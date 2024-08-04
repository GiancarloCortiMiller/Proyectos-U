/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giancarlo
 */
public class RegistroCategoria {
    private String nombre;
    private int numero;

    public RegistroCategoria(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Categoría: " + nombre + ", Número: " + numero;
    }
}