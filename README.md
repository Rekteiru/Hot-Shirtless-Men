# hot-shirtless-men (HSM)
Fixes bows and drills resetting on inventory update (video below)

Explanation:
  Minecraft has a bug which if two NBTs are even very slightly different it'll cause your current action to be broken, whether it being mining a block or pulling a bow.
This exact bug was fixed on vanilla 1.14.4+ and this is what my mod does, it instead of comparing the whole ItemStack (NBT) it compares only the essential parts needed to confirm if its the same item or not which prevents your drill from resetting when trying to glide and prevents your bow from being reset with any inventory update. (bows reset upon any inventory changes because they kinda have your whole inventory in their NBT since they need to identify arrows, drills only reset upon the actual item itself changing (aka fuel update))

tldr: it doesnt modify packets, it only fixes a vanilla bug that got fixed on 1.14.4+

Message me on discord if you need any help: rekterino

The drill code idea was mostly from RoseGold's Mobx Drill.
Bow code is mine.

Enjoy!

---USE AT YOUR OWN RISK, I AM NOT RESPONSIBLE IF YOU GET FLAGGED BY WATCHDOG (very low chance tbh)---

Known issues:
- Does not contain any rats (will add soonTM)
- It can sometimes crash while drawing a bow under very specific circumstances. (fixed on 1.0.4)
- If you swap between the same type of items while mining it wont reset the mining progress which is an unintended behaviour (fixed on 1.0.4)

Video showcase:
https://medal.tv/games/minecraft/clips/1yFeoNtRqKT-Co/d1337B3kQcIF?invite=cr-MSxsZjcsMTc2OTYwOTA4LA
