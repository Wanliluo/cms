package com.cms.common.entity.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:评论实体
 */

@Entity
@Table(name = "cms_comment")
public class Comment {

    //编号
    @Column(name = "id")
    private String Id;

    //栏目编号
    @Column(name = "category_id")
    private String categpryId;

    //栏目内容编号
    @Column(name = "content_id")
    private String contentId;

    //栏目内容的标题
    @Column(name = "title")
    private String title;

    //评论姓名
    @Column(name = "name")
    private String name;

    //评论内容
    @Column(name = "content")
    private String content;

    //评论Ip
    @Column(name = "ip")
    private String ip;

    //评论时间
    @Column(name = "create_date")
    private Date createDate;

    //评论时间1
    private String createDate1;

    //审核人
    @Column(name = "audit_user_id")
    private String auditUserId;

    //审核时间
    @Column(name = "audit_date")
    private Date auditDate;

    //审核时间1
    private String auditDate1;

    //是否删除（1是0否）
    @Column(name = "del_flag")
    private String delFlag;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCategpryId() {
        return categpryId;
    }

    public void setCategpryId(String categpryId) {
        this.categpryId = categpryId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateDate1() {
        return createDate1;
    }

    public void setCreateDate1(String createDate1) {
        this.createDate1 = createDate1;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditDate1() {
        return auditDate1;
    }

    public void setAuditDate1(String auditDate1) {
        this.auditDate1 = auditDate1;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
