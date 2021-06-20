pipeline {
    agent any

    stages {
        stage('Compile'){
            steps {
                withMaven(maven : 'maven_3_5_0'){
                    bat 'mvn clean build'
                }
            }
        }
        stage('build'){
            steps {
                withMaven(maven : 'maven_3_5_0'){
                    bat 'mvn clean install'
                }
            }
        }
    }
}
