import java.util.*;
import java.lang.reflect.*;

public class MyHashTable<K,V>{
	
	private int _tableSize;
	private int totalCount = 0;	 
	
	class DataElement<K,V>{
		K key;
		V value;
		DataElement next;
		
		public DataElement(K k, V v){
			key = k;
			value = v;
		}
	}
	private DataElement <K,V>[] _table;
	
	@SuppressWarnings({"unchecked"})
	public MyHashTable(){
		_tableSize = 2;
		_table =  (DataElement <K,V>[] )  new DataElement[_tableSize]; 
		System.out.println("Table size" + _table.length);
	}
	
	@SuppressWarnings({"unchecked"})	
	public boolean Put(K key, V value){
		
		try{
			if( ( (int) totalCount / _tableSize)  > 1){
				ReHash();
			}
			int hashCode = GetHashCode(key);
			if(_table[hashCode] == null){
				_table[hashCode] = new DataElement<K,V>(key, value);
				totalCount++;
				return true;
			}
			DataElement<K,V> current = _table[hashCode]; 
			DataElement<K,V>  prev = current;
			
			while(current != null) {
				if(current.key == key){
					current.value = value;
					totalCount++;
					return true;
				}
				prev = current;
				current = current.next;
			}
			prev.next = new DataElement<K,V>(key, value);
			totalCount++;
			return true;
		}
		catch(Exception e){
			System.out.println(e.getStackTrace());
			return false;
		}
	}
	
	@SuppressWarnings({"unchecked"})	
	public V Get(K key){
		
		int hashCode = GetHashCode(key);
		DataElement<K,V>  current = _table[hashCode];
		if(current == null){
			System.out.println("List is null for hashcode: " + hashCode + " Key = " + key);
			return null;
		}
		while(current != null){
			if(current.key.equals(key)){
				return current.value;
			}
			current = current.next;
		}
		return null;
	}

	@SuppressWarnings({"unchecked"})	
	private void ReHash(){
		synchronized(_table){
			System.out.println("Rehashing began! when table size was " + _tableSize);
			 DataElement<K,V>[] oldTable = _table;
			_tableSize *= 2;
			_table = (DataElement <K,V>[] )  new DataElement[_tableSize]; 
			//copy each element in old table to new 
			for(DataElement<K,V> tableEntry: oldTable){
				while(tableEntry != null){
					Put(tableEntry.key, tableEntry.value); //enters into the new table with new hashCode
					tableEntry = tableEntry.next;
				} 
			}
			System.out.println("Rehashing complete and table size is " + _tableSize);
		}
		
	}
	
	public int GetHashCode(K key){
	
		if(key instanceof String){
			int counter = 0;
			
			for( char c : ((String) key).toCharArray() ){
				counter+=c;	
			}
			return counter % _tableSize;
		}else if(key instanceof Integer){
			return (Integer) key % _tableSize;
		}	
		else {
			return 0;
		}
	}
	
	@SuppressWarnings({"unchecked"})	
	public void DumpTable(){
		System.out.println("");
		System.out.println(" ---------Dumping Table---------------");
		for(int i = 0; i<  _table.length; i++){
				DataElement<K,V> tableEntry = _table[i];
				while(tableEntry != null){
					System.out.print("key " + tableEntry.key + " value: " + tableEntry.value  + " Hashcode: 	" + GetHashCode(tableEntry.key) + "; " );
					tableEntry = tableEntry.next;
				} 
				System.out.println(" End Of Data at " + i);
			}
	}
	
	@SuppressWarnings({"unchecked"})	
	public void DumpTableStats(){
		System.out.println("");
		System.out.println(" ---------Dumping Table Stats---------------");
		for(int i = 0; i<  _table.length; i++){
				DataElement<K,V> tableEntry = _table[i];
				while(tableEntry != null){
					tableEntry = tableEntry.next;
				} 
				System.out.println(" End Of Data at " + i);
			}
	}
	
	
	public static void main(String args[]){
		MyHashTable<String,String> mt = new MyHashTable<String,String>();
		mt.Put("Kayy", "Rocks");
		mt.Put("Sean", "RocksRocks");
		mt.Put("TS1", "TS1Value");	
		mt.Put("TS2", "TS2Value");
		mt.Put("TriggersReHash", "TriggersReHash");
		mt.Put("Kayy", "Sucks");
		System.out.println(mt.Get("Kayy"));
		System.out.println(mt.Get("Sean"));
		System.out.println(mt.Get("Mallu"));
		System.out.println(mt.Get("TS1"));
		System.out.println(mt.Get("TriggersReHash"));
		for (int i = 0 ; i < 1000 ; i++){
			String key = "Key" + i;
			mt.Put( key , "Value"+i);
		}
		System.out.println("Final Get: " + mt.Get("Key9"));
		//mt.DumpTable();
	}
	
}