package io.codekaffee.cursomc.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.dto.enderecos.EnderecoDTO;
import io.codekaffee.cursomc.dto.enderecos.NewEnderecoDTO;
import io.codekaffee.cursomc.dto.enderecos.ViewEnderecoDTO;
import io.codekaffee.cursomc.models.Cliente;
import io.codekaffee.cursomc.models.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class ClienteDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String nome;
    private String email;
    private Set<String> telefones = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long tipoClientID;

    private String cpf;
    private String cnpj;

    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ViewEnderecoDTO> enderecos = new ArrayList<>();


    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefones = cliente.getTelefones();


        this.cpf = cliente.getCpf();
        this.cnpj = cliente.getCnpj();
    }



}
