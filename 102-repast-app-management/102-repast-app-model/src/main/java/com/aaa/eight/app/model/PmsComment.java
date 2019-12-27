package com.aaa.eight.app.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "pms_comment")
public class PmsComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品id
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 订单为单一商品时，该字段有值
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 会员名称
     */
    @Column(name = "member_nick_name")
    private String memberNickName;

    @Column(name = "product_name")
    private String productName;

    /**
     * 评价星数：0->5
     */
    private Integer star;

    /**
     * 评价的ip
     */
    @Column(name = "member_ip")
    private String memberIp;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 展示状态
     */
    @Column(name = "show_status")
    private Integer showStatus;

    /**
     * 购买时的商品属性
     */
    @Column(name = "product_attribute")
    private String productAttribute;

    @Column(name = "collect_couont")
    private Integer collectCouont;

    /**
     * 阅读次数
     */
    @Column(name = "read_count")
    private Integer readCount;

    /**
     * 上传图片地址，以逗号隔开
     */
    private String pics;

    /**
     * 评论用户头像
     */
    @Column(name = "member_icon")
    private String memberIcon;

    @Column(name = "replay_count")
    private Integer replayCount;

    private String content;

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
     * 获取商品id
     *
     * @return shop_id - 商品id
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置商品id
     *
     * @param shopId 商品id
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取订单ID
     *
     * @return order_id - 订单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID
     *
     * @param orderId 订单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取订单为单一商品时，该字段有值
     *
     * @return product_id - 订单为单一商品时，该字段有值
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置订单为单一商品时，该字段有值
     *
     * @param productId 订单为单一商品时，该字段有值
     */
    public void setProductId(Long productId) {
        this.productId = productId;
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
     * @return product_name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取评价星数：0->5
     *
     * @return star - 评价星数：0->5
     */
    public Integer getStar() {
        return star;
    }

    /**
     * 设置评价星数：0->5
     *
     * @param star 评价星数：0->5
     */
    public void setStar(Integer star) {
        this.star = star;
    }

    /**
     * 获取评价的ip
     *
     * @return member_ip - 评价的ip
     */
    public String getMemberIp() {
        return memberIp;
    }

    /**
     * 设置评价的ip
     *
     * @param memberIp 评价的ip
     */
    public void setMemberIp(String memberIp) {
        this.memberIp = memberIp == null ? null : memberIp.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取展示状态
     *
     * @return show_status - 展示状态
     */
    public Integer getShowStatus() {
        return showStatus;
    }

    /**
     * 设置展示状态
     *
     * @param showStatus 展示状态
     */
    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    /**
     * 获取购买时的商品属性
     *
     * @return product_attribute - 购买时的商品属性
     */
    public String getProductAttribute() {
        return productAttribute;
    }

    /**
     * 设置购买时的商品属性
     *
     * @param productAttribute 购买时的商品属性
     */
    public void setProductAttribute(String productAttribute) {
        this.productAttribute = productAttribute == null ? null : productAttribute.trim();
    }

    /**
     * @return collect_couont
     */
    public Integer getCollectCouont() {
        return collectCouont;
    }

    /**
     * @param collectCouont
     */
    public void setCollectCouont(Integer collectCouont) {
        this.collectCouont = collectCouont;
    }

    /**
     * 获取阅读次数
     *
     * @return read_count - 阅读次数
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * 设置阅读次数
     *
     * @param readCount 阅读次数
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    /**
     * 获取上传图片地址，以逗号隔开
     *
     * @return pics - 上传图片地址，以逗号隔开
     */
    public String getPics() {
        return pics;
    }

    /**
     * 设置上传图片地址，以逗号隔开
     *
     * @param pics 上传图片地址，以逗号隔开
     */
    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    /**
     * 获取评论用户头像
     *
     * @return member_icon - 评论用户头像
     */
    public String getMemberIcon() {
        return memberIcon;
    }

    /**
     * 设置评论用户头像
     *
     * @param memberIcon 评论用户头像
     */
    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon == null ? null : memberIcon.trim();
    }

    /**
     * @return replay_count
     */
    public Integer getReplayCount() {
        return replayCount;
    }

    /**
     * @param replayCount
     */
    public void setReplayCount(Integer replayCount) {
        this.replayCount = replayCount;
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
}