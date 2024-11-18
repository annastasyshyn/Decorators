package ua.edu.ucu.apps.document;

import java.sql.*;

public class CachedDocument extends DocumentDecorator {
    private static final String URL_DB = "jdbc:sqlite:db";
    public CachedDocument(Document document) {
        super(document);
    }
    @Override
    public String parse(String path) {
        String query = "SELECT parsed_string FROM cache WHERE path = ?";
        String insertSQL = "INSERT INTO cache (path, parsed_string) VALUES (?, ?)";
        String parsedText = "";
        try (Connection connect = DriverManager.getConnection(URL_DB);
        PreparedStatement selectStmt = connect.prepareStatement(query);
        PreparedStatement insertStmt = connect.prepareStatement(insertSQL)) {
            selectStmt.setString(1, path);
            ResultSet rs = selectStmt.executeQuery();
            if (rs.next()) {
                parsedText = rs.getString("parsed_string");
            } else {
                parsedText = document.parse(path);
                insertStmt.setString(1, path);
                insertStmt.setString(2, parsedText);
                insertStmt.executeUpdate();
            }
            return parsedText;
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
        


        return parsedText != null ? parsedText : "";
    }
    
}
