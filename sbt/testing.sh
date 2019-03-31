#!/usr/bin/env bash

#---------------------
# Run specific suites (all tests in the suite) by passing them as arguments to testOnly:
#-------------------
sbt testOnly com.yoursuite
sbt testOnly **.StackSpec **.AT*Spec # to use wildcards

#---------------------
# Run specific test suites in a suite

#in this example it will run all tests having the string "for cars"
#-------------------

sbt testOnly **.StackSpec -- -z "for cars"

