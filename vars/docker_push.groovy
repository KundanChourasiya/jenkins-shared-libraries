def call(String Project, String ImageTag, String dockerHubUser){
  withCredentials([usernamePassword(credentialsId:"docker-hub", usernameVariable:"dockerHubUser", passwordVariable:"dockerHubPass")]){
    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
