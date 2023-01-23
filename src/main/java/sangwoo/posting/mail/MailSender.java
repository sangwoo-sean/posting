package sangwoo.posting.mail;

import sangwoo.posting.mail.dto.MailDto;

public interface MailSender {

    void sendMail(MailDto mailDto, String templateName);
}
