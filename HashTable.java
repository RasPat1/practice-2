package practice;

/**
 * Hash Table implementation
 *
 * @author Rasesh Patel
 **/


 /**
  * Hash table using unsorted array as underlying Data Structure
  *
  **/
class HashTable {
	Integer[] table;
 	Integer DEFAULT_SIZE = 10;

 	public void HashTable() {
 		this.table = new Integer[DEFAULT_SIZE];
 		initializeArray(this.table);
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



 	void initializeArray(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
 			this.table[i] = null;
 		}
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