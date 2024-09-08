package turniplabs.examplemod.mixin;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityTNT;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeFancy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(value= Block.class,remap=false)
public abstract class BlocksMixin {


	public void onBlockDestroyedByExplosion(World world, int x, int y, int z) {
		int q = world.getBlockId(x, y-1, z);
		for (int i = -1; i <=1; i++) {
			for (int j = -1; j <=1; j++) {
				for (int k = -1; k <=1; k++) {
					world.setBlock(x+i, y+j, z+k, q);
				}
			}
		}
	}
}
