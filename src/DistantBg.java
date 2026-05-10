/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class DistantBg {
    static final int ANCHOR = 20;
    static final int DISP_W = 240;
    static final int DISP_H = 168;
    static final int DISP_OY = 36;
    static final int DISP_WP = 496;
    static Graphics g;
    static int stageNo;
    static int zoneNo;
    static int workX;
    static int workY;
    public static final int[] box;

    public static final void setStage(int n, int n2) {
        zoneNo = n;
        stageNo = n2;
        g = MainCanvas.gg;
    }

    public static final void paint(int n, int n2) {
        if (zoneNo < 0) {
            return;
        }
        int n3 = n2;
        g.setClip(0, 36, 240, 168);
        block0 : switch (zoneNo) {
            case 0: {
                if ((n2 >>= 5) > 32) {
                    n2 = 32;
                }
                DistantBg.drawParts(DistantBgTbl1.data0, n / 5, n2);
                DistantBg.drawParts(DistantBgTbl1.data1, n / 3, n2);
                DistantBg.drawParts(DistantBgTbl1.data2, n >> 1, n2);
                DistantBg.drawParts(DistantBgTbl1.data3, n, n2);
                break;
            }
            case 1: {
                DistantBg.paintS2(n, n3);
                break;
            }
            case 2: {
                int n4 = 0;
                n2 = (n2 >> 4) - 16;
                if (n2 > 16) {
                    n2 = 16;
                }
                switch (stageNo) {
                    case 0: {
                        if (DistantBg.chkBox(n, n3, 4) || DistantBg.chkBox(n, n3, 8) || DistantBg.chkBox(n, n3, 12)) break;
                        if (DistantBg.chkBox(n, n3, 16)) {
                            n4 = -17;
                            break;
                        }
                        n4 = 1;
                        break;
                    }
                    case 1: {
                        if (DistantBg.chkBox(n, n3, 24) || DistantBg.chkBox(n, n3, 40)) break;
                        if (DistantBg.chkBox(n, n3, 20)) {
                            n4 = -21;
                            break;
                        }
                        if (DistantBg.chkBox(n, n3, 28)) {
                            n4 = -29;
                            break;
                        }
                        if (DistantBg.chkBox(n, n3, 32)) {
                            n4 = -33;
                            break;
                        }
                        if (DistantBg.chkBox(n, n3, 36)) {
                            n4 = -37;
                            break;
                        }
                        if (DistantBg.chkBox(n, n3, 44)) {
                            n4 = -45;
                            break;
                        }
                        n4 = 1;
                        break;
                    }
                    default: {
                        if (DistantBg.chkBox(n, n3, 52) || DistantBg.chkBox(n, n3, 56) || DistantBg.chkBox(n, n3, 60)) break;
                        n4 = DistantBg.chkBox(n, n3, 48) ? -49 : (DistantBg.chkBox(n, n3, 64) ? -65 : 1);
                    }
                }
                if (n4 == 0) {
                    DistantBg.paintS1(n, n3);
                    break;
                }
                if (n4 > 0) {
                    DistantBg.paintS0(n, n2);
                    break;
                }
                if (n4 >= 0) break;
                DistantBg.paintS0(n, n2);
                if (DistantBg.setClip(n, n3, -n4 - 1)) {
                    DistantBg.paintS1(n, n3);
                }
                g.setClip(0, 36, 240, 168);
                break;
            }
            case 3: {
                n2 = 32 - n2 * 512 / 1712;
                if (n2 < -480) {
                    n2 = -480;
                }
                DistantBg.drawParts(DistantBgTbl2.data16, n / 5, n2);
                DistantBg.drawParts(DistantBgTbl2.data17, n >> 2, n2);
                DistantBg.drawParts(DistantBgTbl2.data18, n / 3, n2);
                DistantBg.drawParts(DistantBgTbl2.data19, n >> 1, n2);
                break;
            }
            case 4: {
                n2 = 32 - (n2 >> 3);
                if (n2 < -112) {
                    n2 = -112;
                }
                DistantBg.drawParts(DistantBgTbl1.data8, n / 5, n2);
                DistantBg.drawParts(DistantBgTbl1.data9, n / 3, n2);
                DistantBg.drawParts(DistantBgTbl1.data10, n >> 1, n2);
                DistantBg.drawParts(DistantBgTbl1.data11, n, n2);
                break;
            }
            default: {
                switch (stageNo) {
                    case 0: {
                        n2 = 32 - (n2 >> 3);
                        if (n2 < -144) {
                            n2 = -144;
                        }
                        DistantBg.drawParts(DistantBgTbl2.data12, n / 5, n2);
                        DistantBg.drawParts(DistantBgTbl2.data13, n / 3, n2);
                        break block0;
                    }
                }
                DistantBg.paintS3(n, n3);
            }
        }
    }

    private static final void paintS0(int n, int n2) {
        DistantBg.drawParts(DistantBgTbl1.data4, n / 5, n2);
        DistantBg.drawParts(DistantBgTbl1.data5, n / 3, n2);
        DistantBg.drawParts(DistantBgTbl1.data6, n >> 1, n2);
    }

    private static final void paintS1(int n, int n2) {
        n2 = 256 - (n2 & 0xFF);
        DistantBg.drawParts(DistantBgTbl1.data7, n >>= 1, n2);
        DistantBg.drawParts(DistantBgTbl1.data7, n, n2 - 256);
    }

    private static final void paintS2(int n, int n2) {
        n2 = 256 - (n2 >> 2 & 0xFF);
        DistantBg.drawParts(DistantBgTbl2.data15, n >>= 1, n2);
        DistantBg.drawParts(DistantBgTbl2.data15, n, n2 - 256);
    }

    private static final void paintS3(int n, int n2) {
        n2 = 256 - (n2 >> 3 & 0xFF);
        DistantBg.drawParts(DistantBgTbl2.data14, n >>= 1, n2);
        DistantBg.drawParts(DistantBgTbl2.data14, n, n2 - 256);
    }

    private static final void drawParts(int[] nArray, int n, int n2) {
        workY = n2;
        workX = n;
        DistantBg.drawPartsSub(nArray, 0);
        DistantBg.drawPartsSub(nArray, 256);
    }

    public static final void drawPartsSub(int[] nArray, int n) {
        int n2;
        int n3;
        int n4;
        int n5 = workY;
        if (n == 0 && (n4 = nArray[0]) > 0) {
            g.setColor(nArray[2]);
            g.fillRect(0, nArray[1] + n5, 240, n4);
        }
        int n6 = 0;
        int n7 = n - workX;
        int n8 = 4;
        if (n5 < 20) {
            for (n3 = nArray[3]; n3 > 0; --n3) {
                n7 = n7 + nArray[n8 + 0] & 0x1FF;
                n2 = nArray[n8 + 1];
                n4 = nArray[n8 + 2];
                if (n4 == -2) {
                    n6 = nArray[n8 + 3];
                    if ((n5 += nArray[n8 + 1]) >= 20) {
                        n8 += 4;
                        --n3;
                        break;
                    }
                }
                n8 += 4;
            }
        }
        block5: while (n3 > 0) {
            n7 = n7 + nArray[n8 + 0] & 0x1FF;
            n2 = nArray[n8 + 1];
            n4 = nArray[n8 + 2];
            if (n4 == -2 || n7 < 496 && (n7 >= 256 || n7 + n2 >= 256)) {
                if (n4 >= 0) {
                    g.drawRegion(MainCanvas.m_imgMimg, n4, nArray[n8 + 3], n2, 16, n6, n7 - 256, n5, 20);
                } else {
                    switch (n4) {
                        case -1: {
                            g.setColor(nArray[n8 + 3]);
                            g.fillRect(n7 - 256, n5, n2, 16);
                            break;
                        }
                        case -2: {
                            if ((n5 += nArray[n8 + 1]) >= 204) break block5;
                            n6 = nArray[n8 + 3];
                            break;
                        }
                        default: {
                            n4 = -(n4 + 16);
                            int n9 = n7 - 256;
                            while (n2 > 0) {
                                g.drawRegion(MainCanvas.m_imgMimg, n4, nArray[n8 + 3], 16, 16, n6, n9, n5, 20);
                                n2 -= 16;
                                n9 += 16;
                            }
                            break block0;
                        }
                    }
                }
            }
            n8 += 4;
            --n3;
        }
    }

    private static final boolean setClip(int n, int n2, int n3) {
        int n4 = box[n3] - n;
        int n5 = box[n3 + 2] - n2;
        int n6 = box[n3 + 1] - n;
        int n7 = box[n3 + 3] - n2;
        if (n4 < 0) {
            n4 = 0;
        }
        if (n5 < 36) {
            n5 = 36;
        }
        if (n6 - n4 > 240) {
            n6 = n4 + 240;
        }
        if (n7 - n5 > 168) {
            n7 = n5 + 168;
        }
        if (n4 >= n6) {
            return false;
        }
        if (n5 >= n7) {
            return false;
        }
        if (n5 >= 204) {
            return false;
        }
        if (n7 <= 36) {
            return false;
        }
        g.clipRect(n4, n5, n6 - n4, n7 - n5);
        return true;
    }

    private static final boolean chkBox(int n, int n2, int n3) {
        if (n + 240 < box[n3]) {
            return false;
        }
        if (n >= box[n3 + 1]) {
            return false;
        }
        if (n2 + 168 + 36 < box[n3 + 2]) {
            return false;
        }
        return n2 < box[n3 + 3];
    }

    static {
        zoneNo = -1;
        box = new int[]{3440, 3584, 784, 1084, 2528, 3440, 944, 1096, 2528, 4256, 1096, 2048, 4192, 4496, 988, 2048, 2960, 4496, 784, 1072, 760, 1664, 800, 1088, 568, 3848, 1068, 2048, 760, 1283, 832, 1088, 2122, 3898, 800, 1072, 4443, 4715, 800, 1316, 4091, 5544, 1028, 2048, 5346, 6034, 757, 1125, 1550, 1949, 808, 1076, 0, 6138, 1040, 2048, 0, 1168, 720, 960, 3574, 4600, 752, 1040, 4600, 4999, 776, 1076};
    }
}
