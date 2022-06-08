package system.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoDAO {

    private String url = "jdbc:mysql://localhost:3306/lixoeletronico";
    private String user = "root";
    private String pass = "@Igor1337#";
    private Connection conn;

    public Connection conectar() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha ao conectar " + e);
        }
        return conn;
    }

    public Connection desconectar() {
        try {
            conn.close();
            System.out.println("Operacao concluida, conexao encerrada!");
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar " + e);
        }
        return conn;
    }
}
