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
public interface Observer {

    void actualizarClima(String mensaje, List<Informacion> paneles);

}
