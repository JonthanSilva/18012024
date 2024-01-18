import java.sql.*;
// Importação de todos os itens da biblioteca java.sql
import java.util.*;
// importação de todos os intens da biblioteca java.util
public class Update {
    /**
    * public: porque podera ser importado por outros objetos/classes
    */
    public static void main(String[] args) {
        /**
         *public: porque podera ser importado por outros objetos/classes
         * static: porque o método não podera ser alterado ou sobrescrito
         * void: porque é um metodo sem retorno
         */
        String status = "Nada aconteceu ainda.";
        /*
        * Declaração de uma variável statusinicializada com a mensagem padrão.
        */
    Scanner scnLogin = new Scanner(System.in);
    /*Criação de um objeto Scannerchamado scnLoginpara ler a entrada do usuário para o login a partir do console. */
    Scanner scnSenha = new Scanner(System.in);
    /*Criação de outro objeto Scannerchamado scnSenhapara ler a entrada do usuário para a senha a partir do console.
     */
 try {
    /*Início de um bloco try, onde o código propenso a erros é colocado.
     */
    System.out.println("Bem vindo a alteração de senha.");
    /*Imprime uma mensagem  para o usuário no console. */
    System.out.println("Digite Seu login: ");
    /*Solicita ao usuário que digite seu login no console. */
    String strLogin = scnLogin.nextLine();
    /*Lê a entrada do usuário para o login usando o objeto scnLogin e armazena na variável strLogin. */
 System.out.println("Digite a senha que será alterada: ");
 /*Solicita ao usuário que digite uma senha para ser alterada. */
 String strSenha = scnSenha.nextLine();
 /*Lê a entrada do usuário para a senha usando o objeto scnSenhae armazenado na variável strSenha.*/
 System.out.println("Digite a nova senha : ");
 /*Solicita ao usuário que digite a nova senha. */
 String strNSenha = scnSenha.nextLine();
 /*Lê a entrada do usuário para uma nova senha usando o objeto scnSenhae armazenado na variável strNSenha. */
 String strInsertMySQL = "UPDATE `mysql_connector`.`tbl_login` SET `senha` = '" + strNSenha + "' WHERE (`login` = '" + strLogin + "')";
 /*Constrói uma string contendo um comando SQL para atualizar a senha na tabela tbl_login do banco de dados MySQL. */
 Connection conn = App.conectar();
 /*Chama um método conectar()na classe App para obter uma conexão com o banco de dados e armazenar na variável conn. */
 Statement stmSql = conn.createStatement();
 /*Cria um objeto Statement para executar consultas SQL na conexão conn. */
 stmSql.addBatch(strInsertMySQL);
 /*Adicionado o comando SQL ao lote de execução. O método addBatch()é usado quando você deseja executar várias instruções SQL em lote. */
 stmSql.executeBatch();
 /*Executa um lote de comandos SQL. */
 stmSql.close();
 status = "Ok!  Sua senha foi alterada com sucesso.";
 /*Atualiza a variável status para indicar que a senha foi alterada com sucesso. */
    }catch (Exception e) {
    /*Captura qualquer exceção que ocorra dentro do bloco try. */
        System.err.println("Ops! Ocorreu o erro " + e);
        /*Imprime uma mensagem de erro no console, indicando que ocorreu um erro junto com a descrição da exceção. */
}
/*Fim do bloco try-catch. */
scnSenha.close();
/*Fecha a variavel da senha */
System.out.println(status);
/*Imprime o status final (indicando se a senha foi alterada com sucesso ou se ocorreu um erro) no console. */
}
/*Encerra o metodo main */
}/*Encerra a classe Update  */
