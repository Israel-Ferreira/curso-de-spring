package io.codekaffee.cursomc.services.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Slf4j
public class MockEmailService extends AbstractEmailService {

    @Override
    public void sendEmail(SimpleMailMessage message) {
        log.info("Simulando o envio de email.....");
        log.info(message.toString());
        log.info("Email Enviado");
    }
}
