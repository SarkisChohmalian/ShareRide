package com.example.shareride;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingsFragment extends Fragment {

    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        mAuth = FirebaseAuth.getInstance();

        TextView changePasswordTextView = view.findViewById(R.id.changePassword);
        TextView changeEmailTextView = view.findViewById(R.id.changeEmail);
        TextView changePhoneNumberTextView = view.findViewById(R.id.changePhoneNumber);
        TextView deleteAccountTextView = view.findViewById(R.id.deleteAccount);

        changePasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPasswordResetActivity();
            }
        });

        // Start ChangeEmailActivity when "Change Email" is clicked
        changeEmailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ChangeEmailActivity.class));
            }
        });

        changePhoneNumberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do nothing
            }
        });

        deleteAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDeleteAccountActivity();
            }
        });

        return view;
    }

    private void goToPasswordResetActivity() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            startActivity(new Intent(getActivity(), PasswordResetActivity.class));
        }
    }

    private void goToDeleteAccountActivity() {
        startActivity(new Intent(getActivity(), DeleteAccount.class));
    }
}

