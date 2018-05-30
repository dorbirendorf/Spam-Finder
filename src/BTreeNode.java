


public class BTreeNode {
	//fields
    int numOfKeys;
    String[] keys;
    boolean isLeaf;
    BTreeNode[] child;
    BTreeNode perent;
    int level;
    int t;
    //constroctor
    public BTreeNode (int t,boolean isLeaf){
        this.t=t;
        this.isLeaf=isLeaf;
        keys=new String[2*t-1];
        child=new BTreeNode[2*t];
    }
    //getter setter
    public int getNumOfKeys() {
		return numOfKeys;
	}
	public void setNumOfKeys(int numOfKeys) {
		this.numOfKeys = numOfKeys;
	}
	public BTreeNode getPerent() {
		return perent;
	}
	public void setPerent(BTreeNode perent) {
		this.perent = perent;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	 //methods
	public void splitChild(int i,BTreeNode y){
        BTreeNode z=new BTreeNode(y.t,y.isLeaf());
        z.setNumOfKeys(t-1);
        for (int j=0;j<t-1;j++)
            z.keys[j]=y.keys[j+t];
        if(!y.isLeaf()){
            for(int j=0;j<t;j++)
                z.child[j]=y.child[j+t];
        }
        y.setNumOfKeys(t-1);
        for(int j=numOfKeys;j>=i+1;j--)
            child[j+1]=child[j];
        child[i+1]=z;
        for(int j=numOfKeys-1;j>=i;j--)
            keys[j+1]=keys[j];
        keys[i]=y.keys[t-1];

        y.keys[t-1] = null;
        for(int j = 0; j < t -1; j++)
        {
            y.keys[j + t] = null;
        }
        numOfKeys++;
    }
    public boolean BTreeSearch(String key){
        int i=0;
        while (i<=numOfKeys-1 && key.compareTo(keys[i])>0){
            i++;
        }
        if(key.equals(keys[i])) return true;
        if(isLeaf) return false;
        return child[i].BTreeSearch(key);
    }
    public void insertToNonFull(String k){
        int i=numOfKeys-1;
        if(isLeaf()){
            while (i>=0 && keys[i].compareTo(k)>=1){
                keys[i+1]=keys[i];
                
                i--;
            }
            keys[i+1]=k;
            numOfKeys++;
        }else{
            while (i>=0&&keys[i].compareTo(k)>=1){
                i--;
            }if(child[i+1].numOfKeys==2*t-1){
                splitChild(i+1,child[i+1]);
                if(keys[i+1].compareTo(k)<0)
                    i++;
            }
            child[i+1].insertToNonFull(k);
        }
    }
}
