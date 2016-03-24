/**
 * Hash Table implementation
 *
 * @author Rasesh Patel
 **/


 /**
  * Hash table using Unsorted array as underlying Data structure
  *
  **/
 class HashTable {

 	public static void main(String[] args) {
 		// Test Runner

 		Integer dictionarySize = 100;

 		Integer k1 = 10;
 		Integer k2 = 9;
 		Integer k3 = 12;

 		HashTable t1 = new HashTable();
 		t1.insert(k1);
 		t1.insert(k2);
 		Integer result1 = t1.search(k1);
 		assert result1 == k1
 		Integer result2 = t1.search(k2);
 		assert result2 == k2

 		t1.delete(k1);
 		Integer result3 = t1.search(k1);
 		assert result3 == null;
 		t1.insert(k1);
 		t1.delete(k2);
 		Integer result4 = t1.search(k2);
 		assert result4 == null;

 	}

 	Boolean insert(Integer key) {

 	}

 	Integer search(Integer key) {

 	}



 }


