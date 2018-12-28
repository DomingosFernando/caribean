package hotel

import javax.servlet.ServletException

class GerenteController {

    def index() {}
    def cadastro(){
        render view:"/Cadastro/registro-gerentes"
    }
    def login() {
        render view: "/pagina-usuario"
    }

    def cadastrar(){
        def gerente = new Gerente(params)
        gerente.clientes = Cliente.list()
        gerente.quartos = Quarto.list()
        gerente.hotel = Hotel.get(1)
        //Adicionando foto
        def a = request.getFile("arquivo")
        def nomeOriginal = params.arquivo.originalFilename
        def tamanho = nomeOriginal.length()
        def extensao = nomeOriginal.substring(tamanho-3, tamanho)
        a.transferTo(new File("C:/Users/User/Documents/Project/caribean-hotel/grails-app/assets/images/Usuarios/${gerente.email}.${extensao}"))
        gerente.foto = "${gerente.email}.${extensao}"
        //Final do codigo
        gerente.save(flush:true)
        redirect controller:"Menu",action:"inicial2"
    }

    def criar() {
        def gerente = new Gerente(params)
        gerente.clientes = Cliente.list()
        gerente.quartos = Quarto.list()
        gerente.hotel = Hotel.get(1)
        //Adicionando foto
        def a = request.getFile("arquivo")
        def nomeOriginal = params.arquivo.originalFilename
        def tamanho = nomeOriginal.length()
        def extensao = nomeOriginal.substring(tamanho - 3, tamanho)
        a.transferTo(new File("C:/Users/User/Documents/Project/caribean-hotel/grails-app/assets/images/Usuarios/${gerente.email}.${extensao}"))
        gerente.foto = "${gerente.email}.${extensao}"
        //Final do codigo
        gerente.save(flush: true)

        render view: "/pagina-usuario"
    }
    def deletar(Long id){
        def gerente = Gerente.get(id)
        gerente.delete(flush:true)
        render view: "/Deletar/deletar-cliente"
    }
    def atualizar() {
        //Foto
        def a = request.getFile("arquivo")
        def nomeOriginal = params.arquivo.originalFilename
        def tamanho = nomeOriginal.length()
        def extensao = nomeOriginal.substring(tamanho - 3, tamanho)
        a.transferTo(new File("C:/Users/User/Documents/Project/caribean-hotel/grails-app/assets/images/Usuarios/${params.email}.${extensao}"))
        //
        def gerente = Gerente.get(params.id) ?: new Gerente()
        gerente.foto = "${params.email}.${extensao}"
        bindData(gerente, params)
        gerente.save(flush: true, failOnError: true)
        render view: "/Atualizar/atualizar-gerentes"

    }
}
