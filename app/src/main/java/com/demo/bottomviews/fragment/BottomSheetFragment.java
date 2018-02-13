package com.demo.bottomviews.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.bottomviews.R;
import com.demo.bottomviews.databinding.FragmentBottomSheetDialogBinding;

/**
 * Created by Vinay on 2/12/2018.
 */

public class BottomSheetFragment extends BottomSheetDialogFragment {

    FragmentBottomSheetDialogBinding bottomSheetDialogBinding;

    public BottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bottomSheetDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.fragment_bottom_sheet_dialog, container, false);
        return bottomSheetDialogBinding.getRoot();
    }
}
