package ly.whisk.views;

import io.dropwizard.views.View;

public abstract class BaseView extends View {

	protected BaseView(String templateName) {
		super(templateName);
	}

}
