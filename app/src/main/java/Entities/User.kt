package Entities

class User (nombreUsuario : String, contrasena : String, nombrePersona : String) {

    public lateinit var username : String
    public lateinit var password : String
    public lateinit var nombre : String
    public var hasAccess : Boolean = true

    init{
        this.username = nombreUsuario
        this.password = contrasena
        this.nombre = nombrePersona
    }
}



