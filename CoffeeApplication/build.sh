#!/bin/sh
echo "Test and Building Application"
maven install
echo "Running Application"
java -jar target/com-coffee-house-0.0.1-SNAPSHOT.jar