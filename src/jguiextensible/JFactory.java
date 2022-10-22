/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase factoria para la creacion de guis. 
 * 
 * @author a31r1z
 */
public class JFactory {
    
    /**
     * Gui reusable
     */
    private JGuiExtensible gui;
    
    /**
     * Instancia de JFactory.
     */
    private static JFactory instance;
    
    /**
     * Constructor privado.Singleton.
     */  
    private JFactory() {
        
    } 
    
    /**
    * Metodo sincronizado para acceder a la instancia de JFactory.Si la instancia no se ha creado previamente se crea.
    *
    *@return una unica instancia de JFactory 
    *
    */
    
    public synchronized static JFactory getInstance() {
        
        return (instance==null) ? instance = new JFactory() : instance;
    }
    
    /**
     * Devuelve un dialogo del tipo tipoGui. Si el dialogo debe llevar botones de edicion, el parametro withButtons debe ser true. Si el dialogo debe crearse sin botones el parametor withButtons debe ser false.
     * 
     * @param tipoGui el tipo de gui a crear 
     * @param withButtons true: gui con botones, false: gui sin botones. 
     * @return una gui del tipo escogido. Con o sin botones.
     */
    
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
     /**
      * Metodo interno para crear un panel con los botones Ok y Cancel en la parte inferior.
      * 
      * @param gui gui reusable para incluir en el panel con botones
      * @return un panel con botones OK y Cancel
      */
    
     private JPanel panelBtns(JGuiExtensible gui) {
        
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("CANCEL");
        JPanel panel = new JPanel(); 
        
        btnOk.addActionListener((var event) -> {
           
            System.out.println("HELLO BABY");
            
            JGestor.getInstance().processEdition(gui);
            
            System.out.println("END of EDITION");
        });
         
        btnCancel.addActionListener((var event) -> {
                   
            System.out.println("BYE BYE BABY");
            
            JGestor.getInstance().cleanEdition(gui);
            
            System.out.println("EXIT");
            System.exit(0);
             
        });
         
        panel.add(btnOk);
        panel.add(btnCancel);
        
        return panel;
    }
    
}
