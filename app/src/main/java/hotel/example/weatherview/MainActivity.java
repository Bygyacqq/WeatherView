package hotel.example.weatherview;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "WeatherView";

    private static final String API_KEY = "Wview";
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
    }

    public class ArrayList {
    }
}