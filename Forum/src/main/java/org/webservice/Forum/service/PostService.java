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
import org.webservice.Forum.model.Post;

public class PostService {

	public List<Post> getAllPosts(int topicId){
		
		List <Post> listPost = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.prepareStatement("SELECT * FROM posts WHERE fk_topic_id = ?");
			statement.setLong(1, topicId);
			result = statement.executeQuery();
			
			while(result.next()){
				Post post = new Post();
				post.setId(result.getInt("post_id"));     
				post.setContent(result.getString("post_content"));
				post.setDate(result.getDate("creation_dt"));
				post.setAuthor(result.getString("created_by"));
				listPost.add(post);
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
		
		if(listPost.isEmpty()) {
			throw new DataNotFoundException("There are no posts in the topic!");
		}
		
		return listPost;
	}
	
	public Post getPost(int id) {
		
		Post post = new Post();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.prepareStatement("SELECT * FROM posts WHERE post_id = ?");
			statement.setLong(1, id);
			result = statement.executeQuery();
			
			while(result.next()){
				
				post.setContent(result.getString("post_content"));
				post.setDate(result.getDate("creation_dt"));
				post.setId(result.getInt("post_id"));
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
		
		if((post.getContent() == null) && (post.getAuthor() == null) && (post.getDate() == null)) {
			throw new DataNotFoundException("No post with " + id + " found!");
		}
		
		return post;
	}
	
	public boolean addPost(Post post, int topicId) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.createStatement();
			String sql = "INSERT INTO posts (post_content, created_by, fk_topic_id) values ('" + post.getContent() + "', 'REST-webService', " + topicId + ")";

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
		return true;
	}
	
	public void updatePost(int postId, Post post) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.createStatement();
			String sql = "UPDATE posts SET post_content = '" + post.getContent() + "' WHERE post_id = " + postId + "";

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
	
	public void deletePost(int postId) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","admin");
			statement = connection.createStatement();
			String sql = "DELETE FROM posts WHERE post_id = " + postId + "";

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
