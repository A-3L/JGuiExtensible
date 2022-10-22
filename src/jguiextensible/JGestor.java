/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase gestora de la edicion y la comunicacion entre guis.
 * 
 * @author a31r1z
 */ 
final class JGestor {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Booleanos para gestionar la validacion de edicion
     */
    private boolean exit;
    private boolean valido;
    /**
     * Lista de guis oyentes.
     */
    private final ArrayList <JGuiExtensible> jGuiListeners = new ArrayList<>();
    /**
     * Instancia de JGestor
     */
    private static JGestor instance;
    
    /**
     * Constructor privado.Singleton.
     */
    private JGestor() {
    
    }
    
    /**
     * Metodo sincronizado para acceder a la instancia de JGestor.Si la instancia no se ha creado previamente se crea.
     * 
     * @return una unica instancia de JGestor. 
     */
    protected synchronized static JGestor getInstance() {
    
    return (instance==null) ? instance= new JGestor() : instance;
    
    }
    
    /**
     * Añade una gui a la lista de oyentes.
     * 
     * @param gui gui que se añade a la lista de oyentes. 
     */
    protected void addJGuiListener(JGuiExtensible gui) {
        
        if(!jGuiListeners.contains(gui))
        jGuiListeners.add(gui);
    }
    
    /**
     * Añade una lista de guis a la lista de guis oyentes.
     * 
     * @param childrenList lista de guis que se añade a la lista de guis oyentes.
     */
    protected void addAllJGuiListeners(List<JGuiExtensible> childrenList) {
        
        childrenList.forEach((var gui)-> {
              addJGuiListener(gui);
        });
   
    }
    
    /**
     * Notifica a la lista de guis oyentes que se ha producido un evento, indicando el componente que lo ha provocado y 
     * el valor de cambio.
     * 
     * @param id identificador del componente que ha activado el evento.
     * @param value valor de cambio.
     */
    protected void notifyChanges (String id, Object value) {
          
           System.out.println("LISTENERS: "+ jGuiListeners);
         jGuiListeners.forEach((var gui) -> {
         
         if(!gui.isWrapper()) gui.updateChanges(id, value);
         
         }); 
    }
    
    /**
     * Activa el proceso de validacion y almacenamiento de los datos editados en la gui.Si los datos son validados se da la opcion de guardar los datos, limpiar los datos introducidos o cancelar.
     * 
     * @param gui gui que se quiere validar. 
     */
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
    
    /**
     * Valida los datos de edicion que se han introducido en cada una de las guis reusables
     * 
     * @param gui gui que se quiere validar
     * @return true o false si la validacion es correcta.
     */
    protected boolean validateEdition(JGuiExtensible gui) {
       
        valido=true;
        
            if(!gui.isWrapper()) valido = gui.validateData();
            exit=valido;
            
                for (var elem: gui.JGuiChildrenList) {
                   
                  if(!valido) break;
                                 
                  exit= validateEdition(elem);                         
                }
        
        return exit;      
    }
     
    /**
     * Guarda la edicion de los datos introducidos en cada una de las guis reusables.
     * 
     * @param gui gui de la que se quiere guardar los datos. 
     */
    protected void saveEdition(JGuiExtensible gui) {
    
        if(!gui.isWrapper()) gui.saveData();
        
        gui.JGuiChildrenList.forEach((var elem) -> {
           
            saveEdition(elem); 
            
        });
    }
   
    /**
     * Limpia los datos introducidos en la edicion de cada una de las guis.
     * 
     * @param gui gui de la que se quiere limpiar la edicion. 
     */
    protected void cleanEdition(JGuiExtensible gui ) {
        
        if(!gui.isWrapper()) gui.cleanData();
        
        gui.JGuiChildrenList.forEach(elem -> {
           
            cleanEdition(elem);
            
        });
    } 
}
