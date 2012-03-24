#!/bin/sh

HERE=$(cd $(dirname $0);pwd)
cd $HERE

mvn install
#mvn install -Dmaven.test.skip=true
