package AlgorithmsPrincetonCourse.RandomizedQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.LinkedList;

import org.junit.Test;

import AlgorithmsPrincetonCourse.Assignments.queues.RandomizedQueue;

public class RandomizedQueueTest {
  private void fillArrayWithSequence(int[] a){
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
  }
  
  // private void printQueue(RandomizedQueue<Integer> queue) {
  //   for (int item1 : queue) {
  //     for (int item2 : queue) {
  //       System.out.print(item1 + "-" + item2 + " ");
  //     }
  //     System.out.println();
  //   }
  // }
  
  // private boolean checkQueueNestedIterators(RandomizedQueue<Integer> queue, int[] originalArray) {
  //   LinkedList<Integer> list1 = new LinkedList<>();
  //   LinkedList<Integer> list2 = new LinkedList<>();
    
  //   for (int item1 : queue) {
  //     for (int item2 : queue) {
  //       assertEquals(true, arrayContains(originalArray, item1));
  //       assertEquals(true, arrayContains(originalArray, item2));
        
  //       list1.add(item1);
  //       list2.add(item2);
  //     }
      
  //     System.out.println(list1);
  //     System.out.println(list2);
      
  //     assertFalse("items should be in different order", !list1.equals(list2));
  //   }
    
  //   return true;
  // }
  
  private boolean checkQueueParallelIterators(RandomizedQueue<Integer> queue, int[] originalArray) {
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    
    for (int item1 : queue) {
      list1.add(item1);
      assertEquals(true, arrayContains(originalArray, item1));
    }
    
    System.out.println(list1);
    
    for (int item2 : queue) {
      assertEquals(true, arrayContains(originalArray, item2));
      list2.add(item2);
    }
    
    System.out.println(list2);
    assertFalse("items should be in different order", list1.equals(list2));
    
    return true;
  }
  
  private boolean arrayContains(int[] a, int value) {
    for (int item : a) {
      if (item == value)
      return true;
    }
    return false;
  }
  
  private void fillQueueWithSequence(RandomizedQueue<Integer> queue, int n) {
    for (int i = 0; i < n; i++) {
      queue.enqueue(i);
    }
  }
  
  // @Test
  // public void test9() {
  //   int n = 10;
  //   int[] originalArray = new int[n];
  //   fillArrayWithSequence(originalArray);
    
  //   RandomizedQueue<Integer> queue = new RandomizedQueue<>();
    
  //   fillQueueWithSequence(queue, n);    
  //   checkQueueNestedIterators(queue, originalArray);
    
  //   n = 50;
  //   originalArray = new int[n];
  //   fillArrayWithSequence(originalArray);
  //   fillQueueWithSequence(queue, n);    
    
  //   checkQueueNestedIterators(queue, originalArray);
  // }
  
  @Test
  public void test10() {
    int n = 10;
    int[] originalArray = new int[n];
    fillArrayWithSequence(originalArray);
    
    RandomizedQueue<Integer> queue = new RandomizedQueue<>();
    
    fillQueueWithSequence(queue, n);    
    checkQueueParallelIterators(queue, originalArray);
    
    n = 50;
    originalArray = new int[n];
    fillArrayWithSequence(originalArray);
    fillQueueWithSequence(queue, n);    
    
    checkQueueParallelIterators(queue, originalArray);
  }
}