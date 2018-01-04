package com.n9s.flyjet.hk2018010403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Spinner spinner;
    ArrayList<String> data;
    TextView tv;
    TextView tv2;
    EditText ed;
    ArrayAdapter<String> adapter;
    Spinner spinner2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        ed = (EditText) findViewById(R.id.editText);
        tv3 = (TextView) findViewById(R.id.textView3);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        data = new ArrayList<>();
        data.add("AA11");
        data.add("BB22");
        data.add("CC33");

        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, data);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                tv.setText(data.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                String str[] = getResources().getStringArray(R.array.cities); //重要! 取出靜態陣列(spinner2)內容
                tv3.setText(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void click1(View v)  //按button後顯示於TextView2
    {
        int pos = spinner.getSelectedItemPosition();
        tv2.setText(data.get(pos));
    }

    public void clickAdd(View v) //新增選項入spinner
    {
        data.add(ed.getText().toString());  //資料存在data array內
        adapter.notifyDataSetChanged();  //更新
    }

    public void clickDelete(View v)
    {
        data.remove(spinner.getSelectedItemPosition());
        adapter.notifyDataSetChanged(); //更新
    }
}
