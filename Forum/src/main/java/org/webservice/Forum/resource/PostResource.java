package org.webservice.Forum.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webservice.Forum.model.Post;
import org.webservice.Forum.service.PostService;

@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

PostService myPostService = new PostService();
	
	@GET
	public List<Post> getAllPosts(@PathParam("topicId") int topicId){
		return myPostService.getAllPosts(topicId);
	}
	
	@GET
	@Path("/{postId}")
	public Post getPost(@PathParam("postId") int postId){
		return myPostService.getPost(postId);
	}
	
	@POST
	public Post addPost (@PathParam("topicId") int topicId, Post post){
		myPostService.addPost(post,topicId);
		return post;
	}
	
	@PUT
	@Path("/{postId}")
	public Post updatePost(@PathParam("postId") int postId, Post post){
		myPostService.updatePost(postId,post);
		post.setId(postId);
		return post;
	}
	
	@DELETE
	@Path("/{postId}")
	public void deletePost(@PathParam("postId") int postId){
		myPostService.deletePost(postId);
	}
}
