pipeline {
    agent any

    tools {
        maven 'm3'
        jdk 'jdk21'
    }

    stages {
        stage('Sparse Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'refs/heads/main']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [
                        [$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [
                            [$class: 'SparseCheckoutPath', path: 'library-system/']
                        ]],
                        [$class: 'RelativeTargetDirectory', relativeTargetDir: 'project-build']
                    ],
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        url: 'https://github.com/MamaboloGtub/java-and-spring-tut'
                    ]]
                ])
            }
        }

        stage('Compile Project') {
            steps {
                dir('project-build/library-system') {
                    withMaven(maven: 'm3', jdk: 'jdk21') {
                        bat 'mvn -B -DskipTests=true clean compile'
                    }
                }
            }
        }

        stage('Test Project') {
            steps {
                dir('project-build/library-system') {
                    bat 'mvn -B test'
                }
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package Project') {
            steps {
                dir('project-build/library-system') {
                    withMaven(maven: 'm3', jdk: 'jdk21') {
                        bat 'mvn -B clean package -DskipTests'
                    }
                }
            }
        }

        stage('Deploy Project') {
           steps{
               script {
                   bat "if not exist deploy mkdir deploy"
                   bat "copy project-build\\library-system\\target\\*.jar deploy\\"
               }
           }
        }
        stage('Run Project'){
            steps {
                dir('deploy') {
                    withMaven(maven: 'm3', jdk: 'jdk21') {
                        bat 'start /B java -jar *.jar > app.log 2>&1'
                    }
                }
            }
        }
    }
}
