#!/bin/bash
mvn clean package
cp ear/target/ear-1.0-SNAPSHOT.ear /opt/wildfly/standalone/deployments