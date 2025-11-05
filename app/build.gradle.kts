plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.apo_desmobile_2025"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.apo_desmobile_2025"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Dependências para Material Design (TabLayout, CardView, etc.)
    implementation("com.google.android.material:material:1.13.0")

    // Dependências para RecyclerView e CardView (já incluídas no Material, mas bom garantir)
    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("androidx.cardview:cardview:1.0.0")

    // Dependência para ViewPager2 (para as abas)
    implementation("androidx.viewpager2:viewpager2:1.1.0")
}