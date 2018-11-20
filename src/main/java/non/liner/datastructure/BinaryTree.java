package non.liner.datastructure;

import java.util.List;
import java.util.ArrayList;
//import java.util.Queue;

public class BinaryTree<T> {
    //try to create binary search tree
    private static Node<Integer> root = new Node<Integer>(13);

    public static void main(String[] args) throws QueueOverFlowException, QueueUnderFlowException {
        List<Node<Integer>> data = new ArrayList<Node<Integer>>();
        data.add(new Node<Integer>(10));
        data.add(new Node<Integer>(12));
        data.add(new Node<Integer>(15));
        data.add(new Node<Integer>(18));
        data.add(new Node<Integer>(22));
        data.add(new Node<Integer>(25));
        data.add(new Node<Integer>(23));
        data.add(new Node<Integer>(26));

        for( Node<Integer> node : data){
            insert(node, root);
        }

        insert(new Node<Integer>(16), root);
        insert(new Node<Integer>(17), root);
        insert(new Node<Integer>(11), root);

        //System.out.println("min-" + minimum(root));
        //System.out.println("max-" + maximum(root));

        //System.out.println("maximumDepth-" + maximumDepth(root));

        System.out.println("traversInOrder-");
        traversBreadthSearch(root);

        //System.out.println("range-16to25");
        //range(25, 16, root);
        //System.out.println("binarySearchTreeCheck: " + binarySearchTreeCheck(root,Integer.MIN_VALUE,Integer.MAX_VALUE));

/*
        System.out.println("find- 10: " + lookup(new Node<Integer>(10), root));
        System.out.println("find- 13: " + lookup(new Node<Integer>(13), root));
        System.out.println("find- 11: " + lookup(new Node<Integer>(11), root));
        System.out.println("find- 23: " + lookup(new Node<Integer>(23), root));
        System.out.println("find- 16: " + lookup(new Node<Integer>(16), root));
        System.out.println("find- 12: " + lookup(new Node<Integer>(12), root));

        System.out.println("find- 27: " + lookup(new Node<Integer>(27), root));
        System.out.println("find- 24: " + lookup(new Node<Integer>(24), root));
        System.out.println("find- 19: " + lookup(new Node<Integer>(19), root));
        System.out.println("find- 14: " + lookup(new Node<Integer>(14), root));

        try {
            traversBreadthSearch();
        } catch (QueueOverFlowException e) {
            e.printStackTrace();
        } catch (QueueUnderFlowException e) {
            e.printStackTrace();
        }

        System.out.println("traversPreOrder-");
        traversPreOrder(root);
        System.out.println("traversPostOrder-");
        traversPostOrder(root);
        */

        /*System.out.println("traversInOrder-");
        traversBreadthSearch();
        mirror(root);
        System.out.println("traversInOrder-");
        traversBreadthSearch();*/

        Height depth= new Height();
        System.out.println("isBinarySearchTreeBalanced: " + isBinarySearchTreeBalanced(root, depth));
        System.out.println("height: " + depth.height);

        List<Node<Integer>> bank = new ArrayList<Node<Integer>>();
        getSortedNodeList(root, bank);
        System.out.println("SortedNodeList-");
        for(Node<Integer> node: bank){
            System.out.println(node.getData());
            node.setLeftNode(null);
            node.setRightNode(null);
        }
        Node<Integer> newRoot = convertToBalanceTree(bank, 0 ,  bank.size()-1);

        System.out.println("traversInOrder-");
        traversBreadthSearch(newRoot);
    }

    public static Node<Integer> convertToBalanceTree(List<Node<Integer>> data, int min, int max){
        if (min>max){
            return null;
        }
        int mid = (min + max)/2;
        Node<Integer> node = data.get(mid);
        node.setLeftNode(convertToBalanceTree(data, min, mid-1));
        node.setRightNode(convertToBalanceTree(data, mid+1, max));
        return node;
    }

    public static void getSortedNodeList(Node<Integer> head, List<Node<Integer>> data){
        if(head == null){
            return;
        }
        getSortedNodeList(head.getLeftNode(), data);
        data.add(head);
        getSortedNodeList(head.getRightNode(), data);
    }

    public static class Height{
        int height;
    }

    public static boolean isBinarySearchTreeBalanced(Node<Integer> node, Height depth){
        if(node == null){
            depth.height = 0;
            return true;
        }
        Height leftNodeHeight = new Height();
        Height rightNodeHeight = new Height();
        boolean isleftNodeBalanced = isBinarySearchTreeBalanced(node.getLeftNode(), leftNodeHeight);
        boolean isRightNodeBalanced = isBinarySearchTreeBalanced(node.getRightNode(), rightNodeHeight);
        depth.height = leftNodeHeight.height>rightNodeHeight.height?leftNodeHeight.height:rightNodeHeight.height + 1;
        int diff = leftNodeHeight.height - rightNodeHeight.height;
        if (diff > 1 || diff<-1){
            return false;
        }
        return isleftNodeBalanced && isRightNodeBalanced;
    }

