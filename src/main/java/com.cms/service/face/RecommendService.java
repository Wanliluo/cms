package com.cms.service.face;

import com.cms.common.entity.face.Recommend;

import java.util.List;

/**
 * 用户Service
 * user:ouym
 * date: 2014/9/13
 * time: 17:09
 */
public interface RecommendService {
    /**
     * 通过名称查询推荐
     * @param
     * @return
     */
    public Recommend queryById(Integer id) throws Exception;

    /**
     * 查询所有推荐
     * @param
     * @return
     */
    public List<Recommend> queryAll() throws Exception;

    /**
     * 根据类别查询推荐
     * @param
     * @return
     */
    public List<Recommend> queryByCategory(Integer category) throws Exception;

    /**
     * 根据级别查询推荐
     * @param grade
     * @return
     */
    public List<Recommend> queryByGrade(Integer grade) throws Exception;

    /**
     * 根据类别和级别查询推荐
     * @param category
     * @param grade
     * @return
     */
    public List<Recommend> queryByGradeAndCategory(Integer category, Integer grade) throws Exception;

}
