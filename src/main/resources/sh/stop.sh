#!/bin/sh
#根据进程名用户名杀死进程
function GetPID #User #Name
 {
 

 pid=`ps -ef |grep java | grep anthony | grep -v grep | grep -v dbx\n|sed -n 1p |awk '{print $2}'`
 echo $pid
 }

#获取进程ID
PID=`GetPID java`

if [ !${PID} ];
then

echo java的进程号为:${PID}
echo 开始杀死app用户的java进程...
kill -9 ${PID}
echo 进程已经杀死...
sleep 1

else
echo 无此进程,或者进程无法杀死,请手工执行kill命令
fi

