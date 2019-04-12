package com.example.pdm_00002517_laboratorio_05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

//clase abstracta metodos definidos
class MainActivity : AppCompatActivity(), Fragment_basic.ToolBoxListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fragmentBasic =Fragment_basic.newInstace("Hardcore","Text")


        supportFragmentManager.beginTransaction().add(R.id.activity_content, fragmentBasic)
                .commit()
    }

    override fun ClickListenerHandler(view: TextView) {
        view.text="pi pi pipipipi"
    }
}
