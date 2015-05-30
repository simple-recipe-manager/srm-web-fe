package ly.whisk.views;

import ly.whisk.auth.SRMUser;

import com.google.common.base.Optional;

public class IndexView extends BaseView {

	public IndexView(Optional<SRMUser> optional) {
		super("index.ftl", optional);

	}
}
