package sangwoo.posting.auth;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sangwoo.posting.exceptions.UnautorizedReqeustException;
import sangwoo.posting.user.User;

import java.time.Duration;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtProvider {

    private final String secretKey;
    private long validDuration = Duration.ofDays(1).toMillis();

    @Autowired
    public JwtProvider(@Value("${jwt.password: secretKey}") String secretKey) {
        this.secretKey = secretKey;
    }

    public JwtProvider(@Value("${jwt.password: secretKey}") String secretKey, long validDuration) {
        this.secretKey = secretKey;
        this.validDuration = validDuration;
    }

    public String createToken(User user) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + validDuration);

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // (1)
                .setIssuer("test") // 토큰발급자(iss)
                .setIssuedAt(now) // 발급시간(iat)
                .setExpiration(expiration) // 만료시간(exp)
                .claim("email", user.getEmail())
                .claim("name", user.getName())
                .setSubject("subject") //  토큰 제목(subject)
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes())) // 알고리즘, 시크릿 키
                .compact();
    }

    public Claims parseJwtToken(String token) {
        if (token == null) throw new UnautorizedReqeustException();

        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes()))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            log.error("Invalid JWT signature", e);
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token", e);
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token", e);
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token", e);
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty.", e);
        }
        return claims;
    }
}
