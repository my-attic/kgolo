#!/bin/sh
# Copyright (c) 2013 Philippe Charrière aka @k33g_org
#
# All rights reserved. No warranty, explicit or implicit, provided.
#

echo "1- loading jars"
#FIND JARS
JARS=""
FILES="$(find $1 -name '*.jar')"
for jar in $FILES
do
	JARS="$JARS$PWD/$jar:"
	echo "--> $jar"
done

export CLASSPATH_PREFIX=${CLASSPATH_PREFIX}:"$JARS"


echo "2- Golo Libraries"
#FIND FASTFORWARD GOLO LIBRARIES
LIBS=""
FILES="$(find $1 -name '*.golo')"
for gf in $FILES
do
	LIBS="$LIBS $gf"
	echo "--> $gf"
done

echo "3- run $2"
echo 

gologolo $LIBS $2

