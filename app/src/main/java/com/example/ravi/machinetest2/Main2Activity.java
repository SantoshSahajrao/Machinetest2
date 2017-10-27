package com.example.ravi.machinetest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView ;
    TextView txtTitle,txtDes;
    RadioButton small,large,medium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = (ImageView) findViewById(R.id.img);
        txtTitle = (TextView) findViewById(R.id.txtTile);
        txtDes = (TextView) findViewById(R.id.txtDes);

        Intent intent = getIntent();
        final Data data =(Data) intent.getSerializableExtra("Re");

        Picasso.with(Main2Activity.this).load(data.getLImg()).into(imageView);
        txtTitle.setText(data.getmTitle());
        txtDes.setText(data.getmDescription());

        small = (RadioButton) findViewById(R.id.small);
        medium = (RadioButton) findViewById(R.id.medium);
        large = (RadioButton) findViewById(R.id.large);

        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(Main2Activity.this).load(data.getSImg()).into(imageView);


            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(Main2Activity.this).load(data.getMImg()).into(imageView);
            }
        });

        large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Picasso.with(Main2Activity.this).load(data.getLImg()).into(imageView);
            }
        });





    }
}
