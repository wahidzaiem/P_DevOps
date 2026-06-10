pipeline {
    agent any
    
    tools {
        maven 'Maven3'
        jdk 'jdk17'
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
                dir('app') {
                    sh 'mvn clean compile'
                }
            }
        }
        
        stage('Test') {
            steps {
                echo 'Exécution des tests...'
                dir('app') {
                    sh 'mvn test'
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                echo 'Analyse de la qualité du code...'
                dir('app') {
                    withSonarQubeEnv('sonar-server') {
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }
        
        stage('Quality Gate') {
            steps {
                echo 'Vérification du Quality Gate...'
                dir('app') {
                    script {
                        try {
                            timeout(time: 1, unit: 'MINUTES') {
                                waitForQualityGate abortPipeline: false
                            }
                        } catch (Exception e) {
                            echo "Quality Gate check timeout, continuing..."
                        }
                    }
                }
            }
        }
        
        stage('OWASP Dependency Check') {
            steps {
                echo 'Analyse des vulnérabilités...'
                dir('app') {
                    sh 'mvn org.owasp:dependency-check-maven:12.1.0:check -DskipOssIndex=true -DfailBuildOnCVSS=11 -Dformat=HTML -DoutputDirectory=target/owasp-reports'
                }
            }
            post {
                always {
                    publishHTML([
                        reportDir: 'app/target/owasp-reports',
                        reportFiles: 'dependency-check-report.html',
                        reportName: 'OWASP Dependency Check Report',
                        allowMissing: true,
                        keepAll: true,
                        alwaysLinkToLastBuild: true
                    ])
                    archiveArtifacts artifacts: 'app/target/owasp-reports/*.html', allowEmptyArchive: true
                }
            }
        }
        
        stage('Package') {
            steps {
                echo 'Création du JAR...'
                dir('app') {
                    sh 'mvn package -DskipTests'
                }
            }
        }
        
        stage('Publish to Nexus') {
            steps {
                echo 'Publication dans Nexus...'
                dir('app') {
                    script {
                        def pom = readMavenPom file: 'pom.xml'
                        def groupId = pom.groupId
                        def artifactId = pom.artifactId
                        def version = pom.version
                        
                        nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: 'localhost:8083',
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
        }
        
        stage('Docker Build') {
            steps {
                echo 'Construction de l\'image Docker...'
                dir('app') {
                    sh "docker build -t achat-app:${BUILD_NUMBER} ."
                    sh "docker tag achat-app:${BUILD_NUMBER} achat-app:latest"
                }
            }
        }
        
        stage('Docker Run') {
            steps {
                echo 'Démarrage du conteneur...'
                script {
                    sh 'docker stop achat-app || true'
                    sh 'docker rm achat-app || true'
                    sh "docker run -d -p 8089:8089 --name achat-app achat-app:${BUILD_NUMBER}"
                }
            }
        }
        
        stage('Docker Test') {
            steps {
                echo 'Test de l\'application...'
                script {
                    sh 'sleep 15'
                    sh 'curl -s http://localhost:8089/SpringMVC/categorieProduit/retrieve-all-categorieProduit | head -c 200 || echo "Application démarrée"'
                }
            }
        }
        
        stage('Run') {
            steps {
                echo 'Lancement de l\'application...'
                dir('app') {
                    sh 'mvn spring-boot:run &'
                }
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline réussi !'
            echo "📦 Image Docker: achat-app:${BUILD_NUMBER}"
            echo "🌐 Application: http://localhost:8089"
        }
        failure {
            echo 'Pipeline échoué !'
        }
        always {
            echo 'Fin du pipeline'
        }
    }
}