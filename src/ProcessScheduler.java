import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
 * ProcessScheduler Class for SJF PROCESS SCHEDULER which is also the driver class of the
 * application
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */

public class ProcessScheduler {
  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private CustomProcessQueue queue; // this processing unit's custom process queue


  /**
   * Creates a new ProcessScheduler object
   */
  public ProcessScheduler() {
    this.currentTime = 0;
    this.numProcessesRun = 0;

    queue = new CustomProcessQueue();
  }


  /**
   * Get the number of processes ran so far
   * 
   * @return the number of processes ran so far
   */
  public int getNumProcessesRun() {
    return this.numProcessesRun;
  }


  /**
   * Get the current time after the last run
   * 
   * @return the current time after the last run
   */
  public int getCurrentTime() {
    return this.currentTime;
  }

  /**
   * Enqueues the given process in the CustomProcessQueue queue.
   * 
   * @param process
   */
  public void scheduleProcess(CustomProcess process) {

    queue.enqueue(process);

    System.out.println("Process ID " + process.getProcessId() + " scheduled. Burst Time = "
      + process.getBurstTime());
  }

  /**
   * Starts running the ready processes already scheduled in the queue according to the SJF scheduling
   * policy. This method returns when all the scheduled processes are run and the queue is empty. It
   * returns a String that represents the log of one run operation.
   * 
   * @return log of the completed operation
   */
  public String run() {

    String log = "";

    int numofprocess = queue.size();

    if (queue.size() > 1) // Log based on number of processes
      log += "Starting " + numofprocess + " processes\n\n";
    else
      log += "Starting " + numofprocess + " process\n\n";


    // "Run" each process and remove them from heap while logging
    for (int x = 0; x < numofprocess; x++) {
      CustomProcess currProcess = queue.dequeue();

      log += "Time " + (this.currentTime) + " : Process ID " + currProcess.getProcessId()
        + " Starting.\n";

      this.currentTime += currProcess.getBurstTime();

      log += "Time " + (this.currentTime) + " : Process ID " + currProcess.getProcessId()
        + " Completed.\n";

      this.numProcessesRun++;
    }

    log += "\nTime " + this.currentTime + " : All scheduled processes completed.\n";

    return log;

  }

  /**
   * Driver method of the class
   * 
   */

  public static void main(String[] args) {

    Scanner scnr;


    // // test inputs from file
    // File file = new File("C:/Temp/JAVA/SJF Process Scheduler/zybooksTest.txt");
    // try {
    // scnr = new Scanner(file);
    // } catch (FileNotFoundException e1) {
    //
    // e1.printStackTrace();
    // scnr = new Scanner(System.in); // initialize scanner object
    // }

    scnr = new Scanner(System.in); // initialize scanner object


    String userInput, command, log = "";
    String[] userInputs;
    int burstTime = 0;
    boolean quit = false;
    boolean run = true;
    ProcessScheduler scheduler = new ProcessScheduler();
    CustomProcess newProcess;

    System.out.println("==========   Welcome to the SJF Process Scheduler App   ========\n");

    // loop to run
    while (!quit) {

      System.out.println("Enter command:");
      System.out.println("[schedule <burstTime>] or [s <burstTime>]");
      System.out.println("[run] or [r]");
      System.out.println("[quit] or [q]");
      System.out.println("");



      userInput = scnr.nextLine().trim(); // process input

      if (userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("q")) { // ends loop if quit is entered

        System.out.println(
          scheduler.getNumProcessesRun() + " processes run in " + scheduler.getCurrentTime()
            + " units of time!\n" + "Thank you for using our scheduler!");
        System.out.println("Goodbye!");
        break;
      }

      userInputs = userInput.trim().split(" ");

      if (userInputs.length > 2) {
        System.out.print("WARNING: Please enter a valid command!\n");
      } else {

        try {
          command = userInputs[0].trim().toLowerCase();

          if (userInputs.length == 2) {
            burstTime = Integer.parseInt(userInputs[1]);

          }

          switch (command) {
            case "r": {

              log = scheduler.run();
              break;
            }

            case "run": {

              log = scheduler.run();
              break;
            }

            case "schedule": {
              if (userInputs.length != 2 || burstTime < 1) {
                System.out.println("WARNING: burst time MUST be greater than 0!"); // warning message
                run = false;
              } else
                run = true;
              if (run) {
                newProcess = new CustomProcess(burstTime);
                scheduler.scheduleProcess(newProcess);
              }
              break;
            }

            case "s": {
              if (userInputs.length != 2 || burstTime < 1) {
                System.out.println("WARNING: burst time MUST be greater than 0!"); // warning message
                run = false;
              } else
                run = true;
              if (run) {
                newProcess = new CustomProcess(burstTime);
                scheduler.scheduleProcess(newProcess);
              }
              break;
            }

            default: {
              System.out.print("WARNING: Please enter a valid command!\n");
              break;
            }
          }
          System.out.print(log);
          log = "";

        } catch (Exception e) {
          System.out.print("WARNING: burst time MUST be an integer!"); // warning message
          run = false;
        }
      }
      System.out.println();
    }
    scnr.close(); // Because I wouldn't want someone to leave me turned on.
  }

}
