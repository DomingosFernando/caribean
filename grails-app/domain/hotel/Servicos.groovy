package hotel

class Servicos {
    String tipo
    String preco
    static hasMany=[quartos:Quarto,funcionario:Funcionario]
    static belongsTo=[quartos:Quarto]

    static constraints = {
        tipo(blank:false,nullable:false,unique:true)
        preco(blank:false,nullable:false)
        quartos(nullable: true)
    }
}
