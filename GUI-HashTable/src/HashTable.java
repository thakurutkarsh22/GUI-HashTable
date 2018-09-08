
public class HashTable<K extends Comparable<K>, V> {
	class Node implements Comparable<Node>{
		K key; 
		V value;
		
		Node(K key, V value){
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(HashTable<K, V>.Node o) {
			return this.key.compareTo(o.key);
		}
	}
	
	int size;
	LinkedList<Node>[] lists;
	static final int DEFAULT_SIZE = 4;
	
	public HashTable(){
		this.size = 0;
		this.lists = new LinkedList[DEFAULT_SIZE];
	}
	
	public V get(K key) throws Exception{
		V retVal = null;
		int bucketIndex = this.getBucketIndex(key);
		
		LinkedList<Node> bucket = this.lists[bucketIndex];
		Node htNode = new Node(key, null);
		
		if(bucket == null){
			return null;
		}
		else {
			int foundAt = bucket.find(htNode);
			if(foundAt == -1){
				return null;
			}
			else {
				retVal = bucket.getAt(foundAt).value;
			}
		}
		
		return retVal;
	}
	
	private int getBucketIndex(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	public V remove(K key) throws Exception{
		V retVal = null;
		int bucketIndex = this.getBucketIndex(key);
		
		LinkedList<Node> bucket = this.lists[bucketIndex];
		Node htNode = new Node(key, null);
		
		if(bucket == null){
			return null;
		}
		else {
			int foundAt = bucket.find(htNode);
			if(foundAt == -1){
				return null;
			}
			else {
				retVal = bucket.getAt(foundAt).value;
				bucket.removeAt(foundAt);
				this.size--;
			}
		}
		
		return retVal;
	}

}
