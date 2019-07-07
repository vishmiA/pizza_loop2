package lk.ac.kln.pizza_loop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    Intent intent;

    int cartId;
    String pizzaName;
    String pizzaImageUrl;
    float pizzaPrice;
    int pizzaQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        intent = getIntent();

        ImageView imageView = findViewById(R.id.largeImage);
        TextView textViewDetails = findViewById(R.id.details);
        TextView textViewName  = findViewById(R.id.name);
        TextView textViewPrice  = findViewById(R.id.price);

        pizzaImageUrl = intent.getStringExtra("imageUrl");
        Picasso.get().load(pizzaImageUrl).fit().into(imageView);

        textViewDetails.setText(intent.getStringExtra("description"));

        pizzaName = intent.getStringExtra("name");
        textViewName.setText(pizzaName);

        pizzaPrice = Float.parseFloat(intent.getStringExtra("price"));
        textViewPrice.setText(Float.toString(pizzaPrice));

    }

    public void order(View view) {
        Intent intent = new Intent(DetailsActivity.this, Order_Activity.class);
        startActivity(intent);
    }
}
