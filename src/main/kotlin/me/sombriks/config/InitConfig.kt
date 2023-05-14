package me.sombriks.config

import java.sql.ResultSet
import javax.sql.DataSource

object InitConfig {

    fun initDb(ds: DataSource) {
        ds.connection.use {
            it.prepareStatement(
                """
                create table if not exists todos (
                    id integer not null GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
                    description varchar(255),
                    PRIMARY KEY (id)
                );
            """.trimIndent()
            ).executeUpdate()
        }
    }
}

fun DataSource.query(query: String, params: Array<String?>, resultSetResolver: (rs: ResultSet) -> Unit) {
    this.connection.use {
        val ps = it.prepareStatement(query)
        // XXX for sample purposes only
        for (i in params.indices) ps.setString(i + 1, "%${params[i]}%")
        val rs = ps.executeQuery()
        while (rs.next()) resultSetResolver(rs)
    }
}