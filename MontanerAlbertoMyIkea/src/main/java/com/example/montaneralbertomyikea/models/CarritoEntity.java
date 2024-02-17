package com.example.montaneralbertomyikea.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
/**
 *Esta clase representa la entidad Carrito
 * @version 1.0 10/02/2024
 * @author Alberto Montaner
 */
public class CarritoEntity {
    /**
     * Maneja el flujo de negocio de la entidad Carrito
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "carrito_id", nullable = false)
    private int carritoId;
    @ManyToMany
    @JoinTable(name="productos_carrito",joinColumns = @JoinColumn( name="carrito_id"),inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<ProductofferEntity> productsCarrito = new ArrayList<>();
    private double costeTotal;
    @Column(name = "pagado",nullable = false)
    private boolean pagado = false;


}
