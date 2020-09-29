package Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
class Product(id: Int, name: String, price: Int, description: String, urlImg: String, useMethod: String, sourceMaterials: String) {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int = 0
    @ColumnInfo(name = "name")
    public var name : String
    @ColumnInfo(name = "price")
    public var price : Int = 0
    @ColumnInfo(name = "description")
    public var description : String
    @ColumnInfo(name = "urlImg")
    public var urlImg : String
    @ColumnInfo(name = "useMethod")
    public var useMethod : String
    @ColumnInfo(name = "sourceMaterials")
    public var sourceMaterials : String


    init {
        this.id = id
        this.name = name
        this.price = price
        this.description = description
        this.urlImg = urlImg
        this.useMethod = useMethod
        this.sourceMaterials = sourceMaterials
     }
}