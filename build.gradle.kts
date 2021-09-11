plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("com.discord4j:discord4j-core:3.1.7")
    implementation("io.github.cdimascio:dotenv-java:2.2.0")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}