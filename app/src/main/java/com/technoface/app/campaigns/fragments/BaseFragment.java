package com.technoface.app.campaigns.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Ahmet on 7.8.2017.
 */
public abstract class BaseFragment extends Fragment {

    protected BackHandlerInterface backHandlerInterface;


//    public Typeface hindMedium;
//    public Typeface hindRegular;
//    public Typeface hindSemibold;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(getActivity() instanceof BackHandlerInterface)) {
            throw new ClassCastException("Hosting activity must implement BackHandlerInterface");
        } else {
            backHandlerInterface = (BackHandlerInterface) getActivity();
        }

//        hindMedium = Typeface.createFromAsset(getResources().getAssets(), "fonts/Hind-Medium.ttf");
//        hindRegular = Typeface.createFromAsset(getResources().getAssets(), "fonts/Hind-Regular.ttf");
//        hindSemibold = Typeface.createFromAsset(getResources().getAssets(), "fonts/Hind-Semibold.ttf");

//        MyApplication application = (MyApplication) getActivity().getApplication();
//        mTracker = application.getDefaultTracker();
//
//        if (getActivity().findViewById(R.id.backButton) != null) {
//            ImageView backBtn = (ImageView) getActivity().findViewById(R.id.backButton);
//            backBtn.setClickable(true);
//        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Mark this fragment as the selected Fragment.
        backHandlerInterface.setSelectedFragment(this);
    }


    public boolean onBackPressed(){
        return false;
    }

    public interface BackHandlerInterface {
        public void setSelectedFragment(BaseFragment backHandledFragment);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
