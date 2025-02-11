plugins {
    id("com.specificlanguages.mps") version "1.9.0"
    id("com.specificlanguages.jbr-toolchain") version "1.0.1"
    `maven-publish`
}

repositories {
    maven("https://artifacts.itemis.cloud/repository/maven-mps")
    mavenCentral()
    // JitPack should come last since it will build things on demand
    maven(url = "https://jitpack.io")
}

dependencies {
    mps("com.jetbrains:mps:2023.2.2")
    generation("com.specificlanguages.mps-json:mps-json:2.0.0")

    jbr("com.jetbrains.jdk:jbr_jcef:17.0.11-b1207.30")
}

mpsDefaults {
    javaLauncher = jbrToolchain.javaLauncher
}

stubs {
    register("stubs") {
        destinationDir("solutions/com.specificlanguages.dependencies/lib")

        // These versions are used by MPS 2023.2.2
        dependency("org.apache.commons:commons-lang3:3.12.0")
        dependency("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    }
}

group = "com.specificlanguages.mps-json"
version = "0.1.0"

publishing {
    publications {
        register<MavenPublication>("mpsPlugin") {
            from(components["mps"])

            // Put resolved versions of dependencies into POM files
            versionMapping { usage("java-runtime") { fromResolutionOf("generation") } }
        }
    }
    repositories {
        if (project.hasProperty("gpr.user")) {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/specificlanguages/mps-to-json-exporter")
                credentials {
                    username = project.findProperty("gpr.user") as String?
                    password = project.findProperty("gpr.key") as String?
                }
            }
        }
    }
}
