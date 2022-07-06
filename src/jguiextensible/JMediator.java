/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author a31r1z
 */ 
final class JMediator {
    
    private static final long serialVersionUID = 1L;
    
    private boolean exit;
    private boolean valido;
    
    private final ArrayList <JGuiExtensible> jGuiListeners = new ArrayList<>();
    private static JMediator instance;
    
    
    private JMediator() {
    
    }
    
    protected synchronized static JMediator getInstance() {
    
    return (instance==null) ? instance= new JMediator() : instance;
    
    }
     
    protected void addJGuiListener(JGuiExtensible gui) {
        
        if(!jGuiListeners.contains(gui))
        jGuiListeners.add(gui);
    }
    
    protected void addAllJGuiListeners(List<JGuiExtensible> childrenList) {
        
        childrenList.forEach((var gui)-> {
              addJGuiListener(gui);
        });
   
    }
    
    protected void notifyChanges (String id, Object value) {
          
           System.out.println("LISTENERS: "+ jGuiListeners);
         jGuiListeners.forEach((var gui) -> {
         
         if(!gui.isWrapper() ) gui.updateChanges(id, value);
         
         }); 
    }
      
    protected void processEdition (JGuiExtensible gui) {
          
        if(validateEdition(gui)) {
            
            var option = JOptionPane.showInternalConfirmDialog(null,"Guardar Datos");
            
            switch (option) {
                
                case JOptionPane.NO_OPTION -> cleanEdition(gui);
                case JOptionPane.YES_OPTION -> saveEdition(gui);
                case JOptionPane.CANCEL_OPTION -> { }
            }     
        }   
    } 
     
    protected boolean validateEdition(JGuiExtensible gui) {
       
        valido=true;
        
            if(!gui.isWrapper()) valido = gui.validateData();
            exit=valido;
            
                for (var elem: gui.listaDeGuis) {
                   
                  if(!valido) break;
                                 
                  exit= validateEdition(elem);                         
                }
        
        return exit;      
    }
       
    protected void saveEdition(JGuiExtensible gui) {
    
        if(!gui.isWrapper()) gui.saveData();
        
        gui.listaDeGuis.forEach((var elem) -> {
           
            saveEdition(elem); 
            
        });
    }
   
     protected void cleanEdition(JGuiExtensible gui ) {
        
        if(!gui.isWrapper()) gui.cleanData();
        
        gui.listaDeGuis.forEach(elem -> {
           
            cleanEdition(elem);
            
        });
    } 
}
