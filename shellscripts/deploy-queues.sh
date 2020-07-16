#!/bin/bash
cd ./src/main/java/AlgorithmsPrincetonCourse/Assignments/queues
mkdir -p queues
cp LinkedListDeque.java ./queues

cd ./queues
mv LinkedListDeque.java Deque.java

# remove line with
sed -i '/package AlgorithmsPrincetonCourse.Assignments.queues;/d' ./Deque.java


# replace all "LinkedList" ocurrences  by "Deque"
# https://stackoverflow.com/questions/525592/find-and-replace-inside-a-text-file-from-a-bash-command
sed -i -e 's/LinkedListDeque/Deque/g' Deque.java

# \s means white space
sed -i -e 's/,\sIDeque<Item>//g' Deque.java

# make file executable: chmod +x filename