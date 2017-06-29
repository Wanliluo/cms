package com.cms.common.entity.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:文章实体
 */

@Entity
@Table(name = "cms_article")
public class Article {
    //编号
    @Column(name = "id")
    private String id;

    //栏目编号
    @Column(name = "category_id")
    private String categoryId;

    //标题
    @Column(name = "title")
    private String title;

    //内容
    @Column(name = "content")
    private String content;

    //权重
    @Column(name = "weight")
    private Integer weight;

    //点击数
    @Column(name = "clicks")
    private Integer clicks;

    //发布者
    @Column(name = "author")
    private String author;

    //创建时间
    @Column(name = "created_time")
    private Date createdTime;

    //最后修改时间
    @Column(name = "last_modified_time")
    private Date lastModifiedTime;

    //最后修改时间1
    private String lastModifiedTime1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getLastModifiedTime1() {
        return lastModifiedTime1;
    }

    public void setLastModifiedTime1(String lastModifiedTime1) {
        this.lastModifiedTime1 = lastModifiedTime1;
    }
}

