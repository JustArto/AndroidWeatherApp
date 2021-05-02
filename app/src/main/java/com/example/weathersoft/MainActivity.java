package com.example.weathersoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;

    TextView textCity, textTemp, textDesc, textHumid, textPressure,textWind;
    Button change, search;

    //EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        change = findViewById(R.id.btnChange);

        textCity = findViewById(R.id.city);
        textTemp = findViewById(R.id.temp);
        textDesc = findViewById(R.id.description);
        textHumid = findViewById(R.id.humidity);
        textPressure = findViewById(R.id.pressure);
        textWind = findViewById(R.id.wind);

        change.setOnClickListener(this);
/*
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivityTwo.class);
                startActivityForResult(intent, 1);
            }



            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (data == null) {return;}
                String name = data.getStringExtra("name");
                getWeatherData(name);
            }



        });*/

    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), MainActivityTwo.class);
        startActivityForResult(intent, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String name = data.getStringExtra("name");
        getWeatherData(name);
    }



    private void getWeatherData(final String name)throws NullPointerException{

        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                textCity.setText(name);
                textTemp.setText(response.body().getMain().getTemp() +" °C");
                textDesc.setText("Feels Like"+" "+response.body().getMain().getFeels_like()+" °C");
                //textDesc.setText("Desc "+"\n"+response.body().);
                textHumid.setText("Humidity"+" "+response.body().getMain().getHumidity()+ " o/o");
                textPressure.setText("Pressure "+response.body().getMain().getPressure()+ " hPa");
                textWind.setText("Wind "+response.body().getWind().getSpeed()+" m/s");

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }

        });
    }

}



// listView = findViewById(R.id.list);
//        button = findViewById(R.id.btn);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,names));
//                }
//
//        });

