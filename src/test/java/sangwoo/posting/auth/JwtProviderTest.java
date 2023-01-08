package sangwoo.posting.auth;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import sangwoo.posting.user.User;
import sangwoo.posting.user.dto.UserDto;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

class JwtProviderTest {

    private final JwtProvider jwtProvider;

    public JwtProviderTest() {
        jwtProvider = new JwtProvider("secretKey", Duration.ofMillis(2000).toMillis());
    }

    @Test
    void tokenCreateAndParseTest() {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail("tester");
        User user = User.register(userDto);
        String token = jwtProvider.createToken(user);

        //when
        Claims claims = jwtProvider.parseJwtToken(token);

        //then
        assertThat(claims.getSubject()).isEqualTo("subject");
        assertThat(claims).containsEntry("email", "tester");
    }

    @Test
    void tokenExpiredTest() {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail("tester");
        User user = User.register(userDto);
        String token = jwtProvider.createToken(user);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //when
        Claims claims = jwtProvider.parseJwtToken(token);

        //then
        assertThat(claims).isNull();
    }
}