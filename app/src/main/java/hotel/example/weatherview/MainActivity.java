package hotel.example.weatherview;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "WeatherView";

    private static final String API_KEY = "8fce76c4ae639b43514e5b0ba7ff40d8";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/forecast?q=%s&units=metric&appid=" + API_KEY;

    private EditText searchEditText;

    private RecyclerView recyclerView;

    private WeatherAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new WeatherAdapter(this, new ArrayList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;

    }

    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_search) {

            searchWeather();

            return true;

        }


        return super.onOptionsItemSelected(item);

    }

    private void searchWeather() {
        String location = searchEditText.getText().toString();
        String url = String.format(API_URL, location);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray Weather = response.getJSONArray("List");
                    java.util.ArrayList<weatherData> weatherDataList = new java.util.ArrayList<>();
                    for (int i = 0; i < Weather.length(); i++) {
                        JSONObject weatherObject = Weather.getJSONObject(i);
                        JSONObject mainObject = weatherObject.getJSONObject("Main");
                        JSONObject weatherObjectList = Weather.getJSONObject(i).getJSONArray("Weather").getJSONObject(0);
                        String description = weatherObjectList.getString("Descripción");
                        String date = weatherObject.getString("fecha_txt");
                        double temperature = mainObject.getDouble("Temperatura");
                        weatherData weatherData = new weatherData(date, temperature, description);
                        weatherDataList.add(weatherData);
                    }
                    adapter.updateData(weatherDataList);
                } catch (JSONException e) {
                    Log.e(TAG, "Error de respuesta JSON", e);
                    Toast.makeText(MainActivity.this, "Error al analizar weather data", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e(TAG, "Error al cargar datos del clima", error);
                Toast.makeText(MainActivity.this, "Error al cargar datos del clima", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public class ArrayList {
    }

    class weatherData {
        public weatherData(String date, double temperature, String description) {

        }
    }
}