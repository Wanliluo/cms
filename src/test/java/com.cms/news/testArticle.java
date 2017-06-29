package com.cms.news;

import com.cms.AbstractTestCase;
import com.cms.common.entity.news.Article;
import com.cms.common.util.Pagination;
import com.cms.service.news.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

import static com.cms.web.controller.common.AbstractController.pageSize;

/**
 * 文章service测试
 * User: wanliLuo
 * Date: 2016-12-18
 * Time: 14:47
 */
public class testArticle extends AbstractTestCase {
    @Autowired
    private ArticleService articleService;

    @Test
    public void testGetArticleById(){
        try {
            Article article = articleService.getArticleById("1");
            System.out.println(article.getCategoryId());
            System.out.println("有问题！！！！！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testAdd(){
        try {
            Article article = new Article();
            article.setAuthor("管理员");
            article.setCategoryId("4");
            article.setClicks(2);
            article.setContent("asdfgdhha");
            article.setId("6");
            article.setTitle("aaa");
            article.setWeight(5);
            articleService.addArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        try {
            Article article = new Article();
            article.setAuthor("张三");
            article.setCategoryId("4");
            article.setClicks(2);
            article.setContent("asdfgdhha");
            article.setId("3");
            article.setTitle("aaa");
            article.setWeight(4);
            articleService.updateArticleById(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCount(){
        try {
            Article article = new Article();
            article.setCategoryId("5");
            article.setTitle("null");
            int a=articleService.getCount(article);
            System.out.println("总人数是："+a);
            Pagination page1 = new Pagination(a,pageSize,2);
            List<Article> list = articleService.getArticleList(article, page1);

            for(Article article1 :list){
                System.out.println("实体是"+article1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
