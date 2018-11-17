package UserDAO;

import java.util.List;
import model.User;

public interface UserDAO {


    public int adduser(User u);

    public List<User> list();

}
