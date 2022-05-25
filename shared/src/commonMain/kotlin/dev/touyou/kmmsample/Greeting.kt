package dev.touyou.kmmsample

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}