package com.house.hotel.webapi.config;

import com.google.common.base.Optional;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.models.Tag;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.ApiListing;
import springfox.documentation.service.Documentation;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2MapperImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

import static springfox.documentation.builders.BuilderDefaults.nullToEmptyList;

@Component
@Primary
public class Swagger2MapperSortExtend extends ServiceModelToSwagger2MapperImpl {

    private  static final Logger logger = LoggerFactory.getLogger(Swagger2MapperSortExtend.class);

    @Override
    public Swagger mapDocumentation(Documentation from) {
        Swagger swagger = super.mapDocumentation(from);
        swagger.setPaths( mapApiListings( from.getApiListings() ) );
        // 可自定义tag的排序
         List<Tag> tags = swagger.getTags();
        Collections.sort(tags, new Comparator<Tag>() {
             @Override
             public int compare(Tag left, Tag right) {
                 int leftNum = 0;
                 int rightNum = 0;
                 try{
                     leftNum = Integer.parseInt(left.getName().split("、")[0].trim());
                     rightNum = Integer.parseInt(right.getName().split("、")[0].trim());
                 }catch (Exception e){
                     try {
                         leftNum = Integer.parseInt(left.getName().split("-")[0].trim());
                         rightNum = Integer.parseInt(right.getName().split("-")[0].trim());
                     } catch (Exception ex) {
                         leftNum = NumberUtils.toInt(left.getName().split("\\.")[0].trim(),Integer.MAX_VALUE);
                         rightNum = NumberUtils.toInt(right.getName().split("\\.")[0].trim(),Integer.MAX_VALUE);
                     }

                 }
                 int position = Integer.compare(leftNum, rightNum);
                 return position;
             }
         });
         swagger.setTags(tags);
        return swagger;
    }

    @Override
    protected Map<String, Path> mapApiListings(Multimap<String, ApiListing> apiListings) {
        Map<String, Path> paths = new LinkedHashMap<>();
        Multimap<String, ApiListing> apiListingMap = LinkedListMultimap.create();
        Iterator iter = apiListings.entries().iterator();
        while(iter.hasNext())
        {
            Map.Entry<String, ApiListing> entry = (Map.Entry<String, ApiListing>)iter.next();
            ApiListing apis =  entry.getValue();
            List<ApiDescription> apiDesc = apis.getApis();
            List<ApiDescription> newApi = new ArrayList<>();
            for(ApiDescription a:apiDesc){
                newApi.add(a);
            }
            Collections.sort(newApi, new Comparator<ApiDescription>() {
                @Override
                public int compare(ApiDescription left, ApiDescription right) {
                    int leftPos = left.getOperations().size() == 1 ? left.getOperations().get(0).getPosition() : 0;
                    int rightPos = right.getOperations().size() == 1 ? right.getOperations().get(0).getPosition() : 0;

                    int position = Integer.compare(leftPos, rightPos);
                    if(position == 0) {
                        position = left.getPath().compareTo(right.getPath());
                    }

                    return position;
                }
            });
            try {
                //因ApiListing的属性都是final故需要通过反射来修改值
                modify(apis, "apis", newApi);
            } catch (Exception e) {
                e.printStackTrace();
            }
            apiListingMap.put(entry.getKey(),apis);
        }

        for (ApiListing each : apiListingMap.values()) {
            for (ApiDescription api : each.getApis()) {
                paths.put(api.getPath(), mapOperations(api, Optional.fromNullable(paths.get(api.getPath()))));
            }
        }
        return paths;
    }

    private Path mapOperations(ApiDescription api, Optional<Path> existingPath) {
        Path path = existingPath.or(new Path());
        for (springfox.documentation.service.Operation each : nullToEmptyList(api.getOperations())) {
            Operation operation = mapOperation(each);
            path.set(each.getMethod().toString().toLowerCase(), operation);
        }
        return path;
    }

    public void modify(Object object, String fieldName, Object newFieldValue) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true); //Field 的 modifiers 是私有的
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        if(!field.isAccessible()) {
            field.setAccessible(true);
        }

        field.set(object, newFieldValue);
    }

}
