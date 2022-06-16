/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JGuiSimple extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
    
    private JPanel panel;
    private int guiCount=0;
    
    public JGuiSimple() {
       
       super();
       panel=new JPanel();
       panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
       
    }
      
    @Override
    public void insertGui(JGuiExtensible gui){
         
        panel.add(gui);
        super.add(panel);
        
        guiCount++;
        if(guiCount>2) {
        
        JOptionPane.showMessageDialog(null,"ATENCION: SOLO SE PERMITEN "
                       + "INTEGRAR DOS GUIS DE TIPO SIMPLE");
         
        throw new UnsupportedOperationException("ATENCION: SOLO SE PERMITEN INTEGRAR DOS GUIS DE TIPO SIMPLE " );
      
        }   
      }
     
    }
     
  
    
    
   
    
   

