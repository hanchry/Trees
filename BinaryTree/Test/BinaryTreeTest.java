import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BinaryTreeTest
{
  private BinaryTreeNode<Integer> node;
  private BinaryTree<Integer> tree;

  @BeforeEach
  void setUp() {
    node = new BinaryTreeNode(5);


    node.addLeftChild(new BinaryTreeNode(3));
    node.addRightChild(new BinaryTreeNode(10));
    node.getRightChild().addRightChild(new BinaryTreeNode(13));

    node.getLeftChild().addLeftChild(new BinaryTreeNode(2));
    node.getLeftChild().addRightChild(new BinaryTreeNode(4));

    tree = new BinaryTree();
    tree.setRoot(node);
  }
  @Test
  void isEmpty(){
    assertFalse(tree.isEmpty());
  }
  @Test
  void inOrder(){
    ArrayList<Integer> real = new ArrayList<Integer>(
        Arrays.asList(2,3,4,5,10,13));
    ArrayList<Integer> list = tree.inOrder();
    assertEquals(real,list);
  }
  @Test
  void preOrder(){
    ArrayList<Integer> real = new ArrayList<Integer>(
        Arrays.asList(5,3,2,4,10,13));
    ArrayList<Integer> list = tree.preOrder();
    assertEquals(real,list);
  }
  @Test
  void postOrder(){
    ArrayList<Integer> real = new ArrayList<Integer>(
        Arrays.asList(2,4,3,13,10,5));
    ArrayList<Integer> list = tree.postOrder();
    assertEquals(real,list);
  }
  @Test
  void height(){
    assertEquals(2,tree.height(node));
  }
}
