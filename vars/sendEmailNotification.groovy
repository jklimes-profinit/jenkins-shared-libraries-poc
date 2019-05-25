import mypackage.Constants;

def call(args) {
    def additionalRecepients = args.additionalRecepients
    mail body: "Email from Jenkins. Project: ${env.JOB_NAME}\nBuild Number: ${env.BUILD_NUMBER}\nURL of build: ${env.BUILD_URL}", from: 'jenkins@profinit.eu', replyTo: '', subject: "FlightLog build changed ${currentBuild.result}", to: additionalRecepients

}
