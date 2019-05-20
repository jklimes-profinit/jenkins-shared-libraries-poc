import mypackage.Constants;

def call(relativeUrl, branch) {
    def baseUrl = Constants.SCM_BASE_URL
    sh "echo Base URL: ${baseUrl}"
}
