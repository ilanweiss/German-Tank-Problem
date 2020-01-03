
public class Heap {

	private Tank[] data;
	private int size; 
	
	/**
	 * Creates an empty list.
	 */
	public Heap(){
		this.data = new Tank[10001]; 
		this.size = 0;
	}
	
	/**
	 * Returns the size of the heap.
	 * 
	 * @return the size of the heap
	 */
	public int size(){
		return this.size;
	}
	
	/**
	 * Inserts a given tank into the heap.
	 * Should run in time O(log(n)).
	 * 
	 * @param t - the tank to be inserted.
	 */
	public void insert(Tank t){
		int current = size() + 1; 
		int perent = current/2;
		this.data[current] = t;
		while ((current>1)&&(t.compareTo(this.data[perent]) > 0)) {
				this.data[0] = this.data[perent];
				this.data[perent] = this.data[current];
				this.data[current] = this.data[0];
				this.data[0] = null;
				current = perent;
				perent = current/2;
		}
		size++;
	}
	
	/**
	 * Returns the tank with the highest serial number in the heap.
	 * Should run in time O(1).
	 * 
	 * @return the tank with the highest serial number in the heap.
	 */
	public Tank findMax(){
		return this.data[1];
	}
	
	/**
	 * Removes the tank with the highest serial number from the heap.
	 * Should run in time O(log(n)).
	 * 
	 */
	public void extractMax(){
		this.data[1] = this.data[size];
		size--;
		maxHeapify(1);
    }

    private void maxHeapify(int i) {
        int left= 2 * i;
        int right = (2 * i) + 1 ;
        int parent = i;

        if ((left <= this.size) && (this.data[left].compareTo(this.data[i]) > 0)) {
            parent = left;
        }
        if((right <= this.size) && (this.data[right].compareTo(this.data[parent]) > 0)) {
            parent = right;
        }
        if(parent != i){
            Tank temp = this.data[i];
            this.data[i] = this.data[parent];
            this.data[parent] = temp;
            maxHeapify(parent);
        }
    }
	
	
	/**
	 * Returns the tank with the k highest serial number in the heap.
	 * Should run in time O(klog(n)).
	 * 
	 * @param k
	 * @return the tank with the k highest serial number in the heap.
	 */
	public Tank findKbiggest(int k){
	    Tank[] tempTank = new Tank[k-1];
	    for( int i = 0; i < k-1; i++){
	        tempTank[i] = findMax();
	        extractMax();
        }
        Tank kBiggest = findMax();
        for(int i = 0; i < k-1; i++ ){
	        insert(tempTank[i]);
        }
		return kBiggest;
	}	
	
	/**
	 * Removes the tank with the k highest serial number from the heap.
	 * Should run in time O(klog(n)).
	 * 
	 * @param k
	 */
	public void removeKbiggest(int k){
		Tank[] tempTank = new Tank[k-1];
	    for( int i = 0; i < k-1; i++){
	        tempTank[i] = findMax();
	        extractMax();
        }
        extractMax();
        for(int i = 0; i < k-1; i++ ){
	        insert(tempTank[i]);
        }
	}
	
	/**
	 * Checks if a given tank is a part of the heap.
	 * 
	 * @param t - the tank to be checked
	 * @return true if and only if the tank is in the heap.
	 */
	public boolean contains(Tank t){
		for(int i = 1; i <= size; i++){
		    if (t.compareTo(this.data[i]) == 0) return true;
		}
		return false;
	}
}
