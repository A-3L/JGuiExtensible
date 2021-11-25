/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import javax.swing.JTabbedPane;

/**
 *
 * @author a31r1z
 */
public class JGuiTabbed extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
    
      JTabbedPane jtabbedPanel;

  public JGuiTabbed() {
      
      jtabbedPanel = new JTabbedPane();
            
  }
  
  @Override
  protected void insertGui(JGuiExtensible gui) {
        
        super.insertGui(gui);
        jtabbedPanel.add(gui);
    }    
    
    
}
