/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author a31r1z
 */
public class JFactory {
    
    private JGuiExtensible gui;
    private static JFactory instance;
     
    private JFactory() {
        
    } 
    
    public synchronized static JFactory getInstance() {
        
        return (instance==null)? instance= new JFactory(): instance;
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
        gui.setWrapper(true);
        return gui;
     }
     
     private JPanel panelBtns(JGuiExtensible gui) {
        
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("CANCEL");
        JPanel panel = new JPanel(); 
        
        btnOk.addActionListener((var event) -> {
           
            System.out.println("HELLO BABY");
            
            gui.processEdition(gui);
            
            System.out.println("END of EDITION");
        });
         
        btnCancel.addActionListener((var event) -> {
                   
            System.out.println("BYE BYE BABY");
            
            gui.cleanEdition(gui);
            
            System.out.println("EXIT");
            System.exit(0);
             
        });
         
        panel.add(btnOk);
        panel.add(btnCancel);
        
        return panel;
    }
    
}
