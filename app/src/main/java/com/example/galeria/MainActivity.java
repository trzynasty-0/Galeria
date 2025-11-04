package com.example.galeria;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button prev, next;
    private ImageView zdjecie;
    private EditText podanyNumer;
    private Switch czyNiebieskie;
    private int numerZdjecia = 0;
    private ArrayList<Integer> repozytorium = new ArrayList<>();
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

        prev = findViewById(R.id.prevButton);
        next = findViewById(R.id.nextButton);
        zdjecie = findViewById(R.id.zdjecieView);
        podanyNumer = findViewById(R.id.numerEdit);
        czyNiebieskie = findViewById(R.id.zmienicKolorSwitch);


        repozytorium.add(R.drawable.knight);
        repozytorium.add(R.drawable.hornet);
        repozytorium.add(R.drawable.together);

        prev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(numerZdjecia != 0){
                            numerZdjecia--;
                        }
                        else{
                            numerZdjecia = repozytorium.size() - 1;
                        }
                        zdjecie.setImageResource(repozytorium.get(numerZdjecia));
                    }
                }
        );
        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(numerZdjecia != repozytorium.size() - 1){
                            numerZdjecia++;
                        }
                        else{
                            numerZdjecia = 0;
                        }
                        zdjecie.setImageResource(repozytorium.get(numerZdjecia));
                    }
                }
        );
        podanyNumer.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void afterTextChanged(Editable editable) {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        if(!String.valueOf(podanyNumer.getText()).equals("")){
                            for(int j = 0; j < repozytorium.size(); j++){
                                if(Integer.parseInt(String.valueOf(podanyNumer.getText())) == j){
                                    zdjecie.setImageResource(repozytorium.get(j));
                                }

                            }
                        }
                    }
                }
        );


    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("");
//    }
}