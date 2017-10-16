package cn.liweifa.spittr.data;

import cn.liweifa.spittr.pojo.Spittle;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by josli on 17/10/16.
 */
@Repository
public class JdbcSpittleRepository implements SpittleRepository {
    @Resource(name = "jdbcOperations")
    private JdbcOperations jdbcOperations;

    @Override
    public List<Spittle> findRecentSpittles() {
        return jdbcOperations.query(
                "select `id`, `message`, created_at, latitude, longitude" +
                        " from Spittle" +
                        " order by created_at desc limit 20",
                new SpittleRowMapper());
    }
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return jdbcOperations.query(
                "select `id`, `message`, created_at, latitude, longitude" +
                        " from Spittle" +
                        " where `id` < ?" +
                        " order by created_at desc limit 20",
                new SpittleRowMapper(), max);
    }

    @Override
    public Spittle findOne(long id) {
        return jdbcOperations.queryForObject(
                "select `id`, `message`, created_at, latitude, longitude" +
                        " from Spittle" +
                        " where `id` = ?",
                new SpittleRowMapper(), id);
    }

    @Override
    public void save(Spittle spittle) {
        jdbcOperations.update(
                "insert into Spittle (`message`, created_at, latitude, longitude)" +
                        " values (?, ?, ?, ?)",
                spittle.getMessage(),
                spittle.getTime(),
                spittle.getLatitude(),
                spittle.getLongitude());
    }

    private static class SpittleRowMapper implements RowMapper<Spittle> {
        public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spittle(
                    rs.getLong("`id`"),
                    rs.getString("`message`"),
                    rs.getDate("created_at"),
                    rs.getDouble("longitude"),
                    rs.getDouble("latitude"));
        }
    }
}
