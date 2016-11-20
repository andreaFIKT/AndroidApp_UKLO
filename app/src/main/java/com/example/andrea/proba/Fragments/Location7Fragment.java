package com.example.andrea.proba.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.andrea.proba.R;

/**
 * Created by ANDREA on 10/10/2016.
 */
public class Location7Fragment extends android.support.v4.app.Fragment {
    WebView web7;
    Button buttonMore;
    Button buttonLess;
    boolean connA;
    String malaLinkOff;
    String golemaLinkOff;

    public Location7Fragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.location_7_fragment, container, false);
        web7 = (WebView) v.findViewById(R.id.webViewLoc7);
        connA = checkNetworkConnection(getContext());
        malaLinkOff = getResources().getString(R.string.loc7_malaTabla_link_offline);
        golemaLinkOff = getResources().getString(R.string.loc7_golemaTabla_link_offline);
        if(connA)
        {
            web7.setHorizontalScrollBarEnabled(true);
            web7.loadUrl("http://stklimentpath.fikt.edu.mk/sv-vraci.html");
            web7.requestFocus();
        }
       else
        {
            web7.setHorizontalScrollBarEnabled(true);
            web7.loadUrl(malaLinkOff);
            web7.requestFocus();
        }
        buttonMore = (Button) v.findViewById(R.id.btnMoreLoc7);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web7.setHorizontalScrollBarEnabled(true);
                    web7.loadUrl("http://stklimentpath.fikt.edu.mk/sv-vraci.html");
                    web7.requestFocus();
                }
                else
                {
                    web7.setHorizontalScrollBarEnabled(true);
                    web7.loadUrl(golemaLinkOff);
                    web7.requestFocus();
                }
            }
        });

        buttonLess = (Button)v.findViewById(R.id.btnLessLoc7);
        buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web7.setHorizontalScrollBarEnabled(true);
                    web7.loadUrl("http://stklimentpath.fikt.edu.mk/sv-vraci.html");
                    web7.requestFocus();
                }
                else
                {
                    web7.setHorizontalScrollBarEnabled(true);
                    web7.loadUrl(malaLinkOff);
                    web7.requestFocus();
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
