#!/bin/bash

set +e

BRANCH=$1
# 如果不存在
[ -z "$BRANCH" ] && (echo "缺少branch参数" && exit 1)

git checkout $BRANCH
git pull
git checkout -
git merge $BRANCH