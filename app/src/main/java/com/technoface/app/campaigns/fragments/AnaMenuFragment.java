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

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.technoface.app.campaigns.R;

public class AnaMenuFragment extends Fragment implements View.OnClickListener {


    public static AnaMenuFragment newInstance() {
        AnaMenuFragment fragment = new AnaMenuFragment();
        return fragment;
    }



//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
////        final View rootview=inflater.inflate(R.layout.fragment_ana_menu, container, false);
//
//
//
//        return rootview;
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }



    }
}
