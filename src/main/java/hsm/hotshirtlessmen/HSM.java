package hsm.hotshirtlessmen;

import net.fabricmc.api.ModInitializer;

import net.minecraft.component.Component;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.nbt.NbtCompound;
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
							x |= 4;
						} else {
                            //LOGGER.info("{} : {} != {}", i.type().toString(), i.value().toString(), j.value().toString());
							x |= 1;
						}
					}
				}
			}
		}
		//HSM.LOGGER.info(String.valueOf(x));
		return ((x&2)==2 || ((x&4)==4 && compareUUIDs(component1,component2))) && (x&1)==0;
	}

	public static boolean compareUUIDs(ComponentMap map1, ComponentMap map2) {
		try {
			NbtCompound nbt1 = Objects.requireNonNull(map1.get(DataComponentTypes.CUSTOM_DATA)).copyNbt();
			NbtCompound nbt2 = Objects.requireNonNull(map2.get(DataComponentTypes.CUSTOM_DATA)).copyNbt();
			return nbt1.getString("UUID").equals(nbt2.getString("UUID"));
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return false;
		}
	}

}