package com.cms.mapper.news;

import com.cms.common.entity.news.Category;
import com.cms.common.entity.news.Site;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:站点mapper
 */
public interface SiteMapper {
    /**
     * 添加站点
     * @param site
     * @throws Exception
     */
    public void addSite(@Param("site") Site site) throws Exception;

    /**
     * 根据id删除站点
     * @param id
     * @throws Exception
     */
    public void deleteById(@Param("id") String id) throws Exception;

    /**
     * 根据id修改站点
     * @param id
     * @throws Exception
     */
    public void updateById(@Param("id") String id, @Param("site") Site site) throws Exception;

    /**
     * 通过id查看站点详情
     * @param id
     * @return
     * @throws Exception
     */
    public Site queryById(@Param("id") String id) throws Exception;

}
