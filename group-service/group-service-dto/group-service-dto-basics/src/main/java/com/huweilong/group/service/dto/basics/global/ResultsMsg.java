package com.huweilong.group.service.dto.basics.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 通用接口返回内容
 *  1XX 信息类
 *  2XX 客户端的请求格式正确且处理成功
 *  3XX 重定向
 *  4XX 客户端错误
 *  5XX 服务器错误
 * @author Alex
 */
@AllArgsConstructor
@Getter
public enum ResultsMsg {

    /**
     * 200 OK。
     * 请求已成功执行，回应内容取决于所调用的动词
     */
    OK(200, "OK"),
    /**
     * 201 已创建。
     * 请求已成功执行，在执行过程中创建了一个新资源。相应body为空或包含所创建资源的url，响应中的location头也应该指向URL
     */
    CREATED(201, "CREATED"),
    /**
     * 202 已接受。
     * 请求有效并已接受，但尚未得到处理。
     * 可通过请求轮询，相应结果中的url提供状态更新。
     * 这种方式支持异步REST请求
     */
    ACCEPTED(202, "ACCEPTED"),
    /**
     * 204 没有请求的内容
     * 请求已成功处理，但服务器没有任何响应结果，客户端不应更新显示
     */
    EMPTY(204, "EMPTY"),

    /**
     * 301 永久移除
     * 请求的资源不在位于指定的url。新的location应该在请求头中返回。
     * 只有get或head请求应当重定向到新位置。如有可能，客户端应该更新自己保存的书签
     */
    REMOVE(301, "REMOVE"),
    /**
     * 302 已找到
     * 请求的资源已在其它临时位置找到，并应该在请求头中返回该位置。
     * 只有get或head请求应当重定向到新位置。客户端无需更新书签，因为资源会返回对应的url
     */
    FIND(302, "FIND"),
    /**
     * 303 参见其它信息
     * 该响应码被W3C技术架构小组重新解释成一种对非网络可寻址资源的有效请求方式。这是语义化web中的一个重要概念。可向个人，概念，组织等提供uri。能够在web中找到和不能在web中找到的资源是有区别的
     * 如果客户端收到的编码是303而不是200，就能分辨这种差别。重定向的位置在相应的location头中，头信息可能包含相关资源的文档引用，也可能包含相关资源的一些元数据。
     */
    OTHER(303, "OTHER"),

    /**
     * 403 没有权限
     */
    NO_AUTH(403, "NO_AUTH"),
    /**
     * 404 资源未找到
     */
    NO_FOUND(404, "NO_FOUND"),
    /**
     * 405 方法不允许
     */
    NO_ALLOW(405, "NO_ALLOW"),
    /**
     * 406 请求不接受
     */
    NO_ACCEPTED(406, "NO_ACCEPTED"),
    /**
     * 410 资源不存在
     */
    NO_EXIST(410, "NO_EXIST"),
    /**
     * 411 需要指定长度
     */
    LENGTH_LEGAL(411, "LENGTH_LEGAL"),
    /**
     * 412 前提条件失败
     */
    PREMISE_ERROR(412, "PREMISE_ERROR"),
    /**
     * 413 Entity太大
     */
    ENTITY_BIG(413, "ENTITY_BIG"),
    /**
     * 414 URI超长
     */
    URI_LONG(414, "URI_LONG"),
    /**
     * 415 不支持的媒体类型
     */
    MEDIA_ERROR(415, "MEDIA_ERROR"),
    /**
     * 417 预期失败
     */
    EXPECT_ERROR(417, "EXPECT_ERROR"),

    /**
     * 500 内部服务器错误
     */
    SEVER_ERROR(500, "SEVER_ERROR"),
    /**
     * 501 未实现
     */
    NO_IMPL(501, "NO_IMPL"),
    /**
     * 503 服务不可用
     */
    NO_ABLE(503, "NO_ABLE"),
    ;

    /**
     * 返回状态
     */
    private Integer state;

    /**
     * 返回消息
     */
    private String message;

    public static ResultsMsg getByCode(String state) {
        return Arrays.stream(ResultsMsg.values()).filter(a -> a.getState().equals(state)).findFirst().orElse(null);
    }

}
