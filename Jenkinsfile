pipeline {
    agent any
    
    tools {
        maven 'Maven3'
        jdk 'jdk17'
    }
    
    environment {
        // Récupération automatique des informations depuis le pom.xml
        POM_GROUPID = readMavenPom().groupId
        POM_ARTIFACTID = readMavenPom().artifactId
        POM_VERSION = readMavenPom().version
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Récupération du code depuis Git...'
                checkout scm
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
        
        // ========== NOUVEAU STAGE 1 : ANALYSE SONARQUBE ==========
        stage('SonarQube Analysis') {
            steps {
                echo 'Analyse de la qualité du code avec SonarQube...'
                withSonarQubeEnv('sonar-server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        
        // ========== NOUVEAU STAGE 2 : QUALITY GATE ==========
        stage('Quality Gate') {
            steps {
                echo 'Vérification du Quality Gate SonarQube...'
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        
        stage('Package') {
            steps {
                echo 'Création du JAR...'
                sh 'mvn package -DskipTests'
            }
        }
        
        // ========== NOUVEAU STAGE 3 : PUBLICATION DANS NEXUS ==========
        stage('Publish to Nexus') {
            steps {
                echo 'Publication de l\'artéfact dans Nexus...'
                nexusArtifactUploader(
                    nexusVersion: 'nexus3',
                    protocol: 'http',
                    nexusUrl: 'localhost:8081',
                    groupId: "${POM_GROUPID}",
                    version: "${POM_VERSION}",
                    repository: 'my-app-releases',
                    credentialsId: 'nexus-credentials',
                    artifacts: [
                        [
                            artifactId: "${POM_ARTIFACTID}",
                            classifier: '',
                            file: "target/${POM_ARTIFACTID}-${POM_VERSION}.jar",
                            type: 'jar'
                        ]
                    ]
                )
            }
        }
        
        stage('Run') {
            steps {
                echo 'Lancement de l\'application...'
                sh 'mvn spring-boot:run &'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline réussi ! Artéfact publié dans Nexus'
        }
        failure {
            echo 'Pipeline échoué !'
        }
    }
}
