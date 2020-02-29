package com.jagex;

import java.io.IOException;

public class ItemDefinition extends DoublyLinkedNode {
    public static ReferenceCache aReferenceCache716;
    static ReferenceCache aReferenceCache720;
    static ReferenceTable aReferenceTable722;
    static ReferenceCache aReferenceCache717;
    static ReferenceTable aReferenceTable721;

    static {
        aReferenceCache720 = new ReferenceCache(64);
        aReferenceCache717 = new ReferenceCache(50);
        aReferenceCache716 = new ReferenceCache(200);
    }

    public String[] actions;
    public String name;
    public int spriteScale;
    public int anInt693;
    public int spritePitch;
    public int spriteRoll;
    public int spriteTranslateX;
    public int stackable;
    public int spriteTranslateY;
    public int spriteYaw;
    public boolean members;
    public int value;
    public int noteTemplateId;
    public String[] groundActions;
    public int noteId;
    public boolean tradable;
    public int anInt712;
    public int ambient;
    public int anInt715;
    public int contrast;
    public int team;
    int maleHeadModel;
    int anInt579;
    int modelId;
    int[] variantIds;
    int shiftClickActionIndex;
    IterableNodeTable properties;
    int maleHeadModel2;
    int maleModel1;
    int maleModel2;
    int femaleHeadModel;
    int femaleHeadModel2;
    int anInt709;
    int[] variantStackSizes;
    int femaleModel1;
    int femaleModel2;
    int resizeX;
    int resizeY;
    int resizeZ;
    short[] aShortArray723;
    int anInt711;
    short[] aShortArray724;
    short[] aShortArray718;
    int anInt714;
    int anInt710;
    short[] aShortArray719;
    int anInt713;

    ItemDefinition() {
        this.name = "null";
        this.spriteScale = 2000;
        this.spritePitch = 0;
        this.spriteRoll = 0;
        this.spriteYaw = 0;
        this.spriteTranslateX = 0;
        this.spriteTranslateY = 0;
        this.stackable = 0;
        this.value = 1;
        this.members = false;
        this.groundActions = new String[]{null, null, "Take", null, null};
        this.actions = new String[]{null, null, null, null, "Drop"};
        this.shiftClickActionIndex = -2;
        this.anInt579 = -1;
        this.maleModel1 = -1;
        this.anInt711 = 0;
        this.anInt709 = -1;
        this.femaleModel1 = -1;
        this.anInt710 = 0;
        this.maleModel2 = -1;
        this.femaleModel2 = -1;
        this.maleHeadModel = -1;
        this.maleHeadModel2 = -1;
        this.femaleHeadModel = -1;
        this.femaleHeadModel2 = -1;
        this.noteId = -1;
        this.noteTemplateId = -1;
        this.resizeX = 128;
        this.resizeY = 128;
        this.resizeZ = 128;
        this.ambient = 0;
        this.contrast = 0;
        this.team = 0;
        this.tradable = false;
        this.anInt713 = -1;
        this.anInt714 = -1;
        this.anInt715 = -1;
        this.anInt712 = -1;
    }

    static ClientPreferences method529() {
        DiskFile var0 = null;
        ClientPreferences var1 = new ClientPreferences();

        try {
            var0 = RegionUpdateType.method863("", Class83.anEnum_Sub5_629.aString1212, false);
            byte[] var2 = new byte[(int) var0.length()];

            int var4;
            for (int var3 = 0; var3 < var2.length; var3 += var4) {
                var4 = var0.read(var2, var3, var2.length - var3);
                if (var4 == -1) {
                    throw new IOException();
                }
            }

            var1 = new ClientPreferences(new Buffer(var2));
        } catch (Exception ignored) {
        }

        try {
            if (var0 != null) {
                var0.close();
            }
        } catch (Exception ignored) {
        }

        return var1;
    }

