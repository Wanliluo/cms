package com.cms.service.news;

import com.cms.common.entity.news.Article;
import com.cms.common.util.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章service层
 */
public interface ArticleService {
    /**
     * 根据id查询Article
     * @param id
     * @return
     * @throws Exception
     */
    public Article getArticleById(String id) throws Exception;

    /**
     * 添加文章
     * @param article
     * @throws Exception
     */
    public void addArticle(Article article) throws Exception;

    /**
     * 根据id删除文章
     * @param id
     * @throws Exception
     */
    public void delArticleById(String id) throws Exception;

    /**
     * 根据id修改文章
     * @param article
     * @param article
     * @throws Exception
     */
    public void updateArticleById(@Param("article") Article article) throws Exception;

    /**
     * 多条件查询文章总数
     * @param article
     * @return
     * @throws Exception
     */
    public int getCount(Article article) throws Exception;

    /**
     * 多条件查询文章列表
     * @param article
     * @return
     * @throws Exception
     */
    public List<Article> getArticleList(Article article, Pagination page) throws Exception;
}
