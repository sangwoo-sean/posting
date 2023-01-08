package sangwoo.posting.auth;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import sangwoo.posting.user.User;
import sangwoo.posting.user.dto.UserDto;

import static org.assertj.core.api.Assertions.assertThat;

class JwtProviderTest {

    private final JwtProvider jwtProvider;

    public JwtProviderTest() {
        jwtProvider = new JwtProvider("secretKey");
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
}