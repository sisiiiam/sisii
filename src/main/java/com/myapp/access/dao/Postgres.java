package com.myapp.access.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Postgres {
   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      try {
         //Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "postgres");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM documents;" );
         while ( rs.next() ) {
            int document_id = rs.getInt("document_id");
            String  schengen_id = rs.getString("schengen_id");
            
            System.out.println( "DOCUMENT_ID = " + document_id );
            System.out.println( "SCHENGEN_ID = " + schengen_id );
            
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");
   }
}