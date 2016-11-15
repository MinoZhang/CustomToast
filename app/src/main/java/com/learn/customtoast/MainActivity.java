package com.learn.customtoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button smile,cry,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        smile = (Button) findViewById(R.id.smile);
        cry = (Button) findViewById(R.id.cry);
        other = (Button) findViewById(R.id.other);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.smile:
                CustomToast.makeText(getApplicationContext(),R.drawable.color_face,"恭喜","你中了100万!!","某某某的某某,", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cry:

                break;
            case R.id.other:
                CustomToast.makeText(getApplicationContext(),R.drawable.fuli,"","","", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
