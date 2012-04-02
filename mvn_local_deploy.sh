#!/bin/sh

HERE=$(cd $(dirname $0);pwd)
cd $HERE

FR_PATH=${HOME}/opt/github_m2rep/jp/que/ti/y_s_util/ysu_*
TO_DIR=${HOME}/wksp/mavenrep/jp/que/ti/y_s_util
echo FR_PATH : $FR_PATH
echo TO_DIR : $TO_DIR
echo .
echo "Press any key!  Then continue"
read WAIT_

RM_CMD="rm -irf ${FR_PATH}"
#echo $RM_CMD
python subprocess_call.py $RM_CMD
echo remove m2 repository end

M2_HOME=${HOME}/opt/apache-maven-3.0.3
PATH=${M2_HOME}/bin:$PATH

mvn clean scala:doc install -Dmaven.test.skip=true

cp -pR $FR_PATH $TO_DIR 
