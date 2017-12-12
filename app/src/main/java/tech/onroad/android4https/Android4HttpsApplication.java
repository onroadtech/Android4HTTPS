package tech.onroad.android4https;

import android.app.Application;

import java.io.IOException;

/**
 * Created by TMS on 07/12/2017.
 */

public class Android4HttpsApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        try
        {
            OkHttpClientManager.getInstance()
                    .setCertificates(getAssets().open("server.cer"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