    public int depth(Node<Integer> head){
        if(head==null){
            return 0;
        }
        return Math.max(1+depth(head.getRightNode()),1+depth(head.getLeftNode()));
    }



    public static boolean binarySearchTreeCheck(Node<Integer> head, int min, int max){
        if(head==null) {
            return true;
        }
        int tmp = head.getData();
        if(tmp<=min || tmp>max){
            return false;
        }
        return binarySearchTreeCheck(head.getRightNode(), tmp, max) &&  binarySearchTreeCheck(head.getLeftNode(), min, tmp);
    }

    public static void range(int max, int min, Node<Integer> head){
        if(head == null){
            return;
        }
        int tmp = head.getData();
        if(tmp < min){
            range(max, min, head.getRightNode());
        }
        else if(tmp > max){
            range(max, min, head.getRightNode());
        }
        else{
            System.out.println(tmp);
            range(max, min, head.getLeftNode());
            range(max, min, head.getRightNode());
        }
    }


    public static int minimum(Node<Integer> head){
        if(head.getLeftNode() == null){
            return head.getData();
        }
        return minimum(head.getLeftNode());
    }

    public static int maximum(Node<Integer> head){
        if(head.getRightNode() == null){
            return head.getData();
        }
        return maximum(head.getRightNode());
    }

    public static int maximumDepth(Node<Integer> head){
        if(head == null){
            return 0;
        }
        return  Math.max(1+maximumDepth(head.getLeftNode()), 1+maximumDepth(head.getRightNode()));
    }

    public static void mirror(Node<Integer> head){
        if(head==null){
            return;
        }
        Node<Integer> rightNode =  head.getRightNode();
        head.setRightNode(head.getLeftNode());
        head.setLeftNode(rightNode);
        mirror(head.getLeftNode());
        mirror(head.getRightNode());
    }

    public static void traversBreadthSearch(Node<Integer> root) throws QueueOverFlowException, QueueUnderFlowException{
        Queue<Node> queue = new Queue<Node>(10, Node.class);
        queue.enque(root);
        //Node data = root;
        while(!queue.isEmpty()){
            Node node = queue.deque();
            System.out.println(node);
            if(node.getLeftNode()!=null) {
                queue.enque(node.getLeftNode());
            }
            if(node.getRightNode()!=null) {
                queue.enque(node.getRightNode());
            }
        }
    }

    //[pre-order]
    public static void traversPreOrder(Node<Integer> data){
        if(data == null){
            return;
        }
        System.out.println(data);
        traversPreOrder(data.getLeftNode());
        traversPreOrder(data.getRightNode());
    }

    //[in order]
    public static void traversInOrder(Node<Integer> data){
        if(data == null){
            return;
        }
        traversInOrder(data.getLeftNode());
        System.out.println(data);
        traversInOrder(data.getRightNode());
    }

    //[post order]
    public static void traversPostOrder(Node<Integer> data){
        if(data == null){
            return;
        }
        traversPostOrder(data.getLeftNode());
        traversPostOrder(data.getRightNode());
        System.out.println(data);
    }

    public static Node<Integer> insert(Node<Integer> node, Node<Integer> head){
        if(head == null){
            return node;
        }
        //left side
        if(node.getData() <= head.getData()){
            head.setLeftNode(insert(node, head.getLeftNode()));
        }
        else{//right side
            head.setRightNode(insert(node, head.getRightNode()));
        }
        return head;
    }

    public static boolean lookup(Node<Integer> node, Node<Integer> head){
        if(head == null || node == null){
            return false;
        }
        if(node.getData() == head.getData()){
            return true;
        }
        //left side
        if(node.getData() < head.getData()){
            return lookup(node, head.getLeftNode());
        } else {
            return lookup(node, head.getRightNode());
        }
    }

    static class Node<T>{
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data){
            this.data = data;
        }

        public T getData(){
            return this.data;
        }

        public void setLeftNode(Node<T> leftNode){
            this.leftNode =  leftNode;
        }

        public Node<T> getLeftNode(){
            return leftNode;
        }

        public void setRightNode(Node<T> rightNode){
            this.rightNode = rightNode;
        }

        public Node<T> getRightNode(){
            return rightNode;
        }

        @Override
        public String toString(){
            return this.data.toString();
        }

    }
}




/*
Question -

CHECK IF A BINARY TREE IS A BINARY *SEARCH* TREE
 */