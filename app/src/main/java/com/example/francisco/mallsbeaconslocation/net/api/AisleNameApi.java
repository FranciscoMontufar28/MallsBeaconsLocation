package com.example.francisco.mallsbeaconslocation.net.api;

import android.content.Context;
import android.util.Log;

import com.example.francisco.mallsbeaconslocation.models.AisleName;
import com.example.francisco.mallsbeaconslocation.net.HttpApi;
import com.example.francisco.mallsbeaconslocation.net.HttpAsyncTask;
import com.example.francisco.mallsbeaconslocation.net.Response;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jhovy on 19/11/2017.
 */

public class AisleNameApi extends HttpApi {

    static final int REQUEST_BEACON = 0;



    public interface onAisleSearch{
        void onAisleSearch(List<AisleName> data);
    }

    onAisleSearch onAisleSearch;


    public AisleNameApi(Context context) {
        super(context);
    }

    public void getAisleName(String Beaconone, String Beacontwo, AisleNameApi.onAisleSearch onAisleSearch){
        this.onAisleSearch = onAisleSearch;
        Log.e("URL Aisle", "getAisleName AisleNameApi ");
        String url = urlBaseBeacon+"aisle?beaconidone=Beacon"+Beaconone+"&beaconidtwo=Beacon"+Beacontwo;
        HttpAsyncTask task = makeTask(REQUEST_BEACON, HttpAsyncTask.METHOD_GET);
        task.execute(url);
    }


    @Override
    public void onResponse(int request, Response response) {
        switch (request){
            case REQUEST_BEACON:
                Log.e("URL Aisle", "onResponse AisleNameApi "+response);
                processAisle(response);
                break;
        }
    }


    void processAisle(Response response){
        if(validateError(response)){
            Type type = new TypeToken<List<AisleName>>(){}.getType();
            List<AisleName> data = gson.fromJson(response.getMsg(),type);
            onAisleSearch.onAisleSearch(data);
            Log.e("URL Aisle", "processRecomendations BeaconSearchApi dentro if "+ data);
        }

    }
}
