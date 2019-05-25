def call(scmUrl, additionalRecipients ) {
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
            parameters {
                  booleanParam name: 'SKIP_TESTS', defaultValue: false, description: 'Whether to skip tests'
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
                              sendEmailNotification(additionalRecipients: additionalRecipients)
                        }
                  }

            }
      }

}
