package parsedemo.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static int REQ_CODE_SUCESS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtStart = (TextView)findViewById(R.id.txtStart);

        txtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,BannerWebView.class),REQ_CODE_SUCESS);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == REQ_CODE_SUCESS){
            if (resultCode == RESULT_OK){
                Toast.makeText(MainActivity.this, "Transaction completed Sucesfully", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, "Transaction Failed", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
