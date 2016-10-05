/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.rmi.registry.Registry;

/**
 *
 * @author Rodrigo e Jordan
 */
public class Reserva extends Registro {
    
    private InterfaceCli interfaceCli;

    public InterfaceCli getInterfaceCli() {
        return interfaceCli;
    }

    public void setInterfaceCli(InterfaceCli interfaceCli) {
        this.interfaceCli = interfaceCli;
    }

}
