package sangwoo.posting.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(InvalidUserEmailException.class)
    public ResponseEntity<String> InvalidUserEmailException(InvalidUserEmailException e) {
        String message = "유효하지 않은 이메일입니다.";
        if (e.getMessage() != null) {
            message = e.getMessage();
        }
        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidUserPasswordException.class)
    public ResponseEntity<String> InvalidUserPasswordException(InvalidUserPasswordException e) {
        String message = "유효하지 않은 비밀번호입니다.";
        if (e.getMessage() != null) {
            message = e.getMessage();
        }
        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> RuntimeException(RuntimeException e) {
        log.error(null, e);
        String message = "서비스에 문제가 발생했습니다.";
        if (e.getMessage() != null) {
            message = e.getMessage();
        }
        return new ResponseEntity(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
