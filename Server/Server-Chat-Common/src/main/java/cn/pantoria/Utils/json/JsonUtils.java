package cn.pantoria.Utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Utils.json
 * @Author: 程序员Eighteen
 * @CreateTime: 2026-01-01  21:22
 * @Description: TODO
 * @Version: 1.0
 */

@Slf4j
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        OBJECT_MAPPER.registerModules(new JavaTimeModule());  //解决localDatetime 序列化问题
    }
    public static String toJsonString(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("对象序列化为JSON失败", e);
            return String.valueOf(object);
        }
    }
}
