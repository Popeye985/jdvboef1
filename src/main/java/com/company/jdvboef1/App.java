package com.company.jdvboef1;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String SELECT = "SELECT id, naam, prijs, prijs * 1.21 as prijsBTW from product";
    public static void main( String[] args ) throws SQLException {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useSSL=false&serverTimezone=Europe/Brussels", "root", "Vdab")){
            try(Statement select = conn.createStatement()){
                try(ResultSet rs = select.executeQuery(SELECT)){
                    while (rs.next()){
                        int id = rs.getInt("id");
                        String product = rs.getString("naam");
                        BigDecimal prijs = rs.getBigDecimal("prijs");
                        BigDecimal prijsBTW = rs.getBigDecimal("prijsBTW");
                        System.out.printf("%d: %s kost %.2f€ (%.2f incl btw) %n", id, product, prijs, prijsBTW);


                    }
                }

            }
        }

    }
}
