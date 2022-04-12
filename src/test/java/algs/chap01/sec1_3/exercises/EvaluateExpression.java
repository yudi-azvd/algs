package algs.chap01.sec1_3.exercises;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class EvaluateExpression {
  public static void main(String[] args) {
    In in = new In("./algs4-data/evaluate1.txt");

    Stack<String> operators = new Stack<>();
    Stack<Double> values = new Stack<>();

    while (!in.isEmpty()) {
      String token = in.readString();

      if (token.equals("("))
        ;
      else if (isOperator(token)) 
        operators.push(token);
      else if (token.equals(")")) {
        String operator = operators.pop();
        double value = values.pop();

        if (operator.equals("+"))
          value = values.pop() + value;
        else if (operator.equals("-"))
          value = values.pop() - value;
        else if (operator.equals("*"))
          value = values.pop() * value;
        else if (operator.equals("/"))
          value = values.pop() / value;
        
        values.push(value);
      }
      else 
        values.push(Double.parseDouble(token));
    }
    
    System.out.println(values.pop());
  }

  public static boolean isOperator(String token) {
    if (token.equals("+"))
      return true;
    if (token.equals("-"))
      return true;
    if (token.equals("*"))
      return true;
    if (token.equals("/"))
    return true;
    if (token.equals("sqrt"))
      return true;
    return false;
  }
}