package com.technoface.app.campaigns;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.squareup.picasso.Picasso;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {


    private DbxClientV2 client;
    ProgressDialog progres;
    String movLink;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        client = new DbxClientV2(config, "ya-ku9mSWUAAAAAAAAAAkQ7JC1r_z9AlFZnG9x84_fqCtZQ6KmQyXfPKwDVdNBhj");


        new playPreMovie().execute();
    }

    class playPreMovie extends AsyncTask {

        @Override
        protected void onPreExecute() {
            progres = new ProgressDialog(MainActivity.this);
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
            Picasso.with(MainActivity.this).load(movLink).into(img);
        }
    }
}
