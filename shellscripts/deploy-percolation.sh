#!/bin/bash
cd ./src/main/java/AlgorithmsPrincetonCourse/percolation

# inside percolation directory
mkdir -p percolation
cp Percolation.java ./percolation
cp PercolationStats.java ./percolation
sed -i '/package AlgorithmsPrincetonCourse.percolation;/d' ./percolation/Percolation.java
sed -i '/package AlgorithmsPrincetonCourse.percolation;/d' ./percolation/PercolationStats.java
zip -r percolation.zip ./percolation
rm -r ./percolation