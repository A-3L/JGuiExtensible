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
import javax.swing.JTabbedPane;

/**
 *
 * Class that extends JGuiExtensible class.
 * Creates a tab graphical user interface.
 * 
 * @author a31r1z
 * @see JGuiExtensible
 */
public class JGuiTabbed extends JGuiExtensible implements Serializable{

    private static final long serialVersionUID = 1L;   
    private final JTabbedPane jTabbedPanel;
   
    /**
     * Protected constructor. 
     * Returns a tab graphical user interface.  
     * 
     */
  protected  JGuiTabbed() {
      
     super();
  
     jTabbedPanel= new JTabbedPane();
   
  }
  
  /**
   * Internal method to insert one gui into another.
   * OvrWrites the method of JGuiExtensible.
   * 
   * @param gui gui inserted.
   */
   @Override
  protected void insertJGui(JGuiExtensible gui) {
  
     jTabbedPanel.addTab(gui.getName(),gui);
     
     jTabbedPanel.setSelectedIndex(0);
     
     super.add(jTabbedPanel);
  
  }      
  
}
