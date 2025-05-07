package net.toby.tutorialmod.entity.projectile.explosive.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FlamingChargeFireballEntity extends AbstractFireballEntity {
    private int explosionPower = 1;
    private int explosionCount = 0;


    public FlamingChargeFireballEntity(World world, LivingEntity owner, Vec3d velocity, int explosionPower) {
        super(EntityType.FIREBALL, owner, velocity, world);
        this.explosionPower = explosionPower;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.explosionCount++;
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), (float) this.explosionPower, true, World.ExplosionSourceType.TNT);
            if(explosionCount >= 5) {
                this.discard();
            }
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putByte("ExplosionPower", (byte) this.explosionPower);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("ExplosionPower", NbtElement.NUMBER_TYPE)) {
            this.explosionPower = nbt.getByte("ExplosionPower");
        }
    }
}
