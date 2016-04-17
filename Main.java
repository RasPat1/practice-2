package practice;

class Main {
	public static void main(String[] args) {
 		// Test Runner
 		Integer k1 = 10;
 		Integer k2 = 9;
 		Integer k3 = 12;
 		Integer dictionarySize = 5;

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


		System.out.println(t1.table);
 		System.out.println("Succesfully run");

 	}
 }