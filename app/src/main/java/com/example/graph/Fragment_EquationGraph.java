package com.example.graph;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Fragment_EquationGraph extends Fragment implements View.OnClickListener {
EditText x1,x2,y1,y2,c1,c2;
TextView result;
Button button;
ImageView info;

LineChart equlinechart;
LineDataSet lineDataSet,lineDataSet_two,showdata;
LineData lineData;
ArrayList lineEntry,lineEntry_two,showList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.equationgraph_fragment,container,false);

        getActivity().setTitle("Solution Of Equations");

        equlinechart=view.findViewById(R.id.equlinechart);
        x1=view.findViewById(R.id.x1);
        y1=view.findViewById(R.id.y1);
        c1=view.findViewById(R.id.c1);
        x2=view.findViewById(R.id.x2);
        y2=view.findViewById(R.id.y2);
        c2=view.findViewById(R.id.c2);
        result=view.findViewById(R.id.tv);
        button=view.findViewById(R.id.but);
        info=view.findViewById(R.id.infoimf);
        info.setOnClickListener(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float num = (Float.parseFloat(x1.getText().toString()) * Float.parseFloat(c2.getText().toString())) -
                        (Float.parseFloat(x2.getText().toString()) * Float.parseFloat(c1.getText().toString()));

                float denum = (Float.parseFloat(x1.getText().toString()) * Float.parseFloat(y2.getText().toString())) -
                        (Float.parseFloat(c1.getText().toString()) * Float.parseFloat(y1.getText().toString()));
                float valY = num / denum;

                float valX = (Float.parseFloat(c1.getText().toString()) - Float.parseFloat(y1.getText().toString()) * valY) / Float.parseFloat(x1.getText().toString());
                String ans = "Answer: (" + Float.toString(valX) + " , " + Float.toString(valY) + ")";
                if ((Float.parseFloat(x1.getText().toString()) == Float.parseFloat(x2.getText().toString()))
                        && (Float.parseFloat(y1.getText().toString()) == Float.parseFloat(y2.getText().toString()))) {
                    result.setText("  No Solution (Parallel lines)");
                    result.setTextColor(Color.RED);
                } else {
                    result.setText(ans);
                    result.setTextColor(Color.MAGENTA);

                }

                    float Anum;
                    if (valX < 0) {
                        Anum = Math.abs(valX);
                    } else {
                        Anum = valX;
                    }
                    //co-ordinator of first equation
                    lineEntry = new ArrayList<>();

                    lineEntry.add(new Entry(valX - Anum, (Float.parseFloat(c1.getText().toString()) -
                            (Float.parseFloat(x1.getText().toString()) * (valX - Anum))) / Float.parseFloat(y1.getText().toString())));
                    lineEntry.add(new Entry(valX, valY));
                    lineEntry.add(new Entry(valX + Anum, (Float.parseFloat(c1.getText().toString()) -
                            (Float.parseFloat(x1.getText().toString()) * (valX + Anum))) / Float.parseFloat(y1.getText().toString())));
                    lineEntry.add(new Entry(valX + Anum + 2, (Float.parseFloat(c1.getText().toString()) -
                            (Float.parseFloat(x1.getText().toString()) * (valX + Anum + 2))) / Float.parseFloat(y1.getText().toString())));
                    lineEntry.add(new Entry(valX + Anum + 4, (Float.parseFloat(c1.getText().toString()) -
                            (Float.parseFloat(x1.getText().toString()) * (valX + Anum + 4))) / Float.parseFloat(y1.getText().toString())));

                    String Equ1 = x1.getText().toString() + "x+" + y1.getText().toString() + "y=" + c1.getText().toString();
                    lineDataSet = new LineDataSet(lineEntry, "Equation1: " + Equ1);
                    lineDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                    lineDataSet.setValueTextColor(Color.MAGENTA);
                    lineDataSet.setLineWidth(3f);
                    lineDataSet.setValueTextSize(16f);

                    //co-ordination 0f second equation
                    lineEntry_two = new ArrayList<>();

                    lineEntry_two.add(new Entry(valX, valY));
                    lineEntry_two.add(new Entry(valX - Anum, (Float.parseFloat(c2.getText().toString()) -
                            (Float.parseFloat(x2.getText().toString()) * (valX - Anum))) / Float.parseFloat(y2.getText().toString())));
                    lineEntry_two.add(new Entry(valX + Anum, (Float.parseFloat(c2.getText().toString()) -
                            (Float.parseFloat(x2.getText().toString()) * (valX + Anum))) / Float.parseFloat(y2.getText().toString())));
                    lineEntry_two.add(new Entry(valX + Anum + 2, (Float.parseFloat(c2.getText().toString()) -
                            (Float.parseFloat(x2.getText().toString()) * (valX + Anum + 2))) / Float.parseFloat(y2.getText().toString())));
                    lineEntry_two.add(new Entry(valX + Anum + 4, (Float.parseFloat(c2.getText().toString()) -
                            (Float.parseFloat(x2.getText().toString()) * (valX + Anum + 4))) / Float.parseFloat(y2.getText().toString())));

                    String Equ2 = x2.getText().toString() + "x+" + y2.getText().toString() + "y=" + c2.getText().toString();
                    lineDataSet_two = new LineDataSet(lineEntry_two, "Equation2: " + Equ2);
                    lineDataSet_two.setColors(ColorTemplate.JOYFUL_COLORS);
                    lineDataSet_two.setValueTextColor(Color.MAGENTA);
                    lineDataSet_two.setLineWidth(3f);
                    lineDataSet_two.setValueTextSize(16f);

                    showList = new ArrayList();
                    showList.add(new Entry(valX, valY));
                    showdata = new LineDataSet(showList, "");
                    showdata.setValueTextColor(Color.BLACK);
                    showdata.setValueTextSize(20f);
                    showdata.setDrawCircles(true);


                    lineData = new LineData();
                    lineData.addDataSet(lineDataSet);
                    lineData.addDataSet(lineDataSet_two);
                    //lineData.addDataSet(showdata);
                    equlinechart.setData(lineData);



            }
        });



        return view;
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder myBuilder=new AlertDialog.Builder(getActivity());
        myBuilder.setTitle("Info...");
        myBuilder.setIcon(R.drawable.sign_icon);
        myBuilder.setPositiveButton("Fine",null);
        String message="General form of linear equation: aX+bY=c 0r aX+bY-c=0.\n\n" +
                "Here, Enter the value of 'a'(coefficient of X),\t'b'(coefficient of Y)\t and value of 'c'(constant value).";
        myBuilder.setMessage(message);
        AlertDialog alertDialog=myBuilder.create();
        myBuilder.show();
    }


}
