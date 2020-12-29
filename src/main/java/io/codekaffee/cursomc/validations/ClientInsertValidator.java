package io.codekaffee.cursomc.validations;

import io.codekaffee.cursomc.annotations.ClientInsert;
import io.codekaffee.cursomc.dto.clientes.PostClientDTO;
import io.codekaffee.cursomc.enums.TipoCliente;
import io.codekaffee.cursomc.exceptions.FieldMessage;
import io.codekaffee.cursomc.exceptions.nfex.ClienteNotFoundException;
import io.codekaffee.cursomc.models.Cliente;
import io.codekaffee.cursomc.repositories.ClienteRepository;
import io.codekaffee.cursomc.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, PostClientDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClientInsert constraintAnnotation) {

    }

    @Override
    public boolean isValid(PostClientDTO value, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if(value.getTipoClientID().equals(TipoCliente.PESSOA_FISICA.getId()) && !BR.isValidCPF(value.getCpfOrCnpj())){
            list.add(new FieldMessage("cpfOrCnpj","CPF Inválido"));
        }


        if(value.getTipoClientID().equals(TipoCliente.PESSOA_JURIDICA.getId()) && !BR.isValidCNPJ(value.getCpfOrCnpj())){
            list.add(new FieldMessage("cpfOrCnpj", "CNPJ Inválido"));
        }

        Cliente aux = clienteRepository.findByEmail(value.getEmail()).orElse(null);

        if(aux != null){
            list.add(new FieldMessage("email", "Email já existente"));
        }

        for (FieldMessage e : list){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }


        return list.isEmpty();
    }
}
