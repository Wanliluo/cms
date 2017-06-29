package com.cms.service.face.impl;

import com.cms.common.entity.face.Person;
import com.cms.common.enums.face.OaException;
import com.cms.common.util.PasswordHelper;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.framework.dao.CommonDao;
import com.cms.mapper.face.PersonMapper;
import com.cms.service.face.PersonService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* UserService实现
* user:zwl
* date:2014/9/13
* time:14:50
*/
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    CommonDao commonDao;

    @Autowired
    PersonMapper personMapper;

    @Override
    public Person queryById(Integer id) throws SSException {
        Person person = new Person();
        if(id != null && !(id.equals(""))) {
            try {
                person = personMapper.queryById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Id不能为空！！！");
        }
        return person;
    }

    @Override
    public Person queryByUserName(String userName) throws SSException {
        Person person = new Person();
        if(userName != null && !(userName.equals(""))) {
            try {
                person = personMapper.queryByUserName(userName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("userName不能为空！！！");
        }
        return person;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SSException.class, Exception.class, RuntimeException.class })
    public void addPerson(Person person) throws SSException {
//        if(person!=null){
            try {
                commonDao.insert(person);
            } catch (Exception e) {
                e.printStackTrace();
            }
//        }else {
//            System.out.println("person不能为空！！！");
//        }
    }

    @Override
    public String encryptPassword(Person person) throws SSException {
        RandomNumberGenerator randomNumberGenerator =
                new SecureRandomNumberGenerator();
        String algorithmName = "md5";
        int hashIterations = 2;
        person.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                person.getPassword(),
                ByteSource.Util.bytes(person.retCredentialsSalt()),
                hashIterations).toHex();
        return newPassword;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SSException.class, Exception.class, RuntimeException.class })
    public void updatePassword(String userName,String oldPassword,String newPassword) throws SSException {
        PasswordHelper passwordHelper = new PasswordHelper();
        Person oldPerson = null;
        try {
            oldPerson = personMapper.queryByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /** 开始判断原密码是否正确 **/
        String algorithmName = "md5";
        int hashIterations = 2;
        String password = new SimpleHash(
                algorithmName,
                oldPassword,
                ByteSource.Util.bytes(oldPerson.getUserName() + oldPerson.getSalt()),
                hashIterations).toString();
        if(!password.equals(oldPerson.getPassword())){
            throw SSException.get(OaException.PwdWrong);
        }
        /** 判断原密码是否正确结束 **/

        //将新密码更新到数据库中
        Person person = new Person(oldPerson.getId(),oldPerson.getUserName(),newPassword);
        passwordHelper.encryptPassword(person);
        try {
            commonDao.update(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SSException.class, Exception.class, RuntimeException.class })
    public void updatePassword(int id, String oldPassword, String newPassword) throws SSException {
        PasswordHelper passwordHelper = new PasswordHelper();
        Person oldPerson = null;
        try {
            oldPerson = personMapper.queryById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /** 开始判断原密码是否正确 **/
        String algorithmName = "md5";
        int hashIterations = 2;
        String password = new SimpleHash(
                algorithmName,
                oldPassword,
                ByteSource.Util.bytes(oldPerson.getUserName() + oldPerson.getSalt()),
                hashIterations).toString();
        if(!password.equals(oldPerson.getPassword())){
            throw SSException.get(OaException.PwdWrong);
        }
        /** 判断原密码是否正确结束 **/

        //将新密码更新到数据库中
        Person person = new Person(oldPerson.getId(),oldPerson.getUserName(),newPassword);
        passwordHelper.encryptPassword(person);
        try {
            commonDao.update(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SSException.class, Exception.class, RuntimeException.class })
    public void delPersonById(Integer id) throws SSException {
        if(id != null && !(id.equals(""))) {
            try {
                personMapper.delPersonById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Id不能为空！！！");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SSException.class, Exception.class, RuntimeException.class })
    public void updatePerson(Person person) throws SSException {
        if(person!=null){
            try {
                commonDao.update(person);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("person不能为空！！！");
        }
    }

    @Override
    public Integer isExistUserName(String userName) throws SSException {
        if (userName == null || userName.equals("")) return 1;
        try {
            if(personMapper.isExistUsername(userName) > 0) {
            return 1;}
            else{
                return 0;
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(OaException.SystemException, e);
        }
    }

}
