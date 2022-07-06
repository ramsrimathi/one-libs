def call(credID,userName,ipAddr){
   sshagent ([credID]) {
        sh "mv target/*.war target/webapp.war"
     sh "scp -o StrictHostKeyChecking=no target/webapp.war ${userName}@${ipAddr}:/opt/tomcat9/webapps"
     sh "ssh ${userName}@${ipAddr} /opt/tomcat9/bin/shutdown.sh"
     sh "ssh ${userName}@${ipAddr} /opt/tomcat9/bin/startup.sh"
   }
}
}
