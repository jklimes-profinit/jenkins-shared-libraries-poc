import mypackage.Constants;

def call(relativeUrl) {
    def baseUrl = Constants.SCM_BASE_URL
    sh "echo Base URL: ${baseUrl}"
}
