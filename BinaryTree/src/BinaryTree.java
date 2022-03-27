import java.util.*;

public class BinaryTree<E>
{
  private BinaryTreeNode<E> root;
  private int size;

  public BinaryTreeNode<E> getRoot()
  {
    return root;
  }

  public void setRoot(BinaryTreeNode<E> root)
  {
    this.root = root;
  }

  public boolean isEmpty()
  {
    return root == null;
  }

  public int size()
  {
    return size;
  }

  public boolean contains(E element)
  {
    if(root == null){
      return false;
    }
    return inOrder().contains(element);
  }


  public ArrayList<E> inOrder(){
    ArrayList<E> result = new ArrayList<>();
    Stack<BinaryTreeNode> stack = new Stack<>();
    BinaryTreeNode<E> check = root;

    while (!stack.isEmpty() || check != null)
    {
      while (check != null)
      {
        stack.add(check);
        check = check.getLeftChild();
      }

      check = stack.pop();
      result.add(check.getElement());
      check = check.getRightChild();

    }
    return result;
  }

  public ArrayList<E> preOrder(){
    ArrayList<E> result = new ArrayList<>();
    Stack<BinaryTreeNode> stack = new Stack<>();
    BinaryTreeNode<E> check = root;
    result.add(check.getElement());

    while (!stack.isEmpty() || check != null)
    {
      while (check != null)
      {
        stack.add(check);
        check = check.getLeftChild();

        if (check != null && !result.contains(check.getElement()))
        {
          result.add(check.getElement());
        }
      }

      check = stack.pop();
      check = check.getRightChild();
      if(check != null) result.add(check.getElement());
    }
    return result;
  }


  public ArrayList<E> postOrder(){
    ArrayList<E> result = new ArrayList<>();
    Stack<BinaryTreeNode> stack = new Stack<>();
    Stack<BinaryTreeNode> stack2 = new Stack<>();
    BinaryTreeNode<E> check = root;

    stack.add(check);

    while (!stack.isEmpty())
    {
      check = stack.pop();
      stack2.add(check);

      if(check.getLeftChild() != null){
        stack.add(check.getLeftChild());
      }
      if(check.getRightChild() != null){
        stack.add(check.getRightChild());
      }
    }
    while(!stack2.isEmpty())
    {
      check = stack2.pop();
      result.add(check.getElement());
    }

    return result;
  }



  public ArrayList<E> levelOrder(){
    ArrayList<E> result = new ArrayList<>();
    return result;
  }
  public int height(BinaryTreeNode node){
    if (node == null || (node.getLeftChild() == null && node.getRightChild() == null))
    {
      return 0;
    }
    return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
  }


}
