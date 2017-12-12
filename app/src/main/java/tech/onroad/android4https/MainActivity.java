package tech.onroad.android4https;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                postTest();
            }
        }).start();
    }

    private void postTest() {
        OkHttpClientManager.getAsyn("https://192.168.0.101:8443/SpringBootBase/", new OkHttpClientManager.ResultCallback<String>()
        {

            @Override
            public void onError(com.squareup.okhttp.Request request, Exception e) {
                Log.e(TAG, e.getMessage());
            }

            @Override
            public void onResponse(String u)
            {
                Log.d(TAG,"Response is " + u);
            }
        });
    }
}
