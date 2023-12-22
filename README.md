jsystem6.1.12
https://github.com/Top-Q/jsystem-docs/wiki/Quick-Start-Guide

Clone the whole jsystem root folder
Eclipse - import the jsystem root folder with all its projects
Run maven install on the jsystem-parent project (without the tests)
Run maven install on the jsystem-runner project


Generating Tests Project
##mvn archetype:generate -DarchetypeCatalog=http://maven.top-q.co.il/content/groups/public/archetype-catalog.xml
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate -DarchetypeCatalog=http://maven.top-q.co.il/content/groups/public/archetype-catalog.xml
Choose archetype:
1: http://maven.top-q.co.il/content/groups/public/archetype-catalog.xml -> org.jsystemtest.archetypes:jsystem-tests-archetype (-)
2: http://maven.top-q.co.il/content/groups/public/archetype-catalog.xml -> org.jsystemtest.archetypes:jsystem-so-archetype (-)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): :
mvn clean compile

mvn install:install-file -Dfile=E:\softwares\zookeeper-3.4.10\zookeeper-3.4.10.jar -DgroupId=org.apache.zookeeper -DartifactId=zookeeper -Dversion=3.4.10 -Dpackaging=jar

mvn install:install-file -Dfile=D:\work\reg_env-1.0_20150106\thirdparty\commonLib\jsch-0.1.49.jar -DgroupId=com.jcraft -DartifactId=jsch -Dversion=0.1.49 -Dpackaging=jar
mvn install:install-file '-Dfile=D:\work\reg_env-1.0_20150106\thirdparty\commonLib\jsch-0.1.49.jar' '-DgroupId=com.jcraft' '-DartifactId=jsch' '-Dversion=0.1.49' '-Dpackaging=jar'
mvn install:install-file '-Dfile=D:\work\reg_env-1.0_20150106\thirdparty\commonLib\commons-net.jar' '-DgroupId=org.apache.commons' '-DartifactId=commons-net' '-Dversion=1.0' '-Dpackaging=jar'

org.jsystem.automationProj
