package com.example.andrea.proba.Fragments;

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
public class Location19Fragment extends android.support.v4.app.Fragment {
    WebView web2;
    Button buttonMore;
    Button buttonLess;
    boolean connA;
    String malaLinkOff;
    String golemaLinkOff;

    public Location19Fragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.location_19_fragment, container, false);
        web2 = (WebView) v.findViewById(R.id.webViewLoc19);
        connA = checkNetworkConnection(getContext());
        malaLinkOff = getResources().getString(R.string.loc19_malaTabla_link_offline);
        golemaLinkOff = getResources().getString(R.string.loc19_golemaTabla_link_offline);
        if(connA)
        {
            web2.setHorizontalScrollBarEnabled(true);
            web2.loadUrl("http://stklimentpath.fikt.edu.mk/golemi/sv-arhangel-mihail.html");
            web2.requestFocus();
        }
        else
        {
            web2.setHorizontalScrollBarEnabled(true);
            web2.loadUrl(malaLinkOff);
            web2.requestFocus();
        }

        buttonMore = (Button) v.findViewById(R.id.btnMoreLoc19);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web2.setHorizontalScrollBarEnabled(true);
                    web2.loadUrl("http://stklimentpath.fikt.edu.mk/golemi/sv-arhangel-mihail.html");
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

        buttonLess = (Button)v.findViewById(R.id.btnLessLoc19);
        buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connA)
                {
                    web2.setHorizontalScrollBarEnabled(true);
                    web2.loadUrl("http://stklimentpath.fikt.edu.mk/golemi/sv-arhangel-mihail.html");
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
