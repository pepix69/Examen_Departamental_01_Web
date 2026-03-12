package com.UPIIZ.examen1.models;

import java.time.LocalDate;

public class Pedido {
    private int id;
    private LocalDate fecha;
    private String estado;
    private double total;

    public Pedido() {}

    public Pedido(int id, LocalDate fecha, String estado, double total){
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
