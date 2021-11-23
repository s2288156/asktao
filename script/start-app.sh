#!/bin/bash

java -jar -Dnacos.server-addr=${NACOS_SERVER_ADDR} -Dnacos.namespace=${NACOS_NAMESPACE} zhcl-app.jar