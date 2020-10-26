package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {
    public static String thing;

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException, IOException {
        String thing = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( thing, password );
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        out.println("logged in wowie");
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", thing);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
        return "test";
    }

}
