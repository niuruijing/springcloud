package com.hj.oauth.mapper;


import com.hj.oauth.entity.SysAuthority;

public interface SysAuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    SysAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);
}