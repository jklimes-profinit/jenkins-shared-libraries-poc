def call(args) {
   echo "Context: ${contextHolder.yourField}"
   sh "mvn clean install -DskipTests"
}
