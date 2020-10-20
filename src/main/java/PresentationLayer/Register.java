package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.UserRepo;
import api.Cupcake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends Command {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email1");
        if (UserMapper.checkMail(email)) {
            throw new LoginSampleException("Email er enten allerede registreret eller ikke godkendt");
        } else if(!checkIfEmail(email)) {
            throw new LoginSampleException("Email er ikke godkendt");
        }
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            System.out.println(email + password1 + password2);
            if (password1.equals(password2)) {
                User user = LogicFacade.createUser(email, password1);
                HttpSession session = request.getSession();

                session.setAttribute("email", email);
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole());
                return user.getRole() + "page";
            } else {
                throw new LoginSampleException("the two passwords did not match");
            }
        }

    private static boolean checkIfEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
}
