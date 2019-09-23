def call() {
    sh "mvn --batch-mode sonar:sonar"
}
