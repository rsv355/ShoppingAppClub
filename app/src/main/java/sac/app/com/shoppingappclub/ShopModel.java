package sac.app.com.shoppingappclub;

/**
 * Created by krishna on 26/01/2018.
 */

public class ShopModel {
    public String id;
    public String Name;
    public String Image;
    public String Url;

    public ShopModel() {
    }

    public ShopModel(String id, String name, String image, String url) {
        this.id = id;
        Name = name;
        Image = image;
        Url = url;
    }
}
