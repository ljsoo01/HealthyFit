package com.example.healthyfit;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainUpdateRequest extends StringRequest {
    //서버 연결 10.0.2.2
    final static private String URL = "http://10.0.2.2/member_update.php";
    //final static private String URL = "http://10.0.2.2/member_update.php";
    private Map<String, String> map;

    //입력 받는거
    public MainUpdateRequest(String userMemo, String userDate, String userEmail, String userHeight, String userWeight, String userETC, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userMemo", userMemo);
        map.put("userDate", userDate);
        map.put("userEmail", userEmail);
        map.put("userHeight", userHeight);
        map.put("userWeight", userWeight);
        map.put("userETC", userETC);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}