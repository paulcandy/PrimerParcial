package Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User (id : Int, username : String, password : String, fullname : String) {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "username")
    var username : String

    @ColumnInfo(name = "password")
    var password : String

    @ColumnInfo(name = "fullname")
    var fullname : String

    init{
        this.id = id
        this.username = username
        this.password = password
        this.fullname = fullname
    }
}



