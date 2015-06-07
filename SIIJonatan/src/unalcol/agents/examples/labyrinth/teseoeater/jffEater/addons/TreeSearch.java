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
public class TreeSearch {
    
    static TrinaryTree makeTree() {
    TrinaryTree root, a, b, c, d, e, f, x, y, z;
    c = new TrinaryTree("C", null, null, null, false);
    d = new TrinaryTree("D", null,null, null, false);
    e = new TrinaryTree("E", null,null, null, false);
    f = new TrinaryTree("F", null, null, null, false);
    x = new TrinaryTree("X", null, null, null, false);
    y = new TrinaryTree("Y", null, null, null, false);
    z = new TrinaryTree("Z", null, null, null, true);
    a = new TrinaryTree("A", c, y, d, false);
    b = new TrinaryTree("B", e, z, f, false);
    root = new TrinaryTree("Root", a, x, b, false);
    return root;
    }
    
    static boolean solvable(TrinaryTree node) {
/* 1 */  if (node == null) return false;
/* 2 */  if (node.isGoalNode) return true;
/* 3 */  if (solvable(node.leftChild)) return true;
/* 4 */  if (solvable(node.rightChild)) return true;
         if (solvable(node.middleChild)) return true;
/* 5 */  return false;
    }
    public static void main(String args[]) {
        TrinaryTree tree = makeTree();
        System.out.println(solvable(tree));
    }
    static String indent = "";

    static String name(TrinaryTree node) {
        if (node == null) return null;
        else return node.name;
    }

    static void enter(TrinaryTree node) {
        System.out.println(indent + "Entering solvable(" + name(node) + ")");
        indent = indent + "|  ";
    }

    static boolean yes(TrinaryTree node) {
        indent = indent.substring(3);
        System.out.println(indent + "solvable(" + name(node) + ") returns true");
        return true;
    }

    static boolean no(TrinaryTree node) {
        indent = indent.substring(3);
        System.out.println(indent + "solvable(" + name(node) + ") returns false");
        return false;
    }
    
}
