package com.example.francisco.mallsbeaconslocation.util;

import com.example.francisco.mallsbeaconslocation.models.UserName;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by jhovy on 28/11/2017.
 */

public interface UserClient {

    @POST("users/feedback")
    Call<SimpleResponse> response (@Body UserName userName);
}
