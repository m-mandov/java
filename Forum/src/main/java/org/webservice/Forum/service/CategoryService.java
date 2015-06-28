package org.webservice.Forum.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.webservice.Forum.exception.DataNotFoundException;
import org.webservice.Forum.model.Category;


public class CategoryService {

	public List<Category> getAllCategories(){
		
		List <Category> listCategory = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM categories");
			
			while(result.next()){
				Category category = new Category();
				category.setId(result.getInt("category_id"));     
				category.setName(result.getString("category_name"));
				category.setDate(result.getDate("creation_dt"));
				category.setAuthor(result.getString("created_by"));
				listCategory.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(listCategory.isEmpty()) {
			throw new DataNotFoundException("There are no categories!");
		}
		
		return listCategory;
	}
	
	public Category getCategory(int id) {
		
		Category category = new Category();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.prepareStatement("SELECT * FROM categories WHERE category_id = ?");
			statement.setLong(1, id);
			result = statement.executeQuery();
			
			
			if(result.next()){
				category.setName(result.getString("category_name"));
				category.setDate(result.getDate("creation_dt"));
				category.setId(result.getInt("category_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if((category.getName() == null) && (category.getAuthor() == null) && (category.getDate() == null)) {
			throw new DataNotFoundException("Category with id " + id + " not found");
		}
		
		return category;
	}
	
	public void addCategory(Category category) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.createStatement();
			String sql = "INSERT INTO categories (category_name, created_by) values ('" + category.getName() + "', 'REST-webService')";

			statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.commit();
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateCategory(int categoryId, Category category) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.createStatement();
			String sql = "UPDATE categories SET category_name = '" + category.getName() + "' WHERE category_id = " + categoryId + "";

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteCategory(int categoryId) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.createStatement();
			String sql = "DELETE FROM categories WHERE category_id = " + categoryId + "";

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
