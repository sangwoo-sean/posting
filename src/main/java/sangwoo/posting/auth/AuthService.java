package sangwoo.posting.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sangwoo.posting.auth.dto.LoginDto;
import sangwoo.posting.auth.dto.LoginResponseDto;
import sangwoo.posting.exceptions.InvalidUserEmailException;
import sangwoo.posting.exceptions.InvalidUserPasswordException;
import sangwoo.posting.user.User;
import sangwoo.posting.user.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public LoginResponseDto login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(InvalidUserEmailException::new);

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new InvalidUserPasswordException();
        }

        String jwtToken = jwtProvider.createToken(user);

        return new LoginResponseDto(jwtToken, user.getId(), user.getName());
    }
}
