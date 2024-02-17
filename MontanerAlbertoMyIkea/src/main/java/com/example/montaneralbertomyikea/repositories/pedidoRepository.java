package com.example.montaneralbertomyikea.repositories;

import com.example.montaneralbertomyikea.models.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *Esta clase representa el repositorio Pedido
 * @version 1.0 10/02/2024
 * @author Alberto Montaner
 */
public interface pedidoRepository extends JpaRepository<PedidoEntity,Integer> {
}
