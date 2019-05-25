def call() {
   // workaround for null currentBuild.result when the result is SUCCESS
   if (currentBuild.result == null) {
      currentBuild.result = currentBuild.currentResult
   }
}
