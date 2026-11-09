package com.example.formpizza;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rozmiar;
    private CheckBox mielonka, salame, pieczarki, kukurydza, winogron, doritos, brokul, ananas, kurczak;
    private SeekBar ilosc;
    private EditText adres;
    private Spinner dostawa;
    private Button zamow, reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rozmiar = findViewById(R.id.radioGroup);

        mielonka = findViewById(R.id.mielonka);
        salame = findViewById(R.id.salame);
        pieczarki = findViewById(R.id.pieczarki);
        kukurydza = findViewById(R.id.kukurydza);
        winogron = findViewById(R.id.winogron);
        doritos = findViewById(R.id.doritos);
        brokul = findViewById(R.id.brokul);
        ananas = findViewById(R.id.ananas);
        kurczak = findViewById(R.id.kurczak);

        ilosc = findViewById(R.id.seekBar);
        adres = findViewById(R.id.editText);
        dostawa = findViewById(R.id.spinner);
        zamow = findViewById(R.id.zamuf);
        reset = findViewById(R.id.reset);

        zamow.setOnClickListener(v -> {if(validateForm()){askForZamuf();}});
    }
    private boolean validateForm(){

        return true;
    };

    private void askForZamuf(){
        new AlertDialog.Builder(this).setTitle("Czy zamufic?").setMessage("Czy chcesz zamufic pizza?").setPositiveButton("Tak", ((dialog, which) -> zamuf())).setNegativeButton("Nie", null).show();
    };

    private void zamuf(){

    }
}

