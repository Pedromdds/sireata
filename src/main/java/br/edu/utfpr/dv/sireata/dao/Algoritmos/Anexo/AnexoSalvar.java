package br.edu.utfpr.dv.sireata.dao.Anexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.Algoritmos.saveDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoSalvar implements saveDAO<Anexo>{
    public int salvar(Anexo anexo) throws SQLException{
        boolean insert = (anexo.getIdAnexo() == 0);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = ConnectionDAO.getInstance().getConnection();

            if(insert){
                stmt = conn.prepareStatement("INSERT INTO anexos(idAta, ordem, descricao, arquivo) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            }else{
                stmt = conn.prepareStatement("UPDATE anexos SET idAta=?, ordem=?, descricao=?, arquivo=? WHERE idAnexo=?");
            }

            stmt.setInt(1, anexo.getAta().getIdAta());
            stmt.setInt(2, anexo.getOrdem());
            stmt.setString(3, anexo.getDescricao());
            stmt.setBytes(4, anexo.getArquivo());

            if(!insert){
                stmt.setInt(5, anexo.getIdAnexo());
            }

            stmt.execute();

            if(insert){
                rs = stmt.getGeneratedKeys();

                if(rs.next()){
                    anexo.setIdAnexo(rs.getInt(1));
                }
            }

            return anexo.getIdAnexo();
        }finally{
            if((rs != null) && !rs.isClosed())
                rs.close();
            if((stmt != null) && !stmt.isClosed())
                stmt.close();
            if((conn != null) && !conn.isClosed())
                conn.close();
        }
    }
}
