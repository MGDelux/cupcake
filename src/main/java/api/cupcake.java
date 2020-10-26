package api;

import domain.*;

public class  cupcake {
    private static String ver = "0.0";
    private final TopsRepo topList;
    private final ButRepo butList;

    public cupcake(TopsRepo topList, ButRepo butList) {
        this.topList = topList;
        this.butList = butList;
    }

    public static String getVer() {
        return ver;
    }


}
