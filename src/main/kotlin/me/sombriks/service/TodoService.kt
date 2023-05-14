package me.sombriks.service

import me.sombriks.config.query
import me.sombriks.model.Todo
import javax.sql.DataSource

class TodoService(private val ds: DataSource) {

    fun listTodos(q: String = ""): List<Todo> {
        val todos = mutableListOf<Todo>()
        ds.query("select * from todos where description like ?", arrayOf(q)) {
            todos.add(Todo(it.getInt(1), it.getString(2)))
        }
        return todos
    }

    fun findTodo(id: Int) {

    }

    fun insertTodo(newTodo: Todo) {

    }

    fun updateTodo(newTodo: Todo) {

    }

    fun delTodo(id: Int) {

    }
}