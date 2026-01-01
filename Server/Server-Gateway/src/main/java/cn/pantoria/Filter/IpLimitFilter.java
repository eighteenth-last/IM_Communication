package cn.pantoria.Filter;

import cn.pantoria.Enum.ResponseEnum;
import cn.pantoria.Utils.ReturnErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Filter
 * @Author: 程序员Eighteen
 * @CreateTime: 2026-01-01  22:35
 * @Description: TODO
 * @Version: 1.0
 */

@Slf4j
@Component
public class IpLimitFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("网络ip开始拦截============");
        if(1==1){
            log.info("异常返回");
            return ReturnErrorUtil.disPlay(exchange, ResponseEnum.IP_ERROR);
        }
        return chain.filter(exchange);
    }

    // 过滤器的执行顺序
    @Override
    public int getOrder() {
        return 1;
    }
}
