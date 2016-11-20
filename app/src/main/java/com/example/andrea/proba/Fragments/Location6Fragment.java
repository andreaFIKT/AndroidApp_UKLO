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
public class Location6Fragment extends android.support.v4.app.Fragment {
    WebView web6;
    Button buttonMore;
    Button buttonLess;
    boolean connA;
    String golemaLinkOff;
    String malaLinkOff;
    public Location6Fragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.location_6_fragment, container, false);
        web6 = (WebView) v.findViewById(R.id.webViewLoc6);
        connA = checkNetworkConnection(getContext());
        malaLinkOff = getResources().getString(R.string.loc6_malaTabla_link_offline);
        golemaLinkOff = getResources().getString(R.string.loc6_golemaTabla_link_offline);
        if(connA)
        {
            web6.setHorizontalScrollBarEnabled(true);
            web6.loadUrl("http://stklimentpath.fikt.edu.mk/sv-konstantin-i-elena.html");
            web6.requestFocus();
        }
        else
        {
            web6.setHorizontalScrollBarEnabled(true);
            web6.loadUrl(malaLinkOff);
            web6.requestFocus();
        }

        buttonMore = (Button) v.findViewById(R.id.btnMoreLoc6);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web6.setHorizontalScrollBarEnabled(true);
                    web6.loadUrl("http://stklimentpath.fikt.edu.mk/sv-konstantin-i-elena.html");
                    web6.requestFocus();
                }
                else
                {
                    web6.setHorizontalScrollBarEnabled(true);
                    web6.loadUrl(golemaLinkOff);
                    web6.requestFocus();
                }

            }
        });

        buttonLess = (Button)v.findViewById(R.id.btnLessLoc6);
        buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web6.setHorizontalScrollBarEnabled(true);
                    web6.loadUrl("http://stklimentpath.fikt.edu.mk/sv-konstantin-i-elena.html");
                    web6.requestFocus();
                }
                else
                {
                    web6.setHorizontalScrollBarEnabled(true);
                    web6.loadUrl(malaLinkOff);
                    web6.requestFocus();
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
