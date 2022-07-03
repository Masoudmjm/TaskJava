package com.masoudjafari.taskjava.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.masoudjafari.taskjava.BaseActivity;
import com.masoudjafari.taskjava.databinding.FragmentSettingBinding;

public class SettingFragment extends Fragment {

    private FragmentSettingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SettingViewModel settingViewModel = new ViewModelProvider(this).get(SettingViewModel.class);

        binding = FragmentSettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        settingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        SharedPreferences settings = getActivity().getSharedPreferences("TaskJava", Context.MODE_PRIVATE);
        String fontSize = settings.getString("FONT_SIZE", "Medium");
        String fontType = settings.getString("FONT_TYPE", "First");
        switch (fontSize) {
            case "Large":
                binding.large.setChecked(true);
                break;
            case "Medium":
                binding.medium.setChecked(true);
                break;
            case "Small":
                binding.small.setChecked(true);
                break;
        }

        switch (fontType) {
            case "First":
                binding.firstFont.setChecked(true);
                break;
            case "Second":
                binding.secondFont.setChecked(true);
                break;
        }

        binding.large.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("TaskJava",Context.MODE_PRIVATE).edit();
                editor.putString("FONT_SIZE","Large");
                editor.apply();

            }
        });

        binding.medium.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("TaskJava",Context.MODE_PRIVATE).edit();
                editor.putString("FONT_SIZE","Medium");
                editor.apply();

            }
        });

        binding.small.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("TaskJava",Context.MODE_PRIVATE).edit();
                editor.putString("FONT_SIZE","Small");
                editor.apply();

            }
        });

        binding.firstFont.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("TaskJava",Context.MODE_PRIVATE).edit();
                editor.putString("FONT_TYPE","First");
                editor.apply();

            }
        });

        binding.secondFont.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("TaskJava",Context.MODE_PRIVATE).edit();
                editor.putString("FONT_TYPE","Second");
                editor.apply();

            }
        });

        binding.apply.setOnClickListener(view -> {
            restart();
        });

        return root;
    }

    private void restart() {
        Intent intent = getActivity().getIntent();
        getActivity().finish();
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}