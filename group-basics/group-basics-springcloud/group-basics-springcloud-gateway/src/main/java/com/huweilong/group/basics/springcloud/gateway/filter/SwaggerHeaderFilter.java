package com.huweilong.group.basics.springcloud.gateway.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * swagger 过滤器
 * @author Alex
 */
@Component
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {

    /**
     * HEADER_NAME
     */
    private static final String HEADER_NAME = "X-Forwarded-Prefix";

    /**
     * URI
     */
    private static final String URI = "/v2/api-docs";

    /**
     * 配置网关过滤器
     * @param config 配置项
     * @return GatewayFilter
     */
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path,URI )) {
                return chain.filter(exchange);
            }
            String basePath = path.substring(0, path.lastIndexOf(URI));
            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
        };
    }
}
