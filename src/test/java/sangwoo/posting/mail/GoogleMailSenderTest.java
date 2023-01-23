package sangwoo.posting.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sangwoo.posting.mail.dto.TestMailDto;

@SpringBootTest
class GoogleMailSenderTest {

    @Autowired
    private MailSender googleMailSender;

    @Test
    void mailSendTest() {
        TestMailDto mailDto = new TestMailDto();
        mailDto.setTo("tkddn3367@gmail.com");
        mailDto.setSubject("[Spring Application] 메일 발송 테스트");
        String templateName = "test.ftl";

        mailDto.setTitle("this is the content");
        mailDto.setField1("this is field 1");
        mailDto.setField2("this is field 2");

        googleMailSender.sendMail(mailDto, templateName);
    }
}