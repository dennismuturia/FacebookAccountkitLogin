package com.webweaver.dennis.facebookaccountkitlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static int APP_REQUEST_CODE = 99;
    Button btnPhone, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaring the buttons that I am using.
        btnEmail = (Button)findViewById(R.id.emailButton);
        btnPhone = (Button)findViewById(R.id.phoneButton);
    }
}
