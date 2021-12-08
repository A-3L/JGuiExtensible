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
    
     public JGuiExtensible createDialog(JTipoGui tipoGui) {
        
        switch (tipoGui) {
            
            case SIMPLE -> gui = new JGuiSimple();
            case TABBED -> gui = new JGuiTabbed();
            case TREE   -> gui = new JGuiTree();
            default -> throw new AssertionError (tipoGui.name());
        }
        gui.setLayout(new BorderLayout());
        gui.add(panelBtns(gui), BorderLayout.SOUTH );
        
        return gui;
    }
     
     /*    private JFrame crearFrame(JGuiExtensible gui) {
     
     JFrame frame;
     frame= new JFrame();
     
     frame.add(gui, BorderLayout.CENTER);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     frame.add(panelBtns(gui),BorderLayout.SOUTH);
     frame.pack();
     frame.setLocationRelativeTo(null);
     frame.setVisible(true);
     frame.setMinimumSize(frame.getMinimumSize());
     
     System.out.println(frame.getMinimumSize()+"frame minim");
     System.out.println(frame.getContentPane().getMinimumSize()+"ContentPane tras Pack");
     System.out.println(frame.getPreferredSize()+"frame prefer");
     
     return frame;
     
     }*/
   
     private JPanel panelBtns(JGuiExtensible gui) {
        
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("CANCEL");
        JPanel panel = new JPanel(); 
        
        btnOk.addActionListener((ActionEvent e) -> {
            String st= new String("HELLO BABY");
            
            //gui.notificar(st);
        });
         
        btnCancel.addActionListener((ActionEvent e) -> {
                    
            String st= new String("BYE BYE BABY");
            
          //  gui.notificar(st);
        });
         
        panel.add(btnOk);
        panel.add(btnCancel);
        
        return panel;
    }
    
}
