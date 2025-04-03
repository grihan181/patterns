package org.example.adapter;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;

@Data
public class StringArrayAdapter {
    private OutputStream outputStream;

    public StringArrayAdapter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void writeStringsToOutputStream(String[] strings) {
        try {
            for (String str : strings) {
                outputStream.write(str.getBytes());
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStringFromOutputStream() {
        return outputStream.toString();
    }
}
