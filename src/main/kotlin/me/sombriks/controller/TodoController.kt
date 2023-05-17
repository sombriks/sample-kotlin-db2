package me.sombriks.controller

import io.javalin.http.Context
import io.javalin.http.HttpStatus
import me.sombriks.model.Todo
import me.sombriks.service.TodoService

class TodoController(private val service: TodoService) {

    fun listTodos(ctx: Context) {
        ctx.json(service.listTodos(ctx.queryParam("q") ?: ""))
    }

    fun findTodo(ctx: Context) {
        ctx.json(service.findTodo(ctx.pathParam("id").toInt()))
    }

    fun insertTodo(ctx: Context) {
        val newTodo = ctx.bodyAsClass(Todo::class.java)
        service.insertTodo(newTodo)
        ctx.status(HttpStatus.CREATED)
    }

    fun updateTodo(ctx: Context) {
        val todo = ctx.bodyAsClass(Todo::class.java)
        todo.id = ctx.pathParam("id").toInt()
        service.updateTodo(todo)
        ctx.status(HttpStatus.NO_CONTENT)
    }

    fun delTodo(ctx: Context) {
        service.delTodo(ctx.pathParam("id").toInt())
        ctx.status(HttpStatus.NO_CONTENT)
    }

}
