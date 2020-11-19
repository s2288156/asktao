pipeline {
  agent any
  stages {
    stage('pull code') {
      steps {
        sh 'git pull'
      }
    }

    stage('build') {
      steps {
        sh '''su wu
mvn clean package'''
      }
    }

  }
}