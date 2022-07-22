package com.masoudjafari.taskjava.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.masoudjafari.taskjava.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initiateView();
        setListeners();

        return root;
    }

    private void initiateView() {
        dashboardViewModel = new DashboardViewModel(getContext());
        binding.btnUsers.setOnClickListener(view -> dashboardViewModel.getUsersOnClick());
    }

    private void setListeners() {
        dashboardViewModel.getLoading().observe(getViewLifecycleOwner(), aBoolean ->
                binding.progressBar.setVisibility(aBoolean ? View.VISIBLE : View.GONE));

        dashboardViewModel.getSearchResponse().observe(getViewLifecycleOwner(), searchResponse ->
                Toast.makeText(getContext(), searchResponse.toString(), Toast.LENGTH_SHORT).show());

        dashboardViewModel.getErrorMessage().observe(getViewLifecycleOwner(), message ->
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show());

        dashboardViewModel.getUsersList().observe(getViewLifecycleOwner(), users ->
                Toast.makeText(getContext(), users.size() + "", Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}