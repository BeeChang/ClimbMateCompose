@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.com.android.application.get().pluginId)
    id(libs.plugins.org.jetbrains.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.kapt.get().pluginId)
}

android {
    namespace = Config.appDomain
    compileSdk = Config.compileSdk
    defaultConfig {
        minSdk = Config.minSdk
    }
}

dependencies {

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}