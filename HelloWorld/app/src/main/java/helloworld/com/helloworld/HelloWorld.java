package helloworld.com.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HelloWorld extends ActionBarActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helloworld_world);
        textView = (TextView)findViewById(R.id.change_this_text);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
