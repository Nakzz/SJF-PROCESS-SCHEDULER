public class CustomProcess implements java.lang.Comparable<CustomProcess> {

  //TODO: Comment this class
  private static int nextProcessId = 1; // stores the id to be assigned to the next process
  // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  public CustomProcess(int burstTime) {
    this.burstTime = burstTime;
    this.PROCESS_ID = this.nextProcessId;
    this.nextProcessId++;
  }

  public int getProcessId() {
    return this.PROCESS_ID;
  }
  
  public int getBurstTime() {
    return this.burstTime;
  }
  
  /*
   * It is worth to keep in mind that the process having the smaller burst time should be run first.
   * If two CustomProcess-es have the same burstTime, the process with the lower processId should be
   * run first.
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  public int compareTo(CustomProcess other) {
    // TODO IMplement this method
    
    
    if(this.burstTime < other.getBurstTime()  )
      //p1 is higher priority/smaller
      return -1;
      else if (this.burstTime > other.getBurstTime())
        //p2 is higher priority/smaller
        return 1;
      else if(other.getBurstTime() == this.burstTime) {
        if(other.getProcessId() > this.PROCESS_ID)
          //p1 is higher priority/smaller
          return -1;
          else if (other.getProcessId() < this.PROCESS_ID)
          //p2 is higher priority/smaller
            return 1;
          else if ( other.getProcessId() == this.PROCESS_ID) return 0;    //if comes to this, it is the same process object
      }
        //will never reach
    //TODO: remove this err line
    System.err.println("Should never reach this in Custom process. Check");
        return 0;
  }


}
