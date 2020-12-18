package io.codekaffee.cursomc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @JsonFormat(pattern = "dd/MM/yyyy - HH:mm")
    private LocalDateTime instante;


    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoEntrega;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @OneToMany(mappedBy = "id.pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ItemPedido> items = new HashSet<>();

    public Pedido(Endereco enderecoEntrega, Cliente cliente) {
        this.enderecoEntrega = enderecoEntrega;
        this.cliente = cliente;
    }





}