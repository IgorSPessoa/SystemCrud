package system.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import system.DTO.PedidosDTO;

public class PedidosDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PedidosDTO> lista = new ArrayList<>();

    public void cadastropedidos(PedidosDTO objpedidosdto) {
        String sql = "INSERT INTO pedidos (user_name, user_email, order_created, date_order, created_by, type_pedido, street, city, house_number) VALUES (?,?,?,?,?,?,?,?,?)";
        conn = new conexaoDAO().conectar();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpedidosdto.getNome());
            pstm.setString(2, objpedidosdto.getEmail());
            pstm.setString(3, objpedidosdto.getDatacriada());
            pstm.setString(4, objpedidosdto.getDatacoleta());
            pstm.setInt(5, objpedidosdto.getCriadopor());
            pstm.setString(6, objpedidosdto.getTipo());
            pstm.setString(7, objpedidosdto.getRua());
            pstm.setString(8, objpedidosdto.getCidade());
            pstm.setInt(9, objpedidosdto.getNumcasa());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro cadastar pedido" + erro);
            System.out.println(erro);

        }
    }

    public ArrayList<PedidosDTO> listarpedidos() {
        String sql = "select * from pedidos";
        conn = new conexaoDAO().conectar();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PedidosDTO objPedidosDTO = new PedidosDTO();
                objPedidosDTO.setId(rs.getInt("id"));
                objPedidosDTO.setNome(rs.getString("user_name"));
                objPedidosDTO.setEmail(rs.getString("user_email"));
                objPedidosDTO.setDatacriada(rs.getString("order_created"));
                objPedidosDTO.setDatacoleta(rs.getString("date_order"));
                objPedidosDTO.setCriadopor(rs.getInt("created_by"));
                objPedidosDTO.setRua(rs.getString("street"));
                objPedidosDTO.setCidade(rs.getString("city"));
                objPedidosDTO.setNumcasa(rs.getInt("house_number"));
                objPedidosDTO.setTipo(rs.getString("type_pedido"));
                lista.add(objPedidosDTO);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PedidosDTO ArrayList: " + erro);
            return null;
        }
        return lista;
    }

    public void updatepedido(PedidosDTO objpedidosdto) {
        String sql = "UPDATE pedidos set user_name = ?, user_email = ?,order_created = ?,date_order = ?, created_by = ?, type_pedido = ?,street = ?, city = ?,house_number = ?  WHERE id = ?";
        conn = new conexaoDAO().conectar();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpedidosdto.getNome());
            pstm.setString(2, objpedidosdto.getEmail());
            pstm.setString(3, objpedidosdto.getDatacriada());
            pstm.setString(4, objpedidosdto.getDatacoleta());
            pstm.setInt(5, objpedidosdto.getCriadopor());
            pstm.setString(6, objpedidosdto.getTipo());
            pstm.setString(7, objpedidosdto.getRua());
            pstm.setString(8, objpedidosdto.getCidade());
            pstm.setInt(9, objpedidosdto.getNumcasa());
            pstm.setInt(10, objpedidosdto.getId());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO updatepedido: " + erro);
        }
    }

    public void deletapedido(PedidosDTO objpedidosdto) {
        String sql = "DELETE from pedidos WHERE id = ?";
        conn = new conexaoDAO().conectar();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objpedidosdto.getId());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PedidosDAO deletapedido: " + erro);
        }
    }

    public ResultSet totalid() {
        conn = new conexaoDAO().conectar();
        String sql = "select id from pedidos";
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PedidosDAO totalid: " + erro);
            return null;
        }
    }

    public ResultSet tipos() {
        conn = new conexaoDAO().conectar();
        String sql = "select type_pedido from pedidos";
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PedidosDAO tipos: " + erro);
            return null;
        }
    }
}
