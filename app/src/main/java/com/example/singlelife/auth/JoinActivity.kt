package com.example.singlelife.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.singlelife.R
import com.example.singlelife.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {
    private lateinit var binding : ActivityJoinBinding
    private lateinit var auth: FirebaseAuth
    private var TAG = "JoinActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        binding = DataBindingUtil.setContentView(this,
        R.layout.activity_join)
        auth = Firebase.auth

        binding.joinBtn.setOnClickListener {

            var email = binding.emailArea.text.toString()
            var pwd = binding.pwdArea1.text.toString()
            var pwd2 = binding.pwdArea2.text.toString()
            Log.d(TAG, " email="+email+", pwd="+pwd+", pwd2"+pwd2)

            if(email==null || email == "")
                Toast.makeText(baseContext,"이메일을 입력해주세요." , Toast.LENGTH_SHORT).show()
            else if (pwd==null || pwd ==""  || pwd2==null || pwd2 == "")
                 Toast.makeText(baseContext,"비밀번호를 입력해주세요." , Toast.LENGTH_SHORT).show()
            else if(pwd!=pwd2)
                Toast.makeText(baseContext,"비밀번호 일치여부를 확인해주세요.", Toast.LENGTH_SHORT).show()
            else if(pwd.length < 6)
                Toast.makeText(baseContext,"비밀번호를 여섯 자릿수 이상 입력해주세요.", Toast.LENGTH_SHORT).show()
            else {
                 auth.createUserWithEmailAndPassword(email, pwd)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success")
                            Toast.makeText(baseContext,"회원가입을 완료해습니다.", Toast.LENGTH_SHORT).show()
                            val user = auth.currentUser

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed." + task.exception,
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    }
            }
        }
    }


}