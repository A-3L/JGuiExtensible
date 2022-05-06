/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JFactory {
    
    JGuiExtensible panel,gui;
     
    public JFactory() {
        
    } 
    
     public JGuiExtensible createDialog(JTipoGui tipoGui, boolean withButtons) {
        
        switch (tipoGui) {
            
            case SIMPLE -> gui = new JGuiSimple();
            case TABBED -> gui = new JGuiTabbed();
            case TREE   -> gui = new JGuiTree();
            default -> throw new AssertionError (tipoGui.name());
        }
        
        if (withButtons) {
         
            gui.setLayout(new BorderLayout());
            gui.add(panelBtns(gui), BorderLayout.PAGE_END ); 
           
      }
        
        return gui;
     }
     
     private JPanel panelBtns(JGuiExtensible gui) {
        
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("CANCEL");
        JPanel panel = new JPanel(); 
        
        btnOk.addActionListener((ActionEvent event) -> {
            String st= new String("HELLO BABY");
            System.out.println(st);
            gui.procesarEdicion(gui);
            System.out.println(" FIN de EDICION");
        });
         
        btnCancel.addActionListener((ActionEvent event) -> {
                    
            String st= new String("BYE BYE BABY");
            System.out.println(st);
            gui.limpiarEdicion(gui);
            System.exit(0);
             
        });
         
        panel.add(btnOk);
        panel.add(btnCancel);
        
        return panel;
    }
    
}
