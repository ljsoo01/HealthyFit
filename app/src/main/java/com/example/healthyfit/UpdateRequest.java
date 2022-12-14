package com.example.healthyfit;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UpdateRequest extends StringRequest {
    final static private String URL = "http://10.0.2.2/update.php";
    private Map<String, String> map;

    public UpdateRequest(String userEmail, String userPw, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userEmail", userEmail);
        map.put("userPw", userPw);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
