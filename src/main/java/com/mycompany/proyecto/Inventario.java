/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Giancarlo
 */
public class Inventario {

    ArrayList<RegistroCategoria> categorias = new ArrayList<>();
    ArrayList<RegistroProducto> productos = new ArrayList<>();

    public Inventario(ArrayList<RegistroCategoria> _categorias, ArrayList<RegistroProducto> _productos) {
        this.categorias = _categorias;
        this.productos = _productos;

    }

    public void inventarioM() {
        String opcion;
        int opcionInt = 0;
        boolean esNumerico;

        JOptionPane.showMessageDialog(null, "Bienvenido al Inventario");

        do {
            esNumerico = true;
            JOptionPane.showMessageDialog(null, "1-Ver Inventario Completo" + "\n" + "2- Regresar");
            opcion = JOptionPane.showInputDialog("Digite su opción del menú inventario:");

            try {
                opcionInt = Integer.parseInt(opcion);
            } catch (NumberFormatException a) {
                esNumerico = false;
            }

            if (esNumerico) {
                if (opcionInt < 1 || opcionInt > 2) {
                    JOptionPane.showMessageDialog(null, "Esa opción no es válida, volverás al menú del inventario");
                } else {
                    switch (opcionInt) {
                        case 1:
                            mostrarInventario();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Regresando al menú principal");
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esa opción no es válida, volverás al menú del inventario");
            }
        } while (opcionInt != 2);
    }

    private void mostrarInventario() {
        if (categorias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay categorías registradas. Registre una categoría primero.");
            return;
        }

        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados. Registre un producto primero.");
        }

        String categoriasDisponibles = "";
        for (int i = 0; i < categorias.size(); i++) {
            categoriasDisponibles += (i + 1) + ". " + categorias.get(i).getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null,
                "Estas son las categorias disponibles, seleccione la categoria que desea ver para ver los productos que hay junto con su precio."
                        + "\n" + "Categorias:" + "\n" + categoriasDisponibles);

        int categoriaSeleccionada = 0;
        categoriaSeleccionada = Integer
                .parseInt(JOptionPane.showInputDialog("Seleccione la categoría:\n" + categoriasDisponibles));

        RegistroCategoria categoria = categorias.get(categoriaSeleccionada - 1);
     String productosDisponibles = "";
     int cantidad = 1 ;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId_Categoria() == categoria.getNumero())
            {
            productosDisponibles += cantidad + ". " + productos.get(i).getNombre() + "\n";
            cantidad = cantidad + 1;
             }
        }
        

        JOptionPane.showMessageDialog(null, "Productos:" + "\n" + productosDisponibles);
        

    }

}
