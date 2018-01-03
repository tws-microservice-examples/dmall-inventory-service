pipeline {
    agent any
 
    triggers {
        pollSCM('H/5 * * * *')
    }
    
    environment {
        GROUP_PATH='dmall-team-a'
        DMALL_DOCKER_REGISTRY='52.80.144.157:5000'
        DEV_RANCHER_SERVER='http://54.222.228.139:8080/v2-beta/projects/1a267'
    }
    
    stages {
        stage('repo clean up'){
            steps {
                step([$class: 'WsCleanup'])
            }
        }

        stage('Checkout') {
            steps {
                step([$class: 'WsCleanup'])
            git  poll: true,  credentialsId: 'git-viewer', url: 'git@gitee.com:tws-micro-service/dmall-inventory-service.git', branch: 'release'
            }
                
        }

        stage('Build') {
            steps{
                sh './gradlew clean build'
            }
        }

        stage('Check') {
            parallel {
                stage('Findbugs') {
                        agent none
                        steps {
                            echo 'Findbugs is finished.'
                        }
                    }
                stage('Checkstyle') {
                        agent none
                        steps {
                            echo 'Checkstyle is finished.'
                        }
                    }
                stage('PMD') {
                        agent none
                        steps {
                            echo 'PMD is finished.'
                        }
                    }
            }
        }

        stage('Test') {
            steps{
                sh './gradlew test'
            }
        }

        stage('GenDockerImage') {
            steps{
                sh './genImages.sh'
            }
        }

        stage('DeployToDEV') {
            steps{
                withCredentials([usernamePassword(credentialsId: 'dev_rencher_api_key', passwordVariable: 'SECRET', usernameVariable: 'KEY')]) {
                    sh './deployToDEV.sh'
                }
            }
        }

        stage('PublishStubs'){
            steps {
                sh './gradlew :publishStubsPublicationToMavenRepository'
            }
        }

        stage('TrigerStubServer'){
            steps {
                build 'dmall-inventory-stub-service'
            }
        }
    }
}