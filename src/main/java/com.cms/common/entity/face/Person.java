package com.cms.common.entity.face;


import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Description:个人信息实体
 * Author:luowanli
 * Date:2017/3/31
 * Time:20:57
 */

@Entity
@Table(name = "t_person")
public class Person  extends AbstractEntity {
    //唯一标识
    @Id
    private Integer id;

    //用户名
    @Column(name = "user_name")
    private String userName;

    //初始密码
    @Column(name = "password")
    private String password;

    //盐值
    @Column(name = "salt")
    private String salt;

    //生日
    @Column(name = "birthday")
    private String birthday;

    //性别
    @Column(name = "sex")
    private String sex;

    //职业（区分医生和患者）
    @Column(name = "job")
    private String job;

    //职业描述
    @Column(name = "job_describe")
    private String jobDescribe;

    //图像
    @Column(name = "photo")
    private String photo;

    //微信
    @Column(name = "wechat")
    private String wechat;

    //QQ
    @Column(name = "qq")
    private String qq;

    //电话
    @Column(name = "phone")
    private String phone;

    //单位
    @Column(name = "company")
    private String company;

    //家庭住址或单位地址
    @Column(name = "address")
    private String address;

    //是否删除：1是0否
    @Column(name = "is_del")
    private Integer isDel;

    //创建时间
    @Column(name = "created_time")
    private Date createdTime;

    //最后修改时间
    @Column(name = "last_modified_time")
    private Date lastModifiedTime;

    public Person() {}

    public Person(int userId, String userName,String newPassword) {
        this.id = userId;
        this.userName = userName;
        this.password = newPassword;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobDescribe() {
        return jobDescribe;
    }

    public void setJobDescribe(String jobDescribe) {
        this.jobDescribe = jobDescribe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String retCredentialsSalt(){
        return userName + salt;
    }
}
