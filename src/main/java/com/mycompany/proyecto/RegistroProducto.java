/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Giancarlo
 */
public class RegistroProducto {
    private String nombre;
    private int precio;
    private int cantidad;
    private int id_categoria;

    public RegistroProducto(String nombre, int precio, int cantidad, int id_categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_Categoria() {
        return id_categoria;
    }

    public void setId_Categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setPrecio(int _precio) {
        this.precio = _precio;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad;
    }

}
