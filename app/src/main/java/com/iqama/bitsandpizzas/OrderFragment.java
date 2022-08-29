package com.iqama.bitsandpizzas;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class OrderFragment extends Fragment {
    Toolbar toolbar;
    ImageView imageView;
    CheckBox checkBox;
    RadioButton radioButton, neapolitan, Sicilian_Pizza;
    ToggleButton toggleButton;
    SwitchCompat Switch;
    ChipGroup chipGroup, chipGroupFinal;
    EditText textField;
    Button addButton;
    AppBarLayout appBarLayout;
    RadioGroup radioGroup;
    FloatingActionButton actionButton2;

    String text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        toolbar = view.findViewById(R.id.toolbar);

        /*
           Getting Reference to Parent Activity . So that we can call method "setSupportActionBar()"
         */
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        imageView = view.findViewById(R.id.imageVie);


        toggleButton = view.findViewById(R.id.toggle_button);
        checkBox = view.findViewById(R.id.checkbox);
        radioButton = view.findViewById(R.id.radio_button);
        Switch = view.findViewById(R.id.switch_button);
        chipGroup = view.findViewById(R.id.chip_group);
        textField = view.findViewById(R.id.edit_text);
        addButton = view.findViewById(R.id.button);
        chipGroupFinal = view.findViewById(R.id.chip_Group_final);
        neapolitan = view.findViewById(R.id.neapolitan);
        Sicilian_Pizza = view.findViewById(R.id.Sicilian_Pizza);
        actionButton2 = view.findViewById(R.id.F_A_B2);
        radioGroup = view.findViewById(R.id.radio_Group);


        activity.setSupportActionBar(toolbar);

        if (radioButton.isChecked())
            imageView.setImageResource(R.drawable.food_delivery);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    imageView.setImageResource(R.drawable.food_delivery);

                    /*
                     * custom method for scaleType
                     * */
                    setScaleTypeFunction(imageView);
/*
                    imageView.getLayoutParams().height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
*/
/*
                    imageView.getLayoutParams().width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
*/

                    /*
                     * @requestLayout() is mandatory if you already set the height/width in xml file
                     * */

                    imageView.requestLayout();

                } else {
                    imageView.setImageResource(R.drawable.freelance);
                    setScaleTypeFunction(imageView);
                }
            }
        });
        Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Switch.isChecked()) {
                    imageView.setImageResource(R.drawable.food_delivery);
                    setScaleTypeFunction(imageView);
                } else imageView.setImageResource(R.drawable.freelance);

                setScaleTypeFunction(imageView);
            }
        });

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioButton.isChecked()) {
                    imageView.setImageResource(R.drawable.food_delivery);
                    setScaleTypeFunction(imageView);
                } else imageView.setImageResource(R.drawable.freelance);
                setScaleTypeFunction(imageView);


            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked()) {
                    imageView.setImageResource(R.drawable.food_delivery);
                    setScaleTypeFunction(imageView);
                } else imageView.setImageResource(R.drawable.freelance);
                setScaleTypeFunction(imageView);
            }
        });


        chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                int chip = chipGroup.getCheckedChipId();
                List<Integer> chipIds = chipGroup.getCheckedChipIds();

                int Id;
                for (Integer ids : chipIds) {
                    Id = ids;

                    switch (Id) {
                        case R.id.chip4:
                            imageView.setImageResource(R.drawable.food_delivery);
                            setScaleTypeFunction(imageView);
                            break;
                        case R.id.chill_oil:
                            imageView.setImageResource(R.drawable.freelance);
                            setScaleTypeFunction(imageView);
                            break;
                        case R.id.chip5:
                            imageView.setImageResource(R.drawable.food_delivery);
                            setScaleTypeFunction(imageView);
                            break;
                        case R.id.chip6:
                            imageView.setImageResource(R.drawable.food_delivery);
                            setScaleTypeFunction(imageView);
                            break;
                    }
                }

                if (chip == R.id.parmesan) {
                    imageView.setImageResource(R.drawable.food_delivery);
                    setScaleTypeFunction(imageView);
                }
            }
        });


        ChipGroup chipGroup3 = view.findViewById(R.id.chip_group3);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Chip chip = new Chip(getContext());


                /*
                 * TODO / This chipDrawable created from attribute
                 * */
/*                 ChipDrawable chipDrawable = ChipDrawable.createFromAttributes(getContext(),
                         null,
                         0,
                         com.google.android.material.R.style.Widget_MaterialComponents_Chip_Entry);*


                 /*chip.setCheckable(false);
                 chip.setClickable(true);
                 chip.setChipIconResource(R.drawable.download);
                 chip.setRippleColorResource(R.color.teal_200);
                 chip.setCloseIconTintResource(android.R.color.holo_red_dark);
                 chip.setCloseIconEndPadding(10);
                 chip.setIconStartPadding(5f);*/

                /*
                 * TODO  / this chipDrawable is created from Resource
                 * */

                ChipDrawable chipDrawable = ChipDrawable.createFromResource(getContext(), R.xml.chip);
                chip.setChipDrawable(chipDrawable);
                chip.setText(textField.getText().toString());

                chip.setOnCloseIconClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chipGroup3.removeView(chip);
                    }
                });
                chipGroup3.addView(chip);
                textField.setText("");

            }
        });


        FloatingActionButton floatingActionButton = view.findViewById(R.id.F_A_B);
        floatingActionButton.setVisibility(View.INVISIBLE);

        appBarLayout = view.findViewById(R.id.appbar_Layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
//                     now tool bar is collapsed / closed
                    floatingActionButton.setVisibility(View.INVISIBLE);
                } else if (verticalOffset == 0) {
//                     now tool bar is fully expended / opened
                    floatingActionButton.setVisibility(View.VISIBLE);
                } else /* Somewhere in between */
                    floatingActionButton.setVisibility(View.INVISIBLE);
            }
        });


        actionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioId = radioGroup.getCheckedRadioButtonId();

                if (radioId == -1) {
                    text = "You didn't chose any type";
                    Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();

                } else if (radioId == R.id.neapolitan) {
                    text = "You have chosen neapolitan Pizza";
                    Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();

                } else {
                    text = "You have chosen Sicilian Pizza";
                    Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
                }

                int chipId = chipGroupFinal.getCheckedChipId();

                if (chipId == R.id.chip_parmesan) {
                    text += " , Parmesan";
                } else if (chipId == R.id.chip_Chill_Oil) {
                    text += " , Chili Oil";
                } else {
                    if (radioId == -1){
                        text +="";
                    }else
                    text += " , No Extras";
                }

                Snackbar.make(actionButton2, text, Snackbar.LENGTH_SHORT)
                        .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
                        .setActionTextColor(Color.YELLOW)
                        .setAction("Dismiss",
                                        new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(activity, "Snackbar Dismissed", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                })
                                .show();
                text = "";

            }
        });


        return view;
    }

    void setScaleTypeFunction(ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

}