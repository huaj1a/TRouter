plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

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

    api("com.huaj1a:trouter-annotation:1.0.0")
    annotationProcessor(project(":trouter-compiler"))
    implementation(libs.permissionx)
}


afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                // 指定要发布的 Android 库组件
                from(components["release"])

                groupId = "com.huaj1a"
                artifactId = "trouter-api"
                version = "1.0.0"
            }
        }
        repositories {
            maven {
                // 使用正确的本地路径格式（Windows）
                url = uri("file:///D:/code/venus_project/TRouter/repository")
            }
        }
    }
}
