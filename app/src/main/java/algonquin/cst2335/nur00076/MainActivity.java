package algonquin.cst2335.nur00076;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import algonquin.cst2335.nur00076.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    private MutableLiveData<Boolean> selectAllTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        TextView mytext = variableBinding.textview;
        EditText myedit = variableBinding.myedittext;
        ImageView myimage = variableBinding.imageview;

        String editString = myedit.getText().toString();
        mytext.setText( "Your edit text has: " + editString);
        myimage.getDrawable();

        final Button btn = findViewById(R.id.mybutton);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });

        final ImageButton myimagebutton = findViewById(R.id.myimagebutton);
        myimagebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Code here executes on main thread after user presses button
            }
            public String measure(){
             return "The width = " + myimagebutton.getWidth() + " and height = " + myimagebutton.getHeight();
            }

        });



//        model.selectAllTypes.observe ( this, selected -> {
//            variableBinding.checkbox.setChecked(selected);
//            variableBinding.switchslide.setChecked(selected);
//            variableBinding.radiobutton.setChecked(selected);
//        });
//        public void setSelected (boolean selected {
//
//            variableBinding.checkbox.setChecked(selected);
//            variableBinding.switchslide.setChecked(selected);
//            variableBinding.radiobutton.setChecked(selected);
//            });

    }

}