package com.example.mypc.reactivex;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by MyPC on 30/06/2017.
 */

public interface Resquest {
    @GET("android/jsonarray/")
    Observable<List<Data>> register();


}
