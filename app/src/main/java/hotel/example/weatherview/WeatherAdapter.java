package hotel.example.weatherview;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hotel.example.weatherview.MainActivity.weatherData;

public class WeatherAdapter extends RecyclerView.Adapter {
    public WeatherAdapter(MainActivity mainActivity, MainActivity.ArrayList arrayList) {

    }

    public WeatherAdapter(MainActivity mainActivity, ArrayList arrayList) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void updateData(ArrayList<weatherData> weatherDataList) {

    }
}
