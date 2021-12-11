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
          setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
          
          panel = new JPanel();
          panel. setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
                    
    }
    
    @Override
    protected void insertGui(JGuiExtensible gui){
    
        System.out.println(gui);
        setSizeByComponents(gui);
      panel.add(gui);
      //panel.add(Box.createHorizontalGlue());
     
      
        if(panel.getComponentCount()>2) {
      System.err.println("ATENCION: SOLO SE PERMITEN INTEGRAR DOS GUIS DE TIPO SIMPLE");
      System.exit(0);
      }
       
      System.out.println(panel.getComponentCount());
      setSizeByComponents(gui);
      
      add(panel); 
           //setSizeByComponents(gui);
           //setMinimumSize(panel.getMinimumSize());
    }
    private void setSizeByComponents(JGuiExtensible gui) {
        
        int heightPanel, widthPanel ;
        Insets insets = panel.getInsets();
        System.out.println(insets+"Insets");
              
        heightPanel = panel.getMinimumSize().height;
        widthPanel = panel.getMinimumSize().width;
              
        if (heightPanel > height) height=heightPanel;
        if (widthPanel > width) width=widthPanel;
        
        setMinimumSize(new Dimension(width,height));
    }
    
}
