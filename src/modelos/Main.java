/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import visual.GestionPersonas;

/**
 *
 * @author Xavier Siguachi
 */
public class Main {

    // Creación de una única instancia de ventana
    private static GestionPersonas vPrincipal = new GestionPersonas();

    // para poder interactuar con la ventana desde otras clases
    public static GestionPersonas getvPrincipal() {
        return vPrincipal;
    }

    public void mostrarVentana() {
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);
    }

    public static void main(String[] args) {
        Main mainApp = new Main();
        mainApp.mostrarVentana();
    }

}
