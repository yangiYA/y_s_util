#!/usr/bin/env python
# coding=utf_8
import subprocess
import sys # モジュール属性 argv を取得するため
 
argvs = sys.argv  # コマンドライン引数を格納したリストの取得
argc = len(argvs) # 引数の個数
if argc <= 0:
	print "ERROR. no parameter found!  1 parameter is required. "
	sys.exit(1)

cmd = ""
for prm in argvs[1:]:
	cmd = cmd + " " + prm

print "command:" + cmd
subprocess.call(cmd, shell=True)
