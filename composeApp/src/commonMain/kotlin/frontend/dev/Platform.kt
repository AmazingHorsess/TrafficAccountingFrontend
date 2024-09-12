package frontend.dev

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform