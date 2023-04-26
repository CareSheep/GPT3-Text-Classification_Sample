package com.swu.gpt3_text_classification

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 분류할 텍스트 입력
        val text = "배가 너무 아파"

        // 노인의 위험상황 감지 모델 생성
        val model = "text-davinci-002"
        val prompt = (" 다음 텍스트가 노인의 위험상황인지 판단하세요.:\n$text" +
                "\n위험상황일 경우 '1', 그렇지 않을 경우 '0'을 입력하세요:")

        // 요청
        Gpt3Api.requestGpt3Api(prompt, model) { response ->
            // response에는 API 응답 결과가 반환됩니다.
            if (response!!.toString().toInt() == 1)
                Log.e("위험상황 여부", "노인의 위험상황입니다.")
            else {
                Log.e("위험상황 여부", "노인의 위험상황이 아닙니다.")
            }
        }
    }
}
