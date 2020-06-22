/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 */
package vazkii.botania.common.item;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import vazkii.botania.api.item.IAncientWillContainer;
import vazkii.botania.api.item.IFloatingFlower;
import vazkii.botania.api.mana.spark.SparkUpgradeType;
import vazkii.botania.api.state.enums.CratePattern;
import vazkii.botania.client.gui.bag.ContainerFlowerBag;
import vazkii.botania.client.gui.bag.GuiFlowerBag;
import vazkii.botania.client.gui.box.ContainerBaubleBox;
import vazkii.botania.client.gui.box.GuiBaubleBox;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.core.BotaniaCreativeTab;
import vazkii.botania.common.core.handler.ModSounds;
import vazkii.botania.common.crafting.FluxfieldCondition;
import vazkii.botania.common.crafting.FuzzyNBTIngredient;
import vazkii.botania.common.crafting.recipe.*;
import vazkii.botania.common.item.brew.ItemBrewBase;
import vazkii.botania.common.item.brew.ItemIncenseStick;
import vazkii.botania.common.item.brew.ItemVial;
import vazkii.botania.common.item.equipment.armor.elementium.ItemElementiumBoots;
import vazkii.botania.common.item.equipment.armor.elementium.ItemElementiumChest;
import vazkii.botania.common.item.equipment.armor.elementium.ItemElementiumHelm;
import vazkii.botania.common.item.equipment.armor.elementium.ItemElementiumLegs;
import vazkii.botania.common.item.equipment.armor.manasteel.ItemManasteelArmor;
import vazkii.botania.common.item.equipment.armor.manasteel.ItemManasteelHelm;
import vazkii.botania.common.item.equipment.armor.manaweave.ItemManaweaveArmor;
import vazkii.botania.common.item.equipment.armor.manaweave.ItemManaweaveHelm;
import vazkii.botania.common.item.equipment.armor.terrasteel.ItemTerrasteelArmor;
import vazkii.botania.common.item.equipment.armor.terrasteel.ItemTerrasteelHelm;
import vazkii.botania.common.item.equipment.bauble.*;
import vazkii.botania.common.item.equipment.tool.ItemEnderDagger;
import vazkii.botania.common.item.equipment.tool.ItemGlassPick;
import vazkii.botania.common.item.equipment.tool.ItemStarSword;
import vazkii.botania.common.item.equipment.tool.ItemThunderSword;
import vazkii.botania.common.item.equipment.tool.bow.ItemCrystalBow;
import vazkii.botania.common.item.equipment.tool.bow.ItemLivingwoodBow;
import vazkii.botania.common.item.equipment.tool.elementium.*;
import vazkii.botania.common.item.equipment.tool.manasteel.*;
import vazkii.botania.common.item.equipment.tool.terrasteel.ItemTerraAxe;
import vazkii.botania.common.item.equipment.tool.terrasteel.ItemTerraPick;
import vazkii.botania.common.item.equipment.tool.terrasteel.ItemTerraSword;
import vazkii.botania.common.item.interaction.thaumcraft.ItemElementiumHelmRevealing;
import vazkii.botania.common.item.interaction.thaumcraft.ItemManaInkwell;
import vazkii.botania.common.item.interaction.thaumcraft.ItemManasteelHelmRevealing;
import vazkii.botania.common.item.interaction.thaumcraft.ItemTerrasteelHelmRevealing;
import vazkii.botania.common.item.lens.*;
import vazkii.botania.common.item.material.*;
import vazkii.botania.common.item.record.ItemModRecord;
import vazkii.botania.common.item.relic.*;
import vazkii.botania.common.item.rod.*;
import vazkii.botania.common.lib.LibItemNames;
import vazkii.botania.common.lib.LibMisc;

import java.util.Locale;

import static vazkii.botania.common.block.ModBlocks.register;
import static vazkii.botania.common.lib.ResourceLocationHelper.prefix;

@ObjectHolder(LibMisc.MOD_ID)
public final class ModItems {
	@ObjectHolder(LibItemNames.LEXICON) public static Item lexicon;
	@ObjectHolder("white" + LibItemNames.PETAL_SUFFIX) public static Item whitePetal;
	@ObjectHolder("orange" + LibItemNames.PETAL_SUFFIX) public static Item orangePetal;
	@ObjectHolder("magenta" + LibItemNames.PETAL_SUFFIX) public static Item magentaPetal;
	@ObjectHolder("light_blue" + LibItemNames.PETAL_SUFFIX) public static Item lightBluePetal;
	@ObjectHolder("yellow" + LibItemNames.PETAL_SUFFIX) public static Item yellowPetal;
	@ObjectHolder("lime" + LibItemNames.PETAL_SUFFIX) public static Item limePetal;
	@ObjectHolder("pink" + LibItemNames.PETAL_SUFFIX) public static Item pinkPetal;
	@ObjectHolder("gray" + LibItemNames.PETAL_SUFFIX) public static Item grayPetal;
	@ObjectHolder("light_gray" + LibItemNames.PETAL_SUFFIX) public static Item lightGrayPetal;
	@ObjectHolder("cyan" + LibItemNames.PETAL_SUFFIX) public static Item cyanPetal;
	@ObjectHolder("purple" + LibItemNames.PETAL_SUFFIX) public static Item purplePetal;
	@ObjectHolder("blue" + LibItemNames.PETAL_SUFFIX) public static Item bluePetal;
	@ObjectHolder("brown" + LibItemNames.PETAL_SUFFIX) public static Item brownPetal;
	@ObjectHolder("green" + LibItemNames.PETAL_SUFFIX) public static Item greenPetal;
	@ObjectHolder("red" + LibItemNames.PETAL_SUFFIX) public static Item redPetal;
	@ObjectHolder("black" + LibItemNames.PETAL_SUFFIX) public static Item blackPetal;

	@ObjectHolder("white" + LibItemNames.DYE_SUFFIX) public static Item whiteDye;
	@ObjectHolder("orange" + LibItemNames.DYE_SUFFIX) public static Item orangeDye;
	@ObjectHolder("magenta" + LibItemNames.DYE_SUFFIX) public static Item magentaDye;
	@ObjectHolder("light_blue" + LibItemNames.DYE_SUFFIX) public static Item lightBlueDye;
	@ObjectHolder("yellow" + LibItemNames.DYE_SUFFIX) public static Item yellowDye;
	@ObjectHolder("lime" + LibItemNames.DYE_SUFFIX) public static Item limeDye;
	@ObjectHolder("pink" + LibItemNames.DYE_SUFFIX) public static Item pinkDye;
	@ObjectHolder("gray" + LibItemNames.DYE_SUFFIX) public static Item grayDye;
	@ObjectHolder("light_gray" + LibItemNames.DYE_SUFFIX) public static Item lightGrayDye;
	@ObjectHolder("cyan" + LibItemNames.DYE_SUFFIX) public static Item cyanDye;
	@ObjectHolder("purple" + LibItemNames.DYE_SUFFIX) public static Item purpleDye;
	@ObjectHolder("blue" + LibItemNames.DYE_SUFFIX) public static Item blueDye;
	@ObjectHolder("brown" + LibItemNames.DYE_SUFFIX) public static Item brownDye;
	@ObjectHolder("green" + LibItemNames.DYE_SUFFIX) public static Item greenDye;
	@ObjectHolder("red" + LibItemNames.DYE_SUFFIX) public static Item redDye;
	@ObjectHolder("black" + LibItemNames.DYE_SUFFIX) public static Item blackDye;

	@ObjectHolder(LibItemNames.PESTLE_AND_MORTAR) public static Item pestleAndMortar;
	@ObjectHolder(LibItemNames.TWIG_WAND) public static Item twigWand;

