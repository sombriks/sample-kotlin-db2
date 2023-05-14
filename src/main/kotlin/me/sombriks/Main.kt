package me.sombriks

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import me.sombriks.config.InitConfig
import me.sombriks.controller.TodoController
import me.sombriks.service.TodoService
import javax.sql.DataSource

fun main(args: Array<String>) {

    val dataSource: DataSource = HikariDataSource(
        HikariConfig(
            "/datasource.properties"
        )
    )

    InitConfig.initDb(dataSource)

    val service: TodoService = TodoService(dataSource)
    val controller: TodoController = TodoController(service)

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