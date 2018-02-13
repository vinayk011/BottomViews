package com.demo.bottomviews;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.demo.bottomviews.databinding.ActivityMainBinding;
import com.demo.bottomviews.fragment.BottomSheetFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private BottomSheetBehavior sheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        sheetBehavior = BottomSheetBehavior.from(mainBinding.layoutBottom.bottomSheet);
        sheetBehavior.setBottomSheetCallback(bottomSheetCallback);
        mainBinding.contentMain.btnBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleBottomSheet();
            }
        });
        mainBinding.contentMain.btnBottomSheetDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialog();
            }
        });
        mainBinding.contentMain.btnBottomSheetDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogFragment();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * bottom sheet state change listener
     * we are changing button text when sheet changed state
     * */
        private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            switch (newState) {
                case BottomSheetBehavior.STATE_HIDDEN:
                    break;
                case BottomSheetBehavior.STATE_EXPANDED: {
                    mainBinding.contentMain.btnBottomSheet.setText("Close Sheet");
                }
                break;
                case BottomSheetBehavior.STATE_COLLAPSED: {
                    mainBinding.contentMain.btnBottomSheet.setText("Expand Sheet");
                }
                break;
                case BottomSheetBehavior.STATE_DRAGGING:
                    break;
                case BottomSheetBehavior.STATE_SETTLING:
                    break;
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {

        }
    };

    /**
     * manually opening / closing bottom sheet on button click
     */
    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            mainBinding.contentMain.btnBottomSheet.setText("Close sheet");
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            mainBinding.contentMain.btnBottomSheet.setText("Expand sheet");
        }
    }

    /**
     * showing bottom sheet dialog
     */

    public void showBottomSheetDialog() {
        View view = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet_dialog, null);
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        dialog.show();
    }


    /**
     * showing bottom sheet dialog fragment
     * same layout is used in both dialog and dialog fragment
     */
    public void showBottomSheetDialogFragment() {
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }
}
