import mypackage.Constants;

def call(relativeUrl, branch) {
    def baseUrl = Constants.SCM_BASE_URL
    checkout([$class: 'GitSCM', branches: [[name: '*/master']],
              doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
              userRemoteConfigs: [[url: "${baseUrl}${relativeUrl}"]]])
}
