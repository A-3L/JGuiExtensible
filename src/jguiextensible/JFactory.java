/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JFactory {
    
    JGuiExtensible panel;
     
    public JFactory() {
        
    } 
    
     public JGuiExtensible createDialog(JTipoGui tipoGui) {
        
        switch (tipoGui) {
            
            case SIMPLE -> panel = new JGuiSimple();
            case TABBED -> panel = new JGuiTabbed();
            case TREE   -> panel = new JGuiTree();
            default -> throw new AssertionError (tipoGui.name());
        }
        
        panel.setLayout(new BorderLayout());
        
        JPanel panelBtns = insertBtns();
        
        panel.add(panelBtns, BorderLayout.SOUTH);
         
        return panel;
    }
     private JPanel insertBtns() {
        
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("CANCEL");
        JPanel panelBtns = new JPanel(); 
        
        btnOk.addActionListener((ActionEvent e) -> {
            String st= new String("HELLO BABY");
            
            //jePanel.notificar(st);
        });
         
        btnCancel.addActionListener((ActionEvent e) -> {
                    
            String st= new String("BYE BYE BABY");
            
          //  jePanel.notificar(st);
        });
         
        panelBtns.add(btnOk);
        panelBtns.add(btnCancel);
        
        return panelBtns;
    }
    
}
