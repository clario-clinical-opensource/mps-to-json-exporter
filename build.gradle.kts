plugins {
    id("com.specificlanguages.mps") version "1.9.0"
    id("com.specificlanguages.jbr-toolchain") version "1.0.1"
    `maven-publish`
    signing
    // id("com.gradleup.nmcp").version("0.0.8")
}

repositories {
    maven("https://artifacts.itemis.cloud/repository/maven-mps")
    mavenCentral()
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
        destinationDir("solutions/com.clario.dependencies/lib")

        // These versions are used by MPS 2023.2.2
        dependency("org.apache.commons:commons-lang3:3.12.0")
        dependency("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    }
}

// Empty jar for fulfilling Maven Central requirements
val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier = "sources"
}

// Empty jar for fulfilling Maven Central requirements
val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier = "javadoc"
}


val gitTag: String? = System.getenv("GITHUB_REF")?.replace("refs/tags/", "")?.removePrefix("v")

publishing {
    publications {
        register<MavenPublication>("mpsPlugin") {
            from(components["mps"])

            groupId = "io.github.clario-clinical-opensource"
            artifactId = "mps-to-json-exporter"
            version = gitTag ?: "0.0.1"

            // Put resolved versions of dependencies into POM files
            versionMapping { usage("java-runtime") { fromResolutionOf("generation") } }

            artifact(sourcesJar)
            artifact(javadocJar)

            pom {
                name = "mps-to-json-exporter"
                description = "An MPS library to export MPS models as JSON"
                url = "https://github.com/clario-clinical-opensource/mps-to-json-exporter"

                scm {
                    connection = "scm:git:git://github.com/clario-clinical-opensource/mps-to-json-exporter.git"
                    developerConnection = "scm:git:ssh://github.com:clario-clinical-opensource/mps-to-json-exporter.git"
                    url = "https://github.com/clario-clinical-opensource/mps-to-json-exporter"
                }

                licenses {
                    license {
                        name = "The Apache Software License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        name = "Andy Stetson"
                        email = "stetson.a@gmail.com"
                    }
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/clario-clinical-opensource/mps-to-json-exporter")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
        maven {
            name = "OSSRH"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = System.getenv("CENTRAL_USERNAME")
                password = System.getenv("CENTRAL_PASSWORD")
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(
        System.getenv("GPG_PRIVATE_KEY"),
        System.getenv("GPG_PASSPHRASE")
    )
    sign(publishing.publications)
}

// nmcp {
//     afterEvaluate {
//         // nameOfYourPublication must point to an existing publication
//         publish("mpsPlugin") {
//             username = System.getenv("CENTRAL_USERNAME")
//             password = System.getenv("CENTRAL_PASSWORD")
//             publicationType = "AUTOMATIC"
//         }
//     }
// }
