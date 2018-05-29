package com.myapp.access.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myapp.access.model.Document;

/**
 * Mapper for Document columns to object
 *
 * @author Pradnya Talekar
 * @date 21 May 2018
 */

public class DocumentMapper implements RowMapper<Document>{
	@Override
	public Document mapRow(ResultSet rs, int arg1) throws SQLException {
		Document document = new Document();
		document.setDocumentID(rs.getLong("DOCUMENT_ID"));
		document.setSchengenID(rs.getString("SCHENGEN_ID"));
		return document;
	}
}
