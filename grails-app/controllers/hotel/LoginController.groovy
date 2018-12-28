package hotel

class LoginController {

    def index() { }

    def login() {
        render view: "/page-login"
    }

    def logar() {
        def administrador = Administrador.findByEmail(params.email)
        def cliente = Cliente.findByEmail(params.email)
        def funcionario = Funcionario.findByEmail(params.email)
        def gerente = Gerente.findByEmail(params.email)
        if (cliente && (cliente.senha == params.senha)) {
            session.usuario = cliente
            render view: "/pagina-usuario"
        } else if (gerente && (gerente.senha == params.senha)) {
            session.usuario = gerente
            render view: "/pagina-usuario"
        } else if (administrador && (administrador.senha == params.senha)) {
            session.usuario = administrador
            render view: "/pagina-usuario"
        } else if (funcionario && (funcionario.senha == params.senha)) {
            session.usuario = funcionario
            render view: "/pagina-usuario"
        } else {
            render view: "/page-login", model: [status: 'Invalido!']
        }
    }
}
