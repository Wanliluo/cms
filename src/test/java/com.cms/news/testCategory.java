package com.cms.news;

import com.cms.AbstractTestCase;
import com.cms.common.entity.news.Article;
import com.cms.common.entity.news.Category;
import com.cms.service.news.ArticleService;
import com.cms.service.news.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * 文章service测试
 * User: wanliLuo
 * Date: 2016-12-18
 * Time: 14:47
 */
public class testCategory extends AbstractTestCase {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void testDeleteById(){
        try {
           categoryService.deleteById("2");
            System.out.println("删除成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetListByParentId(){
        try {

            List<Category> lists = categoryService.queryByIsParent(0);
            for(Category category : lists){
                System.out.println("实体是："+category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
