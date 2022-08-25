package br.com.course.trees;

public class BinarySearchTrees {
    
    public static void main(String[] args) {
        
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);

        tree.traverseInOrder();

        System.out.println();
        System.out.println("-------------------");

        System.out.println(tree.get(27));
        System.out.println(tree.get(8888));

        System.out.println("-------------------");

        System.out.println(tree.min());
        System.out.println(tree.max());

        System.out.println("-------------------");

        tree.delete(15);
        tree.traverseInOrder();

        System.out.println();
        System.out.println("-------------------");

        tree.delete(25);
        tree.traverseInOrder();

        System.out.println();
        System.out.println("-------------------");

        tree.delete(88888);
        tree.traverseInOrder();
        System.out.println();
    }
}
