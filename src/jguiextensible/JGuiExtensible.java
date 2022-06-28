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
    
   
    private boolean wrapper=false;
    private transient final JMediator mediator;
    
    
    public JGuiExtensible() {
               
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      this.listaDeGuis = new ArrayList<>();
      this.mediator = JMediator.getInstance();
      
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
   
    protected final void processEdition (JGuiExtensible gui) {
          
        mediator.processEdition(gui);
    } 
    
    protected final boolean validateEdition (JGuiExtensible gui) {
           
        return mediator.validateEdition(gui);
    }
   
    protected boolean validateData () { 
        
      throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
     }
 
    protected final void saveEdition (JGuiExtensible gui) {
        
        mediator.saveEdition(gui);
    }
    
    protected void saveData() {
        
          throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
    }
    
    protected final void cleanEdition(JGuiExtensible gui ) {
        
        mediator.cleanEdition(gui);
    }
    
    protected void cleanData() {
        
          throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");        
    }
      
    protected final void notifyChanges (JGuiExtensible gui, String id, Object value) {
        
        mediator.notifyChanges (id, value);
    }
    
    protected void updateChanges(String id, Object value) {
       
         throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");     
     }
   
    protected boolean isWrapper() {
        
        return wrapper;
    }
    
    protected void setWrapper(boolean bool) {
        
        wrapper=bool;
    }
    
     @Override
    public String toString() {
        
        return getName();
    }
}
