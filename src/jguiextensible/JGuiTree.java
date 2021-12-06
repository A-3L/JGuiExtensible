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
        
        add(jSplitPanel);
    
    }
    
    private void initSplitPanel() {
        
        jSplitPanel.setDividerLocation(0.25);
        jSplitPanel.setDividerSize(2);
        jSplitPanel.setResizeWeight(0.0);
     
         
    }
    
    private void initJTree() {
        
        jTree.setModel(model);   
        jTree.setInvokesStopCellEditing(true);
        jTree.setVisibleRowCount(jTree.getComponentCount());
     
        
    }
    
    private void initJScrollPanel() {
        
        jScrollPanel.setViewportView(jTree);
        jScrollPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        jScrollPanel.setPreferredSize(jTree.getPreferredScrollableViewportSize());
        
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
        treeSelectionListener();
        
    } 
    
    @Override
    protected void insertGuiList(List<JGuiExtensible> childrenList, JGuiExtensible parent) {
     
        parentNode = new DefaultMutableTreeNode(parent);
        
        childrenList.forEach((var gui)-> { 
        
            super.insertGui(gui);
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
      
     private void insertNode(DefaultMutableTreeNode parentNode, DefaultMutableTreeNode childNode) {
        
        int index= model.getChildCount(parentNode);       
        model.insertNodeInto(childNode, parentNode, index);
        
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
        panelNode= (JGuiExtensible) infoNode;
        
        
        jSplitPanel.setRightComponent(panelNode);
      
        jSplitPanel.resetToPreferredSizes();        
    }
    
  
    
}
