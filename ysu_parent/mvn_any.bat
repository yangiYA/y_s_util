cd %~dp0

rem set MAVEN_HOME=C:\java\apache-maven-3.0.3
rem set PATH=%PATH%;%MAVEN_HOME%\bin

rem cd ..\ysu_io
 

rem mvn clean package
mvn clean install deploy
rem mvn install
rem mvn package
