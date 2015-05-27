package sac.app.com.shoppingappclub;

/**
 * Created by Android on 27-05-2015.
 */


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.CurlEffect;


public class WebViewFragment extends Fragment {
    WebView browser;
    ProgressBar progressBar;
    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.webview, container, false);
        progressBar = (ProgressBar)view. findViewById(R.id.progressBar);
        browser = (WebView)view. findViewById(R.id.web);

        if(checkInternet()){
            //String url = getIntent().getStringExtra("url");

            Bundle bundle = this.getArguments();
            String url = bundle.getString("url");
            startbrowser(url);

        }else {
            Toast.makeText(getActivity(), "Please connect your Internet", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    void startbrowser(String url){

        browser.setWebViewClient(new WebViewClient(){
            ProgressDialog progressDialog;


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);//new
            }


            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);//new
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
        ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ) {
            return true;
        } else {
            return false;
        }


    }
}