#!/bin/bash
cd ./src/main/java/AlgorithmsPrincetonCourse/percolation

# inside percolation directory
mkdir -p percolation
cp Percolation.java ./percolation
cp PercolationStats.java ./percolation
zip -r percolation.zip ./percolation
rm -r ./percolation