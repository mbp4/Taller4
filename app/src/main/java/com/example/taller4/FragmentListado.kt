package com.example.taller4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

class FragmentListado: Fragment() {

    private lateinit var listado: ListView
    private lateinit var btnSensores: Button
    private lateinit var btnAgregar: Button
    private lateinit var listaElementos: MutableList<Item>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.principal_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listado = view.findViewById(R.id.listadoElementos)
        btnSensores = view.findViewById(R.id.btnSensor)
        btnAgregar = view.findViewById(R.id.btnAgregar)

        btnAgregar.setOnClickListener {
            nuevoElemento()
        }
    }

    private fun nuevoElemento(){
        val dialogView = layoutInflater.inflate(R.layout.nuevo_item, null)
        val edttxt1 = dialogView.findViewById<EditText>(R.id.edtTitulo)
        val edttxt2 = dialogView.findViewById<EditText>(R.id.edtDescripcion)

        AlertDialog.Builder(requireContext())
            .setTitle("Nuevo Elemento")
            .setView(dialogView)
            .setPositiveButton("Guardar") { _, _ ->
                val nuevoTitulo = edttxt1.text.toString().trim()
                val nuevaDescripcion = edttxt2.text.toString().trim()

                if (nuevoTitulo.isNotEmpty() && nuevaDescripcion.isNotEmpty()) {
                    listaElementos.add(Item(nuevoTitulo, nuevaDescripcion))
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()

    }

}