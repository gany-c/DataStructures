package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    
 /* START STATIC INNER CLASS
 */
  static class Node {
    private final String nodeName;
    private final List<Node> childNodes;

    Node(String nodeName) {
      this.nodeName = nodeName;
      childNodes = new ArrayList<>();
    }

    String getNodeName() {
      return nodeName;
    }

    List<Node> getChildNodes() {
      return childNodes;
    }

    @Override
    public String toString() {
      return "" + nodeName + "-" + hashCode();
    }
  }
  
   /* END STATIC INNER CLASS
 */

  public static void main(String[] args) {
    pretendTheseAreUnitTests();
  }

  public static Collection<Node> querySelectorAll(String selector, Node root) {
   
   if(root == null || selector == null || selector.trim().isEmpty())
        return null;
   
   Collection<Node> output = querySelectorDeep(selector, root);
   
   return output;
  }
  
  private static Collection<Node> querySelectorDeep(String selector, Node root){
      
   if(root == null || selector == null || selector.trim().isEmpty())
        return null;      
  
  Collection<Node> output = new ArrayList<Node>();
   
   if(root.getChildNodes()!=null)
    for(Node child: root.getChildNodes()){
        
        if(child.nodeName.equalsIgnoreCase(selector)){
            output.add(child);
        } 
        
        output.addAll(querySelectorDeep(selector,child));
    }
   
   
   return output;    
      
  }



  // "Unit tests" below here



  private static void pretendTheseAreUnitTests() {
    test1();
    test2();
    test3();
  }

  private static void test1() {
    /*
     *         div
     *          |
     *         span
     */
    Node root = new Node("div");
    Node child = new Node("span");
    root.getChildNodes().add(child);

    String selector = "span";

    List<Node> expected = Arrays.asList(child);
    assertEqual(expected, querySelectorAll(selector, root));
  }

  private static void test2() {
    /*
     *         div
     *       /  |  \
     *      p  span p
     */
    Node root = new Node("div");
    Node child1 = new Node("p");
    Node child2 = new Node("span");
    Node child3 = new Node("p");
    root.getChildNodes().addAll(Arrays.asList(child1, child2, child3));

    String selector = "p";

    List<Node> expected = Arrays.asList(child1, child3);
    assertEqual(expected, querySelectorAll(selector, root));
  }

  private static void test3() {
    /*
     *         div
     *       /  |  \
     *      p  span p
     *     / \     / \
     *   div  a   a  div
     */
    Node root = new Node("div");

    Node child1 = new Node("p");
    Node child2 = new Node("span");
    Node child3 = new Node("p");

    Node child1_1 = new Node("div");
    Node child1_2 = new Node("a");

    Node child3_1 = new Node("a");
    Node child3_2 = new Node("div");

    root.getChildNodes().addAll(Arrays.asList(child1, child2, child3));
    child1.getChildNodes().addAll(Arrays.asList(child1_1, child1_2));
    child3.getChildNodes().addAll(Arrays.asList(child3_1, child3_2));

    String selector = "a";

    List<Node> expected = Arrays.asList(child1_2, child3_1);
    assertEqual(expected, querySelectorAll(selector, root));
  }

  private static void assertEqual(Collection<Node> expected, Collection<Node> actual) {
    if (actual == null) {
      System.out.println("Expected " + expected + " but was null");
    } else if (expected.size() != actual.size()) {
      System.out.println("Expected " + expected + " but actual had different size: " + actual);
    } else {
      Set<Node> expectedSet = new HashSet<>(expected);
      for (Node node : actual) {
        if (expectedSet.contains(node)) {
          expectedSet.remove(node);
        } else {
          System.out.println("Expected " + expected + " but found unexpected node (" + node + ") in actual: " + actual);
          return;
        }
      }

      System.out.println("Pass! Expected is equivalent to actual: " + actual);
    }
  }
}
