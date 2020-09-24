package Entities

class Product(name: String, price : Int, desc : String , urlImg : String, use : String, MP : String) {

    public lateinit var productName : String
    public  var productPrice : Int = 0
    public lateinit var productDescription : String
    public lateinit var productImage : String
    public lateinit var productMethodOfUse : String
    public lateinit var productMP : String


    init {
        this.productName = name
        this.productPrice = price
        this.productDescription = desc
        this.productImage = urlImg
        this.productMethodOfUse = use
        this.productMP = MP
     }
}