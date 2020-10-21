package com.house.hotel.service.user;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.house.hotel.commutil.constant.StatusConstant;
import com.house.hotel.commutil.enums.HotelUserOperationEnum;
import com.house.hotel.commutil.exception.HotelOperationException;
import com.house.hotel.dao.entity.HotelRole;
import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.dao.entity.HotelUserRole;
import com.house.hotel.dao.mapper.HotelRoleMapper;
import com.house.hotel.dao.mapper.HotelUserInfoMapper;
import com.house.hotel.dao.mapper.HotelUserRoleMapper;
import com.house.hotel.dao.model.HotelUserInfoConverterModel;
import com.house.hotel.dto.user.model.HotelRoleModel;
import com.house.hotel.dto.user.model.HotelUserInfoModel;
import com.house.hotel.dto.user.param.UserRegisterParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author muhao.zou
 * @date 2020/9/25 11:41
 */
@Service
public class HotelUserInfoQueryService {
    @Autowired
    private HotelUserInfoMapper hotelUserInfoMapper;
    @Autowired
    private HotelUserRoleMapper hotelUserRoleMapper;
    @Autowired
    private HotelRoleMapper hotelRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public HotelUserInfoConverterModel loadUserByUsername(String userName) {
        HotelUserInfoConverterModel hotelUserInfoModel = new HotelUserInfoConverterModel();
        HotelUserInfo userInfo = hotelUserInfoMapper.selectOne(new HotelUserInfo().setUserAccount(userName));
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        BeanUtils.copyProperties(userInfo, hotelUserInfoModel);

        hotelUserInfoModel.setRoleList(hotelUserInfoMapper.getHrRolesById(hotelUserInfoModel.getUserId()));
        return hotelUserInfoModel;
    }

    /**
     * 获取用户信息列表
     *
     * @return
     */
    public List<HotelUserInfoModel> listHotelUserInfo() {
        List<HotelUserInfo> hotelUserInfoList = hotelUserInfoMapper.selectAll();
        List<HotelUserInfoModel> hotelUserInfoModelList = new ArrayList<>();
        if (null == hotelUserInfoList || hotelUserInfoList.isEmpty()) {
            return hotelUserInfoModelList;
        }
        List<Long> userIds = hotelUserInfoList.stream().map(HotelUserInfo::getUserId).collect(Collectors.toList());
        List<HotelUserRole> hotelUserRoleList = this.listUserRoleByUserIds(userIds);
        List<Integer> roleIds = hotelUserRoleList.stream().map(HotelUserRole::getRoleId).collect(Collectors.toList());
        List<HotelRole> hotelRoleList = this.listHotelRoleByRoleId(roleIds);
        hotelUserInfoList.forEach(v -> {
            HotelUserInfoModel userInfoModel = new HotelUserInfoModel();
            BeanUtils.copyProperties(v, userInfoModel);

            hotelUserRoleList.forEach(v1 -> {
                if (StrUtil.equals(String.valueOf(v.getUserId()), String.valueOf(v1.getUserId()))) {
                    hotelRoleList.forEach(v2 -> {
                        if (StrUtil.equals(String.valueOf(v1.getRoleId()), String.valueOf(v2.getId()))) {
                            userInfoModel.setRoleName(v2.getRoleName());
                        }
                    });
                }
            });
            hotelUserInfoModelList.add(userInfoModel);
        });
        return hotelUserInfoModelList;
    }

    /**
     * 查询角色信息列表
     *
     * @return
     */
    public List<HotelRoleModel> listHotelRole() {
        HotelRole hotelRole = new HotelRole();
        //设置查询条件
        hotelRole.setDisabled(StatusConstant.EFFECTIVE);
        List<HotelRole> hotelRoleList = hotelRoleMapper.select(hotelRole);
        if (CollUtil.isEmpty(hotelRoleList)) {
            return Lists.newArrayList();
        }
        List<HotelRoleModel> hotelRoleModelList = new ArrayList<>(hotelRoleList.size());
        hotelRoleList.forEach(v -> {
            HotelRoleModel hotelRoleModel = new HotelRoleModel();
            BeanUtil.copyProperties(v, hotelRoleModel);
            hotelRoleModelList.add(hotelRoleModel);
        });
        return hotelRoleModelList;
    }

