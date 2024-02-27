import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose") version "1.5.12"

    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)

    val ktor_version = "2.3.8"

    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-xml:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-cbor:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-protobuf:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("ch.qos.logback:logback-classic:1.2.3")
//    implementation(project(":json-kotlinx"))
//    implementation(project(":e2e"))

    implementation("cafe.adriel.voyager:voyager-navigator-desktop:1.0.0-rc02")
    implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator-desktop:1.0.0-rc02")
    implementation("cafe.adriel.voyager:voyager-transitions-desktop:1.0.0-rc02")
    implementation("cafe.adriel.voyager:voyager-tab-navigator-desktop:1.0.0-rc02")

//    testImplementation("junit:junit:$junit_version")
//    testImplementation("org.hamcrest:hamcrest:$hamcrest_version")

}

compose.desktop {
    application {
        mainClass = "ru.avem.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "dbManager"
            packageVersion = "1.0.0"
        }
    }
}
