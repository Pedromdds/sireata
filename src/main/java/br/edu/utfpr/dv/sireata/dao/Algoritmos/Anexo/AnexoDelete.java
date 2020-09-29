package br.edu.utfpr.dv.sireata.dao.Anexo;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.Algoritmos.deleteDAO;

public class AnexoDelete implements deleteDAO{

    @Override
    public void deletar(int value) throws SQLException {
        super.deletar(value);
    }

    public void excluir(int id) throws SQLException{
        Connection conn = null;
        Statement stmt = null;

        try{
            conn = ConnectionDAO.getInstance().getConnection();
            stmt = conn.createStatement();

            stmt.execute("DELETE FROM anexos WHERE idanexo=" + String.valueOf(id));
        }finally{
            if((stmt != null) && !stmt.isClosed())
                stmt.close();
            if((conn != null) && !conn.isClosed())
                conn.close();
        }
    }
}
