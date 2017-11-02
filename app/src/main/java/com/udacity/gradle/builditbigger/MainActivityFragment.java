package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.JavaJokes;
import com.example.mylibrary.MainActivity2;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    AdView adView;
    RelativeLayout relativeLayout;
    private static final String uid = "ca-app-pub-7596508623901365/3678329407";
    Button button;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        relativeLayout = (RelativeLayout) root.findViewById(R.id.advertisefragment);
        button = (Button)root.findViewById(R.id.advertiseshowbtn);
        adView = new AdView(getActivity());
        adView.setAdUnitId(uid);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Toast.makeText(getActivity(), String.valueOf(relativeLayout.getChildCount()), Toast.LENGTH_SHORT).show();
                if (BuildConfig.FLAVOR.equals("Freeflavor")) {

                    AdView adView = new AdView(getActivity());
                    adView.setAdSize(AdSize.BANNER);
                    adView.setAdUnitId(uid);
                    AdRequest adRequest = new AdRequest.Builder().build();
                    adView.loadAd(adRequest);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.ALIGN_BOTTOM);

                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                  relativeLayout.addView(adView,params);



                }


            //    JavaJokes javaJokes = new JavaJokes();
             //   Toast.makeText(getActivity(), JavaJokes.Joker().toString(), Toast.LENGTH_SHORT).show();

             //   new EndpointsAsyḥncTask().execute(new Pair<Context, String>(getActivity(), "Rahul"));
                new EndpointTask().execute(new Pair<Context, String>(getActivity(),JavaJokes.Joker()));
                try {

                } catch (Exception e) {
                    Log.d("TAG", "ERROR HERE" + e.toString());
                }


            }
        });
        // AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        //  AdRequest adRequest = new AdRequest.Builder()
        //         .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        //         .build();
        //   mAdView.loadAd(adRequest);

        return root;
    }

    @Override
    public void onStop() {
        super.onStop();
        relativeLayout.removeView(adView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        relativeLayout.removeView(adView);
    }
}
