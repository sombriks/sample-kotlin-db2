package me.sombriks

import io.javalin.Javalin

fun main(args: Array<String>) {
    val app = Javalin.create(/*config*/)
        .get("/") { ctx -> ctx.result("Hello World") }
        .start(7070)
}