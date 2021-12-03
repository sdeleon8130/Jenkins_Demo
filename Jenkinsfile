pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M2"
    }

    stages {
        
        stage('Preparation') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/sdeleon8130/Jenkins_Demo.git'
                // for remote repository with credentials - generated from Jenkins Syntax git:Git
                //git credentialsId: 'cc052433-60f2-4cef-b96a-8fe95576683e', url: 'https://github.com/sdeleon8130/Jenkins_Demo.git'
            }
        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn clean test"
            }
        }
    }
}
