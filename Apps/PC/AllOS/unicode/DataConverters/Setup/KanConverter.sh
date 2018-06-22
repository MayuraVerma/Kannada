#!/bin/sh

export JRE_HOME=/home/sudheer/Downloads/jre1.7.0_60
PATH=/home/sudheer/Downloads/jre1.7.0_60/bin:${PATH}

#---------------------------------#
# dynamically build the classpath #
#---------------------------------#
CLASSPATH_DC=
for i in `ls ./lib/lib/*.jar`
do
  CLASSPATH_DC=${CLASSPATH_DC}:${i}
done

for i in `ls ./lib/*.jar`
do
  CLASSPATH_DC=${CLASSPATH_DC}:${i}
done

#---------------------------#
# run the anti-spam program #
#---------------------------#
echo ${CLASSPATH_DC};
java -cp ".:${CLASSPATH_DC}" com.kannada.converter.kanuaconvui.KanUAConvUI
