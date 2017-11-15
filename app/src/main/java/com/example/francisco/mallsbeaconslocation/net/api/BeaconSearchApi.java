package com.example.francisco.mallsbeaconslocation.net.api;

import android.content.Context;
import android.util.Log;

import com.example.francisco.mallsbeaconslocation.models.Recomendation;
import com.example.francisco.mallsbeaconslocation.net.HttpApi;
import com.example.francisco.mallsbeaconslocation.net.HttpAsyncTask;
import com.example.francisco.mallsbeaconslocation.net.Response;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.functions.Consumer;

public class BeaconSearchApi extends HttpApi {

    static final int REQUEST_BEACON = 0;



    public interface onBeaconSearch{
        void onBeaconSearch(List<Recomendation> data);
    }

    onBeaconSearch onBeaconSearch;

    public BeaconSearchApi(Context context) {
        super(context);
    }

    public void getPreferencesRecomender(String Userid, String Beaconone, String Beacontwo, BeaconSearchApi.onBeaconSearch onBeaconSearch){
        this.onBeaconSearch = onBeaconSearch;

        String url = urlBaseBeacon+"preferences?usernameid="+Userid+"&beaconidone=Beacon"+Beaconone+"&beaconidtwo=Beacon"+Beacontwo;
        Log.e("URL", urlBaseBeacon+"preferences?usernameid="+Userid+"&beaconidone=Beacon"+Beaconone+"&beaconidtwo=Beacon"+Beacontwo);
        HttpAsyncTask task = makeTask(REQUEST_BEACON, HttpAsyncTask.METHOD_GET);
        task.execute(url);
    }

    public void getPreferencesMostPreferred(String Userid, String Beaconone, String Beacontwo, BeaconSearchApi.onBeaconSearch onBeaconSearch){
        this.onBeaconSearch = (BeaconSearchApi.onBeaconSearch) onBeaconSearch;

        String url = urlBaseBeacon+"morepreferred?usernameid="+Userid+"&beaconidone=Beacon"+Beaconone+"&beaconidtwo=Beacon"+Beacontwo;
        Log.e("URL", urlBaseBeacon+"morepreferred?usernameid="+Userid+"&beaconidone=Beacon"+Beaconone+"&beaconidtwo=Beacon"+Beacontwo);
        HttpAsyncTask task = makeTask(REQUEST_BEACON, HttpAsyncTask.METHOD_GET);
        task.execute(url);
    }


    @Override
    public void onResponse(int request, Response response) {
        switch (request){
            case REQUEST_BEACON:
                Log.e("URL", "onResponse BeaconSearchApi Beacon Request"+response);
                processRecomendations(response);
                break;
        }
    }

    void processRecomendations(Response response){
        if(validateError(response)){
            Type type = new TypeToken<List<Recomendation>>(){}.getType();
            List<Recomendation> data = gson.fromJson(response.getMsg(),type);
            onBeaconSearch.onBeaconSearch(data);
            Log.e("URL", "processRecomendations BeaconSearchApi dentro if "+ data);
        }

    }

}

