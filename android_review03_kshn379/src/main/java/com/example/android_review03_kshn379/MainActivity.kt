package com.example.android_review03_kshn379

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_review03_kshn379.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val studentList = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뷰 설정
        settingView()
        // 이벤트 설정
        settingEvent()

    }

    // 이벤트 설정
    fun settingEvent() {
        binding.apply {
            rvMainList.adapter = StudentAdapter(studentList)
            rvMainList.adapter?.notifyDataSetChanged()

            // 버튼 클릭시 작동
            btnMainInfo.setOnClickListener {
                typeMainInfo.visibility = View.VISIBLE
                scoreMainInfo.visibility = View.GONE
                btnMainInfo.visibility = View.VISIBLE
                btnMainScore.visibility = View.VISIBLE
            }
            btnMainScore.setOnClickListener {
                typeMainInfo.visibility = View.GONE
                scoreMainInfo.visibility = View.VISIBLE
                btnMainScore.visibility = View.VISIBLE
                btnMainInfo.visibility = View.VISIBLE

            }
            studentMainButton.setOnClickListener {
                val resultCheck = validateInput()

                if (resultCheck) {
                    val name = studentMainName.text.toString()
                    val grade = studentMainGrade.text.toString()
                    val korea = koreanMainScore.text.toString()
                    val math = mathMainScore.text.toString()
                    val english = englishMainScore.text.toString()

                    if (name.isNotEmpty() && grade.isNotEmpty() && korea.isNotEmpty() && math.isNotEmpty() && english.isNotEmpty()) {
                        studentList.add(Student(name, grade, korea, math, english))
                        rvMainList.adapter?.notifyDataSetChanged()

                        // EditText 초기화
                        studentMainName.text.clear()
                        studentMainGrade.text.clear()
                        koreanMainScore.text.clear()
                        mathMainScore.text.clear()
                        englishMainScore.text.clear()

                        // 초기 화면으로 돌아가기
                        typeMainInfo.visibility = View.GONE
                        scoreMainInfo.visibility = View.GONE

                        // 리사이클러 뷰가 있는 레이아웃을 보여준다
                        rvMainList.visibility = View.VISIBLE
                    }

                    // 어댑터 연결
                    rvMainList.adapter = StudentAdapter(studentList)
                    // 어댑터에 변경을 알린다
                    rvMainList.adapter?.notifyDataSetChanged()
                }
            }
            checkMainScore.setOnClickListener {
                typeMainInfo.visibility = View.GONE
                scoreMainInfo.visibility = View.GONE
                rvMainList.visibility = View.VISIBLE
            }
        }
    }


    // 뷰 설정
    fun settingView() {
        binding.apply {
            rvMainList.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = StudentAdapter(studentList)
                }

            }
        }

    // 유효성 검사
    fun validateInput(): Boolean {
        binding.apply {
            if (studentMainName.text.isEmpty()) {
                studentMainName.error = "이름을 입력해주세요"
                return false
            }
            if (studentMainGrade.text.isEmpty()) {
                studentMainGrade.error = "학년을 입력해주세요"
                return false
            }
            if (koreanMainScore.text.isEmpty()) {
                koreanMainScore.error = "국어 점수를 입력해주세요"
                return false
            }
            if (englishMainScore.text.isEmpty()) {
                englishMainScore.error = "영어 점수를 입력해주세요"
                return false
            }
            if (mathMainScore.text.isEmpty()) {
                mathMainScore.error = "수학 점수를 입력해주세요"
                return false
            }
        }
        return true
    }
}



