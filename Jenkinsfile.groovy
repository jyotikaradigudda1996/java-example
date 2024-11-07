node('agent1'){
	
        stage('Checkout') { 
		checkout([
			$class: 'GitSCM',
			branches: [[name: 'main']],
			userRemoteConfigs: [[
			    credentialsId: 'github',
			    url: 'https://github.com/jyotikaradigudda1996/java-example.git'
			]]
		])
	}			
 	 	 	 
        stage('Test') {   
              echo 'Running unit test and integration test' 
	}
 	 	} 
 
 	 	stage('Build') { 
 	 	 	sh 'mvn clean package' 
 	 	 	} 

 	 	stage('deploy'){
 	 	     sh 'sudo cp /home/ubuntu/jenkins/workspace/jenkinsfile.groovy/target/*.war /home/ubuntu/tomcat/webapps/'
 	 	     echo 'Successfully deployed'
 	 	    
 	 	}
}
