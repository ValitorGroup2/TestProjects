package helloworld.com.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Calculator extends Activity {

    private EditText Src;
    private float NumberBf;  //save screen before button press operation
    private String Operation;
    //private ButtonClickListener btnClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        Src = (EditText)findViewById(R.id.editCalc);

    }

    public void btnClicked(View v)
    {
        String numb;
        switch(v.getId())
        {
            case R.id.buttonClear:
                Src.setText("0");
                NumberBf = 0;
                Operation ="";
                break;
            case R.id.buttonPlus:
                mMath("+");
                break;
            case R.id.buttonMinus:
                mMath("-");
                break;
            case R.id.buttonDivide:
                mMath("/");
                break;
            case R.id.buttonMultiply:
                mMath("*");
                break;
            case R.id.buttonBackspace:
                numb = Src.getText().toString();
                if (numb.length() < 2) {
                    Src.setText("0");
                }
                else
                {
                    numb = numb.substring(0, numb.length()-1);
                    Src.setText(numb);
                }
                break;
            case R.id.buttonDot:
                numb = Src.getText().toString();
                if (numb.indexOf('.') < 0) {
                    getKeyboard("."); //only one dot allowed
                }

                break;
            case R.id.buttonSign:
                numb = Src.getText().toString();
                if (numb.length() < 1) {
                    Src.setText("0");
                }
                else
                {
                    if(numb.charAt(0) == '-')
                        numb = numb.substring(1, numb.length());
                    else
                        numb = "-" + numb;
                    Src.setText(numb);
                }
                break;
            case R.id.buttonEqual:
                mResult();
                break;
            default:
                numb = ((Button) v).getText().toString();
                getKeyboard(numb);
                break;
        }
    }

    public void mMath(String str){
        NumberBf = Float.parseFloat(Src.getText().toString());
        Operation = str;
        Src.setText("0");
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }

    public void getKeyboard(String str){
        String SrcCurrent = Src.getText().toString();
        if (SrcCurrent.equals("0"))
            SrcCurrent="";
        SrcCurrent += str;
        Src.setText(SrcCurrent);
    }

    public void mResult(){
        float NumAf = Float.parseFloat(Src.getText().toString());
        float result = 0;
        String str = String.valueOf(NumberBf) + " " + Operation + " " + String.valueOf(NumAf);
        if (Operation.equals("+"))
        {
            result = NumAf + NumberBf;
        }
        else if (Operation.equals("-"))
        {
            result =  NumberBf - NumAf;

        }
        else if (Operation.equals("/"))
        {
            if (NumAf == 0) //no null division
                result = 0;
            else
                result = NumberBf / NumAf;

        }
        else if (Operation.equals("*"))
        {
            result = NumAf * NumberBf;
        }

        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
        Src.setText(String.valueOf(result));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
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
