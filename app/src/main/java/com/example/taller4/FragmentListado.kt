package com.example.taller4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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
    private lateinit var itemAdapter: ItemAdapter

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
        listaElementos = mutableListOf()
        itemAdapter = ItemAdapter(requireContext(), R.layout.item, listaElementos)
        listado.adapter = itemAdapter
        btnAgregar.setOnClickListener {
            nuevoElemento()
        }

        listado.setOnItemClickListener { _, _, position, _ ->
            val item = listaElementos[position]
            val fragmentDetalles = FragmentDetalles.newInstance(item.titulo, item.descripcion)

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragmentDetalles)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun nuevoElemento(){

        Log.d("FragmentListado", "Lista de elementos actual: $listaElementos")

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
                    itemAdapter.notifyDataSetChanged()
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()

    }

}