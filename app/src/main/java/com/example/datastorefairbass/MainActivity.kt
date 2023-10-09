package com.example.datastorefairbass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = findViewById<EditText>(R.id.userName)
        val userAge = findViewById<EditText>(R.id.userAge)
        val userEmail = findViewById<EditText>(R.id.userEmail)
        val userPhone = findViewById<EditText>(R.id.userPhone)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            var userId = Firebase.auth.currentUser?.uid.toString()
            var collection = Firebase.firestore.collection("rahul")

            var userData =UserModel(

                userName.text.toString(),
                userAge.text.toString().toLong(),
                userEmail.text.toString(),
                userPhone.text.toString().toLong()
            )
            //set
            collection.add(userData).addOnSuccessListener {
                Toast.makeText(this@MainActivity, "Successfull", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener {
                    Toast.makeText(this@MainActivity, "fail", Toast.LENGTH_SHORT).show()

                }
//            collection.document(userId).get()
//                .addOnSuccessListener {
//                    var data = it.toObject(UserModel::class.java)
//                }
//                .addOnFailureListener {
//
//                }
          }
       }
}