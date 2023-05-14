package me.sombriks.controller

import io.javalin.http.Context
import me.sombriks.service.TodoService

class TodoController(private val service: TodoService) {

    fun listTodos(ctx: Context) {
        ctx.json(service.listTodos(ctx.queryParam("q")))
    }

    fun findTodo(ctx: Context) {

    }

    fun insertTodo(ctx: Context) {

    }

    fun updateTodo(ctx: Context) {

    }

    fun delTodo(ctx: Context) {

    }

}