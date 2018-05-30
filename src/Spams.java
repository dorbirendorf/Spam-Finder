


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Spams implements Iterable<Spam>{

	Spam[] spams;

	public Spam[] getSpams() {
		return spams;
	}

	public Spams(String fileName) {
		
		try {
			//********get the number of spams**********
			File myFile=new File(fileName);
			Scanner myScanner = new Scanner(myFile);
			int numOfLine=0;
			while(myScanner.hasNextLine()) {                     
				numOfLine++;
				myScanner.nextLine();
			}
			myScanner.close();
			this.spams=new Spam[numOfLine];                  //create an array in right size
			
			//********fill the array*******************
		   numOfLine=0;
		   myScanner=new Scanner(myFile);                                //reset scanner and counter
		   while(myScanner.hasNext()) {
			   this.spams[numOfLine]=new Spam(myScanner.next(),myScanner.nextInt());
			   numOfLine++;
		   }
		   
			
			myScanner.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public Iterator<Spam> iterator() {
		
		return new spamsIterator(spams);
	}

   public String toString() {
	   String str="";
	   for(Spam s: spams) {
		   str=str+s.toString();
	   }
	   return str;
   }



	
	
}
