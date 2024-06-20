package com.enprowess.liferayloginscreenlet;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.liferay.mobile.screens.auth.login.LoginListener;
import com.liferay.mobile.screens.auth.login.LoginScreenlet;
import com.liferay.mobile.screens.context.User;

public class MainActivity extends AppCompatActivity implements LoginListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginScreenlet loginScreenlet = (LoginScreenlet) findViewById(R.id.login_screenlet);

        loginScreenlet.setListener(this);
    }


    @Override
    public void onLoginSuccess(User user) {
        Log.i(TAG, user.getEmail() + " " + user.getScreenName() + " " + user.getValues());

        // Create an intent to start ActivityOne
        Intent intent = new Intent(MainActivity.this, ActivitySuccess.class);

        // Put the user details into the intent
        intent.putExtra("userEmail", user.getEmail());
        intent.putExtra("userScreenName", user.getScreenName());

        // Start ActivityOne
        startActivity(intent);

        // Show the Toast message
        Toast.makeText(MainActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(Exception e) {
        Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthenticationBrowserShown() {

    }
}