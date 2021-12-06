/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
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
      
    int height=0, width=0; 
    JPanel panel; 
      
      public JGuiSimple() {
     
          super();       
          setBackground(Color.red);
          
          panel = new JPanel();
          panel. setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
          add(panel);
                    
    }
    
    @Override
    protected void insertGui(JGuiExtensible gui) {
     
      panel.add(gui);
      add(Box.createHorizontalGlue());
      
      
      //setSizeByComponents(gui);
      //setMinimumSize(panel.getMinimumSize());
       System.out.println(panel.getMinimumSize());
       System.out.println(getMinimumSize() +"Parent");
    }
    
    private void setSizeByComponents(JGuiExtensible gui) {
        
        int heightPanel, widthPanel ;
       
      
        
        heightPanel = panel.getMinimumSize().height;
        widthPanel = panel.getMinimumSize().width;
        
        
        
        if (heightPanel > height) height=heightPanel;
        if (widthPanel > width) width=widthPanel;
        
        setMinimumSize(new Dimension(width,height));
    }
    
}
