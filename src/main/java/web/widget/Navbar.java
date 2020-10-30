package web.widget;

import web.pages.Products;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathi @ 29-10-2020 - 09:27
 **/
public class Navbar {
    private final HttpServletRequest request;

    public Navbar(HttpServletRequest request) {
        this.request = request;
    }

    private final List<Item> navLinks = List.of(
            new Item("Home", "/", false),
            new Item("Products", "/products/", false),
            new Item("Admin ", "/AdminPage",true),
            new Item("Login","/login",false),
            new Item("basket","/basket",false));

    public List<Item> GetNavBarLink() {
        String role = (String) request.getSession().getAttribute("role");
        System.out.println("!!! ROLE "+role);
        if (role != null && role.equals("admin")) {
            return navLinks;
        } else {
            List<Item> list = new ArrayList<>();
            for (Item item : navLinks) {
                if (!item.adminOnly) {
                    list.add(item);
                }
            }
            return list;
        }

    }
    public class Item {
        private final String name;
        private final String url;
        private final boolean adminOnly;

        public Item(String name, String url, boolean adminOnly) {
            this.name = name;
            this.url = url;
            this.adminOnly = adminOnly;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        public boolean isAdminOnly() {
            return adminOnly;
        }
        public boolean isActive() {
            return request.getRequestURI().endsWith(url);
        }
    }

}
