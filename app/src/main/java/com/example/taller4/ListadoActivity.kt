package com.example.taller4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ListadoActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentListado())
                .commit()
        }
    }
}