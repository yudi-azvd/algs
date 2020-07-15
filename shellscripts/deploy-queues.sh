#!/bin/bash
cd ./src/main/java/AlgorithmsPrincetonCourse/Assignments/queues
mkdir -p queues
cp LinkedListDeque.java ./queues

cd ./queues
mv LinkedListDeque.java Deque.java
sed -i '/package AlgorithmsPrincetonCourse.Assignments.queues;/d' ./Deque.java

# search and replace
# https://stackoverflow.com/questions/525592/find-and-replace-inside-a-text-file-from-a-bash-command
sed -i -e 's/LinkedListDeque/Deque/g' Deque.java

# make faile executable: chmod +x filename