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
    private int j=1;
            
          
  public JGuiTabbed() {
      
     super();
  
     jTabbedPanel= new JTabbedPane();
     
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
  
  super.add(jTabbedPanel);
  
  return jTabbedPanel;
  }
  
  /*   @Override
  public void addImpl(Component comp, Object constraints, int i) {
  
  String name= "tab"+j;
  j++;
  
  jTabbedPanel.addTab(name, comp);
  
  super.addImpl(jTabbedPanel, BoxLayout.X_AXIS, i);
  }*/
}
