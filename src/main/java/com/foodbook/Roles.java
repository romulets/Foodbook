package com.foodbook;

import java.sql.Connection; 
import java.sql.SQLException; 
 
import javax.sql.DataSource; 
 
import org.junit.Before; 
import org.junit.runner.RunWith; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.core.io.ClassPathResource; 
import org.springframework.jdbc.datasource.DataSourceUtils; 
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator; 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
import org.springframework.transaction.annotation.Transactional; 

public class Roles {

	@RunWith(SpringJUnit4ClassRunner.class) 
	@Transactional 
	public abstract class AbstractIntegrationTest { 
	 
	 @Autowired 
	 DataSource dataSource; 
	 
	 /**
	  * Populates the configured {@link DataSource} with data from {@code data.sql}. 
	  *  
	  * @throws SQLException 
	  */ 
	 @Before 
	 public void populateDatabase() throws SQLException { 
	 
	  ResourceDatabasePopulator populator = new ResourceDatabasePopulator(); 
	  populator.addScript(new ClassPathResource("import.sql")); 
	 
	  Connection connection = null; 
	 
	  try { 
	   connection = DataSourceUtils.getConnection(dataSource); 
	   populator.populate(connection); 
	  } finally { 
	   if (connection != null) { 
	    DataSourceUtils.releaseConnection(connection, dataSource); 
	   } 
	  } 
	 } 
	}
}
