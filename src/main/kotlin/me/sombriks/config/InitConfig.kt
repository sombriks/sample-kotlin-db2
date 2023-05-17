package me.sombriks.config

import me.sombriks.model.Todo
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.mapper.RowMapper
import java.sql.ResultSet
import javax.sql.DataSource

object InitConfig {

    fun initDb(db: Jdbi) {
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
