



public class BTree
{
     int order; // order of tree
    BNode root;  //every tree has at least a root node

    public BTree(int order) { // constructor
        this.order = order;
        root = new BNode(order, null);
    }

    public void insert(BTree t, int key)  //method responsible for insertion
    {
        BNode r = t.root;//this method finds the node to be inserted as
        //it goes through this starting at root node.
        if(r.count == 2*order - 1)//if is full
        {
            BNode s = new BNode(order,null);//new node
            t.root = s;
            s.leaf = false;
            s.count = 0; //   > this is to initialize node.
            s.child[0] = r;
            split(s,0,r);//split root
            nonfullInsert(s, key); //call insert method
        }
        else
            nonfullInsert(r,key);//if its not full just insert it
    }

    public void nonfullInsert(BNode x, int key) //method when node is notr full.        |
    {
        int i = x.count; //i is number of keys in node x
        if(x.leaf)
        {
            while(i >= 1 && key < x.key[i-1])//here find spot to put key.
            {
                x.key[i] = x.key[i-1];//shift values to make room
                i--;//decrement
            }
            x.key[i] = key;//finally assign value to node
            x.count ++; //increment count of keys in this node now.
        }
        else
        {
            int j = 0;
            while(j < x.count  && key > x.key[j])//find spot to recurse
            {			             //on correct child
                j++;
            }
            if(x.child[j].count == order*2 - 1)
            {
                split(x,j,x.child[j]);//call split on node x's ith child
                if(key > x.key[j])
                    j++;
            }
            nonfullInsert(x.child[j],key);//recurse
        }
    }

    public void split(BNode x, int i, BNode y)  //It will split node if  we want to insert into if it is full.
    {
        BNode z = new BNode(order,null); //extra node if we want to insert
        z.leaf = y.leaf;//set boolean to same as y
        z.count = order - 1;//this is updated size
        {
            for(int j = 0; j < order - 1; j++)
                z.key[j] = y.key[j+order]; //copy end of y into front of z
        }

        if(!y.leaf)//if not leaf we have to reassign child nodes.
        {
            for(int k = 0; k < order; k++)
                z.child[k] = y.child[k+order]; //reassing child of y
        }
        y.count = order - 1; //new size of y

        for(int j = x.count ; j> i ; j--)//if we push key into x we have to rearrange child nodes
            x.child[j+1] = x.child[j]; //shift children of x

        x.child[i+1] = z; //reassign i+1 child of x

        for(int j = x.count; j> i; j--)
        {
            x.key[j + 1] = x.key[j]; // shift keys
        }

        x.key[i] = y.key[order-1];// push value up into root.
        y.key[order-1 ] = 0; //erase value where we pushed from

        for(int j = 0; j < order - 1; j++)
            y.key[j + order] = 0; //'delete' old values

        x.count ++;  //increase count of keys in x
    }

    public void print(BNode n) //Method for printing values
    {
        for(int i = 0; i < n.count; i++)
            System.out.print(n.getValue(i)+" " );//this part prints root node

        if(!n.leaf)//this is called when root is not leaf;
        {
            for(int j = 0; j <= n.count  ; j++)//in this loop we recurse
            {				  //to print out tree in
                if(n.getChild(j) != null) //preorder fashion.
                {			  //going from left most
                    System.out.println();
                    print(n.getChild(j));
                }
            }
        }
    }
}