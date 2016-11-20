package com.example.andrea.proba.Fragments;

import android.app.Service;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.andrea.proba.R;

/**
 * Created by ANDREA on 10/8/2016.
 */
public class LocationOneFragment extends Fragment {
    WebView web1;
    Button buttonMore;
    Button buttonLess;
    boolean connA;
    String malaLinkOff;
    String golemaLinkOff;
    Configuration newConfig;

    public LocationOneFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.location_one_fragment, container, false);
        web1 = (WebView) v.findViewById(R.id.webView);
        Log.d("INTERNET", String.valueOf(checkNetworkConnection(getContext())));
        connA = checkNetworkConnection(getContext());
        malaLinkOff = getResources().getString(R.string.loc1_malaTabla_link_offline);
        golemaLinkOff = getResources().getString(R.string.loc1_golemaTabla_link_offline);

        if (connA == true)

        {
            web1.getSettings().setJavaScriptEnabled(true);
            web1.setWebViewClient(new WebViewClient());
            web1.setHorizontalScrollBarEnabled(true);
            web1.loadUrl("http://stklimentpath.fikt.edu.mk/golemi/plaosnik.html");
            web1.requestFocus();
        } else {
            web1.setWebViewClient(new WebViewClient());
            web1.setHorizontalScrollBarEnabled(true);
            web1.loadUrl(malaLinkOff);
            web1.requestFocus();
        }


        buttonMore = (Button) v.findViewById(R.id.btnMore);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (connA == true)

                {
                    web1.getSettings().setJavaScriptEnabled(true);
                    web1.setWebViewClient(new WebViewClient());
                    web1.setHorizontalScrollBarEnabled(true);
                    web1.loadUrl("http://stklimentpath.fikt.edu.mk/golemi/plaosnik.html");
                    web1.requestFocus();
                } else {
                    web1.setWebViewClient(new WebViewClient());
                    web1.setHorizontalScrollBarEnabled(true);
                    web1.loadUrl(golemaLinkOff);
                    web1.requestFocus();
                }

            }
        });
//        buttonMore.setVisibility(View.VISIBLE);
        buttonLess = (Button) v.findViewById(R.id.btnLess);
        buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (connA == true)

                {
                    web1.getSettings().setJavaScriptEnabled(true);
                    web1.setWebViewClient(new WebViewClient());
                    web1.setHorizontalScrollBarEnabled(true);
                    web1.loadUrl("http://stklimentpath.fikt.edu.mk/golemi/plaosnik.html");
                    web1.requestFocus();
                } else {
                    web1.setWebViewClient(new WebViewClient());
                    web1.setHorizontalScrollBarEnabled(true);
                    web1.loadUrl(malaLinkOff);
                    web1.requestFocus();
                }
            }
        });

        return v;
    }

    public boolean checkNetworkConnection(Context _context) {
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }
}


