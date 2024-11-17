/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;
import java.util.List;
import visual.Informacion;

/**
 *
 * @author Xavier Siguachi
 */
public class SujetoConcreto implements Sujeto {

    private List<Observer> listObserver = new ArrayList<>();

    public List<Observer> getListObserver() {
        return listObserver;
    }

    @Override
    public void registrarObserver(Observer observer) {
        listObserver.add(observer);
    }

    @Override
    public void eliminarObserver(Observer observer) {
        listObserver.remove(observer);
    }

    @Override
    public void notificarObserver(double temp, List<Informacion> paneles) {
        for (Observer observer : listObserver) {
            if (observer != null) {
                observer.actualizarClima(generarMensajeClima(temp), paneles);
            }
        }
    }

    private String generarMensajeClima(double temp) {
        String mensaje;
        if (temp < 10) {
            mensaje = "La temperatura es de Fría: " + temp + "°C";
        } else if (temp < 20) {
            mensaje = "La temperatura es de Templado: " + temp + "°C";
        } else if (temp < 30) {
            mensaje = "La temperatura es de Cálido: " + temp + "°C";
        } else {
            mensaje = "La temperatura es de Caluroso: " + temp + "°C";
        }
        return mensaje;
    }

}
