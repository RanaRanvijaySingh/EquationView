package com.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rana.equationview.EquationView;

public final class MainActivity extends AppCompatActivity {

    private String strMath = "Math: " +
            "\\(\\begin{align}x^2+3x^2-4x-24=0\\end{align}\\)";
    private String strChem = "Chemistry: " +
            "\\(\\ce{CO2 + C -> 2 CO}\\)";
    private EquationView mEquationViewMath;
    private EquationView mEquationViewChem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        mEquationViewMath = findViewById(R.id.equationViewMath);
        mEquationViewChem = findViewById(R.id.equationViewChem);
        mEquationViewMath.setText(strMath);
        mEquationViewChem.setText(strChem);
    }
}
