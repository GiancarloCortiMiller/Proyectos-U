/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Giancarlo
 */
public class Producto {

    ArrayList<RegistroCategoria> categorias = new ArrayList<>();
    ArrayList<RegistroProducto> productos = new ArrayList<>();

    public Producto(ArrayList<RegistroCategoria> _categorias, ArrayList<RegistroProducto> _productos) {
        this.categorias = _categorias;
        this.productos = _productos;
    }

    public void productoM() {
        String opcion;
        int opcionInt = 0;
        boolean esNumerico;
        JOptionPane.showMessageDialog(null, "Bienvenido al Ingreso de Productos");
        do {
            esNumerico = true;
            JOptionPane.showMessageDialog(null, "1- Ingresar productos" + "\n" + "2- Regresar");
            opcion = JOptionPane.showInputDialog("Digite su opcion del menu de ingreso de productos: ");

            try {
                opcionInt = Integer.parseInt(opcion);
            } catch (NumberFormatException a) {
                esNumerico = false;
            }

            if (esNumerico) {
                if (opcionInt < 1 || opcionInt > 2) {
                    JOptionPane.showMessageDialog(null, "Esa opción no es válida, volverás al menú del prodcuto");
                } else {
                    switch (opcionInt) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Ingresando productos");
                            if (categorias.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No hay categorías registradas. Registre una categoría primero.");
                                return;
                            }

                            String categoriasDisponibles = "";
                            for (int i = 0; i < categorias.size(); i++) {
                                categoriasDisponibles += (i + 1) + ". " + categorias.get(i).getNombre() + "\n";
                            }

                            int categoriaSeleccionada = 0;
                            esNumerico = false;
                            do {
                                esNumerico = true;
                                try {
                                    categoriaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la categoría:\n" + categoriasDisponibles));
                                    if (categoriaSeleccionada < 1 || categoriaSeleccionada > categorias.size()) {
                                        JOptionPane.showMessageDialog(null, "Categoría no válida. Por favor, seleccione una categoría de la lista.");
                                        esNumerico = false;
                                    }
                                } catch (NumberFormatException e) {
                                    esNumerico = false;
                                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número.");
                                }
                            } while (!esNumerico);

                            RegistroCategoria categoria = categorias.get(categoriaSeleccionada - 1);
                            String productosDisponibles = "";
                            for (int i = 0; i < productos.size(); i++) {
                                if (productos.get(i).getId_Categoria() == categoria.getNumero())
                                    productosDisponibles += (i + 1) + ". " + productos.get(i).getNombre() + "\n";
                            }
                            
                            if (productosDisponibles.equals("")) {
                                JOptionPane.showMessageDialog(null, "No hay productos registrados para esa categoria");
                                return;
                            }
                            
                            int productoSeleccionado = 0;
                            esNumerico = false;
                            do {
                                esNumerico = true;
                                try {
                                    productoSeleccionado = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el producto:\n" + productosDisponibles));
                                    if (productoSeleccionado < 1 || productoSeleccionado > productos.size()) {
                                        JOptionPane.showMessageDialog(null, "Producto no válida. Por favor, seleccione un producto de la lista.");
                                        esNumerico = false;
                                    }
                                } catch (NumberFormatException e) {
                                    esNumerico = false;
                                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número.");
                                }
                            } while (!esNumerico);
                            RegistroProducto producto = productos.get(productoSeleccionado - 1);
                            if (producto != null) {
                                JOptionPane.showMessageDialog(null, "Producto: " + producto.getNombre() + ", Cantidad actual: " + producto.getCantidad());
    
                                boolean cantidadValida = false;
                                int nuevosProductos = 0;
    
                                do {
                                    try {
                                        nuevosProductos = Integer.parseInt(JOptionPane.showInputDialog("Ingresar nueva cantidad:\n"));
                                        if (nuevosProductos < 0) {
                                            JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativa. Por favor, ingrese un número positivo.");
                                        } else {
                                            cantidadValida = true; // Si no hay excepción y la cantidad es válida, salimos del bucle
                                        }
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Cantidad no válida. Por favor, ingrese un número entero.");
                                    }
                                } while (!cantidadValida);
    
                                producto.setCantidad(producto.getCantidad() + nuevosProductos);
                                JOptionPane.showMessageDialog(null, "Producto: " + producto.getNombre() + ", Cantidad actual: " + producto.getCantidad());
                            }
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Regresando al menú principal");
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esa opción no es válida, volverás al menú del producto");
            }
        } while (opcionInt != 2);
    }
}
