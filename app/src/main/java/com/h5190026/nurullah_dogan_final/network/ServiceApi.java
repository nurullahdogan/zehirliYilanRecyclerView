package com.h5190026.nurullah_dogan_final.network;


import com.h5190026.nurullah_dogan_final.model.YilanBilgiModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("yilanbilgiJson.json")
    Observable<List<YilanBilgiModel>> yilanlariGetir();
}
