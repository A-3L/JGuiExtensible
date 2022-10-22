/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * Clase derivada de JGuiExtensible que genera una interfaz grafica 
 * de una sola pagina. 
 * 
 * @author a31r1z
 * @see JGuiExtensible
 */

public class JGuiSimple extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
    
    private final JPanel panel;
   
   /**
    * Constructor protegido.Devuelve una interfaz grafica de navegacion simple 
    */   
    
    public JGuiSimple() {
       
       super();
       panel=new JPanel();
       panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
     
    }
    
    /**
     * Agrega e integra una GUI a la pagina de navegacion simple.Solo se permite integrar dos GUIs simples. 
     * 
     * @param gui gui a insertar
     * @throws UnsupportedOperationException si se intentan integrar mas de dos paginas de navegacion simple.
     */  
    @Override
    protected void insertJGui(JGuiExtensible gui){
      
        panel.add(gui);
        super.add(panel);
        
        guiCount++;
        if(guiCount>2) {
        
        JOptionPane.showMessageDialog(null,"ATENCION: SOLO SE PERMITEN "
                       + "INTEGRAR DOS GUIS DE TIPO SIMPLE");
         
        throw new UnsupportedOperationException("ATENCION: SOLO SE PERMITEN INTEGRAR DOS GUIS DE TIPO SIMPLE " );
      
        }   
      }
    
    /*   @Override
    public void addImpl(Component comp, Object constraints, int i) {
    this.getLayout().addLayoutComponent(comp.getName(), comp);
    
    
    }*/
    
}
     
  
    
    
   
    
   

