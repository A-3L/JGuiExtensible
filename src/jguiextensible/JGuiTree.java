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
 * @author a31r1z
 */
public class JGuiTree extends JGuiExtensible {

    private static final long serialVersionUID = 1L;
    
    
    private JScrollPane jScrollPanel;
    private JSplitPane jSplitPanel;
    private JTree jTree;
    private JGuiExtensible inGui;
    
    private DefaultMutableTreeNode nodoRaiz, parentNode, nodo,selectedNode ;
    private DefaultTreeModel model;
    private Object infoNode;
    private Component panelNode;
    
    private int heightRightComponent =0, widthRightComponent=0;
       
    public JGuiTree() {
        
        super();
      
        initialize();    
    }
    
    private void initialize() {
       
       nodoRaiz = new DefaultMutableTreeNode();
       model = new DefaultTreeModel(nodoRaiz);
        
       initJTree();
       initJScrollPanel();
       initSplitPanel();
     
    }
    
    private void initJTree() {
         
        jTree = new JTree();
        jTree.setInvokesStopCellEditing(true);
        jTree.setScrollsOnExpand(true);
        
    }
    
     private void initJScrollPanel() {
        
        jScrollPanel = new JScrollPane();
        jScrollPanel.setViewportView(jTree);  
    }
     
    private void initSplitPanel() {
        
        jSplitPanel = new JSplitPane();     
        jSplitPanel.setDividerSize(2);
        jSplitPanel.setResizeWeight(0.2); 
        jSplitPanel.setLeftComponent(jScrollPanel);
        
        super.add(jSplitPanel);     
    }
    
    @Override
    protected void insertGui(JGuiExtensible gui) {
         
       nodo = new DefaultMutableTreeNode(gui);
      
       insertNode(nodoRaiz, nodo);  
     
       setDimensions(gui);   
       treeSelectionListener();
      
        super.add(jSplitPanel);  
    } 
    
    @Override
    protected void insertGuiList(List<JGuiExtensible> childrenList) {
     
        parentNode = new DefaultMutableTreeNode(childrenList.get(0));
       
        insertNode(nodoRaiz, parentNode);
          
        childrenList.forEach((var gui)-> { 
        
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(gui);            
            insertNode(parentNode, node); 
            
            setDimensions(gui);
            treeSelectionListener();
            
            super.add(jSplitPanel); 
        }); 
    }
     
    private void insertNode(DefaultMutableTreeNode parent, DefaultMutableTreeNode child) {
       
        int index= model.getChildCount(parent);
        model.insertNodeInto(child, parent, index);
        
         if(nodoRaiz.getUserObject()==null) {
          
        jTree.setModel(model);
        nodoRaiz.setUserObject(nodoRaiz.getNextNode().getUserObject());
        
        jTree.setSelectionRow(1);
        jSplitPanel.setRightComponent((Component)nodoRaiz.getNextNode().getUserObject());
        }
    }
    
    private void setDimensions(Component gui) {
        
       setLeftComponentMinimumSize();
       setRightComponentMinimumSize(gui);
       //setRightComponentPreferredSize(gui);
       
    }
    
    private void treeSelectionListener() {
                  
        jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTree.addTreeSelectionListener((TreeSelectionEvent event) -> {
                   visualizarGui();
            });
    }
                  
    private void visualizarGui() {
                    
        TreePath selectedPath = jTree.getSelectionPath();
        selectedNode = (DefaultMutableTreeNode)selectedPath.getLastPathComponent();
        
        infoNode = selectedNode.getUserObject();
        panelNode= (Component) infoNode;
     
        jSplitPanel.setRightComponent(panelNode);    
    }
    
   
     private void setRightComponentMinimumSize(Component gui) {
    
    int height, width ;  
    
    height = gui.getMinimumSize().height;
    width = gui.getMinimumSize().width;
    
    if (height > heightRightComponent) heightRightComponent=height;
    if (width > widthRightComponent) widthRightComponent=width;
    
    jSplitPanel.getRightComponent().setMinimumSize(new Dimension(widthRightComponent,heightRightComponent));
    
    }
    
    private void setRightComponentPreferredSize(Component gui) {
    
    int height, width ;
    
    height = gui.getPreferredSize().height;
    width = gui.getPreferredSize().width;
    
    if (height > heightRightComponent) heightRightComponent=height;
    if (width > widthRightComponent) widthRightComponent=width;
    
    jSplitPanel.getRightComponent().setPreferredSize(new Dimension(widthRightComponent,heightRightComponent));
       
    }
    
    private void setLeftComponentMinimumSize() {
     
    JViewport view = jScrollPanel.getViewport();
    jSplitPanel.getLeftComponent().setMinimumSize(view.getViewSize());
    
    }
    
    @Override
    public Component add(Component comp) {
        
       nodo = new DefaultMutableTreeNode(comp);
      
       insertNode(nodoRaiz, nodo);  
          
       setDimensions(comp);
       treeSelectionListener();
        
        return  super.add(jSplitPanel);      
    }
    
}
