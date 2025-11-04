package com.example.galeria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
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

        ArrayList<Integer> repozytorium = new ArrayList<>();
        repozytorium.add(R.drawable.knight);
        repozytorium.add(R.drawable.hornet);
        repozytorium.add(R.drawable.together);



    }
}