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

    private static final String validName = "tester";
    private static final String validEmail = "tester@test1.com";
    private static final String invalidEmail = "tester";
    private static final String validPassword = "test1234!";
    private static final String invalidPassword = "test";

    @Test
    void withoutEmailAndPassword() throws Exception {
        //given
        UserDto userDto = new UserDto();

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        String contentAsString = actions
                .andExpect(status().is(HttpServletResponse.SC_BAD_REQUEST))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void withValidEmailWithoutPassword() throws Exception {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail(validEmail);

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        String contentAsString = actions
                .andExpect(status().is(HttpServletResponse.SC_BAD_REQUEST))
                .andReturn().getResponse().getContentAsString();

        assertThat(contentAsString).contains("signupDto.password"); //패스워드 없음 오류
    }

    @Test
    void withoutEmailWithValidPassword() throws Exception {
        //given
        UserDto userDto = new UserDto();
        userDto.setPassword(validPassword);

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        String contentAsString = actions
                .andExpect(status().is(HttpServletResponse.SC_BAD_REQUEST))
                .andReturn().getResponse().getContentAsString();

        assertThat(contentAsString).contains("signupDto.email"); //이메일 없음 오류
    }

    @Test
    void withInvalidEmailAndInvalidPassword() throws Exception {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail(invalidEmail);
        userDto.setPassword(invalidPassword);

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        String contentAsString = actions
                .andExpect(status().is(HttpServletResponse.SC_BAD_REQUEST))
                .andReturn().getResponse().getContentAsString();

        assertThat(contentAsString.contains("signupDto.email") || contentAsString.contains("signupDto.password")).isTrue();
    }

    @Test
    void withValidEmailAndInvalidPassword() throws Exception {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail(validEmail);
        userDto.setPassword(invalidPassword);

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        String contentAsString = actions
                .andExpect(status().is(HttpServletResponse.SC_BAD_REQUEST))
                .andReturn().getResponse().getContentAsString();

        assertThat(contentAsString).contains("signupDto.password");
    }

    @Test
    void withInvalidEmailAndValidPassword() throws Exception {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail(invalidEmail);
        userDto.setPassword(validPassword);

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        String contentAsString = actions
                .andExpect(status().is(HttpServletResponse.SC_BAD_REQUEST))
                .andReturn().getResponse().getContentAsString();

        assertThat(contentAsString).contains("signupDto.email");
    }

    @Test
    void signupRequestWithDuplicatedEmail() throws Exception {
        //given
        UserDto userDto = new UserDto();
        userDto.setName(validName);
        userDto.setEmail(validEmail);
        userDto.setPassword(validPassword);
        mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        String contentAsString = actions
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(contentAsString).isEqualTo("false");
    }

    @Test
    void successfulSignup() throws Exception {
        //given
        UserDto userDto = new UserDto();
        userDto.setName(validName);
        userDto.setEmail(validEmail);
        userDto.setPassword(validPassword);

        //when
        ResultActions actions = mockMvc.perform(requestBuilder("/signup")
                .content(userDto.toString()));

        //then
        String contentAsString = actions
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(contentAsString).isEqualTo("true");
    }

    private MockHttpServletRequestBuilder requestBuilder(String requestUrl) throws Exception {
        return post(requestUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8);
    }
}