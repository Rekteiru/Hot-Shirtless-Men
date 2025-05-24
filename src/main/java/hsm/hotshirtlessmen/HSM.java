package hsm.hotshirtlessmen;

import net.fabricmc.api.ModInitializer;

import net.minecraft.component.Component;
import net.minecraft.component.ComponentMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class HSM implements ModInitializer {
	public static final String MOD_ID = "hotshirtlessmen";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("HSM rat injected!");
	}

	public static boolean compareComponents(ComponentMap component1, ComponentMap component2) {
		// bit flags:
		// 1st digit -> if any other tag was different
		// 2nd digit -> DAMAGE
		// 3rd digit -> CUSTOM_DATA
		byte x = 0;

		for (Component<?> i : component1) {
			for (Component<?> j : component2) {
				if (i.type() == j.type()) {
					if (!Objects.equals(i.value().toString(), j.value().toString())) {
						if (i.type().toString().equals("minecraft:damage")) {
							x |= 2;
						} else if (i.type().toString().equals("minecraft:custom_data")) {
							HSM.LOGGER.info(i.value().toString());
							HSM.LOGGER.info(j.value().toString());
							x |= (byte) (compareUUIDs(i.value().toString(),j.value().toString()) ? 4 : 0);
						} else {
                            //LOGGER.info("{} : {} != {}", i.type().toString(), i.value().toString(), j.value().toString());
							x |= 1;
						}
					}
				}
			}
		}
		//HSM.LOGGER.info(String.valueOf(x));
		return ((x&2)==2 || (x&4)==4) && (x&1)==0;
	}

	public static boolean compareUUIDs(String str1, String str2) {
		try {
			return getUUID(str1).equals(getUUID(str2)) && getUUID(str1).length() > 30;
		} catch (Exception e) {
			LOGGER.error(String.valueOf(e));
			return false;
		}
	}

	private static String getUUID(String str) {
		if (str.contains("uuid:")) {
			int i = str.indexOf("uuid:")+7;
			int e = str.indexOf("\"",i);
			str = e > 30 ? str.substring(i,e) : str;
		}
		return str;
	}

}