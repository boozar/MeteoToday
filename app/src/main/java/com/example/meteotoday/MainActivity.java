package com.example.meteotoday;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.nodes.Element;


public class MainActivity extends AppCompatActivity {
    public static boolean state;
    static TextView textView;
    static TextView textView1;
    static TextView textView2;
    static TextView textView3;
    static HTMLconecter page;
    Button loadButton;
    static void showMeteo(){
        if(page.page != null){
            textView.setTextSize(16);
            textView.setTextColor(Color.BLACK);
            textView.setMovementMethod(new ScrollingMovementMethod());
            textView1.setTextSize(16);
            textView1.setTextColor(Color.BLACK);
            textView1.setMovementMethod(new ScrollingMovementMethod());
            textView2.setTextSize(16);
            textView2.setTextColor(Color.BLACK);
            textView2.setMovementMethod(new ScrollingMovementMethod());
            textView3.setTextSize(16);
            textView3.setTextColor(Color.BLACK);
            textView3.setMovementMethod(new ScrollingMovementMethod());

            Element toDay = page.page.getElementById("tbwdaily1");

            textView.setText(page.page.title() + "\n\n"+ toDay.child(0).child(0).text() + "  " + toDay.child(0).child(2).text() + "  " + toDay.child(0).child(3).child(0).text() );
            textView1.setText(toDay.child(1).child(0).text() + "  " + toDay.child(1).child(2).text() + "  " + toDay.child(1).child(3).child(0).text() );
            textView2.setText(toDay.child(2).child(0).text() + "  " + toDay.child(2).child(2).text() + "  " + toDay.child(2).child(3).child(0).text() );
            textView3.setText(toDay.child(3).child(0).text() + "  " + toDay.child(3).child(2).text() + "  " + toDay.child(3).child(3).child(0).text() );




        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadButton = findViewById(R.id.btnStart);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        state = false;
    }
    public void parsePostClick(View view) {
        page = new HTMLconecter();
        Toast.makeText(getApplicationContext(),"Data load started", Toast.LENGTH_LONG).show();
        page.execute();
    }
}
