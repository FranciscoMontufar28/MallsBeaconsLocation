package com.example.francisco.mallsbeaconslocation.net.api;

import android.content.Context;
import android.util.Log;

import com.example.francisco.mallsbeaconslocation.models.Recomendation;
import com.example.francisco.mallsbeaconslocation.models.UserName;
import com.example.francisco.mallsbeaconslocation.net.HttpApi;
import com.example.francisco.mallsbeaconslocation.net.HttpAsyncTask;
import com.example.francisco.mallsbeaconslocation.net.Response;

import java.util.List;

/**
 * Created by jhovy on 29/11/2017.
 */

public class UserApi extends HttpApi {

    static final int REQUEST_BEACON = 0;

    public interface onUserSearch{
        void onUserSearch(List<UserName> data);
    }

    onUserSearch onUserSearch;


    public UserApi(Context context) {
        super(context);
    }


    public void setUserResponse (String Userid, String itemcode){
        this.onUserSearch = onUserSearch;

        String url = urlBaseBeacon+"feedback?usernameid="+Userid+"&itemid="+itemcode;
        Log.e("URL", urlBaseBeacon+"feedback?usernameid="+Userid+"&itemid="+itemcode+"");
        HttpAsyncTask task = makeTask(REQUEST_BEACON, HttpAsyncTask.METHOD_GET);
        task.execute(url);
    }


    @Override
    public void onResponse(int request, Response response) {
        switch (request){
            case REQUEST_BEACON:
                Log.e("URL", "onResponse BeaconSearchApi Beacon Request"+response);
                //processRecomendations(response);
                break;
        }
    }
}
