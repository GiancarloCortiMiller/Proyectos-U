/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Giancarlo
 */
public class Registro {
    ArrayList<RegistroCategoria> categorias;
    ArrayList<RegistroProducto> productos;
    public Registro(ArrayList<RegistroCategoria> _categorias, ArrayList<RegistroProducto> _productos) {
        this.categorias =  _categorias;
        this.productos = _productos;
    }

    public void registroM() {
        String opcion;
        int opcionInt = 0;
        boolean esNumerico;

        JOptionPane.showMessageDialog(null, "Bienvenido al Registro");

        do {
            esNumerico = true;
            JOptionPane.showMessageDialog(null, "1- Registrar Nuevo Producto" + "\n" + "2- Registrar una Categoria" + "\n" + "3- Regresar");
            opcion = JOptionPane.showInputDialog("Digite su opción del menú Registro:");

            try {
                opcionInt = Integer.parseInt(opcion);
            } catch (NumberFormatException a) {
                esNumerico = false;
            }

            if (esNumerico) {
                if (opcionInt < 1 || opcionInt > 3) {
                    JOptionPane.showMessageDialog(null, "Esa opción no es válida, volverás al menú de Registro");
                } else {
                    switch (opcionInt) {
                        case 1:
                            registrarProducto();
                            break;
                        case 2:
                            registrarCategoria();
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Regresando al menú principal");
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esa opción no es válida, volverás al menú de Registro");
            }
        } while (opcionInt != 3);
    }

    private void registrarProducto() {
        if (categorias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay categorías registradas. Registre una categoría primero.");
            return;
        }

        String categoriasDisponibles = "";
        for (int i = 0; i < categorias.size(); i++) {
            categoriasDisponibles += (i + 1) + ". " + categorias.get(i).getNombre() + "\n";
        }
        
        int categoriaSeleccionada = 0;
        boolean esNumerico = false;
        
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
        
        String nombreProducto = JOptionPane.showInputDialog("Digite el nombre del producto:");
        
        // Verificar si el producto ya existe en la categoría
        RegistroProducto productoExistente = null;
        for (RegistroProducto producto : productos) {
            if (producto.getNombre().equals(nombreProducto)) {
                productoExistente = producto;
                break;
            }
        }
        
        if (productoExistente != null) {
            JOptionPane.showMessageDialog(null,"Producto ya existente"); 

        } else {
            int precioProducto = 0;
            do {
                esNumerico = true;
                try {
                    precioProducto = Integer.parseInt(JOptionPane.showInputDialog("Digite el precio del producto:"));
                } catch (NumberFormatException e) {
                    esNumerico = false;
                    JOptionPane.showMessageDialog(null, "Precio no válido. Por favor, ingrese un número.");
                }
            } while (!esNumerico);

            int cantidadProducto = 0;
            do {
                esNumerico = true;
                try {
                    cantidadProducto = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad del producto:"));
                } catch (NumberFormatException e) {
                    esNumerico = false;
                    JOptionPane.showMessageDialog(null, "Cantidad no válida. Por favor, ingrese un número.");
                }
            } while (!esNumerico);

            RegistroProducto nuevoProducto = new RegistroProducto(nombreProducto, precioProducto, cantidadProducto, categoria.getNumero());

            int opcionSiNo = 0;
            do {
                esNumerico = true;
                try {
                    opcionSiNo = Integer.parseInt(JOptionPane.showInputDialog("Desea registrar este producto\n1-SI\n2-NO"));
                    if (opcionSiNo != 1 && opcionSiNo != 2) {
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese 1 para sí o 2 para no.");
                        esNumerico = false;
                    }
                } catch (NumberFormatException e) {
                    esNumerico = false;
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese 1 para sí o 2 para no.");
                }
            } while (!esNumerico);
            
            if (opcionSiNo == 1) {
            productos.add(nuevoProducto);
            JOptionPane.showMessageDialog(null, "Producto registrado exitosamente.");
            } else {
            JOptionPane.showMessageDialog(null, "Se cancela el registro del producto.");
            }   
        }
    }

    private void registrarCategoria() {
        String nombreCategoria = JOptionPane.showInputDialog("Digite el nombre de la categoría:");
        
        // Verificar si la categoría ya existe
        boolean categoriaRepetida = false;
        for (RegistroCategoria categoria : categorias) {
            if (categoria.getNombre().equals(nombreCategoria)) {
                categoriaRepetida = true;
                break;
            }
        }
        
        if (categoriaRepetida) {
            JOptionPane.showMessageDialog(null, "La categoría '" + nombreCategoria + "' ya está registrada.");
            return;
        }

        int numeroCategoria = 0;
        boolean esNumerico = false;

        do {
            esNumerico = true;
            try {
                numeroCategoria = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de la categoría:"));
            } catch (NumberFormatException e) {
                esNumerico = false;
                JOptionPane.showMessageDialog(null, "Número no válido. Por favor, ingrese un número.");
            }
        } while (!esNumerico);

        RegistroCategoria nuevaCategoria = new RegistroCategoria(nombreCategoria, numeroCategoria);

        int opcionSiNoCat = 0;
        do {
            esNumerico = true;
            try {
                opcionSiNoCat = Integer.parseInt(JOptionPane.showInputDialog("Desea registrar esta categoría\n1-SI\n2-NO"));
                if (opcionSiNoCat != 1 && opcionSiNoCat != 2) {
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese 1 para sí o 2 para no.");
                    esNumerico = false;
                }
            } catch (NumberFormatException e) {
                esNumerico = false;
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese 1 para sí o 2 para no.");
            }
        } while (!esNumerico);

        if (opcionSiNoCat == 1) {
            categorias.add(nuevaCategoria);
            JOptionPane.showMessageDialog(null, "Categoría registrada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Se cancela el registro de la categoría.");
        }
    }
}