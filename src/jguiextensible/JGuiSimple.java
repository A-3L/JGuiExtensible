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

/**
 *
 * @author a31r1z
 */
public class JGuiSimple extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
      
      public JGuiSimple() {
     
          setBackground(Color.PINK); 
          setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
          add(Box.createHorizontalGlue());
      
    }
    
    @Override
    protected void insertGui(JGuiExtensible gui) {
     
      add(gui);
               
    }
    
}
