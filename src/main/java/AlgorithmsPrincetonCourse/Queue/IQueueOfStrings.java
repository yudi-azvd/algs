package AlgorithmsPrincetonCourse.Queue;

interface IQueueOfStrings {
  public void enqueue(String item);
  
  public String dequeue();

  public boolean isEmpty();
}