package com.example.healthyfit;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class todoupdateRequest extends StringRequest {
    final static private String URL = "http://10.0.2.2/todoupdate.php";
    private Map<String, String> map;

    public todoupdateRequest(String userEmail, String content, String date, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userEmail", userEmail);
        map.put("content", content);
        map.put("date", date);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}
