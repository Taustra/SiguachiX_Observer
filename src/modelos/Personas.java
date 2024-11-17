/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Siguachi
 */
public class Personas {

    private List<ObservadorConcreto> listPersonas = new ArrayList<>();

    public List<ObservadorConcreto> getListPersonas() {
        return listPersonas;
    }

    public void registrarPersona(ObservadorConcreto persona) {
        listPersonas.add(persona);
    }

    public void eliminarPersona(ObservadorConcreto persona) {
        listPersonas.remove(persona);
    }

    public ObservadorConcreto buscarPersona(int codigo) {
        for (ObservadorConcreto personaActual : listPersonas) {
            if (personaActual.getCodigo() == codigo) {
                return personaActual;
            }
        }
        return null;
    }

}
