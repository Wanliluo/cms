package com.cms.service.news.impl;

import com.cms.common.entity.news.Category;
import com.cms.mapper.news.CategoryMapper;
import com.cms.service.news.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * 栏目service实现
 * User: wanliLuo
 * Date: 2016-12-18
 * Time: 14:47
 */

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,RuntimeException.class})
    public void add(Category category) throws Exception {
        if (category != null) {
            try {
                if(category.getId()==null||"".equals(category.getId())) {
                    category.setId(UUID.randomUUID().toString());
                categoryMapper.add(category.getId(), category.getParentId(), category.getParentIds(),
                                   category.getSiteId(), category.hashCode(), category.getName(),
                                   category.getDescription());
                }else{
                    categoryMapper.updateById(category.getId(), category.getParentId(), category.getParentIds(),
                            category.getSiteId(), category.hashCode(), category.getName(),
                            category.getDescription());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("categpry实体不能为空");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,RuntimeException.class})
    public void deleteById(String id) throws Exception {
        if(id != null && !(id.equals(""))){
            try {
                categoryMapper.deleteById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("Id不能为空");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,RuntimeException.class})
    public void updateById(Category category) throws Exception {
        if(category.getId() != null && !(category.getId().equals(""))){
            try {
                categoryMapper.updateById(category.getId(), category.getParentId(), category.getParentIds(),
                        category.getSiteId(), category.hashCode(), category.getName(),
                        category.getDescription());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("Id不能为空");
        }
    }

    @Override
    public Category queryById(String id) throws Exception {
        Category category =new Category();
        if(id != null && !(id.equals(""))){
            try {
                category= categoryMapper.queryById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("Id不能为空");
        }
        return category;
    }

    @Override
    public Category queryByName(String name) throws Exception {
        Category category =new Category();
        if(name != null && !(name.equals(""))){
            try {
                category= categoryMapper.queryById(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("name不能为空");
        }
        return category;
    }

    @Override
    public List<Category> queryByIsParent(Integer isParent) throws Exception {
        List<Category> categoryList = Collections.emptyList();
        if(isParent != null){
            try {
                categoryList = categoryMapper.queryByIsParent(isParent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("isParent不能为空");
        }
        return categoryList;
    }

    @Override
    public List<Category> getListByCondition(Category category) throws Exception {
        List<Category> categoryList = Collections.emptyList();
        if(category != null){
            try {
                categoryList = categoryMapper.getListByCondition(category.getId(), category.getParentId(), category.getParentIds(), category.getSiteId(), category.getIsParent(), category.getName(), category.getDescription());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("category实体不能为空");
        }
        return categoryList;
    }
}
