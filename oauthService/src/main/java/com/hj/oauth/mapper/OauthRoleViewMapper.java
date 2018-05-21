package com.hj.oauth.mapper;

import com.hj.oauth.entity.OauthRoleView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OauthRoleViewMapper {
    int insert(OauthRoleView record);

    int insertSelective(OauthRoleView record);

    List<OauthRoleView> getListOauthByUsername(@Param("username") String username);
}