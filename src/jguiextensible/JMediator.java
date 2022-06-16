/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author a31r1z
 */ 
final class JMediator {
    
    private static final long serialVersionUID = 1L;
    
    private boolean exit;
    private boolean valido;
    
    private final static ArrayList <JGuiExtensible> listeners = new ArrayList<>();
   

    protected JMediator() {
        
    }
    
    protected void addJGuiListener(JGuiExtensible gui) {
        
        if(!listeners.contains(gui))
        listeners.add(gui);
    }
    
     protected void notificarCambio(String id, Object value) {
          
        System.out.println("LISTENERS: "+ listeners);
          listeners.forEach((var gui) -> {
          
              if(!gui.isEmpty() ) gui.actualizarCambio(id, value);
          
          }); 
    }
    
    protected void procesarEdicion(JGuiExtensible gui) {
          
        if(validarEdicion(gui)) {
            
            var option = JOptionPane.showInternalConfirmDialog(null,"Guardar Datos");
            
            switch (option) {
                
                case JOptionPane.NO_OPTION -> limpiarEdicion(gui);
                case JOptionPane.YES_OPTION -> guardarEdicion(gui);
                case JOptionPane.CANCEL_OPTION -> { }
            }     
        }   
    } 
     
       protected boolean validarEdicion(JGuiExtensible gui) {
       
        valido=true;
        
            if(!gui.isEmpty()) valido=gui.validarDatos();
            exit=valido;
            
                for (var elem: gui.listaDeGuis) {
                   
                  if(!valido) break;
                                 
                  exit= validarEdicion(elem);                         
                }
        
        return exit;      
    }
       
    protected void guardarEdicion(JGuiExtensible gui) {
    
        if(!gui.isEmpty()) gui.guardarDatos();
        
        gui.listaDeGuis.forEach((var elem) -> {
           
            guardarEdicion(elem); 
            
        });
    }
   
     protected void limpiarEdicion(JGuiExtensible gui ) {
        
        if(!gui.isEmpty()) gui.limpiarDatos();
        
        gui.listaDeGuis.forEach(elem -> {
           
            limpiarEdicion(elem);
            
        });
    }
     
  
    
}
