pipeline{
  
  agent any
  
  stages {
  stage('maven install') {
    steps {
      // One or more steps need to be included within the steps block.
      
      withMaven(maven: 'Maven3') {
              bat 'mvn clean install'
     }
      
      
     
        
        post{
          always{
             junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            
            //publish test results report
            //step([$class: 'MsTestPublisher', testResultsFile: 'testResults.xml', failOnError: true, keepLongStdio: true])
            
           // mstest testResultsFile: "*.trx", keepLongStdio: true
            
          }
        }
      }
      
     
      
      
    
  }
    
    

}

  
  
}
