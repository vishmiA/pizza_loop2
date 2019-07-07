package lk.ac.kln.pizza_loop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class List_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter pAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<Pizza> pizza;

    RequestQueue queue;

    String request_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);

        request_url = "http://192.168.43.251:8080/demo/all";

        queue = Volley.newRequestQueue(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        pizza = new ArrayList<>();

        Request();
    }

    public void Request(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    Pizza pizzaRequest = new Pizza();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        pizzaRequest.setPizzaId(Integer.parseInt(jsonObject.get("pizzaId").toString()));
                        pizzaRequest.setName(jsonObject.get("name").toString());
                        pizzaRequest.setPrice(Float.parseFloat(jsonObject.get("price").toString()));
                        pizzaRequest.setImageUrl(jsonObject.get("imageUrl").toString());
                        pizzaRequest.setDetails(jsonObject.get("description").toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    pizza.add(pizzaRequest);

                }

                pAdapter = new ListAdapter(List_Activity.this, pizza);
                recyclerView.setAdapter(pAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsonArrayRequest);

    }

}
