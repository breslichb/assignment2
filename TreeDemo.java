class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /**
   * A recursive insert method
   * @param root The root of the target tree
   * @param value The value to be inserted
   */
   public Node insert(Node root, int value){
   //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
   //recursive step
      if(value < root.value){
         root.left = insert(root.left, value);
      }else{
         root.right = insert(root.right, value);
      }
      return root;
   }
   
   /**
   * Iterative Insert method
   * @param value The value to be inserted
   */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
         
         while(true){
            parent = current;
            
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
           
         }//closing while
      
      }//closing main if-else 
   }
   
   
   /**
   * A pre-order traversal method.
   * @param root The root of the target tree.
   */
   public void preOrderTraversal(Node root){
      System.out.println(root.value);
      if(root.left != null){
         preOrderTraversal(root.left);
      }
      if(root.right != null){
         preOrderTraversal(root.right);
      }
   }

   /**
   * An in-order traversal method.
   * @param root The root of the target tree.
   */
   public void inOrderTraversal(Node root){
      if(root.left != null){
         preOrderTraversal(root.left);
      }
      System.out.println(root.value);
      if(root.right != null){
         preOrderTraversal(root.right);
      }
   }
   
   
   
   /**
   * A post-order traversal method.
   * @param root The root of the target tree.
   */
   public void postOrderTraversal(Node root){
      if(root.left != null){
         preOrderTraversal(root.left);
      }
      if(root.right != null){
         preOrderTraversal(root.right);
      }
      System.out.println(root.value);
   }
   
   
   
   /**
   * A method to find the node in the tree with a specific value.
   * @param root The root of the target tree.
   * @param key The key we're searching for.
   * @return True if the key is found, False otherwise.
   */
   public boolean find(Node root, int key){
      boolean retval = false;
      if(root.left != null){
         retval = find(root.left, key);
      }
      if(root.value == key){
         return true;
      }
      if(root.right != null && retval != true){
         retval = find(root.right, key);
      }
      return retval;
   }
   
   
   
   /**
   * A method to find the node in the tree with the smallest key.
   * @param root The root of the target tree.
   * @return The smallest value in the tree.
   */
   public int getMin(Node root){
      while(root.left != null){
         root = root.left;
      }
      return root.value;
   }
  
  
  
   /**
   * A method to find the node in the tree with the largest key
   * @param root The root of the target tree.
   * @return The largest value in the tree.
   */
   public int getMax(Node root){
      while(root.right != null){
         root = root.right;
      }
      return root.value;
   }
   
   
   
   /**
    * Deletes a target node in the tree.
    * @param root The root of the target tree.
    * @param key The key of the target node.
    * @return The new node at the old node's position (or null if the node had no children).
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
}

public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1 = new BinarySearchTree();
      t1.insert(t1.root, 24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
      System.out.print("in-order : ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
   }
}