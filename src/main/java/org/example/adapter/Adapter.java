package org.example.adapter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class Adapter {

    public static void main(String[] args) {
        String[] strings = {"I ", "am", " wolf"};
        OutputStream adaptedStream = new ByteArrayOutputStream();
        StringArrayAdapter adapter = new StringArrayAdapter(adaptedStream);
        adapter.writeStringsToOutputStream(strings);

        System.out.println(adapter.getStringFromOutputStream());
    }
}
