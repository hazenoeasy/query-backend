package plus.yuhaozhang.blog.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuh Z
 * @date 12/8/21
 */
public class JWTUtils {
    private static final String JWT_Token = "test";
    public static String createToken(Long userId){
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId",userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,JWT_Token)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+14*60*60*1000));
        String token = jwtBuilder.compact();
        return token;
    }
    public static Map<String,Object> checkToken(String token){
        try{
            Jwt parse = Jwts.parser().setSigningKey(JWT_Token).parse(token);
            return (Map<String,Object>) parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String token = createToken(100L);
        Map<String,Object> map = checkToken(token);
        System.out.println(map);
    }
}
