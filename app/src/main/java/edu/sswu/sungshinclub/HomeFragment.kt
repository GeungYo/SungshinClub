package edu.sswu.sungshinclub

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // SharedPreferences에서 사용자 정보 가져오기
        val sharedPreferences = requireContext().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val studentId = sharedPreferences.getString("currentUser", null) // 현재 사용자 학번
        val userName = sharedPreferences.getString("$studentId:name", "학생 이름") // 사용자 이름

        // 텍스트 뷰에 사용자 이름 설정
        val studentInfoTextView = view.findViewById<TextView>(R.id.studentInfo)
        studentInfoTextView.text = "$userName 님이 속한 성신여자대학교 동아리는 아래와 같습니다."

        return view
    }
}
