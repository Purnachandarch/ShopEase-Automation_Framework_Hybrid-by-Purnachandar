pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {

    stage('Checkout') {
        steps {
            echo 'Checking out ShopEase Automation Framework'
        }
    }

    stage('Build') {
        steps {
            dir('shopease-automation') {
                bat 'mvn clean compile'
            }
        }
    }

    stage('Execute Tests') {
        steps {
            dir('shopease-automation') {
                bat 'mvn test'
            }
        }
    }
    
    
}



    post {
        always {
            echo 'ShopEase Automation Pipeline execution completed'
             testNG(
        reportFilenamePattern: 'shopease-automation/target/surefire-reports/testng-results.xml'
    )
        }

        success {
            echo 'Automation tests passed successfully!'
        }

        failure {
            echo 'Automation tests failed. Check console output.'
        }
    }
}