/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gianc
 */
public class PROYECTO {
    public static void main(String[] args) {
        String opcion;
        int opcionINT = 0;
        boolean esNumerico;
        ArrayList<RegistroCategoria> categorias = new ArrayList<>();
        ArrayList<RegistroProducto> productos = new ArrayList<>();

        JOptionPane.showMessageDialog(null, "Bienvenido a Farmacia La Esperanza");

        do {
            esNumerico = true;
            JOptionPane.showMessageDialog(null, "1-Registro" + "\n" + "2- Ingresar Productos" 
                + "\n" + "3- Editar precio" + "\n" + "4- Ver inventario completo" + "\n" + "5- Salir");
            opcion = JOptionPane.showInputDialog("Digite su opción del menú principal:");

            try {
                opcionINT = Integer.parseInt(opcion);
            } catch (NumberFormatException a) {
                esNumerico = false;
            }

            if (esNumerico) {
                if (opcionINT < 1 || opcionINT > 5) {
                    JOptionPane.showMessageDialog(null, "Su opción no es válida, volverá al menú principal");
                } else {
                    switch (opcionINT) {
                        case 1:
                            Registro registro1 = new Registro(categorias, productos);
                            registro1.registroM();
                            break;
                        case 2:
                            Producto producto1 = new Producto(categorias, productos);
                            producto1.productoM();
                            break;
                        case 3:
                            Precio precio1 = new Precio(categorias, productos);
                            precio1.precioM();
                            break;
                        case 4:
                            Inventario inventario1 = new Inventario();
                            inventario1.inventarioM();
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Adiós!");
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Su opción no es válida, volverá al menú principal");
            }
        } while (opcionINT != 5);
    }
}

    
 
                    
            
        
    
    

              
        
        
 


