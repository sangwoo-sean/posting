package sangwoo.posting.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity createUser() { //회원가입
        userService.createUser();
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
