/* @author mathias */
package PresentationLayer;
import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class passwordReset extends Command {
    public static String email;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        if (UserMapper.checkMail(email)) {
            UserMapper.resetUser(email);
            return "index";
        } else throw new LoginSampleException("Email is not present");
    }
}
