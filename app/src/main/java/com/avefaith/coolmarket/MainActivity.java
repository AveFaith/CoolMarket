package com.avefaith.coolmarket;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.avefaith.coolmarket.databinding.ElementsBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ElementsBinding binding = ElementsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.RB1.setChecked(true);
        binding.TV2.setText("Выбранный способ доставки:\nкурьером");

        binding.ET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("MAINACTIVITY" + "BEFORE", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("MAINACTIVITY" + "ON", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("MAINACTIVITY" + "AFTER", s.toString());
            }
        });

        binding.CB1.isChecked();

        binding.RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.RB1){
                    binding.TV2.setText("Выбранный способ доставки:\nкурьером");
                }
                if(checkedId == R.id.RB2){
                    binding.TV2.setText("Выбранный способ доставки:\nсамовывоз");
                }
                if(checkedId == R.id.RB3){
                    binding.TV2.setText("Выбранный способ доставки:\nдроном");
                }
            }
        });


        binding.BUT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Спасибо, что выбрали нас!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.BUT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.CB1.setChecked(false);
                binding.CB2.setChecked(false);
                binding.CB3.setChecked(false);
                binding.CB4.setChecked(false);
                binding.CB5.setChecked(false);
                binding.CB6.setChecked(false);
                binding.RB1.setChecked(true);
                binding.RB2.setChecked(false);
                binding.RB3.setChecked(false);
                binding.ET.setText("");
                binding.TV2.setText("Выбранный способ доставки:\nкурьером");
                Toast.makeText(MainActivity.this, "Выбор очищен", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Я не умею сохранять!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}