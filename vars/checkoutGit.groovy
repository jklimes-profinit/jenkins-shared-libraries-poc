import mypackage.Constants;

def call(relativeUrl, branch) {
    checkout([$class: 'GitSCM', branches: [[name: '*/master']],
              doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
              userRemoteConfigs: [[url: "${Constants.SCM_BASE_URL}${relativeUrl}"]]])
}
