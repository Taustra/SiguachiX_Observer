/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import visual.Informacion;
/**
 *
 * @author Xavier Siguachi
 */
public class Tests {

    SujetoConcreto notificadorObservers = new SujetoConcreto();
    Personas personas = new Personas();
    List<Informacion> panelesInformacion = new ArrayList<>();
    Informacion panelInf = new Informacion();
    int x = 50;
    int y = 50;

    // Metodos para registrar a las personas en distintas listas dependiendo de su estado (si|no)
    public void registrarObserver(Observer obs) {
        notificadorObservers.registrarObserver(obs);
    }

    public Observer registrarPersona(int cod, String nombre, String estado) {

        if (buscarObserver(cod) == null && personas.buscarPersona(cod) == null) {

            if (estado == "si") {
                Observer p1 = new ObservadorConcreto(cod, nombre);
                registrarObserver(p1);
                System.out.println("Persona observadora registrada");
                return p1;

            } else {
                ObservadorConcreto pp1 = new ObservadorConcreto(cod, nombre);
                resgistrarPersonas(personas, pp1);
                System.out.println("Persona no observadora registrada");
                return pp1;
            }
        } else {
            return null;
        }

    }

    //metodo que solo dispone los datos en el cuadro
    public Informacion crearPanel(Observer o) {

        panelInf = new Informacion();
        //captura de información

        int codigo = Integer.parseInt(Main.getvPrincipal().getTxtCodigo().getText());

        String nombre = Main.getvPrincipal().getTxtNombre().getText();
        String estado = (String) Main.getvPrincipal().getComboBoxEstado().getSelectedItem();
        //Disponer los datos en el panel que contienen  información
        panelInf.getLabelCodigo().setText(String.valueOf(codigo));
        panelInf.getLabelNombre().setText(nombre);
        panelInf.getLabelSuscrito().setText(estado);
        if (estado == "no") {
            panelInf.getLabelTemperatura().setText("No hay notificación");
        }

        return panelInf;
    }

    //metodo que muestra el cuadro con los datos
    public void mostrarPanel(Informacion panelInf) {
        panelesInformacion.add(panelInf);
        panelInf.setSize(550, 114);
        panelInf.setLocation(x, y);
        y += 120;

        Main.getvPrincipal().getjPanelInformacion().add(panelInf, BorderLayout.CENTER);
        Main.getvPrincipal().getjPanelInformacion().revalidate();
        Main.getvPrincipal().getjPanelInformacion().repaint();

    }

   
    //metodo que nos sirve para buscar a una persona
    public void recuperarDatos() {

        int cod = Integer.parseInt(Main.getvPrincipal().getTxtCodigo().getText());

        if (buscarObserver(cod) != null) {

            Main.getvPrincipal().getTxtNombre().setText(buscarObserver(cod).getNombre());
            Main.getvPrincipal().getComboBoxEstado().setSelectedItem("si");
        } else if (personas.buscarPersona(cod) != null) {
            Main.getvPrincipal().getTxtNombre().setText(personas.buscarPersona(cod).getNombre());
            Main.getvPrincipal().getComboBoxEstado().setSelectedItem("no");
        } else {
            JOptionPane.showMessageDialog(null, "No existe la persona");
        }
    }

    public ObservadorConcreto buscarObserver(int cod) {
        List<Observer> listObserver = notificadorObservers.getListObserver();

        for (Observer observer : listObserver) {
            ObservadorConcreto obs = (ObservadorConcreto) observer;

            if (observer == null) {
                JOptionPane.showMessageDialog(null, "No hay Observadores en la lista");
            } else if (obs.getCodigo() == cod) {
                return obs;
            }
        }
        return null;
    }

    //metodo para actualizar el estado suscrito de una persona
    public void actualizar(int codigo, String nuevoEstado) {

        if (nuevoEstado == "no") {
            personas.getListPersonas().add(buscarObserver(codigo));
            notificadorObservers.getListObserver().remove(buscarObserver(codigo));
            for (Informacion panelActual : panelesInformacion) {
                if (Integer.parseInt(panelActual.getLabelCodigo().getText()) == codigo) {
                    panelActual.getLabelSuscrito().setText("no");
                    panelActual.getLabelTemperatura().setText("No hay notificación");
                }
            }
        } else {
            notificadorObservers.getListObserver().add(personas.buscarPersona(codigo));
            personas.getListPersonas().remove(personas.buscarPersona(codigo));
            for (Informacion panelActual : panelesInformacion) {
                if (Integer.parseInt(panelActual.getLabelCodigo().getText()) == codigo) {
                    panelActual.getLabelSuscrito().setText("si");
                }
            }
        }
    }

    //Metodo para notificar temperatura, pero también sirve para la sincronización
    public void notificarObservadores(int valor) {

        notificadorObservers.notificarObserver(valor, panelesInformacion);

    }

    public void resgistrarPersonas(Personas pers, ObservadorConcreto p) {
        pers.registrarPersona(p);
    }

}
