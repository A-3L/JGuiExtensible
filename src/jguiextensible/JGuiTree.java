/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.awt.Dimension;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author a31r1z
 */
public class JGuiTree extends JGuiExtensible {
    
    
    JScrollPane jScrollPanel;
    JSplitPane jSplitPanel;
    JTree jTree;
    
    DefaultMutableTreeNode nodoRaiz, parentNode, nodo, selectedNode ;
    DefaultTreeModel model;
    Object infoNode;
    JGuiExtensible panelNode;
    
    int height=0, width=0;
    
    public JGuiTree() {
        
        super();
        initialize();
        
    }
    
    private void initialize() {
               
        jSplitPanel = new JSplitPane();
        jScrollPanel = new JScrollPane();
        jTree = new JTree();
        
        nodoRaiz = new DefaultMutableTreeNode();
        model = new DefaultTreeModel(nodoRaiz);
        
        initSplitPanel();
        
        initJTree();
        
        initJScrollPanel();
                 
        jSplitPanel.setLeftComponent(jScrollPanel); 
       
    
    }
    
    private void initSplitPanel() {
        
        //jSplitPanel.setDividerLocation(0.50);
        jSplitPanel.setDividerSize(2);
        jSplitPanel.setResizeWeight(0.20); 
       
    }
    
    private void initJTree() {
        
        jTree.setModel(model);   
        jTree.setInvokesStopCellEditing(true);
       
        //jTree.setScrollsOnExpand(true);
       
    }
    
    private void initJScrollPanel() {
        
        jScrollPanel.setViewportView(jTree);
        jScrollPanel.setMinimumSize(new Dimension(75,75));
        
        System.out.println(jScrollPanel.getMinimumSize()+"JSCROLL");
        System.out.println(jTree.getMinimumSize()+"JTREE");
        System.out.println(jSplitPanel.getLeftComponent().getMinimumSize()+"JSPLITLEFT");
     
    }
    
    @Override
    protected void insertGui(JGuiExtensible gui) {
        
        if (nodoRaiz.getUserObject()== null) {
            nodoRaiz.setUserObject(gui);
           
           jTree.setSelectionPath(getInitialPath());
           visualizarGui();
        }
        
        nodo = new DefaultMutableTreeNode(gui);   
        insertNode(nodoRaiz, nodo);
            
        setRightComponentSizeByGui(gui);      
        treeSelectionListener(); 
        add(jSplitPanel);
    } 
    
    @Override
    protected void insertGuiList(List<JGuiExtensible> childrenList) {
     
        parentNode = new DefaultMutableTreeNode(childrenList.get(0));
        
        childrenList.forEach((var gui)-> { 
        
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(gui);
            
            insertNode(parentNode, node);
        
        });
         
        insertNode(nodoRaiz, parentNode);
        treeSelectionListener();    
    }
     
      private TreePath getInitialPath () {
     
        TreePath path = jTree.getPathForRow(0);
       
       return path;
    }
      
     private void insertNode(DefaultMutableTreeNode parent, DefaultMutableTreeNode child) {
       
        int index= model.getChildCount(parent);       
        model.insertNodeInto(child, parent, index);    
    }
     
    private void treeSelectionListener() {
        
        jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTree.addTreeSelectionListener((TreeSelectionEvent event) -> {
             visualizarGui();
        });
         
    }
    
    private void visualizarGui() {
               
        TreePath selectedPath = jTree.getSelectionPath();
        jTree.scrollPathToVisible(selectedPath);
        
        selectedNode = (DefaultMutableTreeNode)selectedPath.getLastPathComponent();
        infoNode = selectedNode.getUserObject();       
        panelNode= (JGuiExtensible) infoNode;
                
        jSplitPanel.setRightComponent(panelNode);
        jSplitPanel.setDividerLocation(jSplitPanel.getDividerLocation());
        
    }
    
    private void setRightComponentSizeByGui(JGuiExtensible gui) {
     
        int heightPanel, widthPanel ;
         
        heightPanel = gui.getMinimumSize().height;
        widthPanel = gui.getMinimumSize().width;
             
        if (heightPanel > height) height=heightPanel;
        if (widthPanel > width) width=widthPanel;
        
        System.out.println(jSplitPanel.getRightComponent());
        
        jSplitPanel.getRightComponent().setMinimumSize(new Dimension(width,height));
        
    }
  
    
}
