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
// Online Sources: //
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * Test class for SJF PROCESS SCHEDULER
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */
public class ProcessSchedulerTests {

  /**
   * Main method for tests 
   */
  public static void main(String[] args) {

    int test = 4;

    if (CustomProcessTest())
      test--;
    else
      System.out.println("CustomProcess() failed!");

    if (testEnqueueCustomProcessQueue())
      test--;
    else
      System.out.println("testEnqueueCustomProcessQueue() failed!");

    if (testDequeueCustomProcessQueue())
      test--;
    else
      System.out.println("testDequeueCustomProcessQueue() failed!");

    if (testDoubleArraySize())
      test--;
    else
      System.out.println("testDoubleArraySize() failed!");



    System.out.println(test + " tests failed!");


  }

  /**
   * This method ensures CustomProcess method works properly
   * 
   * @return true if test passed, false if failed
   */
  public static boolean CustomProcessTest() {
    CustomProcess testProcess = new CustomProcess(1);
    CustomProcess testProcess2 = new CustomProcess(4);

    boolean testPassed = true;

    if (testProcess.getProcessId() != 1)
      testPassed = false;

    if (testProcess2.getProcessId() != 2)
      testPassed = false;

    // System.out.println(testProcess2.getBurstTime());

    if (!(testProcess.compareTo(testProcess2) < 0))
      testPassed = false;

    return testPassed;

  }

  /**
   * This method ensures enqueueCustomProcessQueue method works properly
   * 
   * @return true if test passed, false if failed
   */
  public static boolean testEnqueueCustomProcessQueue() {

    CustomProcessQueue testQueue = new CustomProcessQueue();

    CustomProcess testProcess = new CustomProcess(1);
    CustomProcess testProcess4 = new CustomProcess(4);
    CustomProcess testProcess2 = new CustomProcess(2);
    boolean testPassed = true;


    testQueue.enqueue(testProcess);

    if (testQueue.size() != 1)
      testPassed = false;

    if (!testQueue.peek().equals(testProcess))
      testPassed = false;

    testQueue.enqueue(testProcess4);
    if (testQueue.size() != 2)
      testPassed = false;


    testQueue.enqueue(testProcess2);
    if (testQueue.size() != 3)
      testPassed = false;

    if (!testQueue.peek().equals(testProcess))
      testPassed = false;

    testQueue.enqueue(new CustomProcess(2));
    testQueue.enqueue(new CustomProcess(3));
    testQueue.enqueue(new CustomProcess(6));

    // for(int x=1; x<= testQueue.size(); x++) {
    // System.out.println("ProcessID: "+testQueue.processAtIndex(x).getProcessId() + " burst Time:
    // "+testQueue.processAtIndex(x).getBurstTime());
    // }
    //
    // System.out.println("");


    return testPassed;
  } // checks the correctness of the enqueue
    // operation implemented in the CustomProcessQueue class

  /**
   * This method ensures dequeueCustomProcessQueue method works properly
   * 
   * @return true if test passed, false if failed
   */
  public static boolean testDequeueCustomProcessQueue() {
    CustomProcessQueue testQueue = new CustomProcessQueue();

    boolean testPassed = true;
    CustomProcess testProcess = new CustomProcess(1);
    testQueue.enqueue(new CustomProcess(2));
    testQueue.enqueue(new CustomProcess(3));
    testQueue.enqueue(new CustomProcess(6));
    testQueue.enqueue(testProcess);


    for (int x = 0; x <= testQueue.size(); x++) {
      testQueue.dequeue();
    }

    if (testQueue.size() != 1)
      testPassed = false;

    testQueue.dequeue();

    if (testQueue.size() != 0)
      testPassed = false;


    // for(int x=1; x<= testQueue.size(); x++) {
    // System.out.println("ProcessID: "+testQueue.processAtIndex(x).getProcessId() + " burst Time:
    // "+testQueue.processAtIndex(x).getBurstTime());
    // }

    return testPassed;
  } // checks the correctness of the dequeue
    // operation implemented in the CustomProcessQueue class

  
  /**
   * This method ensures doubleArraySize method works properly
   * 
   * @return true if test passed, false if failed
   */
  public static boolean testDoubleArraySize() {
    CustomProcessQueue testQueue = new CustomProcessQueue();

    boolean testPassed = true;
    for(int i=1; i< 42; i++) { // adds a lot of processes
      testQueue.enqueue(new CustomProcess(i));
    }
    
    for(int i=1; i< 42; i++) { // // adds more processes 
      testQueue.enqueue(new CustomProcess(i));
    }
    

//
//    System.out.println("testQueue.size(): "+testQueue.size());

//    if (testQueue.size() != 1)
//      testPassed = false;
//
    if (testQueue.size() > 90)
      testPassed = false;


    return testPassed;
  } 
  
  

}
