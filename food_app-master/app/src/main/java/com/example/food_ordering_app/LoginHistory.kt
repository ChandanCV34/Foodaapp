package com.example.food_ordering_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginHistory : AppCompatActivity() {
    private lateinit var session: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_history)
        val string=intent.getStringExtra("string")

        val apiclient=application as ApiClient
        session=SessionManager(this)
        var intent= Intent(this,User_Login::class.java)

        var token=session.fetchAuthToken()
        val items:MutableList<LoginData> = mutableListOf<LoginData>()
        if(session.fetchAuthToken()!=null){
            CoroutineScope(Dispatchers.IO).launch{
                val result=apiclient.apiService.GetLoginhistory("Bearer "+token)
                var i=0
                if(result.isSuccessful){
                    while(i<result.body()?.loginEntries!!.size){
                        items.add(result.body()?.loginEntries!![i])
                        i+=1
                    }
                }
                else{
                    startActivity(intent)
                }
                withContext(Dispatchers.Main){
                    val recycle=findViewById<RecyclerView>(R.id.recycle2)
                    recycle.adapter=LoginAdatpterClass(items)
                    recycle.layoutManager= LinearLayoutManager(this@LoginHistory)
                }

            }
        }
        else
            startActivity(intent)
    }
}
