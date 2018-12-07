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
 * WaitingQueueADT Interface for SJF PROCESS SCHEDULER
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */

public interface WaitingQueueADT<T extends Comparable<T>> {

  /**
   * Add an element to this queue
   * 
   * @param element an element to be added
   */
  public void enqueue(T newObject);

  /**
   * Removes and returns the item with the highest priority
   * 
   * @return the element the item with the highest priority
   */
  public T dequeue();

  /**
   * Get the element with the highest priority
   * 
   * @return the element with the highest priority
   */
  public T peek();

  /**
   * Get the number of elements in the queue
   * 
   * @return the size of the queue
   */
  public int size();

  /**
   * Returns true if this queue contains no elements.
   * 
   * @return true if this queue contains no elements, otherwise false
   */
  public boolean isEmpty();
}
