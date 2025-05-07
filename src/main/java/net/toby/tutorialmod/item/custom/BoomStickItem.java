package net.toby.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.toby.tutorialmod.entity.projectile.explosive.custom.FlamingChargeFireballEntity;

public class BoomStickItem extends Item {
    public BoomStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        /*
        if(!world.isClient()) {
            int i = 5;
            while(i > 0) {
                Vec3d explosionPos = user.raycast(100.0, 0f, false).getPos();
                world.createExplosion(null,
                        explosionPos.getX(),
                        explosionPos.getY(),
                        explosionPos.getZ(),
                        3, World.ExplosionSourceType.TNT);
                i--;
            }
        }

         */
        if(!world.isClient) {
            int explosionStrength = 3;

            double e = 2.0;
            double velocity = 0.01;
            Vec3d vec3d = user.getRotationVec(1.0F);
            Vec3d explosionPos = user.raycast(100.0, 0f, false).getPos();
            double f = explosionPos.getX() - (user.getX() + vec3d.x * e);
            double g = explosionPos.getY() - (0.5 + user.getBodyY(0.5));
            double h = explosionPos.getZ() - (user.getZ() + vec3d.z * e);
            Vec3d vec3d2 = new Vec3d(f, g, h);
            Vec3d vec3d3 = new Vec3d(vec3d2.normalize().getX() * velocity, vec3d2.normalize().getY() * velocity, vec3d2.normalize().getZ() * velocity);

            FlamingChargeFireballEntity fireballEntity = new FlamingChargeFireballEntity(world, user, vec3d3, explosionStrength);
            fireballEntity.setPosition(user.getX() + vec3d.x * e, user.getBodyY(0.5) + 0.5, fireballEntity.getZ() + vec3d.z * e);
            world.spawnEntity(fireballEntity);
        }
        return super.use(world, user, hand);
    }
}
