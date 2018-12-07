//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SJF PROCESS SCHEDULER
// Course: CS300, Fall 2018
//
// Author: Ajmain Naqib
// Email: naqib@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __ Write-up states that pair programming is allowed for this assignment.
// __ We have both read and understand the course Pair Programming Policy.
// __ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources:
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * CustomProcessQueue Class for SJF PROCESS SCHEDULER that contains all the processes
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue


  /**
   * Creates a new CustomProcessQueue object
   */
  public CustomProcessQueue() {
    this.heap = new CustomProcess[INITIAL_CAPACITY];
    this.size = 0; // since 0 index should be kept empty
  }

  /**
   * Helper method for enqueue() to correctly place the newly added node in the heap using Binary
   * insertion
   * 
   * @param index of the process to check
   */

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

  /**
   * Helper method for dequeue() replace the root node with the node after it until end of the heap is
   * reached
   * 
   * @param index of the process to check
   */
  private void minHeapPercolateDown(int index) {

    // Slides each element down by one spot
    for (int i = index; i < size(); i++) {
      heap[i] = heap[i + 1];
    }

    heap[size()] = null;


  }

  /**
   * Helper method to double the size of the current heap
   * 
   */
  private void doubleArraySize() {

    CustomProcess[] newheap = new CustomProcess[this.heap.length * 2];

    for (int i = 0; i < this.size; i++) { // Copying into new array
      newheap[i] = this.heap[i];
    }

    this.heap = newheap;
  }

  /**
   * Inserts a newObject in the queue with highest priority being at the front
   * 
   * param newObject that is being added
   */
  //
  public void enqueue(CustomProcess newObject) {

    if (this.isEmpty()) { // Put in first index
      this.heap[1] = newObject;
      this.size++;
    } else {
      if (size + 1 < this.heap.length) { // if contains space, call helper
        this.size++;
        this.heap[size] = newObject;
        minHeapPercolateUp(this.size);

      } else {
        doubleArraySize(); // if array doesn't contain space, expand it
      }
    }
  }


  /**
   * Removes and returns the item with the highest priority
   * 
   * return the item with the highest priority. Null if size of the array is 0
   */
  public CustomProcess dequeue() {

    if (!isEmpty()) {
      CustomProcess removeProcess = this.heap[1]; // Since highest priority is at 1

      minHeapPercolateDown(1);

      this.size--;

      return removeProcess;
    } else
      return null;
  }


  /**
   * Returns the item with the highest priority
   * 
   * return the item with the highest priority. Null if size of the array is 0
   */
  public CustomProcess peek() {

    if (!isEmpty())
      return this.heap[1]; // Since highest priority is at 1

    else
      return null;
  }

  /**
   * Get the number of elements in the queue
   * 
   * @return the size of the queue
   */
  public int size() {
    return this.size;
  }

  /**
   * Returns true if this queue contains no elements.
   * 
   * @return true if this queue contains no elements, otherwise false
   */
  public boolean isEmpty() {
    if (this.size == 0) {
      return true;
    }
    return false;
  }


  /**
   * Returns the item at specific index. Method for testing.
   * 
   * @param index of the item
   * @return object at the index
   */
  public CustomProcess processAtIndex(int index) {
    if (!isEmpty()) {

      return this.heap[index];

    }
    return null;
  }

}
