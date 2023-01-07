package sangwoo.posting.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sangwoo.posting.user.dto.UserDto;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity login(@Validated @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(bindingResult.getFieldError());
        }

        String token = authService.login(userDto);
        return ResponseEntity.ok(token);
    }
}
