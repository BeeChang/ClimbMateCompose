buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.agp)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.hilt.plugin)
        classpath(libs.androidx.navigation.safeargs)
        classpath(libs.secrets)
    }
}



tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}