package com.myapp.access.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.access.model.Document;

/**
 * {@link DocumentDao} implementation
 *
 * @author Pradnya Talekar
 * @date 17 May 2018
 */
@Repository("documentDao")
public class DocumentDaoImpl implements DocumentDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public Document getDocument(Long documentID) {

		Document document = null;
		try {

			document = jdbcTemplate.queryForObject("select * from documents where document_id = ?",
					new Object[] { documentID }, new DocumentMapper());
		} catch (DataAccessException e) {
			
		}	
		
		return document;		
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
