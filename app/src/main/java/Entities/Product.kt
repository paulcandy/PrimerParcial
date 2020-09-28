package Entities

class Product(name: String, price : Int, desc : String , urlImg : String, use : String, MP : String) {

    public var productName : String
    public var productPrice : Int = 0
    public var productDescription : String
    public var productImage : String
    public var productMethodOfUse : String
    public var productMP : String


    init {
        this.productName = name
        this.productPrice = price
        this.productDescription = desc
        this.productImage = urlImg
        this.productMethodOfUse = use
        this.productMP = MP
     }
}