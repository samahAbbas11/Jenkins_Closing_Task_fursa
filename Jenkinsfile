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
                // cd to the dircetory of gradlew file
                // set execution permission to gradlew
                dir('demo/') {
                    sh "chmod +x gradlew"
                    sh './gradlew build'
                }
                
            }
        }
        
        stage('run the app') {
            steps {
                // serach over running java process , and kill it , in order to let the new version of code to run on the port 80.
                sh 'jps | grep demo-0.0.1 | awk \'{print "kill -9 "$1}\' | bash -x'
                
                // don't let jenkins kill the process after the run , and that's with the help of env.variable 
                // let jenkins run the process in background , so the job will not run infintely
                sh 'JENKINS_NODE_COOKIE=do_not_kill nohup java -jar demo/build/libs/demo-0.0.1-SNAPSHOT.jar &'
            }
            
             post {
                //in case of success : send a success message to my channel in slack
                success {
                        slackSend channel: '#hw', color: '#217a36', message: 'The process was built successfully...'}

                //in case of failure : send a failure message to my channel in slack
                failure {
                        slackSend channel: '#hw', color: '#ed3424', message: 'Failure in the build process...'}
            }
            
        }
        
        
        
        
    }
}
