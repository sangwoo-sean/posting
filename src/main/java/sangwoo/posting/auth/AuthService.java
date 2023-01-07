package sangwoo.posting.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sangwoo.posting.exceptions.InvalidUserEmailException;
import sangwoo.posting.exceptions.InvalidUserPasswordException;
import sangwoo.posting.user.User;
import sangwoo.posting.user.UserRepository;
import sangwoo.posting.user.dto.UserDto;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String login(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(InvalidUserEmailException::new);

        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new InvalidUserPasswordException();
        }
        //todo
        String jwtToken = "";
        return jwtToken;
    }
}