    void method526(Buffer var1, int var2) {
        if (var2 == 1) {
            this.modelId = var1.readUShort();
        } else if (var2 == 2) {
            this.name = var1.readString();
        } else if (var2 == 4) {
            this.spriteScale = var1.readUShort();
        } else if (var2 == 5) {
            this.spritePitch = var1.readUShort();
        } else if (var2 == 6) {
            this.spriteRoll = var1.readUShort();
        } else if (var2 == 7) {
            this.spriteTranslateX = var1.readUShort();
            if (this.spriteTranslateX > 32767) {
                this.spriteTranslateX -= 65536;
            }
        } else if (var2 == 8) {
            this.spriteTranslateY = var1.readUShort();
            if (this.spriteTranslateY > 32767) {
                this.spriteTranslateY -= 65536;
            }
        } else if (var2 == 11) {
            this.stackable = 1;
        } else if (var2 == 12) {
            this.value = var1.readInt();
        } else if (var2 == 16) {
            this.members = true;
        } else if (var2 == 23) {
            this.anInt579 = var1.readUShort();
            this.anInt711 = var1.readUByte();
        } else if (var2 == 24) {
            this.maleModel1 = var1.readUShort();
        } else if (var2 == 25) {
            this.anInt709 = var1.readUShort();
            this.anInt710 = var1.readUByte();
        } else if (var2 == 26) {
            this.femaleModel1 = var1.readUShort();
        } else if (var2 >= 30 && var2 < 35) {
            this.groundActions[var2 - 30] = var1.readString();
            if (this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
                this.groundActions[var2 - 30] = null;
            }
        } else if (var2 >= 35 && var2 < 40) {
            this.actions[var2 - 35] = var1.readString();
        } else {
            int var3;
            int var4;
            if (var2 == 40) {
                var3 = var1.readUByte();
                this.aShortArray723 = new short[var3];
                this.aShortArray718 = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.aShortArray723[var4] = (short) var1.readUShort();
                    this.aShortArray718[var4] = (short) var1.readUShort();
                }
            } else if (var2 == 41) {
                var3 = var1.readUByte();
                this.aShortArray724 = new short[var3];
                this.aShortArray719 = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.aShortArray724[var4] = (short) var1.readUShort();
                    this.aShortArray719[var4] = (short) var1.readUShort();
                }
            } else if (var2 == 42) {
                this.shiftClickActionIndex = var1.readByte();
            } else if (var2 == 65) {
                this.tradable = true;
            } else if (var2 == 78) {
                this.maleModel2 = var1.readUShort();
            } else if (var2 == 79) {
                this.femaleModel2 = var1.readUShort();
            } else if (var2 == 90) {
                this.maleHeadModel = var1.readUShort();
            } else if (var2 == 91) {
                this.femaleHeadModel = var1.readUShort();
            } else if (var2 == 92) {
                this.maleHeadModel2 = var1.readUShort();
            } else if (var2 == 93) {
                this.femaleHeadModel2 = var1.readUShort();
            } else if (var2 == 95) {
                this.spriteYaw = var1.readUShort();
            } else if (var2 == 97) {
                this.noteId = var1.readUShort();
            } else if (var2 == 98) {
                this.noteTemplateId = var1.readUShort();
            } else if (var2 >= 100 && var2 < 110) {
                if (this.variantIds == null) {
                    this.variantIds = new int[10];
                    this.variantStackSizes = new int[10];
                }

                this.variantIds[var2 - 100] = var1.readUShort();
                this.variantStackSizes[var2 - 100] = var1.readUShort();
            } else if (var2 == 110) {
                this.resizeX = var1.readUShort();
            } else if (var2 == 111) {
                this.resizeY = var1.readUShort();
            } else if (var2 == 112) {
                this.resizeZ = var1.readUShort();
            } else if (var2 == 113) {
                this.ambient = var1.readByte();
            } else if (var2 == 114) {
                this.contrast = var1.readByte() * 5;
            } else if (var2 == 115) {
                this.team = var1.readUByte();
            } else if (var2 == 139) {
                this.anInt713 = var1.readUShort();
            } else if (var2 == 140) {
                this.anInt714 = var1.readUShort();
            } else if (var2 == 148) {
                this.anInt715 = var1.readUShort();
            } else if (var2 == 149) {
                this.anInt712 = var1.readUShort();
            } else if (var2 == 249) {
                this.properties = AssociateComparator_Sub5.method676(var1, this.properties);
            }
        }

    }

    public final Model getModel(int var1) {
        if (this.variantIds != null && var1 > 1) {
            int var3 = -1;

            for (int var4 = 0; var4 < 10; ++var4) {
                if (var1 >= this.variantStackSizes[var4] && this.variantStackSizes[var4] != 0) {
                    var3 = this.variantIds[var4];
                }
            }

            if (var3 != -1) {
                return CameraCapture.getItemDefinition(var3).getModel(1);
            }
        }

        Model var5 = (Model) aReferenceCache717.get((long) this.anInt693);
        if (var5 != null) {
            return var5;
        }
        UnlitModel var6 = UnlitModel.method982(aReferenceTable722, this.modelId, 0);
        if (var6 == null) {
            return null;
        }
        if (this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var6.method764(this.resizeX, this.resizeY, this.resizeZ);
        }

        int var7;
        if (this.aShortArray723 != null) {
            for (var7 = 0; var7 < this.aShortArray723.length; ++var7) {
                var6.texturize(this.aShortArray723[var7], this.aShortArray718[var7]);
            }
        }

        if (this.aShortArray724 != null) {
            for (var7 = 0; var7 < this.aShortArray724.length; ++var7) {
                var6.colorize(this.aShortArray724[var7], this.aShortArray719[var7]);
            }
        }

        var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
        var5.aabbEnabled = true;
        aReferenceCache717.put(var5, (long) this.anInt693);
        return var5;
    }

    public final UnlitModel method531(int var1) {
        int var3;
        if (this.variantIds != null && var1 > 1) {
            int var2 = -1;

            for (var3 = 0; var3 < 10; ++var3) {
                if (var1 >= this.variantStackSizes[var3] && this.variantStackSizes[var3] != 0) {
                    var2 = this.variantIds[var3];
                }
            }

            if (var2 != -1) {
                return CameraCapture.getItemDefinition(var2).method531(1);
            }
        }

        UnlitModel var4 = UnlitModel.method982(aReferenceTable722, this.modelId, 0);
        if (var4 == null) {
            return null;
        }
        if (this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method764(this.resizeX, this.resizeY, this.resizeZ);
        }

        if (this.aShortArray723 != null) {
            for (var3 = 0; var3 < this.aShortArray723.length; ++var3) {
                var4.texturize(this.aShortArray723[var3], this.aShortArray718[var3]);
            }
        }

        if (this.aShortArray724 != null) {
            for (var3 = 0; var3 < this.aShortArray724.length; ++var3) {
                var4.colorize(this.aShortArray724[var3], this.aShortArray719[var3]);
            }
        }

        return var4;
    }

    void method23() {
    }

    public final boolean method530(boolean var1) {
        int var2 = this.maleHeadModel;
        int var3 = this.maleHeadModel2;
        if (var1) {
            var2 = this.femaleHeadModel;
            var3 = this.femaleHeadModel2;
        }

        if (var2 == -1) {
            return true;
        }
        boolean var4 = true;
        if (!aReferenceTable722.method913(var2, 0)) {
            var4 = false;
        }

        if (var3 != -1 && !aReferenceTable722.method913(var3, 0)) {
            var4 = false;
        }

        return var4;
    }

    void method528(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method526(var1, var2);
        }
    }

    public final UnlitModel method521(boolean var1) {
        int var2 = this.maleHeadModel;
        int var3 = this.maleHeadModel2;
        if (var1) {
            var2 = this.femaleHeadModel;
            var3 = this.femaleHeadModel2;
        }

        if (var2 == -1) {
            return null;
        }
        UnlitModel var4 = UnlitModel.method982(aReferenceTable722, var2, 0);
        if (var3 != -1) {
            UnlitModel var5 = UnlitModel.method982(aReferenceTable722, var3, 0);
            UnlitModel[] var6 = new UnlitModel[]{var4, var5};
            var4 = new UnlitModel(var6, 2);
        }

        int var7;
        if (this.aShortArray723 != null) {
            for (var7 = 0; var7 < this.aShortArray723.length; ++var7) {
                var4.texturize(this.aShortArray723[var7], this.aShortArray718[var7]);
            }
        }

        if (this.aShortArray724 != null) {
            for (var7 = 0; var7 < this.aShortArray724.length; ++var7) {
                var4.colorize(this.aShortArray724[var7], this.aShortArray719[var7]);
            }
        }

        return var4;
    }

    public final boolean method518(boolean var1) {
        int var2 = this.anInt579;
        int var3 = this.maleModel1;
        int var4 = this.maleModel2;
        if (var1) {
            var2 = this.anInt709;
            var3 = this.femaleModel1;
            var4 = this.femaleModel2;
        }

        if (var2 == -1) {
            return true;
        }
        boolean var5 = true;
        if (!aReferenceTable722.method913(var2, 0)) {
            var5 = false;
        }

        if (var3 != -1 && !aReferenceTable722.method913(var3, 0)) {
            var5 = false;
        }

        if (var4 != -1 && !aReferenceTable722.method913(var4, 0)) {
            var5 = false;
        }

        return var5;
    }

    void method524(ItemDefinition var1, ItemDefinition var2) {
        this.modelId = var1.modelId;
        this.spriteScale = var1.spriteScale;
        this.spritePitch = var1.spritePitch;
        this.spriteRoll = var1.spriteRoll;
        this.spriteYaw = var1.spriteYaw;
        this.spriteTranslateX = var1.spriteTranslateX;
        this.spriteTranslateY = var1.spriteTranslateY;
        this.aShortArray723 = var1.aShortArray723;
        this.aShortArray718 = var1.aShortArray718;
        this.aShortArray724 = var1.aShortArray724;
        this.aShortArray719 = var1.aShortArray719;
        this.name = var2.name;
        this.members = var2.members;
        this.value = var2.value;
        this.stackable = 1;
    }

    public final UnlitModel getEquipmentModel(boolean var1) {
        int var3 = this.anInt579;
        int var4 = this.maleModel1;
        int var5 = this.maleModel2;
        if (var1) {
            var3 = this.anInt709;
            var4 = this.femaleModel1;
            var5 = this.femaleModel2;
        }

        if (var3 == -1) {
            return null;
        }
        UnlitModel var6 = UnlitModel.method982(aReferenceTable722, var3, 0);
        if (var4 != -1) {
            UnlitModel var7 = UnlitModel.method982(aReferenceTable722, var4, 0);
            if (var5 != -1) {
                UnlitModel var8 = UnlitModel.method982(aReferenceTable722, var5, 0);
                UnlitModel[] var9 = new UnlitModel[]{var6, var7, var8};
                var6 = new UnlitModel(var9, 3);
            } else {
                UnlitModel[] var11 = new UnlitModel[]{var6, var7};
                var6 = new UnlitModel(var11, 2);
            }
        }

        if (!var1 && this.anInt711 != 0) {
            var6.method976(0, this.anInt711, 0);
        }

        if (var1 && this.anInt710 != 0) {
            var6.method976(0, this.anInt710, 0);
        }

        int var10;
        if (this.aShortArray723 != null) {
            for (var10 = 0; var10 < this.aShortArray723.length; ++var10) {
                var6.texturize(this.aShortArray723[var10], this.aShortArray718[var10]);
            }
        }

        if (this.aShortArray724 != null) {
            for (var10 = 0; var10 < this.aShortArray724.length; ++var10) {
                var6.colorize(this.aShortArray724[var10], this.aShortArray719[var10]);
            }
        }

        return var6;
    }

    void method525(ItemDefinition var1, ItemDefinition var2) {
        this.modelId = var1.modelId;
        this.spriteScale = var1.spriteScale;
        this.spritePitch = var1.spritePitch;
        this.spriteRoll = var1.spriteRoll;
        this.spriteYaw = var1.spriteYaw;
        this.spriteTranslateX = var1.spriteTranslateX;
        this.spriteTranslateY = var1.spriteTranslateY;
        this.aShortArray723 = var2.aShortArray723;
        this.aShortArray718 = var2.aShortArray718;
        this.aShortArray724 = var2.aShortArray724;
        this.aShortArray719 = var2.aShortArray719;
        this.name = var2.name;
        this.members = var2.members;
        this.stackable = var2.stackable;
        this.anInt579 = var2.anInt579;
        this.maleModel1 = var2.maleModel1;
        this.maleModel2 = var2.maleModel2;
        this.anInt709 = var2.anInt709;
        this.femaleModel1 = var2.femaleModel1;
        this.femaleModel2 = var2.femaleModel2;
        this.maleHeadModel = var2.maleHeadModel;
        this.maleHeadModel2 = var2.maleHeadModel2;
        this.femaleHeadModel = var2.femaleHeadModel;
        this.femaleHeadModel2 = var2.femaleHeadModel2;
        this.team = var2.team;
        this.groundActions = var2.groundActions;
        this.actions = new String[5];
        if (var2.actions != null) {
            System.arraycopy(var2.actions, 0, this.actions, 0, 4);
        }

        this.actions[4] = "Discard";
        this.value = 0;
    }

    void method523(ItemDefinition var1, ItemDefinition var2) {
        this.modelId = var1.modelId;
        this.spriteScale = var1.spriteScale;
        this.spritePitch = var1.spritePitch;
        this.spriteRoll = var1.spriteRoll;
        this.spriteYaw = var1.spriteYaw;
        this.spriteTranslateX = var1.spriteTranslateX;
        this.spriteTranslateY = var1.spriteTranslateY;
        this.aShortArray723 = var1.aShortArray723;
        this.aShortArray718 = var1.aShortArray718;
        this.aShortArray724 = var1.aShortArray724;
        this.aShortArray719 = var1.aShortArray719;
        this.stackable = var1.stackable;
        this.name = var2.name;
        this.value = 0;
        this.members = false;
        this.tradable = false;
    }

    public int method522() {
        if (this.shiftClickActionIndex != -1 && this.actions != null) {
            if (this.shiftClickActionIndex >= 0) {
                return this.actions[this.shiftClickActionIndex] != null ? this.shiftClickActionIndex : -1;
            }
            return "Drop".equalsIgnoreCase(this.actions[4]) ? 4 : -1;
        }
        return -1;
    }

    public ItemDefinition method519(int var1) {
        if (this.variantIds != null && var1 > 1) {
            int var2 = -1;

            for (int var3 = 0; var3 < 10; ++var3) {
                if (var1 >= this.variantStackSizes[var3] && this.variantStackSizes[var3] != 0) {
                    var2 = this.variantIds[var3];
                }
            }

            if (var2 != -1) {
                return CameraCapture.getItemDefinition(var2);
            }
        }

        return this;
    }

    public int method527(int var1, int var2) {
        return HealthBar.method696(this.properties, var1, var2);
    }

    public String method520(int var1, String var2) {
        return IterableNodeTable.getStringParameter(this.properties, var1, var2);
    }
}
