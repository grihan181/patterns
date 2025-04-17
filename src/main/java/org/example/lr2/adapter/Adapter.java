package org.example.lr2.adapter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class Adapter {

    public static void main(String[] args) {
        String[] strings = {"Hello, ", "my ", "name ", "is ", "Kirill"};
        OutputStream adaptedStream = new ByteArrayOutputStream();
        StringArrayAdapter adapter = new StringArrayAdapter(adaptedStream);

        adapter.writeStringsToOutputStream(strings);

        System.out.println(adapter.getStringFromOutputStream());
        System.out.println(Arrays.toString(((ByteArrayOutputStream) adapter.getOutputStream()).toByteArray()));
    }
}
