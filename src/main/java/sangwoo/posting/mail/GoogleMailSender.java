package sangwoo.posting.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import sangwoo.posting.mail.dto.MailDto;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@RequiredArgsConstructor
public class GoogleMailSender implements MailSender {

    private final JavaMailSender javaMailSender;
    private final Configuration configuration;

    @Value("${spring.name.username: tkddn3367@gmail.com}")
    private String FROM;

    @Override
    public void sendMail(MailDto mailDto, String templateName) {
        try (StringWriter stringWriter = new StringWriter()) {
            Template template = configuration.getTemplate(templateName);

            template.process(mailDto, stringWriter);
            String content = stringWriter.toString();
            mailDto.setContent(content);

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, StandardCharsets.UTF_8.name());

            helper.setFrom(FROM);
            helper.setTo(mailDto.getTo());
            helper.setSubject(mailDto.getSubject());
            helper.setText(mailDto.getContent(), true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            log.error("Failed to Send Gmail: MessagingException", e);
        } catch (IOException e) {
            log.error("Failed to Send Gmail: IOException", e);
        } catch (TemplateException e) {
            log.error("Failed to Send Gmail: TemplateException", e);
        }
    }
}
