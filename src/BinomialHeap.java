/* class BinomialHeap */
class BinomialHeap
{
    private BinomialHeapNode Nodes;
    private int size;
 
    /* Constructor */
    public BinomialHeap()
    {
        Nodes = null;
        size = 0;
    }
    /* Check if heap is empty */
    public boolean isEmpty()
    {
        return Nodes == null;
    }
    /* Function to get size */
    public int getSize()
    {
        return size;
    }
    /* clear heap */
    public void makeEmpty()
    {
        Nodes = null;
        size = 0;
    }
    /* Function to insert */        
    public void insert(int value, String valn) 
    {
        if (value > 0)
        {
            BinomialHeapNode temp = new BinomialHeapNode(value,valn);
            if (Nodes == null) 
            {
                Nodes = temp;
                size = 1;
            } 
            else 
            {
                unionNodes(temp);
                size++;
            }
        }
    }
    /* Function to unite two binomial heaps */
    private void merge(BinomialHeapNode binHeap) 
    {
        BinomialHeapNode temp1 = Nodes, temp2 = binHeap;
 
        while ((temp1 != null) && (temp2 != null)) 
        {
            if (temp1.degree == temp2.degree) 
            {
                BinomialHeapNode tmp = temp2;
                temp2 = temp2.sibling;
                tmp.sibling = temp1.sibling;
                temp1.sibling = tmp;
                temp1 = tmp.sibling;
            } 
            else 
            {
                if (temp1.degree < temp2.degree) 
                {
                    if ((temp1.sibling == null) || (temp1.sibling.degree > temp2.degree)) 
                    {
                        BinomialHeapNode tmp = temp2;
                        temp2 = temp2.sibling;
                        tmp.sibling = temp1.sibling;
                        temp1.sibling = tmp;
                        temp1 = tmp.sibling;
                    }
                    else 
                    {
                        temp1 = temp1.sibling;
                    }
                }
                else 
                {
                    BinomialHeapNode tmp = temp1;
                    temp1 = temp2;
                    temp2 = temp2.sibling;
                    temp1.sibling = tmp;
                    if (tmp == Nodes) 
                    {
                        Nodes = temp1;
                    }
                    else 
                    {
 
                    }
                }
            }
        }
        if (temp1 == null) 
        {
            temp1 = Nodes;
            while (temp1.sibling != null) 
            {
                temp1 = temp1.sibling;
            }
            temp1.sibling = temp2;
        } 
        else
        {
 
        }
    }
    /* Function for union of nodes */
    private void unionNodes(BinomialHeapNode binHeap) 
    {
        merge(binHeap);
 
        BinomialHeapNode prevTemp = null, temp = Nodes, nextTemp = Nodes.sibling;
 
        while (nextTemp != null) 
        {
            if ((temp.degree != nextTemp.degree) || ((nextTemp.sibling != null) && (nextTemp.sibling.degree == temp.degree))) 
            {                
                prevTemp = temp;
                temp = nextTemp;
            } 
            else
            {
                if (temp.key <= nextTemp.key) 
                {
                    temp.sibling = nextTemp.sibling;
                    nextTemp.parent = temp;
                    nextTemp.sibling = temp.child;
                    temp.child = nextTemp;
                    temp.degree++;
                } 
                else 
                {
                    if (prevTemp == null) 
                    {
                        Nodes = nextTemp;
                    }
                    else 
                    {
                        prevTemp.sibling = nextTemp;
                    }
                    temp.parent = nextTemp;
                    temp.sibling = nextTemp.child;
                    nextTemp.child = temp;
                    nextTemp.degree++;
                    temp = nextTemp;
                }
            }
            nextTemp = temp.sibling;
        }
    }
    /* Function to return minimum key */
    public int findMinimum() 
    {
        return Nodes.findMinNode().key;
    }
    /* Function to delete a particular element */
    public void delete(int value) 
    {
        if ((Nodes != null) && (Nodes.findANodeWithKey(value) != null)) 
        {
            decreaseKeyValue(value, findMinimum() - 1);
            extractMin();
        }
    }
    /* Function to decrease key with a given value */
    public void decreaseKeyValue(int old_value, int new_value) 
    {
        BinomialHeapNode temp = Nodes.findANodeWithKey(old_value);
        if (temp == null)
            return;
        temp.key = new_value;
        BinomialHeapNode tempParent = temp.parent;
 
        while ((tempParent != null) && (temp.key < tempParent.key)) 
        {
            int z = temp.key;
            temp.key = tempParent.key;
            tempParent.key = z;
 
            temp = tempParent;
            tempParent = tempParent.parent;
        }
    }
    /* Function to extract the node with the minimum key */
    public int extractMin() 
    {
        if (Nodes == null)
            return -1;
 
        BinomialHeapNode temp = Nodes, prevTemp = null;
        BinomialHeapNode minNode = Nodes.findMinNode();
 
        while (temp.key != minNode.key) 
        {
            prevTemp = temp;
            temp = temp.sibling;
        }
 
        if (prevTemp == null) 
        {
            Nodes = temp.sibling;
        }
        else
        {
            prevTemp.sibling = temp.sibling;
        }
 
        temp = temp.child;
        BinomialHeapNode fakeNode = temp;
 
        while (temp != null) 
        {
            temp.parent = null;
            temp = temp.sibling;
        }
 
        if ((Nodes == null) && (fakeNode == null))
        {
            size = 0;
        } 
        else
        {
            if ((Nodes == null) && (fakeNode != null)) 
            {
                Nodes = fakeNode.reverse(null);
                size = Nodes.getSize();
            }
            else
            {
                if ((Nodes != null) && (fakeNode == null))
                {
                    size = Nodes.getSize();
                }
                else
                {
                    unionNodes(fakeNode.reverse(null));
                    size = Nodes.getSize();
                }
            }
        }
 
        return minNode.key;
    }
 
    public void deleteName(String value)
    {
    	if ((Nodes != null) && (Nodes.findANodeWithName(value) != null)) 
        {
            decreaseKeyValue(value, findMinimum() - 1);
            extractMin();
        }
    }
    
    public void decreaseKeyValue(String old_value, int new_value) 
    {
        BinomialHeapNode temp = Nodes.findANodeWithName(old_value);
        if (temp == null)
            return;
        temp.key = new_value;
        BinomialHeapNode tempParent = temp.parent;
 
        while ((tempParent != null) && (temp.key < tempParent.key)) 
        {
            int z = temp.key;
            temp.key = tempParent.key;
            tempParent.key = z;
 
            temp = tempParent;
            tempParent = tempParent.parent;
        }
    }
    
  
    /* Function to display heap */
    public void displayHeap(Ordine a)
    {
    	//System.out.print("\nHeap : ");
        displayHeap(Nodes,a);
        //System.out.println("\n");
    }
    private void displayHeap(BinomialHeapNode r, Ordine a)
    {
        if (r != null)
        {
        	//a.aux=a.aux + r.name + r.key +" ";
            displayHeap(r.child,a);
            //System.out.print(r.name + r.key +", ");
            a.aux=a.aux + r.name +", ";
            displayHeap(r.sibling,a);
        }
    }    
} 