    /**
     * 保存用户信息
     *
     * @param userInfoParam 入参
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int saveUser(UserRegisterParam userInfoParam) {
        HotelUserInfo hotelUserInfo = this.transferHotelUserInfo(userInfoParam);

        int userId = hotelUserInfoMapper.insertUseGeneratedKeys(hotelUserInfo);
        if (userId < 0) {
            throw new HotelOperationException(HotelUserOperationEnum.SAVE_USER_EXCEPTION);
        }
        HotelUserRole hotelUserRole = this.transferHotelUserRole(userInfoParam,hotelUserInfo.getUserId().intValue());
        return hotelUserRoleMapper.insertSelective(hotelUserRole);
    }

    /**
     * 修改用户信息
     * @param userInfoParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int modifyUser(UserRegisterParam userInfoParam) {
        if (userInfoParam.getUserId() < 0 || userInfoParam.getUserId() == null) {
            throw new HotelOperationException(HotelUserOperationEnum.SAVE_USER_PARAM_NOT_EXIST);
        }
        HotelUserInfo hotelUserInfo = this.transferHotelUserInfo(userInfoParam);
        hotelUserInfo.setUserId(userInfoParam.getUserId());

        int count = hotelUserInfoMapper.updateByPrimaryKeySelective(hotelUserInfo);

        if (count < 0) {
            throw new HotelOperationException(HotelUserOperationEnum.SAVE_USER_EXCEPTION);
        }
        HotelUserRole hotelUserRole = this.transferHotelUserRole(userInfoParam,userInfoParam.getUserId().intValue());
        Example example = new Example(HotelUserRole.class);
        example.createCriteria().andEqualTo("userId",userInfoParam.getUserId());
        return hotelUserRoleMapper.updateByExample(hotelUserRole,example);
    }

    /**
     * 根据用户ID获取用户角色信息
     *
     * @param userIds 用户ID
     * @return
     */
    private List<HotelUserRole> listUserRoleByUserIds(List<Long> userIds) {
        Example example = new Example(HotelUserRole.class);
        example.createCriteria().andIn("userId", userIds).andEqualTo("disabled", StatusConstant.EFFECTIVE);
        List<HotelUserRole> hotelUserRoleList = hotelUserRoleMapper.selectByExample(example);
        if (CollUtil.isEmpty(hotelUserRoleList)) {
            return Lists.newArrayList();
        }
        return hotelUserRoleList;
    }

    /**
     * 根据角色ID查询角色信息
     *
     * @param roleIds 角色ID
     * @return
     */
    private List<HotelRole> listHotelRoleByRoleId(List<Integer> roleIds) {
        Example example = new Example(HotelRole.class);
        example.createCriteria().andIn("id", roleIds).andEqualTo("disabled", StatusConstant.EFFECTIVE);
        List<HotelRole> hotelRoleList = hotelRoleMapper.selectByExample(example);
        if (CollUtil.isEmpty(hotelRoleList)) {
            return Lists.newArrayList();
        }
        return hotelRoleList;
    }


    private HotelUserInfo transferHotelUserInfo(UserRegisterParam userInfoParam) {
        HotelUserInfo hotelUserInfo = new HotelUserInfo();
        hotelUserInfo.setUserName(userInfoParam.getUserName());
        hotelUserInfo.setUserAccount(userInfoParam.getUserAccount());
        hotelUserInfo.setPassword(passwordEncoder.encode(userInfoParam.getPassword()));
        hotelUserInfo.setPhone(userInfoParam.getPhone());
        hotelUserInfo.setEmail(userInfoParam.getEmail());
        hotelUserInfo.setRemark(userInfoParam.getRemark());
        hotelUserInfo.setCreateDate(new Date());
        hotelUserInfo.setModifyDate(new Date());
        hotelUserInfo.setDisabled(StatusConstant.EFFECTIVE);
        return hotelUserInfo;
    }

    private HotelUserRole transferHotelUserRole(UserRegisterParam userInfoParam,Integer... userId) {
        HotelUserRole hotelUserRole = new HotelUserRole();
        if(userId.length >0 && userId != null){
            hotelUserRole.setUserId(userId[0]);
        }
        hotelUserRole.setRoleId(userInfoParam.getRoleId());
        hotelUserRole.setCreateDate(new Date());
        hotelUserRole.setModifyDate(new Date());
        hotelUserRole.setDisabled(StatusConstant.EFFECTIVE);
        hotelUserRole.setRemark("");
        return hotelUserRole;
    }

}
