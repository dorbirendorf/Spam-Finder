


public class HashListElement {
     
	
	private String content;
	private HashListElement next;
	private int count;
	public HashListElement(int count, String content, HashListElement next) {
		this.count=count;
		this.content=content;
		this.next=next;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public HashListElement getNext() {
		return next;
	}

	public void setNext(HashListElement next) {
		this.next = next;
	}
	
	
}
