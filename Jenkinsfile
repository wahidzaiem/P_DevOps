pipeline {
    agent any
    
    tools {
        maven 'Maven3'
        jdk 'jdk17'
    }
    
    // SECTION ENVIRONMENT MODIFIÉE - sans readMavenPom()
    environment {
        POM_GROUPID = 'tn.esprit.rh'     // Remplacez par votre groupId réel
        POM_ARTIFACTID = 'achat'       // Remplacez par votre artifactId réel
        POM_VERSION = '1.0'              // Remplacez par votre version
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
        
        stage('SonarQube Analysis') {
            steps {
                echo 'Analyse de la qualité du code avec SonarQube...'
                withSonarQubeEnv('sonar-server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        
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
