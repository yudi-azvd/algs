#!/bin/bash
cd ./src/main/java/AlgorithmsPrincetonCourse/Assignments/percolation

# inside percolation directory
mkdir -p percolation
cp Percolation.java ./percolation
cp PercolationStats.java ./percolation
sed -i '/package AlgorithmsPrincetonCourse.Assignments.percolation;/d' ./percolation/Percolation.java
sed -i '/package AlgorithmsPrincetonCourse.Assignments.percolation;/d' ./percolation/PercolationStats.java
zip -r percolation.zip ./percolation
rm -r ./percolation

