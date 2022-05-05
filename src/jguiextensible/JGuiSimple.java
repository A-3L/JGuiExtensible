/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JGuiSimple extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
      
    private  JPanel panel;
    
    public JGuiSimple() {
       
       super();
       
       panel = new JPanel();
       panel. setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
       
    }
      
    public void insertGui(JGuiExtensible gui){
         
         panel.add(gui);
         super.add(panel);
           
          if(panel.getComponentCount()>2) {
        
        JOptionPane.showMessageDialog(null,"ATENCION: SOLO SE PERMITEN "
                       + "INTEGRAR DOS GUIS DE TIPO SIMPLE");
        System.err.println("ATENCION: SOLO SE PERMITEN INTEGRAR DOS GUIS DE TIPO SIMPLE " );
        System.exit(0);
        }
         
    }
   
    /*  @Override*/
      /*  public Component add(Component comp) {
      
      panel.add(comp);
      super.add(panel);
      System.out.println(comp);
      System.out.println(comp.getParent());
      
      return panel;
      
      }*/
    }
     
  
    
    
   
    
   

