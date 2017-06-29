package com.cms.mapper.news;

import com.cms.common.entity.news.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:栏目mapper
 */
public interface CategoryMapper {
    /**
     * 添加栏目
     * @param id
     * @param parentId
     * @param parentIds
     * @param siteId
     * @param isParent
     * @param name
     * @param description
     * @throws Exception
     */
    public void add(@Param("id") String id, @Param("parentId") String parentId, @Param("parentIds") String parentIds,
                    @Param("sieId") String siteId, @Param("isParent") Integer isParent, @Param("name") String name,
                    @Param("description") String description)throws Exception;

    /**
     * 根据id删除栏目
     * @param id
     * @throws Exception
     */
    public void deleteById(@Param("id") String id) throws Exception;

    /**
     * 根据id修改栏目
     * @param id
     * @throws Exception
     */
    public void updateById(@Param("id") String id, @Param("parentId") String parentId, @Param("parentIds") String parentIds,
                           @Param("sieId") String siteId, @Param("isParent") Integer isParent, @Param("name") String name,
                           @Param("description") String description) throws Exception;

    /**
     * 通过id查看详情
     * @param id
     * @return
     * @throws Exception
     */
    public Category queryById(@Param("id") String id) throws Exception;

    /**
     * 通过name查看详情
     * @param name
     * @return
     * @throws Exception
     */
    public Category queryByName(@Param("name") String name) throws Exception;

    /**
     * 通过是否为父节点来查询栏目
     * @param isParent
     * @return
     * @throws Exception
     */
    public List<Category> queryByIsParent(@Param("isParent") Integer isParent) throws Exception;

    /**
     * 通过多条件查询子栏目列表
     * @param parentId
     * @return
     * @throws Exception
     */
    public List<Category> getListByCondition(@Param("id") String id, @Param("parentId") String parentId, @Param("parentIds") String parentIds,
                                            @Param("siteId") String siteId, @Param("isParent") Integer isParent, @Param("name") String name,
                                            @Param("description") String description) throws Exception;


}
