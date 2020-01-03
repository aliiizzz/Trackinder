object Dependencies {
    val appComapat = "androidx.appcompat:appcompat:1.0.2"
    val core = "androidx.core:core-ktx:1.0.2"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val livedata = "androidx.lifecycle:lifecycle-extensions:${Versions.livedata}"

    val room = "androidx.room:room-runtime:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
}

object Versions {
    val kotlin = "1.3.50"
    val navigation = "2.1.0"
    val dagger = "2.25.2"
    val livedata = "2.1.0"
    val room = "2.2.3"
}

object TestDependencies {
    val junit = "junit:junit:4.12"
    val junitExt = "androidx.test.ext:junit:1.1.0"
    val espresso = "androidx.test.espresso:espresso-core:3.1.1"
}

object Libraries {
    val spotify = "com.spotify.android:auth:1.1.0"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}

object Modules {
    val login = ":login"
    val common = ":common"
    val spotifyLogin = ":spotify-login"
    val navigation = ":navigation"
    val di = ":di"
    val local = ":local"
    val repository = ":repository"
}