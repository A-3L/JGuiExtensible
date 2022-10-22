/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * Clase derivada de JGuiExtensible que genera una interfaz grafica de
 * navegacion en estructura de arbol.
 * 
 * @author a31r1z
 * @see JGuiExtensible
 */
public class JGuiTree extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
    
    /**
     * Objetos arbol, panel de desplazamiento y panel dividido para la construccion de la vista
     */
    private JScrollPane jScrollPanel;
    private JSplitPane jSplitPanel;
    private JTree jTree;   
    
    /**
     * Objetos y nodos para la gestion de la insercion de nodos en la estructura de arbol.
     */
    private DefaultMutableTreeNode rootNode, parentNode, nodo,selectedNode ;
    private Object infoNode;
    private Component panelNode;
    /**
     * Modelo de datos del arbol
     */
    private DefaultTreeModel model;
    
    /**
     * Enteros para la configuracion de altura y anchura de la vista
     */
    private int heightRightComponent =0, widthRightComponent=0;
    
    /**
     * Constructor protegido. Devuelve una interfaz grafica de navegacion en estructura de arbol. 
     * 
     */
    public JGuiTree() {
        
        super();
      
        initialize();    
    }
    
    /**
     * Metodo de inicializacion de la gui.
     */
    private void initialize() {
       
       rootNode = new DefaultMutableTreeNode();
       model = new DefaultTreeModel(rootNode);
        
      initJTree();
      initJScrollPanel();
      initJSplitPanel();
     
    }
    
    /**
     * Metodo de inicializacion del arbol.
     */
    private void initJTree() {
         
        jTree = new JTree();
        jTree.setInvokesStopCellEditing(true);
        jTree.setScrollsOnExpand(true);
        
    }
    
    /**
     * Metodo de inicializacion del panel de desplazamiento.
     */
    private void initJScrollPanel() {
        
        jScrollPanel = new JScrollPane();
        jScrollPanel.setViewportView(jTree);  
    }
    /**
     * Metodo de inicializacion del panel dividido.
     */ 
    private void initJSplitPanel() {
        
        jSplitPanel = new JSplitPane();     
        jSplitPanel.setDividerSize(2);
        jSplitPanel.setResizeWeight(0.2); 
        jSplitPanel.setLeftComponent(jScrollPanel);
        
        super.add(jSplitPanel);     
    }
    
    /**
     * Metodo interno polimorfico para insertar una gui en otra.
     * Sobreescribe el metodo de JGuiExtensible.
     * 
     * @param gui guia que se inserta. 
     */
    @Override
    protected void insertJGui(JGuiExtensible gui) {
      
       nodo = new DefaultMutableTreeNode(gui);
           
       insertNode(rootNode,nodo);
      //insert(this, gui);
             
       setDimensions(gui);   
       treeSelectionListener();
      
       super.add(jSplitPanel);  
    } 
    
    /**
     * Metodo interno polimorfico para insertar una lista de guis en otra
     * 
     * @param childrenList lista de guis que se inserta
     */
    @Override
    protected void insertJGuiList(List<JGuiExtensible> childrenList) {
     
        parentNode = new DefaultMutableTreeNode(childrenList.get(0));
        
            insertNode(rootNode,parentNode);
                        
        childrenList.forEach((var gui)->{ 
                     
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(gui); 
            
            insertNode(parentNode, node); 
           
            setDimensions(gui);
             
            super.add(jSplitPanel); 
        });
         
    }
    
    /*  private void insert(JGuiExtensible parent, JGuiExtensible child) {
    
    DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(parent);
    DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(child);
    
    int index= model.getChildCount(node1);
    model.insertNodeInto(node2, node1, index);
    
    if(rootNode.getUserObject()==null) {
    
    jTree.setModel(model);
    rootNode.setUserObject(node2.getUserObject());
    jTree.setSelectionRow(0);
    jSplitPanel.setRightComponent((Component)rootNode.getUserObject());
    }
    
    
    }*/
    
    /**
     * Metodo para la insercion de nodos en la estructura de arbol.
     * 
     * @param parent nodo padre al que se le añade un nodo hijo
     * @param child  nodo hijo que se añade a un nodo padre
     */
    private void insertNode(DefaultMutableTreeNode parent, DefaultMutableTreeNode child) {
            
        int index= model.getChildCount(parent);
        model.insertNodeInto(child, parent, index);
        
        if(rootNode.getUserObject()==null) {
            
            jTree.setModel(model);
            rootNode.setUserObject(child.getUserObject());
            jTree.setSelectionRow(0);
            jSplitPanel.setRightComponent((Component)rootNode.getNextNode().getUserObject());
        }
           
    }
    
    /**
     * Configura las dimensiones minima y preferida del panel dividido en funcion de las guis insertadas.
     * @param gui 
     */
    private void setDimensions(Component gui) {
        
       setLeftComponentMinimumSize();
       setRightComponentMinimumSize(gui);
       setRightComponentPreferredSize(gui);
       
    }
    
    /**
     * Metodo para determinar el nodo seleccionado y lanzar el evento para activar la visualizacion de guis
     */
    private void treeSelectionListener() {
                  
        jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTree.addTreeSelectionListener((TreeSelectionEvent event) -> {
                   visualizeGui();
            });
    }
    
    /**
     * Metodo para visualizar la gui almacenada en el nodo.
     */
    private void visualizeGui() {
                    
        TreePath selectedPath = jTree.getSelectionPath();
        selectedNode = (DefaultMutableTreeNode)selectedPath.getLastPathComponent();
        
        infoNode = selectedNode.getUserObject();
        panelNode= (Component) infoNode;
     
        jSplitPanel.setRightComponent(panelNode);    
    }
    
    /**
     * Configura la dimension minima de la vista derecha del panel dividido en funcion de la gui insertada.
     * @param gui gui insertada en el panel dividido
     */
    private void setRightComponentMinimumSize(Component gui) {
    
    int height, width ;  
    
    height = gui.getMinimumSize().height;
    width = gui.getMinimumSize().width;
    
    if (height > heightRightComponent) heightRightComponent=height;
    if (width > widthRightComponent) widthRightComponent=width;
    
    jSplitPanel.getRightComponent().setMinimumSize(new Dimension(widthRightComponent,heightRightComponent));
    
    }
    
    /**
     * Configura la dimension preferida de la vista derecha del panel dividido en funcion de la gui insertada.
     * @param gui gui insertada en el panel dividido
     */
    private void setRightComponentPreferredSize(Component gui) {
    
    int height, width ;
    
    height = gui.getPreferredSize().height;
    width = gui.getPreferredSize().width;
    
    if (height > heightRightComponent) heightRightComponent=height;
    if (width > widthRightComponent) widthRightComponent=width;
    
    jSplitPanel.getRightComponent().setPreferredSize(new Dimension(widthRightComponent,heightRightComponent));
       
    }
    
    /**
     * Configura la dimension minima de la vista izquierda del panel dividido en funcion de la gui insertada.
     */
    private void setLeftComponentMinimumSize() {
     
    JViewport view = jScrollPanel.getViewport();
    jSplitPanel.getLeftComponent().setMinimumSize(view.getViewSize());
    
    }
    
    /**
     *  Sobreescribe el metodo de adicion de la clase base.
     * 
     * @param comp componente que se quiere añadir
     * @return componente añadido al panel dividido
     */
    @Override
    public Component add(Component comp) {
        
       nodo = new DefaultMutableTreeNode(comp);
      
       insertNode(rootNode, nodo);  
          
       setDimensions(comp);
       treeSelectionListener();
        
       return  super.add(jSplitPanel);      
    }
    
}
