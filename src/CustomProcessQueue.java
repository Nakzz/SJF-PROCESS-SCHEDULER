public abstract class CustomProcessQueue implements WaitingQueueADT {
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
  // Your CustomProcessQueue class contains ONLY ONE no-argument constructor that creates an empty
  // CustomProcessQueue.
  // dequeue() and peek() methods SHOULD return null if they are called on an empty
  // CustomProcessQueue.
  // In addition to implementing ALL the methods defined in the WaitingQueueADT interface, your
  // CustomProcessQueue must have the following two private methods:
  // NOTE that you can add as many private helper methods as you judge necessary to implement the
  // defined behavior of your CustomProcessQueue class.
  // You can defined public getter methods if needed (to test your implementation for instance). But,
  // NO further public method should be added to your class.

  private void minHeapPercolateUp(int index) {


  }

  private void minHeapPercolateDown(int index) {

  }

}
