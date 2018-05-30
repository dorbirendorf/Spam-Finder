


import java.util.Iterator;

public class HashList implements Iterable<Object>{

	private HashListElement First;
	private int count;
	
	public HashList (HashListElement First) {
		this.First=First;
		
	}

	public HashListElement getFirst() {
		return First;
	}

	public void setFirst(HashListElement first) {
		First = first;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public Iterator<Object> iterator() {
		
		return null;
	}

}
