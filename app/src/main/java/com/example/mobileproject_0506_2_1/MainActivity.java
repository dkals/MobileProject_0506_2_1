package com.example.mobileproject_0506_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //id설정시 int 값 필요
    int[] btnNumId = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,
            R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
    Button[] btnNum = new Button[btnNumId.length]; //길이가 얼마나 더 많아질지 모르므로 length로 설정
    EditText edit1, edit2;
    TextView textResult;//필드로 선언해둠

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        textResult = findViewById(R.id.text_result);
        for (int i=0; i<btnNum.length; i++){
            final int index = i;
            btnNum[i] =findViewById(btnNumId[i]);
            btnNum[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String num = ""; //비어있는 문자열로 초기화 시킴
                    if (edit1.isFocused()){
                        num = edit1.getText().toString() + btnNum[index].getText();
                        edit1.setText(num);
                    } //edit1에 포커스가 맞춰져있다면~
                    if (edit2.isFocused()){
                        num = edit2.getText().toString() + btnNum[index].getText();
                        edit2.setText(num); //edit2에 입력된 문자열에 다시 설정?
                    }

                }
            }); //파이널 변수 안만들면 (30line: i로만 설정하면) 9에만 설정이 됨
        }
        Button btnPlus = findViewById(R.id.btn_plus);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnMultiply = findViewById(R.id.btn_multiply);
        Button btnDivide = findViewById(R.id.btn_divide);

        //plus~divide 온클릭리스너설정
        btnPlus.setOnClickListener(btnListener);
        btnMinus.setOnClickListener(btnListener);
        btnMultiply.setOnClickListener(btnListener);
        btnDivide.setOnClickListener(btnListener);

    }
    //클릭된 값이 뷰라는 매개로 전달?
    //getid 클릭된 버튼 넷중에 하나 클릭
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // String edit1str = edit1.getText().toString();
            // String edit2str = edit2.getText().toString();//변수가 회색 = 선언만하고 사용한적이없을때,,
            // int edit1num = Integer.parseInt(edit1str);
            // int edit2num = Integer.parseInt(edit2str); 대신 밑줄 이용
            int edit1num = Integer.parseInt(edit1.getText().toString());
            int edit2num = Integer.parseInt(edit2.getText().toString());
            int result = 0; // result 변수 선언했으므로 밑에 switch 구문에 result 사용

            switch(view.getId()){
                case R.id.btn_plus:
                    result = edit1num + edit2num;
                    break;
                case R.id.btn_minus:
                    result = edit1num - edit2num;
                    break;
                case R.id.btn_multiply:
                    result = edit1num * edit2num;
                    break;
                case R.id.btn_divide:
                    result = edit1num / edit2num;
                    break;
            }
            textResult.setText("계산 결과: "+result);

        }
    };


}