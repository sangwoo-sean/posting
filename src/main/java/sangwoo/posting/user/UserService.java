package sangwoo.posting.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser() { //회원가입
        userRepository.save(new User());
    }

    @Transactional
    public void updateUser() { //회원정보수정
        Long target = 0L; // todo: get user no
        User user = userRepository.findById(target).orElseThrow(IllegalArgumentException::new);
        user.update();
    }

    @Transactional
    public void deleteUser() { //회원탈퇴
        //todo: 삭제정책 정의 필요 (soft or hard)
    }
}
