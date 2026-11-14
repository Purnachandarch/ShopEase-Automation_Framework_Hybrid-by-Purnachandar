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
        
        publishHTML(target: [
    reportDir: 'shopease-automation/test-output',
    reportFiles: '*.html',
    reportName: 'Extent Reports',
    keepAll: true,
    alwaysLinkToLastBuild: true,
    allowMissing: false
])
        
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