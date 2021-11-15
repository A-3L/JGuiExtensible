/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JGuiExtensible extends JPanel {

    private static final long serialVersionUID = 1L;
    
      List<JGuiExtensible> listaDeGuis = new ArrayList<>();
   
 
    public JGuiExtensible() {
        
        setBackground(Color.GREEN);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
         setBorder(BorderFactory.createCompoundBorder(
                   BorderFactory.createLineBorder(Color.red),
                   this.getBorder()));
        
    }
    
     public boolean setUpDialog() {
        
        boolean ret= false;
        
        
        return ret;
    }
    
    public void addExtensibleChild (JGuiExtensible child) {
       
        listaDeGuis.add(child);
        insertGui(child);
        setSize(); 
       
    }
    
    public void addExtensibleChildrenList (List<JGuiExtensible> childrenList) {
        
        insertGuiList(childrenList, this);
    }
    
    protected void insertGui(JGuiExtensible child) {
        
       add(child);             
    }
    
    protected void insertGuiList(List<JGuiExtensible> childrenList, JGuiExtensible parent) {
        
          childrenList.forEach((var gui)-> { 
            
            insertGui(gui);               
        });             
    }
    
    protected void setSize() {
        
    }
    
}
