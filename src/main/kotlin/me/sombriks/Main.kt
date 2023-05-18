package me.sombriks

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import me.sombriks.config.InitConfig
import me.sombriks.config.logger
import me.sombriks.controller.TodoController
import me.sombriks.service.TodoService
import org.jdbi.v3.core.Jdbi

class Main {

    private val log by logger()

    fun initApp(): Javalin {

        val profile = System.getenv("APP_PROFILE") ?: "local"

        log.info("Preparing app with [$profile] profile")

        val db: Jdbi = Jdbi.create(
            HikariDataSource(
                HikariConfig(
                    "/datasource-$profile.properties"
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
        return app
    }
}

fun main(args: Array<String>) {

    val app = Main().initApp()
    app.start(7070)
}
