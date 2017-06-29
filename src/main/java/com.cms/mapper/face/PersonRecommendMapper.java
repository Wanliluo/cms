package com.cms.mapper.face;

import com.cms.common.entity.face.PersonRecommend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 用户Mapper
 * user:
 * date:
 * time:
 */
public interface PersonRecommendMapper {

    /**
     * 根据用户Id查找用户推荐信息列表
     * @param personId
     * @return
     * @throws Exception
     */
    public List<PersonRecommend> queryByPersonId(@Param("personId") Integer personId) throws Exception;

    /**
     * 根据用户Id查找用户推荐信息id列表
     * @param personId
     * @return
     * @throws Exception
     */
    public List<Integer> query(@Param("personId") Integer personId) throws Exception;

    /**
     * 通过表情测试Id查询属于本次测试的推荐
     * @param faceRectangleId
     * @return
     * @throws Exception
     */
    public List<PersonRecommend> queryByFaceRectangleId(@Param("faceRectangleId") Integer faceRectangleId) throws Exception;

    /**
     * 通过id查询用户推荐信息
     * @param id
     * @return
     * @throws Exception
     */
    public PersonRecommend queryById(@Param("id") Integer id) throws Exception;

    /**
     * 根据id删除推荐信息
     * @param id
     * @throws Exception
     */
    public void delPersonRecommendById(@Param("id") Integer id) throws Exception;

}
