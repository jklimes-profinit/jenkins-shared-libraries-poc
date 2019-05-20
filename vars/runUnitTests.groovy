def call() {
    script {
        try {
            sh "mvn test -Dmaven.test.failure.ignore=true"
        } finally {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
