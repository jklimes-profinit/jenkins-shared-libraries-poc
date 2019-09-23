import mypackage.Constants;

def call(args) {
    def additionalRecipients = args.additionalRecipients
    emailext body: "Email from Jenkins. Project: ${env.JOB_NAME}\nBuild Number: ${env.BUILD_NUMBER}\nURL of build: ${env.BUILD_URL}",
            from: 'jenkins@profinit.eu',
            replyTo: '',
            subject: "Job \'${JOB_NAME} (${BUILD_NUMBER}) \' is ${currentBuild.result}",
            to: additionalRecipients
}

def formatParameters() {
    def paramsString = "Build parameters:\n"
    params.each{name, value ->
        paramsString = "${paramsString} ${name}: ${value}\n"
    }
}
