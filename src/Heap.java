/**
 * A basic max heap that works on integers. Will need to be updated to work with whatever implementation of cards/records we go with.
 * Version 1.0 5/26/14 
 * @author Matt Matero
 *
 */



public class Heap {
	private Card[] myHeap; //the actual heap
	private int numElements; //number of elements in the heap
	private int maxSize; //max size of the heap

	/**
	 * Constructs a heap with properties of max size
	 * @param maxSize, the maximum number of elements the heap can contain
	 */
	public Heap(int maxSize){
		myHeap = new Card[maxSize];
		numElements = 0;
		this.maxSize = maxSize;
	}

	/**
	 * Finds the parent of an element
	 * @param pos - the element
	 * @return the parent
	 */
	public int parent(int pos){
		return pos/2;
	}

	/**
	 * Finds the left child of an element
	 * @param pos - the element
	 * @return the left child
	 */
	public int leftChild(int pos){
		return 2*pos;
	}

	/**
	 * Finds right child of an element
	 * @param pos - the element
	 * @return the right child
	 */
	public int rightChild(int pos){
		return 2*pos + 1;
	}

	/**
	 * Checks if an element is a leaf in the heap
	 * @param pos - the element
	 * @return true if the element is a leaf, false otherwise.
	 */
	private boolean isLeaf(int pos){
		return (pos >= (numElements/2)) && (pos <= numElements);
	}

	/**
	 * Swaps two elements in the heap.
	 * @param xPos - the first element you are swapping
	 * @param yPos - the second element you are swapping
	 */
	private void swap(int xPos, int yPos){
		Card temp = myHeap[xPos];
		myHeap[xPos] = myHeap[yPos];
		myHeap[yPos] = temp;
	}

	/**
	 * Will keep the heap in a max heap form
	 * @param pos -the starting point
	 */
	private void maxHeapify(int pos){
		if(!isLeaf(pos)){
			if(myHeap[pos].compare(myHeap[this.leftChild(pos)]) == -1 || myHeap[pos].compare( myHeap[this.rightChild(pos)]) == -1){
				if(myHeap[this.leftChild(pos)].compare(myHeap[this.rightChild(pos)]) == 1){
					swap(pos, this.leftChild(pos));
					maxHeapify(this.leftChild(pos));
				}else{
					swap(pos,this.rightChild(pos));
					maxHeapify(this.rightChild(pos));
				}
			}
		}
	}
	
	/**
	 * uses maxheapify 
	 */
	public void maxHeap(){
		for(int pos = (numElements /2); pos >= 1; pos--){
			maxHeapify(pos);
		}
	}
	
	/**
	 * inserts an element into the heap
	 * @param element - the desired element to be inserted
	 */
	public void insert(Card element){
		if(numElements +1 > maxSize){
			maxSize *= 2;
		}
		myHeap[numElements++] = element;
		int current = numElements;
		
		while(myHeap[current].compare( myHeap[this.parent(current)]) == -1){
			swap(current,this.parent(current));
			current = this.parent(current);
		}
	}
	
	public int getMaxSize(){
		return maxSize;
	}
	
	public int getNumElements(){
		return numElements;
	}
	
}
