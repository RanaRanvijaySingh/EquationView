# EquationView

A simple android library to show equations from math or chemistry using WebView and JavaScript in background.

## Screenshot

![screenshot_20171217-145209_01](https://user-images.githubusercontent.com/4836122/34078173-02b6e658-e33b-11e7-8467-e4b6f91b2846.jpg)

## Implementation

You can either 
1. Download the repository and add EquationView as a module in your own project. You need to add the following dependency in your gradle file. 
    
       dependencies {
           ...
           compile project(path: ':equationview')
       }
       
2. Add the .AAR file (from **EquationView/library/equationview.aar** or generate your own) in your **libs** directory of your project and make the following changes in your gradle file.
  
       dependencies {
           ...
           compile 'com.rana.equationview:equationview@aar'
       }
       repositories{
           flatDir{
               dirs 'libs'
           }
       }

You need to add internet permission in your manifest file.

     <uses-permission android:name="android.permission.INTERNET"/>

Your activity file will look like this.

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
The layout file will look like this.

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="16dp"
    android:orientation="vertical"
    tools:context="com.example.MainActivity">

    <com.rana.equationview.EquationView
        android:id="@+id/equationViewMath"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <com.rana.equationview.EquationView
        android:id="@+id/equationViewChem"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp" />

    </LinearLayout>
   
