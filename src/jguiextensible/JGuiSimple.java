/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JGuiSimple extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
      
     JPanel panel; 
      
      public JGuiSimple() {
     
          super();
          setBackground(Color.PINK);
          panel = new JPanel();
          panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
          add(panel);
          
      
    }
    
    @Override
    protected void insertGui(JGuiExtensible gui) {
     
      panel.add(gui);
      panel.add(Box.createHorizontalGlue());
               
    }
    
}
