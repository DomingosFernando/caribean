package hotel


class ClienteController {

    def index() {
        render view: '/index'
    }

    def cadastro() {
        render view: "/Cadastro/registro-clientes"
    }

    def cadastrar() {
        def a = request.getFile("arquivo")
        def nomeOriginal = params.arquivo.originalFilename
        def tamanho = nomeOriginal.length()
        def extensao = nomeOriginal.substring(tamanho - 3, tamanho)
        a.transferTo(new File("C:/Users/User/Documents/Project/caribean-hotel/grails-app/assets/images/Usuarios/${params.email}.${extensao}"))
        def cliente = new Cliente(params)
        cliente.conta = 0
        cliente.foto = "${params.email}.${extensao}"
        cliente.save(flush: true)

        render view: "/page-login", model: [texto: 'Cadastrado com sucesso!']
    }

    def criar(){
        def a = request.getFile("arquivo")
        def nomeOriginal = params.arquivo.originalFilename
        def tamanho = nomeOriginal.length()
        def x = url
        def extensao = nomeOriginal.substring(tamanho - 3, tamanho)
        a.transferTo(new File("C:/Users/User/Documents/Project/caribean-hotel/grails-app/assets/images/Usuarios/${params.email}.${extensao}"))
        def cliente = new Cliente(params)
        cliente.conta = 0
        cliente.foto = "${params.email}.${extensao}"
        cliente.save(flush: true)

        render view: "/pagina-usuario"
    }
    def avaliacoes(Long id) {
        def avaliacoes = Avaliacao.findAllByEstrelas(id)
        respond avaliacoes,view: "/avaliacao"
    }
    def deletar(Long id){
        def cliente = Cliente.get(id)
        cliente.delete(flush:true)
        render view: "/Deletar/deletar-cliente"
    }
    def atualizar(){
        //Foto
        def a = request.getFile("arquivo")
        def nomeOriginal = params.arquivo.originalFilename
        def tamanho = nomeOriginal.length()
        def extensao = nomeOriginal.substring(tamanho - 3, tamanho)
        a.transferTo(new File("C:/Users/User/Documents/Project/caribean-hotel/grails-app/assets/images/Usuarios/${params.email}.${extensao}"))
        //
        def cliente = Cliente.get(params.id) ?: new Cliente()
        cliente.conta = 0
        cliente.foto = "${params.email}.${extensao}"
        bindData(cliente, params)
        cliente.save(flush: true, failOnError: true)
        render view: "/Atualizar/atualizar-cliente"

    }
}
