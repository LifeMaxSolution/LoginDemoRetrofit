package com.demo.facemeai.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.demo.facemeai.R;
import com.demo.facemeai.databinding.ActivityMainBinding;
import com.demo.facemeai.fragment.AIAvtarFragment;
import com.demo.facemeai.fragment.FaceMeFragment;
import com.demo.facemeai.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        loadFragment(new HomeFragment());
        binding.tabHome.setBackgroundResource(R.drawable.tab_home_selected);
        binding.tabFaceMe.setBackgroundResource(R.drawable.tab_faceme_unselected);
        binding.tabAiAvtar.setBackgroundResource(R.drawable.tab_ai_avatar_unselected);
        binding.txtHome.setTextColor(getResources().getColor(R.color.yellow));
        binding.txtFaceMe.setTextColor(getResources().getColor(R.color.grey));
        binding.txtAiAvtar.setTextColor(getResources().getColor(R.color.grey));


        binding.llHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new HomeFragment());
                binding.tabHome.setBackgroundResource(R.drawable.tab_home_selected);
                binding.tabFaceMe.setBackgroundResource(R.drawable.tab_faceme_unselected);
                binding.tabAiAvtar.setBackgroundResource(R.drawable.tab_ai_avatar_unselected);
                binding.txtHome.setTextColor(getResources().getColor(R.color.yellow));
                binding.txtFaceMe.setTextColor(getResources().getColor(R.color.grey));
                binding.txtAiAvtar.setTextColor(getResources().getColor(R.color.grey));

            }
        });
        binding.llFaceMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FaceMeFragment());
                binding.tabHome.setBackgroundResource(R.drawable.tab_home_unselected);
                binding.tabFaceMe.setBackgroundResource(R.drawable.tab_faceme_selected);
                binding.tabAiAvtar.setBackgroundResource(R.drawable.tab_ai_avatar_unselected);
                binding.txtHome.setTextColor(getResources().getColor(R.color.grey));
                binding.txtFaceMe.setTextColor(getResources().getColor(R.color.yellow));
                binding.txtAiAvtar.setTextColor(getResources().getColor(R.color.grey));

            }
        });
        binding.llAiavtar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AIAvtarFragment());
                binding.tabHome.setBackgroundResource(R.drawable.tab_home_unselected);
                binding.tabFaceMe.setBackgroundResource(R.drawable.tab_faceme_unselected);
                binding.tabAiAvtar.setBackgroundResource(R.drawable.tab_ai_avatar_selected);
                binding.txtHome.setTextColor(getResources().getColor(R.color.grey));
                binding.txtFaceMe.setTextColor(getResources().getColor(R.color.grey));
                binding.txtAiAvtar.setTextColor(getResources().getColor(R.color.yellow));

            }
        });


    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}