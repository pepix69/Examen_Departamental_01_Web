package com.UPIIZ.examen1.controllers;

import com.UPIIZ.examen1.models.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    List<Pedido> pedidos = new ArrayList<>();

    public PedidoController() {
        pedidos.add(new Pedido(1, LocalDate.now(), "Pendiente", 120.50));
        pedidos.add(new Pedido(2, LocalDate.now(), "Enviado", 200.00));
        pedidos.add(new Pedido(3, LocalDate.now(), "Entregado", 75.30));
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/pedidos";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidos);
        return "lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pedido pedido) {
        pedidos.add(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                model.addAttribute("pedido", p);
                break;
            }
        }
        return "editar";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Pedido pedido) {

        for (Pedido p : pedidos) {
            if (p.getId() == pedido.getId()) {
                p.setFecha(pedido.getFecha());
                p.setEstado(pedido.getEstado());
                p.setTotal(pedido.getTotal());
            }
        }

        return "redirect:/pedidos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model) {

        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                model.addAttribute("pedido", p);
                break;
            }
        }

        return "eliminar";
    }

    @PostMapping("/borrar")
    public String borrar(@RequestParam int id) {
        pedidos.removeIf(p -> p.getId() == id);
        return "redirect:/pedidos";
    }


}
