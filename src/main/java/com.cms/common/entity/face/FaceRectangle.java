package com.cms.common.entity.face;


import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Description:面部识别指数实体
 * Author:luowanli
 * Date:2017/3/31
 * Time:20:56
 */

@Entity
@Table(name = "t_face_rectangle")
public class FaceRectangle extends AbstractEntity {
    //唯一标识
    @Id
    private Integer id;

    //用户id
    @Column(name = "person_id")
    private Integer personId;

    //图片地址
    @Column(name = "address")
    private String address;

    //愤怒指数
    @Column(name = "anger")
    private double anger;

    //轻蔑指数
    @Column(name = "contempt")
    private double contempt;

    //厌恶指数
    @Column(name = "disgust")
    private double disgust;

    //恐惧指数
    @Column(name = "fear")
    private double fear;

    //快乐指数
    @Column(name = "happiness")
    private double happiness;

    //中立指数
    @Column(name = "neutral")
    private double neutral;

    //悲伤指数
    @Column(name = "sadness")
    private double sadness;

    //惊讶指数
    @Column(name = "surprise")
    private double surprise;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAnger() {
        return anger;
    }

    public void setAnger(double anger) {
        this.anger = anger;
    }

    public double getContempt() {
        return contempt;
    }

    public void setContempt(double contempt) {
        this.contempt = contempt;
    }

    public double getDisgust() {
        return disgust;
    }

    public void setDisgust(double disgust) {
        this.disgust = disgust;
    }

    public double getFear() {
        return fear;
    }

    public void setFear(double fear) {
        this.fear = fear;
    }

    public double getHappiness() {
        return happiness;
    }

    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }

    public double getNeutral() {
        return neutral;
    }

    public void setNeutral(double neutral) {
        this.neutral = neutral;
    }

    public double getSadness() {
        return sadness;
    }

    public void setSadness(double sadness) {
        this.sadness = sadness;
    }

    public double getSurprise() {
        return surprise;
    }

    public void setSurprise(double surprise) {
        this.surprise = surprise;
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
