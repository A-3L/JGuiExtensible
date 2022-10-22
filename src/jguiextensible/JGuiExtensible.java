 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Clase base de la jerarquia de guis reusables.
 * 
 * @author a31r1z
 */
public class JGuiExtensible extends JPanel {

    private static final long serialVersionUID = 1L;
    
    /**
     * Lista de guis hijas
     */
    protected ArrayList <JGuiExtensible> JGuiChildrenList; 
    /**
     * Contador de guis añadidas
     */
    protected int guiCount;
    private boolean wrapper=false;
    
    /**
     * Constructor de la clase base. Boxlayout como layout por defecto,
     */  
    public JGuiExtensible() {
      
      guiCount = 1;         
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      this.JGuiChildrenList = new ArrayList<>();
      
    }
    
    /**
     * Añade una gui hija a la gui.
     * 
     * @param gui gui que se añade.
     */  
    public void addJGui (JGuiExtensible gui) {
         
        JGuiChildrenList.add(gui);
            
        JGestor.getInstance().addJGuiListener(this);
        JGestor.getInstance().addJGuiListener(gui);
        
        insertJGui(gui);
        
    }
    
    /**
     * Añade una lista de guis hijas a la gui 
     * @param childrenList lista de hijas que se añade
     */
    public void addJGuiChildrenList (List<JGuiExtensible> childrenList) {
        
        JGuiChildrenList.addAll(childrenList);
        
        JGestor.getInstance().addJGuiListener(this);
        JGestor.getInstance().addAllJGuiListeners(childrenList);
        
        insertJGuiList(childrenList);
                
    }
    
    /**
     * Inserta una gui en otra.
     * 
     * @param gui gui que se inserta
     */
    protected void insertJGui(JGuiExtensible gui) {
       
        add(gui);
    }
    
    /**
     * Inserta una lista de guis en otra.
     * 
     * @param childrenList lista de guis que se inserta
     */
    protected void insertJGuiList(List<JGuiExtensible> childrenList) {
        
        childrenList.forEach((var gui)-> { 
                   
            insertJGui(gui);          
        });             
    }
   
    /**
     * Valida los datos introducidos en la gui.Metodo a instanciar por el desarrollador.
     * 
     * @return true o false si la validacion ha tenido exito
     * @throws UnsupportedOperationException si se implementa el metodo.
     */
    protected boolean validateData () { 
        
      throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
     }
    
    /**
     * Guarda los datos introducidos en la gui.Metodo a instanciar por el desarrollador.
     * 
     * @throws UnsupportedOperationException si el metodo no se implementa.
     */
    protected void saveData() {
        
          throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");
    }
    
    /**
     * Limpia los datos introducidos en los componentes de la gui. Metodo a instanciar por el desarrollador.
     * 
     * @throws UnsupportedOperationException si el metodo no se implementa.
     */
    protected void cleanData() {
        
          throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");        
    }
    
    /**
     * Avisa al resto de guis que se ha producido un evento, indicando el componente que lo ha provocado y el valor de cambio.
     * 
     * @param id identificador del componente que activo el evento.
     * @param value valor de cambio.
     */
    protected final void notifyChanges (String id, Object value) {
        
        JGestor.getInstance().notifyChanges (id, value);
    }
    
    /**
     * Actualiza los componentes que estan esperando por un evento.Metodo a implementar por el desarrollador. Se le pasa el identificador del componente que ha activado el evento y el valor de cambio.
     *
     * @param id identificador del componente que ha activado el evento
     * @param value valor de cambio.
     * @throws UnsupportedOperationException si el metodo no se implementa.
     */
    protected void updateChanges(String id, Object value) {
       
         throw new UnsupportedOperationException("Metodo a implementar x Diseñador de GUIS");     
     }
   
    /**
     * Determina si la gui es una gui vacia que funciona como envoltorio de otras guis.
     * 
     * @return true o false si es una gui vacia.  
     */
    protected boolean isWrapper() {
        
        return wrapper;
    }
    
    /**
     * Configura la gui estableciendo si es una gui vacia o una gui diseñada.
     * 
     * @param bool true es gui vacia, false es gui diseñada.
     */
    protected void setWrapper(boolean bool) {
        
        guiCount=0;
        wrapper=bool;
    }
    
    /**
     * Sobreescribe el metodo de la clase Object
     * @return el nombre de la gui
     */
     @Override
    public String toString() {
        
        return getName();
    }
}
