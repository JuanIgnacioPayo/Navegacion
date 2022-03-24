package com.ort.navegacion.fragments

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AlertDialogLayout
import androidx.navigation.findNavController
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.ort.navegacion.R
import com.ort.navegacion.entities.Usuario
import com.ort.navegacion.viewModels.Fragment1ViewModel

class Fragment1 : Fragment() {


    private lateinit var viewModel: Fragment1ViewModel

    private lateinit var v : View

    private lateinit var mail : EditText

    private lateinit var password : EditText

    private lateinit var btnLogin : Button

    private var usuarios : MutableList<Usuario> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment1_fragment, container, false)

        btnLogin = v.findViewById(R.id.btnLogin)

        mail = v.findViewById(R.id.email)

        password = v.findViewById(R.id.pass)

        return v
    }

    override fun onStart() {
        super.onStart()

        usuarios.add(Usuario("Juan", "juan@gmail.com","1234"))
        usuarios.add(Usuario("Facu", "facu@gmail.com","1234"))
        usuarios.add(Usuario("Ale", "ale@gmail.com","1234"))

        btnLogin.setOnClickListener {

            var nameUser = validarUsuario(this.mail.text.toString(), this.password.text.toString())

            if (nameUser.length>0)
            {
                val action = Fragment1Directions.actionFragment1ToFragment2(nameUser)
                v.findNavController().navigate(action)
            }
            else{

                Snackbar.make(v,"Login incorrecto",Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun validarUsuario(mail: String, pass: String): String {
       var nombre: String = ""
        usuarios.forEach { usuario ->
            if (usuario.validarClave(pass)&&usuario.validarMail(mail)){
                nombre = usuario.getName()
            }
        }
        return nombre
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Fragment1ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}