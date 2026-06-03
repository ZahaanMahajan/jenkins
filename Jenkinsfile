#!/usr/bin/env groovy

// This is the way to access a shared library directly from the url from the file 
// library identifier: 'jenkins-shared-library@master', retriever: modernSCM()

// When shared library is setup is the jenkins ui
@Library('jenkins-shared-library')
def gv

pipeline {
    agent any
        tools {
            maven 'maven-3.9'
        }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build jar') {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage('build & push image') {
            steps {
                script {
                    buildImage 'zahaanmahajan/demo-app:jma-3.0'
                    dockerLogin()
                    dockerPush 'zahaanmahajan/demo-app:jma-3.0'
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}

