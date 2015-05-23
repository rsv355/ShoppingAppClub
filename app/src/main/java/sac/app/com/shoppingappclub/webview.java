package sac.app.com.shoppingappclub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class webview extends ActionBarActivity {
    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        browser = (WebView) findViewById(R.id.web);

        if(checkInternet()){
            String url = getIntent().getStringExtra("url");
            startbrowser(url);

        }else {
            Toast.makeText(webview.this,"Please connect your Internet",Toast.LENGTH_SHORT).show();
        }
    }

    void startbrowser(String url){

            browser.setWebViewClient(new WebViewClient(){
                ProgressDialog progressDialog;


                //Show loader on url load
                public void onLoadResource (WebView view, String url) {
                    if (progressDialog == null) {
                        // in standard case YourActivity.this
                        progressDialog = new ProgressDialog(webview.this);
                        progressDialog.setMessage("Loading...");
                        progressDialog.show();
                    }
                }
                public void onPageFinished(WebView view, String url) {
                    try{
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                            progressDialog = null;
                        }
                    }catch(Exception exception){
                        exception.printStackTrace();
                    }
                }
            });
        browser.getSettings().setJavaScriptEnabled(true);

        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);
       // browser.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        browser.setScrollbarFadingEnabled(false);
        browser.getSettings().setBuiltInZoomControls(true);
        //Load url in webview
        browser.loadUrl(url);
    }

    private boolean checkInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(webview.this.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ) {
            return true;
        } else {
            return false;
        }


    }
}
