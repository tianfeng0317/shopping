package com.shopping.demo.result;

import java.io.Serializable;

/**
 * @Author :tianfeng
 * @Date : 2020/11/24 15:05
 * @Description:
 */
public class ResultData<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "1";
    private static final String DENY = "0";
    private static final String ERROR = "-1";

    private String returnState;
    private String errorCode;
    private String errorMessage;
    private T data;

    public ResultData() {
        super();
    }

    /**
     *
     * @Title: success
     * @Description: 返回调用成功数据
     * @param data
     * @return
     * @return ResultData
     */
    @SuppressWarnings("unchecked")
    public static <T> ResultData<T> success(T data) {
        return new ResultData(SUCCESS, "", "success", data);
    }

    /**
     *
     * @Title: success
     * @Description: 调用异常,如连接超时,数据库异常等非业务异常
     * @param errorCode
     * @param errorMessage
     * @return
     * @return ResultData
     */
    @SuppressWarnings("unchecked")
    public static <T> ResultData<T> error(String errorCode, String errorMessage) {
        return new ResultData(ERROR, errorCode, errorMessage, null);
    }

    /**
     *
     * @Title: success
     * @Description: 调用异常,如连接超时,数据库异常等非业务异常
     * @param errorMessage
     * @return
     * @return ResultData
     */
    @SuppressWarnings("unchecked")
    public static <T> ResultData<T> error(String errorMessage) {
        return new ResultData(ERROR, "", errorMessage, null);
    }

    /**
     *
     * @Title: deny
     * @Description: 调用正常,但是业务异常
     * @param errorCode
     * @param errorMessage
     * @return
     * @return ResultData
     */
    @SuppressWarnings("unchecked")
    public static <T> ResultData<T> deny(String errorCode, String errorMessage) {
        return new ResultData(DENY, errorCode, errorMessage, null);
    }

    /**
     * @Title: deny
     * @Description: 调用正常,但是业务异常
     * @param errorMessage
     * @param errorMessage
     * @return
     * @return ResultData
     */
    @SuppressWarnings("unchecked")
    public static <T> ResultData<T> deny(String errorMessage) {
        return new ResultData(DENY, "", errorMessage, null);
    }

    public ResultData(String returnState, String errorCode, String errorMessage) {
        super();
        this.returnState = returnState;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ResultData(String returnState, String errorCode, String errorMessage, T data) {
        this.returnState = returnState;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public String getReturnState() {
        return returnState;
    }

    public void setReturnState(String returnState) {
        this.returnState = returnState;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toResult() {
        return "ResultData{" +
                "returnState='" + returnState + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
