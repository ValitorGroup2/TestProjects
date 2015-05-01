package helloworld.com.helloworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;


/**
 * Created by Gudjon on 30.4.2015.
 */
public class SecondPage extends Activity {

    public final static String USERNAME_KEY = "helloworld.com.helloworld.USERNAME";
    public final static String PASSWORD_KEY = "helloworld.com.helloworld.PASSWORD";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page );
    }

    public void login(View view)
    {
        String userName = ((EditText)findViewById(R.id.editName)).getText().toString();
        String password = ((EditText)findViewById(R.id.editPassword)).getText().toString();
        Intent intent = new Intent(this, ThirdPage.class);
        intent.putExtra(USERNAME_KEY ,userName);
        intent.putExtra(PASSWORD_KEY ,password);
        startActivity(intent);
    }

    public void alert(View view)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirm");
        builder.setMessage("This is a check to see if you are able to follow a simple instruction\n\n please press the 'yes' button?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                Toast.makeText(getApplicationContext(), "You genius, you managed to press Yes! ", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You are a lost cause, you pressed No! ", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
        Toast.makeText(getApplicationContext(), "This text will show before an \n the user presses a button.", Toast.LENGTH_LONG).show();
    }

}
