package com.example.demo3_androidnetworking;


import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    ImageView img2;
    TextView tv2;

    @SuppressLint("MissingInflatedId")
    User user = new User();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        img2 = findViewById(R.id.img_avata2);
        tv2 = findViewById(R.id.tv_email2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        if (intent.getExtras() == null){
            tv2.setText("No Valid to show");

        }
        if (intent.getExtras() != null){
            String email = bundle.getString("email");
            String avata = bundle.getString("avatar");
            tv2.setText(email);
            if (!URLUtil.isValidUrl(avata)){
                img2.setImageResource(R.drawable.ic_launcher_foreground);
            }else {
                Picasso.get().load(avata).into(img2);
            }

        }




    }
}