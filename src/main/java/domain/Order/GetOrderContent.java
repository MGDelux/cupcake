package domain.Order;

/**
 * CREATED BY mathi @ 05-11-2020 - 13:29
 **/
public class GetOrderContent {
    String top;
    String bot;
    int cupcake;

    public GetOrderContent(String top, String bot, int cupcake) {
        this.top = top;
        this.bot = bot;
        this.cupcake = cupcake;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBot() {
        return bot;
    }

    public void setBot(String bot) {
        this.bot = bot;
    }

    public int getCupcake() {
        return cupcake;
    }

    public void setCupcake(int cupcake) {
        this.cupcake = cupcake;
    }
}
