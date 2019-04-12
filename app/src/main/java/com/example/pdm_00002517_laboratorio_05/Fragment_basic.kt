package com.example.pdm_00002517_laboratorio_05

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_basic.*
import kotlinx.android.synthetic.main.fragment_basic.view.*
import java.lang.Exception

const val ARG_TEXTO1 = "texto1"
const val ARG_TEXTO2 = "texto2"

class Fragment_basic: Fragment(){

    var texto1:String?=null
    var texto2:String?=null
    var toolBox:ToolBoxListener?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            texto1=getString(ARG_TEXTO1,"")
            texto2=getString(ARG_TEXTO2,"")
        }
    }
//inflate me muestra una view
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_basic,container,false).apply {
            mtv_01.text=texto1
            mtv_02.text=texto2
            action_change.setOnClickListener{
                toolBox?.ClickListenerHandler(mtv_01)
            }
        }

    }
//una interfaz es donde declaras los metodos, pero no los defines.
    companion object {
        fun newInstace(texto1:String, texto2: String)=Fragment_basic().apply {
            arguments=Bundle().apply {
                putString("texto1", texto1)
                putString("texto2", texto2)
            }
        }
    }
    interface ToolBoxListener{
        fun ClickListenerHandler(view:TextView)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ToolBoxListener){
            toolBox=context
        }else{
            throw Exception("SE NECESITA IMPLEMENTAR ToolBoxListenner")
        }
    }

    override fun onDetach() {
        super.onDetach()
        toolBox=null
    }
}