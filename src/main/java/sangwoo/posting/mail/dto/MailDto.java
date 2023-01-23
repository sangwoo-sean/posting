package sangwoo.posting.mail.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MailDto {
    private String to;
    private String subject;
    private String content;
}
