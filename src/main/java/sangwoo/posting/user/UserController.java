package sangwoo.posting.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sangwoo.posting.user.dto.UserDto;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity createUser(@Validated @RequestBody UserDto userDto, BindingResult bindingResult) { //회원가입
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(bindingResult.getFieldError());
        }
        userService.createUser(userDto);
        return ResponseEntity.ok(null);
    }

    @PatchMapping
    public ResponseEntity updateUser() { //회원수정
        userService.updateUser();
        return ResponseEntity.ok(null);
    }

    @DeleteMapping
    public ResponseEntity deleteUser() { //회원탈퇴
        userService.deleteUser();
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity test() {
        return ResponseEntity.ok("Hello world");
    }
}
