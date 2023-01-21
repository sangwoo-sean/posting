package sangwoo.posting.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sangwoo.posting.user.dto.UserDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 중복된 이메일이 이미 존재하면 false 반환.
     * @param userDto
     * @return boolean - 회원가입 성공 여부를 반환
     */
    @Transactional
    public boolean createUser(UserDto userDto) { //회원가입
        boolean duplicated = userRepository.findByEmail(userDto.getEmail()).isPresent();
        if (duplicated)
            return false;

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        User user = User.register(userDto);
        userRepository.save(user);
        return true;
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

    public UserDto findUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(IllegalAccessError::new);
        return new UserDto(user);
    }
}
