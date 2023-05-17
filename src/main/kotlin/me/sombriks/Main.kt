package me.sombriks

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import me.sombriks.config.InitConfig
import me.sombriks.controller.TodoController
import me.sombriks.service.TodoService
import org.jdbi.v3.core.Jdbi

fun main(args: Array<String>) {

    val db: Jdbi = Jdbi.create(
        HikariDataSource(
            HikariConfig(
                "/datasource.properties"
            )
        )
    )

    InitConfig.initDb(db)

    val service = TodoService(db)
    val controller = TodoController(service)

    val app = Javalin.create {
        // config
    }

    app.routes {
        path("/todos") {
            get(controller::listTodos)
            post(controller::insertTodo)
            path("/{id}") {
                get(controller::findTodo)
                put(controller::updateTodo)
                delete(controller::delTodo)
            }
        }
    }

    app.start(7070)
}
