package com.example.taller4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentDetalles:Fragment() {

    companion object {
        fun newInstance(titulo: String, descripcion: String): FragmentDetalles {
            val fragment = FragmentDetalles()
            val args = Bundle().apply {
                putString("titulo", titulo)
                putString("descripcion", descripcion)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detalles_fragment, container, false)

        val txtTitulo = view.findViewById<TextView>(R.id.txt1)
        val txtDescripcion = view.findViewById<TextView>(R.id.txt2)
        val btnVolver = view.findViewById<Button>(R.id.btnVolver)

        val titulo = arguments?.getString("titulo") ?: ""
        val descripcion = arguments?.getString("descripcion") ?: ""

        txtTitulo.text = titulo
        txtDescripcion.text = descripcion

        btnVolver.setOnClickListener {

            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }

}