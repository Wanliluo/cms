package com.cms.common.entity.face;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wanliLuo
 * Date: 2017-04-01
 * Time: 19:43
 */
@Entity
@Table(name = "t_recomend")
public class Recommend  extends AbstractEntity {
    //唯一标识
    @Id
    private Integer id;

    //推荐名
    @Column(name = "name")
    private String name;

    //推荐类别代码 （1视频，2音乐，3书籍，4运动，5照片）
    @Column(name = "category")
    private  Integer category;

    //推荐类别
    private String category1;

    //级别
    @Column(name = "grade")
    private Integer grade;

    //推荐链接地址
    @Column(name = "address")
    private String address;

    //描述
    @Column(name = "description")
    private String description;

    //是否删除：1是0否
    @Column(name = "is_del")
    private Integer isDel;

    //创建时间
    @Column(name = "created_time")
    private Date createdTime;

    //最后修改时间
    @Column(name = "last_modified_time")
    private Date lastModifiedTime;

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
