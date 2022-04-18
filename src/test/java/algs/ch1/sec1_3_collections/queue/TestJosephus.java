package algs.ch1.sec1_3_collections.queue;
// package AlgorithmsPrincetonCourse.Queue;

// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.util.Iterator;

// import org.junit.Test;
// import org.junit.jupiter.api.DisplayName;

// import AlgorithmsPrincetonCourse.Queue.Josephus.Person;
// import edu.princeton.cs.algs4.Queue;

// public class TestJosephus {
//   Queue<Person> eliminatedPeople = new Queue<>();
  
//   @DisplayName("n = 7, m = 2")
//   @Test
//   public void testJosephus() {
    
//     Queue<Person> eliminated = Josephus.josephus(7, 2);
//     assertTrue(check(eliminated, 7, 2));
//   }

//   private boolean check(Queue<Person> eliminatedPeople, int n, int m) {
//     int mn = m*n;
//     int[] repeatingPeople = new int[mn];

//     for (int i = 0; i < mn; i++) {
//       repeatingPeople[i] = i % n;
//     }

//     Queue<Person> correct = new Queue<>();

//     int mCounter = 1;
//     for (int i = 0; i < repeatingPeople.length; i++, mCounter++) {
//       if (mCounter % m == 0) {
//         correct.enqueue(new Person(repeatingPeople[i]));
//       }
//     }

//     return areEqual(correct, eliminatedPeople);
//   }

//   private static boolean areEqual(Queue<Person> q1, Queue<Person> q2) {
//     if (q1.size() != q2.size()) 
//       return false;

//     Iterator<Person> it1 = q1.iterator();
//     Iterator<Person> it2 = q2.iterator();

//     while (it1.hasNext() && it2.hasNext())
//       if (it1.next().id() != it2.next().id())
//         return false;

//     return true;
//   }
// }