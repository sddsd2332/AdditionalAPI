#priority 50
#loader contenttweaker

import mods.contenttweaker.VanillaFactory;
import mods.contenttweaker.Block;


RegGlassBlock("quantumglass");

function RegGlassBlock(regName as string) {
    var block as Block = VanillaFactory.createBlock(regName, <blockmaterial:glass>);
    block.blockLayer = "CUTOUT";
    block.lightOpacity = 0;
    block.fullBlock = false;
    block.blockHardness = 3.0;
    block.blockResistance = 5.0;
    block.blockSoundType = <soundtype:glass>;
    block.creativeTab = <creativetab:buildingBlocks>;
    block.toolClass = "pickaxe";
    block.toolLevel = 2;
    block.register();
}