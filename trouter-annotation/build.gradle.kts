plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("com.vanniktech.maven.publish") version "0.34.0"
}

val ArtifactId = "trouter-annotation"
val Version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

mavenPublishing {
    coordinates("io.github.huaj1a", ArtifactId, Version)

    pom {
        name = ArtifactId
        url = "https://github.com/huaj1a/TRouter"
        description = "TRouter annotation"

        licenses {
            license {
                name.set("Apache License 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                name = "huaj1a"
                url = "https://github.com/huaj1a"
                email = "huaj1a.venus@gmail.com"
            }
        }

        scm {
            connection.set("scm:git:git://github.com/huaj1a/TRouter.git")
            developerConnection.set("scm:git:ssh://github.com/huaj1a/TRouter.git")
            url.set("https://github.com/huaj1a/TRouter.git")
        }
    }

    publishToMavenCentral()
    signAllPublications()
}