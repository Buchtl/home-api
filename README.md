# Keystore for dev https
`keytool -importcert -trustcacerts -alias nexus -file pi4b.crt.pem -keystore ~/nexus-truststore.jks -storepass changeit`

# Config gradle properties
gradle.properties in ~/.gradle/gradle.properties
```
gpr.user=<GITHUB_USER>
gpr.key=<GITHUB_TOKEN>

systemProp.javax.net.ssl.trustStore=/home/<USER>/nexus-truststore.jks
systemProp.javax.net.ssl.trustStorePassword=<PASSWORD>

nexus.user=<NEXUS_USER>
nexus.password=<NEXUS_PASSWORD>
```