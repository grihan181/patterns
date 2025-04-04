package org.example.adapter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class Adapter {

    public static void main(String[] args) {
        String[] strings = {"Hello, ", "my ", "name ", "is ", "Kirill"};
        OutputStream adaptedStream = new ByteArrayOutputStream();
        StringArrayAdapter adapter = new StringArrayAdapter(adaptedStream);

        adapter.writeStringsToOutputStream(strings);

        System.out.println(adapter.getStringFromOutputStream());
        //System.out.println(adapter.getOutputStream());
    }
}
