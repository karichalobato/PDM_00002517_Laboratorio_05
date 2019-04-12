package com.example.pdm_00002517_laboratorio_05

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

//clase abstracta metodos definidos
class MainActivity : AppCompatActivity(), Fragment_basic.ToolBoxListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fragmentBasic =Fragment_basic.newInstace("Hardcore","Text")


        supportFragmentManager.beginTransaction().add(R.id.activity_content, fragmentBasic)
                .commit()
        if (resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this,"Estoy en landskey",Toast.LENGTH_LONG).show()
        }
    }

    override fun ClickListenerHandler(view: TextView) {
        view.text="pi pi pipipipi"
    }
}
