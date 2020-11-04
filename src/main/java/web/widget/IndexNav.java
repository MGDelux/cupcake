package web.widget;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathi @ 29-10-2020 - 13:53
 **/
public class IndexNav {
    private final HttpServletRequest request;
    public IndexNav(HttpServletRequest request) {
        this.request = request;
    }
    private final List<IndexNav.Item> navLinks = List.of(
            new IndexNav.Item("Hjem", "/", false),
            new IndexNav.Item("Cupcakes", "/products/", false),
            new IndexNav.Item("Profil", "/profilepage", false),
            new IndexNav.Item("Admin ", "/AdminPage", true));

    public List<IndexNav.Item> GetNavBarLink() {
        String role = (String) request.getSession().getAttribute("role");
        System.out.println("!!! ROLE "+role);
        if (role != null && role.equals("admin")) {
            return navLinks;
        } else {
            List<IndexNav.Item> list = new ArrayList<>();
            for (IndexNav.Item item : navLinks) {
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

