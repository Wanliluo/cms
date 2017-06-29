package com.cms.common.entity.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * Description:栏目实体
 */

@Entity
@Table(name = "cms_category")
public class Category {

    //编号
    @Column(name = "id")
    private String id;

    //父级编号
    @Column(name = "parent_id")
    private String parentId;

    //所有父级编号
    @Column(name = "parent_ids")
    private String parentIds;

    //站点编号
    @Column(name = "site_id")
    private String siteId;

    //是否为父节点
    @Column(name = "is_parent")
    private Integer isParent;

    //是否为父节点1
    private String isParent1;

    //栏目名称
    @Column(name = "name")
    private String name;

    //描述
    @Column(name = "description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    public String getIsParent1() {

        return isParent1;
    }

    public void setIsParent1(String isParent1) {
        this.isParent1 = isParent1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
