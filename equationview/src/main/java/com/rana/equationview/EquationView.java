package com.rana.equationview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import java.io.IOException;
import java.io.InputStream;

public class EquationView extends WebView {

    private static final String BLANK = "";
    private static final String TEMPLATE_FILE = "template.html";
    private static final String MIME_TYPE = "text/html";
    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_TO_BE_REPLACED = "rana";

    public EquationView(Context context) {
        super(context);
        init();
    }

    public EquationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EquationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        getSettings().setJavaScriptEnabled(true);
    }

    /**
     * Function to set text in WebView
     *
     * @param text String
     */
    public void setText(String text) {
        String fileContent = "";
        text = text.replace("\\","\\\\");
        try {
            InputStream inputStream = getContext().getAssets().open(TEMPLATE_FILE);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            fileContent = new String(buffer);
            fileContent = fileContent.replaceFirst(CONTENT_TO_BE_REPLACED, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadDataWithBaseURL(BLANK, fileContent, MIME_TYPE, ENCODING, BLANK);
    }
}
