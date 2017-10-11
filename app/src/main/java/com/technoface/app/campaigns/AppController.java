package com.technoface.app.campaigns;

/**
 * Created by Ahmet on 25.5.2017.
 */

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;




import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import android.support.multidex.MultiDexApplication;
import android.support.multidex.MultiDex;

/**
 * Created by Ahmet on 10.5.2017.
 */

public class AppController extends MultiDexApplication  {

    private static AppController mInstance;
    public Uri profilImageUrl;
    public String profilName;
    public Uri profilLink;
    public String bimlink1;
    public String bimlink2;
    public String bimlink3;
    public String soklink1;
    public String soklink2;
    public String soklink3;
    public String alink1;
    public String alink2;
    public String alink3;
    public boolean isGetLinks = false;



    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        printHashKey();

    }

    public void printHashKey(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.technoface.app.duello",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("KeyHash:", e.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.d("KeyHash:", e.toString());
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}