package tech.onroad.android4https;

import android.app.Application;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Liting Wang on 07/12/2017.
 */

public class Android4HttpsApplication extends Application{
    private static final String TAG = "Android4HttpsApp";
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            //单向认证
            /*OkHttpClientManager.getInstance()
                    .setOneWayCertificates(getAssets().open("server.cer"));*/
            //双向认证
            OkHttpClientManager.getInstance()
                    .setTwoWayCertificates(getAssets().open("client.bks"),getAssets().open("server.cer"));
        } catch (IOException e){
            Log.e(TAG, e.getMessage());
        }
    }
}
