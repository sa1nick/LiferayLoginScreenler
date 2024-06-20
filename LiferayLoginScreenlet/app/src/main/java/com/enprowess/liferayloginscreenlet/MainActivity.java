package com.enprowess.liferayloginscreenlet;

import static android.content.ContentValues.TAG;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.liferay.mobile.screens.context.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_screenlet), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void onLoginSuccess(User user) {
        Log.i(TAG,"Login Successfully");
        Toast toast = Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onLoginFailure(User user) {
        Log.i(TAG,"Login Failed");
        Toast toast = Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT);
        toast.show();
    }
}