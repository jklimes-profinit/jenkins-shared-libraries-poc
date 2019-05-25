import mypackage.ContextHolder

def call(args) {
      ContextHolder.initializeContext()
      def context = ContextHolder.getContext()
      context.value = "Test context"
}
