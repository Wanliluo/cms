package com.cms.service.news;

import com.cms.common.entity.news.Category;
import com.cms.common.entity.news.Site;

import java.util.List;

/**
 * 站点service层
 */
public interface SiteService {
    /**
     * 添加站点
     * @param site
     * @throws Exception
     */
    public void add(Site site) throws Exception;

    /**
     * 根据id删除站点
     * @param id
     * @throws Exception
     */
    public void deleteById(String id) throws Exception;

    /**
     * 根据id修改站点
     * @param id
     * @throws Exception
     */
    public void updateById(String id, Site site) throws Exception;

    /**
     * 通过id查看站点详情
     * @param id
     * @return
     * @throws Exception
     */
    public Site queryById(String id) throws Exception;

}
