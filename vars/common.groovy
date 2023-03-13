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

    mail bcc: '', body: 'Job Failed - ${JOB_BASE_NAME}\nJenkins URL - ${JOB_URL}', cc: '', from: 'chandrashekar185@gmail.com', replyTo: 'chandrashekar185@gmail.com', subject: 'TEST FROM JENKINS', to: 'chandrashekar185@gmail.com'
}