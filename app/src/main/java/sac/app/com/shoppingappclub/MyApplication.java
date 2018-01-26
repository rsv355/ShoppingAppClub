package sac.app.com.shoppingappclub;

import android.app.Application;

/**
 * Created by krishna on 26/01/2018.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        DatabaseHandler handler = new DatabaseHandler(getApplicationContext());
        try {
            handler.createDataBase();
        } catch (Exception e) {

        }
    }

}



