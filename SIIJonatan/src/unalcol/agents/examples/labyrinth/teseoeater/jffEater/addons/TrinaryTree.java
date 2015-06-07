/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unalcol.agents.examples.labyrinth.teseoeater.jffEater.addons;

/**
 *
 * @author USER
 */
public class TrinaryTree {
    TrinaryTree leftChild = null;
    TrinaryTree rightChild = null;
    TrinaryTree middleChild = null;
    boolean isGoalNode = false;
    String name;
    
    TrinaryTree(String name, TrinaryTree left, TrinaryTree middle, TrinaryTree right, boolean isGoalNode) {
        this.name = name;
        leftChild = left;
        middleChild = middle;
        rightChild = right;
        this.isGoalNode = isGoalNode;
    }
    
}
