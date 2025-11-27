pipeline {
    agent any

    environment {
        IMAGE_NAME = "yourdockerhub/demo-app"
        BRANCH = "${env.GIT_BRANCH}"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh "mvn -B clean test package"
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${IMAGE_NAME}:${BRANCH} ."
                }
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-pass', variable: 'DOCKER_PASS')]) {
                    sh "echo $DOCKER_PASS | docker login -u yourdockerhub --password-stdin"
                    sh "docker push ${IMAGE_NAME}:${BRANCH}"
                }
            }
        }

        stage('Deploy') {
            when { branch 'main' }
            steps {
                sh "echo \"Deploying to production...\""
                // Add real deploy steps (k8s, ansible, terraform, etc.)
            }
        }
    }

    post {
        always {
            echo "Pipeline Complete."
        }
    }
}

