package cn.liweifa.spittr.data;

import cn.liweifa.spittr.pojo.Spitter;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by josli on 17/10/16.
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {
    @Resource(name = "jdbcOperations")
    private JdbcOperations jdbcOperations;
    @Override
    public Spitter save(Spitter spitter) {
        jdbcOperations.update("(`username`, `password`, first_name, last_name, `email`) VALUES (?,?,?,?)"
        ,spitter.getUsername(),spitter.getPassword(),spitter.getFirstName(),spitter.getLastName(),spitter.getEmail());
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return jdbcOperations.queryForObject(
                "select `id`, `username`, null, first_name, last_name, `email` from Spitter where username=?",
                new SpitterRowMapper(),
                username);
    }

    private static class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(
                    rs.getLong("`id`"),
                    rs.getString("`username`"),
                    null,
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("`email`"));
        }
    }
}
