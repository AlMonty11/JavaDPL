package com.example.montaneralbertomyikea.controllers;

import com.example.montaneralbertomyikea.interfaces.municipiosService;
import com.example.montaneralbertomyikea.interfaces.productofferService;
import com.example.montaneralbertomyikea.interfaces.provinciasService;
import com.example.montaneralbertomyikea.models.MunicipiosEntity;
import com.example.montaneralbertomyikea.models.ProductofferEntity;
import com.example.montaneralbertomyikea.models.ProvinciasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 *Esta clase representa el controlador Productoffer
 * @version 1.0 10/02/2024
 * @author Alberto Montaner
 */
@Controller
public class productoffersController {
    /**
     * Maneja el flujo de negocio del controlador Productoffer
     */
    @Autowired
    productofferService productofferService;
    @Autowired
    municipiosService municipiosService;
    @Autowired
    provinciasService provinciasService;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    /**
     * Muestra la lista de todos los productos.
     * @return Vista principal de Productoffer
     */
    @GetMapping("/productoffer")
    public String listarProductos(Model model) {
        List<ProductofferEntity> productoffer = productofferService.listarProductos();
        model.addAttribute("productoffer", productoffer);
        return "productoffer/productoffer";
    }
    /**
     * Muestra la vista de los detalles de un producto
     * @param id ID del producto
     * @return La vista con los detalles dol producto de correspondiente ID.
     */
    @GetMapping("/detailsProductoffer/{id}")
    public String details(@PathVariable int id, Model model) {
        ProductofferEntity productoffer = productofferService.details(id);
        model.addAttribute("productoffer", productoffer);
        return "productoffer/detailsProductoffer";
    }

    @GetMapping("/createProductoffer")
    public String getCreate(Model model) {
        model.addAttribute("productoffer", new ProductofferEntity());
        List<MunicipiosEntity> municipios = municipiosService.listarMunicipios();
        model.addAttribute("municipios",municipios);
        List<ProvinciasEntity> provincias = provinciasService.listarProvincias();
        model.addAttribute("provincias",provincias);
        return "productoffer/createProductoffer";
    }
    @PostMapping("/createProductoffer")
    public String postCreate(@ModelAttribute ProductofferEntity productoffer,  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productoffer", productoffer);
            return "productoffer/createProductoffer";
        }
        productofferService.create(productoffer);
        return "redirect:/productoffer";
    }


}
