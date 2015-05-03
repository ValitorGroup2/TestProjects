package helloworld.com.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HelloWorld extends ActionBarActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helloworld_world);
        textView = (TextView)findViewById(R.id.change_this_text);

        float val = getSavedChargeCalue();

        Toast.makeText(getApplicationContext(), "Saved value:" + Float.toString(val), Toast.LENGTH_LONG).show();


    }
    public float getSavedChargeCalue(){
        float ret;

        SharedPreferences sPrefs = HelloWorld.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);
        ret = sPrefs.getFloat(getString(R.string.PREF_CHARGE_VALUE),0);
        return  ret;
    }
    public void changeTheText(View view)
    {
        String message = "This text is now changed!";
        if (textView.getText() == message)
        {
            message = "Ok, changing again";

        }
        textView.setText(message);
    }

    public void openPage(View view){

        Intent intent;
        int id = view.getId();
        switch(id){
            case R.id.btnOpenSecondPage:
                intent = new Intent(this, SecondPage.class);
                startActivity(intent);

                break;
            case R.id.btnOpenThirdPage:
                intent = new Intent(this, ThirdPage.class);
                startActivity(intent);
            break;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_world, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent;

        switch(id)
        {
            case R.id.action_settings:
                intent = new Intent(this, SettingsPage.class);
                startActivity(intent);
                return true;
            case R.id.action_calculator:
                intent = new Intent(this, Calculator.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
