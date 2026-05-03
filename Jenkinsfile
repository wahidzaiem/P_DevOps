pipeline {
    agent any
    tools {
        maven 'M2_HOME'
        jdk 'JAVA_HOME'
    }
    stages {
        stage('Checkout') {
            steps {
                echo 'Récupération du code depuis Git...'
                git branch: 'main',
                    url: 'https://github.com/wahidzaiem/P_DevOps.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Compilation du projet...'
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Exécution des tests...'
                sh 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                echo 'Analyse SonarQube...'
                withSonarQubeEnv('sonar-server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Package') {
            steps {
                echo 'Création du JAR...'
                sh 'mvn package -DskipTests'
            }
        }
        stage('Publish to Nexus') {
            steps {
                echo 'Publication dans Nexus...'
                script {
                    def pom = readMavenPom file: 'pom.xml'
                    nexusArtifactUploader(
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        nexusUrl: 'nexus:8081',
                        groupId: pom.groupId,
                        version: pom.version,
                        repository: 'my-app-releases',
                        credentialsId: 'nexus-credentials',
                        artifacts: [[
                            artifactId: pom.artifactId,
                            classifier: '',
                            file: "target/${pom.artifactId}-${pom.version}.jar",
                            type: 'jar'
                        ]]
                    )
                }
            }
        }
        stage('Docker Build') {
            steps {
                echo 'Construction de l image Docker...'
                sh 'docker build -t achat:latest .'
            }
        }
        stage('Docker Run') {
    steps {
        echo 'Lancement du conteneur...'
        sh '''
            docker stop achat-app || true
            docker rm achat-app || true
            docker run -d --name achat-app --network devsecops_default -p 8089:8089 -e SPRING_DATASOURCE_URL='jdbc:mysql://mysql:3306/achatdb?useUnicode=true&serverTimezone=UTC' -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=root -e SERVER_PORT=8089 -e SERVER_SERVLET_CONTEXT_PATH=/SpringMVC -e SPRING_MVC_PATHMATCH_MATCHING_STRATEGY=ant_path_matcher achat:latest

        '''
    }
}
    }
    post {
        success { echo 'Pipeline réussi!' }
        failure { echo 'Pipeline échoué!' }
    }
}
