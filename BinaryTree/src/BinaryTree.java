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


}
