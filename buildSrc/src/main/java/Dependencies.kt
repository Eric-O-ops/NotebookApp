object Versions {

    const val application = "7.3.1"
    const val androidLibrary = "7.3.1"
    const val kotlinAndroid = "1.7.20"
    const val appcompat = "1.5.1"
    const val material = "1.7.0"
    const val constraintLayout = "2.1.4"
}

object Plugins {

    const val application = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val androidLibrary = "com.android.library"
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
}