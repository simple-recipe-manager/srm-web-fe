package ly.whisk.resources;

import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ly.whisk.auth.SRMUser;
import ly.whisk.views.IndexView;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/")
public class IndexResource {

	public IndexResource() {

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Timed
	public IndexView getRoot(@Auth(required = false) SRMUser user) {

		return new IndexView(Optional.fromNullable(user));

	}
}
