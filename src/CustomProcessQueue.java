
// TODO: comment this class

public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue


  public CustomProcessQueue() {
    this.heap = new CustomProcess[INITIAL_CAPACITY];
    this.size = 0; // since 0 index should be kept empty
  }


  // So is minHeapPercolateUp supposed to be used as a helper method whenever we call enqueue in order
  // to correctly place the newly added node in the heap?
  private void minHeapPercolateUp(int index) {
    CustomProcess parent = heap[(index) / 2];
    // To restore heap property, algorithm sifts up the new element, by swapping it with its
    // parent
    if (index == 1 || (parent != null && heap[index].compareTo(parent) > 0)) {
        // do nothing
        return;
    }
    // swap parent and child
    CustomProcess temp;
    temp = heap[index];
    heap[index] = heap[index / 2];
    heap[index / 2] = temp;
    minHeapPercolateUp(index / 2); // on the parent index
  }

  // minHeapPercolateDown is the helper method for dequeue when we need to replace the root node with
  // a new node?
  private void minHeapPercolateDown(int index) {

    for (int i = index; i < size(); i++) {
      heap[i] = heap[i + 1];
    }

    heap[size()] = null;


  }
  
  private void doubleArraySize() {
    
     CustomProcess[] newheap = new CustomProcess[this.heap.length * 2];
     
     for(int i=0; i< this.size; i++) {
       newheap[i] = this.heap[i];
     }
    
     this.heap = newheap;
  }

  // inserts a newObject in the priority queue
  public void enqueue(CustomProcess newObject) {

    
    if (this.isEmpty()) {
      this.heap[1] = newObject;
      this.size++;
  } else {
      if (size+1 < this.heap.length) {
          this.size++;
          this.heap[size] = newObject;
          minHeapPercolateUp(this.size);

      } else {
        doubleArraySize();
      }

  }
    
    
    
  }

  // removes and returns the item with the highest priority
  public CustomProcess dequeue() {

    if (!isEmpty()) {
      CustomProcess removeProcess = this.heap[1];

      // TODO: remove and shift all one down
      minHeapPercolateDown(1);
      
      this.size--;
      
      return removeProcess; // Since highest priority is at 1
    } else
      return null;
  }



  public CustomProcess peek() {

    if (!isEmpty())
      return this.heap[1]; // Since highest priority is at 1

    else
      return null;
  } // returns without removing the item with the highest priority


  public int size() {
    return this.size;
  } // returns size of the waiting queue

  public boolean isEmpty() {
    if (this.size == 0) {
      return true;
    }
    return false;
  } // checks if the waiting queue is empty

  // TODO: remove this method before submitting
  public CustomProcess processAtIndex(int index) {
    if (!isEmpty()) {

      return this.heap[index];

    }
    return null;
  } // checks if the waiting queue is empty

}
