package vinimusbot.app.API.Schedule;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Schedule {

    public void fetchRacesCurentSeason() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("http://ergast.com/api/f1/current").method("GET", null).build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

}
