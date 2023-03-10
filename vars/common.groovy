def compile() {
    if (app_lang == "nodejs") {
        sh 'npm install'
        sh 'env'
    }

    if (app_lang == "maven") {
        sh 'mvn package'
    }

}

def unittests() {
    if (app_lang == "nodejs") {
//        Developer is missing unit test cases in our project, He need to add them as best practice, We are skipping to proceed further
        sh 'npm test'

    }

    if (app_lang == "maven") {
        sh 'mvn test'
    }
    if (app_lang == "python") {
        sh 'python3 -m unittest'
    }
}


def email(email_note) {

    mail bcc: '', body: 'TEST\nNEW1\nNEW2', cc: '', from: 'shekarchandra2k11@gmail.com', replyTo: '', subject: 'TEST FROM JENKINS', to: 'shekarchandra2k11@gmail.com'
//    mail bcc: '', body: "Job Failed - ${JOB_BASE_NAME}\nJenkins URL - ${JOB_URL}", cc: '', from: 'shekarchandra2k11@gmail.com', replyTo: 'shekarchandra2k11@gmail.com', subject: "Job Failed - ${JOB_BASE_NAME}\\nJenkins URL - ${JOB_URL}", to: 'shekarchandra2k11@gmail.com'
}