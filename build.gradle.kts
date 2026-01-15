plugins {
    java
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "aplicacion"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    mainModule.set("aplicacion")
    mainClass.set("aplicacion.TestComponente")
    this.applicationDefaultJvmArgs = listOf("--enable-native-access=javafx.graphics")
}

javafx {
    version = "21.0.6"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    testImplementation ("org.junit.jupiter:junit-jupiter:5.14.0")
    testImplementation ("org.junit.platform:junit-platform-launcher")

    testImplementation ("org.testfx:testfx-core:4.0.18")

    testImplementation ("org.testfx:testfx-junit5:4.0.18")

    testImplementation("org.hamcrest:hamcrest:3.0")
}

tasks.test{
    useJUnitPlatform()
    jvmArgs("--enable-native-access=ALL-UNNAMED")
}