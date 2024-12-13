package edu.sswu.sungshinclub

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.selects.select

class UserInfoFragment : Fragment(R.layout.fragment_user_info) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // SharedPreferences에서 사용자 정보 가져오기
        val sharedPreferences = requireContext().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val studentId = sharedPreferences.getString("currentUser", null) // 현재 사용자 학번
        val userName = sharedPreferences.getString("$studentId:name", "학생 이름") // 사용자 이름

        // 텍스트 뷰에 사용자 이름 설정
        val userNameTextView = view.findViewById<TextView>(R.id.userNameTextView)
        userNameTextView.text = userName

        // 로그아웃 버튼 설정
        val logoutButton = view.findViewById<Button>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", false)
            editor.putString("currentUser", null)
            editor.apply()

            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        val addClub = view.findViewById<TextView>(R.id.addClub)
        addClub.setOnClickListener {
            //동아리 등록할 수 있는 입력 팝업창
        }
        val selectClub = view.findViewById<TextView>(R.id.selectClub)
        selectClub.setOnClickListener {
            // 저장된 동아리 이름 선택 기능
        }
    }
}
