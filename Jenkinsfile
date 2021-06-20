pipeline {
    agent any

    stages {
        stage('Compile'){
            steps {
                    bat 'mvn clean build'
            }
        }
        stage('build'){
            steps {
               bat 'mvn clean build'
            }
        }
    }
}
