package com.example.formpizza;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rozmiar;
    private CheckBox mielonka, salame, pieczarki, kukurydza, winogron, doritos, brokul, ananas, kurczak;
    private SeekBar ilosc;
    private EditText adres;
    private Spinner dostawa;
    private Button zamow, reset;
    private TextView podsumowanie;
    private List<String> skladniki = new ArrayList<>();


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

        podsumowanie = findViewById(R.id.podsumowanie);

        zamow.setOnClickListener(v -> {if(validateForm()){askForZamuf();}});
        ilosc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView)findViewById(R.id.suwak)).setText(String.valueOf(ilosc.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private boolean validateForm(){
        if(adres.getText().toString().trim().isEmpty()){
            adres.setError("Uzupelnij!");
            adres.requestFocus();
            return false;
        }
        if(dostawa.getSelectedItemPosition() == 0){
            Toast.makeText(this, "Wybierz rodzaj dostawy!", Toast.LENGTH_LONG).show();
            dostawa.requestFocus();
            return false;
        }
        if(ilosc.getProgress() == 0){
            Toast.makeText(this, "Nie mozesz zamowic 0 pic!", Toast.LENGTH_LONG).show();
            ilosc.requestFocus();
            return false;
        }
        return true;
    };

    private void askForZamuf(){
        new AlertDialog.Builder(this).setTitle("Czy zamufic?").setMessage("Czy chcesz zamufic pizza?").setPositiveButton("Tak", ((dialog, which) -> zamuf())).setNegativeButton("Nie", null).show();
    };

    private void zamuf(){
        skladniki.add("Sos");
        skladniki.add("Ser");
        if(mielonka.isChecked()){
            skladniki.add(mielonka.getText().toString());
        }
        if(salame.isChecked()){
            skladniki.add(salame.getText().toString());
        }
        if(pieczarki.isChecked()){
            skladniki.add(pieczarki.getText().toString());
        }
        if(kukurydza.isChecked()){
            skladniki.add(kukurydza.getText().toString());
        }
        if(winogron.isChecked()){
            skladniki.add(winogron.getText().toString());
        }
        if(doritos.isChecked()){
            skladniki.add(doritos.getText().toString());
        }
        if(brokul.isChecked()){
            skladniki.add(brokul.getText().toString());
        }
        if(ananas.isChecked()){
            skladniki.add(ananas.getText().toString());
        }
        if(kurczak.isChecked()){
            skladniki.add(kurczak.getText().toString());
        }

        podsumowanie.setText("Zamowiles " + ilosc.getProgress() + " pizz, o rozmiarze " + ((RadioButton)findViewById(rozmiar.getCheckedRadioButtonId())).getText() + " , z rodzajem dostawy: " + dostawa.getSelectedItem() + " , o skladnikach: " + skladniki.toString());
    }
}

