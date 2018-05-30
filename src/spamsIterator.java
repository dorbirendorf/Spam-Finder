


import java.util.Iterator;
import java.util.NoSuchElementException;

public class spamsIterator implements Iterator<Spam> {

	//fields
	int curr=0;
	Spam[] Spams;
	
	//constructor
	public spamsIterator(Spam[] spams) {
		this.Spams=spams;
	}

	

	//methods
	public boolean hasNext() {
		if (curr < Spams.length) {
            return true;
        } else {
            return false;
        }
	}

	@Override
	public Spam next() {
		if(hasNext()) {
			
			Spam toreturn= Spams[curr];
			curr++;
			return toreturn;
			}
			else {throw new NoSuchElementException();}
		}
	}


