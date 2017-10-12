/*
 * Copyright (c) 2017. Truiton (http://www.truiton.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Mohit Gupt (https://github.com/mohitgupt)
 *
 */

package com.technoface.app.campaigns.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.github.piasy.biv.indicator.progresspie.ProgressPieIndicator;
import com.github.piasy.biv.view.BigImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.squareup.picasso.Picasso;
import com.technoface.app.campaigns.AppController;
import com.technoface.app.campaigns.FrescoLoaderActivity;
import com.technoface.app.campaigns.R;


import static android.content.ContentValues.TAG;


public class AnaMenuFragment extends Fragment implements View.OnClickListener {

    private BigImageView bim1,bim2,bim3,sok1,sok2,sok3,a1,a2,a3;
    private DbxClientV2 client;
    ProgressDialog progres;
    String bimlink1,bimlink2,bimlink3,soklink1,soklink2,soklink3,alink2,alink1,alink3;
    private LinearLayout bimLayout;


    public static AnaMenuFragment newInstance() {
        AnaMenuFragment fragment = new AnaMenuFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootview=inflater.inflate(R.layout.fragment_ana_menu, container, false);
        init(rootview);

        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        client = new DbxClientV2(config, "ya-ku9mSWUAAAAAAAAAAntaQQ9F8i7310IJt1ji0RfPV3raCAq6zeY6UTlMtd67t");


        if(!AppController.getInstance().isGetLinks){
            playPreMovie asyn =new playPreMovie("/bim",bimlink1,bim1);
            asyn.execute();
        }else{
            loadImage();
        }


        return rootview;
    }

    private void init(View v){
        bim1 = (BigImageView) v.findViewById(R.id.img_bim1);
        bim2 = (BigImageView) v.findViewById(R.id.img_bim2);
        bim3 = (BigImageView) v.findViewById(R.id.img_bim3);

        sok1 = (BigImageView) v.findViewById(R.id.img_sok1);
        sok2 = (BigImageView) v.findViewById(R.id.img_sok2);
        sok3 = (BigImageView) v.findViewById(R.id.img_sok3);

        a1 = (BigImageView) v.findViewById(R.id.img_A101_1);
        a2 = (BigImageView) v.findViewById(R.id.img_A101_2);
        a3 = (BigImageView) v.findViewById(R.id.img_A101_3);

        bimLayout = (LinearLayout) v.findViewById(R.id.child1);

        bimLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.frame_layout, MontajlarFragment.newInstance());
//                transaction.commit();

                startActivity(new Intent(getActivity(), FrescoLoaderActivity.class));
            }
        });


    }

    private void loadImage(){
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity())
//                .threadPriority(Thread.NORM_PRIORITY)
//                .denyCacheImageMultipleSizesInMemory()
//                .tasksProcessingOrder(QueueProcessingType.LIFO)
//                .memoryCacheSize(1*1024*2014)
//                .discCacheSize(2*1024*1024)
//                .build();
//
//        ImageLoader.getInstance().init(config);
//        ImageLoader imageLoader=ImageLoader.getInstance();
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .cacheOnDisc()
//                .cacheInMemory()
//                .build();
//        imageLoader.displayImage(AppController.getInstance().bimlink1,bim1, options);
//        imageLoader.displayImage(AppController.getInstance().bimlink2,bim2, options);
//        imageLoader.displayImage(AppController.getInstance().bimlink3,bim3, options);
//
//        imageLoader.displayImage(AppController.getInstance().soklink1,sok1, options);
//        imageLoader.displayImage(AppController.getInstance().soklink2,sok2, options);
//        imageLoader.displayImage(AppController.getInstance().soklink3,sok3, options);
//
//        imageLoader.displayImage(AppController.getInstance().alink1,a1, options);
//        imageLoader.displayImage(AppController.getInstance().alink2,a2, options);
//        imageLoader.displayImage(AppController.getInstance().alink3,a3, options);

        bim1.setProgressIndicator(new ProgressPieIndicator());
        bim1.showImage(Uri.parse(AppController.getInstance().bimlink1));
        bim2.setProgressIndicator(new ProgressPieIndicator());
        bim2.showImage(Uri.parse(AppController.getInstance().bimlink2));
        bim3.setProgressIndicator(new ProgressPieIndicator());
        bim3.showImage(Uri.parse(AppController.getInstance().bimlink3));

        sok1.setProgressIndicator(new ProgressPieIndicator());
        sok1.showImage(Uri.parse(AppController.getInstance().soklink1));
        sok2.setProgressIndicator(new ProgressPieIndicator());
        sok2.showImage(Uri.parse(AppController.getInstance().soklink2));
        sok3.setProgressIndicator(new ProgressPieIndicator());
        sok3.showImage(Uri.parse(AppController.getInstance().soklink3));

        a1.setProgressIndicator(new ProgressPieIndicator());
        a1.showImage(Uri.parse(AppController.getInstance().alink1));
        a2.setProgressIndicator(new ProgressPieIndicator());
        a2.showImage(Uri.parse(AppController.getInstance().alink2));
        a3.setProgressIndicator(new ProgressPieIndicator());
        a3.showImage(Uri.parse(AppController.getInstance().alink3));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

    class playPreMovie extends AsyncTask {

        String str,link;
        BigImageView v;
        public playPreMovie(String str,String link ,BigImageView v) {
            this.str = str;
            this.link = link;
            this.v = v;
        }

        @Override
        protected void onPreExecute() {
            progres = new ProgressDialog(getActivity());
            progres.setMessage("Yükleniyor");
            progres.show();
            super.onPreExecute();
            Log.d(TAG,"Link Alınıyor");
        }


        @Override
        protected Object doInBackground(Object[] params) {
            try {

                AppController.getInstance().bimlink1 = client.files().getTemporaryLink("/bim1.jpg").getLink();
                AppController.getInstance().bimlink2 = client.files().getTemporaryLink("/bim2.jpg").getLink();
                AppController.getInstance().bimlink3 = client.files().getTemporaryLink("/bim3.jpg").getLink();

                AppController.getInstance().soklink1 = client.files().getTemporaryLink("/sok1.jpg").getLink();
                AppController.getInstance().soklink2 = client.files().getTemporaryLink("/sok2.jpg").getLink();
                AppController.getInstance().soklink3 = client.files().getTemporaryLink("/sok3.jpg").getLink();

                AppController.getInstance().alink1 = client.files().getTemporaryLink("/a1.jpg").getLink();
                AppController.getInstance().alink2 = client.files().getTemporaryLink("/a2.jpg").getLink();
                AppController.getInstance().alink3 = client.files().getTemporaryLink("/a3.jpg").getLink();

            } catch (DbxException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            progres.dismiss();
            AppController.getInstance().isGetLinks = true;
            loadImage();

    }
    }
}
