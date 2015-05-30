package ly.whisk.resources;

import io.dropwizard.auth.Auth;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ly.whisk.auth.SRMUser;
import ly.whisk.storage.IRecipeStorage;
import ly.whisk.views.RecipeView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

@Path("/recipe/{id}")
@Produces(MediaType.TEXT_HTML)
public class RecipeResource {

	private Logger log = LoggerFactory.getLogger(RecipeResource.class);
	private final IRecipeStorage dao;

	public RecipeResource(IRecipeStorage dao) {
		this.dao = dao;
	}

	@GET
	public View getRecipe(@Auth(required = false) SRMUser user,
			@PathParam("id") String id) {
		try {
			return new RecipeView(Optional.fromNullable(user),
					dao.getRecipe(id));
		} catch (Exception e) {
			log.warn("Failed to fetch recipe", e);
			return null;
			// return new ErrorView("Sorry!");
		}
	}
}
