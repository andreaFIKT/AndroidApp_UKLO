package com.example.andrea.proba.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
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
public class Location4Fragment extends android.support.v4.app.Fragment {
    WebView web4;
    Button buttonMore;
    Button buttonLess;
    boolean connA;
    String linkOff;

    public Location4Fragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.location_4_fragment, container, false);
        web4 = (WebView) v.findViewById(R.id.webViewLoc4);
        connA = checkNetworkConnection(getContext());
        linkOff = getResources().getString(R.string.loc4_malaTabla_link_offline);
        if(connA)
        {
            web4.setHorizontalScrollBarEnabled(true);
            web4.loadUrl("http://stklimentpath.fikt.edu.mk/Sv.Dimitrija.html");
            web4.requestFocus();
        }
        else
        {
            web4.setHorizontalScrollBarEnabled(true);
            web4.loadUrl(linkOff);
            web4.requestFocus();
        }

        buttonMore = (Button) v.findViewById(R.id.btnMoreLoc4);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web4.setHorizontalScrollBarEnabled(true);
                    web4.loadUrl("http://stklimentpath.fikt.edu.mk/Sv.Dimitrija.html");
                    web4.requestFocus();
                }
                else
                {
                    web4.setHorizontalScrollBarEnabled(true);
                    web4.loadUrl(linkOff);
                    web4.requestFocus();
                }

            }
        });

        buttonLess = (Button)v.findViewById(R.id.btnLessLoc4);
        buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web4.setWebViewClient(new WebViewClient());
                    web4.setHorizontalScrollBarEnabled(true);
                    web4.loadUrl("http://stklimentpath.fikt.edu.mk/Sv.Dimitrija.html");
                    web4.requestFocus();
                }
                else
                {
                    web4.setWebViewClient(new WebViewClient());
                    web4.setHorizontalScrollBarEnabled(true);
                    web4.loadUrl(linkOff);
                    web4.requestFocus();
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
