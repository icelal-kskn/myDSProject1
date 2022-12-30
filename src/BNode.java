



public class BNode {
    boolean leaf;
    int t;  //order of tree
    int count; // number of keys in node
    int[] key;  // array of key values
    BNode[] child; //array of references
    BNode parent;  //parent of current node.

    public BNode(int t, BNode parent)
    {
        this.t = t;  //assign size
        this.parent = parent; //assign parent
        key = new int[2*t - 1];  // array of proper size
        child = new BNode[2*t]; // array of refs proper size
        leaf = true; // everynode is leaf at first;
        count = 0; //until we add keys later.
    }

    public int getValue(int index) // method to return key value at index position|
    {
        return key[index];
    }

    public BNode getChild(int index)   //  method to get ith child of node
    {
        return child[index];
    }
}
