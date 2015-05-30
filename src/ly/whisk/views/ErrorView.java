package ly.whisk.views;

import io.dropwizard.views.View;

public class ErrorView extends View {

	public ErrorView(String errorText) {
		super("error.ftl");
	}

}
