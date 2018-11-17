package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {

        User u = new User();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        u.setSurname(rs.getString("surname"));
        return u;
    }

}
