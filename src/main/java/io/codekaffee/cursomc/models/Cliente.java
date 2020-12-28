package io.codekaffee.cursomc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.dto.clientes.PostClientDTO;
import io.codekaffee.cursomc.enums.TipoCliente;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    private String cpfOrCnpj;


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


    public Cliente(String nome, @Email String email, String cpfOrCnpj, TipoCliente tipo) {
        this.nome = nome;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.tipo = tipo;
    }


    public Cliente(PostClientDTO clienteDTO){
        this.email = clienteDTO.getEmail();
        this.cpfOrCnpj = clienteDTO.getCpfOrCnpj();
        this.nome = clienteDTO.getNome();

        this.telefones = clienteDTO.getTelefones();
        this.tipo = TipoCliente.toEnum(clienteDTO.getTipoClientID());
    }

    public Cliente updateData(ClienteDTO clienteDTO){

        this.setNome(clienteDTO.getNome());
        this.setEmail(clienteDTO.getEmail());

        return  this;
    }
}
