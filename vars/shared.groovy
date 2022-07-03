def call(String stageName){
    if ("${stageName}" == 'Build') {
        sh 'mvn clean'
        sh 'mvn install'
    }
    elif ("${stageName}" == 'CodeQualityAnalysis') {
        sh 'mvn clean'
        sh 'mvn sonar:sonar'
    }
    elif ("${stageName}" == 'BackupArtifacts') {
        sh 'mvn clean'
        sh 'mvn deploy'
    }
    elif ("${stageName}" == 'Authorisation') {
        timeout(time: 48, unit: 'HOURS') {
            // some block
            input message: 'Approve or Decline'
        }
    }
}
