package io.codekaffee.cursomc.services;

import ch.qos.logback.core.net.server.Client;
import io.codekaffee.cursomc.dto.enderecos.NewEnderecoDTO;
import io.codekaffee.cursomc.models.Cidade;
import io.codekaffee.cursomc.models.Cliente;
import io.codekaffee.cursomc.models.Endereco;
import io.codekaffee.cursomc.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeService cidadeService;

    public void insertEndereco(NewEnderecoDTO enderecoDTO, Cliente cliente){
        Cidade cidade =  cidadeService.findByNome(enderecoDTO.getCidade());

        Endereco endereco = new Endereco(enderecoDTO, cliente, cidade);
        enderecoRepository.save(endereco);
    }
}
