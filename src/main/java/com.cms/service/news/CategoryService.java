package com.cms.service.news;

import com.cms.common.entity.news.Category;
import java.util.List;

/**
 * 栏目service层
 */
public interface CategoryService {
    /**
     * 添加栏目
     * @param category
     * @throws Exception
     */
    public void add(Category category) throws Exception;

    /**
     * 根据id删除栏目
     * @param id
     * @throws Exception
     */
    public void deleteById(String id) throws Exception;

    /**
     * 根据id修改栏目
     * @param category
     * @throws Exception
     */
    public void updateById(Category category) throws Exception;

    /**
     * 通过id查看详情
     * @param id
     * @return
     * @throws Exception
     */
    public Category queryById(String id) throws Exception;

    /**
     * 通过name查看详情
     * @param name
     * @return
     * @throws Exception
     */
    public Category queryByName(String name) throws Exception;

    /**
     * 通过是否为父节点来查询栏目
     * @param isParent
     * @return
     * @throws Exception
     */
    public List<Category> queryByIsParent(Integer isParent) throws Exception;

    /**
     * 通过父级id查询子栏目列表
     * @param category
     * @return
     * @throws Exception
     */
    public List<Category> getListByCondition(Category category) throws Exception;
}
