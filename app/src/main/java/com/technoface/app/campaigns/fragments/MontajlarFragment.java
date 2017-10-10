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



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;


public class MontajlarFragment extends Fragment implements View.OnClickListener {

    public static final String TAG =
            "MontajlarFragment";




    public static MontajlarFragment newInstance() {
        MontajlarFragment fragment = new MontajlarFragment();
        return fragment;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_montajlar, container, false);
//
//
//        return rootView;
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }


    @Override
    public void onClick(View v) {

    }


}
