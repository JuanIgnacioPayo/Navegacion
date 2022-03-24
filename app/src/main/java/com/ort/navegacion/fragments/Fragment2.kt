package com.ort.navegacion.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ort.navegacion.R
import com.ort.navegacion.viewModels.Fragment2ViewModel
import org.w3c.dom.Text

class Fragment2 : Fragment() {

    companion object {
        fun newInstance() = Fragment2()
    }

    private lateinit var viewModel: Fragment2ViewModel

    private lateinit var v : View

    private lateinit var bienvenido : TextView

    private lateinit var nombre : TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment2_fragment, container, false)

        bienvenido =  v.findViewById(R.id.bienvenido)

        nombre = v.findViewById( R.id.name)


        return v
    }

    override fun onStart() {
        super.onStart()
        nombre.text= Fragment2Args.fromBundle(requireArguments()).nameUser
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Fragment2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}