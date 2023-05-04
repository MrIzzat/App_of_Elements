package com.mrizzat.appofelements.models;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Dictionary;
import java.util.Hashtable;

public class ChemicalDA {

    Dictionary<String, Chemical> elements = new Hashtable<String,Chemical>();

    public ChemicalDA() {
    }

    public void readFile(Context c) throws IOException {
        InputStream fis = c.getAssets().open("Elements.txt");
        int size = fis.available();
        byte[] buf = new byte[size];
        fis.read(buf);
        fis.close();
        String file = new String(buf);

        String[] sepElm = file.split("\n");

        for(int i=0;i<sepElm.length;i++){
            String[] elmInfo = sepElm[i].split("\\|");
            elements.put(elmInfo[1],new Chemical(elmInfo[1],elmInfo[2],
                    Double.parseDouble(elmInfo[3]),
                    Integer.parseInt(elmInfo[0])));

            //Log.d("Elements",elmInfo[1]);
        }
    }

    public Chemical findElement(String symbol){

        return elements.get(symbol);

    }
}
