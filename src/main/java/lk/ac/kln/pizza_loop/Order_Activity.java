package lk.ac.kln.pizza_loop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Order_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_);
    }

    public void submit(View view) {
        Toast.makeText(this,"Orderd Complete", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(Order_Activity.this, List_Activity.class);
        startActivity(intent);
    }
}
