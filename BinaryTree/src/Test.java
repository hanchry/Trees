public class Test
{
  public static void main(String[] args)
  {
    Node node = new Node();
    Node node2 = new Node();
    Node node3 = new Node();
    Node node4 = new Node();
    node.setValue(30);
    node2.setValue(25);
    node3.setValue(28);
    node4.setValue(40);

    IBinaryTree tree = new BinaryTree();
    tree.addNode(node);
    tree.addNode(node2);
    tree.addNode(node3);
    tree.addNode(node4);
    System.out.println(tree.getLowestNode().getValue());

  }
}
