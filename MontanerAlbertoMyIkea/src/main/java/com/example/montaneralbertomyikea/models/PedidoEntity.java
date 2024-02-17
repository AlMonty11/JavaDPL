package com.example.montaneralbertomyikea.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
public class PedidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pedido_id", nullable = false)
    private int pedidoId;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "carrito_id", referencedColumnName = "carrito_Id")
    private CarritoEntity carrito;

    public PedidoEntity() {

    }
}
