package system.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import system.DTO.FuncionarioDTO;

public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> lista = new ArrayList<>();

    public void cadastrofuncionario(FuncionarioDTO objFuncionarioDTO) {
        String sql = "INSERT INTO administracao (user_name, user_email, user_password, user_type) VALUES (?,?,?,?)";
        conn = new conexaoDAO().conectar();
        String email = objFuncionarioDTO.getEmail();
        String erro_email = "java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '" + email + "' for key 'clientes.user_email'";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objFuncionarioDTO.getNome());
            pstm.setString(2, objFuncionarioDTO.getEmail());
            pstm.setString(3, objFuncionarioDTO.getSenha());
            pstm.setString(4, objFuncionarioDTO.getTipo());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            if (erro_email.equals(erro.toString())) {
                JOptionPane.showMessageDialog(null, "Erro cadastar funcionario, Email em uso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro cadastar funcionario" + erro);
            }
        }
    }

    public ArrayList<FuncionarioDTO> listarfuncionario() {
        String sql = "select * from administracao";
        conn = new conexaoDAO().conectar();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
                objFuncionarioDTO.setId(rs.getInt("id"));
                objFuncionarioDTO.setNome(rs.getString("user_name"));
                objFuncionarioDTO.setEmail(rs.getString("user_email"));
                objFuncionarioDTO.setSenha(rs.getString("user_password"));
                objFuncionarioDTO.setTipo(rs.getString("user_type"));
                lista.add(objFuncionarioDTO);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO ArrayList: " + erro);
            return null;
        }
        return lista;
    }

    public void updatefuncionario(FuncionarioDTO objFuncionarioDTO) {
        String sql = "UPDATE administracao set user_name = ?, user_email = ?, user_password = ?, user_type = ? WHERE id=?";
        conn = new conexaoDAO().conectar();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objFuncionarioDTO.getNome());
            pstm.setString(2, objFuncionarioDTO.getEmail());
            pstm.setString(3, objFuncionarioDTO.getSenha());
            pstm.setString(4, objFuncionarioDTO.getTipo());
            pstm.setInt(5, objFuncionarioDTO.getId());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO UPDATE: " + erro);
        }
    }

    public void deletafuncionario(FuncionarioDTO objFuncionarioDTO) {
        String sql = "DELETE from administracao WHERE id = ?";
        conn = new conexaoDAO().conectar();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objFuncionarioDTO.getId());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO deletafuncionario: " + erro);
        }
    }
}
