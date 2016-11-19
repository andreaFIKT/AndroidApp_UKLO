package com.example.andrea.proba.Fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andrea.proba.Menu;
import com.example.andrea.proba.R;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * Created by ANDREA on 10/26/2016.
 */
public class ChangeLanguageFragment extends Fragment {
    ImageView img;
    TextView txt_chLan;
    ListView list_chLan;
    ArrayAdapter<CharSequence> adapter;


    public ChangeLanguageFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.change_language_fragment, container, false);
        img = (ImageView) v.findViewById(R.id.introImage);
        txt_chLan = (TextView) v.findViewById(R.id.selectLanguageLabelMenuChangeLan);
        list_chLan = (ListView) v.findViewById(R.id.introSelectLanguageMenuChangeLan);
        txt_chLan.setText(R.string.txt_selectLanguage);


        adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.language, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list_chLan.setAdapter(adapter);
        list_chLan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String lang;
                if(i==0) {
                    lang = "mk";
                    Locale myLocale = new Locale(lang);
                    Resources res = getContext().getResources();
                    DisplayMetrics dm = res.getDisplayMetrics();
                    Configuration conf = res.getConfiguration();
                    conf.locale = myLocale;

                    res.updateConfiguration(conf, dm);
                    getContext().getResources().updateConfiguration(
                            getContext().getResources().getConfiguration(),
                            getContext().getResources().getDisplayMetrics());
                    Intent intent = new Intent(getActivity(),Menu.class);
                    startActivity(intent);
                }
                else if(i==1) {
                    lang = "en";
                    Locale myLocale = new Locale(lang);
                    Resources res = getContext().getResources();
                    DisplayMetrics dm = res.getDisplayMetrics();
                    Configuration conf = res.getConfiguration();
                    conf.locale = myLocale;

                    res.updateConfiguration(conf, dm);
                    getContext().getResources().updateConfiguration(
                            getContext().getResources().getConfiguration(),
                            getContext().getResources().getDisplayMetrics());
                    Intent intent = new Intent(getActivity(),Menu.class);
                    startActivity(intent);
                }
            }
        });
        return v;
    }
}