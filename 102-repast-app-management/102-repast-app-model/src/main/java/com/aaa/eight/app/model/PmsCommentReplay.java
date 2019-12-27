package com.aaa.eight.app.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "pms_comment_replay")
public class PmsCommentReplay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_id")
    private Long commentId;

    /**
     * 会员名称
     */
    @Column(name = "member_nick_name")
    private String memberNickName;

    /**
     * 会员头像
     */
    @Column(name = "member_icon")
    private String memberIcon;

    private String content;

    /**
     * 评论时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 评论人员类型；0->会员；1->管理员
     */
    private Integer type;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return comment_id
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取会员名称
     *
     * @return member_nick_name - 会员名称
     */
    public String getMemberNickName() {
        return memberNickName;
    }

    /**
     * 设置会员名称
     *
     * @param memberNickName 会员名称
     */
    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName == null ? null : memberNickName.trim();
    }

    /**
     * 获取会员头像
     *
     * @return member_icon - 会员头像
     */
    public String getMemberIcon() {
        return memberIcon;
    }

    /**
     * 设置会员头像
     *
     * @param memberIcon 会员头像
     */
    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon == null ? null : memberIcon.trim();
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取评论时间
     *
     * @return create_time - 评论时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置评论时间
     *
     * @param createTime 评论时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取评论人员类型；0->会员；1->管理员
     *
     * @return type - 评论人员类型；0->会员；1->管理员
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置评论人员类型；0->会员；1->管理员
     *
     * @param type 评论人员类型；0->会员；1->管理员
     */
    public void setType(Integer type) {
        this.type = type;
    }
}