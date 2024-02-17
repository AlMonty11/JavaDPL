package com.example.montaneralbertomyikea.controllers;

import com.example.montaneralbertomyikea.interfaces.pedidoService;
import com.example.montaneralbertomyikea.models.CarritoEntity;
import com.example.montaneralbertomyikea.models.PedidoEntity;
import com.example.montaneralbertomyikea.models.ProductofferEntity;
import com.example.montaneralbertomyikea.services.carritoServiceJPA;
import com.example.montaneralbertomyikea.services.pedidoServiceJPA;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
@Controller
public class pedidosController {
    @Autowired
    pedidoServiceJPA pedidoService;
    @Autowired
    carritoServiceJPA carritoService;
    @GetMapping("/pedidos")
    public String listarPedidos(Model model) {
        List<PedidoEntity> pedidos = pedidoService.listarPedidos();
        model.addAttribute("pedidos", pedidos);
        return "pedidos/pedidos";
    }
    @GetMapping("/realizarPedido")
    public String realizarPedido(){
        CarritoEntity carrito = carritoService.getCarrito();
        PedidoEntity pedido = new PedidoEntity();
        pedido.setCarrito(carrito);
        pedidoService.realizarPedido(pedido);
        carrito.setPagado(true);
        carritoService.aniadirAlCarrito(carrito);
        return "redirect:/pedidos";
    }
    @GetMapping("/detailsPedido/{id}")
    public String detailsPedido(@PathVariable int id,Model model){
        PedidoEntity pedido = pedidoService.detailsPedido(id);
        model.addAttribute("pedido",pedido);
        return "/pedidos/detailsPedido";
    }
}
