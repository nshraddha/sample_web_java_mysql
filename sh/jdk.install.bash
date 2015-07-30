#!/bin/bash

JAVA_VERSION="$(java -version  2>&1 | grep "java version \"1\.8" )"

if [ -n "$JAVA_VERSION" ];
then
  echo "JAVA 8 is present in the System"
  echo "JAVA Version: " $JAVA_VERSION
  exit 0
fi

echo "Java 8 not present in the System, installing."
echo "[INFO] Downloading JDK 8"

JDK_RPM_NAME="jdk-8u5-linux-x64.rpm"

wget -c --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-urebackup-cookie" "http://download.oracle.com/otn-p    ub/java/jdk/8u5-b13/jdk-8u5-linux-x64.rpm" --output-document=/tmp/$JDK_RPM_NAME

echo "[INFO] Installing RPM"
sudo rpm -i /tmp/$JDK_RPM_NAME
echo "[INFO] DONE"

echo "[INFO] Setting Java 8 as Default Version..."
ALT_NUMBER=999

sudo alternatives --install /usr/bin/java java /usr/java/default/bin/java 999
echo 2 | sudo alternatives --config java

echo "[INFO] DONE"
