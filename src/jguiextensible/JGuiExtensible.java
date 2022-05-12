 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JGuiExtensible extends JPanel {

    private static final long serialVersionUID = 1L;
 
  
    List <JGuiExtensible> listaDeGuis = new ArrayList<>();
    static List <JGuiExtensible> listeners = new ArrayList<>();
    
    private boolean exit;
    private boolean valido;
    
    
    public JGuiExtensible() {
        
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      listeners.add(this);
       
    }
       
    public void addExtensibleChild (JGuiExtensible gui) {
            
        listaDeGuis.add(gui);
        
        insertGui(gui);
        
    }
 
    public void addExtensibleChildrenList (List<JGuiExtensible> childrenList) {
        
        listaDeGuis.addAll(childrenList);
        
        insertGuiList(childrenList);
    }
    
    protected void insertGui(JGuiExtensible gui) {
       
        add(gui);
    }
    
    protected void insertGuiList(List<JGuiExtensible> childrenList) {
        
          childrenList.forEach((var gui)-> { 
            
            insertGui(gui);          
        });             
    }
   
    protected boolean validarEdicion(JGuiExtensible gui) {
                       
        exit=true;
        valido=false;
      
        for (JGuiExtensible elem :gui.listaDeGuis) {
    
            valido= validarEdicion(elem);
    
            if(!exit) break;
    
            if(!gui.validarDatos() || !elem.validarDatos()) {
               
                exit= false;
                valido=false;
                break;
            }else  
                valido=true;
            }
    
        System.out.println("VALIDACION REALIZADA");
        System.out.println(valido);
         
        return valido;
    }
   
    protected boolean validarDatos() { 
        
     //  throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
     return true;
     }
 
    protected void guardarEdicion(JGuiExtensible gui) {
        
        gui.guardarDatos();
        
        gui.listaDeGuis.forEach(elem -> {
            guardarEdicion(elem);
        });
    }
    
    protected void guardarDatos() {
        
        //  throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
    }
    
    protected void limpiarEdicion(JGuiExtensible gui ) {
        
        gui.limpiarDatos();
        
        gui.listaDeGuis.forEach(elem -> {
            limpiarEdicion(elem);
        });
    }
    
    protected void limpiarDatos() {
        
        //  throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");        
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
     
    protected void notificarCambio(String id, Object value) {
          
          System.out.println(listeners);
    
          listeners.forEach((var gui) -> {
              
              gui.actualizarCambio(id, value);
             
        });  
    }
    
    protected void actualizarCambio(String id, Object value) {
     
    //  throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
         
     }
    
    @Override
    public String toString() {
        
        return getName();
    }
 
    /*  @Override
    public Insets getInsets() {
    
    return new Insets(6,0,0,0);
    
    } */
}
