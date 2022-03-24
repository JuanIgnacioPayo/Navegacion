package com.ort.navegacion.entities

import android.text.Editable
import org.w3c.dom.Text

class Usuario (name: String , email: String, password: String)
{
    private val password= password
    private val email = email
    private val name = name

    fun validarClave(clave: String): Boolean {
        return this.password.equals(clave)
    }
    fun validarMail(mail: String): Boolean {
        return this.email.equals(mail)
    }
    fun getName() : String
    {return this.name}

}