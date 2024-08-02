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
public class Precio {

    public int precio;

    ArrayList<RegistroCategoria> categorias = new ArrayList<>();
    ArrayList<RegistroProducto> productos = new ArrayList<>();

    public Precio(ArrayList<RegistroCategoria> _categorias, ArrayList<RegistroProducto> _productos) {
        this.categorias = _categorias;
        this.productos = _productos;
    }

    
    public void precioM() {
        String opcion;
        int opcionInt = 0;
        boolean esNumerico;

        JOptionPane.showMessageDialog(null, "Bienvenido a la edición de precios");

        do {
            esNumerico = true;
            JOptionPane.showMessageDialog(null, "1- Editar Precio" + "\n" + "2- Regresar");
            opcion = JOptionPane.showInputDialog("Digite su opción del menú de edición de precios:");

            try {
                opcionInt = Integer.parseInt(opcion);
            } catch (NumberFormatException a) {
                esNumerico = false;
            }

            if (esNumerico) {
                if (opcionInt < 1 || opcionInt > 2) {
                    JOptionPane.showMessageDialog(null, "Esa opción no es válida, volverás al menú de edición de precios");
                } else {
                    switch (opcionInt) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Editando precio");
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
                                JOptionPane.showMessageDialog(null, "Producto: " + producto.getNombre() + ", Precio actual: " + producto.getPrecio());
                                boolean precioValido = false;
                                int nuevoPrecio = 0;
    
                                do {
                                    try {
                                        nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio:\n"));
                                        precioValido = true; // Si no hay excepción, el precio es válido
                                    } catch (NumberFormatException e) {
                                         JOptionPane.showMessageDialog(null, "Precio no válido. Por favor, ingrese un número entero.");
                                    }
                                } while (!precioValido);
    
                                producto.setPrecio(nuevoPrecio);
                                JOptionPane.showMessageDialog(null, "Producto: " + producto.getNombre() + ", Nuevo Precio: " + producto.getPrecio());
                            }

                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Regresando al menú principal");
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esa opción no es válida, volverás al menú de edición de precios");
            }
        } while (opcionInt != 2);
    }
}
        
        
        
        
        
        
    
    
    
    

