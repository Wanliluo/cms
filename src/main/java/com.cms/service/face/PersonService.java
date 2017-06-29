package com.cms.service.face;



import com.cms.common.entity.face.Person;

import java.util.List;

/**
 * 用户Service
 * user:ouym
 * date: 2014/9/13
 * time: 17:09
 */
public interface PersonService {
    /**
     * 通过id查用户
     * @param id
     * @return
     * @throws Exception
     */
    public Person queryById(Integer id) throws Exception;

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     * @throws Exception
     */
    public Person queryByUserName(String userName) throws Exception;


    /**
     * 添加用户
     * @param person
     * @throws Exception
     */
    public void addPerson(Person person) throws Exception;

    /**
     * 给password加密
     * @param  person
     * @return
     * @throws Exception
     */
    public String encryptPassword(Person person) throws Exception;

    /**
     * 根据用户名修改密码
     * @param userName
     * @param password
     * @param newPassword
     * @throws Exception
     */
    public void updatePassword(String userName, String password, String newPassword) throws Exception;

    /**
     * 根据id修改密码
     * @param id
     * @param password
     * @param newPassword
     * @throws Exception
     */
    public void updatePassword(int id, String password, String newPassword) throws Exception;

    /**
     * 通过id删除用户
     * @param id
     * @throws Exception
     */
    public void delPersonById(Integer id) throws Exception;

    /**
     * 修改用户信息
     * @param person
     * @return
     * @throws Exception
     */
    public void updatePerson(Person person) throws Exception;

    /**
     * 判断用户名是否重复，更新时用
     * @param userName
     * @return
     * @throws Exception
     */
    public Integer isExistUserName(String userName) throws Exception;


}
