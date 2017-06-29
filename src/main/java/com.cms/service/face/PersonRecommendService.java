package com.cms.service.face;

import com.cms.common.entity.face.PersonRecommend;

import java.util.List;

/**
 * 用户Service
 * user:ouym
 * date: 2014/9/13
 * time: 17:09
 */
public interface PersonRecommendService {
    /**
     * 根据用户Id查找用户推荐信息列表
     * @param personId
     * @return
     * @throws Exception
     */
    public List<PersonRecommend> queryByPersonId(Integer personId) throws Exception;

    /**
     * 根据用户Id查找用户推荐信息列表Id
     * @param personId
     * @return
     * @throws Exception
     */
    public List<Integer> query(Integer personId) throws Exception;

    /**
     * 通过表情测试Id查询属于本次测试的推荐
     * @param faceRectangleId
     * @return
     * @throws Exception
     */
    public List<PersonRecommend> queryByFaceRectangleId(Integer faceRectangleId) throws Exception;

    /**
     * 通过id查询用户推荐信息
     * @param id
     * @return
     * @throws Exception
     */
    public PersonRecommend queryById(Integer id) throws Exception;

    /**
     * 添加用户推荐
     * @param personRecommend
     * @throws Exception
     */
    public void addPersonRecommend(PersonRecommend personRecommend) throws Exception;

    /**
     * 根据id删除推荐信息
     * @param id
     * @throws Exception
     */
    public void delPersonRecommendById(Integer id) throws Exception;

}
