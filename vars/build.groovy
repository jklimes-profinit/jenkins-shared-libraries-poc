def call(args) {
   def context = args.ctx
   echo "Context: ${context.value}"
   sh "mvn clean install -DskipTests"
}
