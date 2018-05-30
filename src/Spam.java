


public class Spam {
	
	String spamWord;
	int limit;
	
	
	public Spam(String spamWord, int limit) {
		super();
		this.spamWord = spamWord;
		this.limit = limit;
	}
	public String getSpamWord() {
		return spamWord;
	}
	public void setSpamWord(String spamWord) {
		this.spamWord = spamWord;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	@Override
	public String toString() {
		return "spam [spamWord=" + spamWord + ", limit=" + limit + "]";
	}

}
