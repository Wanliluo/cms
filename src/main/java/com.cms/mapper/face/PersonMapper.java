package com.cms.mapper.face;

import com.cms.common.entity.face.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 用户Mapper
 * user:
 * date:
 * time:
 */
public interface PersonMapper {
    /**
     * 通过id查用户
     * @param id
     * @return
     * @throws Exception
     */
    public Person queryById(@Param("id") Integer id) throws Exception;

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     * @throws Exception
     */
    public Person queryByUserName(@Param("userName") String userName) throws Exception;

    /**
     * 通过id删除用户
     * @param id
     * @throws Exception
     */
    public void delPersonById(@Param("id") Integer id) throws Exception;

    /**
     * 判断用户名是否重复，更新时用
     * @param userName
     * @return
     * @throws Exception
     */
    public int isExistUsername(@Param("userName") String userName) throws Exception;




}
