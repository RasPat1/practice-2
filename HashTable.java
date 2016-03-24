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
 	Integer[] table;

 	public static void main(String[] args) {
 		// Test Runner
 		Integer k1 = 10;
 		Integer k2 = 9;
 		Integer k3 = 12;


 		HashTable t1 = new HashTable();
 		t1.insert(k1);
 		t1.insert(k2);
 		Integer result1 = t1.search(k1);
 		assert result1 == k1;
 		Integer result2 = t1.search(k2);
 		assert result2 == k2;


 		t1.delete(k1);
 		Integer result3 = t1.search(k1);
 		assert result3 == null;
 		t1.insert(k1);
 		t1.delete(k2);
 		Integer result4 = t1.search(k2);
 		assert result4 == null;


		System.out.println(t1);
 		System.out.println("Succesfully run");

 	}

 	Boolean insert(Integer key) {
 		return false;
 	}

 	Integer search(Integer key) {
 		return 0;
 	}

 	Boolean delete(Integer key) {
 		return false;
 	}

 	/**
 	 * Intialize Hash Table
 	 */
 	public void HashTable(Integer dictionarySize) {
 		this.table = new Integer[dictionarySize];
 	}

 	/**
 	 * Return a Hash of the integer using a safe Hash function
 	 **/
 	Integer hash(Integer key) {
 		return 0;
 	}

 	public String toString() {
 		String string = "START::";

 		for (int i = 0; i < this.table.length; i++) {
 			String value = "NULL::";
 			if (this.table[i] != null) {
 				value = this.table[i] + "::";
 			}

 			string += value;
 		}

 		string += "END";

 		return string;
 	}

 }


