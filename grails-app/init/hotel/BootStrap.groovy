package hotel

class BootStrap {

    def init = { servletContext ->
        new Administrador(nome:"ADMIN",email:"admin@admin.com",senha:"admin", foto:"admin.jpg", estado:"RN", pais:"Brasil").save(flush:true)

        new Servicos (tipo:"Serviço de quarto completo", preco:"30").save(flush:true)

        new Quarto (capacidade:"2", estrelas:"4", valor:"200", foto:"1.jpg").save(flush:true, failOnError:true)
        new Quarto (capacidade:"2", estrelas:"5", valor:"300", foto:"2.jpg").save(flush:true)
        new Quarto (capacidade:"2", estrelas:"4", valor:"250", foto:"3.jpg").save(flush:true)
    }
    def destroy = {
    }
}
