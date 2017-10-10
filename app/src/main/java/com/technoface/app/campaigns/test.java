package com.technoface.app.campaigns;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.squareup.picasso.Picasso;

import static android.content.ContentValues.TAG;

/**
 * Created by Ahmet on 10.10.2017.
 */

public class test {
    private DbxClientV2 client;
    ProgressDialog progres;
    String movLink;
    ImageView img;
    Context context;

    public test(DbxClientV2 client, ProgressDialog progres, String movLink, ImageView img, DbxRequestConfig config) {
        this.client = client;
        this.progres = progres;
        this.movLink = movLink;
        this.img = img;
//        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
//        client = new DbxClientV2(config, "ya-ku9mSWUAAAAAAAAAAkQ7JC1r_z9AlFZnG9x84_fqCtZQ6KmQyXfPKwDVdNBhj");


        new playPreMovie().execute();
    }



class playPreMovie extends AsyncTask {

    @Override
    protected void onPreExecute() {
        progres = new ProgressDialog(context);
        progres.setMessage("Video Başlatılıyor");
        progres.show();
        super.onPreExecute();
        Log.d(TAG,"Link Alınıyor");
    }


    @Override
    protected Object doInBackground(Object[] params) {
        try {
            movLink = client.files().getTemporaryLink("/bim.jpg").getLink();
        } catch (DbxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        progres.dismiss();
        Picasso.with(context).load(movLink).into(img);
    }
}
}
