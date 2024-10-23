package concavebark.beaconrings;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeaconRingsClient implements ClientModInitializer {
	public static final String MOD_ID = "beaconrings";

	public static final Logger CLIENT_LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		CLIENT_LOGGER.info("Beacon Rings Client Loading!");
	}
}