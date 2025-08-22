plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.vanniktech.maven.publish") version "0.34.0"
}

val artifactId = "trouter-api"
val version = "1.0.0"

android {
    namespace = "com.huaj1a.trouter"
    compileSdk = 36

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)

    api(libs.trouter.annotation)
    annotationProcessor(libs.trouter.compiler)
    implementation(libs.permissionx)
}

mavenPublishing {
    coordinates("io.github.huaj1a", artifactId, version)

    pom {
        name = artifactId
        url = "https://github.com/huaj1a/TRouter"
        description = "TRouter api"

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