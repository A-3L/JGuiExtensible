/** 
 * JGuiExtensible is a library that provides the necessary classes to implement
 * a reusable graphical user interface pattern
 * 
 * Copyright (C) 2022 a31r1z
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jguiextensible;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Management class for edition and communication between Guis.
 * 
 * @author a31r1z
 */ 
final class JGestor implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Booleans to manage the editing validation.
     */
    private boolean exit;
    private boolean valido;
    /**
     * Listeners gui list.
     */
    private final ArrayList <JGuiExtensible> jGuiListeners = new ArrayList<>();
    /**
     * Instance of JGestor
     */
    private static JGestor instance;
    
    /**
     * Private constructor.Singleton.
     */
    private JGestor() {
    
    }
    
    /**
     * Synchronized method to acces instance of JGestor.If instance has not been created it creates the instance.
     * 
     * @return a single instance of JGestor. 
     */
    protected synchronized static JGestor getInstance() {
    
    return (instance==null) ? instance= new JGestor() : instance;
    
    }
    
    /**
     * Adds a gui to listeners list.
     * 
     * @param gui gui added to listener list. 
     */
    protected void addJGuiListener(JGuiExtensible gui) {
        
        if(!jGuiListeners.contains(gui))
        jGuiListeners.add(gui);
    }
    
    /**
     * Adds a gui list to listeners list.
     * 
     * @param childrenList gui list added to listeners list.
     */
    protected void addAllJGuiListeners(List<JGuiExtensible> childrenList) {
        
        childrenList.forEach((var gui)-> {
              addJGuiListener(gui);
        });
   
    }
    
    /**
     * Notifies to gui listeners list that an event has been activated.
     * It identifies the component that throwed the event and the change value.
     * 
     * @param id identifies the component that has activated the event.
     * @param value change value.
     */
    protected void notifyChanges (String id, Object value) {
          
         jGuiListeners.forEach((var gui) -> {
         
         if(!gui.isWrapper()) gui.updateChanges(id, value);
         
         }); 
    }
    
    /**
     * Activate the process of validation and storage of the data edited in the GUI.If the data are validated, the option of saving the data is given, cleaning the data entered or cancel.
     * 
     * @param gui gui to validate. 
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
     * Validates the edition data that has been entered in every reusable gui.
     * 
     * @param gui gui to validate.
     * @return true o false if validation is wright.
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
     * Saves the edition data that has been entered in every reusable gui.
     * 
     * @param gui gui to save data. 
     */
    protected void saveEdition(JGuiExtensible gui) {
    
        if(!gui.isWrapper()) gui.saveData();
        
        gui.JGuiChildrenList.forEach((var elem) -> {
           
            saveEdition(elem); 
            
        });
    }
   
    /**
     * Cleans the edition data that has been entered in every reusable gui.
     * 
     * @param gui gui to clean data. 
     */
    protected void cleanEdition(JGuiExtensible gui ) {
        
        if(!gui.isWrapper()) gui.cleanData();
        
        gui.JGuiChildrenList.forEach(elem -> {
           
            cleanEdition(elem);
            
        });
    } 
}
