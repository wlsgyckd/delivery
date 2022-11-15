package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    // 검색시 같은 이름이 있는 아이템이 담길 리스트
    ArrayList<SingleItem> search_list = new ArrayList<>();
    // recyclerView에 추가할 아이템 리스트
    ArrayList<SingleItem> original_list = new ArrayList<>();
    // 어댑터
    SimpleTextAdapter adapter;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 리스트에 아이템 추가
        for(int i=0; i<50; i++){
            if(i % 2 == 0){
                original_list.add(new SingleItem("STORE " + i,"foreground image " + i, "foreground image " + i, R.drawable.ic_launcher_foreground));
            }
            else{
                original_list.add(new SingleItem("STORE " + i,"background image " + i, "background image " + i, R.drawable.ic_launcher_background));
            }
        }

        editText = findViewById(R.id.editText);

        // editText 리스터 작성
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String searchText = editText.getText().toString();
                search_list.clear();

                if(searchText.equals("")){
                    adapter.setItems(original_list);
                }
                else {
                    // 검색 단어를 포함하는지 확인
                    for (int a = 0; a < original_list.size(); a++) {
                        if (original_list.get(a).name.toLowerCase().contains(searchText.toLowerCase())) {
                            search_list.add(original_list.get(a));
                        }
                        adapter.setItems(search_list);
                    }
                }
            }
        });

        // recyclerView, adapter연결
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SimpleTextAdapter(original_list);
        recyclerView.setAdapter(adapter);
    }
}