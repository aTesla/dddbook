// https://mp.weixin.qq.com/s?__biz=MzAxNDEwNjk5OQ==&mid=2650427571&idx=1&sn=bfc3c1c6f189965a1a4c7f3918012405&chksm=839698abb4e111bd5e02344f27d86c928ccfe4d3da1649817b02924c07f681fc1a7ea818f442&scene=178&cur_album_id=1452661944472977409#rd
pluginManagement {
    plugins {
        id("org.springframework.boot") version "3.3.5" apply false
        id("io.spring.dependency-management") version "1.1.6" apply false
        id("org.jetbrains.kotlin.jvm") version "2.0.21" apply false
        id("org.jetbrains.kotlin.plugin.spring") version "2.0.21" apply false
        id("org.jetbrains.kotlin.plugin.serialization") version "2.0.21" apply false
    }
    repositories {
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}

rootProject.name = "dddbook"
include("bank-application")
include("bank-domain")
include("bank-external")
include("bank-messaging")
include("bank-persistence")
include("bank-start")
include("bank-types")
include("bank-web")