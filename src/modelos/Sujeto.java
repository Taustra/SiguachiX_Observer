/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.List;
import visual.Informacion;

/**
 *
 * @author Xavier Siguachi
 */
public interface Sujeto {

    void registrarObserver(Observer observer);

    void eliminarObserver(Observer observer);

    void notificarObserver(double temp, List<Informacion> paneles);

}
