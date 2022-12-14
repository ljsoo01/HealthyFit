package com.example.healthyfit;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignupRequest extends StringRequest {
    final static private String URL = "http://10.0.2.2/signup.php";
    private Map<String, String> map;

    public SignupRequest(String userEmail, String userName, String userPw, String userGender, String userBirth, String userHeight, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userEmail",userEmail);
        map.put("userName",userName);
        map.put("userPw",userPw);
        map.put("userGender",userGender);
        map.put("userBirth",userBirth);
        map.put("userHeight",userHeight);
}

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}