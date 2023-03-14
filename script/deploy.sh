#!/bin/bash

## 변수 설정
txtrst='\033[1;37m' # White
txtred='\033[1;31m' # Red
txtylw='\033[1;33m' # Yellow
txtpur='\033[1;35m' # Purple
txtgrn='\033[1;32m' # Green
txtgra='\033[1;30m' # Gray

S3_PATH=$1
if [ -z $S3_PATH ]; then
    echo -e "${txtred}!! S3 PATH 필수값${txtrst}"
    exit 1
fi

JAR_NAME=$2
if [ -z $JAR_NAME ]; then
    echo -e "${txtred}!! JAR_NAME 필수값${txtrst}"
    exit 1
fi

CURRENT_PID=$(pgrep -f $JAR_NAME)

echo -e "${txtylw}=======================================${txtrst}"
echo -e "${txtgrn}  << 스크립트 🧐 >>${txtrst}"
echo -e "${txtylw}=======================================${txtrst}"


if [ -z $CURRENT_PID ]; then
    echo -e "> ${txtgrn}현재 구동중인 애플리케이션 없음${txtrst}"
else
    echo -e "> ${txtgrn}현재 구동중인 애플리케이션 종료 진행중${txtrst}"
    kill -9 $CURRENT_PID
    echo -e "> ${txtgrn}종료 완료${txtrst}"
fi

echo -e "${txtylw}=======================================${txtrst}"
echo -e "> ${txtgrn}S3 다운로드 진행중${txtrst}"
aws s3 cp s3://$S3_PATH/$JAR_NAME ./
echo -e "> ${txtgrn}S3 다운로드 완료${txtrst}"
echo -e "${txtylw}=======================================${txtrst}"
echo -e "> ${txtgrn}배포 진행중${txtrst}"
nohup java -jar $JAR_NAME > /dev/null 2>&1 &
echo -e "> ${txtgrn}배포 완료${txtrst}"
exit 0