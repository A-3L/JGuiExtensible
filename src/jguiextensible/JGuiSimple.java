/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import javax.swing.JOptionPane;

/**
 *
 * @author a31r1z
 */
public class JGuiSimple extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
      
    private int jguiCount=0;
    
    public JGuiSimple() {
       
       super();
    
    }
      
    @Override
    public void insertGui(JGuiExtensible gui){
         
        super.insertGui(gui);
        
        jguiCount++;
        if(jguiCount>2) {
        
        JOptionPane.showMessageDialog(null,"ATENCION: SOLO SE PERMITEN "
                       + "INTEGRAR DOS GUIS DE TIPO SIMPLE");
         
        throw new UnsupportedOperationException("ATENCION: SOLO SE PERMITEN INTEGRAR DOS GUIS DE TIPO SIMPLE " );
      
        }   
      }
     
    }
     
  
    
    
   
    
   

