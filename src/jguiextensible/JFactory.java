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

import java.awt.BorderLayout;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Factory class to create graphical user interfaces of diferent types. 
 * 
 * @author a31r1z
 */
public class JFactory implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**
     * Reusable gui
     */
    private JGuiExtensible gui;
    
    /**
     * JFactory instance.
     */
    private static JFactory instance;
    
    /**
     * Private constructor.Singleton.
     */  
    private JFactory() {
        
    } 
    
    /**
    * Synchronized method to get the instance of JFactory.
    * If the instance has not been created it creates it.
    *
    *@return a single instance of JFactory 
    *
    */
    
    public synchronized static JFactory getInstance() {
        
        return (instance==null) ? instance = new JFactory() : instance;
    }
    
    /**
     * Returns a dialog of tipoGui type.
     * If gui must wear edition buttons, the withButtons parameter must be true, also it must be false.
     * 
     * @param tipoGui the gui type to create. 
     * @param withButtons true: gui cwith buttons, false: gui without buttons. 
     * @return a gui of the selected typ. With or without buttons.
     */
    
    public JGuiExtensible createDialog(JTipoGui tipoGui, boolean withButtons) {
        
        switch (tipoGui) {
            
            case SIMPLE -> gui = new JGuiSimple();
            case TABBED -> gui = new JGuiTabbed();
            case TREE   -> gui = new JGuiTree();
            default -> throw new AssertionError (tipoGui.name());
        }
        
        if (withButtons) {
         
            gui.setLayout(new BorderLayout());
            gui.add(panelBtns(gui), BorderLayout.PAGE_END ); 
           
      }
        gui.setWrapper(true);
        
        return gui;
     }
     /**
      * Internal method to create one panel with ok and cancel buttons on the bottom.
      * 
      * @param gui reusable gui to include in the panel.
      * @return one panel with Ok and Cancel buttons.
      */
    
     private JPanel panelBtns(JGuiExtensible gui) {
        
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("CANCEL");
        JPanel panel = new JPanel(); 
        
        btnOk.addActionListener((var event) -> {
           
            System.out.println("HELLO BABY");
            
            JGestor.getInstance().processEdition(gui);
            
            System.out.println("END of EDITION");
        });
         
        btnCancel.addActionListener((var event) -> {
                   
            System.out.println("BYE BYE BABY");
            
            JGestor.getInstance().cleanEdition(gui);
            
            System.out.println("EXIT");
            System.exit(0);
             
        });
         
        panel.add(btnOk);
        panel.add(btnCancel);
        
        return panel;
    }
    
}
