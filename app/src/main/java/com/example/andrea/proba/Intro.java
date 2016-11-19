package com.example.andrea.proba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrea.proba.Utils.LocaleUtils;

import java.util.Locale;

/**
 * Created by ANDREA on 10/8/2016.
 */
public class Intro extends Activity {
    ImageView imgIntro;
    ListView selectLanguage;
    TextView txtSelectLanguage;
    Button buttonContinue;
    Context context;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapterMk;
    ArrayAdapter<CharSequence> adapterEn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);
        context = this;
        imgIntro = (ImageView) findViewById(R.id.introImage);
        txtSelectLanguage = (TextView) findViewById(R.id.selectLanguageLabel);
//        txtSelectLanguage.setText(R.string.txt_selectLanguage);
        selectLanguage = (ListView) findViewById(R.id.introSelectLanguage);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.language, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectLanguage.setAdapter(adapter);
        selectLanguage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String lang;
                if(i==0) {
                    lang = "mk";
                    Locale myLocale = new Locale(lang);
                    Resources res = getBaseContext().getResources();
                    DisplayMetrics dm = res.getDisplayMetrics();
                    Configuration conf = res.getConfiguration();
                    conf.locale = myLocale;

                    res.updateConfiguration(conf, dm);
                    getBaseContext().getResources().updateConfiguration(
                            getBaseContext().getResources().getConfiguration(),
                            getBaseContext().getResources().getDisplayMetrics());
//                    LocaleUtils.setLocale(LocaleUtils.SPANISH);
                    txtSelectLanguage.setText(R.string.txt_selectLanguage);
                    adapterMk = ArrayAdapter.createFromResource(context, R.array.language, R.layout.support_simple_spinner_dropdown_item);
                    selectLanguage.setAdapter(adapterMk);
                    buttonContinue.setText(R.string.continueB);
                }
                else if(i==1) {
                   /* Configuration newConfig = new Configuration();
                    newConfig.locale = Locale.ENGLISH;
                    onConfigurationChanged(newConfig);*/
                    lang = "en";
                    Locale myLocale = new Locale(lang);
                    Resources res = getBaseContext().getResources();
                    DisplayMetrics dm = res.getDisplayMetrics();
                    Configuration conf = res.getConfiguration();
                    conf.locale = myLocale;

                    res.updateConfiguration(conf, dm);
                    getBaseContext().getResources().updateConfiguration(
                            getBaseContext().getResources().getConfiguration(),
                            getBaseContext().getResources().getDisplayMetrics());

//                    LocaleUtils.setLocale(LocaleUtils.FRENCH);
                    txtSelectLanguage.setText(R.string.txt_selectLanguage);
                    adapterEn = ArrayAdapter.createFromResource(context, R.array.language, R.layout.support_simple_spinner_dropdown_item);
                    selectLanguage.setAdapter(adapterEn);
                    buttonContinue.setText(R.string.continueB);
                }
            }
        });

        buttonContinue = (Button) findViewById(R.id.btnContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intro.this,Menu.class);
                startActivity(intent);
            }
        });
    }
   /* @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.intro_layout);
        setTitle(R.string.app_name);

        // Checks the active language
        if (newConfig.locale == Locale.ENGLISH) {
            Toast.makeText(this, "English", Toast.LENGTH_SHORT).show();
        } else if (newConfig.locale == Locale.FRENCH){
            Toast.makeText(this, "French", Toast.LENGTH_SHORT).show();
        }
    }*/
}
