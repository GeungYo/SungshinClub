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
        val selectedClub = sharedPreferences.getString("$studentId:selectedClub", null) // 선택된 동아리 정보

        // 사용자 정보 및 동아리 정보 설정
        val studentInfoTextView = view.findViewById<TextView>(R.id.studentInfo)
        studentInfoTextView.text = "$userName"
        val clubName: String
        val clubDescription: String
        if (!selectedClub.isNullOrEmpty()) {
            val splitData = selectedClub.split(":")
            clubName = splitData[0]
            clubDescription = splitData[1]
        } else {
            clubName = "동아리 이름이 없습니다."
            clubDescription = "동아리가 선택되지 않았습니다."
        }

        // 텍스트 뷰에 데이터 설정
        val homeClubNameTextView = view.findViewById<TextView>(R.id.homeClubName)
        val homeClubInfoTextView = view.findViewById<TextView>(R.id.homeClubInfo)
        homeClubNameTextView.text = clubName
        homeClubInfoTextView.text = clubDescription




        return view
    }
}
