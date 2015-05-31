package ly.whisk.auth;

import com.amazonaws.services.cognitosync.AmazonCognitoSyncClient;
import com.google.common.base.Supplier;

public class SRMUser {

	private String firstName;
	private String lastName;

	public SRMUser(AuthHolder holder) {
		this.firstName = holder.getCognitoId();
		
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected SRMUser() {
		this.firstName = "Guest";
	}

	public static Supplier<SRMUser> guestSupplier() {
		return new Supplier<SRMUser>() {

			@Override
			public SRMUser get() {
				return new SRMUser();
			}
		};

	}
}
