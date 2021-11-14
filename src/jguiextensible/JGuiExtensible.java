/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JGuiExtensible extends JPanel {

    private static final long serialVersionUID = 1L;
    
      List<JGuiExtensible> listaDeGuis = new ArrayList<>();
      JPanel panel = new JPanel();
   
 
    public JGuiExtensible() {
        
        setBackground(Color.GREEN);
        
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
    
    /*  protected JGuiExtensible insertPanel(JGuiExtensible parent, JGuiExtensible child) {
    
    panel.add(child);
    panel.add(parent);
    
    return (JGuiExtensible)panel;
    }*/
    
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
