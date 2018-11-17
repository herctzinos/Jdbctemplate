package Controllers;

import UserDAO.UserDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Usercontroller {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public ModelAndView listusers() {
        List<User> listUsers = userDao.list();
        ModelAndView model = new ModelAndView("userlist");
        model.addObject("/userlist", listUsers);
        return model;

    }

    @RequestMapping("/test")
    public ModelAndView helloWorld(ModelMap model, HttpServletRequest request) {

        String message = "Welcome to codeNuclear.com Spring MVC Sessions";
        message += "<br>You Did it....!";

        System.out.println(message);
        model.addAttribute("message", message);

        return new ModelAndView("test", "welcomeMessage", message);
    }
    @RequestMapping(value = "/adduser")
    public String adduser(ModelMap map) {

        User u = new User();
        u.setId(11);
        u.setName("Herc");
        u.setPassword("Smith");
        userDao.adduser(u);
        return "userlist";
    }

    @RequestMapping(value = "/createuser")
    public String createuser(ModelMap map) {

        User u = new User();
        userDao.adduser(u);
        return "userlist";
    }

    @RequestMapping(value = "/showform")
    public ModelAndView getuserform() {
        ModelAndView mva = new ModelAndView("userlist");
        User u = new User();
        u.setName("Herc");
        mva.addObject("userEntity", u);
        return mva;
    }

}
