/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Giancarlo
 */
public class Inventario {

    public String producto;
    public int cantidad;

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
                            JOptionPane.showMessageDialog(null, "Viendo Inventario Completo");
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
}
         
         
         
         
         
         
         
         
         
         

