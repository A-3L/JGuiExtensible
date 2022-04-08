 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author a31r1z
 */
public class JGuiExtensible extends JPanel {

    private static final long serialVersionUID = 1L;

  
    
     private static final List<JGuiExtensible> listaDeGuis = new ArrayList<>();
     private List<JGuiExtensible> listaDeGuisHijas = new ArrayList<>();
     
     int height=0, width=0;
   
     
      
    public JGuiExtensible() {
        
       setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
       //listaDeGuis.add(this);
       //setPreferredSize(new Dimension(600,400));
 
    }
       
    public void addExtensibleChild (JGuiExtensible gui) {
             
        listaDeGuis.add(gui);
        
        insertGui(gui);
       
    }
    
    public void addExtensibleChildrenList (List<JGuiExtensible> childrenList) {
              
        insertGuiList(childrenList);
    }
    
    protected void insertGui(JGuiExtensible child) {
       
       // listaDeGuis.addAll(listaDeGuisHijas);
            
    }
    
    protected void insertGuiList(List<JGuiExtensible> childrenList) {
        
          childrenList.forEach((var gui)-> { 
            
            insertGui(gui);          
        });             
    }
   
    protected void validar() {
        
        listaDeGuis.forEach((var gui)-> { 
            
           if (gui.validacion()) System.out.println("Validar");
                 
        });
          System.out.println("Validacion realizada");
    } 
   
    protected boolean validacion() {
        
        return true;
    }
    
    
     protected void notificarCambio(String id, Object obj) {
            
         listaDeGuis.forEach((var gui) -> {
                      
               gui.actualizarCambio(id,obj);    
         });      
    }
     
    protected void actualizarCambio(String id, Object obj) {
    
      // throw new UnsupportedOperationException("Metodo a completar x Diseñador de GUIS");
        
    }
    
    @Override
    public String toString() {
        
        return getName();
    }
 
     
}
