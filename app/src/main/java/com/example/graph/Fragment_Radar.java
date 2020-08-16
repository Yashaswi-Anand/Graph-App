package com.example.graph;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Fragment_Radar extends Fragment {
    EditText l1, l2, l3,l4, v1, v2, v3,v4;
    Button button;
    RadarChart radarChart;
    RadarDataSet radarDataSet;
    RadarData radarData;
    ArrayList<RadarEntry> Rentries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.radargraph_fragment, container, false);

        getActivity().setTitle("Radar Chart"); //set fragment name

        radarChart=view.findViewById(R.id.radarchart);
        v1=view.findViewById(R.id.ved1);
        v2=view.findViewById(R.id.ved2);
        v3=view.findViewById(R.id.ved3);
        v4=view.findViewById(R.id.ved4);
        l1=view.findViewById(R.id.led1);
        l2=view.findViewById(R.id.led2);
        l3=view.findViewById(R.id.led3);
        l4=view.findViewById(R.id.led4);
        button=view.findViewById(R.id.showResult);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rentries=new ArrayList<>();
                Rentries.add(new RadarEntry(Float.parseFloat(v1.getText().toString())));
                Rentries.add(new RadarEntry(Float.parseFloat(v2.getText().toString())));
                Rentries.add(new RadarEntry(Float.parseFloat(v3.getText().toString())));
                Rentries.add(new RadarEntry(Float.parseFloat(v4.getText().toString())));

                radarDataSet=new RadarDataSet(Rentries,"Graph Is Shown.");
                radarDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                radarDataSet.setValueTextSize(15f);
                radarDataSet.setValueTextColor(Color.BLUE);
                radarDataSet.setVisible(true);

                String[] labels={l1.getText().toString(),l2.getText().toString(),l3.getText().toString(),l4.getText().toString()};
                XAxis xAxis=radarChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
                xAxis.setTextColor(Color.RED);
                xAxis.setTextSize(15f);


                radarData=new RadarData(radarDataSet);
                radarChart.setData(radarData);
                radarChart.getDescription().setEnabled(false);
                radarChart.animateX(1000);
            }
        });


        return view;
    }


}
