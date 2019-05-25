def call(args) {
   def context = args.ctx
   sh "mvn clean install -DskipTests"
   echo "Context: ${context}"
}
