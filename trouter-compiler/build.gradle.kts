plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("kotlin-kapt")
    id("com.vanniktech.maven.publish") version "0.34.0"
}

val artifactId = "trouter-compiler"
val version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

dependencies {
    kapt(libs.auto.service)
    compileOnly(libs.auto.service)
    kapt(libs.auto.service)
    implementation(libs.trouter.annotation)
}

mavenPublishing {
    coordinates("io.github.huaj1a", artifactId, version)

    pom {
        name = artifactId
        url = "https://github.com/huaj1a/TRouter"
        description = "TRouter compiler"

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
 