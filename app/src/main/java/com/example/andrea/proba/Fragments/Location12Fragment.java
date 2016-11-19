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
public class Location12Fragment extends android.support.v4.app.Fragment {
    WebView web2;
    Button buttonMore;
    Button buttonLess;
    boolean connA;
    String linkOff;

    public Location12Fragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.location_12_fragment, container, false);
        web2 = (WebView) v.findViewById(R.id.webViewLoc12);
        connA = checkNetworkConnection(getContext());
        linkOff = getResources().getString(R.string.loc12_malaTabla_link_offline);
        if(connA)
        {
            web2.setHorizontalScrollBarEnabled(true);
            web2.loadUrl("http://stklimentpath.fikt.edu.mk/sv-jovan-kaneo.html");
            web2.requestFocus();
        }
        else
        {
            web2.setHorizontalScrollBarEnabled(true);
            web2.loadUrl(linkOff);
            web2.requestFocus();
        }

        buttonMore = (Button) v.findViewById(R.id.btnMoreLoc12);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web2.setHorizontalScrollBarEnabled(true);
                    web2.loadUrl("http://stklimentpath.fikt.edu.mk/sv-jovan-kaneo.html");
                    web2.requestFocus();
                }
                else
                {
                    web2.setHorizontalScrollBarEnabled(true);
                    web2.loadUrl(linkOff);
                    web2.requestFocus();
                }

            }
        });
//        buttonMore.setVisibility(View.VISIBLE);
        buttonLess = (Button)v.findViewById(R.id.btnLessLoc12);
        buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web2.setHorizontalScrollBarEnabled(true);
                    web2.loadUrl("http://stklimentpath.fikt.edu.mk/sv-jovan-kaneo.html");
                    web2.requestFocus();
                }
                else
                {
                    web2.setHorizontalScrollBarEnabled(true);
                    web2.loadUrl(linkOff);
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
