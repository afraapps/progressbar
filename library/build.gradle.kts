plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
}

android {
    namespace = "ir.afraapps.widget.progressbar"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}


afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "ir.afraapps"
                artifactId = "progressbar"
                version = rootProject.extra.get("appVersionName") as String

                pom {
                    name.set(project.name)
                    description.set("The progressbar for mahak")
                    url.set("https://github.com/dabestaniha/${project.name}")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("sobhan-jabbari")
                            name.set("Ali Jabbari")
                            email.set("sobhan.jabbari@gmail.com")
                        }
                    }

                    scm {
                        connection.set("scm:git:github.com/dabestaniha/${project.name}.git")
                        url.set("https://github.com/dabestaniha/${project.name}")
                    }
                }
            }
        }

        repositories {
            maven {
                name = "afraapps"
                url = uri("${project.layout.buildDirectory}/afraapps")
            }
        }

    }
}


dependencies {

    implementation("androidx.core:core-ktx:1.12.0")

    val appcompat_version = "1.6.1"
    implementation("androidx.appcompat:appcompat:$appcompat_version")
    implementation("androidx.appcompat:appcompat-resources:$appcompat_version")

    implementation("com.google.android.material:material:1.10.0")
}