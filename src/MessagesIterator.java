


import java.util.Iterator;
import java.util.NoSuchElementException;



public class MessagesIterator implements Iterator<Message> {
	int current = 0;
	MyArrayList<Message> Messages;
	
	
	public MessagesIterator(MyArrayList<Message> messages) {
		
		Messages = messages;
	}



	public boolean hasNext() {
		
		if (current < Messages.size()) {
            return true;
        } else {
            return false;
        }
		
	}

	

	@Override
	public Message next() {
		if(hasNext()) {
		
		Message toreturn= Messages.get(current);
		current++;
		return toreturn;
		}
		else {throw new NoSuchElementException();}
	}

}
