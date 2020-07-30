package com.huweilong.group.service.dto.basics.global;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用接口返回对象
 * @param <T> 对象类型
 * @author Alex
 */
@Data
@ApiModel(value = "通用接口返回对象")
public class Results<T> implements Serializable {

    /**
     * 结果码
     */
    @ApiModelProperty(value = "结果码", required = true, example = "200")
    private Integer state;

    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳", required = true, example = "1567425139000")
    private Long time;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息", required = true, example = "SUCCESS")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据", required = true, example = "{}")
    private T content;

    /**
     * 构造函数
     */
    public Results() {};

    /**
     * 构造函数
     * @param state 结果码
     * @param message 返回信息
     * @param content 返回数据
     */
    public Results(Integer state, String message, T content) {
        this.state = state;
        this.message = message;
        this.content = content;
        this.time = System.currentTimeMillis();
    }

    /**
     * SUCCESS
     * @param <T> 返回类型
     * @return 返回结果
     */
    public static <T> Results<T> SUCCESS() {
        ResultsMsg resultsMsg = ResultsMsg.OK;
        return new Results<>(resultsMsg.getState(), resultsMsg.getMessage(), null);
    }

    /**
     * SUCCESS
     * @param message 返回信息
     * @param <T> 返回类型
     * @return 返回结果
     */
    public static <T> Results<T> SUCCESS(String message) {
        ResultsMsg resultsMsg = ResultsMsg.OK;
        return new Results<>(resultsMsg.getState(), message, null);
    }

    /**
     * SUCCESS
     * @param content 返回数据
     * @param <T> 返回类型
     * @return 返回结果
     */
    public static <T> Results<T> SUCCESS(T content) {
        ResultsMsg resultsMsg = ResultsMsg.OK;
        return new Results<>(resultsMsg.getState(), resultsMsg.getMessage(), content);
    }

    /**
     * SUCCESS
     * @param message 返回信息
     * @param content 返回数据
     * @param <T> 返回类型
     * @return 返回结果
     */
    public static <T> Results<T> SUCCESS(String message, T content) {
        ResultsMsg resultsMsg = ResultsMsg.OK;
        return new Results<>(resultsMsg.getState(), message, content);
    }

    /**
     * ERROR
     * @param <T> 返回类型
     * @return 返回结果
     */
    public static <T> Results<T> ERROR() {
        ResultsMsg resultsMsg = ResultsMsg.SEVER_ERROR;
        return new Results<>(resultsMsg.getState(), resultsMsg.getMessage(), null);
    }

    /**
     * ERROR
     * @param message 返回信息
     * @param <T> 返回类型
     * @return 返回结果
     */
    public static <T> Results<T> ERROR(String message) {
        ResultsMsg resultsMsg = ResultsMsg.SEVER_ERROR;
        return new Results<>(resultsMsg.getState(), message, null);
    }

    /**
     * ERROR
     * @param content 返回数据
     * @param <T> 返回类型
     * @return 返回结果
     */
    public static <T> Results<T> ERROR(T content) {
        ResultsMsg resultsMsg = ResultsMsg.SEVER_ERROR;
        return new Results<>(resultsMsg.getState(), resultsMsg.getMessage(), content);
    }

    /**
     * ERROR
     * @param state 结果码
     * @param message 返回信息
     * @param <T> 返回类型
     * @return 返回结果
     */
    public static <T> Results<T> ERROR(Integer state, String message) {
        ResultsMsg resultsMsg = ResultsMsg.SEVER_ERROR;
        return new Results<>(state, message, null);
    }

    /**
     * ERROR
     * @param message 返回信息
     * @param content 返回数据
     * @param <T> 返回类型
     * @return 返回结果
     */
    public static <T> Results<T> ERROR(String message, T content) {
        ResultsMsg resultsMsg = ResultsMsg.SEVER_ERROR;
        return new Results<>(resultsMsg.getState(), message, content);
    }

    /**
     * RESULT
     * @param resultsMsg 结果信息
     * @param <T> 结果类型
     * @return 返回结果
     */
    public static <T> Results<T> RESULT(ResultsMsg resultsMsg) {
        return new Results<>(resultsMsg.getState(), resultsMsg.getMessage(), null);
    }

    /**
     * RESULT
     * @param state 结果码
     * @param message 返回信息
     * @param content 返回数据
     * @param <T> 返回类型
     * @return 返回结果
     */
    public static <T> Results<T> RESULT(Integer state, String message, T content) {
        return new Results<>(state, message, content);
    }

    /**
     * 判断返回结果是否成功
     * @param results  返回结果
     * @param <T> 返回类型
     * @return true 成功 false 失败
     */
    public static <T> boolean isSuccess(Results<T> results) {
        if (results == null) {
            return false;
        }
        return ResultsMsg.OK.getState().equals(results.getState()) ? true : false;
    }
}
