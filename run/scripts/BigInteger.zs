#priority 50
#loader crafttweaker reloadable

import mods.additionalapi.SaBigInteger;
import mods.additionalapi.SaWorldData;
import crafttweaker.event.PlayerInteractBlockEvent;
import crafttweaker.data.IData;

val a = "1";
val b = "2";
val c = "-3";
print(BigInteger.BigIntegerAdd("1","55"));



events.onPlayerRightClickBlock(function(event as PlayerInteractBlockEvent){
    val item = event.item;
    if(!event.world.remote&&!isNull(item)&&item.definition.id == "minecraft:stick"){
        val data1 as IData = {a:123};
        val data2 as IData = {b:"123"};
        WorldData.setArchiveData("AAA","ceshi",data1);
        print("/////////////////////////////////////////////");
        print(WorldData.getArchiveData("AAA","ceshi"));
        print(WorldData.getArchiveData("AAA","ceshia"));
    } 
});
