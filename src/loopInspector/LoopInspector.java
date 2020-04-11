import java.util.*;

public class LoopInspector {

  public int loopSize(Node node) {
    HashMap<Node, Integer> nodeMap = new HashMap<Node, Integer>();
    nodeMap.put(node, 1);
    Integer counter = 2;
    Node currNode = node.getNext();
    do{
      nodeMap.put(currNode, counter);
      currNode = currNode.getNext();
      counter++;
    }
    while(!nodeMap.containsKey(currNode));
    if(nodeMap.size() == 1){
      return 1;
    }
    int startOfLoop = 0;
    for(Map.Entry<Node, Integer> nodeElement : nodeMap.entrySet()){
      if(nodeElement.getKey() == currNode){
        startOfLoop = (int) nodeElement.getValue();
      }
    }
    return nodeMap.size() + 1 - startOfLoop;
  }

}