package com.example.bmi_indicator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText u_height, u_weight;
    TextView bmi;
    float h,w,res;
    Button btn_Calculate;
    CalculatorGetterAndSetter values = new CalculatorGetterAndSetter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        u_height = findViewById(R.id.user_height);
        u_weight = findViewById(R.id.user_weight);
        btn_Calculate = findViewById(R.id.btn_bmi);
        bmi = findViewById(R.id.bmi_result);

        btn_Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setUser_weight(u_weight.getText().toString());
                values.setUser_height(u_height.getText().toString());
                w=Float.parseFloat(u_weight.getText().toString());
                h=Float.parseFloat(u_height.getText().toString());
                h=h/100;
                res=w/(h*h);
                if(res<18.5)
                {
                    Toast.makeText(MainActivity.this, "You are underweight.", Toast.LENGTH_SHORT).show();
                }
                else if(res>=18.5 && res<=24.9)
                {
                    Toast.makeText(MainActivity.this, "Congratulations!! you got Normal weight.", Toast.LENGTH_SHORT).show();
                }
                else if(res==25 || res<=29.9)
                {
                    Toast.makeText(MainActivity.this, "You are overweight", Toast.LENGTH_SHORT).show();
                }
                else if(res>30)
                {
                    Toast.makeText(MainActivity.this, "Sorry but you got some serious obesity problem", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }





}
