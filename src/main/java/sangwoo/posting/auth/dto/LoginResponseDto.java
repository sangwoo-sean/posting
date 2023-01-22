package sangwoo.posting.auth.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private String token;
    private String name;
    private Long userId;

    public LoginResponseDto(String token, Long userId, String name) {
        this.token = token;
        this.name = name;
        this.userId = userId;
    }
}
