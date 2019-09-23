import mypackage.ContextHolder

def call(args) {
   def context = ContextHolder.getContext()
   sh "mvn clean install --batch-mode -DskipTests"
}
