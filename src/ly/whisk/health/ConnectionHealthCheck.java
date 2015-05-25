package ly.whisk.health;

import com.codahale.metrics.health.HealthCheck;

public class ConnectionHealthCheck extends HealthCheck {

	public ConnectionHealthCheck() {
	}

	@Override
	protected Result check() throws Exception {

		return Result.healthy("I'm listening!");
	}

}
