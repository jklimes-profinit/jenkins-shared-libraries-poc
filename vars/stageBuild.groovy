def call() {
    stage('Build') {
        steps {
            sh "mvn clean install -DskipTests"
        }
    }
}
