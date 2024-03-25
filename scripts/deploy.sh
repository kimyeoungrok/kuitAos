#!/bin/bash

IS_GREEN_EXIST=$(docker ps | grep green)
DEFAULT_CONF=" /etc/nginx/conf.d"

# blue가 실행 중이면 green을 up합니다.
if [ -z $IS_GREEN_EXIST ];then
  echo "### BLUE => GREEN ####"
  echo ">>> green image를 pull합니다."
  docker-compose pull green
  echo ">>> green container를 up합니다."
  docker-compose up -d green
  while [ 1 = 1 ]; do
  echo ">>> green health check 중..."
  sleep 3
  REQUEST=$(curl http://127.0.0.1:8080)
    if [ -n "$REQUEST" ]; then
      echo ">>> 🍃 health check success !"
      break;
    fi
  done;
  sleep 3
  echo ">>> nginx를 다시 실행 합니다."
  sudo ln -s -f /etc/nginx/sites-available/green /etc/nginx/sites-enabled/default
  sudo nginx -s reload
  echo ">>> blue container를 down합니다."
  docker-compose stop blue

# green이 실행 중이면 blue를 up합니다.
else
  echo "### GREEN => BLUE ###"
  echo ">>> blue image를 pull합니다."
  docker-compose pull blue
  echo ">>> blue container up합��다."
  docker-compose up -d blue
  while [ 1 = 1 ]; do
    echo ">>> blue health check 중..."
    sleep 3
    REQUEST=$(curl http://127.0.0.1:8081)
    if [ -n "$REQUEST" ]; then
      echo ">>> 🍃 health check success !"
      break;
    fi
  done;
  sleep 3
  echo ">>> nginx를 다시 실행 합니다."
  sudo ln -s -f /etc/nginx/sites-available/blue /etc/nginx/sites-enabled/default
  sudo nginx -s reload
  echo ">>> green container를 down합니다."
  docker-compose stop green
fi