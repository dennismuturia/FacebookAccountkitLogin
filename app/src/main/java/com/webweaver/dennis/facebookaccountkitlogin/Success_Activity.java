package com.webweaver.dennis.facebookaccountkitlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;

public class Success_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_);

        //Declare a signout button
        Button signout = (Button)findViewById(R.id.logout);
        //Create an onclick listener
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountKit.logOut();
                finish();
            }
        });
    }
    //Press Ctrl+o

    @Override
    protected void onPostResume() {
        super.onPostResume();

        AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
            @Override
            public void onSuccess(Account account) {
                EditText editUser, editPhone, editEmail;

                editUser = (EditText)findViewById(R.id.editUserId);
                //Deal with the user ID first
                editUser.setText(String.format("The Id is %s", account.getId()));
                editPhone = (EditText)findViewById(R.id.editPhone);
                //Then Phone number
                editPhone.setText(String.format("The Phone number is %s", account.getPhoneNumber() == null ? "":account.getPhoneNumber().toString()));
                editEmail = (EditText)findViewById(R.id.editEmail);
                //Lastly on the email
                editEmail.setText(String.format("The Email is %s", account.getEmail()));
            }

            @Override
            public void onError(AccountKitError accountKitError) {

            }
        });
    }
}
