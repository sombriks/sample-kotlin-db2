package me.sombriks.config

import org.jdbi.v3.core.Jdbi
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object InitConfig {

    private val log by logger()

    fun initDb(db: Jdbi) {

        log.info("preparing database")

        db.useHandle<Exception> {
            it.execute(
                """
                create table if not exists todos (
                    id integer not null GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
                    description varchar(255),
                    PRIMARY KEY (id)
                );
            """
            )
            it.execute(
                """
                   insert into todos(description) 
                    values ('some description'), ('more description'), ('another description');
                """
            )
        }
    }
}


fun <R : Any> R.logger(): Lazy<Logger> {
    return lazy { LoggerFactory.getLogger(getClassName(this.javaClass)) }
}
fun <T : Any> getClassName(clazz: Class<T>): String {
    return clazz.name.removeSuffix("\$Companion")
}
