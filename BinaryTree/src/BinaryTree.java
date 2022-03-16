public class BinaryTree implements IBinaryTree
{
  private Node grantParent;

  public BinaryTree(){
    grantParent = new Node();
  }
  @Override public void addNode(Node node)
  {
    if(grantParent.isValueEmpty()){
      grantParent.setValue(node.getValue());
    }
    else
    {
      Node check = grantParent;
      while (true)
      {
        if (node.getValue() < check.getValue()){
          if(check.getLeft() != null){
            check = check.getLeft();
          }
          else {
            check.setLeft(node);
            System.out.println(check.getValue() + " added left " + node.getValue());
            break;
          }
        }
        else if (node.getValue() > check.getValue()){
          if(check.getRight() != null){
            check = check.getRight();
          }
          else {
            check.setRight(node);
            System.out.println(check.getValue() + " added right " + node.getValue());
            break;
          }
        }
      }
    }
  }

  @Override public Node getLowestNode()
  {
    Node result = grantParent;
    while(true){
      if(result.getLeft() != null){
        result = result.getLeft();
      }
      else{
        break;
      }
    }
    return result;
  }

  @Override public Node getHighestNode()
  {
    Node result = grantParent;
    while(true){
      if(result.getRight() != null){
        result = result.getRight();
      }
      else{
        break;
      }
    }
    return result;
  }
}
