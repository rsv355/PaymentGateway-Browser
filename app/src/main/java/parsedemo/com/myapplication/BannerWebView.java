package parsedemo.com.myapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by krishnakumar on 10-05-2016.
 */
public class BannerWebView extends Activity {
    private WebView wv1;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);




        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        wv1 = (WebView) findViewById(R.id.webview);

        wv1.loadUrl("http://nochex.eposapi.co.uk?id=hari_chinnu21@yahoo.com&amount=11&name=krishna&address=asdfff&city=ahmd&postcode=st161dt&phone=8974785965&email=check1235@search2reach.com&test=true");

        wv1.setWebViewClient(new MyBrowser());


        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.getSettings().setSupportZoom(true);
        wv1.getSettings().setBuiltInZoomControls(true);


    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();


    }





    private class MyBrowser extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                 Log.e("OverrideUrlLoading",url);
                           //if(url.equalsIgnoreCase("http://ws-srv-net.in.webmyne.com/Applications/paylabas/Loading.html")){
            if (url.equalsIgnoreCase("http://nochex.eposapi.co.uk/index.php?error=0&msg=successmessage") ||
                    url.equalsIgnoreCase("https://nochex.eposapi.co.uk/index.php?error=0&msg=successmessage")||
                    url.equalsIgnoreCase("http://nochex.eposapi.co.uk/index.php?error=0&msg=Transaction+Success")||
                    url.equalsIgnoreCase("https://nochex.eposapi.co.uk/index.php?error=0&msg=Transaction+Success")) {

                    Intent i = new Intent();
                    setResult(RESULT_OK, i);
                    finish();
                    return true;
                }else if (url.equalsIgnoreCase("http://nochex.eposapi.co.uk/index.php?error=0&msg=failedmessag") ||
                    url.equalsIgnoreCase("https://nochex.eposapi.co.uk/index.php?error=0&msg=failedmessag")||
                    url.equalsIgnoreCase("http://nochex.eposapi.co.uk/index.php?error=0&msg=Transaction+Failed")||
                    url.equalsIgnoreCase("https://nochex.eposapi.co.uk/index.php?error=0&msg=Transaction+Failed")) {

                Intent i = new Intent();
                setResult(RESULT_CANCELED, i);
                finish();
                return true;
            }
            
            return false;
        }
    }



//end of main class

}
