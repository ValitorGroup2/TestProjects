package helloworld.com.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Notandi on 30.4.2015.
 */
public class ThirdPage extends Activity{
    public final static String USERNAME_KEY = "helloworld.com.helloworld.USERNAME";
    public final static String PASSWORD_KEY = "helloworld.com.helloworld.PASSWORD";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_page);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(USERNAME_KEY);
        String password = intent.getStringExtra(PASSWORD_KEY);
        ((TextView)findViewById(R.id.tvUsername)).setText(userName);
        ((TextView)findViewById(R.id.tvPassword)).setText(password);


    }
}
