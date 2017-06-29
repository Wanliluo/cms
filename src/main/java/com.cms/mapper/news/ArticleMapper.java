package com.cms.mapper.news;

import com.cms.common.entity.news.Article;
import com.cms.common.util.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章Mapper层
 * Date: 2016-12-18
 * Time: 14:47
 */
public interface ArticleMapper {

    /**
     * 根据Id查询文章详情
     * @param id
     * @return
     * @throws Exception
     */
    public Article queryArticleById(@Param("id")String id) throws Exception;

    /**
     * 添加文章
     * @param id
     * @param categoryId
     * @param title
     * @param content
     * @param author
     * @throws Exception
     */
    public void addArticle(@Param("id")String id, @Param("categoryId")String categoryId, @Param("title")String title,
                           @Param("content")String content, @Param("author")String author) throws Exception;

    /**
     * 根据id删除文章
     * @param id
     * @throws Exception
     */
    public void delArticleById(@Param("id") String id) throws Exception;

    /**
     * 根据id修改文章
     * @param id
     * @param categoryId
     * @param title
     * @param content
     * @param author
     * @throws Exception
     */
    public void updateArticleById(@Param("id")String id, @Param("categoryId")String categoryId, @Param("title")String title,
                                  @Param("content")String content, @Param("author")String author) throws Exception;

    /**
     * 多条件查询文章总数
     * @param categoryId
     * @param title
     * @param content
     * @param author
     * @return
     * @throws Exception
     */
    public int getCount(@Param("categoryId")String categoryId, @Param("title")String title,
                        @Param("content")String content, @Param("author")String author) throws Exception;

    /**
     * 多条件查询文章列表
     * @param categoryId
     * @param title
     * @param content
     * @param author
     * @return
     * @throws Exception
     */
    public List<Article> getArticleList(@Param("categoryId")String categoryId, @Param("title")String title,
                                        @Param("content")String content, @Param("author")String author,
                                        @Param("pCurrent") int pCurrent, @Param("pSize") int pSize) throws Exception;
}
