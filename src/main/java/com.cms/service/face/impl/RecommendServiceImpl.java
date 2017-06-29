package com.cms.service.face.impl;

import com.cms.common.entity.face.Recommend;
import com.cms.common.enums.face.OaException;
import com.cms.mapper.face.RecommendMapper;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.framework.dao.CommonDao;
import com.cms.service.face.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* UserService实现
* user:zwl
* date:2014/9/13
* time:14:50
*/
@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    CommonDao commonDao;

    @Autowired
    RecommendMapper recommendMapper;

    @Override
    public Recommend queryById(Integer id) throws SSException {
        Recommend recommend = new Recommend();
        if(id != null && !(id.equals(""))) {
            try {
                recommend = recommendMapper.queryById(id);
            } catch (Exception e) {
                LogClerk.errLog.error(e);
                throw SSException.get(OaException.SystemException, e);
            }
        }else {
            System.out.println("name不能为空！！！");
        }
        return recommend;
    }

    @Override
    public List<Recommend> queryAll() throws SSException {
        List<Recommend> recommendList = Collections.emptyList();
            try {
                recommendList = recommendMapper.queryAll();
            } catch (Exception e) {
                LogClerk.errLog.error(e);
                throw SSException.get(OaException.SystemException, e);
            }
        return recommendList;
    }

    @Override
    public List<Recommend> queryByCategory(Integer category) throws SSException {
        List<Recommend> recommendList = Collections.emptyList();
        if(category != null && !(category.equals(""))) {
            try {
                recommendList = recommendMapper.queryByCategory(category);
            } catch (Exception e) {
                LogClerk.errLog.error(e);
                throw SSException.get(OaException.SystemException, e);
            }
        }else {
            System.out.println("category不能为空！！！");
        }
        return recommendList;
    }

    @Override
    public List<Recommend> queryByGrade(Integer grade) throws SSException {
        List<Recommend> recommendList = Collections.emptyList();
        if(grade != null && !(grade.equals(""))) {
            try {
                recommendList = recommendMapper.queryByGrade(grade);
            } catch (Exception e) {
                LogClerk.errLog.error(e);
                throw SSException.get(OaException.SystemException, e);
            }
        }else {
            System.out.println("grade不能为空！！！");
        }
        return recommendList;
    }



    public List<Recommend> queryByGradeAndCategory(Integer category, Integer grade) throws SSException {
        List<Recommend> recommendList = Collections.emptyList();
        if(category != null && !(category.equals("")) && grade != null && !(grade.equals(""))) {
            try {
                recommendList = recommendMapper.queryByGradeAndCategory(category,grade);
            } catch (Exception e) {
                LogClerk.errLog.error(e);
                throw SSException.get(OaException.SystemException, e);
            }
        }else {
            System.out.println("category,grade不能为空！！！");
        }
        return recommendList;
    }

}
