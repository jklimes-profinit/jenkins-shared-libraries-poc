def call() {
    context = "Test"
   sh "mvn clean install -DskipTests"
}
