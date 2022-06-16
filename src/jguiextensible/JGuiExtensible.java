 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JGuiExtensible extends JPanel {

    private static final long serialVersionUID = 1L;
 
  
    protected ArrayList <JGuiExtensible> listaDeGuis;
   
    private boolean emptyGui=false;
    private final JMediator mediator;
    
    
    public JGuiExtensible() {
                
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      this.mediator = new JMediator();
      this.listaDeGuis = new ArrayList<>();
         
    }
       
    public void addExtensibleChild (JGuiExtensible gui) {
         
        listaDeGuis.add(gui);
            
        mediator.addJGuiListener(this);
        mediator.addJGuiListener(gui);
             
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
   
    protected final void procesarEdicion(JGuiExtensible gui) {
          
        mediator.procesarEdicion(gui);
    } 
    
    protected final boolean validarEdicion(JGuiExtensible gui) {
           
        return mediator.validarEdicion(gui);
    }
   
    protected boolean validarDatos() { 
        
      throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
     }
 
    protected final void guardarEdicion(JGuiExtensible gui) {
        
        mediator.guardarEdicion(gui);
    }
    
    protected void guardarDatos() {
        
          throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
    }
    
    protected final void limpiarEdicion(JGuiExtensible gui ) {
        
        mediator.limpiarEdicion(gui);
    }
    
    protected void limpiarDatos() {
        
          throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");        
    }
      
    protected final void notificarCambio(String id, Object value) {
        
        mediator.notificarCambio(id, value);
    }
    
    protected void actualizarCambio(String id, Object value) {
       
         throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");     
     }
   
    protected boolean isEmpty() {
        
        return emptyGui;
    }
    
    protected void setEmpty(boolean bool) {
        
        emptyGui=bool;
    }
    
    @Override
    public String toString() {
        
        return getName();
    }
}
