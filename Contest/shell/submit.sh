#!/bin/bash

cat ~/contest/parts/submit_part1.txt > ~/contest/submit.java
cat c:/users/takeru/git/Contest/Contest/AlgorithmAndData/$1.java | sed -e "s/$1/Main/" >> ~/contest/submit.java
cat ~/contest/parts/submit_part2.txt >> ~/contest/submit.java

