plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "funnybrain.kaohsiungculturalheritage"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    androidExtensions {
        isExperimental = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dexOptions {
        preDexLibraries = false
    }
    packagingOptions {
        pickFirst("META-INF/DEPENDENCIES")
        pickFirst("META-INF/LICENSE")
        pickFirst("META-INF/LICENSE.txt")
        pickFirst("META-INF/license.txt")
        pickFirst("META-INF/NOTICE")
        pickFirst("META-INF/NOTICE.txt")
        pickFirst("META-INF/notice.txt")
        pickFirst("META-INF/ASL2.0")
        pickFirst("META-INF/atomicfu.kotlin_module")
    }
}

dependencies {
    val ankoVer = "0.10.8"
    val junitVer = "5.4.2"
//    val kotlinVer = project.rootProject.ext["kotlin_version"]
    val kotlinVer = project.rootProject.extra.get("kotlin_version")

    implementation(fileTree("dir" to "libs", "include" to ("*.jar")))

    implementation("com.android.support:multidex:1.0.3")
    implementation("android.arch.navigation:navigation-fragment:1.0.0")
    implementation("android.arch.navigation:navigation-ui:1.0.0")
    implementation("android.arch.navigation:navigation-fragment-ktx:1.0.0")
    implementation("android.arch.navigation:navigation-ui-ktx:1.0.0")
    implementation("androidx.appcompat:appcompat:1.1.0-beta01")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta2")
    implementation("androidx.core:core-ktx:1.2.0-alpha02")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0-alpha06")

    api("com.alibaba.android:ultraviewpager:1.0.7.7@aar")
    implementation("com.android.support:appcompat-v7:28.0.0")
    implementation("com.android.support:design:28.0.0")
    implementation("com.android.support:support-v4:28.0.0")

    implementation("com.facebook.fresco:fresco:1.10.0")
    implementation("com.github.bumptech.glide:glide:4.9.0")
    implementation("com.google.android.material:material:1.1.0-alpha07")
    implementation("com.orhanobut:logger:2.2.0")

    implementation("com.squareup.okhttp3:logging-interceptor:3.14.2")
    implementation("com.squareup.retrofit2:retrofit:2.6.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.5.0")
    implementation("com.squareup.retrofit2:converter-gson:2.5.0")

    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.3.0")

    implementation("org.jetbrains.anko:anko:$ankoVer")
    implementation("org.jetbrains.anko:anko-appcompat-v7:$ankoVer")
    implementation("org.jetbrains.anko:anko-commons:$ankoVer")
    implementation("org.jetbrains.anko:anko-cardview-v7:$ankoVer")
    implementation("org.jetbrains.anko:anko-constraint-layout:$ankoVer")
    implementation("org.jetbrains.anko:anko-design:$ankoVer")
    implementation("org.jetbrains.anko:anko-design-coroutines:$ankoVer")
    implementation("org.jetbrains.anko:anko-recyclerview-v7:$ankoVer")
    implementation("org.jetbrains.anko:anko-recyclerview-v7-coroutines:$ankoVer")
    implementation("org.jetbrains.anko:anko-sdk27:$ankoVer") // sdk15, sdk19, sdk21, sdk23, sdk25 are also available
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVer")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.0")

    androidTestImplementation("org.junit.jupiter:junit-jupiter-api:$junitVer")
    androidTestImplementation("org.junit.jupiter:junit-jupiter-params:$junitVer")
    androidTestRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVer")
    androidTestImplementation("io.mockk:mockk:1.9")
    androidTestImplementation("com.squareup.retrofit2:retrofit-mock:2.2.0")

    androidTestImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVer")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVer")
    androidTestImplementation("com.squareup.okhttp3:mockwebserver:3.14.2")

    androidTestImplementation("androidx.test:runner:1.3.0-alpha01")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0-alpha01")
}

configurations {
    implementation{
        resolutionStrategy.failOnVersionConflict()
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}