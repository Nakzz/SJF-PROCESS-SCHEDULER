
// TODO: comment this class

public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue

  // You are NOT allowed to import java.util.ArrayList class or any other ArrayList-based
  // implementation.
  // The heap MUST array-based MIN-heap. It will be implemented such that the ROOT node is ALWAYS the
  // entry at index 1 in the array. This means that index 0 should be unused and the process having
  // the highest priority is always stored at index 1 of your array heap.
  // Unused indexes (0, plus any past the current size of your heap) should contain null.
  // Your heap array should expand to fit all the processes being enqueued. You can devise your
  // dynamic heap by simply doubling its size whenever it is full. One simple way to do so is to copy
  // all elements into a new 2x-sized array when you run out of space. We note that implementing a
  // shadow array to expand the size of your heap array is not required by this assignment.

  // dequeue() and peek() methods SHOULD return null if they are called on an empty
  // CustomProcessQueue.
  // In addition to implementing ALL the methods defined in the WaitingQueueADT interface, your
  // CustomProcessQueue must have the following two private methods:

  // NOTE that you can add as many private helper methods as you judge necessary to implement the
  // defined behavior of your CustomProcessQueue class.

  // You can defined public getter methods if needed (to test your implementation for instance). But,
  // NO further public method should be added to your class.

  // Your CustomProcessQueue class contains ONLY ONE no-argument constructor that creates an empty
  // CustomProcessQueue.
  public CustomProcessQueue() {
    heap = new CustomProcess[INITIAL_CAPACITY];
    int size = 0; // since 0 index should be kept empty
  }


  // So is minHeapPercolateUp supposed to be used as a helper method whenever we call enqueue in order
  // to correctly place the newly added node in the heap?
  private void minHeapPercolateUp(int index) {
    // TODO: remove system print messages

    CustomProcess newProcess;
    CustomProcess nextProcess;

    newProcess = heap[0];
    nextProcess = heap[index];

    if (nextProcess == null) {
      heap[index] = (CustomProcess) newProcess;
      return;
    } else {

      // if next is higher priority
      if (newProcess.compareTo(nextProcess) > 0) {
        // System.out.println("Next is higher priority.Going to next iterationg");

        //// call inHeapPercolateUp with index+1
        minHeapPercolateUp(index + 1);
      } else if (newProcess.compareTo(nextProcess) < 0) {
        // if next is lower priority
        // push everything back by 1
        // /System.out.println("P1 is lower prioirity. Index: " + index);


        for (int i = this.size; i > index; i--) {
          heap[i] = heap[i - 1];
        }
        heap[index] = null;

        minHeapPercolateUp(index);
      } else if (newProcess.compareTo(nextProcess) == 0) {
        System.err.println("Same process is trying to be added. Not sure what to do.");
        // TODO: what to do if same process?
      }
    }
  }

  // minHeapPercolateDown is the helper method for dequeue when we need to replace the root node with
  // a new node?
  private void minHeapPercolateDown(int index) {

    for (int i = index; i < size(); i++) {
      heap[i] = heap[i + 1];
    }

    heap[size()] = null;
    this.size--;

  }

  // inserts a newObject in the priority queue
  public void enqueue(CustomProcess newObject) {

    heap[0] = newObject;
    this.size++;

    minHeapPercolateUp(1);
    heap[0] = null;

  }

  // removes and returns the item with the highest priority
  public CustomProcess dequeue() {

    if (!isEmpty()) {
      CustomProcess removeProcess = this.heap[1];

      // TODO: remove and shift all one down
      minHeapPercolateDown(1);

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
