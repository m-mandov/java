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

import org.webservice.Forum.model.Topic;
import org.webservice.Forum.service.TopicService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TopicResource {
	
	TopicService myTopicService = new TopicService();
	
	@GET
	public List<Topic> getAllTopics(@PathParam("categoryId") int categoryId){
		return myTopicService.getAllTopics(categoryId);
	}
	
	@GET
	@Path("{topicId}")
	public Topic getTopic(@PathParam("topicId") int topicId){
		return myTopicService.getTopic(topicId);
	}
	
	@POST
	public Topic addTopic (@PathParam("categoryId") int categoryId, Topic topic){
		myTopicService.addTopic(topic,categoryId);
		return topic;
	}
	
	@PUT
	@Path("{topicId}")
	public Topic updateTopic(@PathParam("topicId") int topicId, Topic topic){
		myTopicService.updateTopic(topicId,topic);
		topic.setId(topicId);
		return topic;
	}
	
	@DELETE
	@Path("{topicId}")
	public void deleteTopic(@PathParam("topicId") int topicId){
		myTopicService.deleteTopic(topicId);
	}
	
	@Path("/{topicId}/posts")
	public PostResource getPostResource(){
		return new PostResource();
	}

}
