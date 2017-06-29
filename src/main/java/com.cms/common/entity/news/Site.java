package com.cms.common.entity.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * Description:站点实体
 */

@Entity
@Table(name = "cms_site")
public class Site {

    //编号
    @Column(name = "id")
    private String id;

    //站点名称
    @Column(name = "name")
    private String name;

    //站点标题
    @Column(name = "title")
    private String title;

    //站点描述
    @Column(name = "description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
