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

import org.webservice.Forum.model.Category;
import org.webservice.Forum.service.CategoryService;


@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {
	
	CategoryService myCategoryService = new CategoryService();

	@GET
	public List<Category> getAllCategories() {
		return myCategoryService.getAllCategories();
	}
	
	@GET
	@Path("/{categoryId}")
	public Category getCategory(@PathParam("categoryId") int categoryId) {
		return myCategoryService.getCategory(categoryId);
	}
	
	@POST
	public Category addCategory(Category category){
		myCategoryService.addCategory(category);
		return category;
	}
	
	@PUT
	@Path("/{categoryId}")
	public Category updateMessage(@PathParam("categoryId") int categoryId, Category category){
		myCategoryService.updateCategory(categoryId,category);
		category.setId(categoryId);
		return category;
	}
	
	@DELETE
	@Path("/{categoryId}")
	public void deleteMessage(@PathParam("categoryId") int categoryId){
		myCategoryService.deleteCategory(categoryId);
	}
	
	@Path("/{categoryId}/topics")
	public TopicResource getTopicResource(){
		return new TopicResource();
	}
}
