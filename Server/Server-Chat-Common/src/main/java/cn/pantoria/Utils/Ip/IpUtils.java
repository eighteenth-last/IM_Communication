package cn.pantoria.Utils.Ip;

import jakarta.servlet.http.HttpServletRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Utils.Ip
 * @Author: 程序员Eighteen
 * @CreateTime: 2026-01-01  22:15
 * @Description: TODO
 * @Version: 1.0
 */

public class IpUtils {
    public static String getRequestIp(HttpServletRequest httpServletRequest) {
        return getClientIp(httpServletRequest);
    }

    private static final String IP_UNKNOWN = "unknown";
    private static final String IP_LOCAL = "127.0.0.1";
    private static final String IP_LOCAL_IPV6 = "0:0:0:0:0:0:0:1";
    private static final int IP_LEN = 15;

    // 获取客户端 IP
    public static String getClientIp(HttpServletRequest httpServletRequest) {
        String ipAddress = httpServletRequest.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = httpServletRequest.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = httpServletRequest.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = httpServletRequest.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = httpServletRequest.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = httpServletRequest.getRemoteAddr();
            if (IP_LOCAL.equals(ipAddress) || IP_LOCAL_IPV6.equals(ipAddress)) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                }
            }
        }
        if (ipAddress != null && ipAddress.length() > IP_LEN) {
            int index = ipAddress.indexOf(",");
            if (index > 0) {
                ipAddress = ipAddress.substring(0, index);
            }
        }
        return ipAddress;
    }
}
