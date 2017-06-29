package com.cms.mapper.face;

import com.cms.common.entity.face.Recommend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 用户Mapper
 * user:
 * date:
 * time:
 */
public interface RecommendMapper {
    /**
     * 通过名称查询推荐
     * @param id
     * @return
     */
    public Recommend queryById(@Param("id") Integer id) throws Exception;


    /**
     * 查询所有推荐
     * @param
     * @return
     */
    public List<Recommend> queryAll() throws Exception;

    /**
     * 根据类别查询推荐
     * @param category
     * @return
     */
    public List<Recommend> queryByCategory(@Param("category") Integer category) throws Exception;

    /**
     * 根据级别查询推荐
     * @param grade
     * @return
     */
    public List<Recommend> queryByGrade(@Param("grade") Integer grade) throws Exception;

    /**
     * 根据类别和级别查询推荐
     * @param category
     * @param grade
     * @return
     */
    public List<Recommend> queryByGradeAndCategory(@Param("category") Integer category, @Param("grade") Integer grade) throws Exception;

}
