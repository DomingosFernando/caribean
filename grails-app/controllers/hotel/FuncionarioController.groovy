package hotel

class FuncionarioController {

    def index() {}

    def cadastrar() {
        def funcionario = new Funcionario(params)
        //Adicionando foto
        def a = request.getFile("arquivo")
        def nomeOriginal = params.arquivo.originalFilename
        def tamanho = nomeOriginal.length()
        def extensao = nomeOriginal.substring(tamanho - 3, tamanho)
        a.transferTo(new File("C:/Users/User/Documents/Project/caribean-hotel/grails-app/assets/images/Usuarios/${funcionario.email}.${extensao}"))
        funcionario.foto = "${funcionario.email}.${extensao}"
        //Final do codigo
        funcionario.save(flush: true)
        redirect controller:"Menu",action:"inicial2"
    }

    def criar(){
        def funcionario = new Funcionario(params)
        //Adicionando foto
        def a = request.getFile("arquivo")
        def nomeOriginal = params.arquivo.originalFilename
        def tamanho = nomeOriginal.length()
        def extensao = nomeOriginal.substring(tamanho - 3, tamanho)
        a.transferTo(new File("C:/Users/User/Documents/Project/caribean-hotel/grails-app/assets/images/Usuarios/${funcionario.email}.${extensao}"))
        funcionario.foto = "${funcionario.email}.${extensao}"
        //Final do codigo
        funcionario.save(flush: true)

        render view: "/pagina-usuario"
    }

    def deletar(Long id) {
        def funcionario = Funcionario.get(id)
        funcionario.delete(flush: true)
        render view: "/Deletar/deletar-funcionario"
    }

    def atualizar() {
        //Foto
        def a = request.getFile("arquivo")
        def nomeOriginal = params.arquivo.originalFilename
        def tamanho = nomeOriginal.length()
        def extensao = nomeOriginal.substring(tamanho - 3, tamanho)
        a.transferTo(new File("C:/Users/User/Documents/Project/caribean-hotel/grails-app/assets/images/Usuarios/${params.email}.${extensao}"))
        //
        def funcionario = Funcionario.get(params.id) ?: new Funcionario()
        funcionario.foto = "${params.email}.${extensao}"
        bindData(funcionario, params)
        funcionario.save(flush: true, failOnError: true)
        render view: "/Atualizar/atualizar-funcionario"

    }

}
