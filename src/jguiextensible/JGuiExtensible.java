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
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Base class of the hierarchy of reusable Guis.
 * 
 * @author a31r1z
 */
public class JGuiExtensible extends JPanel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**
     * List of children guis
     */
    protected ArrayList <JGuiExtensible> JGuiChildrenList; 
    /**
     * Added guis counter
     */
    protected int guiCount;
    private boolean wrapper=false;
    
    /**
     * Base class constructor. Boxlayout as default layout.
     */  
    public JGuiExtensible() {
      
      guiCount = 1;         
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      this.JGuiChildrenList = new ArrayList<>();
      
      
    }
    
    /**
     * Adds a gui child to the gui.
     * 
     * @param gui gui added.
     */  
    public void addJGui (JGuiExtensible gui) {
         
        JGuiChildrenList.add(gui);
            
        JGestor.getInstance().addJGuiListener(this);
        JGestor.getInstance().addJGuiListener(gui);
        
        insertJGui(gui);
        
    }
    
    /**
     * Adds a list of guis children to the gui. 
     * 
     * @param childrenList gui children list added. 
     */
    public void addJGuiChildrenList (List<JGuiExtensible> childrenList) {
        
        JGuiChildrenList.addAll(childrenList);
        
        JGestor.getInstance().addJGuiListener(this);
        JGestor.getInstance().addAllJGuiListeners(childrenList);
        
        insertJGuiList(childrenList);
                
    }
    
    /**
     * Insert one gui into another
     * 
     * @param gui gui que se inserta
     */
    protected void insertJGui(JGuiExtensible gui) {
       
        add(gui);
    }
    
    /**
     * Insert one gui list into another
     * 
     * @param childrenList gui list that is added
     */
    protected void insertJGuiList(List<JGuiExtensible> childrenList) {
        
        childrenList.forEach((var gui)-> { 
                   
            insertJGui(gui);          
        });             
    }
   
    /**
     * Validates the data entered in the gui. Method to be implemented by developer.
     * 
     * @return true o false if the validation is achieved.
     * @throws UnsupportedOperationException if the method is not implemented.
     */
    protected boolean validateData () { 
        
      throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
     }
    
    /**
     * Saves the data entered in the gui. Method to be implemented by developer.
     * 
     * @throws UnsupportedOperationException if the method is not implemented.
     */
    protected void saveData() {
        
          throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
    }
    
    /**
     * Cleans the data entered in the gui. Method to be implemented by developer.
     * 
     * @throws UnsupportedOperationException if the method is not implemented.
     */
    protected void cleanData() {
        
          throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");        
    }
    
    /**
     * Warns the rest of guis that an event has been throwed. Notifies the component that has throwed the event
     * and the change value.
     * 
     * @param id identifies the component that throws the event
     * @param value change value.
     */
    protected final void notifyChanges (String id, Object value) {
        
        JGestor.getInstance().notifyChanges (id, value);
    }
    
    /**
     * Updates the componentes that are listening for an event.
     * Method to be implemented by developer.
     * The arguments are the identifier of the component that has activated the event and the change value.
     *
     * @param id identifier of the component that has activated the event.
     * @param value change value.
     * @throws UnsupportedOperationException if the method is not implemented.
     */
    protected void updateChanges(String id, Object value) {
       
         throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");     
     }
   
    /**
     * It determines if the gui is an empty gui that wraps other guis.
     * 
     * @return true o false if it is an empty gui.  
     */
    protected boolean isWrapper() {
        
        return wrapper;
    }
    
    /**
     * Sets the gui as an empty gui or designed gui.
     * 
     * @param bool true is an empty gui, false is a designed gui.
     */
    protected void setWrapper(boolean bool) {
        
        guiCount=0;
        wrapper=bool;
    }
    
    /**
     * Overwrites the method of th Object class
     * 
     * @return gui´s name
     */
     @Override
    public String toString() {
        
        return getName();
    }
}
