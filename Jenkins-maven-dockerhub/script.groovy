def buildJar() {
    echo "Building the application..."
    sh "mvn package"
}

def buildImage() {
    echo "Building the docker image..."
        withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            sh 'docker build -t zahaanmahajan/demo-app:jma-2.0 .'
                sh 'echo $PASS | docker login -u $USER --password-stdin'
                sh 'docker push zahaanmahajan/demo-app:jma-2.0'
        }
}

def deployImage() {
    echo "deploying the application..."
}

return this
