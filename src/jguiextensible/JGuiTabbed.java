/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;

/**
 *
 * @author a31r1z
 */
public class JGuiTabbed extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
    
      JTabbedPane jtabbedPanel;
     

  public JGuiTabbed() {
      
      super();
      jtabbedPanel= new JTabbedPane();
      add(jtabbedPanel);
      setBackground(Color.BLUE);
        
  }
  
  @Override
  protected void insertGui(JGuiExtensible gui) {
              
        jtabbedPanel.add(gui);
        
        System.out.println("En GuiTab");
          
    }    
    
    
}
