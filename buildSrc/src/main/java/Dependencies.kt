object Versions {

    const val application = "7.3.1"
    const val androidLibrary = "7.3.1"
    const val kotlinAndroid = "1.7.20"
    const val appcompat = "1.5.1"
    const val material = "1.7.0"
    const val constraintLayout = "2.1.4"
    const val room = "2.4.3"
    const val hilt = "2.42"
    const val viewBindingDelegate = "1.4.7"
    const val lottie = "3.4.0"
    const val dotsIndicator = "2.1.6"
    const val navVersion = "2.5.2"
    const val safeArgs = "2.5.3"
}

object Plugins {

    const val application = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val androidLibrary = "com.android.library"
    const val kapt = "kapt"
    const val hilt = "com.google.dagger.hilt.android"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
}

object Dependencies {

    object Core {

        const val core = "androidx.core:core-ktx:1.9.0"
    }

    object UIComponents {

        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    }

    object Room {

        const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object Navigation {

        const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    }

    object ViewBindingPropertyDelegate {

        const val viewBindingDelegate =
            "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBindingDelegate}"
    }


    object DaggerHilt {

        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltAndroidKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }

    object LottieFiles {

        const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    }

    object DotsIndicator {

        const val  dotsIndicator = "me.relex:circleindicator:${Versions.dotsIndicator}"
    }
}