package com.example.healthyfit;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class selectRequest extends StringRequest {
    final static private String URL = "http://10.0.2.2/select.php";
    private Map<String, String> map;

    public selectRequest(String userEmail, String content, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userEmail", userEmail);
        map.put("content", content);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}
