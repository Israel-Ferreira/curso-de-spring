package io.codekaffee.cursomc.models;

import io.codekaffee.cursomc.dto.enderecos.EnderecoDTO;
import io.codekaffee.cursomc.dto.enderecos.NewEnderecoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;


    @ManyToOne
    private Cliente cliente;


    @OneToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;


    public Endereco(EnderecoDTO enderecoDTO, Cliente cliente, Cidade cidade){
        this.numero = enderecoDTO.getNumero();
        this.logradouro = enderecoDTO.getLogradouro();
        this.complemento = enderecoDTO.getComplemento();
        this.cep = enderecoDTO.getCep();
        this.bairro = enderecoDTO.getBairro();

        this.cidade = cidade;
        this.cliente = cliente;
    }




    public Endereco(String logradouro, String numero, String complemento, String bairro, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
    }

}
