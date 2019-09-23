import mypackage.Constants

def call(args) {
    cleanWs()
    def relativeUrl = args.relativeUrl
    def baseUrl = Constants.SCM_BASE_URL
    checkout([$class: 'GitSCM', branches: [[name: '*/master']],
              doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
              userRemoteConfigs: [[url: "${baseUrl}${relativeUrl}"]]])
}
