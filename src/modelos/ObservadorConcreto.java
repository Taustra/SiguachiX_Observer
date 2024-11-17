/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.List;
import visual.GestionPersonas;
import visual.Informacion;

/**
 *
 * @author Xavier Siguachi
 */
//Observador Concreto
public class ObservadorConcreto implements Observer {

    private int codigo;
    private String nombre;

    public ObservadorConcreto(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void actualizarClima(String mensaje, List<Informacion> paneles) {
        for (Informacion panelActual : paneles) {
            if (panelActual.getLabelSuscrito().getText() == "si") {
                panelActual.getLabelTemperatura().setText(mensaje);
            }
        }
    }
}
