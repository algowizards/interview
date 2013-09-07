public class SimpleHashTable{
	
	private static int MAXSIZE = 4;
	List<HashEntry>[] _table = new List<HashEntry>[MAXSIZE];
	
	public void put(object key, object value ){
		int hashCode = computeHashCode(key);
		List<HashEntry>() list = table[hashCode];
		
		if(list == null){
			list = new List<HashEntry>();
			table[hashCode] = list;
		}
		
		foreach(HashEntry h in list){
			if(h.key.equals(key)){
				h.value = value;
				return;
			}
		}
		list.add(new HashEntry(key, value));
		
	}
	
	public object get(object key){
		
		int hashCode = computeHashCode(key);
		if(table[hashCode] == null){
			return null;
		}
		
		foreach(HashEntry h in table[hashCode]){
			if(h.equals(key)){
				return h.value;
			}
		}
		return null;
	}
	
	
	private int computeHashCode(object key){
		return key.hashCode()%MAXSIZE;
	}
	
	private class HashEntry{
		object key;
		object value;

		public HashEntry(object k, object v){
			key = k;
			value = v;
		}
	}
	
}