	@ObjectHolder(LibItemNames.MANASTEEL_INGOT) public static Item manaSteel;
	@ObjectHolder(LibItemNames.MANA_PEARL) public static Item manaPearl;
	@ObjectHolder(LibItemNames.MANA_DIAMOND) public static Item manaDiamond;
	@ObjectHolder(LibItemNames.LIVINGWOOD_TWIG) public static Item livingwoodTwig;
	@ObjectHolder(LibItemNames.TERRASTEEL_INGOT) public static Item terrasteel;
	@ObjectHolder(LibItemNames.LIFE_ESSENCE) public static Item lifeEssence;
	@ObjectHolder(LibItemNames.REDSTONE_ROOT) public static Item redstoneRoot;
	@ObjectHolder(LibItemNames.ELEMENTIUM_INGOT) public static Item elementium;
	@ObjectHolder(LibItemNames.PIXIE_DUST) public static Item pixieDust;
	@ObjectHolder(LibItemNames.DRAGONSTONE) public static Item dragonstone;
	@ObjectHolder(LibItemNames.PLACEHOLDER) public static Item placeholder;
	@ObjectHolder(LibItemNames.RED_STRING) public static Item redString;
	@ObjectHolder(LibItemNames.DREAMWOOD_TWIG) public static Item dreamwoodTwig;
	@ObjectHolder(LibItemNames.GAIA_INGOT) public static Item gaiaIngot;
	@ObjectHolder(LibItemNames.ENDER_AIR_BOTTLE) public static Item enderAirBottle;
	@ObjectHolder(LibItemNames.MANA_STRING) public static Item manaString;
	@ObjectHolder(LibItemNames.MANASTEEL_NUGGET) public static Item manasteelNugget;
	@ObjectHolder(LibItemNames.TERRASTEEL_NUGGET) public static Item terrasteelNugget;
	@ObjectHolder(LibItemNames.ELEMENTIUM_NUGGET) public static Item elementiumNugget;
	@ObjectHolder(LibItemNames.LIVING_ROOT) public static Item livingroot;
	@ObjectHolder(LibItemNames.PEBBLE) public static Item pebble;
	@ObjectHolder(LibItemNames.MANAWEAVE_CLOTH) public static Item manaweaveCloth;
	@ObjectHolder(LibItemNames.MANA_POWDER) public static Item manaPowder;

	@ObjectHolder(LibItemNames.LENS_NORMAL) public static Item lensNormal;
	@ObjectHolder(LibItemNames.LENS_SPEED) public static Item lensSpeed;
	@ObjectHolder(LibItemNames.LENS_POWER) public static Item lensPower;
	@ObjectHolder(LibItemNames.LENS_TIME) public static Item lensTime;
	@ObjectHolder(LibItemNames.LENS_EFFICIENCY) public static Item lensEfficiency;
	@ObjectHolder(LibItemNames.LENS_BOUNCE) public static Item lensBounce;
	@ObjectHolder(LibItemNames.LENS_GRAVITY) public static Item lensGravity;
	@ObjectHolder(LibItemNames.LENS_MINE) public static Item lensMine;
	@ObjectHolder(LibItemNames.LENS_DAMAGE) public static Item lensDamage;
	@ObjectHolder(LibItemNames.LENS_PHANTOM) public static Item lensPhantom;
	@ObjectHolder(LibItemNames.LENS_MAGNET) public static Item lensMagnet;
	@ObjectHolder(LibItemNames.LENS_EXPLOSIVE) public static Item lensExplosive;
	@ObjectHolder(LibItemNames.LENS_INFLUENCE) public static Item lensInfluence;
	@ObjectHolder(LibItemNames.LENS_WEIGHT) public static Item lensWeight;
	@ObjectHolder(LibItemNames.LENS_PAINT) public static Item lensPaint;
	@ObjectHolder(LibItemNames.LENS_FIRE) public static Item lensFire;
	@ObjectHolder(LibItemNames.LENS_PISTON) public static Item lensPiston;
	@ObjectHolder(LibItemNames.LENS_LIGHT) public static Item lensLight;
	@ObjectHolder(LibItemNames.LENS_WARP) public static Item lensWarp;
	@ObjectHolder(LibItemNames.LENS_REDIRECT) public static Item lensRedirect;
	@ObjectHolder(LibItemNames.LENS_FIREWORK) public static Item lensFirework;
	@ObjectHolder(LibItemNames.LENS_FLARE) public static Item lensFlare;
	@ObjectHolder(LibItemNames.LENS_MESSENGER) public static Item lensMessenger;
	@ObjectHolder(LibItemNames.LENS_TRIPWIRE) public static Item lensTripwire;
	@ObjectHolder(LibItemNames.LENS_STORM) public static Item lensStorm;

	@ObjectHolder(LibItemNames.RUNE_WATER) public static Item runeWater;
	@ObjectHolder(LibItemNames.RUNE_FIRE) public static Item runeFire;
	@ObjectHolder(LibItemNames.RUNE_EARTH) public static Item runeEarth;
	@ObjectHolder(LibItemNames.RUNE_AIR) public static Item runeAir;
	@ObjectHolder(LibItemNames.RUNE_SPRING) public static Item runeSpring;
	@ObjectHolder(LibItemNames.RUNE_SUMMER) public static Item runeSummer;
	@ObjectHolder(LibItemNames.RUNE_AUTUMN) public static Item runeAutumn;
	@ObjectHolder(LibItemNames.RUNE_WINTER) public static Item runeWinter;
	@ObjectHolder(LibItemNames.RUNE_MANA) public static Item runeMana;
	@ObjectHolder(LibItemNames.RUNE_LUST) public static Item runeLust;
	@ObjectHolder(LibItemNames.RUNE_GLUTTONY) public static Item runeGluttony;
	@ObjectHolder(LibItemNames.RUNE_GREED) public static Item runeGreed;
	@ObjectHolder(LibItemNames.RUNE_SLOTH) public static Item runeSloth;
	@ObjectHolder(LibItemNames.RUNE_WRATH) public static Item runeWrath;
	@ObjectHolder(LibItemNames.RUNE_ENVY) public static Item runeEnvy;
	@ObjectHolder(LibItemNames.RUNE_PRIDE) public static Item runePride;

	@ObjectHolder(LibItemNames.MANA_TABLET) public static Item manaTablet;
	@ObjectHolder(LibItemNames.MANA_GUN) public static Item manaGun;
	@ObjectHolder(LibItemNames.MANA_COOKIE) public static Item manaCookie;
	@ObjectHolder(LibItemNames.FERTILIZER) public static Item fertilizer;

	@ObjectHolder(LibItemNames.GRASS_SEEDS) public static Item grassSeeds;
	@ObjectHolder(LibItemNames.PODZOL_SEEDS) public static Item podzolSeeds;
	@ObjectHolder(LibItemNames.MYCEL_SEEDS) public static Item mycelSeeds;
	@ObjectHolder(LibItemNames.DRY_SEEDS) public static Item drySeeds;
	@ObjectHolder(LibItemNames.GOLDEN_SEEDS) public static Item goldenSeeds;
	@ObjectHolder(LibItemNames.VIVID_SEEDS) public static Item vividSeeds;
	@ObjectHolder(LibItemNames.SCORCHED_SEEDS) public static Item scorchedSeeds;
	@ObjectHolder(LibItemNames.INFUSED_SEEDS) public static Item infusedSeeds;
	@ObjectHolder(LibItemNames.MUTATED_SEEDS) public static Item mutatedSeeds;

