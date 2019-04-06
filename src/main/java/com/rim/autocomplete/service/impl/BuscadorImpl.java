package com.rim.autocomplete.service.impl;

import com.rim.autocomplete.model.Buscador;
import com.rim.autocomplete.service.BuscadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("buscadorService")
public class BuscadorImpl implements BuscadorService {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.dataSource = dataSource;

    }

    @Override
    public List<Buscador> getBuscador(String id) {
        ResultSet result = null;
        Connection con = null;
        PreparedStatement pst = null;

        ArrayList<Buscador> lists = new ArrayList<Buscador>();

        try {

            con = dataSource.getConnection();


            pst = con.prepareStatement("SELECT idproducto, nombre_producto, tipo FROM indice where nombre_producto like ? AND estatus = 0 order by nombre_producto limit 80;");
            pst.setString(1, "%" + id + "%");
            result = pst.executeQuery();

            while (result.next()) {

                Buscador list = new Buscador();

                list.setData(result.getInt(1));
                list.setValue(result.getString(2));

                lists.add(list);

            }

        } catch (SQLException e) {

            System.err.println("SQL exception: " + Arrays.toString(e.getStackTrace()));
            System.err.println("SQL exception: " + e.getMessage());
            System.err.println("SQL exception: " + e.getErrorCode());
            System.err.println("SQL exception: " + e.getSQLState());

        } catch (Exception e) {

            System.err.println("Exception: " + Arrays.toString(e.getStackTrace()));
            System.err.println("Exception: " + e.getMessage());

        } finally {

            try {

                if (result != null) {

                    result.close();

                }
                ;
                if (pst != null) {

                    pst.close();

                }
                ;
                if (con != null) {

                    con.close();

                }
                ;

            } catch (SQLException e) {

                System.err.println("SQL exception: " + Arrays.toString(e.getStackTrace()));
                System.err.println("SQL exception: " + e.getMessage());
                System.err.println("SQL exception: " + e.getErrorCode());
                System.err.println("SQL exception: " + e.getSQLState());
            }

        }

        return lists;
    }

}
