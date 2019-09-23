def call() {
    try {
        sh "mvn --batch-mode jacoco:prepare-agent surfire:test -Dmaven.test.failure.ignore=true"
    } finally {
        junit '**/target/surefire-reports/*.xml'
    }
}
