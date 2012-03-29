#!/bin/sh

HERE=$(cd $(dirname $0);pwd)
cd $HERE

FR_DIR=${HOME}/opt/github_rep/repository/jp/que/ti/y_s_util/ysu_*
TO_DIR=${HOME}/wksp/mavenrep/jp/que/ti/y_s_util
echo FR_DIR : $FR_DIR
echo TO_DIR : $TO_DIR
echo .
echo "Press any key!  Then continue"
read WAIT_

RM_CMD="rm -irf ${FR_DIR}/*"
echo  $RM_CMD
#rm -irf ${FR_DIR}/*


M2_HOME=${HOME}/opt/apache-maven-3.0.3
PATH=${M2_HOME}/bin:$PATH


#mvn clean install -Dmaven.test.skip=true

cp -pR $FR_DIR/* $TO_DIR 

