package com.example.tamago;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.tamago.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getStamina().observe(this, count -> {

            switch (count) {
                case 80:
                    binding.eggIv.setImageResource(R.drawable.egg2);
                    break;

                case 50:
                    binding.eggIv.setImageResource(R.drawable.egg3);
                    break;


                case 10: {
                    binding.eggIv.setImageResource(R.drawable.egg4);
                    break;
                }

                case 0: {
                    binding.eggIv.setImageResource(R.drawable.aa);
                    break;
                }

            }
        });
    }

    public void resetStamina(View view) {
        viewModel.resetStamina();
        binding.eggIv.setImageResource(R.drawable.egg);
    }
}