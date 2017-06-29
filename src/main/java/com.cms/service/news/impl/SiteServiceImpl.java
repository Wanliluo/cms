package com.cms.service.news.impl;

import com.cms.common.entity.news.Category;
import com.cms.common.entity.news.Site;
import com.cms.mapper.news.CategoryMapper;
import com.cms.mapper.news.SiteMapper;
import com.cms.service.news.CategoryService;
import com.cms.service.news.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * 站点service实现
 * User: wanliLuo
 * Date: 2016-12-18
 * Time: 14:47
 */

@Service("siteService")
public class SiteServiceImpl implements SiteService {
    @Autowired
    SiteMapper siteMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,RuntimeException.class})
    public void add(Site site) throws Exception {
        if (site != null) {
            try {
                siteMapper.addSite(site);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("site实体不能为空");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,RuntimeException.class})
    public void deleteById(String id) throws Exception {
        if(id != null && !(id.equals(""))){
            try {
                siteMapper.deleteById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("Id不能为空");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,RuntimeException.class})
    public void updateById(String id, Site site) throws Exception {
        if(id != null && !(id.equals(""))){
            try {
                siteMapper.updateById(id,site);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("Id不能为空");
        }
    }

    @Override
    public Site queryById(String id) throws Exception {
       Site site = new Site();
        if(id != null && !(id.equals(""))){
            try {
                site= siteMapper.queryById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("Id不能为空");
        }
        return site;
    }
}
