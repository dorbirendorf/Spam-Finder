


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Messages implements Iterable<Message> {

	
	
	 public MyArrayList<Message> myMessages;
	 public HashTable[] msgWordCount;
	public Messages() {
		this.myMessages=new MyArrayList<Message>() ;
	}


	public MessagesIterator iterator() {

    return new MessagesIterator(myMessages);
	}

	public MyArrayList<Message> getMessages() {
		return myMessages;
	}
	
	public void setMessages(MyArrayList<Message> arr) {
		this.myMessages=arr;
		
	}


	public void add(Message message) {
		this.myMessages.add(message);
		
	}
	
	public String toString() {
		String str="";
		for(Message m: myMessages) {
			str=str+m.toString();
		}
		return str;
	}
	
	public  void generateMessages(String fileName)   {
		final String separator = "#";
	    final String from = "From:";
	    final String to = "To:";
        String line;
	    Message message = null;
	    
	    BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
		
	    while ((line=br.readLine())!=null) {
	     
	    	if (line.startsWith(separator)) {
	            message = null;
	    }
	        
	        else {
	            if (message == null)
	                this.add(message = new Message());

	            if (line.startsWith(from))
	                message.setSender(line.substring(from.length()).trim());
	            else if (line.startsWith(to))
	                message.setAddressee(line.substring(to.length()).trim());
	            else
	                message.addToBody(line);
	        }
	    }

	   try {
		br.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e1) {
		
		e1.printStackTrace();
	} 
	}

    public void createHashTables(String m) {
    	 this.msgWordCount=new HashTable[myMessages.size()];
    	 for(int i=0;i<myMessages.size();i++) {
    		 msgWordCount[i]=new HashTable(Integer.parseInt(m));   //create hashtables
    	 }
    	int msgNum=0;
    	for(Message msg:myMessages) {
    		String [] wordArray=msg.getBody().split(" ");         //creat word array from each msg
    		for(int i=0;i<wordArray.length;i++) {                //for each word in the array
    			String word=wordArray[i];                        
    			this.msgWordCount[msgNum].insert(word);              //enter the word into the hashtable that represent the msg
    			
    		}
    		msgNum++;
    	}
    	
    }


	public String findSpams(String fileName, BTree btree) {
		Spams spams =new Spams(fileName);
		Integer msgindex=0;
		String str="";
		for(Message msg: myMessages) {
			double msgLength=msgLength(msg);
			String frindes=(msg.getSender()+" & "+msg.getAddressee());
			String frindes2=(msg.getAddressee()+" & "+msg.getSender());
			if((!btree.search(frindes))&&(!btree.search(frindes2))) {           //if not friends
			if(isSpam(this.msgWordCount[msgindex],spams,msgLength))	{str=str+msgindex.toString()+",";}
			}
			msgindex++;
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}

	
	public static double msgLength(Message msg) {
		String body=msg.getBody();
		String[] words=body.split(" ");
		return words.length;
	}
	
	
	
    public boolean isSpam(HashTable wordCount,Spams spams,double msgLength) {
    	boolean isSpam=false;
    	for(int i=0;i<spams.spams.length&&isSpam==false;i++) {
    		String word=spams.spams[i].getSpamWord();
    		double limPer=spams.spams[i].getLimit();     
    		double wordApear= wordCount.numOfApear(word);  
    		double percent=(wordApear*100/msgLength);
    		isSpam=percent>limPer;
    		
    	}
    	return isSpam;
    }
}
