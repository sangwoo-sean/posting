package sangwoo.posting.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sangwoo.posting.auth.dto.LoginDto;
import sangwoo.posting.auth.dto.LoginResponseDto;
import sangwoo.posting.auth.dto.SignupDto;
import sangwoo.posting.user.UserService;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity login(@Validated @RequestBody LoginDto loginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(bindingResult.getFieldError());
        }

        LoginResponseDto response = authService.login(loginDto);

        return ResponseEntity.ok(response);
    }

    @PostMapping("signup")
    @Transactional
    public ResponseEntity signup(@Validated @RequestBody SignupDto signupDto, BindingResult bindingResult) { //회원가입
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(bindingResult.getFieldError());
        }

        boolean success = userService.createUser(signupDto);
        return ResponseEntity.ok(success);
    }

    @PostMapping("logout")
    public ResponseEntity logout() { //로그아웃
        //todo: something
        return ResponseEntity.ok(null);
    }

    //todo: 비밀번호 찾기 혹은 초기화, email 로 보내야할듯
}
