package com.mrizzat.appofelements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.mrizzat.appofelements.models.Chemical;
import com.mrizzat.appofelements.models.ChemicalDA;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {




    TextView txtElement;
    TextView txtElementInfo;
    ChemicalDA chemDA = new ChemicalDA();
    LinearLayout elementInfo;
    MaterialButton[] elements=new MaterialButton[114];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        elementInfo = findViewById(R.id.elementInfo);
        txtElement = findViewById(R.id.txtElement);
        txtElementInfo = findViewById(R.id.txtElementInfo);
        Class id=R.id.class;
        Field field = null;



        for(int k = 0; k<elements.length; k++) {

            try {
                String temp = "i"+(k+1);
                field = id.getField(temp);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            try {
                elements[k] = findViewById(field.getInt(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<elements.length;i++){
            final int index = i;
          elements[i].setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String elementalInfo = elements[index].getText().toString();
                  Chemical chem = chemDA.findElement(elementalInfo);
                  if(chem==null){
                      Toast.makeText(MainActivity.this,
                              "This Symbol Does Not Represent Any Elements",
                              Toast.LENGTH_SHORT).show();
                      elementInfo.setVisibility(View.GONE);
                  }else{
                      elementInfo.setVisibility(View.VISIBLE);

                      txtElement.setText((chem.getName()));

                      String cheminfo ="Symbol: "+chem.getSymbol()+"\n"
                              +"Atomic Number: "+chem.getAtomicNumber() +"\n"
                              +"Atomic Weight: "+chem.getAtomicWeight();
                      txtElementInfo.setText(cheminfo);
                  }
              }
          });
        }

    }


    public void readFile() throws IOException {
        chemDA.readFile(this);

    }
}