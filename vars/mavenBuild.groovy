import mypackage.ContextHolder

def call(args) {
   def context = ContextHolder.getContext()
   echo "Context: ${context.value}"
   sh "mvn clean install -DskipTests"
}
