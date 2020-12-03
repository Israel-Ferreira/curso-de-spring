package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.dto.location.CidadeDTO;
import io.codekaffee.cursomc.exceptions.nfex.CidadeNotFoundException;
import io.codekaffee.cursomc.exceptions.nfex.EstadoNotFoundException;
import io.codekaffee.cursomc.models.Cidade;
import io.codekaffee.cursomc.models.Estado;
import io.codekaffee.cursomc.repositories.CidadeRepository;
import io.codekaffee.cursomc.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public void insertCity(CidadeDTO cidadeDTO){
        Estado estado =  estadoRepository.findByNomeAndSigla(cidadeDTO.getNomeEstado(), cidadeDTO.getSiglaEstado())
                .orElseThrow(EstadoNotFoundException::new);

        Cidade cidade = new Cidade(cidadeDTO.getNome(), estado);

        cidadeRepository.save(cidade);
    }


    public Cidade findByNome(String nome){
        System.out.println(nome);
        return cidadeRepository.findByNomeContainingIgnoringCase(nome)
                .orElseThrow(CidadeNotFoundException::new);
    }
}
