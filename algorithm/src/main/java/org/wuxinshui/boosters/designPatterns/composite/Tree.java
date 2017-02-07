package org.wuxinshui.boosters.designPatterns.composite;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/8
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
public class Tree {
    TreeNode root=null;

    public Tree(String name) {
        this.root = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tree=new Tree("A");
        TreeNode nodeB=new TreeNode("B");
        TreeNode nodeC=new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println(tree.root.getChildren());
    }
}
