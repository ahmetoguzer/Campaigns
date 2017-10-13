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



import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.indicator.progresspie.ProgressPieIndicator;
import com.github.piasy.biv.loader.fresco.FrescoImageLoader;
import com.github.piasy.biv.loader.glide.GlideImageLoader;
import com.github.piasy.biv.view.BigImageView;
import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;
import com.technoface.app.campaigns.AppController;
import com.technoface.app.campaigns.R;
import com.technoface.app.campaigns.adapters.AnaMenuPagerAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class PuanlarFragment extends Fragment {
    private ViewPager pager;
    private PageIndicatorView indicator;

    public static PuanlarFragment newInstance() {
        PuanlarFragment fragment = new PuanlarFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootview= inflater.inflate(R.layout.fragment_campaigns, container, false);


        pager = (ViewPager) rootview.findViewById(R.id.pager);
        AnaMenuPagerAdapter adapter = new AnaMenuPagerAdapter(getActivity());
        pager.setAdapter(adapter);
        indicator = (PageIndicatorView)rootview.findViewById(R.id.pageIndicatorView);
        indicator.setViewPager(pager);
        indicator.setAnimationType(AnimationType.FILL);
        return rootview;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }




}
