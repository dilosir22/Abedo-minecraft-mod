package com.dilosir22.abedo.client.render.model;


import com.dilosir22.abedo.Abedo;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CockatriceModel extends AnimatedGeoModel{

	public ResourceLocation getAnimationFileLocation(Object entity)
	{
		return new ResourceLocation(Abedo.MOD_ID, "animations/cockatrice.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(Object entity)
	{
		return new ResourceLocation(Abedo.MOD_ID, "geo/Cockatrice.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(Object entity)
	{
		return new ResourceLocation(Abedo.MOD_ID, "textures/entities/cockatrice.png");
	}




}