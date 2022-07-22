package com.masoudjafari.taskjava;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            SharedPreferences settings = getSharedPreferences("TaskJava", Context.MODE_PRIVATE);
            String fontSizePref = settings.getString("FONT_SIZE", "Medium");
            String fontTypePref = settings.getString("FONT_TYPE", "First");

            int themeID = R.style.FontSizeMediumOne;
            if (fontSizePref.equals("Small") & fontTypePref.equals("First"))
                themeID = R.style.FontSizeSmallOne;
            else if (fontSizePref.equals("Small") & fontTypePref.equals("Second"))
                themeID = R.style.FontSizeSmallTwo;
            else if (fontSizePref.equals("Medium") & fontTypePref.equals("Second"))
                themeID = R.style.FontSizeMediumTwo;
            else if (fontSizePref.equals("Large") & fontTypePref.equals("First"))
                themeID = R.style.FontSizeLargeOne;
            else if (fontSizePref.equals("Large") & fontTypePref.equals("Second"))
                themeID = R.style.FontSizeLargeTwo;

            setTheme(themeID);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
