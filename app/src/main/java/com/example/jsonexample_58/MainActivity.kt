package com.example.jsonexample_58

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsonexample_58.Model.UserAdapter
import com.example.jsonexample_58.Model.UserModelClass
import com.example.jsonexample_58.Model.Users
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList: ArrayList<UserModelClass> = ArrayList()



        try {

            val jsonString = getJSONFromAssets()!!
            val users = Gson().fromJson(jsonString, Users::class.java)

            recyclerView.layoutManager = LinearLayoutManager(this)
            val itemAdapter = UserAdapter(this, users.users)
            recyclerView.adapter = itemAdapter


//            val obj = JSONObject(getJSONFromAssets()!!)
//
//            val userArray = obj.getJSONArray("users")
//
//            for (i in 0 until userArray.length()){
//                val user = userArray.getJSONObject(i)
//
//                val id = user.getInt("id")
//                val name = user.getString("name")
//                val email = user.getString("email")
//                val gender = user.getString("gender")
//                val weight = user.getDouble("weight")
//                val height = user.getInt("height")
//
//                val phone = user.getJSONObject("phone")
//                val mobile = phone.getString("mobile")
//                val office = user.getString("office")
//
//                val userDetails = UserModelClass(id,name,email,gender, weight, height, mobile, office)
//                userList.add(userDetails)
//            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }



    }

    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset:Charset = Charsets.UTF_8
        try {
            val myUserJSONFile = assets.open("Users.json")
            val size = myUserJSONFile.available()
            val buffer = ByteArray(size)
            myUserJSONFile.read(buffer)
            myUserJSONFile.close()
        }catch (ex:IOException){
            ex.printStackTrace()
        }
        return json

    }
}