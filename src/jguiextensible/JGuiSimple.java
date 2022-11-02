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
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * Class that extends JGuiExtensible class.
 * Creates a simple graphical user interface.
 * 
 * @author a31r1z
 * @see JGuiExtensible
 */

public class JGuiSimple extends JGuiExtensible implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private final JPanel panel;
   
   /**
    * Protected constructor. 
    * Returns a simple graphical user interface. 
    */   
    
    protected JGuiSimple() {
       
       super();
       panel=new JPanel();
       panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
     
    }
    
    /**
     * Adds a gui to the simple gui.Only two simple guis are allowed. 
     * 
     * @param gui gui to add.
     * @throws UnsupportedOperationException if more than two simple gui are going to add.
     */  
    @Override
    protected void insertJGui(JGuiExtensible gui){
      
        panel.add(gui);
        super.add(panel);
       
        guiCount++;
        if(guiCount>2) {
        
        JOptionPane.showMessageDialog(null,"ATENCION: SOLO SE PERMITEN "
                       + "INTEGRAR DOS GUIS DE TIPO SIMPLE");
         
        throw new UnsupportedOperationException("ATENCION: SOLO SE PERMITEN INTEGRAR DOS GUIS DE TIPO SIMPLE " );
      
        }   
    }
}
     
  
    
    
   
    
   

