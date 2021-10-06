pipeline {
    agent {label 'slave'}


    stages {
        stage('Git clone') {
            steps {
                git 'https://github.com/samahAbbas11/Jenkins_Closing_Task_fursa.git'
            }
        }
        
        stage('Build') {
            steps {
                dir('demo/') {
                    sh "chmod +x gradlew"
                    sh './gradlew clean build'
                }
                
            }
        }
        
        stage('run the app') {
            steps {
                sh 'jps | grep demo-0.0.1 | awk \'{print "kill -9 "$1}\' | bash -x'
                
                sh 'JENKINS_NODE_COOKIE=do_not_kill nohup java -jar demo/build/libs/demo-0.0.1-SNAPSHOT.jar &'
            }
        }
        
        
        
        
    }
}
