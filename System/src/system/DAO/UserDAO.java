package system.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import system.DTO.UserDTO;

public class UserDAO {

    Connection conn;

    public ResultSet autenticacaoUser(UserDTO objUserDTO) {
        conn = new conexaoDAO().conectar();

        try {
            String sql = "select * from administracao where user_email = ? and user_password = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objUserDTO.getUser_email());
            pstm.setString(2, objUserDTO.getUser_senha());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UserDAO: " + erro);
            return null;
        }
    }

}
