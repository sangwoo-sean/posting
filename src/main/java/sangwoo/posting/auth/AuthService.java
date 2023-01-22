package sangwoo.posting.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sangwoo.posting.auth.dto.LoginResponseDto;
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
    private final JwtProvider jwtProvider;

    public LoginResponseDto login(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(InvalidUserEmailException::new);

        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new InvalidUserPasswordException();
        }

        String jwtToken = jwtProvider.createToken(user);

        return new LoginResponseDto(jwtToken, user.getId());
    }
}
