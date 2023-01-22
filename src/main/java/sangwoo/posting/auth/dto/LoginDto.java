package sangwoo.posting.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginDto {
    @NotBlank(message = "이메일은 공백일 수 없습니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @NotBlank(message = "비밀번호는 공백일 수 없습니다.")
    @Pattern(regexp = "(?i)^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=,./<>?;':\"\\[\\]{}])[A-Z\\d!@#$%^&*()_+\\-=,./<>?;':\"\\[\\]{}]{8,20}$",
            message = "비밀번호는 8~20자의 영문자+숫자+특수문자를 조합한 형태로 입력해주세요.")
    private String password;

    @Override
    public String toString() {
        return "{" +
                "\"email\": \"" + email + "\", " +
                "\"password\": \"" + password + "\"" +
                "}";
    }
}
