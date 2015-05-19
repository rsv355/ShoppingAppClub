package sac.app.com.shoppingappclub;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.Toast;

public class SplashPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



    }

    @Override
    protected void onResume() {
        super.onResume();

        if(checkInternet()){

             new CountDownTimer(4000,4000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    Intent i  = new Intent(SplashPage.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }.start();

        }else{
            Toast.makeText(SplashPage.this,"Please connect your Internet",Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(SplashPage.this.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        } else {
            return false;
        }


    }
}
