/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;

/**
 *
 * @author a31r1z
 */
public class JGuiTabbed extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
    
      JTabbedPane jTabbedPanel;
     

  public JGuiTabbed() {
      
      super();
     
      jTabbedPanel= new JTabbedPane();
                                                                                           
  }
  
   @Override
  protected void insertGui(JGuiExtensible gui) {
  
    jTabbedPanel.addTab(gui.getName(),gui);
  
    super.add(jTabbedPanel);
  
  }     
   
     @Override
  public Component add (Component comp) {
      
    jTabbedPanel.addTab(comp.getName(), comp);
    super.add(jTabbedPanel);
    
    return  this;
  }
}
