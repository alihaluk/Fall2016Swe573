#!/bin/bash
set -e

mkdir -p build

echo "Compiling..."
javac -d build app/src/main/java/tr/edu/boun/healthtracker/utils/CalorieCalculator.java
javac -d build -cp build:app/libs/junit-4.12.jar:app/libs/hamcrest-core-1.3.jar app/src/test/java/tr/edu/boun/healthtracker/LogicUnitTest.java

echo "Running tests..."
java -cp build:app/libs/junit-4.12.jar:app/libs/hamcrest-core-1.3.jar org.junit.runner.JUnitCore tr.edu.boun.healthtracker.LogicUnitTest
