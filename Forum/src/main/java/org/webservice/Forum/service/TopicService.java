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
import org.webservice.Forum.model.Topic;

public class TopicService {

	public List<Topic> getAllTopics(int categoryId){
		
		List <Topic> listTopic = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.prepareStatement("SELECT * FROM topics WHERE fk_category_id = ?");
			statement.setInt(1, categoryId);
			result = statement.executeQuery();
			
			while(result.next()){
				Topic topic = new Topic();
				topic.setId(result.getInt("topic_id"));     
				topic.setName(result.getString("topic_name"));
				topic.setDate(result.getDate("creation_dt"));
				topic.setAuthor(result.getString("created_by"));
				listTopic.add(topic);
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
		
		if(listTopic.isEmpty()) {
			throw new DataNotFoundException("There are no topics in the category!");
		}
		
		return listTopic;
	}
	
	public Topic getTopic(int id) {
		
		Topic topic = new Topic();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.prepareStatement("SELECT * FROM topics WHERE topic_id = ?");
			statement.setLong(1, id);
			result = statement.executeQuery();
			
			while(result.next()){
				
				topic.setName(result.getString("topic_name"));
				topic.setDate(result.getDate("creation_dt"));
				topic.setId(result.getInt("topic_id"));
				topic.setAuthor(result.getString("created_by"));
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
		
		if((topic.getAuthor() == null) && (topic.getDate() == null) && (topic.getName() == null)) {
			throw new DataNotFoundException("There are no topics in the category!");
		}
		
		return topic;
	}
	
	public void addTopic(Topic topic, int categoryId) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.createStatement();
			String sql = "INSERT INTO topics (topic_name, created_by, fk_category_id) values ('" + topic.getName() + "', 'REST-webService', " + categoryId + ")";

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
	
	public void updateTopic(int topicId, Topic topic) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.createStatement();
			String sql = "UPDATE topics SET topic_name = '" + topic.getName() + "' WHERE topic_id = " + topicId + "";

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
	
	public void deleteTopic(int topicId) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.createStatement();
			String sql = "DELETE FROM topics WHERE topic_id = " + topicId + "";

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
