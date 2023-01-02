// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.application) version Versions.application apply false
    id(Plugins.androidLibrary) version Versions.androidLibrary apply false
    id(Plugins.kotlinAndroid) version Versions.kotlinAndroid apply false

    // Hilt
    id(Plugins.hilt) version Versions.hilt apply false
}