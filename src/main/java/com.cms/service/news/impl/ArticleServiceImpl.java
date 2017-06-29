package com.cms.service.news.impl;

import com.cms.common.entity.news.Article;
import com.cms.common.entity.news.Category;
import com.cms.common.util.Pagination;
import com.cms.mapper.news.ArticleMapper;
import com.cms.service.news.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * 文章service实现
 * User: wanliLuo
 * Date: 2016-12-18
 * Time: 14:47
 */

@Service("articleService")
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Article getArticleById(String id) throws Exception {
       Article article = new Article();
            if(id != null && !(id.equals(""))){
                try {
                    article = articleMapper.queryArticleById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.print("Id不能为空");
            }
        return article;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,RuntimeException.class})
    public void addArticle(Article article) throws Exception {
        if(article != null){
            try {
                if(article.getId()==null||"".equals(article.getId())) {
                    article.setId(UUID.randomUUID().toString());
                    articleMapper.addArticle(article.getId(), article.getCategoryId(), article.getTitle(),
                            article.getContent(), article.getAuthor());
                }else{
                    articleMapper.updateArticleById(article.getId(), article.getCategoryId(), article.getTitle(),
                            article.getContent(), article.getAuthor());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("article实体不能为空");
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,RuntimeException.class})
    public void delArticleById(String id) throws Exception {
        if(id != null && !(id.equals(""))){
            try {
                articleMapper.delArticleById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("Id不能为空");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,RuntimeException.class})
    public void updateArticleById(Article article) throws Exception {
        if(article.getId() != null && !(article.getId().equals(""))){
            try {
                articleMapper.updateArticleById(article.getId(), article.getCategoryId(), article.getTitle(),
                        article.getContent(), article.getAuthor());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("Id不能为空");
        }
    }

    @Override
    public int getCount(Article article) throws Exception {
        int count = 0;
        if(article != null){
            try {
                count = articleMapper.getCount(article.getCategoryId(), article.getTitle(), article.getContent(), article.getAuthor());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("article不能为空");
        }
        return count;
    }

    @Override
    public List<Article> getArticleList(Article article, Pagination page) throws Exception {
        int pCurrent = 0, pSize = 10;
        List<Article> articleList = Collections.emptyList();
        if(article != null && page !=null){
            pCurrent = page.getCurrentFristPosition();
            pSize = page.getPageSize();
            try {
               articleList = articleMapper.getArticleList(article.getCategoryId(), article.getTitle(), article.getContent(), article.getAuthor(), pCurrent, pSize);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("article实体不能为空");
        }
        return articleList;
    }
}
