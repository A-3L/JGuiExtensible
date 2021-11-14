/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jguiextensible;

import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
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
    
    JScrollPane jScrollPanel;
    JSplitPane jSplitPanel;
    JTree jTree;
    
    DefaultMutableTreeNode nodoRaiz, parentNode, guiNode, selectedNode ;
    DefaultTreeModel model;
    Object infoNode;
    JGuiExtensible panelNode;
    
    
    public JGuiTree() {
        
        initialize();
        
    }
    
    private void initialize() {
        
        jSplitPanel = new JSplitPane();
        jScrollPanel = new JScrollPane();
        jTree = new JTree();
        
        nodoRaiz = new DefaultMutableTreeNode();
        model = new DefaultTreeModel(nodoRaiz);
        
        jSplitPanel.setDividerLocation(-40);
        jSplitPanel.setDividerSize(2);
        
        jTree.setModel(model);
        jTree.setSelectionRow(1);
        
        jScrollPanel.setViewportView(jTree);
        
        jSplitPanel.setLeftComponent(jScrollPanel);
    
    }
    
    @Override
    protected void insertGui(JGuiExtensible gui) {
        
        super.insertGui(gui);
        
        nodoRaiz = new DefaultMutableTreeNode();
        guiNode = new DefaultMutableTreeNode(gui);
        
        insertNode(nodoRaiz, guiNode);
        
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
       
     private void insertNode(DefaultMutableTreeNode parentNode, DefaultMutableTreeNode childNode) {
        
        int index= model.getChildCount(parentNode);       
        model.insertNodeInto(childNode, parentNode, index);
        
    }
     
     private void treeSelectionListener() {
        
        jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTree.addTreeSelectionListener((TreeSelectionEvent event) -> {
            visualizarTree();
        });
         
    }
    
    private void visualizarTree() {
        
        TreePath selectedPath = jTree.getSelectionPath();
        
        selectedNode = (DefaultMutableTreeNode)selectedPath.getLastPathComponent();
        infoNode = selectedNode.getUserObject();       
        panelNode= (JGuiExtensible) infoNode;
        
        jSplitPanel.setRightComponent(panelNode);
        
    }
    
}