	@ObjectHolder(LibItemNames.DIRT_ROD) public static Item dirtRod;
	@ObjectHolder(LibItemNames.TERRAFORM_ROD) public static Item terraformRod;
	@ObjectHolder(LibItemNames.GRASS_HORN) public static Item grassHorn;
	@ObjectHolder(LibItemNames.LEAVES_HORN) public static Item leavesHorn;
	@ObjectHolder(LibItemNames.SNOW_HORN) public static Item snowHorn;
	@ObjectHolder(LibItemNames.MANA_MIRROR) public static Item manaMirror;
	@ObjectHolder(LibItemNames.MANASTEEL_HELM) public static Item manasteelHelm;
	@ObjectHolder(LibItemNames.MANASTEEL_HELM_R) public static Item manasteelHelmRevealing;
	@ObjectHolder(LibItemNames.MANASTEEL_CHEST) public static Item manasteelChest;
	@ObjectHolder(LibItemNames.MANASTEEL_LEGS) public static Item manasteelLegs;
	@ObjectHolder(LibItemNames.MANASTEEL_BOOTS) public static Item manasteelBoots;
	@ObjectHolder(LibItemNames.MANASTEEL_PICK) public static Item manasteelPick;
	@ObjectHolder(LibItemNames.MANASTEEL_SHOVEL) public static Item manasteelShovel;
	@ObjectHolder(LibItemNames.MANASTEEL_AXE) public static Item manasteelAxe;
	@ObjectHolder(LibItemNames.MANASTEEL_SWORD) public static Item manasteelSword;
	@ObjectHolder(LibItemNames.MANASTEEL_SHEARS) public static Item manasteelShears;
	@ObjectHolder(LibItemNames.TERRASTEEL_HELM) public static Item terrasteelHelm;
	@ObjectHolder(LibItemNames.TERRASTEEL_HELM_R) public static Item terrasteelHelmRevealing;
	@ObjectHolder(LibItemNames.TERRASTEEL_CHEST) public static Item terrasteelChest;
	@ObjectHolder(LibItemNames.TERRASTEEL_LEGS) public static Item terrasteelLegs;
	@ObjectHolder(LibItemNames.TERRASTEEL_BOOTS) public static Item terrasteelBoots;
	@ObjectHolder(LibItemNames.TERRA_SWORD) public static Item terraSword;
	@ObjectHolder(LibItemNames.TERRA_PICK) public static Item terraPick;
	@ObjectHolder(LibItemNames.TERRA_AXE) public static Item terraAxe;
	@ObjectHolder(LibItemNames.TINY_PLANET) public static Item tinyPlanet;
	@ObjectHolder(LibItemNames.MANA_RING) public static Item manaRing;
	@ObjectHolder(LibItemNames.AURA_RING) public static Item auraRing;
	@ObjectHolder(LibItemNames.MANA_RING_GREATER) public static Item manaRingGreater;
	@ObjectHolder(LibItemNames.AURA_RING_GREATER) public static Item auraRingGreater;
	@ObjectHolder(LibItemNames.TRAVEL_BELT) public static Item travelBelt;
	@ObjectHolder(LibItemNames.KNOCKBACK_BELT) public static Item knockbackBelt;
	@ObjectHolder(LibItemNames.ICE_PENDANT) public static Item icePendant;
	@ObjectHolder(LibItemNames.LAVA_PENDANT) public static Item lavaPendant;
	@ObjectHolder(LibItemNames.MAGNET_RING) public static Item magnetRing;
	@ObjectHolder(LibItemNames.WATER_RING) public static Item waterRing;
	@ObjectHolder(LibItemNames.MINING_RING) public static Item miningRing;
	@ObjectHolder(LibItemNames.DIVA_CHARM) public static Item divaCharm;
	@ObjectHolder(LibItemNames.FLIGHT_TIARA) public static Item flightTiara;
	@ObjectHolder(LibItemNames.ENDER_DAGGER) public static Item enderDagger; // What you looking at?
	@ObjectHolder(LibItemNames.QUARTZ_DARK) public static Item darkQuartz;
	@ObjectHolder(LibItemNames.QUARTZ_MANA) public static Item manaQuartz;
	@ObjectHolder(LibItemNames.QUARTZ_BLAZE) public static Item blazeQuartz;
	@ObjectHolder(LibItemNames.QUARTZ_LAVENDER) public static Item lavenderQuartz;
	@ObjectHolder(LibItemNames.QUARTZ_RED) public static Item redQuartz;
	@ObjectHolder(LibItemNames.QUARTZ_ELVEN) public static Item elfQuartz;
	@ObjectHolder(LibItemNames.QUARTZ_SUNNY) public static Item sunnyQuartz;
	@ObjectHolder(LibItemNames.WATER_ROD) public static Item waterRod;
	@ObjectHolder(LibItemNames.ELEMENTIUM_HELM) public static Item elementiumHelm;
	@ObjectHolder(LibItemNames.ELEMENTIUM_HELM_R) public static Item elementiumHelmRevealing;
	@ObjectHolder(LibItemNames.ELEMENTIUM_CHEST) public static Item elementiumChest;
	@ObjectHolder(LibItemNames.ELEMENTIUM_LEGS) public static Item elementiumLegs;
	@ObjectHolder(LibItemNames.ELEMENTIUM_BOOTS) public static Item elementiumBoots;
	@ObjectHolder(LibItemNames.ELEMENTIUM_PICK) public static Item elementiumPick;
	@ObjectHolder(LibItemNames.ELEMENTIUM_SHOVEL) public static Item elementiumShovel;
	@ObjectHolder(LibItemNames.ELEMENTIUM_AXE) public static Item elementiumAxe;
	@ObjectHolder(LibItemNames.ELEMENTIUM_SWORD) public static Item elementiumSword;
	@ObjectHolder(LibItemNames.ELEMENTIUM_SHEARS) public static Item elementiumShears;
	@ObjectHolder(LibItemNames.OPEN_BUCKET) public static Item openBucket;
	@ObjectHolder(LibItemNames.SPAWNER_MOVER) public static Item spawnerMover;
	@ObjectHolder(LibItemNames.PIXIE_RING) public static Item pixieRing;
	@ObjectHolder(LibItemNames.SUPER_TRAVEL_BELT) public static Item superTravelBelt;
	@ObjectHolder(LibItemNames.RAINBOW_ROD) public static Item rainbowRod;
	@ObjectHolder(LibItemNames.TORNADO_ROD) public static Item tornadoRod;
	@ObjectHolder(LibItemNames.FIRE_ROD) public static Item fireRod;
	@ObjectHolder(LibItemNames.VINE_BALL) public static Item vineBall;
	@ObjectHolder(LibItemNames.SLINGSHOT) public static Item slingshot;
	@ObjectHolder(LibItemNames.MANA_BOTTLE) public static Item manaBottle;
	@ObjectHolder(LibItemNames.LAPUTA_SHARD) public static Item laputaShard;
	@ObjectHolder(LibItemNames.NECRO_VIRUS) public static Item necroVirus;
	@ObjectHolder(LibItemNames.NULL_VIRUS) public static Item nullVirus;
	@ObjectHolder(LibItemNames.REACH_RING) public static Item reachRing;
	@ObjectHolder(LibItemNames.SKY_DIRT_ROD) public static Item skyDirtRod;
	@ObjectHolder(LibItemNames.ITEM_FINDER) public static Item itemFinder;
	@ObjectHolder(LibItemNames.SUPER_LAVA_PENDANT) public static Item superLavaPendant;
	@ObjectHolder(LibItemNames.ENDER_HAND) public static Item enderHand;
	@ObjectHolder(LibItemNames.GLASS_PICK) public static Item glassPick;
	@ObjectHolder(LibItemNames.SPARK) public static Item spark;
	@ObjectHolder(LibItemNames.SPARK_UPGRADE + "_dispersive") public static Item sparkUpgradeDispersive;
	@ObjectHolder(LibItemNames.SPARK_UPGRADE + "_dominant") public static Item sparkUpgradeDominant;
	@ObjectHolder(LibItemNames.SPARK_UPGRADE + "_recessive") public static Item sparkUpgradeRecessive;
	@ObjectHolder(LibItemNames.SPARK_UPGRADE + "_isolated") public static Item sparkUpgradeIsolated;
	@ObjectHolder(LibItemNames.DIVINING_ROD) public static Item diviningRod;
	@ObjectHolder(LibItemNames.GRAVITY_ROD) public static Item gravityRod;
	@ObjectHolder(LibItemNames.MANA_INKWELL) public static Item manaInkwell;
	@ObjectHolder(LibItemNames.VIAL) public static Item vial;
	@ObjectHolder(LibItemNames.FLASK) public static Item flask;
	@ObjectHolder(LibItemNames.BREW_VIAL) public static Item brewVial;
	@ObjectHolder(LibItemNames.BREW_FLASK) public static Item brewFlask;
	@ObjectHolder(LibItemNames.BLOOD_PENDANT) public static Item bloodPendant;
	@ObjectHolder(LibItemNames.MISSILE_ROD) public static Item missileRod;
	@ObjectHolder(LibItemNames.HOLY_CLOAK) public static Item holyCloak;
	@ObjectHolder(LibItemNames.UNHOLY_CLOAK) public static Item unholyCloak;
	@ObjectHolder(LibItemNames.BALANCE_CLOAK) public static Item balanceCloak;
	@ObjectHolder(LibItemNames.CRAFTING_HALO) public static Item craftingHalo;
	@ObjectHolder(LibItemNames.BLACK_LOTUS) public static Item blackLotus;
	@ObjectHolder(LibItemNames.BLACKER_LOTUS) public static Item blackerLotus;
	@ObjectHolder(LibItemNames.MONOCLE) public static Item monocle;
	@ObjectHolder(LibItemNames.CLIP) public static Item clip;
	@ObjectHolder(LibItemNames.COBBLE_ROD) public static Item cobbleRod;
	@ObjectHolder(LibItemNames.SMELT_ROD) public static Item smeltRod;
	@ObjectHolder(LibItemNames.WORLD_SEED) public static Item worldSeed;
	@ObjectHolder(LibItemNames.SPELL_CLOTH) public static Item spellCloth;
	@ObjectHolder(LibItemNames.THORN_CHAKRAM) public static Item thornChakram;
	@ObjectHolder(LibItemNames.FLARE_CHAKRAM) public static Item flareChakram;
	@ObjectHolder(LibItemNames.OVERGROWTH_SEED) public static Item overgrowthSeed;
	@ObjectHolder(LibItemNames.CRAFT_PATTERN_PREFIX + "1_1") public static Item craftPattern1_1;
	@ObjectHolder(LibItemNames.CRAFT_PATTERN_PREFIX + "2_2") public static Item craftPattern2_2;
	@ObjectHolder(LibItemNames.CRAFT_PATTERN_PREFIX + "1_2") public static Item craftPattern1_2;
	@ObjectHolder(LibItemNames.CRAFT_PATTERN_PREFIX + "2_1") public static Item craftPattern2_1;
	@ObjectHolder(LibItemNames.CRAFT_PATTERN_PREFIX + "1_3") public static Item craftPattern1_3;
	@ObjectHolder(LibItemNames.CRAFT_PATTERN_PREFIX + "3_1") public static Item craftPattern3_1;
	@ObjectHolder(LibItemNames.CRAFT_PATTERN_PREFIX + "2_3") public static Item craftPattern2_3;
	@ObjectHolder(LibItemNames.CRAFT_PATTERN_PREFIX + "3_2") public static Item craftPattern3_2;
	@ObjectHolder(LibItemNames.CRAFT_PATTERN_PREFIX + "donut") public static Item craftPatternDonut;
	@ObjectHolder(LibItemNames.ANCIENT_WILL_PREFIX + "ahrim") public static Item ancientWillAhrim;
	@ObjectHolder(LibItemNames.ANCIENT_WILL_PREFIX + "dharok") public static Item ancientWillDharok;
	@ObjectHolder(LibItemNames.ANCIENT_WILL_PREFIX + "guthan") public static Item ancientWillGuthan;
	@ObjectHolder(LibItemNames.ANCIENT_WILL_PREFIX + "torag") public static Item ancientWillTorag;
	@ObjectHolder(LibItemNames.ANCIENT_WILL_PREFIX + "verac") public static Item ancientWillVerac;
	@ObjectHolder(LibItemNames.ANCIENT_WILL_PREFIX + "karil") public static Item ancientWillKaril;
	@ObjectHolder(LibItemNames.CORPOREA_SPARK) public static Item corporeaSpark;
	@ObjectHolder(LibItemNames.CORPOREA_SPARK_MASTER) public static Item corporeaSparkMaster;
	@ObjectHolder(LibItemNames.LIVINGWOOD_BOW) public static Item livingwoodBow;
	@ObjectHolder(LibItemNames.CRYSTAL_BOW) public static Item crystalBow;

	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "black_bowtie") public static Item blackBowtie;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "black_tie") public static Item blackTie;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "red_glasses") public static Item redGlasses;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "puffy_scarf") public static Item puffyScarf;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "engineer_goggles") public static Item engineerGoggles;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "eyepatch") public static Item eyepatch;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "wicked_eyepatch") public static Item wickedEyepatch;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "red_ribbons") public static Item redRibbons;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "pink_flower_bud") public static Item pinkFlowerBud;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "polka_dotted_bows") public static Item polkaDottedBows;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "blue_butterfly") public static Item blueButterfly;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "cat_ears") public static Item catEars;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "witch_pin") public static Item witchPin;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "devil_tail") public static Item devilTail;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "kamui_eye") public static Item kamuiEye;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "googly_eyes") public static Item googlyEyes;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "four_leaf_clover") public static Item fourLeafClover;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "clock_eye") public static Item clockEye;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "unicorn_horn") public static Item unicornHorn;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "devil_horns") public static Item devilHorns;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "hyper_plus") public static Item hyperPlus;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "botanist_emblem") public static Item botanistEmblem;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "ancient_mask") public static Item ancientMask;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "eerie_mask") public static Item eerieMask;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "alien_antenna") public static Item alienAntenna;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "anaglyph_glasses") public static Item anaglyphGlasses;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "orange_shades") public static Item orangeShades;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "groucho_glasses") public static Item grouchoGlasses;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "thick_eyebrows") public static Item thickEyebrows;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "lusitanic_shield") public static Item lusitanicShield;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "tiny_potato_mask") public static Item tinyPotatoMask;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "questgiver_mark") public static Item questgiverMark;
	@ObjectHolder(LibItemNames.COSMETIC_PREFIX + "thinking_hand") public static Item thinkingHand;

	@ObjectHolder(LibItemNames.SWAP_RING) public static Item swapRing;
	@ObjectHolder(LibItemNames.FLOWER_BAG) public static Item flowerBag;
	@ObjectHolder(LibItemNames.PHANTOM_INK) public static Item phantomInk;
	@ObjectHolder(LibItemNames.POOL_MINECART) public static Item poolMinecart;
	@ObjectHolder(LibItemNames.PINKINATOR) public static Item pinkinator;
	@ObjectHolder(LibItemNames.INFINITE_FRUIT) public static Item infiniteFruit;
	@ObjectHolder(LibItemNames.KING_KEY) public static Item kingKey;
	@ObjectHolder(LibItemNames.FLUGEL_EYE) public static Item flugelEye;
	@ObjectHolder(LibItemNames.THOR_RING) public static Item thorRing;
	@ObjectHolder(LibItemNames.ODIN_RING) public static Item odinRing;
	@ObjectHolder(LibItemNames.LOKI_RING) public static Item lokiRing;
	@ObjectHolder(LibItemNames.DICE) public static Item dice;
	@ObjectHolder(LibItemNames.KEEP_IVY) public static Item keepIvy;
	@ObjectHolder(LibItemNames.BLACK_HOLE_TALISMAN) public static Item blackHoleTalisman;
	@ObjectHolder(LibItemNames.RECORD_GAIA1) public static Item recordGaia1;
	@ObjectHolder(LibItemNames.RECORD_GAIA2) public static Item recordGaia2;
	@ObjectHolder(LibItemNames.TEMPERANCE_STONE) public static Item temperanceStone;
	@ObjectHolder(LibItemNames.INCENSE_STICK) public static Item incenseStick;
	@ObjectHolder(LibItemNames.WATER_BOWL) public static Item waterBowl;
	@ObjectHolder(LibItemNames.OBEDIENCE_STICK) public static Item obedienceStick;
	@ObjectHolder(LibItemNames.CACOPHONIUM) public static Item cacophonium;
	@ObjectHolder(LibItemNames.SLIME_BOTTLE) public static Item slimeBottle;
	@ObjectHolder(LibItemNames.STAR_SWORD) public static Item starSword;
	@ObjectHolder(LibItemNames.EXCHANGE_ROD) public static Item exchangeRod;
	@ObjectHolder(LibItemNames.MAGNET_RING_GREATER) public static Item magnetRingGreater;
	@ObjectHolder(LibItemNames.THUNDER_SWORD) public static Item thunderSword;
	@ObjectHolder(LibItemNames.MANAWEAVE_HELM) public static Item manaweaveHelm;
	@ObjectHolder(LibItemNames.MANAWEAVE_CHEST) public static Item manaweaveChest;
	@ObjectHolder(LibItemNames.MANAWEAVE_LEGS) public static Item manaweaveLegs;
	@ObjectHolder(LibItemNames.MANAWEAVE_BOOTS) public static Item manaweaveBoots;
	@ObjectHolder(LibItemNames.AUTOCRAFTING_HALO) public static Item autocraftingHalo;
	@ObjectHolder(LibItemNames.SEXTANT) public static Item sextant;
	@ObjectHolder(LibItemNames.SPEED_UP_BELT) public static Item speedUpBelt;
	@ObjectHolder(LibItemNames.BAUBLE_BOX) public static Item baubleBox;
	@ObjectHolder(LibItemNames.DODGE_RING) public static Item dodgeRing;
	@ObjectHolder(LibItemNames.INVISIBILITY_CLOAK) public static Item invisibilityCloak;
	@ObjectHolder(LibItemNames.CLOUD_PENDANT) public static Item cloudPendant;
	@ObjectHolder(LibItemNames.SUPER_CLOUD_PENDANT) public static Item superCloudPendant;
	@ObjectHolder(LibItemNames.THIRD_EYE) public static Item thirdEye;
	@ObjectHolder(LibItemNames.ASTROLABE) public static Item astrolabe;
	@ObjectHolder(LibItemNames.GODDESS_CHARM) public static Item goddessCharm;

	public static Item.Properties defaultBuilder() {
		return new Item.Properties().group(BotaniaCreativeTab.INSTANCE);
	}

	private static Item.Properties unstackable() {
		return defaultBuilder().maxStackSize(1);
	}

	public static void registerItems(RegistryEvent.Register<Item> evt) {
		IForgeRegistry<Item> r = evt.getRegistry();

		register(r, new ItemLexicon(unstackable().rarity(Rarity.UNCOMMON)), LibItemNames.LEXICON);
		for (DyeColor color : DyeColor.values()) {
			register(r, new ItemPetal(ModBlocks.getBuriedPetal(color), color, defaultBuilder()), color.getName() + LibItemNames.PETAL_SUFFIX);
			register(r, new ItemDye(color, defaultBuilder()), color.getName() + LibItemNames.DYE_SUFFIX);
		}
		register(r, new ItemSelfReturning(unstackable()), LibItemNames.PESTLE_AND_MORTAR);
		register(r, new ItemTwigWand(unstackable().rarity(Rarity.RARE)), LibItemNames.TWIG_WAND);
		register(r, new Item(defaultBuilder()), LibItemNames.MANASTEEL_INGOT);
		register(r, new Item(defaultBuilder()), LibItemNames.MANA_PEARL);
		register(r, new Item(defaultBuilder()), LibItemNames.MANA_DIAMOND);
		register(r, new Item(defaultBuilder()), LibItemNames.LIVINGWOOD_TWIG);
		register(r, new ItemManaResource(defaultBuilder()), LibItemNames.TERRASTEEL_INGOT);
		register(r, new Item(defaultBuilder()), LibItemNames.LIFE_ESSENCE);
		register(r, new Item(defaultBuilder()), LibItemNames.REDSTONE_ROOT);
		register(r, new ItemElven(defaultBuilder()), LibItemNames.ELEMENTIUM_INGOT);
		register(r, new ItemElven(defaultBuilder()), LibItemNames.PIXIE_DUST);
		register(r, new ItemElven(defaultBuilder()), LibItemNames.DRAGONSTONE);
		register(r, new ItemSelfReturning(defaultBuilder()), LibItemNames.PLACEHOLDER);
		register(r, new Item(defaultBuilder()), LibItemNames.RED_STRING);
		register(r, new Item(defaultBuilder()), LibItemNames.DREAMWOOD_TWIG);
		register(r, new ItemManaResource(defaultBuilder()), LibItemNames.GAIA_INGOT);
		register(r, new ItemEnderAir(defaultBuilder()), LibItemNames.ENDER_AIR_BOTTLE);
		register(r, new Item(defaultBuilder()), LibItemNames.MANA_STRING);
		register(r, new Item(defaultBuilder()), LibItemNames.MANASTEEL_NUGGET);
		register(r, new Item(defaultBuilder()), LibItemNames.TERRASTEEL_NUGGET);
		register(r, new Item(defaultBuilder()), LibItemNames.ELEMENTIUM_NUGGET);
		register(r, new ItemManaResource(defaultBuilder()), LibItemNames.LIVING_ROOT);
		register(r, new Item(defaultBuilder()), LibItemNames.PEBBLE);
		register(r, new Item(defaultBuilder()), LibItemNames.MANAWEAVE_CLOTH);
		register(r, new Item(defaultBuilder()), LibItemNames.MANA_POWDER);
		register(r, new ItemLens(unstackable(), new Lens(), ItemLens.PROP_NONE), LibItemNames.LENS_NORMAL);
		register(r, new ItemLens(unstackable(), new LensSpeed(), ItemLens.PROP_NONE), LibItemNames.LENS_SPEED);
		register(r, new ItemLens(unstackable(), new LensPower(), ItemLens.PROP_POWER), LibItemNames.LENS_POWER);
		register(r, new ItemLens(unstackable(), new LensTime(), ItemLens.PROP_NONE), LibItemNames.LENS_TIME);
		register(r, new ItemLens(unstackable(), new LensEfficiency(), ItemLens.PROP_NONE), LibItemNames.LENS_EFFICIENCY);
		register(r, new ItemLens(unstackable(), new LensBounce(), ItemLens.PROP_TOUCH), LibItemNames.LENS_BOUNCE);
		register(r, new ItemLens(unstackable(), new LensGravity(), ItemLens.PROP_ORIENTATION), LibItemNames.LENS_GRAVITY);
		register(r, new ItemLens(unstackable(), new LensMine(), ItemLens.PROP_TOUCH | ItemLens.PROP_ORIENTATION), LibItemNames.LENS_MINE);
		register(r, new ItemLens(unstackable(), new LensDamage(), ItemLens.PROP_DAMAGE), LibItemNames.LENS_DAMAGE);
		register(r, new ItemLens(unstackable(), new LensPhantom(), ItemLens.PROP_TOUCH), LibItemNames.LENS_PHANTOM);
		register(r, new ItemLens(unstackable(), new LensMagnet(), ItemLens.PROP_ORIENTATION), LibItemNames.LENS_MAGNET);
		register(r, new ItemLens(unstackable(), new LensExplosive(), ItemLens.PROP_DAMAGE | ItemLens.PROP_TOUCH | ItemLens.PROP_INTERACTION), LibItemNames.LENS_EXPLOSIVE);
		register(r, new ItemLens(unstackable(), new LensInfluence(), ItemLens.PROP_NONE), LibItemNames.LENS_INFLUENCE);
		register(r, new ItemLens(unstackable(), new LensWeight(), ItemLens.PROP_TOUCH | ItemLens.PROP_INTERACTION), LibItemNames.LENS_WEIGHT);
		register(r, new ItemLens(unstackable(), new LensPaint(), ItemLens.PROP_TOUCH | ItemLens.PROP_INTERACTION), LibItemNames.LENS_PAINT);
		register(r, new ItemLens(unstackable(), new LensFire(), ItemLens.PROP_DAMAGE | ItemLens.PROP_TOUCH | ItemLens.PROP_INTERACTION), LibItemNames.LENS_FIRE);
		register(r, new ItemLens(unstackable(), new LensPiston(), ItemLens.PROP_TOUCH | ItemLens.PROP_INTERACTION), LibItemNames.LENS_PISTON);
		register(r, new ItemLens(unstackable(), new LensLight(), ItemLens.PROP_TOUCH | ItemLens.PROP_INTERACTION), LibItemNames.LENS_LIGHT);
		register(r, new ItemLens(unstackable(), new LensWarp(), ItemLens.PROP_NONE), LibItemNames.LENS_WARP);
		register(r, new ItemLens(unstackable(), new LensRedirect(), ItemLens.PROP_TOUCH | ItemLens.PROP_INTERACTION), LibItemNames.LENS_REDIRECT);
		register(r, new ItemLens(unstackable(), new LensFirework(), ItemLens.PROP_TOUCH), LibItemNames.LENS_FIREWORK);
		register(r, new ItemLens(unstackable(), new LensFlare(), ItemLens.PROP_CONTROL), LibItemNames.LENS_FLARE);
		register(r, new ItemLens(unstackable(), new LensMessenger(), ItemLens.PROP_POWER), LibItemNames.LENS_MESSENGER);
		register(r, new ItemLens(unstackable(), new LensTripwire(), ItemLens.PROP_CONTROL), LibItemNames.LENS_TRIPWIRE);
		register(r, new ItemLens(unstackable(), new LensStorm(), ItemLens.PROP_NONE), LibItemNames.LENS_STORM);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_WATER);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_FIRE);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_EARTH);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_AIR);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_SPRING);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_SUMMER);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_AUTUMN);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_WINTER);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_MANA);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_LUST);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_GLUTTONY);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_GREED);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_SLOTH);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_WRATH);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_ENVY);
		register(r, new ItemRune(defaultBuilder()), LibItemNames.RUNE_PRIDE);
		register(r, new ItemManaTablet(unstackable()), LibItemNames.MANA_TABLET);
		register(r, new ItemManaGun(unstackable().setNoRepair()), LibItemNames.MANA_GUN);
		register(r, new ItemManaCookie(defaultBuilder().food(new Food.Builder().hunger(0).saturation(0.1F).effect(new EffectInstance(Effects.SATURATION, 20, 0), 1).build())), LibItemNames.MANA_COOKIE);
		register(r, new ItemFertilizer(defaultBuilder()), LibItemNames.FERTILIZER);
		register(r, new ItemGrassSeeds(IFloatingFlower.IslandType.GRASS, defaultBuilder()), LibItemNames.GRASS_SEEDS);
		register(r, new ItemGrassSeeds(IFloatingFlower.IslandType.PODZOL, defaultBuilder()), LibItemNames.PODZOL_SEEDS);
		register(r, new ItemGrassSeeds(IFloatingFlower.IslandType.MYCEL, defaultBuilder()), LibItemNames.MYCEL_SEEDS);
		register(r, new ItemGrassSeeds(IFloatingFlower.IslandType.DRY, defaultBuilder()), LibItemNames.DRY_SEEDS);
		register(r, new ItemGrassSeeds(IFloatingFlower.IslandType.GOLDEN, defaultBuilder()), LibItemNames.GOLDEN_SEEDS);
		register(r, new ItemGrassSeeds(IFloatingFlower.IslandType.VIVID, defaultBuilder()), LibItemNames.VIVID_SEEDS);
		register(r, new ItemGrassSeeds(IFloatingFlower.IslandType.SCORCHED, defaultBuilder()), LibItemNames.SCORCHED_SEEDS);
		register(r, new ItemGrassSeeds(IFloatingFlower.IslandType.INFUSED, defaultBuilder()), LibItemNames.INFUSED_SEEDS);
		register(r, new ItemGrassSeeds(IFloatingFlower.IslandType.MUTATED, defaultBuilder()), LibItemNames.MUTATED_SEEDS);
		register(r, new ItemDirtRod(unstackable()), LibItemNames.DIRT_ROD);
		register(r, new ItemTerraformRod(unstackable()), LibItemNames.TERRAFORM_ROD);
		register(r, new ItemHorn(unstackable()), LibItemNames.GRASS_HORN);
		register(r, new ItemHorn(unstackable()), LibItemNames.LEAVES_HORN);
		register(r, new ItemHorn(unstackable()), LibItemNames.SNOW_HORN);
		register(r, new ItemManaMirror(unstackable()), LibItemNames.MANA_MIRROR);
		register(r, new ItemManasteelHelm(unstackable()), LibItemNames.MANASTEEL_HELM);
		register(r, new ItemManasteelHelmRevealing(unstackable()), LibItemNames.MANASTEEL_HELM_R);
		register(r, new ItemManasteelArmor(EquipmentSlotType.CHEST, unstackable()), LibItemNames.MANASTEEL_CHEST);
		register(r, new ItemManasteelArmor(EquipmentSlotType.LEGS, unstackable()), LibItemNames.MANASTEEL_LEGS);
		register(r, new ItemManasteelArmor(EquipmentSlotType.FEET, unstackable()), LibItemNames.MANASTEEL_BOOTS);
		register(r, new ItemManasteelPick(unstackable()), LibItemNames.MANASTEEL_PICK);
		register(r, new ItemManasteelShovel(unstackable()), LibItemNames.MANASTEEL_SHOVEL);
		register(r, new ItemManasteelAxe(unstackable()), LibItemNames.MANASTEEL_AXE);
		register(r, new ItemManasteelSword(unstackable()), LibItemNames.MANASTEEL_SWORD);
		register(r, new ItemManasteelShears(unstackable()), LibItemNames.MANASTEEL_SHEARS);
		register(r, new ItemTerrasteelHelm(unstackable()), LibItemNames.TERRASTEEL_HELM);
		register(r, new ItemTerrasteelHelmRevealing(unstackable()), LibItemNames.TERRASTEEL_HELM_R);
		register(r, new ItemTerrasteelArmor(EquipmentSlotType.CHEST, unstackable()), LibItemNames.TERRASTEEL_CHEST);
		register(r, new ItemTerrasteelArmor(EquipmentSlotType.LEGS, unstackable()), LibItemNames.TERRASTEEL_LEGS);
		register(r, new ItemTerrasteelArmor(EquipmentSlotType.FEET, unstackable()), LibItemNames.TERRASTEEL_BOOTS);
		register(r, new ItemTerraSword(unstackable()), LibItemNames.TERRA_SWORD);
		register(r, new ItemTerraPick(unstackable()), LibItemNames.TERRA_PICK);
		register(r, new ItemTerraAxe(unstackable()), LibItemNames.TERRA_AXE);
		register(r, new ItemTinyPlanet(unstackable()), LibItemNames.TINY_PLANET);
		register(r, new ItemManaRing(unstackable()), LibItemNames.MANA_RING);
		register(r, new ItemAuraRing(unstackable()), LibItemNames.AURA_RING);
		register(r, new ItemGreaterManaRing(unstackable()), LibItemNames.MANA_RING_GREATER);
		register(r, new ItemGreaterAuraRing(unstackable()), LibItemNames.AURA_RING_GREATER);
		register(r, new ItemTravelBelt(unstackable()), LibItemNames.TRAVEL_BELT);
		register(r, new ItemKnockbackBelt(unstackable()), LibItemNames.KNOCKBACK_BELT);
		register(r, new ItemIcePendant(unstackable()), LibItemNames.ICE_PENDANT);
		register(r, new ItemLavaPendant(unstackable()), LibItemNames.LAVA_PENDANT);
		register(r, new ItemMagnetRing(unstackable()), LibItemNames.MAGNET_RING);
		register(r, new ItemWaterRing(unstackable()), LibItemNames.WATER_RING);
		register(r, new ItemMiningRing(unstackable()), LibItemNames.MINING_RING);
		register(r, new ItemDivaCharm(unstackable()), LibItemNames.DIVA_CHARM);
		register(r, new ItemFlightTiara(unstackable()), LibItemNames.FLIGHT_TIARA);
		register(r, new ItemEnderDagger(unstackable().defaultMaxDamage(69).setNoRepair()), LibItemNames.ENDER_DAGGER);
		register(r, new Item(defaultBuilder()), LibItemNames.QUARTZ_DARK);
		register(r, new Item(defaultBuilder()), LibItemNames.QUARTZ_MANA);
		register(r, new Item(defaultBuilder()), LibItemNames.QUARTZ_BLAZE);
		register(r, new Item(defaultBuilder()), LibItemNames.QUARTZ_LAVENDER);
		register(r, new Item(defaultBuilder()), LibItemNames.QUARTZ_RED);
		register(r, new Item(defaultBuilder()), LibItemNames.QUARTZ_ELVEN);
		register(r, new Item(defaultBuilder()), LibItemNames.QUARTZ_SUNNY);
		register(r, new ItemWaterRod(unstackable()), LibItemNames.WATER_ROD);
		register(r, new ItemElementiumHelm(unstackable()), LibItemNames.ELEMENTIUM_HELM);
		register(r, new ItemElementiumHelmRevealing(unstackable()), LibItemNames.ELEMENTIUM_HELM_R);
		register(r, new ItemElementiumChest(unstackable()), LibItemNames.ELEMENTIUM_CHEST);
		register(r, new ItemElementiumLegs(unstackable()), LibItemNames.ELEMENTIUM_LEGS);
		register(r, new ItemElementiumBoots(unstackable()), LibItemNames.ELEMENTIUM_BOOTS);
		register(r, new ItemElementiumPick(unstackable()), LibItemNames.ELEMENTIUM_PICK);
		register(r, new ItemElementiumShovel(unstackable()), LibItemNames.ELEMENTIUM_SHOVEL);
		register(r, new ItemElementiumAxe(unstackable()), LibItemNames.ELEMENTIUM_AXE);
		register(r, new ItemElementiumSword(unstackable()), LibItemNames.ELEMENTIUM_SWORD);
		register(r, new ItemElementiumShears(unstackable()), LibItemNames.ELEMENTIUM_SHEARS);
		register(r, new ItemOpenBucket(unstackable()), LibItemNames.OPEN_BUCKET);
		register(r, new ItemSpawnerMover(unstackable()), LibItemNames.SPAWNER_MOVER);
		register(r, new ItemPixieRing(unstackable()), LibItemNames.PIXIE_RING);
		register(r, new ItemSuperTravelBelt(unstackable()), LibItemNames.SUPER_TRAVEL_BELT);
		register(r, new ItemRainbowRod(unstackable()), LibItemNames.RAINBOW_ROD);
		register(r, new ItemTornadoRod(unstackable()), LibItemNames.TORNADO_ROD);
		register(r, new ItemFireRod(unstackable()), LibItemNames.FIRE_ROD);
		register(r, new ItemVineBall(defaultBuilder()), LibItemNames.VINE_BALL);
		register(r, new ItemSlingshot(unstackable()), LibItemNames.SLINGSHOT);
		register(r, new ItemBottledMana(unstackable()), LibItemNames.MANA_BOTTLE);
		register(r, new ItemLaputaShard(unstackable()), LibItemNames.LAPUTA_SHARD);
		register(r, new ItemVirus(defaultBuilder()), LibItemNames.NECRO_VIRUS);
		register(r, new ItemVirus(defaultBuilder()), LibItemNames.NULL_VIRUS);
		register(r, new ItemReachRing(unstackable()), LibItemNames.REACH_RING);
		register(r, new ItemSkyDirtRod(unstackable()), LibItemNames.SKY_DIRT_ROD);
		register(r, new ItemItemFinder(unstackable()), LibItemNames.ITEM_FINDER);
		register(r, new ItemSuperLavaPendant(unstackable()), LibItemNames.SUPER_LAVA_PENDANT);
		register(r, new ItemEnderHand(unstackable()), LibItemNames.ENDER_HAND);
		register(r, new ItemGlassPick(unstackable()), LibItemNames.GLASS_PICK);
		register(r, new ItemSpark(defaultBuilder()), LibItemNames.SPARK);
		register(r, new ItemSparkUpgrade(defaultBuilder(), SparkUpgradeType.DISPERSIVE), LibItemNames.SPARK_UPGRADE + "_" + SparkUpgradeType.DISPERSIVE.name().toLowerCase(Locale.ROOT));
		register(r, new ItemSparkUpgrade(defaultBuilder(), SparkUpgradeType.DOMINANT), LibItemNames.SPARK_UPGRADE + "_" + SparkUpgradeType.DOMINANT.name().toLowerCase(Locale.ROOT));
		register(r, new ItemSparkUpgrade(defaultBuilder(), SparkUpgradeType.RECESSIVE), LibItemNames.SPARK_UPGRADE + "_" + SparkUpgradeType.RECESSIVE.name().toLowerCase(Locale.ROOT));
		register(r, new ItemSparkUpgrade(defaultBuilder(), SparkUpgradeType.ISOLATED), LibItemNames.SPARK_UPGRADE + "_" + SparkUpgradeType.ISOLATED.name().toLowerCase(Locale.ROOT));
		register(r, new ItemDiviningRod(unstackable()), LibItemNames.DIVINING_ROD);
		register(r, new ItemGravityRod(unstackable()), LibItemNames.GRAVITY_ROD);
		register(r, new ItemManaInkwell(unstackable().setNoRepair()), LibItemNames.MANA_INKWELL);
		register(r, new ItemVial(defaultBuilder()), LibItemNames.VIAL);
		register(r, new ItemVial(defaultBuilder()), LibItemNames.FLASK);
		register(r, new ItemBrewBase(unstackable(), 4, 32, () -> vial), LibItemNames.BREW_VIAL);
		register(r, new ItemBrewBase(unstackable(), 6, 24, () -> flask), LibItemNames.BREW_FLASK);
		register(r, new ItemBloodPendant(unstackable()), LibItemNames.BLOOD_PENDANT);
		register(r, new ItemMissileRod(unstackable()), LibItemNames.MISSILE_ROD);
		register(r, new ItemHolyCloak(unstackable()), LibItemNames.HOLY_CLOAK);
		register(r, new ItemUnholyCloak(unstackable()), LibItemNames.UNHOLY_CLOAK);
		register(r, new ItemBalanceCloak(unstackable()), LibItemNames.BALANCE_CLOAK);
		register(r, new ItemCraftingHalo(unstackable()), LibItemNames.CRAFTING_HALO);
		register(r, new ItemBlackLotus(defaultBuilder()), LibItemNames.BLACK_LOTUS);
		register(r, new ItemBlackLotus(defaultBuilder()), LibItemNames.BLACKER_LOTUS);
		register(r, new ItemMonocle(unstackable()), LibItemNames.MONOCLE);
		register(r, new Item(unstackable()), LibItemNames.CLIP);
		register(r, new ItemCobbleRod(unstackable()), LibItemNames.COBBLE_ROD);
		register(r, new ItemSmeltRod(unstackable()), LibItemNames.SMELT_ROD);
		register(r, new ItemWorldSeed(defaultBuilder()), LibItemNames.WORLD_SEED);
		register(r, new ItemSpellCloth(unstackable().defaultMaxDamage(35).setNoRepair()), LibItemNames.SPELL_CLOTH);
		register(r, new ItemThornChakram(defaultBuilder().maxStackSize(6)), LibItemNames.THORN_CHAKRAM);
		register(r, new ItemThornChakram(defaultBuilder().maxStackSize(6)), LibItemNames.FLARE_CHAKRAM);
		register(r, new ItemOvergrowthSeed(defaultBuilder()), LibItemNames.OVERGROWTH_SEED);
		register(r, new ItemCraftPattern(CratePattern.CRAFTY_1_1, unstackable()), LibItemNames.CRAFT_PATTERN_PREFIX + "1_1");
		register(r, new ItemCraftPattern(CratePattern.CRAFTY_2_2, unstackable()), LibItemNames.CRAFT_PATTERN_PREFIX + "2_2");
		register(r, new ItemCraftPattern(CratePattern.CRAFTY_1_2, unstackable()), LibItemNames.CRAFT_PATTERN_PREFIX + "1_2");
		register(r, new ItemCraftPattern(CratePattern.CRAFTY_2_1, unstackable()), LibItemNames.CRAFT_PATTERN_PREFIX + "2_1");
		register(r, new ItemCraftPattern(CratePattern.CRAFTY_1_3, unstackable()), LibItemNames.CRAFT_PATTERN_PREFIX + "1_3");
		register(r, new ItemCraftPattern(CratePattern.CRAFTY_3_1, unstackable()), LibItemNames.CRAFT_PATTERN_PREFIX + "3_1");
		register(r, new ItemCraftPattern(CratePattern.CRAFTY_2_3, unstackable()), LibItemNames.CRAFT_PATTERN_PREFIX + "2_3");
		register(r, new ItemCraftPattern(CratePattern.CRAFTY_3_2, unstackable()), LibItemNames.CRAFT_PATTERN_PREFIX + "3_2");
		register(r, new ItemCraftPattern(CratePattern.CRAFTY_DONUT, unstackable()), LibItemNames.CRAFT_PATTERN_PREFIX + "donut");
		register(r, new ItemAncientWill(IAncientWillContainer.AncientWillType.AHRIM, unstackable()), LibItemNames.ANCIENT_WILL_PREFIX + "ahrim");
		register(r, new ItemAncientWill(IAncientWillContainer.AncientWillType.DHAROK, unstackable()), LibItemNames.ANCIENT_WILL_PREFIX + "dharok");
		register(r, new ItemAncientWill(IAncientWillContainer.AncientWillType.GUTHAN, unstackable()), LibItemNames.ANCIENT_WILL_PREFIX + "guthan");
		register(r, new ItemAncientWill(IAncientWillContainer.AncientWillType.TORAG, unstackable()), LibItemNames.ANCIENT_WILL_PREFIX + "torag");
		register(r, new ItemAncientWill(IAncientWillContainer.AncientWillType.VERAC, unstackable()), LibItemNames.ANCIENT_WILL_PREFIX + "verac");
		register(r, new ItemAncientWill(IAncientWillContainer.AncientWillType.KARIL, unstackable()), LibItemNames.ANCIENT_WILL_PREFIX + "karil");
		register(r, new ItemCorporeaSpark(defaultBuilder()), LibItemNames.CORPOREA_SPARK);
		register(r, new ItemCorporeaSpark(defaultBuilder()), LibItemNames.CORPOREA_SPARK_MASTER);
		register(r, new ItemLivingwoodBow(defaultBuilder().defaultMaxDamage(500)), LibItemNames.LIVINGWOOD_BOW);
		register(r, new ItemCrystalBow(defaultBuilder().defaultMaxDamage(500)), LibItemNames.CRYSTAL_BOW);

		for (ItemBaubleCosmetic.Variant v : ItemBaubleCosmetic.Variant.values()) {
			register(r, new ItemBaubleCosmetic(v, unstackable()), LibItemNames.COSMETIC_PREFIX + v.name().toLowerCase(Locale.ROOT));
		}

		register(r, new ItemSwapRing(unstackable()), LibItemNames.SWAP_RING);
		register(r, new ItemFlowerBag(unstackable()), LibItemNames.FLOWER_BAG);
		register(r, new Item(defaultBuilder()), LibItemNames.PHANTOM_INK);
		register(r, new ItemPoolMinecart(unstackable()), LibItemNames.POOL_MINECART);
		register(r, new ItemPinkinator(unstackable()), LibItemNames.PINKINATOR);
		register(r, new ItemInfiniteFruit(unstackable()), LibItemNames.INFINITE_FRUIT);
		register(r, new ItemKingKey(unstackable()), LibItemNames.KING_KEY);
		register(r, new ItemFlugelEye(unstackable()), LibItemNames.FLUGEL_EYE);
		register(r, new ItemThorRing(unstackable()), LibItemNames.THOR_RING);
		register(r, new ItemOdinRing(unstackable()), LibItemNames.ODIN_RING);
		register(r, new ItemLokiRing(unstackable()), LibItemNames.LOKI_RING);
		register(r, new ItemDice(unstackable()), LibItemNames.DICE);
		register(r, new ItemKeepIvy(defaultBuilder()), LibItemNames.KEEP_IVY);
		register(r, new ItemBlackHoleTalisman(unstackable()), LibItemNames.BLACK_HOLE_TALISMAN);
		register(r, new ItemModRecord(1, ModSounds.gaiaMusic1, unstackable()), LibItemNames.RECORD_GAIA1);
		register(r, new ItemModRecord(1, ModSounds.gaiaMusic2, unstackable()), LibItemNames.RECORD_GAIA2);
		register(r, new ItemTemperanceStone(unstackable()), LibItemNames.TEMPERANCE_STONE);
		register(r, new ItemIncenseStick(unstackable()), LibItemNames.INCENSE_STICK);
		register(r, new ItemWaterBowl(unstackable()), LibItemNames.WATER_BOWL);
		register(r, new ItemObedienceStick(unstackable()), LibItemNames.OBEDIENCE_STICK);
		register(r, new ItemCacophonium(unstackable()), LibItemNames.CACOPHONIUM);
		register(r, new ItemSlimeBottle(unstackable()), LibItemNames.SLIME_BOTTLE);
		register(r, new ItemStarSword(unstackable()), LibItemNames.STAR_SWORD);
		register(r, new ItemExchangeRod(unstackable()), LibItemNames.EXCHANGE_ROD);
		register(r, new ItemMagnetRing(unstackable(), 16), LibItemNames.MAGNET_RING_GREATER);
		register(r, new ItemThunderSword(unstackable()), LibItemNames.THUNDER_SWORD);
		register(r, new ItemManaweaveHelm(unstackable()), LibItemNames.MANAWEAVE_HELM);
		register(r, new ItemManaweaveArmor(EquipmentSlotType.CHEST, unstackable()), LibItemNames.MANAWEAVE_CHEST);
		register(r, new ItemManaweaveArmor(EquipmentSlotType.LEGS, unstackable()), LibItemNames.MANAWEAVE_LEGS);
		register(r, new ItemManaweaveArmor(EquipmentSlotType.FEET, unstackable()), LibItemNames.MANAWEAVE_BOOTS);
		register(r, new ItemAutocraftingHalo(unstackable()), LibItemNames.AUTOCRAFTING_HALO);
		register(r, new ItemSextant(unstackable()), LibItemNames.SEXTANT);
		register(r, new ItemSpeedUpBelt(unstackable()), LibItemNames.SPEED_UP_BELT);
		register(r, new ItemBaubleBox(unstackable()), LibItemNames.BAUBLE_BOX);
		register(r, new ItemDodgeRing(unstackable()), LibItemNames.DODGE_RING);
		register(r, new ItemInvisibilityCloak(unstackable()), LibItemNames.INVISIBILITY_CLOAK);
		register(r, new ItemCloudPendant(unstackable()), LibItemNames.CLOUD_PENDANT);
		register(r, new ItemSuperCloudPendant(unstackable()), LibItemNames.SUPER_CLOUD_PENDANT);
		register(r, new ItemThirdEye(unstackable()), LibItemNames.THIRD_EYE);
		register(r, new ItemAstrolabe(unstackable()), LibItemNames.ASTROLABE);
		register(r, new ItemGoddessCharm(unstackable()), LibItemNames.GODDESS_CHARM);
	}

	public static void registerRecipeSerializers(RegistryEvent.Register<IRecipeSerializer<?>> evt) {
		IForgeRegistry<IRecipeSerializer<?>> r = evt.getRegistry();
		register(r, AncientWillRecipe.SERIALIZER, "ancient_will_attach");
		register(r, ArmorUpgradeRecipe.SERIALIZER, "armor_upgrade");
		register(r, BannerRecipe.SERIALIZER, "banner_pattern_apply");
		register(r, BlackHoleTalismanExtractRecipe.SERIALIZER, "black_hole_talisman_extract");
		register(r, CompositeLensRecipe.SERIALIZER, "composite_lens");
		register(r, CosmeticAttachRecipe.SERIALIZER, "cosmetic_attach");
		register(r, CosmeticRemoveRecipe.SERIALIZER, "cosmetic_remove");
		register(r, HelmRevealingRecipe.SERIALIZER, "helm_revealing");
		register(r, KeepIvyRecipe.SERIALIZER, "keep_ivy");
		register(r, LensDyeingRecipe.SERIALIZER, "lens_dye");
		register(r, ManaGunClipRecipe.SERIALIZER, "mana_gun_add_clip");
		register(r, ManaGunLensRecipe.SERIALIZER, "mana_gun_add_lens");
		register(r, ManaGunRemoveLensRecipe.SERIALIZER, "mana_gun_remove_lens");
		register(r, ManaUpgradeRecipe.SERIALIZER, "mana_upgrade");
		register(r, ShapelessManaUpgradeRecipe.SERIALIZER, "mana_upgrade_shapeless");
		register(r, PhantomInkRecipe.SERIALIZER, "phantom_ink_apply");
		register(r, SpellClothRecipe.SERIALIZER, "spell_cloth_apply");
		register(r, TerraPickTippingRecipe.SERIALIZER, "terra_pick_tipping");
		register(r, TwigWandRecipe.SERIALIZER, "twig_wand");

		CraftingHelper.register(FluxfieldCondition.SERIALIZER);
		CraftingHelper.register(prefix("fuzzy_nbt"), FuzzyNBTIngredient.SERIALIZER);
	}

	public static void registerContainers(RegistryEvent.Register<ContainerType<?>> evt) {
		IForgeRegistry<ContainerType<?>> r = evt.getRegistry();

		ContainerType<ContainerFlowerBag> bag = IForgeContainerType.create(ContainerFlowerBag::fromNetwork);
		register(r, bag, flowerBag.getRegistryName());

		ContainerType<ContainerBaubleBox> box = IForgeContainerType.create(ContainerBaubleBox::fromNetwork);
		register(r, box, baubleBox.getRegistryName());

		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
			ScreenManager.registerFactory(bag, GuiFlowerBag::new);
			ScreenManager.registerFactory(box, GuiBaubleBox::new);
		});
	}

	public static Item getPetal(DyeColor color) {
		switch (color) {
		default:
		case WHITE:
			return whitePetal;
		case ORANGE:
			return orangePetal;
		case MAGENTA:
			return magentaPetal;
		case LIGHT_BLUE:
			return lightBluePetal;
		case YELLOW:
			return yellowPetal;
		case LIME:
			return limePetal;
		case PINK:
			return pinkPetal;
		case GRAY:
			return grayPetal;
		case LIGHT_GRAY:
			return lightGrayPetal;
		case CYAN:
			return cyanPetal;
		case PURPLE:
			return purplePetal;
		case BLUE:
			return bluePetal;
		case BROWN:
			return brownPetal;
		case GREEN:
			return greenPetal;
		case RED:
			return redPetal;
		case BLACK:
			return blackPetal;
		}
	}

	public static Item getDye(DyeColor color) {
		switch (color) {
		default:
		case WHITE:
			return whiteDye;
		case ORANGE:
			return orangeDye;
		case MAGENTA:
			return magentaDye;
		case LIGHT_BLUE:
			return lightBlueDye;
		case YELLOW:
			return yellowDye;
		case LIME:
			return limeDye;
		case PINK:
			return pinkDye;
		case GRAY:
			return grayDye;
		case LIGHT_GRAY:
			return lightGrayDye;
		case CYAN:
			return cyanDye;
		case PURPLE:
			return purpleDye;
		case BLUE:
			return blueDye;
		case BROWN:
			return brownDye;
		case GREEN:
			return greenDye;
		case RED:
			return redDye;
		case BLACK:
			return blackDye;
		}
	}
}
