

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BTree {
	//fields
    public BTreeNode root;
    public int t;
    //constructor
    public BTree(int tVal){
        root=null;
        t=tVal;
    }
    public BTree(String tVal){
        root=null;
        t=Integer.parseInt(tVal);
    }
    //methods
    public void createFullTree(String fileName) {
        Scanner myScanner = null;
        try {
            myScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (myScanner.hasNext()) {
            insert(myScanner.nextLine());
            
            
        }
    }
    
    public Boolean search(String key){
        if(root==null) throw new RuntimeException("exeption");
        return root.BTreeSearch(key);
    }

    public void insert(String key){
        if(root==null){
            root=new BTreeNode(t,true);
            root.keys[0]=key;
            root.setNumOfKeys(1);
        }else{
            if(root.getNumOfKeys() == 2*t-1){             //full so split
                BTreeNode myNode=new BTreeNode(t,false);  //need to add one more
                myNode.child[0]=root;
                myNode.splitChild(0,root);
                int i=0;
                if(myNode.keys[0].compareTo(key)<0) i++;
                myNode.child[i].insertToNonFull(key);
                root=myNode;
            }else
                root.insertToNonFull(key);
        }
    }
  //This function prints your tree in a treeish form. if two nodes has a ___ between them it means they are not from the same parent.
    public void PrintTree() {
    		String strTree = toString();
    		String[] treeLevels = strTree.split("#");
    		for (int i = 0; i < treeLevels.length; i++) {
    			String[] level = treeLevels[i].split("\\|");
    			for (int j = 0; j < Math.pow(2, treeLevels.length - i); j++)
    				System.out.print("  ");
    			for (int k = 0; k < level.length; k++) {
    				if (level[k].contains("^")) {
    					String[] level2 = level[k].split("\\^");
    					System.out.print("[" + level2[0] + "]");
    					for (int j = 0; j < Math.pow(3, treeLevels.length - i); j++)
    						System.out.print("_");
    					System.out.print("[" + level2[1] + "]");
    				} else
    					System.out.print("[" + level[k] + "]");
    				for (int j = 0; j < Math.pow(2, treeLevels.length - i); j++)
    					System.out.print(" ");
    			}
    			System.out.println();
    		}
    	}
    
   
    public String nodeToString(BTreeNode node,char c){
        boolean stop=false;
        String toReturn="";
        if(node.level!=0) toReturn+=c;
        toReturn+=node.keys[0];
        for(int i=1;!stop&&i<=node.getNumOfKeys();i++){
            if(i==node.keys.length||node.keys[i]==null){
                stop=true;
            }
            else
                toReturn+=","+node.keys[i];
        }
        return  toReturn;
    }
    public String toString(){
     Queue<BTreeNode> bQueue=new Queue<>();
     String toreturn="";
     root.level=0;
     bQueue.enqueue(root);
     toreturn=toStringRec(toreturn,bQueue,0,null);
     return toreturn;
 }
    public String toStringRec(String toReturn,Queue<BTreeNode> bQueue,int recLevel,BTreeNode lastParent){
        while(!bQueue.isEmpty()){
            BTreeNode x=bQueue.dequeue();
            if(recLevel!=x.level)
                toReturn+=nodeToString(x,'#');
            else{
                if(lastParent!=x.getPerent()) {
                    toReturn += nodeToString(x, '^');
                }
                else
                    toReturn+=nodeToString(x,'|');
            }
            lastParent=x.getPerent();
            recLevel=x.level;
            if(!x.isLeaf()){
                for(int i=0;i<=x.getNumOfKeys();i++) {
                    x.child[i].setPerent(x);
                    x.child[i].level = x.level + 1;
                    bQueue.enqueue(x.child[i]);
                }
            }
        }
        return toReturn;
    }}
    