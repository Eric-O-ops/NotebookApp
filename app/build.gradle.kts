plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)

    // Kapt
    kotlin(Plugins.kapt)

    // Hilt
    id(Plugins.hilt)
}

android {
    namespace = Config.applicationId
    compileSdk = Config.compileAndTargetSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.compileAndTargetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    // ViewBinding
    buildFeatures.viewBinding = true
}

dependencies {

    // Core
    implementation(Dependencies.Core.core)

    // Appcompat
    implementation(Dependencies.UIComponents.appcompat)

    // Material
    implementation(Dependencies.UIComponents.material)

    // Constraint Layout
    implementation(Dependencies.UIComponents.constraintLayout)

    // Tests
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    // Room
    implementation(Dependencies.Room.roomRuntime)
    annotationProcessor(Dependencies.Room.roomCompiler)
    kapt(Dependencies.Room.roomCompiler)

    // ViewBinding Property Delegate
    implementation(Dependencies.ViewBindingPropertyDelegate.viewBindingDelegate)

    // Navigation
    implementation(Dependencies.Navigation.navigation)

    //Hilt
    implementation(Dependencies.DaggerHilt.daggerHilt)
    kapt(Dependencies.DaggerHilt.hiltAndroidKapt)

    //LottieFiles
    implementation(Dependencies.LottieFiles.lottie)

    //Dots indicator
    implementation(Dependencies.DotsIndicator.dotsIndicator)
}