plugins {
    id("java")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:7.2.2")
    implementation("com.fasterxml.jackson.core:jackson-core:2.22.1")
    implementation("org.slf4j:slf4j-api:2.0.17")


    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

tasks.test {
    useJUnitPlatform()
}