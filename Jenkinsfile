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
        sh '''cd ~
pwd'''
      }
    }

  }
}