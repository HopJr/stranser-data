package com.example.stranser_data;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class TestFragment extends Fragment {
    private static String OUT = "out";

    private TextView tvName;
    private TextView tvAdd;
    private Button btSub;
    private TestClistener clistener;
    private SinhVien sinhVien;

    public static TestFragment newInstance(SinhVien out) {
        Bundle args = new Bundle();
        args.putSerializable(OUT, out);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName = getActivity().findViewById(R.id.tvName);
        tvAdd = getActivity().findViewById(R.id.tvAdd);
        btSub = getActivity().findViewById(R.id.btSend);

        sinhVien = (SinhVien) getArguments().getSerializable(OUT);
        tvName.setText(sinhVien.getName());
        tvAdd.setText(sinhVien.getAdd());

        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clistener.onSendClick(sinhVien);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof TestClistener) {
            clistener = (TestClistener) context;
        }
    }
}
