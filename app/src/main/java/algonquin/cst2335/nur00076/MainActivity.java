package algonquin.cst2335.nur00076;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/** This is the Main that has all the code for the password validation app
 * @author Guled Nur
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /** This holds the text at the centre of the screen */
    private TextView tv = null;

    /** This holds the password for input and validation */
    private EditText et =null;

    /** This holds the button to run the validation function */
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();

            checkPasswordComplexity(password);
        });
    }

    /**
     * This function checks the strength of the
     * password variable by seeing if it
     * has an Upper Case letter, a lower case letter,
     * a number, and a special symbol.
     *
     * @param password is a String object that we are checking.
     */
    public void checkPasswordComplexity(String password) {

        char ch;
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if( Character.isDigit(ch)) {
                foundNumber = true;
            }
            else if (Character.isUpperCase(ch)) {
                foundUpperCase = true;
            }
            else if (Character.isLowerCase(ch)) {
                foundLowerCase = true;
            }
            else if (isSpecialCharacter(ch)) {
                foundSpecial = true;
            }
            if(foundNumber && foundUpperCase && foundLowerCase && foundSpecial){
                Toast.makeText(MainActivity.this,"Strong Password",Toast.LENGTH_SHORT).show();
                tv.setText("Your password meets the requirements");
                return;
            }
        }
        if(!foundUpperCase)
        {
            Toast.makeText(MainActivity.this,"Missing an Upper case letter",Toast.LENGTH_SHORT).show();
            tv.setText("You shall not pass!");
        }
        else if(!foundLowerCase)
        {
            Toast.makeText(MainActivity.this,"Missing a Lower case letter",Toast.LENGTH_SHORT).show();
            tv.setText("You shall not pass!");
        }
        else if(!foundNumber)
        {
            Toast.makeText(MainActivity.this,"Missing a Number",Toast.LENGTH_SHORT).show();
            tv.setText("You shall not pass!");
        }
        else {
            Toast.makeText(MainActivity.this,"Missing a Symbol",Toast.LENGTH_SHORT).show();
            tv.setText("You shall not pass!");
        }
    }

    /** This Function has the symbols that will be used
     * to check how strong the password variable is.
     *
     * @param c has the symbols we'll use.
     * @return true if there is a symbol in the password
     * and false if there isn't.
     */
    boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }
}
