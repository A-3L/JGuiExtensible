/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JGuiExtensible extends JPanel {

    private static final long serialVersionUID = 1L;
    
      List<JGuiExtensible> listaDeGuis = new ArrayList<>();
 
    public JGuiExtensible() {
        
          super();
          setBackground(Color.PINK);
          setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
            
    }
    
     public boolean setUpDialog() {
        
        boolean ret= false;
        
        
        return ret;
    }
    
    public void addExtensibleChild (JGuiExtensible child) {
       
        listaDeGuis.add(child);
      
        insertGui(child);
        
    }
    
    public void addExtensibleChildrenList (List<JGuiExtensible> childrenList) {
              
        insertGuiList(childrenList, this);
    }
    
    protected void insertGui(JGuiExtensible child) {
     
       add(child);
          System.out.println("Pasox jge.insertGui");
    }
    
    protected void insertGuiList(List<JGuiExtensible> childrenList, JGuiExtensible parent) {
        
          childrenList.forEach((var gui)-> { 
            
            insertGui(gui);          
        });             
    }
    
     public String toString() {
       
        return this.getName();
    }
}
