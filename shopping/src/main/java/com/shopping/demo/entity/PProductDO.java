package com.shopping.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Author :tianfeng
 * @Date : 2020/12/1 11:27
 * @Description:
 */
@Entity
@Table(name = "p_product", schema = "public", catalog = "shopping-mall")
public class PProductDO {
    private String productId;
    private String brandId;
    private String brandName;
    private Date createDate;
    private String createUser;
    private String introduction;
    private Date lastModifyDate;
    private String modifyUser;
    private String originPlaceId;
    private String originPlaceName;
    private String productCode;
    private String productName;
    private String productState;
    private String productType;
    private String sellStartDate;
    private String sellStopDate;
    private String validFlag;

    @Id
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "brand_id")
    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "brand_name")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "create_user")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "last_modify_date")
    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    @Basic
    @Column(name = "modify_user")
    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    @Basic
    @Column(name = "origin_place_id")
    public String getOriginPlaceId() {
        return originPlaceId;
    }

    public void setOriginPlaceId(String originPlaceId) {
        this.originPlaceId = originPlaceId;
    }

    @Basic
    @Column(name = "origin_place_name")
    public String getOriginPlaceName() {
        return originPlaceName;
    }

    public void setOriginPlaceName(String originPlaceName) {
        this.originPlaceName = originPlaceName;
    }

    @Basic
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_state")
    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    @Basic
    @Column(name = "product_type")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "sell_start_date")
    public String getSellStartDate() {
        return sellStartDate;
    }

    public void setSellStartDate(String sellStartDate) {
        this.sellStartDate = sellStartDate;
    }

    @Basic
    @Column(name = "sell_stop_date")
    public String getSellStopDate() {
        return sellStopDate;
    }

    public void setSellStopDate(String sellStopDate) {
        this.sellStopDate = sellStopDate;
    }

    @Basic
    @Column(name = "valid_flag")
    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PProductDO that = (PProductDO) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(brandId, that.brandId) &&
                Objects.equals(brandName, that.brandName) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(introduction, that.introduction) &&
                Objects.equals(lastModifyDate, that.lastModifyDate) &&
                Objects.equals(modifyUser, that.modifyUser) &&
                Objects.equals(originPlaceId, that.originPlaceId) &&
                Objects.equals(originPlaceName, that.originPlaceName) &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productState, that.productState) &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(sellStartDate, that.sellStartDate) &&
                Objects.equals(sellStopDate, that.sellStopDate) &&
                Objects.equals(validFlag, that.validFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, brandName, createDate, createUser, introduction, lastModifyDate, modifyUser, originPlaceId, originPlaceName, productCode, productName, productState, productType, sellStartDate, sellStopDate, validFlag);
    }
}
