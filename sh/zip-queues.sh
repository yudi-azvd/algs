#!/bin/bash
cd ./src/main/java/AlgorithmsPrincetonCourse/Assignments/queues
mkdir -p queues
cp LinkedListDeque.java ./queues
cp RandomizedQueue.java ./queues
cp Permutation.java ./queues

# rename file
cd ./queues
mv LinkedListDeque.java Deque.java


###
### LinkedListDeque
# remove line with
sed -i '/package AlgorithmsPrincetonCourse.Assignments.queues;/d' ./Deque.java

# replace all "LinkedList" ocurrences  by "Deque"
# https://stackoverflow.com/questions/525592/find-and-replace-inside-a-text-file-from-a-bash-command
sed -i -e 's/LinkedListDeque/Deque/g' Deque.java

# \s means white space
sed -i -e 's/,\sIDeque<Item>//g' Deque.java


###
### RandomizedQueue
sed -i '/package AlgorithmsPrincetonCourse.Assignments.queues;/d' ./RandomizedQueue.java
sed -i '/@SuppressWarnings("unchecked")/d' ./RandomizedQueue.java


###
### RandomizedQueue
sed -i '/package AlgorithmsPrincetonCourse.Assignments.queues;/d' ./Permutation.java


# zip files
cd ..
zip -r queues.zip ./queues 
rm -r ./queues

# make file executable: chmod +x filename