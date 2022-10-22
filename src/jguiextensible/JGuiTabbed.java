/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Component;
import javax.swing.JTabbedPane;

/**
 *
 * Clase derivada de JGuiExtensible que genera una interfaz grafica de
 * navegacion mediante pestañas.
 * 
 * @author a31r1z
 * @see JGuiExtensible
 */
public class JGuiTabbed extends JGuiExtensible {

    private static final long serialVersionUID = 1L;   
    private final JTabbedPane jTabbedPanel;
   
    /**
     * Constructor protegido. Devuelve una interfaz grafica de navegacion mediante pestañas.  
     * 
     */
  public  JGuiTabbed() {
      
     super();
  
     jTabbedPanel= new JTabbedPane();
     
  }
  
  /**
   * Metodo interno polimorfico para insertar una gui en otra.
   * Sobreescribe el metodo de JGuiExtensible.
   * 
   * @param gui gui que se inserta.
   */
   @Override
  protected void insertJGui(JGuiExtensible gui) {
  
     jTabbedPanel.addTab(gui.getName(),gui);
     
     jTabbedPanel.setSelectedIndex(0);
     
     super.add(jTabbedPanel);
  
  }      
   
    /**
     * Sobreescribe el metodo de adicion de la clase base.
     * 
     * @param comp componente que se quiere añadir
     * @return el componente añadido al JTabbedPanel.
     */
  @Override
  public Component add (Component comp) {
  
  jTabbedPanel.addTab(comp.getName(), comp);
  
  return super.add(jTabbedPanel);
  }
  
}
