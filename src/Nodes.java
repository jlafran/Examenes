import java.util.HashMap;
import java.util.List;

public class Nodes {
    public static void main(String[] args) {
        Node na = new Node(1,2);
        Node nb = new Node(2,3);
        Node nc = new Node(3,7);
        Node nd = new Node(5,7);
        Node nf = new Node(8);
        Node ng = new Node(7,8);


        Node[] nodes = {na,nb,nc,nd,nf};
        Node res = findRoot(nodes);
        System.out.println(res.getId() + " " + res.getIdParent());

        Node[] node = {na,nb,ng,nc,nd};
        Node r = findRootSubtree(node);
        System.out.println(r.getId() + " " + r.getIdParent());
    }
    /**
        We define a Node as a Class that has two properties: an ID and a ParentID.

        A Node nodeA is the parent of nodeB if the parentID in nodeB is the same as the id of nodeA.
        All the ids are unique.

        After a decomposition in a previous function, we are given an array of nodes.
        The array isn’t sorted in any particular order. We have to identify the root, that means, the node with parentID null.

        Write a function that, given an array of Nodes, returns the root node.

        Sample invocation:

        whoIsTheRoot([{id: 1, parentId: 2}, {id: 2, parentId: null}]) == {id: 2, parentId: null}
        whoIsTheRoot([{id: 3, parentId: 7}, {id: 5, parentId: 7}, {id: 7, parentId: null}]) == {id: 7, parentId: null}
     */
    public static Node findRoot (Node[] nodes){
        Node n = new Node();
        for (Node node : nodes){
            if (node.getIdParent() == null){
                n.setId(node.getId());
                break;
            }
        }
        return n;
    }

    /**
     Now the previous function is transforming subtrees and sending us those subtrees as arrays.
     Therefore the root of our subtree does have a parentId, but it’s a node that isn’t inside the array that we receive as an input.

     Write a function that returns the root of the subtree.

     Sample invocation:

     whoIsTheRoot([{id: 1, parentId: 2}, {id: 2, parentId: 5}]) == {id: 2, parentId: 5}
     */
    public static Node findRootSubtree(Node[] subtree){
        HashMap<Integer,Integer> nodes = new HashMap<>();
        Node res = new Node();
        for (Node node : subtree){
            nodes.put(node.id,node.IdParent);
        }

        for (Node node : subtree){
            if (!nodes.containsKey(node.getIdParent())){
                res.setId(node.getId());
                res.setIdParent(node.getIdParent());
                break;
            }
        }
        return res;
    }

}
