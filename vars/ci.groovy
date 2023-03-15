def call() {
  try {
      pipeline {

          agent {
              label 'workstation'
          }
          stages {

              stage('compile/Build') {
                  steps {
                      script {
                          common.compile()
                      }

                  }
              }

              stage('Unit Tests') {
                  steps {
                      script {
                          common.unittests()
                      }

                  }
              }

              stage('Quality Control') {
                  steps {
                      withAWSParameterStore(credentialsId: '', naming: 'relative', path: '/service', recursive: true, regionName: 'eu-west-1') {
                          echo "USER = ${env.SONARQUBE_USER}"
                      }
                      //sh 'sonar-scanner -Dsonar.host.url=http://172.31.4.40:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=cart'
                  }
              }
              stage('Upload Code to Centralized Place') {
                  steps {
                      echo 'Upload'
                  }
              }
          }

      }
      } catch (Exception e) {
      common.email("Failed")
  }
}
