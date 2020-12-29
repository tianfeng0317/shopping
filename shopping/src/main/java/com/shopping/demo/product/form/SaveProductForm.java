package com.shopping.demo.product.form;

import java.sql.Timestamp;

/**
 * @Author :tianfeng
 * @Date : 2020/12/1 11:15
 * @Description:
 */
public class SaveProductForm {

    private String productCode;
    private String productType;
    private String productName;
    private String brandId;
    private String brandName;
    private String introduction;
    private String originPlaceId;
    private String originPlaceName;
    private String productState;
    private String validFlag;
    private String sellStartDate;
    private String sellStopDate;
    private String createUser;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOriginPlaceId() {
        return originPlaceId;
    }

    public void setOriginPlaceId(String originPlaceId) {
        this.originPlaceId = originPlaceId;
    }

    public String getOriginPlaceName() {
        return originPlaceName;
    }

    public void setOriginPlaceName(String originPlaceName) {
        this.originPlaceName = originPlaceName;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getSellStartDate() {
        return sellStartDate;
    }

    public void setSellStartDate(String sellStartDate) {
        this.sellStartDate = sellStartDate;
    }

    public String getSellStopDate() {
        return sellStopDate;
    }

    public void setSellStopDate(String sellStopDate) {
        this.sellStopDate = sellStopDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
