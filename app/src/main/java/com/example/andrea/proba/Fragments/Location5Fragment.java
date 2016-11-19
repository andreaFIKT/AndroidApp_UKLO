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
public class Location5Fragment extends android.support.v4.app.Fragment {
    WebView web5;
    Button buttonMore;
    Button buttonLess;
    boolean connA;
    String linkOff;

    public Location5Fragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.location_5_fragment, container, false);
        web5 = (WebView) v.findViewById(R.id.webViewLoc5);
        connA = checkNetworkConnection(getContext());
        linkOff = getResources().getString(R.string.loc5_malaTabla_link_offline);
        if(connA)
        {
            web5.setHorizontalScrollBarEnabled(true);
            web5.loadUrl("http://www.fikt.uklo.edu.mk");
            web5.requestFocus();
        }
        else
        {
            web5.setHorizontalScrollBarEnabled(true);
            web5.loadUrl(linkOff);
            web5.requestFocus();
        }
        buttonMore = (Button) v.findViewById(R.id.btnMoreLoc5);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web5.getSettings().setJavaScriptEnabled(true);
                web5.setWebViewClient(new WebViewClient());
                web5.setHorizontalScrollBarEnabled(true);
                web5.loadUrl("http://www.google.com");
                web5.requestFocus();

                if(connA)
                {
                    web5.setHorizontalScrollBarEnabled(true);
                    web5.loadUrl("http://www.google.com");
                    web5.requestFocus();
                }
                else
                {
                    web5.setHorizontalScrollBarEnabled(true);
                    web5.loadUrl(linkOff);
                    web5.requestFocus();
                }

            }
        });

        buttonLess = (Button)v.findViewById(R.id.btnLessLoc5);
        buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web5.setHorizontalScrollBarEnabled(true);
                    web5.loadUrl("http://www.fikt.uklo.edu.mk");
                    web5.requestFocus();
                }
                else
                {
                    web5.setHorizontalScrollBarEnabled(true);
                    web5.loadUrl(linkOff);
                    web5.requestFocus();
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
