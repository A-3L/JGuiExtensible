/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Component;
import javax.swing.JTabbedPane;

/**
 *
 * @author a31r1z
 */
public class JGuiTabbed extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
    
    private final JTabbedPane jTabbedPanel;
    
     

  public JGuiTabbed() {
      
     super();
  
     jTabbedPanel= new JTabbedPane();
   
     //super.add(jTabbedPanel);
    
  }
  
   @Override
  protected void insertGui(JGuiExtensible gui) {
  
     jTabbedPanel.addTab(gui.getName(),gui);
     
     jTabbedPanel.setSelectedIndex(0);
     
     super.add(jTabbedPanel);
  
  }      
   
    /**
     *
     * @param comp
     * @return 
     */
    @Override
  public Component add (Component comp) {
 
     jTabbedPanel.addTab(comp.getName(), comp);
     
    return super.add(jTabbedPanel);
  }
}
