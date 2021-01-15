package io.codekaffee.cursomc.services.email;

import io.codekaffee.cursomc.models.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String emailSender;

    @Override
    public void sendOrderConfirmationEmail(Pedido pedido) {
        SimpleMailMessage messagePedido =  this.prepareSimpleMailMessageFromPedido(pedido);
        this.sendEmail(messagePedido);
    }


    protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido pedido){
        SimpleMailMessage sm = new SimpleMailMessage();

        sm.setTo(pedido.getCliente().getEmail());
        sm.setFrom(emailSender);

        sm.setSubject("Pedido Confirmado!! Código: " + pedido.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(pedido.toString());


        return sm;
    }
}
