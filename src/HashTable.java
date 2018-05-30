




public class HashTable {

	private HashList [] arr;
	
	public HashTable(int m) {
		this.arr = new HashList [m];
		for (int i=0; i<m; i++) {
			arr[i]=null;
		}
	}
	
	
	
	public int hashFunction(String word) {
		int count=0;
		char [] wordC= word.toCharArray();
		for (char c: wordC) {
	
			
			count=count + Math.abs(Character.getNumericValue(c));
		}
		return (count%arr.length);
	}

	public void insert(String word)
	{
		int a=hashFunction(word);
		if (arr[a]==null) {
			HashListElement NE= new HashListElement(1, word, null);
			HashList NH= new HashList(NE);
			arr[a]=NH;
			
		}
		else {
			HashListElement E=arr[a].getFirst();
			boolean changed=false;
			while (E!=null && !changed) {
				if (E.getContent().equals(word))
				{
					E.setCount(E.getCount()+1);
					changed=true;
				}
				E=E.getNext();
			}
			 if (!changed) {
			HashListElement NE= new HashListElement(1, word, arr[a].getFirst());
			arr[a].setFirst(NE);
			}
		}
    }
	
	public int numOfApear(String word) {
		int a=hashFunction(word);
		if (arr[a]==null)
			return 0;
		
		HashListElement E=arr[a].getFirst();
		while (E.getNext()!=null) {
			if (E.getContent().equals(word))
				return E.getCount();
			E=E.getNext();
		}
		if (E.getContent().equals(word))
			return E.getCount();
		return 0;
	}
	
	public String toString() {
		return null;
		
	}
}
