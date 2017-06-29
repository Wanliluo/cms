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
@Table(name = "t_person_recommend")
public class PersonRecommend extends AbstractEntity {

    //唯一标识
    @Id
    private Integer id;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "face_rectangle_id")
    private Integer faceRectangleId;

    @Column(name = "recommend _id")
    private Integer recommendId;

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

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getFaceRectangleId() {
        return faceRectangleId;
    }

    public void setFaceRectangleId(Integer faceRectangleId) {
        this.faceRectangleId = faceRectangleId;
    }

    public Integer getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Integer recommendId) {
        this.recommendId = recommendId;
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
}
