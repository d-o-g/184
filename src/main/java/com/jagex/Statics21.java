package com.jagex;

public class Statics21 {
    public static DoublyLinkedNode_Sub21 method923(int var0) {
        DoublyLinkedNode_Sub21 var1 = (DoublyLinkedNode_Sub21) DoublyLinkedNode_Sub21.aReferenceCache700.get((long) var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = DoublyLinkedNode_Sub21.aReferenceTable383.unpack(3, var0);
        var1 = new DoublyLinkedNode_Sub21();
        if (var2 != null) {
            var1.method990(new Buffer(var2));
        }

        DoublyLinkedNode_Sub21.aReferenceCache700.put(var1, (long) var0);
        return var1;
    }

    static int method922(InterfaceComponent var0, int var1) {
        if (var0.functionOpcodes != null && var1 < var0.functionOpcodes.length) {
            try {
                int[] var2 = var0.functionOpcodes[var1];
                int var3 = 0;
                int var4 = 0;
                byte var5 = 0;

                while (true) {
                    int var6 = var2[var4++];
                    int var7 = 0;
                    byte var8 = 0;
                    if (var6 == 0) {
                        return var3;
                    }

                    if (var6 == 1) {
                        var7 = client.currentLevels[var2[var4++]];
                    }

                    if (var6 == 2) {
                        var7 = client.levels[var2[var4++]];
                    }

                    if (var6 == 3) {
                        var7 = client.experiences[var2[var4++]];
                    }

                    int var9;
                    InterfaceComponent var10;
                    int var11;
                    int var12;
                    if (var6 == 4) {
                        var9 = var2[var4++] << 16;
                        var9 += var2[var4++];
                        var10 = InterfaceComponent.lookup(var9);
                        var11 = var2[var4++];
                        if (var11 != -1 && (!CameraCapture.getItemDefinition(var11).members || client.membersWorld)) {
                            for (var12 = 0; var12 < var10.itemIds.length; ++var12) {
                                if (var11 + 1 == var10.itemIds[var12]) {
                                    var7 += var10.itemStackSizes[var12];
                                }
                            }
                        }
                    }

                    if (var6 == 5) {
                        var7 = Varps.values[var2[var4++]];
                    }

                    if (var6 == 6) {
                        var7 = Statics20.anIntArray1262[client.levels[var2[var4++]] - 1];
                    }

                    if (var6 == 7) {
                        var7 = Varps.values[var2[var4++]] * 100 / 46875;
                    }

                    if (var6 == 8) {
                        var7 = PlayerEntity.local.combatLevel;
                    }

                    if (var6 == 9) {
                        for (var9 = 0; var9 < 25; ++var9) {
                            if (Statics20.aBooleanArray1263[var9]) {
                                var7 += client.levels[var9];
                            }
                        }
                    }

                    if (var6 == 10) {
                        var9 = var2[var4++] << 16;
                        var9 += var2[var4++];
                        var10 = InterfaceComponent.lookup(var9);
                        var11 = var2[var4++];
                        if (var11 != -1 && (!CameraCapture.getItemDefinition(var11).members || client.membersWorld)) {
                            for (var12 = 0; var12 < var10.itemIds.length; ++var12) {
                                if (var11 + 1 == var10.itemIds[var12]) {
                                    var7 = 999999999;
                                    break;
                                }
                            }
                        }
                    }

                    if (var6 == 11) {
                        var7 = client.energy;
                    }

                    if (var6 == 12) {
                        var7 = client.weight;
                    }

                    if (var6 == 13) {
                        var9 = Varps.values[var2[var4++]];
                        int var13 = var2[var4++];
                        var7 = (var9 & 1 << var13) != 0 ? 1 : 0;
                    }

                    if (var6 == 14) {
                        var9 = var2[var4++];
                        var7 = Class37.getVarpbit(var9);
                    }

                    if (var6 == 15) {
                        var8 = 1;
                    }

                    if (var6 == 16) {
                        var8 = 2;
                    }

                    if (var6 == 17) {
                        var8 = 3;
                    }

                    if (var6 == 18) {
                        var7 = Statics18.baseX + (PlayerEntity.local.fineX >> 7);
                    }

                    if (var6 == 19) {
                        var7 = Statics36.baseY + (PlayerEntity.local.fineY >> 7);
                    }

                    if (var6 == 20) {
                        var7 = var2[var4++];
                    }

                    if (var8 == 0) {
                        if (var5 == 0) {
                            var3 += var7;
                        }

                        if (var5 == 1) {
                            var3 -= var7;
                        }

                        if (var5 == 2 && var7 != 0) {
                            var3 /= var7;
                        }

                        if (var5 == 3) {
                            var3 *= var7;
                        }

                        var5 = 0;
                    } else {
                        var5 = var8;
                    }
                }
            } catch (Exception var14) {
                return -1;
            }
        }
        return -2;
    }
}
