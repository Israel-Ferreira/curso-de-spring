package io.codekaffee.cursomc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.enums.TipoCliente;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@ToString(exclude = "enderecos")
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;


    @Email
    @Column(unique = true)
    private String email;


    @CPF
    @Column(nullable = true)
    private String cpf;

    @CNPJ
    @Column(nullable = true)
    private String cnpj;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();


    @JsonBackReference
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();


    @ElementCollection
    @CollectionTable(name = "telefone")
    private Set<String> telefones =  new HashSet<>();


    public Cliente(String nome, @Email String email, @CPF String cpf, @CNPJ String cnpj, TipoCliente tipo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.tipo = tipo;
    }


    public Cliente(ClienteDTO clienteDTO){
        this.email = clienteDTO.getEmail();
        this.cpf = clienteDTO.getCpf();
        this.cnpj = clienteDTO.getCnpj();
        this.nome = clienteDTO.getNome();

        this.telefones = clienteDTO.getTelefones();
        this.tipo = TipoCliente.toEnum(clienteDTO.getTipoClientID());
    }
}
