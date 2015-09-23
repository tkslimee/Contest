#!/bin/bash

sed -e "s/Main/$1/g" ./parts/first_template.txt > ../AlgorithmAndData/$1.java
