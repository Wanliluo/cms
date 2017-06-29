package com.cms.service.face.impl;

import com.cms.common.entity.face.PersonRecommend;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.framework.dao.CommonDao;
import com.cms.mapper.face.PersonRecommendMapper;
import com.cms.service.face.PersonRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
* UserService实现
* user:zwl
* date:2014/9/13
* time:14:50
*/
@Service("personRecommendService")
public class PersonRecommendServiceImpl implements PersonRecommendService {

    @Autowired
    CommonDao commonDao;

    @Autowired
    PersonRecommendMapper personRecommendMapper;

    @Override
    public List<PersonRecommend> queryByPersonId(Integer personId) throws SSException {
        List<PersonRecommend> personRecommendList = Collections.emptyList();
        if(personId != null && !(personId.equals(""))) {
            try {
                personRecommendList = personRecommendMapper.queryByPersonId(personId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("personId不能为空！！！");
        }
        return personRecommendList;
    }

    @Override
    public List<Integer> query(Integer personId) throws Exception {
        List list = Collections.emptyList();
        if(personId != null && !(personId.equals(""))) {
            try {
                list = personRecommendMapper.query(personId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("personId不能为空！！！");
        }
        return list;
    }

    @Override
    public List<PersonRecommend> queryByFaceRectangleId(Integer faceRectangleId) throws SSException {
        List<PersonRecommend> personRecommendList = Collections.emptyList();
        if(faceRectangleId != null && !(faceRectangleId.equals(""))) {
            try {
                personRecommendList = personRecommendMapper.queryByPersonId(faceRectangleId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("faceRectangleId不能为空！！！");
        }
        return personRecommendList;
    }

    @Override
    public PersonRecommend queryById(Integer id) throws SSException {
        PersonRecommend personRecommend = new PersonRecommend();
        if(id != null && !(id.equals(""))) {
            try {
                personRecommend = personRecommendMapper.queryById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Id不能为空！！！");
        }
        return personRecommend;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SSException.class, Exception.class, RuntimeException.class })
    public void addPersonRecommend(PersonRecommend personRecommend) throws SSException {
        if(personRecommend!=null){
            try {
                commonDao.insert(personRecommend);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("personRecommend不能为空！！！");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SSException.class, Exception.class, RuntimeException.class })
    public void delPersonRecommendById(Integer id) throws SSException {
        if(id != null && !(id.equals(""))) {
            try {
                personRecommendMapper.delPersonRecommendById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Id不能为空！！！");
        }
    }

}
