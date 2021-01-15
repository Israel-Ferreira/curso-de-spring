package io.codekaffee.cursomc.services.email;

import io.codekaffee.cursomc.models.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendOrderConfirmationEmail(Pedido pedido);
    void sendEmail(SimpleMailMessage message);
}
