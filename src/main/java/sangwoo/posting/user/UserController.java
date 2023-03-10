package sangwoo.posting.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sangwoo.posting.user.dto.UserDto;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping
    public ResponseEntity<Void> updateUser() { //회원수정
        userService.updateUser();
        return ResponseEntity.ok(null);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser() { //회원탈퇴
        userService.deleteUser();
        return ResponseEntity.ok(null);
    }

    @GetMapping(params = "email")
    public ResponseEntity<UserDto> findUserByEmail(@RequestParam String email) {
        UserDto userDto = userService.findUserByEmail(email);
        return ResponseEntity.ok(userDto);
    }
}
