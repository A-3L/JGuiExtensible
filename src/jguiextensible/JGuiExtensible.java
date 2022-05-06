 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

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
 
  
    private List <JGuiExtensible> listaDeGuisHijas = new ArrayList<>();
    private static List <JGuiExtensible> listaDeGuis = new ArrayList<>();
    
    private boolean exit;
    private boolean valido;
    
    private JGuiExtensible parent;
    private JGuiExtensible root;
    
    public JGuiExtensible() {
        
       setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
       listaDeGuis.add(this);
       
    }
       
    public void addExtensibleChild (JGuiExtensible gui) {
       
        listaDeGuisHijas.add(gui);
             
        insertGui(gui);
            
    }
    
    public void addExtensibleChildrenList (List<JGuiExtensible> childrenList) {
        
        listaDeGuisHijas.addAll(childrenList);
        
        insertGuiList(childrenList);
    }
    
    protected void insertGui(JGuiExtensible child) {
       
       // listaDeGuis.addAll(listaDeGuisHijas);
            
    }
    
    protected void insertGuiList(List<JGuiExtensible> childrenList) {
        
          childrenList.forEach((var gui)-> { 
            
            insertGui(gui);          
        });             
    }
   
    protected boolean validarEdicion(JGuiExtensible gui) {
          System.out.println(gui.listaDeGuisHijas);
          System.out.println(gui+ " GUIVALIDAR");
               
        exit=true;
        valido=false;
      
        for (JGuiExtensible elem :gui.listaDeGuisHijas) {
    
              System.out.println("Validar " + elem);
    
            valido= validarEdicion(elem);
    
            if(!exit) break;
    
            if(!gui.validarDatos() || !elem.validarDatos()) {
                System.out.println("Validando "+gui+" o " +elem );
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
     
     return true;
     }
 
    protected void guardarEdicion(JGuiExtensible gui) {
        
        gui.guardarDatos();
        
        gui.listaDeGuisHijas.forEach(elem -> {
            
            guardarEdicion(elem);
        });
    }
    
    protected void guardarDatos() {
    
    }
    
    protected void limpiarEdicion(JGuiExtensible gui ) {
        
        gui.limpiarDatos();
        
        gui.listaDeGuisHijas.forEach(elem -> {
            limpiarEdicion(elem);
        });
    }
    
    protected void limpiarDatos() {
            
    }
    
    protected void procesarEdicion(JGuiExtensible gui) {
        
        if(validarEdicion(gui)) {
            
            var option = JOptionPane.showInternalConfirmDialog(null,"Guardar Datos");
            switch (option) {
                case JOptionPane.NO_OPTION :  
                    limpiarEdicion(gui);
                    break; 
                case JOptionPane.YES_OPTION:  
                    guardarEdicion(gui);  
                    break;
                case JOptionPane.CANCEL_OPTION:              
                    break;
            }     
        }   
    } 
     
    protected void notificarCambio(String id, Object value) {
          
          System.out.println(listaDeGuis);
          
          listaDeGuis.forEach((var gui) -> {
              
              gui.actualizarCambio(id, value);
             
        });  
    }
    
    protected void actualizarCambio(String id, Object value) {
     
        // throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
    
     }
    
    @Override
    public String toString() {
        
        return getName();
    }
 
     
}
