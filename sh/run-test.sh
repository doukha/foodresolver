#!/usr/bin/env bash

echo "Hallo"

set -e -x

cd .. && mvn test
