#!/bin/bash

cat ./parts/submit_part1.txt > ./submit.java
cat ../AlgorithmAndData/$1.java | sed -e "s/$1/Main/" >> ./submit.java
cat ./parts/submit_part2.txt >> ./submit.java

