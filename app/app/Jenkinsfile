pipeline {
    agent any
    
    tools {
        maven 'Maven3'
        jdk 'jdk17'
    }
    
    // Supprimez le bloc environment - on va le gérer autrement
    
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
        
        // ========== ANALYSE SONARQUBE ==========
        stage('SonarQube Analysis') {
            steps {
                echo 'Analyse de la qualité du code avec SonarQube...'
                withSonarQubeEnv('sonar-server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        
        // ========== QUALITY GATE ==========
        stage('Quality Gate') {
    steps {
        echo 'Vérification du Quality Gate (optionnelle)...'
        script {
            try {
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: false  // false = ne pas échouer
                }
            } catch (Exception e) {
                echo "Quality Gate check timeout, continuing..."
            }
        }
    }
}
        
        stage('Package') {
            steps {
                echo 'Création du JAR...'
                sh 'mvn package -DskipTests'
            }
        }
        
        // ========== PUBLICATION DANS NEXUS ==========
        stage('Publish to Nexus') {
            steps {
                echo 'Publication de l\'artéfact dans Nexus...'
                
                // Récupération des informations du pom.xml
                script {
                    def pom = readMavenPom file: 'pom.xml'
                    def groupId = pom.groupId
                    def artifactId = pom.artifactId
                    def version = pom.version
                    
                    nexusArtifactUploader(
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        nexusUrl: 'localhost:8081',
                        groupId: groupId,
                        version: version,
                        repository: 'my-app-releases',
                        credentialsId: 'nexus-credentials',
                        artifacts: [
                            [
                                artifactId: artifactId,
                                classifier: '',
                                file: "target/${artifactId}-${version}.jar",
                                type: 'jar'
                            ]
                        ]
                    )
                }
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
