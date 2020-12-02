package io.codekaffee.cursomc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.enums.TipoCliente;
import io.codekaffee.cursomc.models.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ClienteDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String nome;
    private String email;
    private Set<String> telefones = new HashSet<>();

    private Long tipoClientID;

    private String cpf;
    private String cnpj;

    private List<EnderecoDTO> enderecos;

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefones = cliente.getTelefones();
        this.enderecos = cliente.getEnderecos().stream().map(EnderecoDTO::new).collect(Collectors.toList());
        this.cpf = cliente.getCpf();
        this.cnpj = cliente.getCnpj();
    }

    public ClienteDTO(String nome, String email, Set<String> telefones, Long tipoClientID, String cpf, String cnpj) {
        this.nome = nome;
        this.email = email;
        this.telefones = telefones;
        this.tipoClientID = tipoClientID;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }



}
