import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

fun firebaseProperty(name: String, fallback: String): String {
    val props = Properties()
    val file = rootProject.file("firebase.properties")
    if (file.exists()) {
        file.inputStream().use(props::load)
    }
    return props.getProperty(name, fallback)
}

fun quote(value: String): String = "\"$value\""

android {
    namespace = "com.mihro.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mihro.app"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField(
            "String",
            "FIREBASE_API_KEY",
            quote(firebaseProperty("FIREBASE_API_KEY", "REPLACE_WITH_FIREBASE_API_KEY"))
        )
        buildConfigField(
            "String",
            "FIREBASE_APP_ID",
            quote(firebaseProperty("FIREBASE_APP_ID", "REPLACE_WITH_FIREBASE_APP_ID"))
        )
        buildConfigField(
            "String",
            "FIREBASE_PROJECT_ID",
            quote(firebaseProperty("FIREBASE_PROJECT_ID", "REPLACE_WITH_FIREBASE_PROJECT_ID"))
        )
        buildConfigField(
            "String",
            "FIREBASE_STORAGE_BUCKET",
            quote(firebaseProperty("FIREBASE_STORAGE_BUCKET", "REPLACE_WITH_FIREBASE_STORAGE_BUCKET"))
        )
        buildConfigField(
            "String",
            "FIREBASE_MESSAGING_SENDER_ID",
            quote(
                firebaseProperty(
                    "FIREBASE_MESSAGING_SENDER_ID",
                    "REPLACE_WITH_FIREBASE_MESSAGING_SENDER_ID"
                )
            )
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2026.02.01")

    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.navigation:navigation-compose:2.8.5")

    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("com.google.android.material:material:1.12.0 ")

    implementation(platform("com.google.firebase:firebase-bom:34.7.0"))
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.8.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
