package io.codekaffee.cursomc.services.email;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@Slf4j
public class SmtpEmailService extends AbstractEmailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendEmail(SimpleMailMessage message) {
        log.info("Enviando o email.....");
        mailSender.send(message);
        log.info("Email Enviado com sucesso");
    }
}
