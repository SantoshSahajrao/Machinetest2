package com.example.ravi.machinetest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ArrayList<Data> marrayList;
    RecyAdapter mrecyAdapter;
    RecyclerView mrecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrecyclerView = (RecyclerView) findViewById(R.id.xrecy);

        marrayList = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest("https://www.googleapis.com/youtube/v3/playlists?part=snippet%20&channelId=UC_x5XG1OV2P6uZZ5FSM9Ttw%20&key=AIzaSyD3-rVQCVkN9bxkETMuojKmJCrU2gssB8Q", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray Item = response.getJSONArray("items");
                    for (int i=0;i<=Item.length();i++)

                    {
                        Data data = new Data();
                        JSONObject jsonobj = Item.getJSONObject(i);
                        JSONObject snpies = jsonobj.getJSONObject("snippet");
                        data.mTitle = snpies.getString("title");
                        data.mDescription = snpies.getString("description");
                        JSONObject thamnail = snpies.getJSONObject("thumbnails");
                        JSONObject DImg = thamnail.getJSONObject("default");
                        data.SImg = DImg.getString("url");
                        JSONObject Medium = thamnail.getJSONObject("medium");
                        data.MImg = Medium.getString("url");
                        JSONObject LargeImg = thamnail.getJSONObject("high");
                        data.LImg = LargeImg.getString("url");

                        marrayList.add(data);
                        mrecyAdapter.notifyDataSetChanged();


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(request);

        mrecyAdapter = new RecyAdapter(marrayList,MainActivity.this);
        mrecyclerView.setAdapter(mrecyAdapter);
      //  LinearLayoutManager layoutManger = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        mrecyclerView.setLayoutManager(gridLayoutManager);
    }
}
