package com.company.assaka.util;

import com.company.assaka.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static SecretKey KEY;
    private static long EXPIRATION;

    private final JwtConfig jwtConfig;

    public JwtUtil(JwtConfig jwtConfig){this.jwtConfig = jwtConfig;}

    @PostConstruct
    public void init() {
        // 将 yml 中的字符串密钥转换为符合 HmacSHA256 标准的密钥对象
        JwtUtil.KEY = Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8));
        JwtUtil.EXPIRATION = jwtConfig.getExpiration();

        // 打印一下，方便你确认是否读取成功（上线时建议删掉或改为 debug 级别日志）
        System.out.println("=== JWT密钥初始化成功，过期时间：" + EXPIRATION + " 毫秒 ===");
    }

    /**
     * 生成 Token
     *
     * @param claims 自定义的 payload 数据（比如存放 userId, userType 等）
     * @return 返回签发的 JWT 字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expDate = new Date(nowMillis + EXPIRATION);

        return Jwts.builder()
                .claims(claims)                 // 放入自定义业务数据
                .issuedAt(now)                  // 签发时间
                .expiration(expDate)            // 过期时间
                .signWith(KEY, Jwts.SIG.HS256)  // 指定密钥和签名算法
                .compact();                     // 压缩生成字符串
    }


    /**
     * 解析 Token，获取所有的 Claims (Payload 里的所有数据)
     * 如果 Token 过期、被篡改、或者格式不对，此方法会抛出异常
     *
     * @param token 前端传来的 JWT 字符串
     * @return Claims 对象 (本质上就是一个 Map)
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(KEY)                // 设置验证密钥
                .build()
                .parseSignedClaims(token)       // 解析并验证签名
                .getPayload();                  // 获取 Payload 部分
    }

    /**
     * 通用方法：从 Token 中获取指定的字段值
     *
     * @param token JWT 字符串
     * @param key   你想获取的字段名 (比如 "userType", "userId")
     * @return 对应的值 (需强转为你需要的类型，如 String, Integer)
     */
    public static Object getClaim(String token, String key) {
        Claims claims = parseToken(token);
        return claims.get(key);
    }

    /**
     * 便捷方法：专门获取用户类型/角色
     * 对应你之前提问的 userType
     */
    public static String getUserType(String token) {
        return (String) getClaim(token, "userType");
    }

    /**
     * 便捷方法：专门获取用户ID
     */
    public static String getUserId(String token) {
        return (String) getClaim(token, "userId");
    }

    /**
     * 判断 Token 是否过期 (验证不通过也算过期)
     *
     * @param token JWT 字符串
     * @return true 表示已过期或无效；false 表示有效
     */
    public static boolean isTokenExpired(String token) {
        try {
            Claims claims = parseToken(token);
            return claims.getExpiration().before(new Date());
        } catch (Exception e) {
            // 只要 parseToken 抛出异常（说明被篡改或格式错误），我们也视为无效
            return true;
        }
    }
}
