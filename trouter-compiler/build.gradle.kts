plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("kotlin-kapt")
    id("maven-publish")
}
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
    implementation("com.huaj1a:trouter-annotation:1.0.0")
}

tasks.register("sourcesJar", Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["java"])
            artifact(tasks["sourcesJar"]) // 附加源码 JAR
            groupId = "com.huaj1a"
            artifactId = "trouter-compiler"
            version = "1.0.0"
        }
    }
    repositories {
        maven {
            url = uri("file:///D:/code/venus_project/TRouter/repository")
        }
    }
}


 