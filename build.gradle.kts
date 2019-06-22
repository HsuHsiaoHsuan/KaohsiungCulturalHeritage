// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    var kotlin_version: String by extra

    kotlin_version = "1.3.40"
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.0-beta04")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.2.0")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", type = Delete::class) {
    delete(rootProject.buildDir)
}