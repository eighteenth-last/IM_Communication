package cn.pantoria.Utils;

import cn.pantoria.Enum.ResponseEnum;
import cn.pantoria.Response.Response;
import cn.pantoria.Utils.json.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.core.io.buffer.DataBuffer;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Utils
 * @Author: 程序员Eighteen
 * @CreateTime: 2026-01-01  22:44
 * @Description: TODO
 * @Version: 1.0
 */

public class ReturnErrorUtil {
    // 重新包装错误返回信息
    public static Mono<Void> disPlay(ServerWebExchange webExchange, ResponseEnum responseEnum){
        // 1、拿到响应
        ServerHttpResponse httpResponse=webExchange.getResponse();
        // 2、构建返回对象
        Response jsonResult = Response.fail(responseEnum);
        // 3、设置返回的header
        if(!httpResponse.getHeaders().containsKey("Content-Type")){
            httpResponse.getHeaders().add("Content-Type", MimeTypeUtils.APPLICATION_JSON_VALUE);
        }
        // 4、将response的状态码设置为500
        httpResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        // 5、将返回对象转为json，并将信息输出给httpResponse
       String jsonString = JsonUtils.toJsonString(jsonResult);

        DataBuffer dataBuffer= httpResponse.bufferFactory().wrap(jsonString.getBytes(StandardCharsets.UTF_8));
        return httpResponse.writeWith(Mono.just(dataBuffer));

    }
}
