/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JGuiSimple extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
    
    
    
      public JGuiSimple() {
     
          setBackground(Color.PINK); 
          setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
         // setLayout(new GridLayout(1,0));
    }
    
    @Override
    protected void insertGui(JGuiExtensible gui) {
        
       super.insertGui(super.insertPanel(this, gui));
             
    }
    
}
