package hotel

class Administrador {
    String nome
    String email
    String senha
    String foto
    String estado
    String pais
    static constraints = {
        nome(nullable:false,blank:false,maxSize:50)
        senha(nullable:false,blank:false,maxSize:50)
        email(nullable:false,blank:false,maxSize:50,unique:true,email:true)
        estado(nullable:false,blank:false,maxSize:200)
        pais(nullable:false,blank:false,maxSize:200)
    }
}
