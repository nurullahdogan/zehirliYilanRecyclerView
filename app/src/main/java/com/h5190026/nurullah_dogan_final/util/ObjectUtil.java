package com.h5190026.nurullah_dogan_final.util;

import com.google.gson.Gson;
import com.h5190026.nurullah_dogan_final.model.YilanBilgiModel;

public class ObjectUtil {

    public  static String yilanToJsonString(YilanBilgiModel yilanBilgiModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(yilanBilgiModel);
    }

    public  static YilanBilgiModel jsonStringToYilan(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,YilanBilgiModel.class);
    }
}
