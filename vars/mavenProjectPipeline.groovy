def call(scmUrl) {
      pipeline {
            agent any
            tools {
                  maven 'Maven'
            }
            options {
                  buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '5'))
                  disableConcurrentBuilds()
            }
            triggers {
                  pollSCM 'H/2 * * * *'
            }
            stages {
                  stage ("Configure"){
                        steps {
                              script {
                                    configure()
                              }
                        }
                  }
                  stage('Checkout') {
                        steps {
                              checkoutGit(relativeUrl: scmUrl, branch: 'master')
                        }
                  }
                  stage('Build') {
                        steps {
                              mavenBuild()
                        }
                  }
                  stage('Test') {
                        steps {
                              runUnitTests()
                        }
                  }
            }
            post {
                  always {
                        script {
                              fixBuildResult
                              sendEmailNotification(additionalRecipients: 'jonas.klimes@profinit.eu')
                        }
                  }

            }
      }

}
