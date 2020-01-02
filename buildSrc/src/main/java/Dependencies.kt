object Dependencies {
    val appComapat = "androidx.appcompat:appcompat:1.0.2"
    val core = "androidx.core:core-ktx:1.0.2"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
}

object Versions {
    val kotlin = "1.3.50"
}

object TestDependencies {
    val junit = "junit:junit:4.12"
    val junitExt = "androidx.test.ext:junit:1.1.0"
    val espresso = "androidx.test.espresso:espresso-core:3.1.1"
}

object Libraries {
    val spotify = "com.spotify.android:auth:1.1.0"
}

object Modules {
    val login = ":login"
    val common = ":common"
    val spotifyLogin = ":spotify-login"
}