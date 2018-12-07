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
 * CustomProcess Class for SJF PROCESS SCHEDULER
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */

public class CustomProcess implements java.lang.Comparable<CustomProcess> {

  private static int nextProcessId = 1; // stores the id to be assigned to the next process
  // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution


  /**
   * Creates a new CustomProcess object with burstTime param
   * 
   * @param burstTime time to complete the Process
   */
  public CustomProcess(int burstTime) {
    this.burstTime = burstTime;
    this.PROCESS_ID = this.nextProcessId;
    this.nextProcessId++;
  }

  /**
   * PROCESS_ID accessor of the object
   * 
   * @return PROCESS_ID of the object
   */
  public int getProcessId() {
    return this.PROCESS_ID;
  }

  /**
   * burstTime accessor of the object
   * 
   * @return burstTime of the object
   */
  public int getBurstTime() {
    return this.burstTime;
  }

  /**
   * Compares processes. Having the smaller burst time should be run first. If two CustomProcess-es
   * have the same burstTime, the process with the lower processId should be run first.
   * 
   * param other process objectbeing compared to current process object return -1 if current process
   * has smaller process_ID or burst time 1 if compared process has smaller process_ID or burst time 0
   * if same process
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   * 
   */
  public int compareTo(CustomProcess other) {

    if (this.burstTime < other.getBurstTime())
      // p1 is higher priority/smaller
      return -1;
    else if (this.burstTime > other.getBurstTime())
      // p2 is higher priority/smaller
      return 1;
    else if (other.getBurstTime() == this.burstTime) {
      if (other.getProcessId() > this.PROCESS_ID)
        // p1 is higher priority/smaller
        return -1;
      else if (other.getProcessId() < this.PROCESS_ID)
        // p2 is higher priority/smaller
        return 1;
      else if (other.getProcessId() == this.PROCESS_ID)
        return 0; // if comes to this, it is the same process object
    }
    // will never reach

    System.err.println("Should never reach this in Custom process. Check");
    return 0;
  }


}
