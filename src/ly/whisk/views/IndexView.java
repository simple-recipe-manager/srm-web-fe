package ly.whisk.views;

import ly.whisk.auth.SRMUser;

import com.google.common.base.Optional;

public class IndexView extends BaseView {

	private SRMUser user;

	public IndexView(Optional<SRMUser> optional) {
		super("index.ftl");
		this.user = optional.or(SRMUser.guestSupplier());

	}

	public SRMUser getUser() {
		return this.user;
	}
}
