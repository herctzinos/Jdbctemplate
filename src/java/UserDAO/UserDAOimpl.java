package UserDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import mapper.UserMapper;
import model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class UserDAOimpl implements UserDAO {

    private DataSource dataSource;

    public UserDAOimpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> list() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "Select * from user";
        List<User> listUser = jdbcTemplate.query(sql, new UserMapper());
        return listUser;
    }

    @Override
    public int adduser(User u) {

        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("user");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", u.getId());
        parameters.put("name", u.getName());
        parameters.put("surname", u.getSurname());
        return simpleJdbcInsert.execute(parameters);

    }

}
