package me.sombriks.service

import me.sombriks.model.Todo
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.mapTo

class TodoService(private val db: Jdbi) {

    fun listTodos(q: String = ""): List<Todo> {
        return db.withHandle<List<Todo>, Exception> {
            it.createQuery("select * from todos where description like :q")
                .bind("q", "%$q%")
                .mapTo(Todo::class.java)
                .toList()
        }
    }

    fun findTodo(id: Int): Todo {
        return db.withHandle<Todo, Exception> {
            it.createQuery("select * from todos where id = :id")
                .bind("id", id)
                .mapTo(Todo::class.java)
                .one()
        }
    }

    fun insertTodo(newTodo: Todo) {
        db.useHandle<Exception> {
            it.createUpdate("insert into todos (description) values (:description)")
                .bindBean(newTodo)
                .execute()
        }
    }

    fun updateTodo(todo: Todo) {
        db.useHandle<Exception> {
            it.createUpdate("update todos set description = :description where id = :id")
                .bindBean(todo)
                .execute()
        }
    }

    fun delTodo(id: Int) {
        db.useHandle<Exception> {
            it.execute("delete from todos where id = ?", id)
        }
    }
}
