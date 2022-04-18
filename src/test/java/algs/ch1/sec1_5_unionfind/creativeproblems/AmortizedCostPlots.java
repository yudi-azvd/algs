package algs.ch1.sec1_5_unionfind.creativeproblems;

import algs.ch1.sec1_5_unionfind.QuickFindDisjointSet;
import algs.ch1.sec1_5_unionfind.QuickUnionDisjointSet;
import algs.ch1.sec1_5_unionfind.WeightedQuickUnionDisjointSet;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class AmortizedCostPlots {
  public static void main(String[] args) {
    // plot_qf();
    // plot_qu();
    plot_wqu();
  }

  public static void plot_qu() {
    In in = new In("algs4-data/mediumUF.txt");

    int n = in.readInt();
    int p, q, cost, total = 0;
    int iethConnection = 1;

    QuickUnionDisjointSet set = new QuickUnionDisjointSet(n);

    StdDraw.setPenRadius(0.005);
    StdDraw.setXscale(0, 900);
    StdDraw.setYscale(0, 1300);
    
    while (!in.isEmpty()) {
      p = in.readInt();
      q = in.readInt();
      set.union(p, q);
      cost = set.getCost();
      total = set.getTotal();
      
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.point(iethConnection, cost);
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.point(iethConnection, total/iethConnection);
      iethConnection++;
    }

    StdDraw.show();
  }


  public static void plot_wqu() {
    In in = new In("algs4-data/mediumUF.txt");
    StdDraw.show();


    int n = in.readInt();
    int p, q, cost, total = 0;
    int iethConnection = 1;

    WeightedQuickUnionDisjointSet set = new WeightedQuickUnionDisjointSet(n);

    StdDraw.setPenRadius(0.005);
    StdDraw.setXscale(0, 900);
    StdDraw.setYscale(0, 40);
    
    while (!in.isEmpty()) {
      p = in.readInt();
      q = in.readInt();
      set.union(p, q);
      cost = set.getCost();
      total = set.getTotal();
      
      StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
      StdDraw.point(iethConnection, cost);
      StdDraw.setPenColor(StdDraw.GREEN);
      StdDraw.point(iethConnection, total/iethConnection);
      iethConnection++;
    }
  }


  public static void plot_qf() {
    In in = new In("algs4-data/mediumUF.txt");
    StdDraw.show();


    int n = in.readInt();
    int p, q, cost, total = 0;
    int iethConnection = 1;

    QuickFindDisjointSet set = new QuickFindDisjointSet(n);

    StdDraw.setPenRadius(0.005);
    StdDraw.setXscale(0, 900);
    StdDraw.setYscale(0, 1300);
    
    while (!in.isEmpty()) {
      p = in.readInt();
      q = in.readInt();
      set.union(p, q);
      cost = set.getCost();
      total = set.getTotal();
      
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.point(iethConnection, cost);
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.point(iethConnection, total/iethConnection);
      iethConnection++;
    }
  }
}