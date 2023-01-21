package sangwoo.posting.auth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import sangwoo.posting.user.dto.UserDto;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Transactional
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void withoutPayload() throws Exception {
        //given
        UserDto userDto = new UserDto();

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        String contentAsString = actions
                .andExpect(status().is(HttpServletResponse.SC_BAD_REQUEST))
                .andReturn().getResponse().getContentAsString();

        assertThat(contentAsString).contains("userDto.email"); //이메일 없음 오류
    }

    @Test
    void withoutPassword() throws Exception {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail("tester@test1.test");

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        String contentAsString = actions
                .andExpect(status().is(HttpServletResponse.SC_BAD_REQUEST))
                .andReturn().getResponse().getContentAsString();

        assertThat(contentAsString).contains("userDto.password"); //패스워드 없음 오류
    }

    //todo: test
    // 패스워드 있고 아이디 없을때
    // 유효하지 않은 아이디일때
    // 유효하지 않은 비밀번호일때
    // 중복된 아이디일때

    @Test
    void successfulSignup() throws Exception {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail("tester@test1.test");
        userDto.setPassword("test1234");

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        actions
                .andExpect(status().isOk());
    }

    private MockHttpServletRequestBuilder requestBuilder(String requestUrl) throws Exception {
        return post(requestUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8);
    }
}