package algs.ch2.sorting.creativeproblems;

import edu.princeton.cs.algs4.Queue;

/**
 * <code>creative-problem-2.2.14</code>
 * 
 * <p>Testes em {@link TestSortedQueues}
 * 
 * <p>Eu juro que não olhei a resposta do carinha antes de fazer a minha própria
 * solução.
 */
public class SortedQueues {
  /**
   * Junta duas filas ordenadas
   * @param q1  primeira fila ordenada
   * @param q2  segunda fila ordenada
   * @return a fila ordenada resultado da concatenação de q1 com q2
   */
  public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
    Queue<Integer> mergedQueue = new Queue<>();

    while (!q1.isEmpty() && !q2.isEmpty()) {
      int n1 = q1.peek();
      int n2 = q2.peek();

      if (n1 < n2) {
        mergedQueue.enqueue(q1.dequeue());
      }
      else {
        mergedQueue.enqueue(q2.dequeue());
      }
    }

    while(!q1.isEmpty()) {
      mergedQueue.enqueue(q1.dequeue());
    }

    while(!q2.isEmpty()) {
      mergedQueue.enqueue(q2.dequeue());
    }

    return mergedQueue;
  }

  
  public static boolean isSorted(Queue<Integer> q) {
    if (q == null)
      return false;
    if (!q.isEmpty())
      return true;

    int previousItem = q.peek();

    for (Integer nextItem : q) {
      if (nextItem >= previousItem)
        return false;
      previousItem = nextItem;
    }

    return true;
  }


  public static void main(String[] args) {
    Queue<Integer> evenNumbers = new Queue<>();
    Queue<Integer> oddNumbers = new Queue<>();

    for (int i = 0; i < 10; i += 2) {
      evenNumbers.enqueue(i);
    }

    for (int i = 1; i < 16; i += 2) {
      oddNumbers.enqueue(i);
    }

    System.out.println(evenNumbers);
    System.out.println(oddNumbers);

    System.out.println(SortedQueues.merge(evenNumbers, oddNumbers));
  }
}
