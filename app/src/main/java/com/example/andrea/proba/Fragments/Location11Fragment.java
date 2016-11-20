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
public class Location11Fragment extends android.support.v4.app.Fragment {
    WebView web2;
    Button buttonMore;
    Button buttonLess;
    boolean connA;
    String golemaLinkOff;
    String malaLinkOff;

    public Location11Fragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.location_11_fragment, container, false);
        web2 = (WebView) v.findViewById(R.id.webViewLoc11);
        connA = checkNetworkConnection(getContext());
        malaLinkOff = getResources().getString(R.string.loc11_malaTabla_link_offline);
        golemaLinkOff = getResources().getString(R.string.loc11_golemaTabla_link_offline);
        if(connA)
        {
            web2.setHorizontalScrollBarEnabled(true);
            web2.loadUrl("http://stklimentpath.fikt.edu.mk/sv-sofija.html");
            web2.requestFocus();
        }
        else
        {
            web2.setHorizontalScrollBarEnabled(true);
            web2.loadUrl(malaLinkOff);
            web2.requestFocus();
        }

        buttonMore = (Button) v.findViewById(R.id.btnMoreLoc11);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web2.setHorizontalScrollBarEnabled(true);
                    web2.loadUrl("http://stklimentpath.fikt.edu.mk/sv-sofija.html");
                    web2.requestFocus();
                }
                else
                {
                    web2.setHorizontalScrollBarEnabled(true);
                    web2.loadUrl(golemaLinkOff);
                    web2.requestFocus();
                }

            }
        });
//        buttonMore.setVisibility(View.VISIBLE);
        buttonLess = (Button)v.findViewById(R.id.btnLessLoc11);
        buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web2.setHorizontalScrollBarEnabled(true);
                    web2.loadUrl("http://stklimentpath.fikt.edu.mk/sv-sofija.html");
                    web2.requestFocus();
                }
                else
                {
                    web2.setHorizontalScrollBarEnabled(true);
                    web2.loadUrl(malaLinkOff);
                    web2.requestFocus();
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
