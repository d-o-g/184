package jag.statics;

import jag.game.InterfaceComponent;
import jag.game.World;
import jag.game.client;
import jag.game.option.AttackOptionPriority;
import jag.game.scene.entity.PlayerEntity;
import jag.game.type.NpcDefinition;
import jag.script.ScriptEvent;
import jag.worldmap.WorldMapTileDecor_Sub1;

public class Statics9 {

    static void buildNpcMenu(NpcDefinition def, int index, int sceneX, int sceneY) {
        if (client.menuRowCount < 400) {
            if (def.transformIds != null) {
                def = def.transform();
            }

            if (def != null && def.aBoolean703 && (!def.aBoolean698 || client.anInt1053 == index)) {
                String menuDefinition = def.name;
                int var6;
                int opcode;
                if (def.combatLevel != 0) {
                    var6 = def.combatLevel;
                    opcode = PlayerEntity.local.combatLevel;
                    int var8 = opcode - var6;
                    String color;
                    if (var8 < -9) {
                        color = World.getColorTags(16711680);
                    } else if (var8 < -6) {
                        color = World.getColorTags(16723968);
                    } else if (var8 < -3) {
                        color = World.getColorTags(16740352);
                    } else if (var8 < 0) {
                        color = World.getColorTags(16756736);
                    } else if (var8 > 9) {
                        color = World.getColorTags(65280);
                    } else if (var8 > 6) {
                        color = World.getColorTags(4259584);
                    } else if (var8 > 3) {
                        color = World.getColorTags(8453888);
                    } else if (var8 > 0) {
                        color = World.getColorTags(12648192);
                    } else {
                        color = World.getColorTags(16776960);
                    }

                    menuDefinition = menuDefinition + color + " " + " (" + "level-" + def.combatLevel + ")";
                }

                if (def.aBoolean698 && client.aBoolean1042) {
                    WorldMapTileDecor_Sub1.insertMenuItem("Examine", World.getColorTags(16776960) + menuDefinition, 1003, index, sceneX, sceneY);
                }

                if (client.itemSelectionState == 1) {
                    WorldMapTileDecor_Sub1.insertMenuItem("Use", client.selectedItemName + " " + "->" + " " + World.getColorTags(16776960) + menuDefinition, 7, index, sceneX, sceneY);
                } else if (client.spellSelected) {
                    if ((client.spellTargetFlags & 2) == 2) {
                        WorldMapTileDecor_Sub1.insertMenuItem(client.selectedComponentAction, client.selectedSpellName + " " + "->" + " " + World.getColorTags(16776960) + menuDefinition, 8, index, sceneX, sceneY);
                    }
                } else {
                    int var10 = def.aBoolean698 && client.aBoolean1042 ? 2000 : 0;
                    String[] var12 = def.actions;
                    if (var12 != null) {
                        for (var6 = 4; var6 >= 0; --var6) {
                            if (var12[var6] != null && !var12[var6].equalsIgnoreCase("Attack")) {
                                opcode = 0;
                                if (var6 == 0) {
                                    opcode = var10 + 9;
                                }

                                if (var6 == 1) {
                                    opcode = var10 + 10;
                                }

                                if (var6 == 2) {
                                    opcode = var10 + 11;
                                }

                                if (var6 == 3) {
                                    opcode = var10 + 12;
                                }

                                if (var6 == 4) {
                                    opcode = var10 + 13;
                                }

                                WorldMapTileDecor_Sub1.insertMenuItem(var12[var6], World.getColorTags(16776960) + menuDefinition, opcode, index, sceneX, sceneY);
                            }
                        }
                    }

                    if (var12 != null) {
                        for (var6 = 4; var6 >= 0; --var6) {
                            if (var12[var6] != null && var12[var6].equalsIgnoreCase("Attack")) {
                                short var11 = 0;
                                if (client.npcAttackOptionPriority != AttackOptionPriority.anActionPrioritySetting330) {
                                    if (AttackOptionPriority.anActionPrioritySetting336 == client.npcAttackOptionPriority || AttackOptionPriority.anActionPrioritySetting333 == client.npcAttackOptionPriority && def.combatLevel > PlayerEntity.local.combatLevel) {
                                        var11 = 2000;
                                    }

                                    opcode = 0;
                                    if (var6 == 0) {
                                        opcode = var11 + 9;
                                    }

                                    if (var6 == 1) {
                                        opcode = var11 + 10;
                                    }

                                    if (var6 == 2) {
                                        opcode = var11 + 11;
                                    }

                                    if (var6 == 3) {
                                        opcode = var11 + 12;
                                    }

                                    if (var6 == 4) {
                                        opcode = var11 + 13;
                                    }

                                    WorldMapTileDecor_Sub1.insertMenuItem(var12[var6], World.getColorTags(16776960) + menuDefinition, opcode, index, sceneX, sceneY);
                                }
                            }
                        }
                    }

                    if (!def.aBoolean698 || !client.aBoolean1042) {
                        WorldMapTileDecor_Sub1.insertMenuItem("Examine", World.getColorTags(16776960) + menuDefinition, 1003, index, sceneX, sceneY);
                    }
                }

            }
        }
    }

    public static void method796(int var0) {
        if (var0 != -1) {
            if (InterfaceComponent.load(var0)) {
                InterfaceComponent[] var1 = client.interfaces[var0];

                for (InterfaceComponent var3 : var1) {
                    if (var3.anObjectArray1384 != null) {
                        ScriptEvent var4 = new ScriptEvent();
                        var4.source = var3;
                        var4.args = var3.anObjectArray1384;
                        ScriptEvent.process(var4, 5000000);
                    }
                }

            }
        }
    }
}
