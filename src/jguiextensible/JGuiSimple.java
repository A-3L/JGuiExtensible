/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Color;
import javax.swing.BoxLayout;

/**
 *
 * @author a31r1z
 */
public class JGuiSimple extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
      
      public JGuiSimple() {
     
          setBackground(Color.PINK); 
          setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
    }
    
    @Override
    protected void insertGui(JGuiExtensible gui) {
        
      add(gui);
               
    }
    
}
