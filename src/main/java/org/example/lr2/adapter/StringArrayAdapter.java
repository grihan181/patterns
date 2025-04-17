package org.example.lr2.adapter;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;

@Data
public class StringArrayAdapter {

    private OutputStream outputStream;

    public StringArrayAdapter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public String getStringFromOutputStream() {
        return outputStream.toString();
    }

    public void writeStringsToOutputStream(String[] arr) {
        try {
            for (String str : arr) {
                outputStream.write(str.getBytes());
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
