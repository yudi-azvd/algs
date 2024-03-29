/******************************************************************************
 *  Name:    Yudi Yamane
 *  NetID:   yudi
 *  Precept: P01
 *
 *  Description:  Modeling Percolation using an N-by-N grid and Union-Find data
 *                structures to determine the threshold.
 ******************************************************************************/
package algs.assignments.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private int n; // virtual? grid height and width.
  private int openSites; // number open sites.
  private boolean[][] grid; // N-by-N grid
  private WeightedQuickUnionUF unionFind; // disjoint set representing the
                                          // connection in the N-by-N grid.
  // private WeightedQuickUnionUF unionFindOpenSites; // ?
  // private WeightedQuickUnionUF unionFindFullSites; // ?

  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be positive");
    }

    // maybe this.n is not needed because we have grid[][]
    this.n = n;
    grid = new boolean[n][n];
    unionFind = new WeightedQuickUnionUF(n*n + 2);
    openSites = 0;

    for (int i = 0; i <= n; i++) {
      unionFind.union(0, i);
    }
    for (int i = n*n-n+1; i < n*n+1; i++) {
      unionFind.union(n*n + 1, i);
    }

    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        grid[row][col] = false;
      }
    }
  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col) {
    validate(row, col);
    row--;
    col--;

    int unionFindIndex = xyTo1D(row, col);
    int nSquared = this.n*this.n;
    // only proceed if unionFindIndex is not connected to virtual nodes
    // (if there was a unionFind for OPEN SITES)
    // if (something)
    //   return

    if (!grid[row][col]) {
      openSites++;
      grid[row][col] = true;
    }

    // Only connect in unionFind if neighbor is already open.
    // top neighbor
    if (unionFindIndex - this.n >= 0 && row-1 >= 0 && grid[row-1][col]) {
      unionFind.union(unionFindIndex, unionFindIndex - this.n);
    }

    // bottom neighbor
    if (unionFindIndex + this.n < nSquared && row+1 < this.n && grid[row+1][col]) {
      unionFind.union(unionFindIndex, unionFindIndex + this.n);
    }

    // left neighbor
    if (unionFindIndex - 1 >= 0 && col-1 >= 0 && grid[row][col-1]) {
      unionFind.union(unionFindIndex, unionFindIndex - 1);
    }

    // right neighbor
    if (unionFindIndex + 1 < nSquared && col+1 < n && grid[row][col+1]) {
      unionFind.union(unionFindIndex, unionFindIndex + 1);
    }
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
    validate(row, col);
    // is there another way without using grid?
    // is the site connected to the top or bottom row?
    // yes => true
//    return true;
    row--;
    col--;
    return grid[row][col];
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
    validate(row, col);
    // int fullNeighbors = 0;
    row--;
    col--;
    int unionFindIndex = xyTo1D(row, col);
    // boolean hasAtLeastOneFullNeighbor = false; // count full neighbors around
    // (row,col). if there's is more than one, it is def full.
    boolean isConnectedToTopVirtualNode =
      (unionFind.find(0) == unionFind.find(unionFindIndex))
      && (grid[row][col]);

    // top neighbor
    // if (unionFindIndex - this.n >= 0 && row-1 >= 0 && grid[row-1][col]
    // && unionFind.find(0) == unionFind.find(unionFindIndex-this.n)) {
    //   hasAtLeastOneFullNeighbor = true;
    // }

    return isConnectedToTopVirtualNode;
  }

  // returns the number of open sites
  public int numberOfOpenSites() {
    return openSites;
  }

  // does the system percolate?
  public boolean percolates() {
    // top row connected to bottom row?
    return unionFind.find(0) == unionFind.find(this.n*this.n+1);
  }

  // converts virtual grid coordinates to union find index
  private int xyTo1D(int y, int x) {
    return y*this.n + x + 1;
  }

  // validates grid coordinates
  private void validate(int row, int col) {
    if (!(0 < row && row <= this.n) || !(0 < col && col <= this.n))
      throw new IllegalArgumentException(
        "Row or column indices are out of range [1,"+this.n+"]."
        + "Got (" + row + "," + col +")"
      );
  }

  // test client (optional)
  // public static void main(String[] args) {
    // Percolation p = new Percolation(5);
    // System.out.println(p.isOpen(0, 0));
  // }
}