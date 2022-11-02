/** 
 * JGuiExtensible is a library that provides the necessary classes to implement
 * a reusable graphical user interface pattern
 * 
 * Copyright (C) 2022 a31r1z
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jguiextensible;

import java.awt.Component;
import java.awt.Dimension;
import java.io.Serializable;
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
 * Class that extends JGuiExtensible class.
 * Creates a tree graphical user interface.
 * 
 * @author a31r1z
 * @see JGuiExtensible
 */
public class JGuiTree extends JGuiExtensible implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**
     * Diferent objects for the construction of the view.
     */
    private JScrollPane jScrollPanel;
    private JSplitPane jSplitPanel;
    private JTree jTree;   
    
    /**
     * Objects and nodes for node insertion management in the tree structure.
     */
    private DefaultMutableTreeNode rootNode, parentNode, nodo,selectedNode ;
    transient private Object infoNode;
    private Component panelNode;
    /**
     * Tree data model.
     */
    private DefaultTreeModel model;
    
    /**
     * Integers for height and width settings of the view. 
     */
    private int heightRightComponent =0, widthRightComponent=0;
    
    /**
     * Protedted constructor. 
     * Returns a tree graphical user interface. 
     * 
     */
    protected JGuiTree() {
        
        super();
      
        initialize();    
    }
    
    /**
     * Method to initialize the gui. 
     */
    private void initialize() {
       
       rootNode = new DefaultMutableTreeNode();
       model = new DefaultTreeModel(rootNode);
        
      initJTree();
      initJScrollPanel();
      initJSplitPanel();
     
    }
    
    /**
     * Method to initialize the tree.
     */
    private void initJTree() {
         
        jTree = new JTree();
        jTree.setInvokesStopCellEditing(true);
        jTree.setScrollsOnExpand(true);
        
    }
    
    /**
     * Method to initialize the scrollpanel.
     */
    private void initJScrollPanel() {
        
        jScrollPanel = new JScrollPane();
        jScrollPanel.setViewportView(jTree);  
    }
    /**
     * Method to initialize the splitpanel.
     */ 
    private void initJSplitPanel() {
        
        jSplitPanel = new JSplitPane();     
        jSplitPanel.setDividerSize(2);
        jSplitPanel.setResizeWeight(0.2); 
        jSplitPanel.setLeftComponent(jScrollPanel);
        
        super.add(jSplitPanel);     
    }
    
    /**
     * Internal method to add one gui into another.
     * Overwrites the same method in JGuiExtensible class.
     * 
     * @param gui gui to add. 
     */
    @Override
    protected void insertJGui(JGuiExtensible gui) {
      
       nodo = new DefaultMutableTreeNode(gui);
           
       insertNode(rootNode,nodo);
               
       setDimensions(gui);   
       treeSelectionListener();
      
       super.add(jSplitPanel);  
    } 
    
    /**
     * Internal method to add one gui list into another gui.
     * Overwrites the same method in JGuiExtensible class.
     * 
     * @param childrenList gui list to add.
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
    
    /**
     * Method for the insertion of nodes into the tree structure.
     * 
     * @param parent father node to add a gui child node.
     * @param child  child node to add to a parent node
     * 
     */
    private void insertNode(DefaultMutableTreeNode parent, DefaultMutableTreeNode child) {
            
        int index= model.getChildCount(parent);
        model.insertNodeInto(child, parent, index);
        
        if(rootNode.getUserObject()==null) {
            
            jTree.setModel(model);
            rootNode.setUserObject(child.getUserObject());
            jTree.setSelectionRow(1);
            jSplitPanel.setRightComponent((Component)rootNode.getNextNode().getUserObject());
        }
           
    }
    
    /**
     * Set de minimum and preferred dimensions of splitpanel according to the guis added.
     * 
     * @param gui gui that his dimension must be set 
     */
    private void setDimensions(Component gui) {
        
       setLeftComponentMinimumSize();
       setRightComponentMinimumSize(gui);
       setRightComponentPreferredSize(gui);
     
       
    }
    
    /**
     * Method to determine the selected node and activate the event to throw the gui visualization.
     */
    private void treeSelectionListener() {
                  
        jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTree.addTreeSelectionListener((TreeSelectionEvent event) -> {
                   visualizeGui();
            });
    }
    
    /**
     * Method to visualize the gui stored in a node. 
     */
    private void visualizeGui() {
                    
        TreePath selectedPath = jTree.getSelectionPath();
        selectedNode = (DefaultMutableTreeNode)selectedPath.getLastPathComponent();
        
        infoNode = selectedNode.getUserObject();
        panelNode= (Component) infoNode;
     
        jSplitPanel.setRightComponent(panelNode);    
    }
    
    /**
     * Sets the minimum dimension of the right view of the splitpanel according the inserted gui.
     * @param gui inserted gui in the splitpanel
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
     * Sets the preferred dimension of the right view of the splitpanel according the inserted gui.
     * @param guiinserted gui in the splitpanel
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
     * Sets the minimum dimension of the left view of the splitpanel according the inserted gui.
     */
    private void setLeftComponentMinimumSize() {
     
    JViewport view = jScrollPanel.getViewport();
    jSplitPanel.getLeftComponent().setMinimumSize(view.getViewSize());
    
    }   
}
