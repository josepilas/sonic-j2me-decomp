/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Command
 *  javax.microedition.lcdui.CommandListener
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.lcdui.Font
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 *  javax.microedition.lcdui.game.GameCanvas
 *  javax.microedition.media.Manager
 *  javax.microedition.media.MediaException
 *  javax.microedition.media.Player
 *  javax.microedition.media.PlayerListener
 *  javax.microedition.media.control.VolumeControl
 *  javax.microedition.rms.RecordStore
 */
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.rms.RecordStore;

public class MainCanvas
extends GameCanvas
implements CommandListener,
PlayerListener,
Runnable {
    public static boolean moveRsm;
    public static boolean drawRsm;
    public static boolean loopMode;
    public static boolean noloop;
    public static boolean loopOut1;
    public static boolean loopOut2;
    public static final boolean EmuOn = false;
    private static final boolean DebugPutOn = false;
    private static final boolean DebugCommandOn = false;
    private static DataOutputStream out;
    private static InputStream in;
    private static DataInputStream indata;
    public Random rnd = new Random();
    private static sonic h;
    private static RecordStore record;
    private static Font f;
    public static Graphics gg;
    private static int[][] ObjectList;
    private static int ObjectListNum;
    private static boolean[] ObjectAct;
    private static boolean[] ObjectDead;
    private Image[] m_imgCmd = new Image[20];
    public static Image m_imgMimg;
    private Image[] m_imgObj = new Image[150];
    private static boolean keyBreak;
    private static boolean DrawFlag;
    private static boolean[] KeyEvent;
    private static boolean[] KeyPress;
    private static boolean debugFlag;
    private static int TIME_WAIT;
    private static int XNUM;
    private static int MODE_SELECT_DATAFOLDER;
    private static int MODE_DEBUGPRINT2;
    private static int MODE_CONNINIT;
    private static int MODE_DEBUGPRINT;
    private static int MODE_CONNECT_FAILED;
    private static int MODE_INIT;
    private static int MODE_TITLE;
    private static int MODE_FIELD;
    private static int MODE_STAGESELECT;
    private static int MODE_STARTSTAGE;
    private static int MODE_CLEARSTAGE;
    private static int MODE_CONTINUE;
    private static int MODE_OPTION;
    public int zoneNumber = 0;
    public int stageNumber = 0;
    public int selectZoneNumber = 0;
    public int selectStageNumber = 0;
    public int animeTimer = 1;
    public int cpuTimer = 1;
    private static int plmaxspd;
    private static int pladdspd;
    private static int plretspd;
    private static int plstaspd;
    private static int gravity;
    private static int pljump;
    private static int pljump_w;
    private static int[] plspeed;
    private static int[] ploldpos;
    private static int falltimer;
    private static int nocoltimer;
    private static int kokyutimer;
    private static int noloopchecktimer;
    private static int olddir;
    private static int olddir2;
    private static int mutekicount;
    private static int muteki2count;
    private static int speedupcount;
    private static int bariacount;
    private static int oldringcount;
    private static int ringcount;
    private static int scorecount;
    private static int timecount;
    private static int timecount2;
    private static int diecount;
    private static int playercount;
    private static int plsaveX;
    private static int plsaveY;
    private static int plsaveTime;
    private static int plsaveTime2;
    private static int[] objectData;
    private static int OBJA_MAX;
    private static int[][] objAwaData;
    private static int[][] objData;
    private static boolean initDisplay;
    private static boolean readStageObjectFlag;
    private static boolean raidOn;
    private static boolean[] switchflag;
    private static int raidObjectNum;
    private static int raidObjectNumSub;
    private static int PlayerH;
    private static int SONIC_N;
    private static int SONIC_S;
    private static int LOGO;
    private static int LOGOLINE;
    private static int SYSTXT;
    private static int WINDOW_RING;
    private static int WINDOW_TIME;
    private static int WINDOW_ZANKI;
    private static int WINDOU_SUUJI;
    private static int SYSSCORE;
    private static int SYSTXT2;
    private static int T_CUR1;
    private static int T_CUR2;
    private static int GAMEOVER;
    private static int TIMEOVER;
    private static int RING;
    private static int RING1;
    private static int SJUMP;
    private static int BURANKO;
    private static int HASHI;
    private static int TOGE_HASHI;
    private static int BREAK;
    private static int YUKA;
    private static int TURI;
    private static int TOGE;
    private static int BOX;
    private static int FBLOCK;
    private static int DAI;
    private static int YOGAN;
    private static int SWITCH2;
    private static int SHIMA;
    private static int DAI2;
    private static int BRKABE;
    private static int PEDAL;
    private static int BREAK2;
    private static int STEP;
    private static int FUN;
    private static int SISOO;
    private static int BELT;
    private static int PATA;
    private static int FIRE6;
    private static int SWITCH2_;
    private static int MAWARU;
    private static int YUKAI;
    private static int DOOR;
    private static int YUKAE;
    private static int DAI4;
    private static int ELE;
    private static int BELTC;
    private static int NOKO;
    private static final int RING_SFLAG_RING_18_00 = 0;
    private static final int RING_SFLAG_RING_00_18 = 1;
    private static final int SJUMP_NFLAG = 2;
    private static final int BURANKO_NFLAG = 3;
    private static final int THASHI_NFLAG = 4;
    private static final int HASHI_NFLAG = 5;
    private static final int BREAK_SFLAG = 6;
    private static final int YUKA_NFLAG = 7;
    private static final int TURI_NFLAG = 8;
    private static final int TOGE_NFLAG = 9;
    private static final int BOX_SFLAG = 10;
    private static final int FBLOCK_NFLAG = 11;
    private static final int DAI_NFLAG = 12;
    private static final int YOGAN2_SFLAG = 13;
    private static final int MYOGAN_NFLAG = 14;
    private static final int SWITCH2_NFLAG = 15;
    private static final int SHIMA_NFLAG = 16;
    private static final int DAI2_NFLAG = 17;
    private static final int BRKABE_SFLAG = 18;
    private static final int PEDAL_NFLAG = 19;
    private static final int BREAK2_NFLAG = 20;
    private static final int STEP_NFLAG = 21;
    private static final int FUN_NFLAG = 22;
    private static final int SISOO_NFLAG = 23;
    private static final int BELT_NFLAG = 24;
    private static final int PATA_NFLAG = 25;
    private static final int FIRE6_NFLAG = 26;
    private static final int BRYUKA_NFLAG = 27;
    private static final int MAWARU_NFLAG = 28;
    private static final int YUKAI_NFLAG = 29;
    private static final int DOOR_NFLAG = 30;
    private static final int YUKAE_NFLAG = 31;
    private static final int DAI4_NFLAG = 32;
    private static final int ELE_NFLAG = 33;
    private static final int BELTC_NFLAG = 34;
    private static final int NOKO_NFLAG = 35;
    private static final int SAVE_SFLAG = 36;
    private static final int KAGEB_NFLAG = 37;
    private static final int BGSPR_NFLAG = 38;
    private static final int KAMERE_SFLAG = 39;
    private static final int HACHI_SFLAG = 40;
    private static final int MUSI_SFLAG = 41;
    private static final int ITEM_NFLAG = 42;
    private static final int ITEM_SFLAG = 43;
    private static final int GOLE_NFLAG = 44;
    private static final int BTEN_NFLAG = 45;
    private static final int BTEN_SFLAG = 46;
    private static final int BIGRING_NFLAG = 47;
    private static final int SCOLI_NFLAG = 48;
    private static final int IMO_SFLAG = 49;
    private static final int BROBO_SFLAG = 50;
    private static final int BUTA_SFLAG = 51;
    private static final int HAGURUMA_NFLAG = 52;
    private static final int SHOOTER_NFLAG = 53;
    private static final int DAINFLA = 54;
    private static final int MASIN_NFLAG = 55;
    private static final int BOBIN_SFLAG = 56;
    private static final int KANI_SFLAG = 57;
    private static final int JYAMA_NFLAG = 58;
    private static final int FETAMA_NFLAG = 59;
    private static final int TEKYU_NFLAG = 60;
    private static final int SIGNAL_NFLAG = 61;
    private static final int DAI2_SFLAG = 62;
    private static final int RING_SFLAG_RING_M10_10 = 63;
    private static final int RING_SFLAG_RING_10_10 = 64;
    private static final int RING_SFLAG_RING_20_20 = 65;
    private static final int RING_SFLAG_RING_10_00 = 66;
    private static final int RING_SFLAG_RING_20_00 = 67;
    private static final int RING_SFLAG_RING_00_10 = 68;
    private static final int RING_SFLAG_RING_00_20 = 69;
    private static final int ARUMA_SFLAG = 70;
    private static final int YADO_SFLAG = 71;
    private static final int ELEV_NFLAG_80 = 72;
    private static final int ELEV_NFLAG = 73;
    private static final int UNI_SFLAG = 74;
    private static final int MFIRE_NFLAG = 75;
    private static final int HASHIRA_NFLAG = 76;
    private static final int YOGANC_NFLAG = 77;
    private static final int BAT_SFLAG = 78;
    private static final int OCHI_NFLAG = 79;
    private static final int YARI_SFLAG = 80;
    private static final int MOGURA_SFLAG = 81;
    private static final int KAZARI_SFLAG = 82;
    private static final int DAI3_NFLAG = 83;
    private static final int MIZU_NFLAG = 84;
    private static final int AWA_NFLAG = 85;
    private static final int FISH_SFLAG = 86;
    private static final int FISH2_SFLAG = 87;
    private static final int KASSYA_NFLAG = 88;
    private static final int TAKI_NFLAG = 89;
    private static final int SHIMA2_NFLAG = 90;
    private static final int BOU_NFLAG = 91;
    private static final int BEN_NFLAG = 92;
    private static final int BEN_SFLAG = 93;
    private static final int TURI2 = 94;
    private static final int TURI3 = 95;
    private static final int TAMA = 96;
    private static final int BAKUHATU = 97;
    private static final int MYOGAN2 = 98;
    private static final int YOGAN2 = 99;
    private static final int ANIMAL = 100;
    private static final int _FIRE = 101;
    private static final int BLOCK = 102;
    private static final int OBJAWA = 104;
    private static final int DAI3_0x27 = 105;
    private static final int DAI3_0x13 = 106;
    private static final int DAI2_0xE0 = 107;
    private static final int DAI2_0xF0 = 108;
    private static final int EFFECT = 109;
    private static final int MIZU_0x09 = 110;
    private static final int WATER2 = 111;
    private static final int BOSS1 = 120;
    private static final int BOSS2 = 125;
    private static final int BOSS3 = 130;
    private static final int BOSS4 = 135;
    private static final int BOSS5 = 140;
    private static final int BOSS6 = 145;
    private static final int BOSS5BLOCK = 150;
    private static int[] objectDrawList;
    private static int objectDrawCount;
    private static int MapW;
    private static int MapH;
    private static int mode;
    private static int BossFirst;
    private static int Target;
    private static int connCount;
    private static int connPos;
    private static int comSel;
    private static int Window;
    private static int[] mapOxy;
    private static int[] oldMapOxy;
    private static int[] mapView;
    private static int[] mapViewTarget;
    private static int[] mapOfs;
    private static int[] mapOfsTarget;
    private static byte[] mapData;
    private static byte[] mapFrontData;
    private static byte[] blockLinkTable;
    private static byte[] blockColTable;
    private static byte[][] zoneActTable;
    private static int[] zoneActTable2;
    private static byte[][] tempWorldMapData;
    private static final byte[][][][] worldMapData;
    private static byte[] scddirtbl;
    private static boolean pauseGame;
    private static int[] PlayerParam;
    private static boolean PlayerSJump;
    private static boolean PlayerDamage;
    private static boolean PlayerWater;
    private static boolean PlayerSWater;
    private static boolean PlayerBou;
    private static boolean PlayerJump;
    private static boolean PlayerAir;
    private static boolean PlayerBall;
    private static boolean PlayerDie;
    private static boolean PlayerCrouch;
    private static boolean PlayerLookUp;
    private static boolean PlayerNoCol;
    private static boolean PlayerNoCtrl;
    private static boolean TimerClear;
    private static boolean TimerStop;
    private static boolean PlayerDush;
    private boolean[] crushing = new boolean[4];
    private static final int[] sinData;
    private static byte[] scdtblwk;
    private static int FontPos;
    private static long getTime2;
    private static int MapEndCounter;
    private static boolean bossModeOn;
    private static boolean bossBreakOn;
    private static short[][] objectSizeTbl;
    private static int TRANS_NONE;
    private static int TRANS_ROT90;
    private static int TRANS_ROT180;
    private static int TRANS_ROT270;
    private static int TRANS_MIRROR;
    private static int TRANS_MIRROR_ROT90;
    private static int TRANS_MIRROR_ROT180;
    private static int TRANS_MIRROR_ROT270;
    public static final int[] rotNumTable;
    static final int[][] encZoneNumber;
    static final int[][] encStageNumber;
    private static int cutDrawVLine;
    int displayOffsetY;
    int displayOffsetY2;
    private byte resumeStage;
    private byte resumeZanki;
    private int resumeScore;
    private byte clearStageData;
    public int MODE_FIELD_PAUSE = 10;
    public int pauseTimer = 0;
    public int pauseSelect = 0;
    byte[] oldm_nConfigValue = new byte[4];
    public static String[] softKeys;
    boolean SetSoftFlag;
    int SetSoftCount;
    int drawRsmCount;
    int wipeCount;
    boolean outWipe;
    boolean putWipe;
    boolean playerDraw;
    private byte[] imageOffset = new byte[21248];
    private byte[] rot = new byte[21248];
    private byte[] hitChk = new byte[21248];
    private byte[] hitChk2 = new byte[21248];
    private int[][][] drawMapData = new int[20][20][4];
    boolean drawRingFlag;
    boolean drawTimeFlag;
    boolean drawZankiFlag;
    int oldRingCount = 0;
    int oldScoreCount = 0;
    int oldTimeCount = 0;
    int oldZankiCount = 0;
    int[][] kyuryuTable = new int[][]{{2688, 784, 3088, 912}, {3968, 272, 5136, 400}, {1120, 1040, 1808, 1168}, {2592, 1552, 5648, 1776}, {3200, 1568, 5072, 1680}};
    private boolean goleFlag = false;
    private int golecount;
    private int scoreGetcount;
    private int scoreGetcountMax;
    private int SysStringMax = 10;
    private int[][] SysString = new int[this.SysStringMax][15];
    private int SysCenter;
    private int SysCount;
    private int GREEN_HILL = 0;
    private int FINAL = 1;
    private int MARBLE = 2;
    private int ZONE = 3;
    private int ACT1 = 4;
    private int ACT2 = 5;
    private int ACT3 = 6;
    private int SPRING_YARD = 7;
    private int ACT = 8;
    private int SCRAP_BRAIN = 9;
    private int DAEN_B = 10;
    private int STAR_LIGHT = 11;
    private int LABYRINTH = 12;
    private int DAEN_Y = 13;
    private int SONIC_HAS = 14;
    private int PASSED = 15;
    private int SPECIAL_STAGE = 16;
    private int CHAOS_EMERALDS = 17;
    int[][] SystxtTable = new int[][]{{0, 0, 112, 16}, {112, 0, 56, 16}, {0, 16, 80, 16}, {80, 16, 48, 16}, {128, 16, 8, 16}, {136, 16, 16, 16}, {152, 16, 16, 16}, {0, 32, 128, 16}, {128, 32, 24, 8}, {0, 48, 128, 16}, {128, 40, 40, 40}, {0, 64, 120, 16}, {0, 80, 104, 16}, {104, 80, 40, 40}, {0, 96, 104, 16}, {0, 112, 72, 16}, {0, 128, 152, 16}, {0, 144, 176, 16}};
    int[] zonetable = new int[]{this.GREEN_HILL, this.MARBLE, this.SPRING_YARD, this.LABYRINTH, this.STAR_LIGHT, this.SCRAP_BRAIN, this.FINAL};
    public boolean scoreMoveFlag = false;
    public boolean limitBreak = false;
    public int resultRing = 0;
    public int resultTime = 0;
    int blockColCount;
    int enemyBlock;
    public int pushCount = 0;
    public int bressCount = 2100;
    public int CrouchCount = 0;
    public int LookUpCount = 0;
    boolean rhit;
    boolean lhit;
    int PlayerW = 10;
    boolean playdamageYogan;
    int offSetPos = 0;
    int[][][] limitTable = new int[][][]{new int[][]{{4, 0, 9407, 0, 768, 96}, {4, 0, 7871, 0, 768, 96}, {4, 0, 10592, 0, 768, 96}, {4, 0, 10943, 0, 768, 96}}, new int[][]{{4, 0, 6591, 0, 1328, 96}, {4, 0, 4271, 0, 1824, 96}, {4, 0, 8239, 65280, 2048, 96}, {4, 0, 8383, 0, 1824, 96}}, new int[][]{{4, 0, 6079, 0, 464, 96}, {4, 0, 6079, 0, 1312, 96}, {4, 0, 6144, 0, 1824, 96}, {4, 0, 5823, 0, 1824, 96}}, new int[][]{{4, 0, 8127, 0, 1600, 96}, {4, 0, 8127, 0, 1600, 96}, {4, 0, 8192, 0, 1728, 96}, {4, 0, 16064, 0, 1824, 96}}, new int[][]{{4, 0, 8896, 0, 1056, 96}, {4, 0, 10432, 0, 1312, 96}, {4, 0, 11264, 0, 1568, 96}, {4, 0, 11968, 0, 1568, 96}}, new int[][]{{4, 0, 8640, 0, 1824, 96}, {4, 0, 7744, 65280, 2048, 96}, {4, 8320, 9312, 1296, 1296, 96}, {4, 0, 16064, 0, 1824, 96}}};
    public byte m_bScrollLock;
    public short[][] m_aaScrollLockPos = new short[][]{{9312, 7776}, {6736, 4176, 8208}, {6224, 6224}, {8288, 8032}, {8800, 10336}, {8544, 7648}};
    int[] poslimit = new int[4];
    int nofcolTimer = 0;
    public boolean damageNow = false;
    public int damageMoveTimer = 0;
    public boolean PlayerSub;
    boolean bressDie;
    boolean timeUpDie;
    boolean noTimeScore;
    private static boolean OttotoOn;
    private static int OttotoSide;
    private static int raidObjectW;
    private static int raidObjectX;
    public int playerStandCount = 0;
    private boolean bressMusic = false;
    int objChkPoint = 0;
    int objChkNum = 0;
    int m_objMaxObject;
    boolean ChkVecR = false;
    boolean ChkVecL = false;
    int LSize = -240;
    int RSize = 640;
    private static int[] m_aAddObjectData;
    int noDataPointer = 0;
    int listSub = 0;
    int[][] objTempData = new int[30][25];
    int objCount;
    boolean[] setDrawFlag = new boolean[150];
    private int waterH = 0;
    private int waterH2 = 0;
    private int waterH3 = 0;
    private byte water_flag = 0;
    private byte water_flag2 = 0;
    private byte water_flag3 = 0;
    private byte water_flag4 = 0;
    int noLeverTimer = 0;
    int[] awasintlb = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 255, 255, 255, 255, 255, 254, 254, 254, 254, 254, 253, 253, 253, 253, 253, 253, 253, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 253, 253, 253, 253, 253, 253, 253, 254, 254, 254, 254, 254, 255, 255, 255, 255, 255};
    int[] awaSize = new int[]{8, 8, 16, 16, 24, 32, 32, 32};
    int[] awaPos = new int[]{0, 8, 16, 32, 48, 72, 104, 136};
    public boolean endingModeOn = false;
    private static byte LANGUAGE_MAX;
    private static byte TITLE_MODE_LICENSE_SEGA;
    private static byte TITLE_MODE_LICENSE_SONICTEAM;
    private static byte TITLE_MODE_FIRST_SETUP;
    private static byte TITLE_MODE_TITLE;
    private static byte TITLE_MODE_TITLE_MENU;
    private static byte TITLE_MODE_TITLE_RANCKING;
    private static byte TITLE_MODE_TITLE_RANCKING_MENU;
    private static byte TITLE_MODE_TITLE_RANCKING_DEL;
    private static byte TITLE_MODE_TITLE_CONFIG_MENU;
    private static byte TITLE_MODE_TITLE_CONTINUE_MENU;
    private static byte TITLE_MODE_TITLE_HOWTO;
    private static byte m_nTitleMode;
    private static byte m_nPattern;
    private static byte m_nRingPattern;
    private static byte m_nSel;
    private static byte m_bDraw;
    private static byte m_bFirstSetUp;
    private static byte m_nTimer;
    private static byte[] m_nConfigValue;
    private static byte[] m_HowToPicIndexTbl;
    private static byte[][] m_aConfigTextOffset;
    private static Command[] cmd;
    private static int m_nMarqueePos;
    private static int m_nOnKey;
    private static int m_nPushedKey;
    private static int m_nLastKey;
    private static int[] m_nHiScore;
    private static int[] m_nDifficulty;
    private static boolean[] m_OnKeyFlag;
    private static Image[] m_imgImage;
    private static Font m_Font;
    private static short[][] m_HowToPicTbl;
    private static String[] m_strText;
    private static String[] m_strHowToText;
    private static String[] m_strMusicComposed;
    private static String m_strMarquee;
    private int MarqOfs;
    private static final int LocalType = 1;
    private static int comboScore;
    private boolean isObj2Debug = false;
    private static int[][] obj2Data;
    private static final int OBJ2_MAX = 50;
    private static final int OBJ2_BAKUHATU = 1;
    private static final int OBJ2_KEMURI = 2;
    private static final int OBJ2_BAKUDAN = 3;
    private static final int OBJ2_RING = 4;
    private static final int OBJ2_KIRA = 5;
    private static final int OBJ2_SCORE = 6;
    private static final int OBJ2_TAMA = 7;
    private static final int OBJ2_HACHI_TAMA = 8;
    private static final int OBJ2_KANI_TAMA = 9;
    private static final int OBJ2_BUTA_TAMA = 10;
    private static final int OBJ2_UNI_TAMA = 11;
    private static final int OBJ2_UNI2_TAMA = 12;
    private static final int OBJ2_BROBO_TAMA = 13;
    private static final int OBJ2_IMO_TAMA = 14;
    private static final int OBJ2_MUSI_KEMURI = 15;
    private static final int OBJ2_FIREBALL = 16;
    private static final int OBJ2_FIREBALL2 = 17;
    private static final int OBJ2_FIREBALL3 = 18;
    private static final int OBJ2_FIREBALL4 = 19;
    private static final int OBJ2_FIREBALL5 = 20;
    private static final int OBJ2_KAZARIFIRE = 21;
    private static final int OBJ2_DBLOCK = 22;
    private static final int OBJ2_DBLOCK2 = 23;
    private static final int OBJ2_DBLOCK3 = 24;
    private static final int OBJ2_DBLOCK4 = 25;
    private static final int OBJ2_BRKABE_G = 26;
    private static final int OBJ2_BOSS6_TAMA = 27;
    private static final int OBJ2_FRIC = 28;
    private static final int OBJ2_AZARASI = 29;
    private static final int OBJ2_NIWATORI = 30;
    private static final int OBJ2_USAGI = 31;
    private static final int OBJ2_PENGUIN = 32;
    private static final int OBJ2_RISU = 33;
    private static final int OBJ2_BUTA = 34;
    private static final int OBJ2_DEBUG = 35;
    private boolean putNowLoading = false;
    private Display display;
    private int mapViewType = 0;
    private int mapViewTypeTemp = 0;
    private int mapViewCount = 0;
    private int mapViewPri = 0;
    private volatile InputStream is1 = null;
    private volatile Player player1 = null;
    private static volatile boolean bPauseMusic;
    private static volatile boolean bGoalMusic;
    private static volatile int musicCount;
    private static volatile int musicRetry;
    private static volatile int musicRequest;
    private static volatile int musicNum;
    private volatile boolean bDoPlay = false;
    private static final int MusicRetryInterval = 50;
    private static final byte[][] friendTbl;
    private static final byte[] sisootbl;
    private static final int KaniAttackCount = 360;
    private static final int ArumaRunCount = 94;
    private static final int ArumaSpeedX = 500;
    private static final int ArumaSpeedY = 400;
    private static final int ArumaStartOffsetX = 160;
    private static final byte[] batAnimTbl;
    private static final short[][] RectTblKamere;
    private static final short[][] RectTblHachi;
    private static final short[][] RectTblMusi;
    private static final short[][] RectTblImo;
    private static final short[][] RectTblBrobo;
    private static final short[][] RectTblButa;
    private static final short[][] RectTblKani;
    private static final short[][] RectTblAruma;
    private static final short[][] RectTblYado;
    private static final short[][] RectTblUni;
    private static final short[][] RectTblBat;
    private static final short[][] RectTblMogura;
    private static final short[][] RectTblFish;
    private static final short[][] RectTblFish2;
    private static final byte[] Boss6TamaAnmTbl;
    private static final byte[] Boss6TamaAnmTbl2;
    private static final byte[] Boss6TamaAnmTbl3;
    private static final short[][] RectTblBakuhatu;
    private static final short[][] RectTblKemuri;
    private static final short[][] RectTblTama;
    private static final short[][] RectTblDBlock;
    private static final short[][] RectTblBoss6Tama;
    private short[][] MoveAnimalTbl = new short[][]{{-250, -360}, {-80, -100}, {-160, -250}, {-200, -300}, {-120, -225}, {-150, -250}, {-100, -165}};
    private short[][] RectAnimalTbl = new short[][]{{0, 0, 16, 24, 0}, {16, 0, 16, 16, 8}, {32, 0, 16, 16, 8}, {0, 24, 16, 24, 0}, {16, 16, 16, 16, 8}, {32, 16, 16, 16, 8}, {0, 48, 16, 24, 0}, {16, 32, 16, 16, 8}, {32, 32, 16, 16, 8}, {0, 72, 16, 24, 0}, {16, 48, 16, 24, 0}, {32, 48, 16, 24, 0}, {0, 96, 16, 24, 0}, {16, 72, 16, 24, 0}, {32, 72, 16, 24, 0}, {16, 96, 16, 24, 0}, {0, 120, 24, 16, 8}, {0, 136, 24, 16, 8}, {32, 96, 16, 24, 0}, {24, 120, 24, 16, 8}, {24, 136, 24, 16, 8}};
    private int bossType;
    private int bossStep;
    private int bossAnim;
    private int bossDir;
    private int bossAngle;
    private int bossAngle2;
    private int bossParam1;
    private int bossParam2;
    private int bossPosX;
    private int bossPosY;
    private int bossOfsX;
    private int bossOfsY;
    private int bossOriginX;
    private int bossOriginY;
    private int bossCount;
    private int bossFrame;
    private int bossFlash;
    private int bossStopCount;
    private int bossFace;
    private int bossFaceCount;
    private int bossHP;
    private static final int[] BossDeadLimitY;
    private static final int Boss1MoveWidth = 3200;
    private static final int Boss1Speed = 100;
    private static final int Boss1FurikoSpeed = 100;
    private static int boss1BallPosX;
    private static int boss1BallPosY;
    private static boolean boss1BallOn;
    private static final int[][] boss2MoveTbl;
    private static final int boss3AttackWidth = 104;
    private static final int boss3SpeedX = 150;
    private static final int boss3DownSpeed = 50;
    private static final int boss3FloatSpeed = 12;
    private static final int boss3AttackWait = 48;
    private static int boss3FireCount;
    private static short[][] boss4Sisoo;
    private static final int Boss4SisooOfs = 3500;
    private static final int Boss4ShootWait = 50;
    private static final int Boss4Speed = 80;
    private static final int Boss4HighPos = -400;
    private static final int Boss4LowPos = 4800;
    private static final int Boss4BakuhatuCount = 240;
    private static short[][] boss5Block;
    static final int Boss5BlockLine = 160;
    private static final int boss5AttackWidth = 120;
    private static final int boss5Speed = 70;
    private static int boss5AttackCount;
    private static int[] boss6Piston;
    private static int[][] boss6PistonXY;
    private static int boss6RideNum;
    private static int boss6PistonNum;
    private static int[] boss6TamaY;
    private static int boss6Lamp;
    private static int boss6Destroy;
    private static final short[][] boss6PistonPos;
    private static int nakaStep;
    private static int nakaLevel;
    private static int nakaCount;
    private static int endingEggStep;
    private static int endingEggAnim;
    private static int endingEggCount;
    private static final short[][] RectTblEndingB;
    private static int wipeCol;
    private static int wipeLevel;
    private static boolean wipeDir;
    private int endingStep;
    private int endingCount;
    private int endingAnim;
    private int endingType;
    private int endingLogoPosX;
    private int endingStringFadeLevel;
    private short[][] endingRectTbl = new short[][]{{0, 0, 32, 40}, {0, 40, 48, 72}, {48, 0, 176, 136}};
    private short[][] RectBoss6LampTbll = new short[][]{{0, 0, 48, 56}, {0, 56, 48, 56}};
    private short[][] RectEggmanTbl = new short[][]{{0, 0, 48, 56}, {0, 56, 48, 56}, {0, 112, 48, 56}, {0, 168, 48, 56}, {48, 0, 64, 56}, {48, 56, 64, 56}, {48, 112, 64, 56}, {48, 168, 64, 56}};
    private short[][] RectBossTbl = new short[][]{{0, 0, 56, 24, 0, -36}, {0, 24, 56, 24, 0, -36}, {0, 48, 56, 24, 0, -36}, {0, 72, 56, 24, 0, -36}, {0, 96, 56, 24, 0, -36}, {0, 120, 56, 24, 0, -36}, {0, 144, 56, 24, 0, -36}, {0, 168, 56, 24, 0, -36}, {56, 48, 64, 32, 4, -8}, {56, 80, 64, 32, 4, -8}, {56, 64, 64, 48, 4, -8}, {56, 112, 16, 16, 42, -10}, {56, 128, 16, 16, 42, -10}, {56, 144, 24, 16, 46, -10}, {56, 160, 32, 32, 52, -10}, {88, 112, 16, 16, 0, 16}, {88, 128, 16, 16, 0, 16}, {88, 144, 16, 16, 0, 0}, {104, 112, 16, 8, 18, -42}, {104, 128, 16, 16, 0, 10}, {104, 144, 16, 40, 0, 10}, {56, 0, 56, 24, 0, -36}, {56, 24, 56, 24, 0, -36}};
    private short[][] RectBoss2Tbl = new short[][]{{0, 0, 64, 48, 4, 0}, {0, 48, 64, 40, 4, -4}, {0, 88, 64, 32, 4, -8}, {0, 120, 64, 32, 4, -8}};
    private short[] RectBossBallTbl = new short[]{0, 0, 48, 48, 0, 0};
    private static int continueStep;
    private static int continueSonicPosX;
    private static int continueSonicPosY;
    private static int continueSonicAnim;
    private static int continueSonicAnim2;
    private static int continueCount;
    private static int continueResult;
    private static final int ContinueSonicCenterX = 120;
    private static final int ContinueSonicBottomY = 167;
    private static final short[][] ContinueSonicTbl;
    private static final short[][] ContinueSonicTbl2;
    int[] break_sflag_ike_yuka = new int[]{32, 32, 32, 32, 32, 32, 32, 32, 33, 33, 34, 34, 35, 35, 36, 36, 37, 37, 38, 38, 39, 39, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48};
    int[][] yuka_nflag_ike_yuka = new int[][]{{44, 44, 44, 44, 44, 44, 44, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 44, 44, 44, 44, 44, 44, 44}, {52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52}, {37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53}};
    int[] yuka_nflag_yuka_w = new int[]{64, 32, 64};
    int[] yuka_nflag_yuka_h = new int[]{40, 48, 48};
    int[] box_sflag_ike_def_X = new int[]{1296, 3632, 752, 4880};
    int[] box_sflag_ike_def_Y = new int[]{1168, 1104, 1680, 1360};
    int[] box_sflag_ike_col_X = new int[]{1263, 3598, 785, 4845};
    int[] box_sflag_ike_col_Y = new int[]{1216, 1136, 1728, 1392};
    int[] box_sflag_ike_box_V = new int[]{-1, -1, 1, -1};
    private static boolean[] switchflag2;
    int[] break2_nflag_ike_brockTable = new int[]{4, 7, 5, 6, 0, 3, 2, 1};
    int[] break2_nflag_ike_brockTimeTable = new int[]{0, 5, 8, 17, 20, 28, 32, 34};
    int[] fire6_nflag_ike_posTable = new int[]{16, 16, 8, 8, 8};
    int[] fire6_nflag_ike_sizeTable = new int[]{32, 32, 24, 24, 16};
    int[] fire6_nflag_ike_sizeTable2 = new int[]{32, 32, 16, 24, 16};
    int[] mawaru_nflag_ike_posx = new int[]{-24, -47, -47, -46, -23, 1, 9, 1};
    int[] mawaru_nflag_ike_posy = new int[]{-47, -46, -24, 1, 8, 1, -23, -46};
    int[][] ele_nflag_ike_anime = new int[][]{{1, 0}, {1, 0}, {1, 1}, {0, 1}};
    int[][] beltc_nflag_ike_objectPos = new int[][]{{3604, 880, 3823, 770, 3823, 832, 3604, 942}, {3860, 736, 4079, 626, 4079, 688, 3860, 798}, {4116, 624, 4335, 514, 4335, 576, 4116, 686}, {3860, 1392, 4079, 1282, 4079, 1344, 3860, 1454}, {6932, 1648, 7151, 1538, 7151, 1600, 6932, 1710}, {7188, 1504, 7407, 1394, 7407, 1456, 7188, 1566}};
    int[] beltc_nflag_ike_defx = new int[]{3712, 3968, 3968, 4224, 7040, 7296};
    int[] beltc_nflag_ike_defy = new int[]{896, 768, 1280, 640, 1536, 1408};
    int[] beltc_nflag_ike_startPos = new int[2];
    int[] beltc_nflag_ike_endPos = new int[2];
    boolean gole_on = false;
    int[] bten_nflag_ike_score = new int[]{0, 10000, 1000, 100};
    int[][] shooter_nflag_ike_objectPos = new int[][]{{1940, 396}, {148, 920}, {1940, 756, 1956, 716, 2000, 696, 2136, 696, 2180, 676, 2196, 636, 2196, 412}, {2196, 1692}, {4500, 1148, 4484, 1188, 4440, 1208, 4048, 1208, 4004, 1228, 3988, 1268, 3988, 1436}, {4756, 1180}, {5524, 2040, 5508, 2000, 5472, 1980, 5328, 1980, 5284, 1960, 5268, 1920, 5268, 1440}, {2196, 144}};
    int[] shooter_nflag_ike_pos = new int[]{2, 4, 6, 8, 10, 12, 12, 9, 7, 4, 1, -2};
    int[] masin_nflag_ike_x = new int[]{-8, -16, -12, 12, 16, 8};
    int[] masin_nflag_ike_y = new int[]{22, 25, 13, 22, 25, 13};
    int[] yari_sflag_ike_PosTable = new int[]{48, 32, 16, 32};
    private static int[][] kassya_x;
    private static int[][] kassya_y;
    int[][] kassya_nflag_ike_objectPos = new int[][]{{4216, 538, 4286, 608, 4286, 915, 4236, 965, 4130, 912, 4130, 580}, {4734, 640, 4814, 720, 4814, 1134, 4658, 1056, 4658, 716}, {3362, 1154, 3362, 1502, 3502, 1502, 3502, 1154}, {3426, 930, 3566, 930, 3566, 1246, 3426, 1246}, {3244, 578, 3550, 578, 3550, 990, 3154, 990, 3154, 668}, {4690, 522, 5086, 522, 5086, 702, 4690, 702}};
    int[][] kassya_nflag_ike_defX = new int[][]{{4208, 4736}, {3432, 3488}, {4208, 4736}};
    int[][] kassya_nflag_ike_defY = new int[][]{{640, 768}, {1152, 896}, {640, 768}};
    int[] myogan_nflag_ike_ani = new int[]{2, 3, 2, 3, 2, 3, 2, 3, 2, 2, 3, 0, 1, 0, 1};
    int[][] step_nflag_ike_gura = new int[][]{{-1, 1}, {1, -1}};
    int[] fire6_nflag_ike_animeTable = new int[]{40, 40, 16, 16, 0};
    int[][] fire6_nflag_ike_rotTable = new int[][]{{TRANS_NONE, TRANS_MIRROR}, {TRANS_MIRROR, TRANS_NONE}, {TRANS_ROT180, TRANS_MIRROR_ROT180}, {0, 0}};
    int[][] ele_nflag_ike_rotTable = new int[][]{{TRANS_ROT180, TRANS_MIRROR_ROT180}, {TRANS_ROT180, TRANS_MIRROR_ROT180}, {TRANS_MIRROR, TRANS_NONE}, {TRANS_ROT180, TRANS_MIRROR_ROT180}};
    int[] item_nflag_ike_itemTable = new int[]{8, 0, 4, 3, 2, 1, 0};
    int[] gole_nflag_ike_rotTable = new int[]{rotNumTable[TRANS_NONE], rotNumTable[TRANS_ROT90], rotNumTable[TRANS_MIRROR_ROT270], rotNumTable[TRANS_MIRROR]};
    int[] gole_nflag_ike_kiraTableX = new int[]{8, 0, 40, 24, 10, 40, 30, 24, 41, 6};
    int[] gole_nflag_ike_kiraTableY = new int[]{8, 16, 8, 30, 23, 24, 18, 16, 18, 8};
    int[] yoganc_nflag_ike_posY = new int[]{0, 32, 64, 96, 128, 168, 208};
    int[] yari_sflag_ike_drawPosTable = new int[]{0, 6, 6, 4, 10, 2, 6, 4};

    private void crushingDeathChk() {
        if (debugFlag) {
            return;
        }
        if (this.crushing[0] && this.crushing[3]) {
            this.playerDie();
        } else if ((!PlayerJump || raidOn) && this.crushing[3]) {
            this.playerDie();
        } else if (this.zoneNumber != 2 && this.zoneNumber != 4) {
            if (raidOn && (this.blockColChk2(this.PlayerPosX() - 8, this.PlayerPosY() - 24) || this.blockColChk2(this.PlayerPosX() + 8, this.PlayerPosY() - 24))) {
                this.playerDie();
            }
        } else if (raidOn && this.blockColChk2(this.PlayerPosX() - 8, this.PlayerPosY() - 24) && this.blockColChk2(this.PlayerPosX() + 8, this.PlayerPosY() - 24)) {
            this.playerDie();
        }
        this.crushing[0] = false;
        this.crushing[3] = false;
    }

    MainCanvas(sonic sonic2) {
        super(false);
        h = sonic2;
    }

    public void keyPressed(int n) {
        if (PlayerNoCtrl && mode == MODE_FIELD) {
            return;
        }
        if (this.endingModeOn) {
            return;
        }
        int n2 = this.getGameAction(n);
        if (n2 == 8 || n == 53) {
            MainCanvas.KeyPress[0] = true;
        } else if (n2 == 6 || n == 56) {
            MainCanvas.KeyPress[1] = true;
        } else if (n2 == 1 || n == 50) {
            MainCanvas.KeyPress[2] = true;
        } else if (n2 == 2 || n == 52) {
            MainCanvas.KeyPress[3] = true;
        } else if (n2 == 5 || n == 54) {
            MainCanvas.KeyPress[4] = true;
        } else if (n == 48) {
            MainCanvas.KeyPress[7] = true;
        } else if (n == 42) {
            MainCanvas.KeyPress[8] = true;
        } else if (n == 35) {
            MainCanvas.KeyPress[9] = true;
        }
    }

    public void keyReleased(int n) {
        int n2 = this.getGameAction(n);
        if (n2 == 8 || n == 53) {
            MainCanvas.KeyPress[0] = false;
        } else if (n2 == 6 || n == 56) {
            MainCanvas.KeyPress[1] = false;
        } else if (n2 == 1 || n == 50) {
            MainCanvas.KeyPress[2] = false;
        } else if (n2 == 2 || n == 52) {
            MainCanvas.KeyPress[3] = false;
        } else if (n2 == 5 || n == 54) {
            MainCanvas.KeyPress[4] = false;
        } else if (n == 48) {
            MainCanvas.KeyPress[7] = false;
        } else if (n == 42) {
            MainCanvas.KeyPress[8] = false;
        } else if (n == 35) {
            MainCanvas.KeyPress[9] = false;
        }
    }

    public void clearKey() {
        MainCanvas.KeyPress[0] = false;
        MainCanvas.KeyPress[1] = false;
        MainCanvas.KeyPress[2] = false;
        MainCanvas.KeyPress[3] = false;
        MainCanvas.KeyPress[4] = false;
        MainCanvas.KeyPress[5] = false;
        MainCanvas.KeyPress[6] = false;
        MainCanvas.KeyPress[8] = false;
        MainCanvas.KeyPress[9] = false;
    }

    public void initAll() {
        try {
            try {
                gg = this.getGraphics();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            mode = MODE_INIT;
            this.displayOffsetY = this.getHeight() - 240 >> 1;
            this.displayOffsetY2 = this.displayOffsetY + 36;
            gg.translate(0, this.displayOffsetY);
            this.DG();
            this.load_conf();
            this.TK_LoadTextset();
            this.DG();
            this.m_imgCmd[MainCanvas.LOGO] = this.createImage("/logo.png");
            this.m_imgCmd[MainCanvas.LOGOLINE] = this.createImage("/logoline.png");
            this.m_imgCmd[MainCanvas.SYSTXT] = this.createImage("/Systxt.png");
            this.m_imgCmd[MainCanvas.SYSTXT2] = this.createImage("/Systxt2.png");
            this.m_imgCmd[MainCanvas.WINDOW_RING] = this.createImage("/windou_ring.png");
            this.m_imgCmd[MainCanvas.WINDOW_TIME] = this.createImage("/windou_time.png");
            this.m_imgCmd[MainCanvas.WINDOW_ZANKI] = this.createImage("/windou_zanki.png");
            this.m_imgCmd[MainCanvas.WINDOU_SUUJI] = this.createImage("/windou_suuji.png");
            this.m_imgCmd[MainCanvas.SYSSCORE] = this.createImage("/score.png");
            this.m_imgCmd[MainCanvas.GAMEOVER] = this.createImage("/gameover.png");
            this.m_imgCmd[MainCanvas.TIMEOVER] = this.createImage("/timeover.png");
            this.load_resu();
            this.load_hisc();
            FontPos = (20 - f.getHeight()) / 2;
            gg.setFont(f);
            this.m_imgCmd[MainCanvas.T_CUR1] = this.createImage("/t_cur1.png");
            this.m_imgCmd[MainCanvas.T_CUR2] = this.createImage("/t_cur2.png");
            initDisplay = true;
            this.DG();
            indata = new DataInputStream(this.getClass().getResourceAsStream("/scddirtbl.blt"));
            indata.read(scddirtbl);
            indata.close();
            mode = MODE_TITLE;
            this.SetSoftFlag = true;
            this.SetSoftCount = 10;
            this.InitObj2();
            DrawFlag = true;
            this.InitSound();
            this.TK_TitleInit(true);
            this.setCommandListener(this);
            ObjectListNum = 0;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void GameMain() {
        int n = 0;
        int n2 = 0;
        long l = 0L;
        long l2 = System.currentTimeMillis();
        while (true) {
            long l3;
            if (l > (l3 = System.currentTimeMillis())) {
                l = l3;
                l2 = 0L;
            } else {
                l = l3;
            }
            getTime2 = l - (l2 - (long)TIME_WAIT + 10L);
            if (l2 > l) {
                try {
                    Thread.sleep(l2 - l);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                l = System.currentTimeMillis();
                n = 0;
            } else if (++n > 1) {
                n = 0;
            } else if (n2 != 0) {
                n = 0;
            }
            this.ProcessMain();
            if (n <= 0) {
                this.DG();
                l2 = l + (long)(TIME_WAIT - 10);
            } else if (mode != MODE_FIELD || this.endingModeOn) {
                this.DG();
                l2 = l + (long)(TIME_WAIT - 10);
            } else {
                this.playerDraw = muteki2count > 0 ? --muteki2count % 2 == 0 : false;
                ++this.animeTimer;
            }
            if (++n2 <= 7) continue;
            n2 = 0;
        }
    }

    public void save_conf() {
        this.SaveRecordStore(m_nConfigValue, "conf");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void load_conf() {
        try {
            m_nConfigValue = this.LoadRecordStore("conf");
            if (m_nConfigValue[0] != 0) return;
        }
        catch (Throwable throwable) {
            m_bFirstSetUp = 1;
            m_nConfigValue = new byte[4];
            MainCanvas.m_nConfigValue[0] = 1;
            MainCanvas.m_nConfigValue[1] = 3;
            MainCanvas.m_nConfigValue[2] = 1;
            this.save_conf();
        }
    }

    public void save_resu() {
        byte[] byArray = new byte[7];
        byArray[0] = this.resumeStage;
        byArray[1] = this.resumeZanki;
        for (int i = 0; i < 4; ++i) {
            byArray[2 + i] = (byte)(this.resumeScore >> i * 8 % 256);
        }
        byArray[6] = this.clearStageData;
        this.SaveRecordStore(byArray, "resu");
    }

    public void load_resu() {
        try {
            byte[] byArray = this.LoadRecordStore("resu");
            this.resumeStage = byArray[0];
            this.resumeZanki = byArray[1];
            int n = 0;
            for (int i = 0; i < 4; ++i) {
                n |= (byArray[2 + i] & 0xFF) << i * 8;
            }
            this.resumeScore = n;
            this.clearStageData = byArray[6];
        }
        catch (Throwable throwable) {
            this.save_resu();
        }
    }

    public void save_hisc() {
        byte[] byArray = new byte[25];
        for (int i = 0; i < 5; ++i) {
            byArray[0 + i * 5] = (byte)m_nDifficulty[i];
            for (int j = 0; j < 4; ++j) {
                byArray[1 + j + i * 5] = (byte)(m_nHiScore[i] >> j * 8 % 256);
            }
        }
        this.SaveRecordStore(byArray, "hisc");
    }

    public void load_hisc() {
        try {
            byte[] byArray = this.LoadRecordStore("hisc");
            for (int i = 0; i < 5; ++i) {
                MainCanvas.m_nDifficulty[i] = byArray[0 + i * 5];
                int n = 0;
                for (int j = 0; j < 4; ++j) {
                    n |= (byArray[1 + j + i * 5] & 0xFF) << j * 8;
                }
                MainCanvas.m_nHiScore[i] = n;
            }
        }
        catch (Throwable throwable) {
            this.save_hisc();
        }
    }

    public void SetSoftLabel() {
        if (mode == MODE_TITLE) {
            if (m_nTitleMode == TITLE_MODE_TITLE || m_nTitleMode == TITLE_MODE_TITLE_MENU) {
                if (m_nConfigValue[1] != 0) {
                    this.SetSoftLabel(0, softKeys[14]);
                } else {
                    this.SetSoftLabel(0, softKeys[13]);
                }
            }
        } else {
            if (mode == MODE_CONTINUE || mode == MODE_STARTSTAGE || mode == MODE_FIELD || mode == MODE_STAGESELECT) {
                this.SetSoftLabel(0, "");
            } else if (m_nConfigValue[1] != 0) {
                this.SetSoftLabel(0, softKeys[14]);
            } else {
                this.SetSoftLabel(0, softKeys[13]);
            }
            if (mode == MODE_FIELD) {
                if (playercount <= 0 && PlayerDie || this.gole_on || this.endingModeOn) {
                    this.SetSoftLabel(1, "");
                } else {
                    this.SetSoftLabel(1, softKeys[5]);
                }
            } else if (mode == this.MODE_FIELD_PAUSE) {
                this.SetSoftLabel(1, softKeys[6]);
            } else if (mode == MODE_CONTINUE) {
                this.SetSoftLabel(1, softKeys[11]);
            } else if (mode == MODE_STAGESELECT) {
                this.SetSoftLabel(1, softKeys[4]);
            } else if (mode == MODE_STARTSTAGE) {
                this.SetSoftLabel(1, "");
            }
        }
    }

    public boolean softKeyChk() {
        try {
            if (moveRsm && this.CheckSoftLabel(1, softKeys[5])) {
                mode = this.MODE_FIELD_PAUSE;
                this.SetSoftFlag = true;
                this.SetSoftCount = 10;
                this.pauseTimer = 0;
                this.pauseSelect = 0;
                moveRsm = false;
                this.PauseMusic();
                return true;
            }
            moveRsm = false;
            int n = -1;
            if (KeyPress[5]) {
                MainCanvas.KeyPress[5] = false;
                n = 0;
            } else if (KeyPress[6]) {
                if (mode == MODE_TITLE) {
                    return false;
                }
                MainCanvas.KeyPress[6] = false;
                n = 1;
            }
            if (n != -1) {
                if (this.CheckSoftLabel(n, softKeys[4])) {
                    if (mode == MODE_STAGESELECT) {
                        mode = MODE_TITLE;
                        this.SetSoftFlag = true;
                        this.SetSoftCount = 10;
                        this.ObjImageClear();
                        this.TK_TitleInit(false);
                        m_nTitleMode = TITLE_MODE_TITLE_MENU;
                        m_nSel = 1;
                        this.TK_SetMarquee(7 + m_nSel);
                        this.SetSoftKey(2);
                    } else {
                        mode = MODE_TITLE;
                        this.SetSoftFlag = true;
                        this.SetSoftCount = 10;
                        this.ObjImageClear();
                        this.TK_TitleInit(false);
                    }
                    return true;
                }
                if (this.CheckSoftLabel(n, softKeys[5])) {
                    mode = this.MODE_FIELD_PAUSE;
                    this.SetSoftFlag = true;
                    this.SetSoftCount = 10;
                    this.pauseTimer = 0;
                    this.pauseSelect = 0;
                    this.PauseMusic();
                    return true;
                }
                if (this.CheckSoftLabel(n, softKeys[6])) {
                    this.save_conf();
                    mode = MODE_FIELD;
                    this.SetSoftFlag = true;
                    this.SetSoftCount = 10;
                    this.RestartMusic();
                    return true;
                }
                if (this.CheckSoftLabel(n, softKeys[11])) {
                    mode = MODE_TITLE;
                    this.SetSoftFlag = true;
                    this.SetSoftCount = 10;
                    this.ObjImageClear();
                    this.StopMusic();
                    this.TK_TitleInit(true);
                    return true;
                }
                if (this.CheckSoftLabel(n, softKeys[13])) {
                    MainCanvas.m_nConfigValue[1] = this.oldm_nConfigValue[1];
                    if (m_nConfigValue[1] == 0) {
                        MainCanvas.m_nConfigValue[1] = 3;
                    }
                    this.save_conf();
                    this.MuteMusic(false);
                    this.SetSoftFlag = true;
                    this.SetSoftCount = 10;
                    return true;
                }
                if (this.CheckSoftLabel(n, softKeys[14])) {
                    this.oldm_nConfigValue[1] = m_nConfigValue[1];
                    if (this.oldm_nConfigValue[1] == 0) {
                        this.oldm_nConfigValue[1] = 0;
                    }
                    MainCanvas.m_nConfigValue[1] = 0;
                    this.save_conf();
                    this.MuteMusic(true);
                    this.SetSoftFlag = true;
                    this.SetSoftCount = 10;
                    return true;
                }
                if (this.CheckSoftLabel(n, softKeys[2])) {
                    h.doExit();
                    return true;
                }
            }
        }
        catch (Throwable throwable) {
            moveRsm = false;
        }
        return false;
    }

    public void ProcessMain() {
        try {
            if (this.softKeyChk()) {
                this.clearKey();
                return;
            }
            if (mode == MODE_TITLE) {
                this.TK_TitleFactor();
            } else if (mode == this.MODE_FIELD_PAUSE) {
                this.playerStandCount = 0;
                if (KeyPress[0]) {
                    this.save_conf();
                    if (this.pauseSelect == 0) {
                        this.clearKey();
                        mode = MODE_FIELD;
                        this.SetSoftFlag = true;
                        this.SetSoftCount = 10;
                        this.RestartMusic();
                    } else {
                        mode = MODE_TITLE;
                        this.SetSoftFlag = true;
                        this.SetSoftCount = 10;
                        this.ObjImageClear();
                        this.TK_TitleInit(true);
                    }
                    this.clearKey();
                } else if (KeyPress[1]) {
                    this.clearKey();
                    this.pauseSelect = this.pauseSelect + 1 & 1;
                } else if (KeyPress[2]) {
                    this.clearKey();
                    this.pauseSelect = this.pauseSelect + 1 & 1;
                }
            } else if (mode == MODE_STAGESELECT) {
                if (KeyPress[0]) {
                    this.zoneNumber = encZoneNumber[this.selectZoneNumber][this.selectStageNumber];
                    this.stageNumber = encStageNumber[this.selectZoneNumber][this.selectStageNumber];
                    playercount = 3;
                    scorecount = 0;
                    readStageObjectFlag = true;
                    this.initStageStart();
                } else if (KeyPress[4]) {
                    this.clearKey();
                    int n = 18;
                    this.selectStageNumber = (this.selectStageNumber + 1) % 3;
                    if (this.selectStageNumber == 0) {
                        ++this.selectZoneNumber;
                    }
                    if (this.selectZoneNumber == n / 3) {
                        if (this.selectStageNumber > n % 3) {
                            this.selectZoneNumber = 0;
                            this.selectStageNumber = 0;
                        }
                    } else if (this.selectZoneNumber > n / 3) {
                        this.selectZoneNumber = 0;
                        this.selectStageNumber = 0;
                    }
                } else if (KeyPress[3]) {
                    this.clearKey();
                    int n = 18;
                    this.selectStageNumber = (this.selectStageNumber + 2) % 3;
                    if (this.selectStageNumber == 2) {
                        --this.selectZoneNumber;
                        if (this.selectZoneNumber < 0) {
                            this.selectZoneNumber = n / 3;
                            this.selectStageNumber = n % 3;
                        }
                    }
                }
                if (this.selectZoneNumber == 6) {
                    this.selectStageNumber = 0;
                }
            } else if (mode == MODE_FIELD) {
                MainCanvas.oldMapOxy[0] = mapOxy[0];
                MainCanvas.oldMapOxy[1] = mapOxy[1];
                for (int i = 0; i < 4; ++i) {
                    oldringcount = ringcount;
                    if (this.endingModeOn) {
                        this.SetSoftFlag = true;
                        this.SetSoftCount = 10;
                        this.clearKey();
                        this.moveEnding();
                    }
                    if (this.gole_on) {
                        this.SetSoftFlag = true;
                        this.SetSoftCount = 10;
                        TimerStop = true;
                    }
                    MainCanvas.ploldpos[0] = this.PlayerPosX();
                    MainCanvas.ploldpos[1] = this.PlayerPosY() - 1;
                    raidObjectW = 0;
                    raidObjectX = 0;
                    OttotoOn = false;
                    this.damageNow = false;
                    this.playdamageYogan = false;
                    try {
                        this.playerAction();
                        if (!PlayerDie) {
                            this.addObjectChk();
                            this.objectAction();
                        }
                        if (this.zoneNumber == 1) {
                            this.objAwaData_move();
                        }
                        if (!PlayerDie) {
                            this.DriveObj2();
                        }
                        if (this.playdamageYogan) {
                            this.playdamageset();
                        }
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                    this.moveObjData();
                    this.crushingDeathChk();
                    --speedupcount;
                    if (--mutekicount == 0) {
                        this.PlayZoneBGML();
                    }
                    if (speedupcount <= 0) {
                        plmaxspd = 1536;
                        pladdspd = 12;
                    }
                    this.limitchk(true);
                    this.ViewControl();
                    ++this.cpuTimer;
                    if (this.cpuTimer % 60 == 0 && !TimerStop && (timecount = (timecount + 1) % 60) == 0) {
                        if (timecount2 == 9) {
                            timecount = 59;
                            this.playerDie();
                        } else {
                            ++timecount2;
                        }
                    }
                    if (TimerClear) {
                        timecount = 0;
                        timecount2 = 0;
                    }
                    if (!PlayerDamage && ringcount >= 100 && oldringcount < 100) {
                        this.PlayMusic(13);
                        ++playercount;
                    }
                    if (!PlayerDamage && ringcount >= 200 && oldringcount < 200) {
                        this.PlayMusic(13);
                        ++playercount;
                    }
                    if (!PlayerDamage && ringcount >= 300 && oldringcount < 300) {
                        this.PlayMusic(13);
                        ++playercount;
                    }
                    if (this.PlayerPosY() < 32 && PlayerSJump && this.stageNumber == 3 && this.zoneNumber == 1) {
                        this.limitBreak = false;
                        this.scoreMoveFlag = false;
                        this.goleFlag = false;
                        this.gole_on = false;
                        plsaveX = 0;
                        plsaveY = 0;
                        plsaveTime = 0;
                        plsaveTime2 = 0;
                        this.noTimeScore = false;
                        this.selectStageNumber = (this.selectStageNumber + 1) % 3;
                        if (this.selectStageNumber == 0) {
                            ++this.selectZoneNumber;
                        }
                        this.resumeStage = (byte)(this.selectStageNumber + this.selectZoneNumber * 3);
                        this.resumeZanki = (byte)playercount;
                        this.resumeScore = scorecount;
                        if (this.clearStageData < this.resumeStage) {
                            this.clearStageData = this.resumeStage;
                        }
                        this.save_resu();
                        this.zoneNumber = encZoneNumber[this.selectZoneNumber][this.selectStageNumber];
                        this.stageNumber = encStageNumber[this.selectZoneNumber][this.selectStageNumber];
                        this.countClear();
                        readStageObjectFlag = true;
                        this.initStageStart();
                    }
                    if (mode == MODE_FIELD) {
                        continue;
                    }
                    break;
                }
            } else if (mode == MODE_CONTINUE) {
                ++this.cpuTimer;
                this.moveContinue();
            }
            this.moveSysString();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void DG() {
        try {
            this.Draw();
            if (this.SetSoftFlag) {
                this.SetSoftLabel();
                if (this.SetSoftCount > 0) {
                    --this.SetSoftCount;
                } else {
                    this.SetSoftFlag = false;
                }
            }
            if (drawRsm) {
                if (this.drawRsmCount == 0) {
                    this.drawRsmCount = 10;
                }
                if (this.drawRsmCount > 1) {
                    --this.drawRsmCount;
                } else {
                    this.drawRsmCount = 0;
                    drawRsm = false;
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void paint(Graphics graphics) {
    }

    public void Draw() {
        int n;
        try {
            if (mode == MODE_INIT) {
                gg.setClip(0, 0, 240, 240);
                gg.setColor(0);
                gg.fillRect(0, 0, 240, 320);
                this.TK_DrawStringC(m_strText[44], 120, 180, 0xFFFFFF, 658170);
            } else if (mode == this.MODE_FIELD_PAUSE) {
                gg.setClip(0, 0, 240, 240);
                gg.setFont(m_Font);
                this.TK_DrawBelt(true, false);
                this.TK_DrawStringC(softKeys[5], 120, 6, 0xFFFFFF, 0);
                this.drawField();
                gg.setColor(0);
                for (n = 0; n < 84; ++n) {
                    gg.fillRect(0, n * 2 + 36, 240, 1);
                }
                int[] nArray = new int[]{0, 0, 0, 2};
                int[] nArray2 = new int[]{0, 16, 32, 16};
                gg.drawRegion(this.m_imgObj[0], 0, nArray2[this.pauseTimer % 4], 16, 16, nArray[this.pauseTimer % 4], 120 - m_Font.stringWidth(softKeys[15 + this.pauseSelect]) / 2 - 16 - 14, 94 + 30 * this.pauseSelect, 20);
                gg.drawRegion(this.m_imgObj[0], 0, nArray2[this.pauseTimer % 4], 16, 16, nArray[this.pauseTimer % 4], 120 + m_Font.stringWidth(softKeys[15 + this.pauseSelect]) / 2 + 14, 94 + 30 * this.pauseSelect, 20);
                gg.setColor(0xFFFFFF);
                gg.drawString(softKeys[15], 120 - m_Font.stringWidth(softKeys[15]) / 2, 93, 20);
                gg.drawString(softKeys[16], 120 - m_Font.stringWidth(softKeys[16]) / 2, 123, 20);
                ++this.pauseTimer;
                initDisplay = true;
            } else if (mode == MODE_TITLE) {
                this.TK_TitleDraw();
            } else if (mode == MODE_STAGESELECT) {
                if (initDisplay) {
                    gg.setClip(0, 0, 240, 240);
                    gg.drawImage(this.m_imgCmd[LOGOLINE], 0, 0, 20);
                    gg.drawImage(this.m_imgCmd[LOGOLINE], 0, 204, 20);
                    gg.drawImage(this.m_imgCmd[LOGO], 153, 209, 20);
                    initDisplay = false;
                }
                gg.setColor(0);
                gg.fillRect(0, 36, 240, 168);
                this.SysCenter = 120 + this.SystxtTable[this.zonetable[this.selectZoneNumber]][2] / 2;
                gg.drawRegion(this.m_imgCmd[SYSTXT], this.SystxtTable[this.DAEN_B][0], this.SystxtTable[this.DAEN_B][1], this.SystxtTable[this.DAEN_B][2], this.SystxtTable[this.DAEN_B][3], rotNumTable[TRANS_NONE], this.SysCenter - this.SystxtTable[this.DAEN_B][2] - 1, 82, 20);
                if (this.selectZoneNumber == 6) {
                    gg.drawRegion(this.m_imgCmd[SYSTXT], this.SystxtTable[this.ZONE][0], this.SystxtTable[this.ZONE][1], this.SystxtTable[this.ZONE][2], this.SystxtTable[this.ZONE][3], rotNumTable[TRANS_NONE], this.SysCenter - 48, 100, 20);
                } else {
                    gg.drawRegion(this.m_imgCmd[SYSTXT], this.SystxtTable[this.ACT1 + this.selectStageNumber][0], this.SystxtTable[this.ACT1 + this.selectStageNumber][1], this.SystxtTable[this.ACT1 + this.selectStageNumber][2], this.SystxtTable[this.ACT1 + this.selectStageNumber][3], rotNumTable[TRANS_NONE], this.SysCenter - this.SystxtTable[this.DAEN_B][2] + 25, 108, 20);
                    gg.drawRegion(this.m_imgCmd[SYSTXT], this.SystxtTable[this.ACT][0], this.SystxtTable[this.ACT][1], this.SystxtTable[this.ACT][2], this.SystxtTable[this.ACT][3], rotNumTable[TRANS_NONE], this.SysCenter - this.SystxtTable[this.DAEN_B][2] + 1, 116, 20);
                    gg.drawRegion(this.m_imgCmd[SYSTXT], this.SystxtTable[this.ZONE][0], this.SystxtTable[this.ZONE][1], this.SystxtTable[this.ZONE][2], this.SystxtTable[this.ZONE][3], rotNumTable[TRANS_NONE], this.SysCenter - 65, 100, 20);
                }
                gg.drawRegion(this.m_imgCmd[SYSTXT], this.SystxtTable[this.zonetable[this.selectZoneNumber]][0], this.SystxtTable[this.zonetable[this.selectZoneNumber]][1], this.SystxtTable[this.zonetable[this.selectZoneNumber]][2], this.SystxtTable[this.zonetable[this.selectZoneNumber]][3], rotNumTable[TRANS_NONE], 120 - this.SystxtTable[this.zonetable[this.selectZoneNumber]][2] / 2, 84, 20);
                gg.drawImage(this.m_imgCmd[T_CUR1], 213, 96, 20);
                gg.drawImage(this.m_imgCmd[T_CUR2], 22, 96, 20);
            } else if (mode == MODE_CONTINUE) {
                gg.setClip(0, 0, 240, 240);
                ++this.animeTimer;
                this.drawContinue();
            } else if (mode == MODE_STARTSTAGE) {
                gg.setClip(0, 0, 240, 240);
                gg.drawImage(this.m_imgCmd[LOGOLINE], 0, 0, 20);
                gg.drawImage(this.m_imgCmd[LOGOLINE], 0, 204, 20);
                gg.drawImage(this.m_imgCmd[LOGO], 153, 209, 20);
                initDisplay = false;
                gg.setColor(0);
                gg.fillRect(0, 36, 240, 168);
            } else if (mode == MODE_FIELD) {
                if (initDisplay) {
                    gg.setClip(0, 0, 240, 240);
                    gg.drawImage(this.m_imgCmd[LOGOLINE], 0, 0, 20);
                    gg.drawImage(this.m_imgCmd[LOGOLINE], 0, 204, 20);
                    gg.drawImage(this.m_imgCmd[LOGO], 153, 209, 20);
                    this.drawRingFlag = true;
                    this.drawZankiFlag = true;
                    this.drawZankiFlag = true;
                    this.drawSystemData();
                    initDisplay = false;
                } else {
                    this.drawSystemData();
                }
                this.playerDraw = muteki2count > 0 ? --muteki2count % 2 == 0 : false;
                this.drawField();
                ++this.animeTimer;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (mode == MODE_STARTSTAGE || mode == MODE_FIELD) {
            int n2;
            if (this.outWipe) {
                gg.setColor(0);
                for (n = 0; n < 10; ++n) {
                    n2 = 24 - (this.wipeCount - n) * 4;
                    if (n2 <= 0) {
                        n2 = 0;
                        continue;
                    }
                    if (n2 > 24) {
                        n2 = 24;
                    }
                    gg.fillRect(n * 24 + (24 - n2), 0, n2, 240);
                }
                if (22 < this.wipeCount) {
                    this.wipeCount = 0;
                    this.outWipe = false;
                }
                ++this.wipeCount;
            }
            this.drawSysString();
            if (this.putWipe) {
                gg.setColor(0);
                for (n = 0; n < 10; ++n) {
                    if (this.wipeCount - n <= 0) continue;
                    n2 = this.wipeCount - n << 2;
                    if (n2 > 24) {
                        n2 = 24;
                    }
                    gg.fillRect(n * 24, 0, n2, 240);
                }
                if (22 < this.wipeCount) {
                    this.wipeCount = 0;
                    this.putWipe = false;
                }
                ++this.wipeCount;
            }
            if (this.putNowLoading) {
                this.TK_DrawStringC(m_strText[44], 120, 180, 0xFFFFFF, 658170);
            }
        }
        if (drawRsm || this.drawZankiFlag || this.drawTimeFlag || this.drawRingFlag || mode != MODE_FIELD) {
            this.drawRingFlag = false;
            this.drawTimeFlag = false;
            this.drawZankiFlag = false;
            this.flushGraphics(0, this.displayOffsetY, 240, 240);
        } else {
            this.flushGraphics(0, this.displayOffsetY2, 240, 168);
        }
        this.serviceRepaints();
    }

    public void drawField() {
        gg.setClip(0, 36, 240, 168);
        if (!pauseGame) {
            int n;
            DistantBg.paint(mapView[0], mapView[1]);
            if (this.zoneNumber == 1 || this.zoneNumber == 5) {
                this.DrawMap(gg);
            } else {
                this.DrawMap3(gg);
            }
            this.CallObjectDraw();
            this.DrawObj2();
            if (!PlayerDie) {
                this.drawPlayerImage(gg);
            }
            this.drawObjData();
            if (this.zoneNumber == 1 || this.zoneNumber == 5) {
                this.DrawMap2(gg);
            } else {
                this.DrawMap4(gg);
            }
            this.CallObjectDrawFront();
            if (this.zoneNumber == 1) {
                this.objAwaData_draw();
            }
            if (PlayerDie) {
                this.drawPlayerImage(gg);
            }
            if (this.zoneNumber == 1) {
                n = (168 - (this.waterH2 - mapView[1])) / 16 + 1;
                int n2 = (this.waterH2 - mapView[1]) % 2;
                if (n2 < 0) {
                    n2 = 0;
                }
                for (int i = 0; i < n; ++i) {
                    if (i == 0) {
                        for (int j = 0; j < 8; ++j) {
                            this.drawRegion(gg, this.m_imgObj[111], 0, this.animeTimer % 3 * 16, 32, 16, rotNumTable[0], j * 32, this.waterH2 - mapView[1] - 8, 20);
                        }
                    }
                    if (i == 0) {
                        this.drawRegion(gg, this.m_imgObj[5], 0, n2, 240, 16 - n2, rotNumTable[0], 0, this.waterH2 - mapView[1] + i * 16, 20);
                        continue;
                    }
                    this.drawRegion(gg, this.m_imgObj[5], 0, 0, 240, 16, rotNumTable[0], 0, this.waterH2 - mapView[1] + i * 16 - n2, 20);
                }
                if (this.bressCount < 600 && this.bressCount / 60 % 2 == 1) {
                    if (this.bressMusic) {
                        this.PlayMusic(24);
                        this.bressMusic = false;
                    }
                    this.drawNumber(116, 80, this.bressCount / 60 / 2, 1);
                }
                if (this.bressCount >= 600) {
                    if (!this.bressMusic) {
                        this.PlayZoneBGML();
                    }
                    this.bressMusic = true;
                }
            }
            if (this.endingModeOn) {
                this.drawEnding();
            }
            if (playercount <= 0 && PlayerDie || this.timeUpDie && timecount == 59 && timecount2 == 9) {
                n = (660 - diecount) * 6;
                if (120 - n < 8) {
                    n = 112;
                }
                if (timecount == 59 && timecount2 == 9) {
                    gg.drawRegion(this.m_imgCmd[TIMEOVER], 0, 0, 64, 16, rotNumTable[TRANS_NONE], n - 64, 108, 20);
                    gg.drawRegion(this.m_imgCmd[TIMEOVER], 0, 16, 64, 16, rotNumTable[TRANS_NONE], 240 - n, 108, 20);
                } else {
                    gg.drawRegion(this.m_imgCmd[GAMEOVER], 0, 0, 64, 16, rotNumTable[TRANS_NONE], n - 64, 108, 20);
                    gg.drawRegion(this.m_imgCmd[GAMEOVER], 0, 16, 64, 16, rotNumTable[TRANS_NONE], 240 - n, 108, 20);
                }
            }
        }
    }

    public void ObjImageClear() {
        this.m_imgObj = null;
        try {
            System.gc();
            Thread.sleep(200L);
            this.m_imgObj = new Image[150];
            System.gc();
            Thread.sleep(200L);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void StageDataTableClear() {
        MainCanvas.zoneActTable[0] = null;
        MainCanvas.zoneActTable[1] = null;
        MainCanvas.zoneActTable[2] = null;
        MainCanvas.zoneActTable[3] = null;
        try {
            System.gc();
            Thread.sleep(200L);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void scroll(Graphics graphics, int n, int n2) {
    }

    public boolean CheckSoftLabel(int n, String string) {
        String[] stringArray = new String[2];
        stringArray[n] = cmd[n].getLabel();
        return stringArray[n].equals(string);
    }

    public void SetSoftLabel(int n, String string) {
        String[] stringArray = new String[2];
        try {
            stringArray[0] = cmd[0].getLabel();
            stringArray[1] = cmd[1].getLabel();
            if (stringArray[n].equals(string)) {
                return;
            }
            this.removeCommand(cmd[1]);
            this.removeCommand(cmd[0]);
            stringArray[n] = string;
            MainCanvas.cmd[0] = new Command(stringArray[0], 1, 1);
            MainCanvas.cmd[1] = new Command(stringArray[1], 1, 1);
            this.addCommand(cmd[0]);
            this.addCommand(cmd[1]);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public String ZeroSup(int n, int n2) {
        String string = n + "";
        for (int i = string.length(); i < n2; ++i) {
            string = 0 + string;
        }
        return string;
    }

    public String ZeroSup(String string, int n) {
        String string2 = string;
        for (int i = string2.length(); i < n; ++i) {
            string2 = 0 + string2;
        }
        return string2;
    }

    public boolean DrawWaterMap(int n, int n2, int n3, int n4) {
        if (this.zoneNumber == 1) {
            if (n > 60 && n < 100) {
                this.drawRegion(gg, this.m_imgObj[84], (n -= 60) % 10 << 4, (n / 10 << 4) + (this.animeTimer % 4 << 4 << 2), 16, 16, rotNumTable[n2], n3, n4, 20);
                return false;
            }
            if (n >= 186) {
                this.drawRegion(gg, this.m_imgObj[84], (n -= 186) % 10 << 4, (n / 10 << 4) + (this.animeTimer % 4 << 4) + 256, 16, 16, rotNumTable[n2], n3, n4, 20);
                return false;
            }
        } else if (this.zoneNumber == 5 && this.animeTimer % 3 != 0) {
            if (n >= 250 && n < 290) {
                this.drawRegion(gg, this.m_imgObj[84], (n -= 250) % 10 << 4, (n / 10 << 4) + (this.animeTimer % 3 - 1 << 4 << 2), 16, 16, rotNumTable[n2], n3, n4, 20);
                return false;
            }
            if (n >= 560 && n < 570) {
                this.drawRegion(gg, this.m_imgObj[84], (n -= 560) % 10 << 4, (n / 10 << 4) + (this.animeTimer % 3 - 1 << 4) + 128, 16, 16, rotNumTable[n2], n3, n4, 20);
                return false;
            }
            if (n >= 30 && n < 90) {
                this.drawRegion(gg, this.m_imgObj[84], (n -= 30) % 10 << 4, (n / 10 << 4) + (this.animeTimer % 3 - 1) * 96 + 160, 16, 16, rotNumTable[n2], n3, n4, 20);
                return false;
            }
        }
        return true;
    }

    public void setMapData() {
        for (int i = 0; i < mapData.length >> 1; ++i) {
            int n = mapData[i << 1] & 0xFF;
            this.hitChk[i] = 0;
            this.hitChk2[i] = 0;
            byte by = (byte)(n << 6);
            by = (byte)Math.abs(by >> 6);
            if (n >> 5 <= 1) {
                this.hitChk2[i] = 1;
            }
            if ((n >> 5) % 2 == 0) {
                this.hitChk[i] = 1;
            }
            this.rot[i] = (byte)(n >> 3 & 3);
            this.imageOffset[i] = 0;
            if ((n & 1) == 1) {
                this.imageOffset[i] = 1;
                continue;
            }
            if ((n & 3) != 2) continue;
            this.imageOffset[i] = 2;
        }
    }

    public void DrawMapRegion(int n, int n2, int n3, int n4) {
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        for (n5 = n; n5 < n + n3; ++n5) {
            if (MapW << 4 <= (mapView[0] >> 4) + n5) continue;
            for (n6 = n2; n6 < n2 + n4; ++n6) {
                int n9 = (mapView[0] >> 4) + n5 >> 4;
                int n10 = (mapView[1] >> 4) + n6 >> 4;
                n10 %= MapH;
                try {
                    n8 = (tempWorldMapData[n10][n9] << 9) + (((mapView[0] >> 4) + n5 & 0xF) + (((mapView[1] >> 4) + n6 & 0xF) << 4) << 1) + 1;
                    n7 = mapData[n8] & 0xFF;
                    if ((n7 += this.imageOffset[n8 >> 1] << 8) == 0) continue;
                    if (this.zoneNumber == 2) {
                        if (n7 == 367 || n7 == 366) {
                            n7 = (n7 + this.animeTimer / 5 & 1) + 366;
                        }
                        if (n7 == 365 || n7 == 364) {
                            n7 = (n7 + this.animeTimer / 5 & 1) + 364;
                        }
                        if (n7 == 363 || n7 == 362) {
                            n7 = (n7 + this.animeTimer / 5 & 1) + 362;
                        }
                    }
                    int n11 = TRANS_NONE;
                    if (this.rot[n8 >> 1] != 0) {
                        if (this.rot[n8 >> 1] == 1) {
                            n11 = TRANS_MIRROR;
                        } else if (this.rot[n8 >> 1] == 2) {
                            n11 = TRANS_MIRROR_ROT180;
                        } else if (this.rot[n8 >> 1] == 3) {
                            n11 = TRANS_ROT180;
                        }
                    }
                    this.drawRegion(gg, m_imgMimg, n7 % 10 << 4, n7 / 10 << 4, 16, 16, rotNumTable[n11], (n5 << 4) - (mapView[0] & 0xF), (n6 << 4) - (mapView[1] & 0xF), 20);
                    continue;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        }
    }

    public void DrawMap(Graphics graphics) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < 16; ++i) {
            if (MapW << 4 <= (mapView[0] >> 4) + i) {
                this.drawMapData[i][n][2] = 0;
                continue;
            }
            for (n = 0; n < 12; ++n) {
                int n4 = (mapView[0] >> 4) + i >> 4;
                int n5 = (mapView[1] >> 4) + n >> 4;
                n5 %= MapH;
                try {
                    n3 = (tempWorldMapData[n5][n4] << 9) + (((mapView[0] >> 4) + i & 0xF) + (((mapView[1] >> 4) + n & 0xF) << 4) << 1) + 1;
                    n2 = mapData[n3] & 0xFF;
                    this.drawMapData[i][n][0] = n2 += this.imageOffset[n3 >> 1] << 8;
                    if (n2 == 0) continue;
                    int n6 = TRANS_NONE;
                    if (this.rot[n3 >> 1] != 0) {
                        if (this.rot[n3 >> 1] == 1) {
                            n6 = TRANS_MIRROR;
                        } else if (this.rot[n3 >> 1] == 2) {
                            n6 = TRANS_MIRROR_ROT180;
                        } else if (this.rot[n3 >> 1] == 3) {
                            n6 = TRANS_ROT180;
                        }
                    }
                    this.drawMapData[i][n][1] = n6;
                    this.drawMapData[i][n][2] = 0;
                    if (mapFrontData[n2] != 0) {
                        this.drawMapData[i][n][2] = 1;
                        if (mapFrontData[n2] != 2) continue;
                        gg.setColor(8738);
                        gg.fillRect((i << 4) - (mapView[0] & 0xF), (n << 4) - (mapView[1] & 0xF) + 36, 16, 16);
                        continue;
                    }
                    if (!this.DrawWaterMap(n2, n6, (i << 4) - (mapView[0] & 0xF), (n << 4) - (mapView[1] & 0xF))) continue;
                    this.drawRegion(graphics, m_imgMimg, n2 % 10 << 4, n2 / 10 << 4, 16, 16, rotNumTable[n6], (i << 4) - (mapView[0] & 0xF), (n << 4) - (mapView[1] & 0xF), 20);
                    continue;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        }
    }

    public void DrawMap2(Graphics graphics) {
        int n = 0;
        for (int i = 0; i < 16; ++i) {
            if (MapW << 4 <= (mapView[0] >> 4) + i) continue;
            for (n = 0; n < 12; ++n) {
                try {
                    if (this.drawMapData[i][n][2] != 1 || !this.DrawWaterMap(this.drawMapData[i][n][0], this.drawMapData[i][n][1], (i << 4) - (mapView[0] & 0xF), (n << 4) - (mapView[1] & 0xF))) continue;
                    this.drawRegion(graphics, m_imgMimg, this.drawMapData[i][n][0] % 10 << 4, this.drawMapData[i][n][0] / 10 << 4, 16, 16, rotNumTable[this.drawMapData[i][n][1]], (i << 4) - (mapView[0] & 0xF), (n << 4) - (mapView[1] & 0xF), 20);
                    continue;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        }
    }

    public void DrawMap3(Graphics graphics) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < 16; ++i) {
            if (MapW << 4 <= (mapView[0] >> 4) + i) {
                this.drawMapData[i][n][2] = 0;
                continue;
            }
            for (n = 0; n < 12; ++n) {
                int n4 = (mapView[0] >> 4) + i >> 4;
                int n5 = (mapView[1] >> 4) + n >> 4;
                n5 %= MapH;
                try {
                    n3 = (tempWorldMapData[n5][n4] << 9) + (((mapView[0] >> 4) + i & 0xF) + (((mapView[1] >> 4) + n & 0xF) << 4) << 1) + 1;
                    n2 = mapData[n3] & 0xFF;
                    this.drawMapData[i][n][0] = n2 += this.imageOffset[n3 >> 1] << 8;
                    if (n2 == 0) continue;
                    if (this.zoneNumber == 2) {
                        if (n2 == 367 || n2 == 366) {
                            n2 = (n2 + this.animeTimer / 5 & 1) + 366;
                        }
                        if (n2 == 365 || n2 == 364) {
                            n2 = (n2 + this.animeTimer / 5 & 1) + 364;
                        }
                        if (n2 == 363 || n2 == 362) {
                            n2 = (n2 + this.animeTimer / 5 & 1) + 362;
                        }
                    }
                    int n6 = TRANS_NONE;
                    if (this.rot[n3 >> 1] != 0) {
                        if (this.rot[n3 >> 1] == 1) {
                            n6 = TRANS_MIRROR;
                        } else if (this.rot[n3 >> 1] == 2) {
                            n6 = TRANS_MIRROR_ROT180;
                        } else if (this.rot[n3 >> 1] == 3) {
                            n6 = TRANS_ROT180;
                        }
                    }
                    this.drawMapData[i][n][1] = n6;
                    this.drawMapData[i][n][2] = 0;
                    if (mapFrontData[n2] != 0) {
                        this.drawMapData[i][n][2] = 1;
                        continue;
                    }
                    this.drawRegion(graphics, m_imgMimg, n2 % 10 << 4, n2 / 10 << 4, 16, 16, rotNumTable[n6], (i << 4) - (mapView[0] & 0xF), (n << 4) - (mapView[1] & 0xF), 20);
                    continue;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        }
    }

    public void DrawMap4(Graphics graphics) {
        int n = 0;
        for (int i = 0; i < 16; ++i) {
            if (MapW << 4 <= (mapView[0] >> 4) + i) continue;
            for (n = 0; n < 12; ++n) {
                try {
                    if (this.drawMapData[i][n][2] != 1) continue;
                    this.drawRegion(graphics, m_imgMimg, this.drawMapData[i][n][0] % 10 << 4, this.drawMapData[i][n][0] / 10 << 4, 16, 16, rotNumTable[this.drawMapData[i][n][1]], (i << 4) - (mapView[0] & 0xF), (n << 4) - (mapView[1] & 0xF), 20);
                    continue;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        }
    }

    public void drawHitMap() {
    }

    public void drawChipPut(int n, int n2, int n3) {
        int n4 = (blockLinkTable[n3] & 0xFF) * 16;
        gg.setColor(0xFFFFFF);
        for (int i = 0; i < 16; ++i) {
            gg.fillRect(n + i, n2 + 36 + 16 - Math.abs(scdtblwk[n4 + i]), 1, Math.abs(scdtblwk[n4 + i]));
            if (Math.abs(scdtblwk[n4 + i + 4096]) <= 16) continue;
        }
        gg.setColor(0);
        this.drawStringCenter(gg, f, n3 + "", n, n2, true);
    }

    public void drawStringCenter(Graphics graphics, Font font, String string, int n, int n2, boolean bl) {
        if (bl) {
            this.drawString(graphics, string, n - font.stringWidth(string) / 2, n2);
        }
    }

    public void drawString(Graphics graphics, String string, int n, int n2) {
        graphics.drawString(string, n - 1, n2 += FontPos, 20);
        graphics.drawString(string, n + 1, n2, 20);
        graphics.drawString(string, n, n2 + 1, 20);
        graphics.drawString(string, n, n2 - 1, 20);
        graphics.setColor(0xFFFFFF);
        graphics.drawString(string, n, n2, 20);
    }

    public int dSin(int n) {
        int n2 = n % 360;
        if (n2 >= 0 && n2 <= 90) {
            return sinData[n2] / 100;
        }
        if (n2 > 90 && n2 <= 180) {
            return sinData[90 - (n2 - 90)] / 100;
        }
        if (n2 > 180 && n2 <= 270) {
            return -1 * (sinData[n2 - 180] / 100);
        }
        if (n2 > 270 && n2 <= 359) {
            return -1 * (sinData[90 - (n2 - 270)] / 100);
        }
        return 0;
    }

    public int dCos(int n) {
        int n2 = n % 360;
        if (n2 >= 0 && n2 < 90) {
            return -1 * sinData[89 - n2] / 100;
        }
        if (n2 >= 90 && n2 < 180) {
            return sinData[n2 - 90] / 100;
        }
        if (n2 >= 180 && n2 < 270) {
            return sinData[89 - (n2 - 180)] / 100;
        }
        if (n2 >= 270 && n2 <= 359) {
            return -1 * (sinData[n2 - 270] / 100);
        }
        return 0;
    }

    private void addScoreCount(int n) {
        if (99950000 > scorecount && scorecount % 50000 > (scorecount + n) % 50000) {
            ++playercount;
            this.PlayMusic(13);
        }
        if ((scorecount += n) > 99999999) {
            scorecount = 99999999;
        }
    }

    private void addScoreCount(int n, int n2) {
        if (99950000 > scorecount && scorecount % 50000 > (scorecount + n) % 50000) {
            ++playercount;
            this.PlayMusic(30);
        }
        if ((scorecount += n) > 99999999) {
            scorecount = 99999999;
        }
    }

    public void drawSystemData() {
        gg.setClip(0, 0, 240, 240);
        if (this.oldRingCount != ringcount || this.oldScoreCount != scorecount) {
            this.drawRingFlag = true;
        } else if (ringcount == 0 && (this.animeTimer & 1) == 0) {
            this.drawRingFlag = true;
        }
        this.oldRingCount = ringcount;
        this.oldScoreCount = scorecount;
        if (this.drawRingFlag) {
            gg.drawRegion(this.m_imgCmd[LOGOLINE], 0, 0, 100, 32, rotNumTable[TRANS_NONE], 0, 0, 20);
            gg.drawRegion(this.m_imgCmd[WINDOW_RING], 0, 0, 55, 26, rotNumTable[TRANS_NONE], 4, 5, 20);
            if (ringcount != 0 || (this.animeTimer >> 1 & 1) == 0) {
                this.drawNumber(31, 3, ringcount, 3);
            }
            this.drawNumber(31, 18, scorecount, 8);
        }
        if (timecount == 0 || this.oldTimeCount != timecount2 * 100 + timecount) {
            this.drawTimeFlag = true;
        }
        this.oldTimeCount = timecount2 * 100 + timecount;
        if (this.drawTimeFlag) {
            gg.drawRegion(this.m_imgCmd[LOGOLINE], 192, 0, 48, 32, rotNumTable[TRANS_NONE], 192, 0, 20);
            gg.drawRegion(this.m_imgCmd[WINDOW_TIME], 0, 0, 44, 13, rotNumTable[TRANS_NONE], 192, 18, 20);
            this.drawNumber(200, 16, timecount2, 1);
            this.drawNumber(216, 16, timecount, 2);
        }
        if (playercount > 99) {
            playercount = 99;
        }
        if (this.oldZankiCount != playercount) {
            this.drawZankiFlag = true;
        }
        this.oldZankiCount = playercount;
        if (this.drawZankiFlag) {
            gg.drawRegion(this.m_imgCmd[LOGOLINE], 0, 0, 50, 32, rotNumTable[TRANS_NONE], 0, 204, 20);
            gg.drawRegion(this.m_imgCmd[WINDOW_ZANKI], 0, 0, 22, 20, rotNumTable[TRANS_NONE], 5, 213, 20);
            if (playercount > 9) {
                this.drawNumber(31, 219, playercount, 2);
            } else {
                this.drawNumber(31, 219, playercount, 1);
            }
        }
    }

    public void drawNumber(int n, int n2, int n3, int n4) {
        int n5 = n3 % 10;
        gg.drawRegion(this.m_imgCmd[WINDOU_SUUJI], 7 * n5, 0, 7, 13, rotNumTable[TRANS_NONE], n + (n4 << 3) - 8, n2, 20);
        for (int i = 1; i < n4; ++i) {
            int n6 = 1;
            for (int j = 0; j < i; ++j) {
                n6 *= 10;
            }
            n5 = n3 / n6 % 10;
            gg.drawRegion(this.m_imgCmd[WINDOU_SUUJI], 7 * n5, 0, 7, 13, rotNumTable[TRANS_NONE], n + (n4 << 3) - (i << 3) - 8, n2, 20);
        }
    }

    private boolean kyuryuchk() {
        if (this.zoneNumber == 1) {
            if (this.stageNumber == 0) {
                try {
                    int[][] nArray = this.searchObject(62, 227);
                    if (nArray.length > 0 && nArray[0][5] != 0 && this.kyuryuTable[0][0] <= this.PlayerPosX() && this.kyuryuTable[0][2] > this.PlayerPosX() && this.kyuryuTable[0][1] <= this.PlayerPosY() - 16 && this.kyuryuTable[0][3] > this.PlayerPosY() - 16) {
                        return true;
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                if (this.kyuryuTable[1][0] <= this.PlayerPosX() && this.kyuryuTable[1][2] > this.PlayerPosX() && this.kyuryuTable[1][1] <= this.PlayerPosY() && this.kyuryuTable[1][3] > this.PlayerPosY()) {
                    return true;
                }
            } else if (this.stageNumber == 1) {
                try {
                    if (this.animeTimer % 60 < 30 && this.kyuryuTable[2][0] <= this.PlayerPosX() && this.kyuryuTable[2][2] > this.PlayerPosX() && this.kyuryuTable[2][1] <= this.PlayerPosY() && this.kyuryuTable[2][3] > this.PlayerPosY()) {
                        return true;
                    }
                    int[][] nArray = this.searchObject(93, -1);
                    if (nArray.length > 0 ? nArray[0][2] < this.PlayerPosX() && this.kyuryuTable[2][0] <= this.PlayerPosX() && this.kyuryuTable[2][2] > this.PlayerPosX() && this.kyuryuTable[2][1] <= this.PlayerPosY() && this.kyuryuTable[2][3] > this.PlayerPosY() : ((nArray = this.searchObject(92, -1)).length > 0 ? nArray[0][2] < this.PlayerPosX() && this.kyuryuTable[2][0] <= this.PlayerPosX() && this.kyuryuTable[2][2] > this.PlayerPosX() && this.kyuryuTable[2][1] <= this.PlayerPosY() && this.kyuryuTable[2][3] > this.PlayerPosY() : this.kyuryuTable[2][0] <= this.PlayerPosX() && this.kyuryuTable[2][2] > this.PlayerPosX() && this.kyuryuTable[2][1] <= this.PlayerPosY() && this.kyuryuTable[2][3] > this.PlayerPosY())) {
                        return true;
                    }
                }
                catch (Throwable throwable) {}
            } else if (this.stageNumber == 2) {
                try {
                    if (this.animeTimer % 60 < 30 && this.kyuryuTable[3][0] <= this.PlayerPosX() && this.kyuryuTable[3][2] > this.PlayerPosX() && this.kyuryuTable[3][1] <= this.PlayerPosY() && this.kyuryuTable[3][3] > this.PlayerPosY()) {
                        return true;
                    }
                    int[][] nArray = this.searchObject(93, -1);
                    if (nArray.length > 0 ? nArray[0][2] < this.PlayerPosX() && this.kyuryuTable[3][0] <= this.PlayerPosX() && this.kyuryuTable[3][2] > this.PlayerPosX() && this.kyuryuTable[3][1] <= this.PlayerPosY() && this.kyuryuTable[3][3] > this.PlayerPosY() : ((nArray = this.searchObject(92, -1)).length > 0 ? nArray[0][2] < this.PlayerPosX() && this.kyuryuTable[3][0] <= this.PlayerPosX() && this.kyuryuTable[3][2] > this.PlayerPosX() && this.kyuryuTable[3][1] <= this.PlayerPosY() && this.kyuryuTable[3][3] > this.PlayerPosY() : this.kyuryuTable[3][0] <= this.PlayerPosX() && this.kyuryuTable[3][2] > this.PlayerPosX() && this.kyuryuTable[3][1] <= this.PlayerPosY() && this.kyuryuTable[3][3] > this.PlayerPosY())) {
                        return true;
                    }
                }
                catch (Throwable throwable) {}
            } else if (this.stageNumber == 3) {
                try {
                    if (this.animeTimer % 60 < 30 && this.kyuryuTable[4][0] <= this.PlayerPosX() && this.kyuryuTable[4][2] > this.PlayerPosX() && this.kyuryuTable[4][1] <= this.PlayerPosY() && this.kyuryuTable[4][3] > this.PlayerPosY()) {
                        return true;
                    }
                    int[][] nArray = this.searchObject(93, -1);
                    if (nArray.length > 0 ? nArray[0][2] < this.PlayerPosX() && this.kyuryuTable[4][0] <= this.PlayerPosX() && this.kyuryuTable[4][2] > this.PlayerPosX() && this.kyuryuTable[4][1] <= this.PlayerPosY() && this.kyuryuTable[4][3] > this.PlayerPosY() : ((nArray = this.searchObject(92, -1)).length > 0 ? nArray[0][2] < this.PlayerPosX() && this.kyuryuTable[4][0] <= this.PlayerPosX() && this.kyuryuTable[4][2] > this.PlayerPosX() && this.kyuryuTable[4][1] <= this.PlayerPosY() && this.kyuryuTable[4][3] > this.PlayerPosY() : this.kyuryuTable[4][0] <= this.PlayerPosX() && this.kyuryuTable[4][2] > this.PlayerPosX() && this.kyuryuTable[4][1] <= this.PlayerPosY() && this.kyuryuTable[4][3] > this.PlayerPosY())) {
                        return true;
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        }
        return false;
    }

    public void initGoleStart() {
        this.SysString = new int[this.SysStringMax][15];
        this.PlayMusic(20);
        int n = 0;
        this.SysCount = 0;
        this.golecount = 30;
        this.goleFlag = true;
        this.SysString[n][0] = 1;
        this.SysString[n][1] = this.DAEN_B;
        this.SysString[n][2] = 240;
        this.SysString[n][3] = 82;
        this.SysString[n][8] = 1 - this.SystxtTable[this.SysString[0][1]][2];
        this.SysString[n][9] = 0;
        this.SysString[++n][0] = 1;
        this.SysString[n][1] = this.ACT1 + this.selectStageNumber;
        this.SysString[n][2] = 240;
        this.SysString[n][3] = 108;
        this.SysString[n][8] = 25 - this.SystxtTable[this.SysString[0][1]][2];
        this.SysString[n][9] = 3;
        this.SysString[++n][0] = 1;
        this.SysString[n][1] = this.ACT;
        this.SysString[n][2] = 240;
        this.SysString[n][3] = 116;
        this.SysString[n][8] = -1 - this.SystxtTable[this.SysString[0][1]][2];
        this.SysString[n][9] = 2;
        this.SysString[++n][0] = 1;
        this.SysString[n][1] = this.SONIC_HAS;
        this.SysString[n][2] = 0 - this.SystxtTable[this.SysString[n][1]][2];
        this.SysString[n][3] = 84;
        this.SysString[n][8] = -this.SystxtTable[this.SysString[n][1]][2];
        this.SysString[n][9] = 0;
        this.SysCenter = 120 + this.SystxtTable[this.SysString[n][1]][2] / 2;
        this.SysString[++n][0] = 1;
        this.SysString[n][1] = this.PASSED;
        this.SysString[n][2] = 0 - this.SystxtTable[this.SysString[n][1]][2];
        this.SysString[n][3] = 100;
        this.SysString[n][8] = -this.SystxtTable[this.SysString[n - 1][1]][2] / 2 - this.SystxtTable[this.SysString[n][1]][2] / 2;
        this.SysString[n][9] = 1;
        ++n;
        for (int i = 0; i < this.SysString.length; ++i) {
            if (this.SysString[i][0] != 1) continue;
            this.SysString[i][4] = this.SystxtTable[this.SysString[i][1]][0];
            this.SysString[i][5] = this.SystxtTable[this.SysString[i][1]][1];
            this.SysString[i][6] = this.SystxtTable[this.SysString[i][1]][2];
            this.SysString[i][7] = this.SystxtTable[this.SysString[i][1]][3];
        }
    }

    public void initStageStart() {
        int n;
        try {
            this.water_flag = 0;
            this.water_flag2 = 0;
            this.water_flag3 = 0;
            this.water_flag4 = 0;
            bossModeOn = false;
            bossBreakOn = false;
            this.gole_on = false;
            this.ChkVecR = true;
            this.ChkVecL = true;
            MapEndCounter = 0;
            this.bressCount = 2100;
            this.bressMusic = true;
            indata = new DataInputStream(this.getClass().getResourceAsStream("/zone" + (this.zoneNumber + 1) + ".bmd"));
            MapW = worldMapData[this.zoneNumber][this.stageNumber][0].length;
            MapH = worldMapData[this.zoneNumber][this.stageNumber].length;
            tempWorldMapData = new byte[MapH][MapW];
            for (n = 0; n < MapH; ++n) {
                for (int i = 0; i < MapW; ++i) {
                    MainCanvas.tempWorldMapData[n][i] = worldMapData[this.zoneNumber][this.stageNumber][n][i];
                }
            }
            indata.read(mapData);
            indata.close();
            this.setMapData();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        this.InitObj2();
        this.SysString = new int[this.SysStringMax][15];
        this.cpuTimer = 0;
        this.animeTimer = 0;
        mutekicount = 0;
        muteki2count = 0;
        this.objChkNum = 0;
        this.objChkPoint = 0;
        mode = MODE_STARTSTAGE;
        this.SetSoftFlag = true;
        this.SetSoftCount = 10;
        this.m_bScrollLock = 0;
        this.limitBreak = false;
        this.ResetSound();
        this.PlayZoneBGM();
        int n2 = 0;
        this.SysCount = 0;
        this.SysString[n2][0] = 1;
        this.SysString[n2][1] = this.DAEN_B;
        this.SysString[n2][2] = 240;
        this.SysString[n2][3] = 82;
        this.SysString[n2][8] = 1 - this.SystxtTable[this.SysString[0][1]][2];
        this.SysString[n2][9] = 0;
        this.SysString[++n2][0] = 1;
        this.SysString[n2][1] = this.ACT1 + this.selectStageNumber;
        this.SysString[n2][2] = 240;
        this.SysString[n2][3] = 108;
        this.SysString[n2][8] = 25 - this.SystxtTable[this.SysString[0][1]][2];
        this.SysString[n2][9] = 3;
        this.SysString[++n2][0] = 1;
        this.SysString[n2][1] = this.ACT;
        this.SysString[n2][2] = 240;
        this.SysString[n2][3] = 116;
        this.SysString[n2][8] = -1 - this.SystxtTable[this.SysString[0][1]][2];
        this.SysString[n2][9] = 2;
        this.SysString[++n2][0] = 1;
        this.SysString[n2][1] = this.zonetable[this.selectZoneNumber];
        this.SysString[n2][2] = 0 - this.SystxtTable[this.SysString[n2][1]][2];
        this.SysString[n2][3] = 84;
        this.SysString[n2][8] = -this.SystxtTable[this.SysString[n2][1]][2];
        this.SysString[n2][9] = 0;
        this.SysCenter = 120 + this.SystxtTable[this.SysString[n2][1]][2] / 2;
        ++n2;
        if (this.selectZoneNumber == 6) {
            this.SysString[n2][0] = 1;
            this.SysString[n2][1] = this.ZONE;
            this.SysString[n2][2] = 0 - this.SystxtTable[this.SysString[n2][1]][2];
            this.SysString[n2][3] = 100;
            this.SysString[n2][8] = -48;
            this.SysString[n2][9] = 1;
        } else {
            this.SysString[n2][0] = 1;
            this.SysString[n2][1] = this.ZONE;
            this.SysString[n2][2] = 0 - this.SystxtTable[this.SysString[n2][1]][2];
            this.SysString[n2][3] = 100;
            this.SysString[n2][8] = -65;
            this.SysString[n2][9] = 1;
        }
        ++n2;
        for (n = 0; n < this.SysString.length; ++n) {
            if (this.SysString[n][0] != 1) continue;
            this.SysString[n][4] = this.SystxtTable[this.SysString[n][1]][0];
            this.SysString[n][5] = this.SystxtTable[this.SysString[n][1]][1];
            this.SysString[n][6] = this.SystxtTable[this.SysString[n][1]][2];
            this.SysString[n][7] = this.SystxtTable[this.SysString[n][1]][3];
        }
    }

    public void drawNumber2(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6 = n3 % 10;
        int n7 = 1;
        while (true) {
            n5 = 1;
            for (n4 = 0; n4 < n7; ++n4) {
                n5 *= 10;
            }
            if (n3 / n5 == 0) break;
            ++n7;
        }
        n5 = n7;
        this.drawRegion(gg, this.m_imgCmd[SYSTXT2], 8 * n6, 48, 8, 16, rotNumTable[TRANS_NONE], n - 8, n2, 20);
        for (n7 = 1; n7 < n5; ++n7) {
            int n8 = 1;
            for (n4 = 0; n4 < n7; ++n4) {
                n8 *= 10;
            }
            n6 = n3 / n8 % 10;
            this.drawRegion(gg, this.m_imgCmd[SYSTXT2], 8 * n6, 48, 8, 16, rotNumTable[TRANS_NONE], n - n7 * 8 - 8, n2, 20);
        }
    }

    public void readStageObject() {
        try {
            this.ObjImageClear();
            this.StageDataTableClear();
            this.initStage(this.zoneNumber + 1);
            this.objectInit(this.stageNumber);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void countClear() {
        int n;
        ringcount = 0;
        timecount = 0;
        timecount2 = 0;
        diecount = 0;
        bariacount = 0;
        speedupcount = 0;
        mutekicount = 0;
        muteki2count = 0;
        this.damageMoveTimer = 0;
        this.LookUpCount = 0;
        this.CrouchCount = 0;
        for (int i = 0; i < objData.length; ++i) {
            MainCanvas.objData[i][0] = 0;
        }
        PlayerSJump = false;
        PlayerDamage = false;
        PlayerDush = false;
        PlayerWater = false;
        PlayerSWater = false;
        PlayerBou = false;
        PlayerJump = false;
        PlayerBall = false;
        PlayerDie = false;
        this.bressDie = false;
        this.timeUpDie = false;
        PlayerCrouch = false;
        PlayerLookUp = false;
        PlayerNoCol = false;
        PlayerNoCtrl = false;
        TimerStop = false;
        TimerClear = false;
        comboScore = 0;
        for (n = 0; n < 256; ++n) {
            MainCanvas.switchflag[n] = false;
            MainCanvas.switchflag2[n] = false;
        }
        ObjectListNum = 0;
        this.noDataPointer = 0;
        for (n = 0; n < ObjectList.length; ++n) {
            MainCanvas.ObjectList[n][24] = 0;
        }
    }

    public void endStageStart() {
        this.clearKey();
        this.drawRingFlag = true;
        this.drawZankiFlag = true;
        this.drawZankiFlag = true;
        this.countClear();
        if (this.stageNumber == 2 && this.zoneNumber == 4) {
            this.AddObjectData(150, 11424, 1394, 0, 0);
        }
        for (int i = 0; i < PlayerParam.length; ++i) {
            MainCanvas.PlayerParam[i] = 0;
        }
        olddir = 0;
        MainCanvas.plspeed[0] = 0;
        MainCanvas.plspeed[1] = 0;
        int[][] nArrayArray = new int[][]{{80, 944, 80, 252, 80, 944, 128, 168}, {96, 108, 80, 236, 80, 748, 2944, 0}, {48, 614, 48, 614, 48, 358, 128, 168}, {64, 716, 64, 332, 64, 332, 128, 168}, {48, 957, 48, 445, 48, 236, 128, 168}, {48, 1164, 48, 1868, 8512, 1452, 128, 168, 304, 168}, {1568, 363, 3808, 364, 128, 168, 128, 168}};
        MainCanvas.mapOxy[0] = 0;
        MainCanvas.mapOxy[1] = 0;
        if (this.zoneNumber == 5 && this.stageNumber == 3) {
            MainCanvas.PlayerParam[0] = nArrayArray[this.zoneNumber][8] << 8;
            MainCanvas.PlayerParam[1] = (nArrayArray[this.zoneNumber][9] << 8) + 5120;
        } else {
            MainCanvas.PlayerParam[0] = nArrayArray[this.zoneNumber][this.stageNumber * 2 + 0] << 8;
            MainCanvas.PlayerParam[1] = (nArrayArray[this.zoneNumber][this.stageNumber * 2 + 1] << 8) + 5120;
        }
        if (plsaveX != 0 || plsaveY != 0) {
            MainCanvas.PlayerParam[0] = plsaveX << 8;
            MainCanvas.PlayerParam[1] = plsaveY << 8;
            timecount = plsaveTime;
            timecount2 = plsaveTime2;
            this.water_flag = 0;
            if (this.zoneNumber == 1 && this.stageNumber == 2) {
                this.water_flag = 1;
                if (plsaveX > 4864) {
                    this.water_flag = (byte)2;
                }
            }
        }
        this.limitchk(false);
        this.InitViewControl();
        this.waterMove();
        this.waterH3 = this.waterH;
        this.waterMove();
        MainCanvas.PlayerParam[8] = -1;
        MainCanvas.PlayerParam[9] = 1;
        mode = MODE_FIELD;
        this.addObjectChk();
        this.SetSoftFlag = true;
        this.SetSoftCount = 10;
    }

    public void initStage(int n) {
        this.LoadImages(n);
        try {
            this.water_flag = 0;
            this.water_flag2 = 0;
            this.water_flag3 = 0;
            this.water_flag4 = 0;
            bossModeOn = false;
            this.ChkVecR = true;
            this.ChkVecL = true;
            if (this.zoneNumber != 1) {
                this.waterH3 = 0xFFFFFF;
                this.waterH2 = 0xFFFFFF;
                this.waterH = 0xFFFFFF;
            } else {
                int[] nArray = new int[]{184, 808, 2304, 552};
                this.waterH2 = this.waterH3 = nArray[this.stageNumber];
                this.waterH = this.waterH3;
            }
            MainCanvas.mapOxy[0] = 0;
            MainCanvas.oldMapOxy[0] = 0;
            MainCanvas.mapOxy[1] = 0;
            MainCanvas.oldMapOxy[1] = 0;
            indata = new DataInputStream(this.getClass().getResourceAsStream("/zone" + n + ".blt"));
            indata.read(blockLinkTable);
            indata.close();
            indata = new DataInputStream(this.getClass().getResourceAsStream("/MapLzone" + n + ".blt"));
            indata.read(mapFrontData);
            indata.close();
            indata = new DataInputStream(this.getClass().getResourceAsStream("/ZONE" + n + "ACT.act"));
            MainCanvas.zoneActTable[0] = new byte[indata.readShort()];
            MainCanvas.zoneActTable[1] = new byte[indata.readShort()];
            MainCanvas.zoneActTable[2] = new byte[indata.readShort()];
            MainCanvas.zoneActTable[3] = new byte[indata.readShort()];
            indata.read(zoneActTable[0]);
            indata.read(zoneActTable[1]);
            indata.read(zoneActTable[2]);
            indata.read(zoneActTable[3]);
            indata.close();
            indata = new DataInputStream(this.getClass().getResourceAsStream("/scdtblwk.scd"));
            indata.read(scdtblwk);
            indata.close();
            indata = new DataInputStream(this.getClass().getResourceAsStream("/blkcol.bct"));
            indata.read(blockColTable);
            indata.close();
            this.m_imgObj[0] = this.createImage("/ring.png");
            this.m_imgObj[36] = this.createImage("/save.png");
            this.m_imgObj[42] = this.createImage("/item.png");
            this.m_imgObj[109] = this.createImage("/effect.png");
            this.m_imgObj[9] = this.createImage("/toge.png");
            if (this.zoneNumber == 0) {
                this.m_imgObj[3] = this.createImage("/buranko.png");
            }
            if (this.zoneNumber != 5) {
                this.m_imgObj[55] = this.createImage("/masin.png");
            }
            this.m_imgObj[MainCanvas.SJUMP] = this.createImage("/sjump.png");
            this.m_imgObj[1] = this.createImage("/sjump2.png");
            if (this.zoneNumber == 4) {
                this.m_imgObj[16] = this.createImage("/shima5.png");
            } else if (this.zoneNumber == 0) {
                this.m_imgObj[16] = this.createImage("/shima.png");
            }
            if (this.zoneNumber == 0) {
                this.m_imgObj[5] = this.createImage("/hashi.png");
                this.m_imgObj[58] = this.createImage("/jyama.png");
                this.m_imgObj[6] = this.createImage("/break.png");
                this.m_imgObj[37] = this.createImage("/kageb.png");
            }
            if (this.zoneNumber == 1) {
                if (this.stageNumber < 3) {
                    this.m_imgObj[83] = this.createImage("/dai3.png");
                    this.m_imgObj[107] = this.createImage("/dai2_0xE0.png");
                    this.m_imgObj[108] = this.createImage("/dai2_0xF0.png");
                    this.m_imgObj[82] = this.createImage("/kazari.png");
                    this.m_imgObj[88] = this.createImage("/kassya.png");
                    this.m_imgObj[84] = this.createImage("/mizu.png");
                    this.m_imgObj[110] = this.createImage("/mizu_0x09.png");
                    this.m_imgObj[80] = this.createImage("/yari.png");
                    this.m_imgObj[85] = this.createImage("/awa.png");
                    this.m_imgObj[104] = this.createImage("/objawa.png");
                    this.m_imgObj[105] = this.createImage("/dai3_0x27.png");
                    this.m_imgObj[106] = this.createImage("/dai3_0x13.png");
                    this.m_imgObj[91] = this.createImage("/bou.png");
                    this.m_imgObj[92] = this.createImage("/ben.png");
                    this.m_imgObj[5] = this.createImage("/water.png");
                    this.m_imgObj[111] = this.createImage("/water2.png");
                } else {
                    this.m_imgObj[83] = this.createImage("/z_dai3.png");
                    this.m_imgObj[105] = this.createImage("/z_dai3_0x27.png");
                    this.m_imgObj[106] = this.createImage("/z_dai3_0x13.png");
                    this.m_imgObj[107] = this.createImage("/z_dai2_0xE0.png");
                    this.m_imgObj[108] = this.createImage("/z_dai2_0xF0.png");
                    this.m_imgObj[82] = this.createImage("/z_kazari.png");
                    this.m_imgObj[88] = this.createImage("/kassya.png");
                    this.m_imgObj[84] = this.createImage("/z_mizu.png");
                    this.m_imgObj[110] = this.createImage("/mizu_0x09.png");
                    this.m_imgObj[80] = this.createImage("/yari.png");
                    this.m_imgObj[85] = this.createImage("/awa.png");
                    this.m_imgObj[104] = this.createImage("/objawa.png");
                    this.m_imgObj[91] = this.createImage("/bou.png");
                    this.m_imgObj[92] = this.createImage("/z_ben.png");
                    this.m_imgObj[5] = this.createImage("/water.png");
                    this.m_imgObj[111] = this.createImage("/water2.png");
                }
            }
            if (this.zoneNumber == 2) {
                this.m_imgObj[79] = this.createImage("/ochi.png");
                this.m_imgObj[54] = this.createImage("/dai.png");
                this.m_imgObj[8] = this.createImage("/turi.png");
                this.m_imgObj[94] = this.createImage("/turi2.png");
                this.m_imgObj[95] = this.createImage("/turi3.png");
                this.m_imgObj[13] = this.createImage("/yogan2.png");
                this.m_imgObj[99] = this.createImage("/yogan22.png");
                this.m_imgObj[11] = this.createImage("/fblock.png");
                this.m_imgObj[77] = this.createImage("/yoganc.png");
                this.m_imgObj[14] = this.createImage("/myogan.png");
                this.m_imgObj[98] = this.createImage("/myogan2.png");
                this.m_imgObj[7] = this.createImage("/yuka.png");
                this.m_imgObj[27] = this.createImage("/bryuka.png");
            }
            this.m_imgObj[15] = this.createImage("/switch.png");
            if (this.zoneNumber == 3) {
                this.m_imgObj[22] = this.createImage("/fun.png");
                this.m_imgObj[MainCanvas.BRKABE] = this.createImage("/brkabe.png");
                this.m_imgObj[MainCanvas.PEDAL] = this.createImage("/pedal.png");
                this.m_imgObj[MainCanvas.STEP] = this.createImage("/step.png");
                this.m_imgObj[73] = this.createImage("/elev.png");
                this.m_imgObj[23] = this.createImage("/sisoo.png");
            }
            if (this.zoneNumber == 4) {
                this.m_imgObj[MainCanvas.DAI2] = this.createImage("/dai2.png");
                this.m_imgObj[61] = this.createImage("/signal.png");
                this.m_imgObj[56] = this.createImage("/bobin.png");
            }
            if (this.zoneNumber == 5 && this.stageNumber != 3) {
                this.m_imgObj[MainCanvas.PATA] = this.createImage("/paka2.png");
                this.m_imgObj[33] = this.createImage("/ele.png");
                this.m_imgObj[28] = this.createImage("/mawaru.png");
                this.m_imgObj[29] = this.createImage("/yukai.png");
                this.m_imgObj[32] = this.createImage("/dai4.png");
                this.m_imgObj[12] = this.createImage("/dai_.png");
            }
            this.m_imgObj[26] = this.createImage("/fire6.png");
            if (this.zoneNumber == 4) {
                this.m_imgObj[83] = this.createImage("/dai4_.png");
            }
            this.m_imgObj[96] = this.createImage("/tama.png");
            this.m_imgObj[97] = this.createImage("/bakuhatu.png");
            this.IkeshitaLoadStageImage(n);
            this.AraiLoadStageImage(n);
            DistantBg.setStage(this.zoneNumber, this.stageNumber);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void LoadImages(int n) {
        try {
            m_imgMimg = null;
            System.gc();
            Thread.sleep(200L);
            m_imgMimg = n == 2 && this.stageNumber == 3 ? this.createImage("/z_zone2.png") : this.createImage("/zone" + n + ".png");
            if (this.m_imgCmd[SONIC_N] == null) {
                this.m_imgCmd[MainCanvas.SONIC_N] = this.createImage("/sonic.png");
            }
            if (this.m_imgCmd[SONIC_S] == null) {
                this.m_imgCmd[MainCanvas.SONIC_S] = this.createImage("/sonic_s.png");
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void playerAction() {
        this.waterMove();
        if (debugFlag) {
            if (KeyPress[2]) {
                PlayerParam[1] = KeyPress[0] ? PlayerParam[1] - 128 : PlayerParam[1] - 2048;
            }
            if (KeyPress[1]) {
                PlayerParam[1] = KeyPress[0] ? PlayerParam[1] + 128 : PlayerParam[1] + 2048;
            } else if (KeyPress[3]) {
                PlayerParam[0] = KeyPress[0] ? PlayerParam[0] - 128 : PlayerParam[0] - 2048;
            } else if (KeyPress[4]) {
                PlayerParam[0] = KeyPress[0] ? PlayerParam[0] + 128 : PlayerParam[0] + 2048;
            }
        } else if (PlayerNoCol || PlayerNoCtrl) {
            PlayerParam[11] = PlayerParam[11] + plmaxspd;
        } else if (PlayerDie) {
            PlayerParam[1] = PlayerParam[1] + PlayerParam[5];
            PlayerParam[5] = PlayerParam[5] + gravity;
        } else if (this.kyuryuchk()) {
            if (this.damageMoveTimer > 0) {
                --this.damageMoveTimer;
                PlayerParam[1] = PlayerParam[1] - PlayerParam[3] * 2;
                PlayerParam[0] = PlayerParam[0] + PlayerParam[5];
                PlayerParam[5] = PlayerParam[5] + gravity;
            } else {
                for (int i = 0; i < 4; ++i) {
                    int n;
                    MainCanvas.PlayerParam[3] = 512;
                    if ((this.PlayerPosY() - 24) % 128 < 64) {
                        if (this.blockColChk(this.PlayerPosX() + 24, this.PlayerPosY() - 24)) {
                            PlayerParam[1] = PlayerParam[1] + 256;
                            for (n = 0; this.blockColChk(this.PlayerPosX() + 24, this.PlayerPosY() - 24) && n <= 24; ++n) {
                                PlayerParam[0] = PlayerParam[0] - 256;
                            }
                        } else if (this.blockColChk(this.PlayerPosX() + 24, this.PlayerPosY())) {
                            PlayerParam[1] = PlayerParam[1] - 256;
                            for (n = 0; this.blockColChk(this.PlayerPosX() + 24, this.PlayerPosY()) && n <= 24; ++n) {
                                PlayerParam[0] = PlayerParam[0] - 256;
                            }
                        } else {
                            PlayerParam[0] = PlayerParam[0] + PlayerParam[3];
                        }
                    } else if (this.blockColChk(this.PlayerPosX() + 24, this.PlayerPosY())) {
                        PlayerParam[1] = PlayerParam[1] - 256;
                        for (n = 0; this.blockColChk(this.PlayerPosX() + 24, this.PlayerPosY()) && n <= 24; ++n) {
                            PlayerParam[0] = PlayerParam[0] - 256;
                        }
                    } else if (this.blockColChk(this.PlayerPosX() + 24, this.PlayerPosY() - 24)) {
                        PlayerParam[1] = PlayerParam[1] + 256;
                        for (n = 0; this.blockColChk(this.PlayerPosX() + 24, this.PlayerPosY() - 24) && n <= 24; ++n) {
                            PlayerParam[0] = PlayerParam[0] - 256;
                        }
                    } else {
                        PlayerParam[0] = PlayerParam[0] + PlayerParam[3];
                    }
                    if (KeyPress[2] && i == 0) {
                        PlayerParam[1] = PlayerParam[1] - 256;
                        if (this.blockColChk_Enemy(this.PlayerPosX() + 24, this.PlayerPosY() - 24)) {
                            PlayerParam[1] = PlayerParam[1] + 256;
                        }
                    }
                    if (!KeyPress[1] || i != 0) continue;
                    PlayerParam[1] = PlayerParam[1] + 256;
                }
                PlayerJump = true;
                PlayerDamage = false;
                PlayerSWater = true;
                MainCanvas.PlayerParam[3] = 2048;
            }
        } else if (this.ballchk()) {
            if (this.ball00walk()) {
                this.ball00jump();
            }
        } else if (this.play00walk()) {
            this.play00jump();
        }
    }

    public int rnd(int n) {
        return Math.abs(this.rnd.nextInt()) % n;
    }

    public boolean blockColChk(int n, int n2) {
        try {
            if (n < 0) {
                n = 0;
            }
            if (n2 < 0) {
                n2 = 0;
            }
            ++this.blockColCount;
            int n3 = (tempWorldMapData[(n2 >> 4 >> 4) % MapH][n >> 4 >> 4] << 9) + ((n >> 4 & 0xF) + ((n2 >> 4 & 0xF) << 4) << 1) + 1;
            if (this.hitChk[n3 >> 1] == 1) {
                return false;
            }
            int n4 = (blockLinkTable[(mapData[n3] & 0xFF) + (this.imageOffset[n3 >> 1] << 8)] & 0xFF) << 5;
            if (this.rot[n3 >> 1] == 1 ? 0 == (blockColTable[n4 + (15 - (n & 0xF) << 1) + ((n2 & 0xF) >> 3)] >> 7 - (n2 & 7) & 1) : (this.rot[n3 >> 1] == 2 ? 0 == (blockColTable[n4 + ((n & 0xF) << 1) + (15 - (n2 & 0xF) >> 3)] >> (n2 & 7) & 1) : (this.rot[n3 >> 1] == 3 ? 0 == (blockColTable[n4 + (15 - (n & 0xF) << 1) + (15 - (n2 & 0xF) >> 3)] >> (n2 & 7) & 1) : 0 == (blockColTable[n4 + ((n & 0xF) << 1) + ((n2 & 0xF) >> 3)] >> 7 - (n2 & 7) & 1)))) {
                return false;
            }
            MainCanvas.PlayerParam[8] = n4 = (mapData[n3] & 0xFF) + (this.imageOffset[n3 >> 1] << 8);
            if (this.zoneNumber == 1) {
                if (n4 > 70 && n4 < 84) {
                    PlayerWater = true;
                    MainCanvas.PlayerParam[12] = 0;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                    MainCanvas.PlayerParam[10] = 4096;
                    if (this.rot[n3 >> 1] == 0) {
                        MainCanvas.PlayerParam[12] = 1;
                        MainCanvas.PlayerParam[13] = 0;
                        MainCanvas.PlayerParam[14] = 0;
                        MainCanvas.PlayerParam[10] = -4096;
                    }
                } else {
                    n2 -= 16;
                    if (n < 0) {
                        n = 0;
                    }
                    if (n2 < 0) {
                        n2 = 0;
                    }
                    if ((n4 = (mapData[n3 = (tempWorldMapData[(n2 >> 4 >> 4) % MapH][n >> 4 >> 4] << 9) + ((n >> 4 & 0xF) + ((n2 >> 4 & 0xF) << 4) << 1) + 1] & 0xFF) + (this.imageOffset[n3 >> 1] << 8)) == 83 || n4 == 186) {
                        PlayerWater = true;
                        MainCanvas.PlayerParam[12] = 0;
                        MainCanvas.PlayerParam[13] = 0;
                        MainCanvas.PlayerParam[14] = 0;
                        MainCanvas.PlayerParam[10] = 4096;
                        if (this.rot[n3 >> 1] == 0) {
                            MainCanvas.PlayerParam[12] = 1;
                            MainCanvas.PlayerParam[13] = 0;
                            MainCanvas.PlayerParam[14] = 0;
                            MainCanvas.PlayerParam[10] = -4096;
                        }
                    } else {
                        n2 += 16;
                        if ((n -= 16) < 0) {
                            n = 0;
                        }
                        if (n2 < 0) {
                            n2 = 0;
                        }
                        PlayerWater = (n4 = (mapData[n3 = (tempWorldMapData[(n2 >> 4 >> 4) % MapH][n >> 4 >> 4] << 9) + ((n >> 4 & 0xF) + ((n2 >> 4 & 0xF) << 4) << 1) + 1] & 0xFF) + (this.imageOffset[n3 >> 1] << 8)) == 71 || n4 == 72;
                    }
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return true;
    }

    public boolean blockColChk2(int n, int n2) {
        int n3;
        if (n < 0) {
            n = 0;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (this.hitChk2[(n3 = (tempWorldMapData[(n2 >> 4 >> 4) % MapH][n >> 4 >> 4] << 9) + ((n >> 4 & 0xF) + ((n2 >> 4 & 0xF) << 4) << 1) + 1) >> 1] == 1) {
            return false;
        }
        int n4 = (blockLinkTable[(mapData[n3] & 0xFF) + (this.imageOffset[n3 >> 1] << 8)] & 0xFF) << 5;
        if (this.rot[n3 >> 1] == 1 ? 0 == (blockColTable[n4 + (15 - (n & 0xF) << 1) + ((n2 & 0xF) >> 3)] >> 7 - (n2 & 7) & 1) : (this.rot[n3 >> 1] == 2 ? 0 == (blockColTable[n4 + ((n & 0xF) << 1) + (15 - (n2 & 0xF) >> 3)] >> (n2 & 7) & 1) : (this.rot[n3 >> 1] == 3 ? 0 == (blockColTable[n4 + (15 - (n & 0xF) << 1) + (15 - (n2 & 0xF) >> 3)] >> (n2 & 7) & 1) : 0 == (blockColTable[n4 + ((n & 0xF) << 1) + ((n2 & 0xF) >> 3)] >> 7 - (n2 & 7) & 1)))) {
            return false;
        }
        MainCanvas.PlayerParam[8] = n4 = (mapData[n3] & 0xFF) + (this.imageOffset[n3 >> 1] << 8);
        return true;
    }

    public boolean blockColChk_easy(int n, int n2) {
        int n3;
        if (n < 0) {
            n = 0;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        return this.hitChk[(n3 = (tempWorldMapData[(n2 >> 4 >> 4) % MapH][n >> 4 >> 4] << 9) + ((n >> 4 & 0xF) + ((n2 >> 4 & 0xF) << 4) << 1) + 1) >> 1] != 1;
    }

    public boolean blockColChk_Enemy(int n, int n2) {
        try {
            int n3;
            if (n < 0) {
                n = 0;
            }
            if (n2 < 0) {
                n2 = 0;
            }
            if (this.hitChk[(n3 = (tempWorldMapData[(n2 >> 4 >> 4) % MapH][n >> 4 >> 4] << 9) + ((n >> 4 & 0xF) + ((n2 >> 4 & 0xF) << 4) << 1) + 1) >> 1] == 1 && this.hitChk2[n3 >> 1] == 1) {
                return false;
            }
            int n4 = (blockLinkTable[(mapData[n3] & 0xFF) + (this.imageOffset[n3 >> 1] << 8)] & 0xFF) << 5;
            if (this.rot[n3 >> 1] == 1 ? 0 == (blockColTable[n4 + (15 - (n & 0xF) << 1) + ((n2 & 0xF) >> 3)] >> 7 - (n2 & 7) & 1) : (this.rot[n3 >> 1] == 2 ? 0 == (blockColTable[n4 + ((n & 0xF) << 1) + (15 - (n2 & 0xF) >> 3)] >> (n2 & 7) & 1) : (this.rot[n3 >> 1] == 3 ? 0 == (blockColTable[n4 + (15 - (n & 0xF) << 1) + (15 - (n2 & 0xF) >> 3)] >> (n2 & 7) & 1) : 0 == (blockColTable[n4 + ((n & 0xF) << 1) + ((n2 & 0xF) >> 3)] >> 7 - (n2 & 7) & 1)))) {
                return false;
            }
            this.enemyBlock = n4 = (mapData[n3] & 0xFF) + (this.imageOffset[n3 >> 1] << 8);
        }
        finally {
            return true;
        }
    }

    public int blockdirChk(int n) {
        return scddirtbl[blockLinkTable[n] & 0xFF] & 0xFF;
    }

    public boolean rcol2() {
        if (this.blockColChk2(this.PlayerPosX() + 12, this.PlayerPosY() - 12)) {
            int n = 14;
            for (int i = 0; i < n; ++i) {
                PlayerParam[0] = PlayerParam[0] - 256;
                if (!this.blockColChk2(this.PlayerPosX() + 12, this.PlayerPosY() - 12)) break;
            }
            return true;
        }
        return false;
    }

    public boolean lcol2() {
        if (this.blockColChk2(this.PlayerPosX() - 12, this.PlayerPosY() - 12)) {
            int n = 14;
            for (int i = 0; i < n; ++i) {
                PlayerParam[0] = PlayerParam[0] + 256;
                if (!this.blockColChk2(this.PlayerPosX() - 12, this.PlayerPosY() - 12)) break;
            }
            return true;
        }
        return false;
    }

    public boolean rcol3() {
        if (this.blockColChk2(this.PlayerPosX() + 12, this.PlayerPosY() - 24)) {
            int n = 14;
            for (int i = 0; i < n; ++i) {
                PlayerParam[0] = PlayerParam[0] - 256;
                if (!this.blockColChk2(this.PlayerPosX() + 12, this.PlayerPosY() - 24)) break;
            }
            return true;
        }
        return false;
    }

    public boolean lcol3() {
        if (this.blockColChk2(this.PlayerPosX() - 12, this.PlayerPosY() - 24)) {
            int n = 14;
            for (int i = 0; i < n; ++i) {
                PlayerParam[0] = PlayerParam[0] + 256;
                if (!this.blockColChk2(this.PlayerPosX() - 12, this.PlayerPosY() - 24)) break;
            }
            return true;
        }
        return false;
    }

    public boolean rcol() {
        int n;
        int n2;
        if (olddir <= 22 || olddir >= 338) {
            n2 = this.PlayerPosX() + 12;
            n = this.PlayerPosY() - 12;
        } else if (this.zoneNumber == 1 && olddir == 316) {
            n2 = this.PlayerPosX() + 12;
            n = this.PlayerPosY() - 36;
        } else {
            return false;
        }
        if ((this.zoneNumber == 4 || this.zoneNumber == 3) && olddir != 0) {
            return false;
        }
        if (this.blockColChk2(n2, n)) {
            for (int i = 0; i < 14; ++i) {
                PlayerParam[0] = PlayerParam[0] - 256;
                if (!this.blockColChk(--n2, n)) break;
            }
            return true;
        }
        return false;
    }

    public boolean lcol() {
        int n;
        if (olddir > 22 && olddir < 338) {
            return false;
        }
        if ((this.zoneNumber == 4 || this.zoneNumber == 3) && olddir != 0) {
            return false;
        }
        if (this.zoneNumber == 2 && olddir == 22) {
            return false;
        }
        int n2 = this.PlayerPosX() - 12;
        if (this.blockColChk2(n2, n = this.PlayerPosY() - 12)) {
            for (int i = 0; i < 14; ++i) {
                PlayerParam[0] = PlayerParam[0] + 256;
                if (!this.blockColChk(++n2, n)) break;
            }
            return true;
        }
        return false;
    }

    public boolean hcol() {
        try {
            int n = 32;
            if (PlayerSJump) {
                n = 32;
            }
            if (this.blockColChk2(this.PlayerPosX(), this.PlayerPosY() - n)) {
                int n2 = 14;
                for (int i = 0; i < n2; ++i) {
                    PlayerParam[1] = PlayerParam[1] + 256;
                    if (this.blockColChk2(this.PlayerPosX(), this.PlayerPosY() - n)) continue;
                    PlayerParam[1] = PlayerParam[1] - 256;
                    break;
                }
                return true;
            }
            n = 16;
            if (this.blockColChk2(this.PlayerPosX(), this.PlayerPosY() - n)) {
                int n3 = 14;
                for (int i = 0; i < n3; ++i) {
                    PlayerParam[1] = PlayerParam[1] + 256;
                    if (this.blockColChk2(this.PlayerPosX(), this.PlayerPosY() - n)) continue;
                    PlayerParam[1] = PlayerParam[1] - 256;
                    break;
                }
                return true;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return false;
    }

    public boolean fcol(int n) {
        try {
            if (this.blockColChk(this.PlayerPosX(), this.PlayerPosY())) {
                int n2 = 16;
                int n3 = olddir;
                if (n == -1) {
                    // empty if block
                }
                if (this.zoneNumber == 3 && olddir == 90 && (PlayerParam[8] == 370 || PlayerParam[8] == 371)) {
                    return true;
                }
                if (n3 < 0) {
                    n3 = 0;
                }
                for (int i = 0; i < n2; ++i) {
                    if (!PlayerJump) {
                        PlayerParam[0] = PlayerParam[0] - (this.dSin(n3 + 180) << 8) / 100;
                    }
                    PlayerParam[1] = PlayerParam[1] - this.dCos(n3 + 180) * 256 / 100;
                    if (this.blockColChk(this.PlayerPosX(), this.PlayerPosY())) continue;
                    if (!PlayerJump) {
                        PlayerParam[0] = PlayerParam[0] + (this.dSin(n3 + 180) << 8) / 100;
                    }
                    PlayerParam[1] = PlayerParam[1] + (this.dCos(n3 + 180) << 8) / 100;
                    olddir = this.getPlayerArg(this.PlayerPosX(), this.PlayerPosY());
                    break;
                }
                return true;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return false;
    }

    public void playerPushSet() {
        if (!PlayerJump && PlayerBall) {
            PlayerBall = false;
        }
        this.pushCount = 2;
    }

    public void playerBressChk() {
        if (this.zoneNumber == 1 && this.waterH2 < this.PlayerPosY() - 12) {
            --this.bressCount;
            if (this.bressCount < 0) {
                this.bressDie = true;
                this.playerDie();
                this.PlayMusic(29);
                MainCanvas.PlayerParam[5] = 256;
            }
        } else {
            this.bressCount = 2100;
        }
    }

    public boolean jumpchk(int n) {
        if (0 == n) {
            if (PlayerJump) {
                return true;
            }
            if (this.limitBreak) {
                return false;
            }
            if (this.zoneNumber == 0 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 31 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 32)) {
                MainCanvas.KeyPress[2] = false;
                return false;
            }
            if (KeyPress[2]) {
                if (this.zoneNumber == 5 && this.stageNumber != 2 && (37 == PlayerParam[8] || 38 == PlayerParam[8] || 39 == PlayerParam[8] || 41 == PlayerParam[8] || 42 == PlayerParam[8] || 47 == PlayerParam[8] || 48 == PlayerParam[8] || 49 == PlayerParam[8] || 52 == PlayerParam[8] || 59 == PlayerParam[8] || 62 == PlayerParam[8] || 69 == PlayerParam[8] || 71 == PlayerParam[8] || 72 == PlayerParam[8] || 78 == PlayerParam[8] || 79 == PlayerParam[8] || 87 == PlayerParam[8] || 88 == PlayerParam[8] || 89 == PlayerParam[8])) {
                    PlayerJump = true;
                    PlayerDamage = false;
                    PlayerAir = false;
                    raidOn = false;
                    PlayerBall = true;
                    int n2 = this.getPlayerArg(this.PlayerPosX(), this.PlayerPosY());
                    if (n2 < 0) {
                        n2 = 0;
                    }
                    MainCanvas.PlayerParam[3] = this.dSin(n2) * (pljump + PlayerParam[10]) / 100 + PlayerParam[10];
                    MainCanvas.PlayerParam[5] = this.dCos(n2) * (pljump + PlayerParam[10]) / 100;
                    return true;
                }
                if (raidOn) {
                    PlayerJump = true;
                    PlayerDamage = false;
                    PlayerAir = false;
                    raidOn = false;
                    PlayerBall = true;
                    MainCanvas.PlayerParam[3] = this.dSin(0) * pljump / 100 + PlayerParam[10];
                    MainCanvas.PlayerParam[5] = this.dCos(0) * pljump / 100;
                    return true;
                }
                PlayerJump = true;
                PlayerDamage = false;
                PlayerAir = false;
                raidOn = false;
                PlayerBall = true;
                int n3 = olddir;
                int n4 = this.PlayerPosX() / 16 / 16;
                int n5 = this.PlayerPosY() / 16 / 16;
                int n6 = tempWorldMapData[n5 %= MapH][n4] * 512 + (this.PlayerPosX() / 16 % 16 + this.PlayerPosY() / 16 % 16 * 16) * 2 + 1;
                int n7 = 0;
                int n8 = mapData[n6 - 1] & 0xFF;
                byte by = (byte)(n8 << 6);
                if ((by = (byte)Math.abs(by >> 6)) % 4 != 0) {
                    n7 = 256 * (by % 4);
                }
                int n9 = (mapData[n6] & 0xFF) + n7;
                byte by2 = (byte)this.blockdirChk(n9);
                if (olddir == 270) {
                    nocoltimer = 5;
                    MainCanvas.PlayerParam[3] = -pljump;
                    MainCanvas.PlayerParam[5] = -Math.abs(pljump);
                } else if (olddir == 90) {
                    nocoltimer = 5;
                    MainCanvas.PlayerParam[3] = pljump;
                    MainCanvas.PlayerParam[5] = -Math.abs(pljump);
                } else if (by2 == 0 || olddir > 290 || olddir < 70) {
                    MainCanvas.PlayerParam[3] = this.dSin(n3) * pljump / 100 + PlayerParam[10];
                    MainCanvas.PlayerParam[5] = this.dCos(n3) * pljump / 100;
                    if (PlayerParam[5] > 0) {
                        this.nofcolTimer = 1;
                    }
                    if (Math.abs(PlayerParam[10]) > 2560 && this.zoneNumber == 4 && this.stageNumber == 1 && PlayerParam[0] > 9216) {
                        PlayerParam[5] = PlayerParam[5] - 768;
                        MainCanvas.PlayerParam[3] = this.dSin(n3) * pljump / 100 + 2560;
                    }
                } else {
                    MainCanvas.PlayerParam[3] = this.dSin(n3) * pljump / 100;
                    MainCanvas.PlayerParam[5] = this.dCos(n3) * pljump / 100;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean ballchk() {
        if (this.CrouchCount > -1) {
            --this.CrouchCount;
        }
        if (this.LookUpCount > -1) {
            --this.LookUpCount;
        }
        if (PlayerBall) {
            return true;
        }
        if (!PlayerJump && !this.limitBreak) {
            if (KeyPress[1]) {
                if (Math.abs(PlayerParam[10]) > plretspd) {
                    PlayerBall = true;
                    return true;
                }
                if (!KeyPress[3] && !KeyPress[4]) {
                    PlayerCrouch = true;
                    this.CrouchCount += 2;
                    if (this.CrouchCount > 32) {
                        this.CrouchCount = 32;
                    }
                    return false;
                }
            } else if (KeyPress[0] && Math.abs(PlayerParam[10]) <= plretspd && !KeyPress[3] && !KeyPress[4]) {
                PlayerLookUp = true;
                this.LookUpCount += 2;
                if (this.LookUpCount > 24) {
                    this.LookUpCount = 24;
                }
                return false;
            }
        }
        return false;
    }

    public boolean setPlayerPos() {
        this.rhit = false;
        this.lhit = false;
        int n = olddir;
        int n2 = 32;
        int n3 = 256;
        if (olddir != 22 && olddir != 338) {
            n2 = 256;
        }
        if (olddir >= 270 && olddir < 300) {
            n3 = 32;
        }
        if (olddir >= 60 && olddir < 90) {
            n3 = 32;
        }
        if (this.zoneNumber == 0 && (tempWorldMapData[this.PlayerPosY() >> 8][this.PlayerPosX() >> 8] == 31 || tempWorldMapData[this.PlayerPosY() >> 8][this.PlayerPosX() >> 8] == 32)) {
            n3 = 256;
        }
        int n4 = olddir;
        if (this.fcol()) {
            raidOn = false;
            if (this.zoneNumber == 4 && (n4 == 79 && olddir == 90 || n4 == 281 && olddir == 270)) {
                MainCanvas.PlayerParam[10] = olddir == 90 ? 640 : -640;
                olddir = n4;
                this.noLeverTimer = 0;
                this.nofcolTimer = 3;
                return false;
            }
            return true;
        }
        for (int i = 0; i < 14; ++i) {
            PlayerParam[0] = PlayerParam[0] + this.dSin(n + 180) * n2 / 100;
            PlayerParam[1] = PlayerParam[1] + this.dCos(n + 180) * n3 / 100;
            if (!this.fcol()) continue;
            raidOn = false;
            if (this.zoneNumber == 4 && (n4 == 79 && olddir == 90 || n4 == 281 && olddir == 270)) {
                MainCanvas.PlayerParam[10] = olddir == 90 ? 640 : -640;
                olddir = n4;
                this.noLeverTimer = 0;
                this.nofcolTimer = 3;
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean fcol() {
        if (this.zoneNumber == 5 && this.stageNumber != 2) {
            if (37 == PlayerParam[8] || 38 == PlayerParam[8] || 39 == PlayerParam[8] || 41 == PlayerParam[8] || 42 == PlayerParam[8] || 47 == PlayerParam[8] || 48 == PlayerParam[8] || 49 == PlayerParam[8] || 52 == PlayerParam[8] || 59 == PlayerParam[8] || 62 == PlayerParam[8] || 69 == PlayerParam[8] || 71 == PlayerParam[8] || 72 == PlayerParam[8] || 78 == PlayerParam[8] || 79 == PlayerParam[8] || 87 == PlayerParam[8] || 88 == PlayerParam[8] || 89 == PlayerParam[8]) {
                return this.fcol(0);
            }
            if (plspeed[0] >= 0) {
                this.rhit = this.fcol_r();
                if (!this.rhit) {
                    this.lhit = this.fcol_l();
                }
            }
            if (plspeed[0] < 0) {
                this.lhit = this.fcol_l();
                if (!this.lhit) {
                    this.rhit = this.fcol_r();
                }
            }
            return this.rhit || this.lhit;
        }
        if (this.zoneNumber == 0) {
            if (tempWorldMapData[this.PlayerPosY() >> 8][this.PlayerPosX() >> 8] == 31 || tempWorldMapData[this.PlayerPosY() >> 8][this.PlayerPosX() >> 8] == 32) {
                return this.fcol(0);
            }
            if (plspeed[0] >= 0) {
                this.rhit = this.fcol_r();
                if (!this.rhit) {
                    this.lhit = this.fcol_l();
                }
            }
            if (plspeed[0] < 0) {
                this.lhit = this.fcol_l();
                if (!this.lhit) {
                    this.rhit = this.fcol_r();
                }
            }
            return this.rhit || this.lhit;
        }
        if (this.zoneNumber == 3) {
            if (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 42 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 43 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 52 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53) {
                return this.fcol(0);
            }
            if (plspeed[0] >= 0) {
                this.rhit = this.fcol_r();
                if (!this.rhit) {
                    this.lhit = this.fcol_l();
                }
            }
            if (plspeed[0] < 0) {
                this.lhit = this.fcol_l();
                if (!this.lhit) {
                    this.rhit = this.fcol_r();
                }
            }
            return this.rhit || this.lhit;
        }
        if (plspeed[0] >= 0) {
            this.rhit = this.fcol_r();
            if (!this.rhit) {
                this.lhit = this.fcol_l();
            }
        }
        if (plspeed[0] < 0) {
            this.lhit = this.fcol_l();
            if (!this.lhit) {
                this.rhit = this.fcol_r();
            }
        }
        return this.rhit || this.lhit;
    }

    private boolean fcol_r() {
        try {
            int n;
            int n2 = olddir;
            if (n2 < 0) {
                n2 = 0;
            }
            int n3 = this.PlayerW;
            int n4 = this.PlayerPosX() + this.dSin(n2 + 90) * n3 / 100;
            if (this.blockColChk(n4, n = this.PlayerPosY() + this.dCos(n2 + 90) * n3 / 100)) {
                int n5 = this.getPlayerArg(n4, n);
                if (this.zoneNumber == 3 && (PlayerParam[8] == 1 || PlayerParam[8] == 17 || PlayerParam[8] == 319) && (olddir >= 270 && olddir < 300 || olddir > 60 && olddir <= 90)) {
                    olddir = olddir >= 270 && olddir < 300 ? 270 : 90;
                    return true;
                }
                int n6 = 16;
                for (int i = 0; i < n6; ++i) {
                    n5 = this.getPlayerArg(n4, n);
                    if (!PlayerJump) {
                        PlayerParam[0] = PlayerParam[0] - (this.dSin(n2 + 180) << 8) / 100;
                    }
                    PlayerParam[1] = PlayerParam[1] - (this.dCos(n2 + 180) << 8) / 100;
                    n4 = this.PlayerPosX() + this.dSin(n2 + 90) * n3 / 100;
                    if (this.blockColChk(n4, n = this.PlayerPosY() + this.dCos(n2 + 90) * n3 / 100)) continue;
                    if (!PlayerJump) {
                        PlayerParam[0] = PlayerParam[0] + (this.dSin(n2 + 180) << 8) / 100;
                    }
                    PlayerParam[1] = PlayerParam[1] + (this.dCos(n2 + 180) << 8) / 100;
                    if (this.zoneNumber == 3 && n5 == 350) {
                        n5 = 0;
                    }
                    olddir = n5;
                    break;
                }
                return true;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return false;
    }

    private boolean fcol_l() {
        try {
            int n;
            int n2 = olddir;
            if (n2 < 0) {
                n2 = 0;
            }
            int n3 = this.PlayerW;
            int n4 = this.PlayerPosX() + this.dSin(n2 + 270) * n3 / 100;
            if (this.blockColChk(n4, n = this.PlayerPosY() + this.dCos(n2 + 270) * n3 / 100)) {
                int n5 = this.getPlayerArg(n4, n);
                if (this.zoneNumber == 3 && (PlayerParam[8] == 1 || PlayerParam[8] == 17 || PlayerParam[8] == 319) && (olddir >= 270 && olddir < 300 || olddir > 60 && olddir <= 90)) {
                    olddir = olddir >= 270 && olddir < 300 ? 270 : 90;
                    return true;
                }
                int n6 = 16;
                for (int i = 0; i < n6; ++i) {
                    n5 = this.getPlayerArg(n4, n);
                    if (!PlayerJump) {
                        PlayerParam[0] = PlayerParam[0] - (this.dSin(n2 + 180) << 8) / 100;
                    }
                    PlayerParam[1] = PlayerParam[1] - (this.dCos(n2 + 180) << 8) / 100;
                    n4 = this.PlayerPosX() + this.dSin(n2 + 270) * n3 / 100;
                    if (this.blockColChk(n4, n = this.PlayerPosY() + this.dCos(n2 + 270) * n3 / 100)) continue;
                    if (!PlayerJump) {
                        PlayerParam[0] = PlayerParam[0] + (this.dSin(n2 + 180) << 8) / 100;
                    }
                    PlayerParam[1] = PlayerParam[1] + (this.dCos(n2 + 180) << 8) / 100;
                    if (this.zoneNumber == 3 && n5 == 350) {
                        n5 = 0;
                    }
                    olddir = n5;
                    break;
                }
                return true;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return false;
    }

    public boolean play00walk() {
        MainCanvas.plspeed[0] = 0;
        MainCanvas.plspeed[1] = 0;
        if (this.jumpchk(0)) {
            return true;
        }
        int n = Math.abs(PlayerParam[10]);
        this.keispd(0);
        this.levermove();
        if (n <= plmaxspd && Math.abs(PlayerParam[10]) > plmaxspd && n <= plmaxspd) {
            MainCanvas.PlayerParam[10] = PlayerParam[10] < 0 ? -plmaxspd : plmaxspd;
        }
        if (!(olddir > 22 && olddir < 338 || n <= plmaxspd && (KeyPress[3] || KeyPress[4] || PlayerParam[10] == 0) || PlayerParam[10] == 0)) {
            if (PlayerParam[10] < 0) {
                PlayerParam[10] = PlayerParam[10] + pladdspd;
                if (PlayerParam[10] > 0) {
                    MainCanvas.PlayerParam[10] = 0;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                }
            } else {
                PlayerParam[10] = PlayerParam[10] - pladdspd;
                if (PlayerParam[10] < 0) {
                    MainCanvas.PlayerParam[10] = 0;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                }
            }
        }
        if (Math.abs(PlayerParam[10]) > 4096) {
            MainCanvas.PlayerParam[10] = PlayerParam[10] < 0 ? -4096 : 4096;
        }
        if (this.ballchk()) {
            return false;
        }
        this.speedset(0);
        if (this.zoneNumber == 0 || this.zoneNumber == 3) {
            this.loopchange();
        }
        if (!PlayerNoCol) {
            boolean bl = false;
            if (this.zoneNumber == 0 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 31 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 32)) {
                bl = true;
                PlayerBall = true;
                PlayerParam[10] = PlayerParam[10] + 256;
                if (PlayerParam[10] > 4096) {
                    MainCanvas.PlayerParam[10] = 4096;
                }
            }
            if (this.zoneNumber == 0 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 54)) {
                bl = true;
            }
            if (this.zoneNumber == 3 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 42 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 43 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 52 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53)) {
                bl = true;
            }
            if (!bl) {
                if (raidOn) {
                    if (this.blockColChk2(this.PlayerPosX() - 12, this.PlayerPosY() - 24) && this.blockColChk2(this.PlayerPosX() + 12, this.PlayerPosY() - 24)) {
                        if (this.rcol2()) {
                            MainCanvas.PlayerParam[10] = 0;
                            MainCanvas.PlayerParam[13] = 0;
                            MainCanvas.PlayerParam[14] = 0;
                            if (KeyPress[4]) {
                                this.playerPushSet();
                            }
                        }
                        if (this.lcol2()) {
                            MainCanvas.PlayerParam[10] = 0;
                            MainCanvas.PlayerParam[13] = 0;
                            MainCanvas.PlayerParam[14] = 0;
                            if (KeyPress[3]) {
                                this.playerPushSet();
                            }
                        }
                    } else {
                        if (this.rcol3() || this.rcol2()) {
                            MainCanvas.PlayerParam[10] = 0;
                            MainCanvas.PlayerParam[13] = 0;
                            MainCanvas.PlayerParam[14] = 0;
                            if (KeyPress[4]) {
                                this.playerPushSet();
                            }
                        }
                        if (this.lcol3() || this.lcol2()) {
                            MainCanvas.PlayerParam[10] = 0;
                            MainCanvas.PlayerParam[13] = 0;
                            MainCanvas.PlayerParam[14] = 0;
                            if (KeyPress[3]) {
                                this.playerPushSet();
                            }
                        }
                    }
                } else {
                    if (this.rcol()) {
                        MainCanvas.PlayerParam[10] = 0;
                        MainCanvas.PlayerParam[13] = 0;
                        MainCanvas.PlayerParam[14] = 0;
                        if (KeyPress[4]) {
                            this.playerPushSet();
                        }
                    }
                    if (this.lcol()) {
                        MainCanvas.PlayerParam[10] = 0;
                        MainCanvas.PlayerParam[13] = 0;
                        MainCanvas.PlayerParam[14] = 0;
                        if (KeyPress[3]) {
                            this.playerPushSet();
                        }
                    }
                }
            }
            int n2 = PlayerParam[0];
            int n3 = PlayerParam[1];
            boolean bl2 = true;
            if (this.setPlayerPos()) {
                this.crushing[0] = true;
                bl2 = false;
            }
            if (this.noLeverTimer > 0) {
                if (bl2) {
                    MainCanvas.PlayerParam[0] = n2;
                    MainCanvas.PlayerParam[1] = n3;
                }
            } else if (!raidOn && bl2) {
                MainCanvas.PlayerParam[0] = n2;
                MainCanvas.PlayerParam[1] = n3;
                if (olddir == 22 && this.zoneNumber == 1 && this.stageNumber == 1) {
                    MainCanvas.PlayerParam[3] = this.dSin(90) * PlayerParam[10] / 100;
                    MainCanvas.PlayerParam[5] = this.dCos(90) * PlayerParam[10] / 100;
                } else {
                    MainCanvas.PlayerParam[3] = this.dSin(olddir + 90) * PlayerParam[10] / 100;
                    MainCanvas.PlayerParam[5] = this.dCos(olddir + 90) * PlayerParam[10] / 100;
                }
                if ((olddir - 90) % 180 == 0) {
                    if (olddir == 90) {
                        PlayerParam[0] = PlayerParam[0] + 256;
                        if (this.zoneNumber == 4 && this.stageNumber != 0) {
                            MainCanvas.PlayerParam[5] = 0;
                        }
                    } else {
                        PlayerParam[0] = PlayerParam[0] - 256;
                        if (PlayerParam[10] > 2816) {
                            this.noLeverTimer = 15;
                        }
                    }
                }
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                PlayerAir = true;
                PlayerJump = true;
                PlayerDamage = false;
                raidOn = false;
                if (this.hcol()) {
                    MainCanvas.PlayerParam[5] = 0;
                }
            } else {
                bl = false;
                if (this.zoneNumber == 0 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 31 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 32)) {
                    bl = true;
                }
                if (this.zoneNumber == 2 && (PlayerParam[8] == 365 || PlayerParam[8] == 364 || PlayerParam[8] == 363 || PlayerParam[8] == 362)) {
                    this.playdamageset();
                }
                if (!bl) {
                    this.fallchk();
                }
            }
        }
        return false;
    }

    public void play00jump() {
        if (this.noLeverTimer > 0) {
            --this.noLeverTimer;
        } else if (KeyPress[3]) {
            MainCanvas.PlayerParam[12] = 1;
            if (PlayerParam[3] == 0) {
                PlayerParam[3] = PlayerParam[3] - (plretspd << 1);
            } else {
                PlayerParam[3] = PlayerParam[3] - pladdspd;
                if (PlayerParam[3] > 0) {
                    PlayerParam[3] = PlayerParam[3] - pladdspd;
                }
            }
        } else if (KeyPress[4]) {
            MainCanvas.PlayerParam[12] = 0;
            if (PlayerParam[3] == 0) {
                PlayerParam[3] = PlayerParam[3] + (plretspd << 1);
            } else {
                PlayerParam[3] = PlayerParam[3] + pladdspd;
                if (PlayerParam[3] < 0) {
                    PlayerParam[3] = PlayerParam[3] + pladdspd;
                }
            }
        }
        if (Math.abs(PlayerParam[3]) > plmaxspd) {
            MainCanvas.PlayerParam[3] = PlayerParam[3] < 0 ? -plmaxspd : plmaxspd;
        }
        plspeed[0] = plspeed[0] + PlayerParam[3];
        plspeed[1] = plspeed[1] + PlayerParam[5];
        if (PlayerParam[5] > 0 && this.nofcolTimer <= 0) {
            if (olddir == 270) {
                PlayerParam[0] = PlayerParam[0] - 3072;
            } else if (olddir == 90) {
                PlayerParam[0] = PlayerParam[0] + 3072;
            }
            olddir = 0;
        }
        this.jumpmove();
        this.speedset(1);
        if (this.zoneNumber == 0 || this.zoneNumber == 3) {
            this.loopchange();
        }
        if (PlayerJump && nocoltimer <= 0) {
            if (this.rcol2()) {
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                MainCanvas.PlayerParam[3] = 0;
            }
            if (this.lcol2()) {
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                MainCanvas.PlayerParam[3] = 0;
            }
        }
        this.jumpcolchk();
    }

    public boolean ball00walk() {
        MainCanvas.plspeed[0] = 0;
        MainCanvas.plspeed[1] = 0;
        if (this.jumpchk(0)) {
            return true;
        }
        int n = Math.abs(PlayerParam[10]);
        this.keispd(1);
        this.blevermove();
        this.speedset(0);
        if (Math.abs(PlayerParam[10]) > 4096) {
            MainCanvas.PlayerParam[10] = PlayerParam[10] < 0 ? -4096 : 4096;
        }
        if (Math.abs(PlayerParam[10]) > 3072) {
            // empty if block
        }
        if (this.zoneNumber == 0 || this.zoneNumber == 3) {
            this.loopchange();
        }
        if (!PlayerNoCol) {
            boolean bl = false;
            if (this.zoneNumber == 0 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 31 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 32)) {
                bl = true;
                PlayerParam[10] = PlayerParam[10] + 12;
                if (PlayerParam[10] > 4096) {
                    MainCanvas.PlayerParam[10] = 4096;
                }
            }
            if (this.zoneNumber == 0 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 54)) {
                bl = true;
            }
            if (this.zoneNumber == 3 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 42 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 43 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 52 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53)) {
                bl = true;
            }
            if (!bl) {
                if (raidOn) {
                    if (this.blockColChk2(this.PlayerPosX() - 12, this.PlayerPosY() - 24) && this.blockColChk2(this.PlayerPosX() + 12, this.PlayerPosY() - 24)) {
                        if (this.rcol2()) {
                            MainCanvas.PlayerParam[10] = 0;
                            MainCanvas.PlayerParam[13] = 0;
                            MainCanvas.PlayerParam[14] = 0;
                            if (KeyPress[4]) {
                                this.playerPushSet();
                            }
                        }
                        if (this.lcol2()) {
                            MainCanvas.PlayerParam[10] = 0;
                            MainCanvas.PlayerParam[13] = 0;
                            MainCanvas.PlayerParam[14] = 0;
                            if (KeyPress[3]) {
                                this.playerPushSet();
                            }
                        }
                    } else {
                        if (this.rcol3() || this.rcol2()) {
                            MainCanvas.PlayerParam[10] = 0;
                            MainCanvas.PlayerParam[13] = 0;
                            MainCanvas.PlayerParam[14] = 0;
                            if (KeyPress[4]) {
                                this.playerPushSet();
                            }
                        }
                        if (this.lcol3() || this.lcol2()) {
                            MainCanvas.PlayerParam[10] = 0;
                            MainCanvas.PlayerParam[13] = 0;
                            MainCanvas.PlayerParam[14] = 0;
                            if (KeyPress[3]) {
                                this.playerPushSet();
                            }
                        }
                    }
                } else {
                    if (this.rcol()) {
                        MainCanvas.PlayerParam[10] = 0;
                        MainCanvas.PlayerParam[13] = 0;
                        MainCanvas.PlayerParam[14] = 0;
                        if (KeyPress[4]) {
                            this.playerPushSet();
                        }
                    }
                    if (this.lcol()) {
                        MainCanvas.PlayerParam[10] = 0;
                        MainCanvas.PlayerParam[13] = 0;
                        MainCanvas.PlayerParam[14] = 0;
                        if (KeyPress[3]) {
                            this.playerPushSet();
                        }
                    }
                }
            }
            int n2 = PlayerParam[0];
            int n3 = PlayerParam[1];
            boolean bl2 = true;
            if (this.setPlayerPos()) {
                this.crushing[0] = true;
                bl2 = false;
            }
            if (this.noLeverTimer > 0) {
                if (bl2) {
                    MainCanvas.PlayerParam[0] = n2;
                    MainCanvas.PlayerParam[1] = n3;
                }
            } else if (!raidOn && bl2 && !bl) {
                MainCanvas.PlayerParam[0] = n2;
                MainCanvas.PlayerParam[1] = n3;
                if (this.zoneNumber == 0 && Math.abs(PlayerParam[10]) > 2560) {
                    MainCanvas.PlayerParam[10] = PlayerParam[10] < 0 ? -4224 : 4224;
                }
                MainCanvas.PlayerParam[3] = this.dSin(olddir + 90) * PlayerParam[10] / 100;
                MainCanvas.PlayerParam[5] = this.dCos(olddir + 90) * PlayerParam[10] / 100;
                if ((olddir - 90) % 180 == 0) {
                    if (olddir == 90) {
                        PlayerParam[0] = PlayerParam[0] + 256;
                        if (this.zoneNumber == 4 && this.stageNumber != 0) {
                            MainCanvas.PlayerParam[5] = 0;
                        }
                    } else {
                        PlayerParam[0] = PlayerParam[0] - 256;
                        if (PlayerParam[10] > 3072 && this.zoneNumber == 4) {
                            this.noLeverTimer = 15;
                        }
                    }
                }
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                PlayerAir = true;
                PlayerJump = true;
                PlayerDamage = false;
                raidOn = false;
                if (this.hcol()) {
                    MainCanvas.PlayerParam[5] = 0;
                }
            } else {
                bl = false;
                if (this.zoneNumber == 0 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 31 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 32)) {
                    bl = true;
                }
                if (this.zoneNumber == 2 && (PlayerParam[8] == 365 || PlayerParam[8] == 364 || PlayerParam[8] == 363 || PlayerParam[8] == 362)) {
                    this.playdamageset();
                }
                if (!bl) {
                    this.fallchk();
                }
            }
        }
        return false;
    }

    public void ball00jump() {
        int n = Math.abs(PlayerParam[3]);
        if (this.noLeverTimer > 0) {
            --this.noLeverTimer;
        } else if (!this.limitBreak) {
            if (KeyPress[3]) {
                MainCanvas.PlayerParam[12] = 1;
                if (PlayerParam[3] == 0) {
                    PlayerParam[3] = PlayerParam[3] - (plretspd << 1);
                } else {
                    PlayerParam[3] = PlayerParam[3] - pladdspd;
                    if (PlayerParam[3] > 0) {
                        PlayerParam[3] = PlayerParam[3] - pladdspd;
                    }
                }
            } else if (KeyPress[4]) {
                MainCanvas.PlayerParam[12] = 0;
                if (PlayerParam[3] == 0) {
                    PlayerParam[3] = PlayerParam[3] + (plretspd << 1);
                } else {
                    PlayerParam[3] = PlayerParam[3] + pladdspd;
                    if (PlayerParam[3] < 0) {
                        PlayerParam[3] = PlayerParam[3] + pladdspd;
                    }
                }
            }
        }
        if (Math.abs(PlayerParam[3]) > 4096) {
            MainCanvas.PlayerParam[3] = PlayerParam[3] < 0 ? -4096 : 4096;
        }
        if (this.zoneNumber == 3 && Math.abs(PlayerParam[3]) > plmaxspd && n <= plmaxspd) {
            MainCanvas.PlayerParam[3] = PlayerParam[3] < 0 ? -plmaxspd : plmaxspd;
        }
        plspeed[0] = plspeed[0] + PlayerParam[3];
        plspeed[1] = plspeed[1] + PlayerParam[5];
        if (PlayerParam[5] > 0 && this.nofcolTimer <= 0) {
            if (olddir == 270) {
                PlayerParam[0] = PlayerParam[0] - 3072;
            } else if (olddir == 90) {
                PlayerParam[0] = PlayerParam[0] + 3072;
            }
            olddir = 0;
        }
        this.jumpmove();
        this.speedset(1);
        if (this.zoneNumber == 0 || this.zoneNumber == 3) {
            this.loopchange();
        }
        if (PlayerJump && --nocoltimer <= 0) {
            if (this.rcol2()) {
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                MainCanvas.PlayerParam[3] = 0;
            }
            if (this.lcol2()) {
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                MainCanvas.PlayerParam[3] = 0;
            }
        }
        this.jumpcolchk();
    }

    public void jumpmove() {
    }

    public void playerTyakuchi(int n) {
        if (n == 0) {
            PlayerBall = false;
            comboScore = 0;
            PlayerJump = false;
            PlayerSJump = false;
            PlayerDamage = false;
        }
        if (n == 0) {
            MainCanvas.PlayerParam[10] = PlayerParam[3];
            int n2 = this.getPlayerArg(this.PlayerPosX(), this.PlayerPosY());
            if (n2 < 0) {
                for (int i = 1; i < this.PlayerW + 1 && (n2 = this.getPlayerArg(this.PlayerPosX() - i, this.PlayerPosY())) < 0 && (n2 = this.getPlayerArg(this.PlayerPosX() + i, this.PlayerPosY())) < 0; ++i) {
                }
            }
            olddir = n2;
            if (n2 <= 67 && n2 >= 44 || n2 >= 293 && n2 <= 316) {
                if (PlayerParam[5] > 3072) {
                    MainCanvas.PlayerParam[5] = 4096;
                }
                MainCanvas.PlayerParam[10] = this.dCos(n2 + 90) > 0 ? PlayerParam[5] : -PlayerParam[5];
            } else if (n2 < 338 && n2 > 22) {
                PlayerParam[10] = PlayerParam[10] + this.dCos(n2 + 90) * PlayerParam[5] / 100;
            }
            MainCanvas.PlayerParam[5] = 0;
            MainCanvas.PlayerParam[3] = 0;
            if (this.zoneNumber == 2 && (PlayerParam[8] == 365 || PlayerParam[8] == 364 || PlayerParam[8] == 363 || PlayerParam[8] == 362)) {
                this.playdamageYogan = true;
            }
            if (PlayerParam[10] < 0) {
                MainCanvas.PlayerParam[13] = 1;
            }
            if (PlayerParam[10] > 0) {
                MainCanvas.PlayerParam[13] = 2;
            }
            MainCanvas.PlayerParam[14] = 0;
        } else if (PlayerSJump) {
            int n3 = this.getPlayerArg(this.PlayerPosX(), this.PlayerPosY() - 32);
            if (n3 < 0) {
                n3 = olddir;
            }
            if (n3 % 90 == 0) {
                MainCanvas.PlayerParam[5] = 0;
            } else {
                PlayerParam[3] = PlayerParam[3] + -(this.dCos(n3 + 90) * PlayerParam[5]) / 100;
            }
        } else {
            MainCanvas.PlayerParam[5] = 0;
        }
    }

    public void jumpcolchk() {
        if (this.nofcolTimer > 0) {
            --this.nofcolTimer;
            return;
        }
        if (-pljump_w <= PlayerParam[5]) {
            MainCanvas.KeyPress[2] = false;
        } else if (!(KeyPress[2] || PlayerSJump || PlayerAir)) {
            MainCanvas.PlayerParam[5] = -pljump_w;
        }
        if (PlayerParam[5] > 0) {
            PlayerSJump = false;
            if (this.fcol()) {
                if (olddir >= 270 || olddir <= 90) {
                    this.playerTyakuchi(0);
                } else {
                    olddir = 0;
                }
            }
        } else if (this.hcol()) {
            this.playerTyakuchi(1);
        }
    }

    public void levermove() {
        if (this.limitBreak) {
            MainCanvas.PlayerParam[12] = 0;
            if (PlayerParam[13] == 0) {
                MainCanvas.PlayerParam[13] = 2;
                MainCanvas.PlayerParam[14] = 2;
            }
            this.plwalk(1);
        } else if (!PlayerWater) {
            if (this.zoneNumber == 5 && this.stageNumber != 2 && (37 == PlayerParam[8] || 38 == PlayerParam[8] || 39 == PlayerParam[8] || 41 == PlayerParam[8] || 42 == PlayerParam[8] || 47 == PlayerParam[8] || 48 == PlayerParam[8] || 49 == PlayerParam[8] || 52 == PlayerParam[8] || 59 == PlayerParam[8] || 62 == PlayerParam[8] || 69 == PlayerParam[8] || 71 == PlayerParam[8] || 72 == PlayerParam[8] || 78 == PlayerParam[8] || 79 == PlayerParam[8] || 87 == PlayerParam[8] || 88 == PlayerParam[8] || 89 == PlayerParam[8])) {
                PlayerParam[10] = PlayerParam[10] + 256;
                if (1024 < PlayerParam[10]) {
                    MainCanvas.PlayerParam[10] = 1024;
                }
                MainCanvas.PlayerParam[12] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
            } else if (this.noLeverTimer > 0) {
                --this.noLeverTimer;
            } else if (KeyPress[3]) {
                MainCanvas.PlayerParam[12] = 1;
                if (PlayerParam[13] == 0) {
                    MainCanvas.PlayerParam[13] = 1;
                }
                if (PlayerParam[14] == 0) {
                    MainCanvas.PlayerParam[14] = 1;
                }
                this.plwalk(0);
            } else if (KeyPress[4]) {
                MainCanvas.PlayerParam[12] = 0;
                if (PlayerParam[13] == 0) {
                    MainCanvas.PlayerParam[13] = 2;
                }
                if (PlayerParam[14] == 0) {
                    MainCanvas.PlayerParam[14] = 2;
                }
                this.plwalk(1);
            }
        }
        plspeed[0] = plspeed[0] + this.dSin(olddir + 90) * PlayerParam[10] / 100;
        plspeed[1] = plspeed[1] + this.dCos(olddir + 90) * PlayerParam[10] / 100;
    }

    public void plwalk(int n) {
        boolean bl = false;
        int n2 = Math.abs(PlayerParam[10]);
        if (n == 1) {
            if (PlayerParam[10] < 0 && PlayerParam[13] == 1) {
                PlayerParam[10] = PlayerParam[10] + plretspd;
                if (PlayerParam[10] > 0) {
                    MainCanvas.PlayerParam[10] = 0;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                }
            }
            if (PlayerParam[10] == 0) {
                PlayerParam[10] = PlayerParam[10] + pladdspd;
            }
            PlayerParam[10] = PlayerParam[10] + pladdspd;
            if (PlayerParam[10] > 0 && PlayerParam[13] == 1) {
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
            }
        } else {
            if (PlayerParam[10] > 0 && PlayerParam[13] == 2) {
                PlayerParam[10] = PlayerParam[10] - plretspd;
                if (PlayerParam[10] < 0) {
                    MainCanvas.PlayerParam[10] = 0;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                }
            }
            if (PlayerParam[10] == 0) {
                PlayerParam[10] = PlayerParam[10] - pladdspd;
            }
            PlayerParam[10] = PlayerParam[10] - pladdspd;
            if (PlayerParam[10] < 0 && PlayerParam[13] == 2) {
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
            }
        }
    }

    public void blevermove() {
        if (this.limitBreak) {
            MainCanvas.PlayerParam[12] = 0;
            if (PlayerParam[13] == 0) {
                MainCanvas.PlayerParam[13] = 2;
                MainCanvas.PlayerParam[14] = 2;
            }
            this.plwalk(1);
        } else if (this.zoneNumber == 5 && this.stageNumber != 2 && (37 == PlayerParam[8] || 38 == PlayerParam[8] || 39 == PlayerParam[8] || 41 == PlayerParam[8] || 42 == PlayerParam[8] || 47 == PlayerParam[8] || 48 == PlayerParam[8] || 49 == PlayerParam[8] || 52 == PlayerParam[8] || 59 == PlayerParam[8] || 62 == PlayerParam[8] || 69 == PlayerParam[8] || 71 == PlayerParam[8] || 72 == PlayerParam[8] || 78 == PlayerParam[8] || 79 == PlayerParam[8] || 87 == PlayerParam[8] || 88 == PlayerParam[8] || 89 == PlayerParam[8])) {
            PlayerParam[10] = PlayerParam[10] + 256;
            if (2560 < PlayerParam[10]) {
                MainCanvas.PlayerParam[10] = 2560;
            }
        } else if (this.noLeverTimer > 0) {
            --this.noLeverTimer;
        } else if (KeyPress[3]) {
            if (PlayerParam[13] == 0) {
                MainCanvas.PlayerParam[13] = 1;
            }
            if (PlayerParam[14] == 0) {
                MainCanvas.PlayerParam[14] = 1;
            }
            MainCanvas.PlayerParam[12] = 1;
            this.plballwalk(0);
        } else if (KeyPress[4]) {
            if (PlayerParam[13] == 0) {
                MainCanvas.PlayerParam[13] = 2;
            }
            if (PlayerParam[14] == 0) {
                MainCanvas.PlayerParam[14] = 2;
            }
            MainCanvas.PlayerParam[12] = 0;
            this.plballwalk(1);
        }
        plspeed[0] = plspeed[0] + this.dSin(olddir + 90) * PlayerParam[10] / 100;
        plspeed[1] = plspeed[1] + this.dCos(olddir + 90) * PlayerParam[10] / 100;
        if (PlayerParam[10] != 0 && PlayerParam[10] != 0) {
            if (PlayerParam[10] < 0) {
                PlayerParam[10] = PlayerParam[10] + pladdspd;
                if (PlayerParam[10] >= 0) {
                    MainCanvas.PlayerParam[10] = 0;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                    PlayerBall = false;
                }
            } else {
                PlayerParam[10] = PlayerParam[10] - pladdspd;
                if (PlayerParam[10] <= 0) {
                    MainCanvas.PlayerParam[10] = 0;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                    PlayerBall = false;
                }
            }
        }
        if (PlayerParam[10] == 0) {
            PlayerBall = false;
            comboScore = 0;
        }
    }

    public void plballwalk(int n) {
        boolean bl = false;
        if (n == 1) {
            PlayerParam[10] = PlayerParam[10] + (pladdspd >> 1);
            if (Math.abs(PlayerParam[10]) > 4096) {
                MainCanvas.PlayerParam[10] = PlayerParam[10] < 0 ? -4096 : 4096;
            }
        } else {
            PlayerParam[10] = PlayerParam[10] - (pladdspd >> 1);
            if (Math.abs(PlayerParam[10]) > 4096) {
                MainCanvas.PlayerParam[10] = PlayerParam[10] < 0 ? -4096 : 4096;
            }
        }
    }

    public void keispd(int n) {
        if (raidOn) {
            return;
        }
        if (0 == n) {
            int n2 = olddir;
            if (n2 < 0) {
                n2 = 0;
                if (!(olddir == 0 || raidOn || olddir > 22 && olddir < 338)) {
                    n2 = PlayerParam[10] > 0 ? 90 : (PlayerParam[10] < 0 ? 270 : olddir);
                }
            }
            if (olddir > 22 && olddir < 338) {
                PlayerParam[10] = PlayerParam[10] + this.dCos(n2 + 90) * 32 / 100;
            }
        } else {
            int n3 = PlayerParam[10];
            int n4 = olddir;
            if (n4 < 0) {
                n4 = 0;
                if (!(olddir == 0 || raidOn || olddir > 22 && olddir < 338)) {
                    n4 = PlayerParam[10] > 0 ? 90 : (PlayerParam[10] < 0 ? 270 : olddir);
                }
            }
            int n5 = (n4 + 135) % 360;
            if (n4 < 338 && n4 > 22) {
                if (this.dCos(n4 + 90) * 80 / 100 < 0 && PlayerParam[10] < 0) {
                    PlayerParam[10] = PlayerParam[10] + this.dCos(n4 + 90) * 80 / 100;
                }
                if (this.dCos(n4 + 90) * 80 / 100 > 0 && PlayerParam[10] > 0) {
                    PlayerParam[10] = PlayerParam[10] + this.dCos(n4 + 90) * 80 / 100;
                }
            } else if (olddir == 338 || olddir == 22) {
                if ((this.dCos(n4 + 90) << 5) / 100 < 0 && PlayerParam[10] < 0) {
                    PlayerParam[10] = PlayerParam[10] + this.dCos(n4 + 90) * 80 / 100;
                }
                if ((this.dCos(n4 + 90) << 5) / 100 > 0 && PlayerParam[10] > 0) {
                    PlayerParam[10] = PlayerParam[10] + this.dCos(n4 + 90) * 80 / 100;
                }
            } else {
                PlayerParam[10] = PlayerParam[10] + this.dCos(n4 + 90) * 80 / 100;
            }
            if (PlayerParam[10] >= 0 && n3 <= 0) {
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                PlayerBall = false;
            }
            if (PlayerParam[10] <= 0 && n3 >= 0) {
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                PlayerBall = false;
            }
        }
    }

    public void limitchk(boolean bl) {
        try {
            int n = 112;
            if (this.LookUpCount > 0) {
                n += this.LookUpCount << 1;
            }
            if (this.CrouchCount > 0) {
                n -= this.CrouchCount << 1;
            }
            if (this.zoneNumber == 0 && this.stageNumber == 3) {
                this.poslimit[0] = 0;
                this.poslimit[2] = 0;
                this.poslimit[1] = 3840;
                this.poslimit[3] = 256;
                if (bossBreakOn) {
                    this.poslimit[1] = this.poslimit[1] + 768;
                }
            } else if (this.zoneNumber == 5 && this.stageNumber == 3) {
                this.poslimit[0] = 0;
                this.poslimit[2] = 0;
                this.poslimit[1] = 1440;
                this.poslimit[3] = 64 + n;
                if (bossBreakOn) {
                    this.poslimit[1] = this.poslimit[1] + 768;
                }
                if (mapOxy[0] >= 1200) {
                    if (bossModeOn) {
                        this.poslimit[0] = 1200;
                        this.poslimit[1] = 1440;
                        this.poslimit[2] = 32;
                        this.poslimit[3] = 32 + n;
                    }
                    if (bossBreakOn) {
                        this.poslimit[0] = 1200;
                    }
                    if (mapOxy[0] >= 1808) {
                        this.poslimit[0] = 1808;
                        this.poslimit[1] = 2048;
                        this.poslimit[2] = 32;
                        this.poslimit[3] = 64 + n;
                    }
                }
            } else {
                this.poslimit[0] = 0;
                this.poslimit[2] = 0;
                this.poslimit[1] = this.limitTable[this.zoneNumber][this.stageNumber][2] + 320;
                this.poslimit[3] = this.hlimitget() + (240 - (184 - n));
                if (this.m_bScrollLock == 2) {
                    this.limitBreak = true;
                }
                if (this.stageNumber == 2 && this.zoneNumber == 1) {
                    if (this.PlayerPosX() >= this.m_aaScrollLockPos[this.zoneNumber][this.stageNumber] || this.m_bScrollLock == 1) {
                        this.poslimit[0] = this.m_aaScrollLockPos[this.zoneNumber][this.stageNumber] - 144;
                        this.m_bScrollLock = 1;
                    }
                } else if (this.stageNumber < 2) {
                    if (this.PlayerPosX() >= this.m_aaScrollLockPos[this.zoneNumber][this.stageNumber] || this.m_bScrollLock == 1) {
                        this.poslimit[0] = this.m_aaScrollLockPos[this.zoneNumber][this.stageNumber] - 144;
                        this.m_bScrollLock = 1;
                    }
                } else if (this.m_bScrollLock == 2 && this.zoneNumber != 1) {
                    this.poslimit[0] = (short)(this.limitTable[this.zoneNumber][this.stageNumber][2] + 320);
                }
                if (this.zoneNumber == 1 && this.stageNumber == 2) {
                    this.poslimit[3] = this.poslimit[3] + 56;
                }
                if (this.zoneNumber == 5 && this.stageNumber == 1) {
                    this.poslimit[3] = this.poslimit[3] - 168;
                }
                if (this.stageNumber == 2 && this.zoneNumber != 1 && bossBreakOn) {
                    this.poslimit[1] = this.poslimit[1] + 256;
                }
                if (bossModeOn) {
                    if (this.zoneNumber == 0) {
                        this.poslimit[0] = 10632;
                        this.poslimit[1] = 10872;
                        this.poslimit[2] = 0;
                        this.poslimit[3] = 800 + n;
                    } else if (this.zoneNumber == 2) {
                        this.poslimit[0] = 6168;
                        this.poslimit[1] = 6440;
                        this.poslimit[2] = 560;
                        this.poslimit[3] = 568 + n;
                    } else if (this.zoneNumber == 4) {
                        this.poslimit[0] = 11304;
                        this.poslimit[1] = 11544;
                        this.poslimit[2] = 1232;
                        this.poslimit[3] = 1248 + n;
                    } else if (this.zoneNumber == 3) {
                        this.poslimit[0] = 8280;
                        this.poslimit[1] = 8520;
                        this.poslimit[2] = 528;
                        this.poslimit[3] = 576 + n;
                    }
                }
                if (bossBreakOn) {
                    if (this.zoneNumber == 0) {
                        this.poslimit[0] = 10632;
                    } else if (this.zoneNumber == 2) {
                        this.poslimit[0] = 6168;
                    } else if (this.zoneNumber == 4) {
                        this.poslimit[0] = 11304;
                    } else if (this.zoneNumber == 3) {
                        this.poslimit[0] = 8280;
                    }
                }
            }
            if (PlayerDie) {
                this.checkDieCount();
                return;
            }
            for (int i = 0; i < 2; ++i) {
                int n2 = 0;
                n2 = i == 0 ? 120 : n;
                int n3 = 0;
                n3 = i == 0 ? this.PlayerPosX() : this.PlayerPosY();
                if (i == 0) {
                    if (!bossModeOn && MapEndCounter == 0 && this.zoneNumber == 5 && this.stageNumber == 3) {
                        this.startBossMode();
                    } else if (!bossModeOn && MapEndCounter == 0 && this.zoneNumber == 1 && this.stageNumber == 2 && this.PlayerPosX() >= 7488 && this.PlayerPosY() >= 1536) {
                        this.startBossMode();
                    }
                    if (!bossModeOn || this.zoneNumber != 1) {
                        // empty if block
                    }
                    if (mapOxy[i] >= this.poslimit[1] - 240 && !bossModeOn && MapEndCounter == 0 && this.stageNumber == 2) {
                        this.startBossMode();
                    }
                }
                if (i == 0) {
                    if (n3 - mapOxy[i] != n2) {
                        if (n3 - mapOxy[i] < n2) {
                            if (this.gole_on) {
                                if (mapOxy[i] + 16 << 8 > PlayerParam[0]) {
                                    MainCanvas.PlayerParam[0] = mapOxy[i] + 16 << 8;
                                    if (PlayerParam[10] < 0) {
                                        MainCanvas.PlayerParam[10] = 0;
                                        MainCanvas.PlayerParam[13] = 0;
                                        MainCanvas.PlayerParam[14] = 0;
                                    }
                                    if (!PlayerJump && PlayerBall) {
                                        PlayerBall = false;
                                    }
                                }
                            } else {
                                this.ChkVecL = true;
                                int n4 = i;
                                mapOxy[n4] = mapOxy[n4] - (n2 - (n3 - mapOxy[i]));
                                if (mapOxy[i] < this.poslimit[i << 1]) {
                                    MainCanvas.mapOxy[i] = this.poslimit[i << 1];
                                }
                                if (mapOxy[i] + 16 << 8 > PlayerParam[0]) {
                                    MainCanvas.PlayerParam[0] = mapOxy[i] + 16 << 8;
                                    if (PlayerParam[10] < 0) {
                                        MainCanvas.PlayerParam[10] = 0;
                                        MainCanvas.PlayerParam[13] = 0;
                                        MainCanvas.PlayerParam[14] = 0;
                                    }
                                    if (!PlayerJump && PlayerBall) {
                                        PlayerBall = false;
                                    }
                                    if (PlayerJump && PlayerParam[3] < 0) {
                                        MainCanvas.PlayerParam[3] = 0;
                                    }
                                }
                            }
                        } else if (n3 - mapOxy[i] > n2) {
                            this.ChkVecR = true;
                            int n5 = i;
                            mapOxy[n5] = mapOxy[n5] - (n2 - (n3 - mapOxy[i]));
                            if (mapOxy[i] + n2 * 2 > this.poslimit[(i << 1) + 1]) {
                                MainCanvas.mapOxy[i] = this.poslimit[(i << 1) + 1] - (n2 << 1);
                            }
                            if (this.limitBreak) {
                                if (mapOxy[i] + 96 + 240 << 8 < PlayerParam[0]) {
                                    MainCanvas.PlayerParam[0] = mapOxy[i] + 96 + 240 << 8;
                                    MainCanvas.PlayerParam[10] = 0;
                                    MainCanvas.PlayerParam[13] = 0;
                                    MainCanvas.PlayerParam[14] = 0;
                                    if (!PlayerJump && PlayerBall) {
                                        PlayerBall = false;
                                    }
                                }
                            } else if (mapOxy[i] - 16 + 240 << 8 < PlayerParam[0]) {
                                MainCanvas.PlayerParam[0] = mapOxy[i] - 16 + 240 << 8;
                                MainCanvas.PlayerParam[10] = 0;
                                MainCanvas.PlayerParam[13] = 0;
                                MainCanvas.PlayerParam[14] = 0;
                                if (!PlayerJump && PlayerBall) {
                                    PlayerBall = false;
                                }
                            }
                        }
                    }
                } else {
                    if (bossModeOn && (this.zoneNumber != 1 || this.stageNumber != 2) && mapOxy[i] + n > this.poslimit[i * 2 + 1]) {
                        MainCanvas.mapOxy[i] = this.poslimit[i * 2 + 1] - n;
                    }
                    if (n3 - mapOxy[i] != n2) {
                        int n6 = 0;
                        if (n3 - mapOxy[i] < n2 - n6) {
                            int n7 = i;
                            mapOxy[n7] = mapOxy[n7] - (n2 - n6 - (n3 - mapOxy[i]));
                            if ((this.zoneNumber == 1 && this.stageNumber == 2 && mapOxy[0] < 7936 || this.zoneNumber == 5 && this.stageNumber == 1) && this.LookUpCount <= 0 && this.CrouchCount <= 0) {
                                if (mapOxy[i] < this.poslimit[i * 2]) {
                                    MainCanvas.PlayerParam[1] = this.poslimit[i * 2 + 1] + mapOxy[i] + n2 << 8;
                                    MainCanvas.mapOxy[i] = this.poslimit[i * 2 + 1] + mapOxy[i];
                                }
                            } else if (mapOxy[i] < this.poslimit[i * 2]) {
                                MainCanvas.mapOxy[i] = this.poslimit[i * 2];
                            }
                            if (this.zoneNumber == 1 && this.stageNumber == 0 && PlayerParam[1] < 8192) {
                                MainCanvas.PlayerParam[1] = 8192;
                                if (PlayerParam[5] < 0) {
                                    MainCanvas.PlayerParam[5] = 0;
                                }
                            }
                            if (this.zoneNumber == 4 && PlayerParam[1] < 8192) {
                                MainCanvas.PlayerParam[1] = 8192;
                                if (PlayerParam[5] < 0) {
                                    MainCanvas.PlayerParam[5] = 0;
                                }
                            }
                        } else if (n3 - mapOxy[i] > n2) {
                            int n8 = i;
                            mapOxy[n8] = mapOxy[n8] - (n2 - (n3 - mapOxy[i]));
                            if ((this.zoneNumber == 1 && this.stageNumber == 2 && mapOxy[0] < 7936 || this.zoneNumber == 5 && this.stageNumber == 1) && this.LookUpCount <= 0 && this.CrouchCount <= 0) {
                                if (mapOxy[i] > this.poslimit[i * 2 + 1]) {
                                    MainCanvas.mapOxy[i] = mapOxy[i] % this.poslimit[i * 2 + 1];
                                    MainCanvas.PlayerParam[1] = PlayerParam[1] % (this.poslimit[i * 2 + 1] << 8);
                                }
                            } else if (this.zoneNumber == 1 && this.stageNumber == 2 && mapOxy[0] < 7936 || this.zoneNumber == 5 && this.stageNumber == 1) {
                                if (this.CrouchCount <= 0 && mapOxy[i] > this.poslimit[i * 2 + 1]) {
                                    MainCanvas.mapOxy[i] = this.poslimit[i * 2 + 1];
                                }
                            } else if (mapOxy[i] + n > this.poslimit[i * 2 + 1]) {
                                MainCanvas.mapOxy[i] = this.poslimit[i * 2 + 1] - n;
                            }
                            if (!(this.zoneNumber == 1 && this.stageNumber == 2 || this.zoneNumber == 5 && this.stageNumber == 1)) {
                                if (this.zoneNumber == 3 && mapOxy[i] + 168 << 8 < PlayerParam[i]) {
                                    if (!debugFlag && !PlayerDie) {
                                        MainCanvas.PlayerParam[i] = mapOxy[i] - 16 + 240 << 8;
                                        this.playerDie();
                                    }
                                } else if (mapOxy[i] - 16 + 240 << 8 < PlayerParam[i] && !debugFlag && !PlayerDie) {
                                    MainCanvas.PlayerParam[i] = mapOxy[i] - 16 + 240 << 8;
                                    this.playerDie();
                                }
                            }
                        }
                    }
                }
                if (mapOxy[i] >= 0) continue;
                MainCanvas.mapOxy[i] = 0;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public int hlimitget() {
        int n = MapH * 256 - 232;
        switch (this.zoneNumber) {
            case 0: {
                n = this.zone1((byte)this.stageNumber);
                break;
            }
            case 1: {
                n = 1824;
                break;
            }
            case 2: {
                n = this.zone3((byte)this.stageNumber);
                break;
            }
            case 3: {
                n = this.zone4((byte)this.stageNumber);
                break;
            }
            case 4: {
                n = this.zone5((byte)this.stageNumber);
                break;
            }
            case 5: {
                n = this.zone6((byte)this.stageNumber);
                break;
            }
        }
        return n;
    }

    public int zone1(byte by) {
        int n;
        switch (by) {
            case 0: {
                n = 1024;
                if (6016 <= mapOxy[0]) break;
                n = 768;
                break;
            }
            case 1: {
                n = 768;
                if (3792 > mapOxy[0]) {
                    n = 768;
                    break;
                }
                if (5632 > mapOxy[0]) {
                    n = 512;
                    break;
                }
                if (7520 <= mapOxy[0]) break;
                n = 1024;
                break;
            }
            default: {
                n = 1216;
                if (896 > mapOxy[0]) {
                    n = 768;
                    break;
                }
                if (2400 > mapOxy[0]) {
                    n = 784;
                    break;
                }
                if (640 > mapOxy[1]) {
                    n = 768;
                    break;
                }
                if (4992 > mapOxy[0]) break;
                n = 1024;
                if (5888 > mapOxy[0]) break;
                if (mapOxy[1] > 880) {
                    if (6144 > mapOxy[0]) break;
                    this.poslimit[1] = 6384;
                    MapEndCounter = 1;
                    break;
                }
                n = 768;
            }
        }
        return n;
    }

    public int zone3(byte by) {
        int n;
        switch (by) {
            case 0: {
                if ((plsaveX != 0 || plsaveY != 0) && mapOxy[0] == 0 && mapOxy[1] == 0) {
                    n = 1280;
                    break;
                }
                n = 1024;
                if (this.PlayerPosX() > 3584 && this.PlayerPosX() < 4096 && this.PlayerPosY() > 1024 && this.PlayerPosY() < 1248) {
                    n = 1280;
                    break;
                }
                if (3696 <= mapOxy[0]) {
                    n = 528;
                    if (5168 <= mapOxy[0]) break;
                    n = 1280;
                    break;
                }
                if (1792 > mapOxy[0]) {
                    n = 464;
                    break;
                }
                if (2400 <= mapOxy[0] && 2752 > mapOxy[0]) {
                    n = 1280;
                    if (728 <= mapOxy[1]) break;
                    n = 544;
                    break;
                }
                n = 1280;
                if (728 > mapOxy[1]) {
                    n = 832;
                    if (3328 <= mapOxy[0]) break;
                    n = 544;
                    break;
                }
                if (1176 <= mapOxy[1] || 3792 <= mapOxy[0]) break;
                n = 832;
                break;
            }
            case 1: {
                n = 512;
                if (5888 <= mapOxy[0]) break;
                n = 1312;
                break;
            }
            default: {
                n = 1824;
                if (5472 >= mapOxy[0] || this.PlayerPosY() >= 1280) break;
                n = 528;
            }
        }
        return n;
    }

    public int zone4(byte by) {
        int n = 1824;
        switch (by) {
            case 0: {
                n = 1824;
                break;
            }
            case 1: {
                int n2 = 112;
                n = (MapH << 8) - 72 - (240 - (184 - n2));
                break;
            }
            default: {
                n = 528;
                if (7936 <= mapOxy[0]) break;
                n = 1792;
            }
        }
        return n;
    }

    public int zone5(byte by) {
        int n = 1824;
        switch (by) {
            case 0: {
                break;
            }
            case 1: {
                n = 1312;
                if (9632 > mapOxy[0] || 1248 <= this.PlayerPosY()) break;
                n = 1056;
                break;
            }
            default: {
                n = 1228;
                if (11264 <= mapOxy[0]) break;
                n = 1824;
            }
        }
        return n;
    }

    public int zone6(byte by) {
        int n;
        switch (by) {
            case 0: {
                n = 672;
                if (6272 > mapOxy[0]) {
                    n = 1824;
                    break;
                }
                if (8192 <= mapOxy[0]) break;
                n = 1568;
                break;
            }
            case 1: {
                n = 8032;
                if (6144 > mapOxy[0]) {
                    n = 2048;
                    break;
                }
                if (7680 <= mapOxy[0]) break;
                n = 1464;
                break;
            }
            default: {
                n = 1824;
            }
        }
        return n;
    }

    public void speedset(int n) {
        this.playerBressChk();
        if (this.zoneNumber == 1 && this.waterH2 < this.PlayerPosY() - 12) {
            PlayerParam[0] = PlayerParam[0] + (plspeed[0] >> 1);
            PlayerParam[1] = PlayerParam[1] + (plspeed[1] >> 1);
        } else {
            if (plspeed[0] > 4096) {
                MainCanvas.plspeed[0] = 4096;
            }
            if (plspeed[0] < -4096) {
                MainCanvas.plspeed[0] = -4096;
            }
            if (plspeed[1] > 4096) {
                MainCanvas.plspeed[1] = 4096;
            }
            if (plspeed[1] < -4096) {
                MainCanvas.plspeed[1] = -4096;
            }
            PlayerParam[0] = PlayerParam[0] + plspeed[0];
            PlayerParam[1] = PlayerParam[1] + plspeed[1];
        }
        if (n == 1) {
            if (falltimer <= 0) {
                PlayerParam[5] = this.zoneNumber == 1 && this.waterH2 < this.PlayerPosY() - 12 ? PlayerParam[5] + gravity / 2 : PlayerParam[5] + gravity;
            } else {
                --falltimer;
            }
        }
        PlayerParam[11] = n == 1 && PlayerBall ? PlayerParam[11] + plmaxspd : (Math.abs(plspeed[0]) + Math.abs(plspeed[1]) > plmaxspd ? PlayerParam[11] + plmaxspd : PlayerParam[11] + (Math.abs(plspeed[0]) + Math.abs(plspeed[1])));
    }

    public boolean fallchk() {
        if (olddir <= 290 && olddir >= 70) {
            if (olddir < 90 || olddir > 270) {
                if (Math.abs(PlayerParam[10]) < 640) {
                    if (PlayerParam[10] < 0) {
                        MainCanvas.PlayerParam[12] = 1;
                        MainCanvas.PlayerParam[13] = 0;
                        MainCanvas.PlayerParam[14] = 0;
                    } else {
                        MainCanvas.PlayerParam[12] = 0;
                        MainCanvas.PlayerParam[13] = 0;
                        MainCanvas.PlayerParam[14] = 0;
                    }
                    int n = Math.abs(PlayerParam[10]);
                    MainCanvas.PlayerParam[5] = 280;
                    MainCanvas.PlayerParam[3] = -(this.dSin(olddir + 90) * n) / 100;
                    PlayerJump = true;
                    PlayerDamage = false;
                    raidOn = false;
                    this.noLeverTimer = 30;
                    this.hcol();
                }
            } else if (Math.abs(PlayerParam[10]) < 640) {
                if (PlayerParam[10] < 0) {
                    MainCanvas.PlayerParam[12] = 1;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                } else {
                    MainCanvas.PlayerParam[12] = 0;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                }
                int n = PlayerParam[10];
                MainCanvas.PlayerParam[5] = this.dCos(olddir + 90) * n / 100;
                if (olddir > 90 && olddir < 270) {
                    MainCanvas.PlayerParam[5] = 0;
                }
                MainCanvas.PlayerParam[3] = this.dSin(olddir + 90) * n / 100;
                PlayerJump = true;
                PlayerDamage = false;
                raidOn = false;
                this.nofcolTimer = 15;
                if (olddir == 90 || olddir == 270) {
                    this.nofcolTimer = 0;
                }
                this.hcol();
            }
        }
        return false;
    }

    public int PlayerPosX() {
        return PlayerParam[0] >> 8;
    }

    public int PlayerPosY() {
        return PlayerParam[1] >> 8;
    }

    public void playdamageset() {
        if (!debugFlag && !this.damageNow && mutekicount <= 0) {
            if (bariacount > 0) {
                bariacount = 0;
                muteki2count = 60;
                PlayerDamage = true;
                PlayerJump = true;
                MainCanvas.PlayerParam[3] = PlayerParam[12] == 1 ? 512 : -512;
                MainCanvas.PlayerParam[5] = -1024;
                MainCanvas.PlayerParam[12] = (PlayerParam[12] + 1) % 2;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                this.damageNow = true;
            } else if (muteki2count <= 0) {
                if (ringcount <= 0) {
                    this.playerDie();
                } else {
                    this.Vibrate(1000);
                    muteki2count = 60;
                    PlayerDamage = true;
                    PlayerJump = true;
                    if (this.kyuryuchk()) {
                        this.damageMoveTimer = 10;
                        MainCanvas.PlayerParam[3] = -512;
                        MainCanvas.PlayerParam[5] = -1024;
                    } else {
                        MainCanvas.PlayerParam[3] = PlayerParam[12] == 1 ? 512 : -512;
                        MainCanvas.PlayerParam[5] = -1024;
                    }
                    MainCanvas.PlayerParam[12] = (PlayerParam[12] + 1) % 2;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                    this.ShotRing(this.PlayerPosX(), this.PlayerPosY() - 12, ringcount);
                    ringcount = 0;
                    this.damageNow = true;
                }
            }
        }
    }

    public void playdamageset2() {
        if (!debugFlag && !this.damageNow && mutekicount <= 0) {
            if (bariacount > 0) {
                bariacount = 0;
                muteki2count = 60;
                PlayerDamage = true;
                PlayerJump = true;
                MainCanvas.PlayerParam[3] = PlayerParam[12] == 1 ? 512 : -512;
                MainCanvas.PlayerParam[5] = -1024;
                MainCanvas.PlayerParam[12] = (PlayerParam[12] + 1) % 2;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                this.damageNow = true;
            } else if (muteki2count <= 0) {
                if (ringcount <= 0) {
                    this.playerDie();
                } else {
                    this.Vibrate(1000);
                    muteki2count = 60;
                    PlayerDamage = true;
                    PlayerJump = true;
                    if (this.kyuryuchk()) {
                        this.damageMoveTimer = 10;
                        MainCanvas.PlayerParam[3] = 512;
                        MainCanvas.PlayerParam[5] = 0;
                    } else {
                        MainCanvas.PlayerParam[3] = PlayerParam[12] == 1 ? 512 : -512;
                        MainCanvas.PlayerParam[5] = -1024;
                    }
                    MainCanvas.PlayerParam[12] = (PlayerParam[12] + 1) % 2;
                    MainCanvas.PlayerParam[13] = 0;
                    MainCanvas.PlayerParam[14] = 0;
                    this.ShotRing(this.PlayerPosX(), this.PlayerPosY() - 12, ringcount);
                    ringcount = 0;
                    this.damageNow = true;
                }
            }
        }
    }

    public void playerDie() {
        int n = 0;
        if (PlayerDie) {
            this.SetSoftFlag = true;
            this.SetSoftCount = 10;
            return;
        }
        this.Vibrate(1000);
        TimerStop = true;
        this.bressCount = 2100;
        this.bressMusic = true;
        PlayerJump = true;
        PlayerDamage = false;
        PlayerBall = false;
        PlayerDie = true;
        this.PlayerSub = true;
        raidOn = false;
        MainCanvas.PlayerParam[10] = 0;
        MainCanvas.PlayerParam[13] = 0;
        MainCanvas.PlayerParam[14] = 0;
        falltimer = 5;
        MainCanvas.PlayerParam[3] = 0;
        MainCanvas.PlayerParam[5] = this.dCos(n) * pljump / 100;
        diecount = 120;
    }

    public void checkDieCount() {
        if (PlayerDie) {
            MainCanvas.PlayerParam[3] = 0;
            --diecount;
            if (mapOxy[1] - 16 + 240 << 8 < PlayerParam[1] && this.PlayerSub) {
                this.PlayerSub = false;
                if (--playercount <= 0) {
                    this.PlayMusic(21);
                    diecount = 660;
                    this.SetSoftFlag = true;
                    this.SetSoftCount = 10;
                    for (int i = 0; i < m_nHiScore.length; ++i) {
                        if (m_nHiScore[i] >= scorecount) continue;
                        for (int j = m_nHiScore.length - 1; j > i; --j) {
                            MainCanvas.m_nHiScore[j] = m_nHiScore[j - 1];
                            MainCanvas.m_nDifficulty[j] = m_nDifficulty[j - 1];
                        }
                        MainCanvas.m_nHiScore[i] = scorecount;
                        MainCanvas.m_nDifficulty[i] = m_nConfigValue[0];
                        this.save_hisc();
                        break;
                    }
                    scorecount = 0;
                } else if (timecount == 59 && timecount2 == 9) {
                    diecount = 240;
                    this.timeUpDie = true;
                    this.SetSoftFlag = true;
                    this.SetSoftCount = 10;
                    plsaveTime = 0;
                    plsaveTime2 = 0;
                    this.noTimeScore = true;
                }
            }
            if (diecount < 0) {
                if (playercount <= 0) {
                    this.startContinue();
                    this.SetSoftFlag = true;
                    this.SetSoftCount = 10;
                } else {
                    this.initStageStart();
                }
            }
        }
    }

    public void playerRaidOn(int n) {
        int n2;
        this.crushing[0] = true;
        if (this.damageNow || PlayerParam[5] < 0) {
            return;
        }
        if (PlayerJump && PlayerBall && !PlayerAir) {
            PlayerBall = false;
        }
        if ((n2 = raidObjectW - 8) < 0) {
            n2 = 0;
        } else if (Math.abs(this.PlayerPosX() - raidObjectX) > n2) {
            OttotoOn = true;
            OttotoSide = 0;
            if (this.PlayerPosX() - raidObjectX > 0) {
                OttotoSide = 1;
            }
        }
        this.playdamageYogan = false;
        MainCanvas.PlayerParam[8] = 0;
        MainCanvas.PlayerParam[5] = 0;
        if (PlayerJump) {
            MainCanvas.PlayerParam[10] = PlayerParam[3];
            if (PlayerParam[10] < 0) {
                MainCanvas.PlayerParam[13] = 1;
            }
            if (PlayerParam[10] > 0) {
                MainCanvas.PlayerParam[13] = 2;
            }
            MainCanvas.PlayerParam[14] = 0;
        }
        MainCanvas.PlayerParam[3] = 0;
        raidOn = true;
        raidObjectNum = n;
        olddir = 0;
        PlayerJump = false;
        PlayerSJump = false;
        PlayerWater = false;
        comboScore = 0;
    }

    public byte getPlayerArg2(int n, int n2) {
        int n3;
        if (n < 0) {
            n = 0;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (this.hitChk[(n3 = (tempWorldMapData[(n2 >> 4 >> 4) % MapH][n >> 4 >> 4] << 9) + ((n >> 4 & 0xF) + ((n2 >> 4 & 0xF) << 4) << 1) + 1) >> 1] == 1) {
            return -1;
        }
        int n4 = (mapData[n3] & 0xFF) + (this.imageOffset[n3 >> 1] << 8);
        return (byte)this.blockdirChk(n4);
    }

    public int getPlayerArg(int n, int n2) {
        int n3;
        if (n < 0) {
            n = 0;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (this.hitChk[(n3 = (tempWorldMapData[(n2 >> 4 >> 4) % MapH][n >> 4 >> 4] << 9) + ((n >> 4 & 0xF) + ((n2 >> 4 & 0xF) << 4) << 1) + 1) >> 1] == 1) {
            return -1;
        }
        int n4 = (mapData[n3] & 0xFF) + (this.imageOffset[n3 >> 1] << 8);
        int n5 = this.blockdirChk(n4) * 360 / 255;
        if (this.rot[n3 >> 1] == 1) {
            n5 = 360 - n5;
        } else if (this.rot[n3 >> 1] == 2) {
            n5 = 540 - n5;
        } else if (this.rot[n3 >> 1] == 3) {
            n5 = 540 - n5;
            n5 %= 360;
            n5 = 360 - n5;
        }
        if (n5 % 90 == 0) {
            if (olddir == 62) {
                n5 = 90;
                return n5;
            }
            n5 = Math.abs((olddir - 22 + 45) / 90) * 90;
            if (olddir == 44) {
                n5 = 0;
            }
        }
        return n5 % 360;
    }

    public void drawPlayerImage(Graphics graphics) {
        if (this.playerDraw) {
            return;
        }
        int n = rotNumTable[TRANS_NONE];
        int n2 = (540 - olddir) % 360;
        if (PlayerParam[12] == 1) {
            n = rotNumTable[TRANS_MIRROR];
        }
        MainCanvas.PlayerParam[11] = PlayerParam[11] % 92160;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        if (PlayerSJump) {
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 240, 80, 40, 45, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
        } else if (PlayerDamage && PlayerJump) {
            n = PlayerParam[12] == 1 ? rotNumTable[TRANS_MIRROR - 4] : rotNumTable[TRANS_MIRROR];
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 160, 80, 40, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1] - 5, 1 | 0x20);
        } else if (kokyutimer > 0) {
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 352, 0, 40, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            --kokyutimer;
        } else if (PlayerBou) {
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 144 + 48 * ((this.animeTimer >> 1) % 2), 128, 49, 32, rotNumTable[TRANS_NONE + 4], this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            PlayerBou = false;
        } else if (PlayerSWater) {
            if ((this.animeTimer >> 1) % 5 < 3) {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 48 * ((this.animeTimer >> 1) % 5), 120, 45, 24, rotNumTable[TRANS_NONE], this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            } else {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 240 - 48 * ((this.animeTimer >> 1) % 5), 120, 45, 24, rotNumTable[TRANS_NONE + 4], this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            }
            PlayerSWater = false;
        } else if (PlayerBall && PlayerJump) {
            n3 = 0;
            if (PlayerJump && olddir == 270) {
                n3 -= 16;
            }
            n5 = -24 + this.dSin(n2) * 24 / 100;
            n6 = -24 - this.dCos(n2) * 24 / 100;
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 192 + PlayerParam[11] / plmaxspd / 4 % 5 * 32, 0, 32, 40, n, this.PlayerPosX() - mapView[0] + n3, this.PlayerPosY() - mapView[1], 1 | 0x20);
        } else if (PlayerWater) {
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 120 + 40 * (this.animeTimer / 2 % 2), 80, 40, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1] - 5, 1 | 0x20);
        } else if (PlayerDie) {
            if (this.bressDie) {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 280, 80, 40, 44, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            } else {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 200, 80, 40, 44, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            }
        } else if (PlayerBall && !PlayerJump) {
            n3 = -16 + this.dSin(n2) * 16 / 100;
            n4 = -15 - this.dCos(n2) * 15 / 100;
            n5 = -24 + this.dSin(n2) * 24 / 100;
            n6 = -24 - this.dCos(n2) * 24 / 100;
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 192 + PlayerParam[11] / plmaxspd / 4 % 5 * 32, 10, 32, 30, n, this.PlayerPosX() - mapView[0] + n3, this.PlayerPosY() - mapView[1] + n4, 20);
        } else if (PlayerCrouch) {
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 0, 80, 40, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            PlayerCrouch = false;
        } else if (PlayerLookUp) {
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 160, 0, 32, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            PlayerLookUp = false;
        } else if (this.pushCount > 0) {
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 288 + this.animeTimer / 4 % 4 * 32, 120, 32, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
        } else if (PlayerParam[10] == 0 && !PlayerJump) {
            if (OttotoOn) {
                if (OttotoSide == 1) {
                    this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 40 + this.playerStandCount / 8 % 2 * 40, 80, 40, 40, rotNumTable[TRANS_NONE], this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
                } else {
                    this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 40 + this.playerStandCount / 8 % 2 * 40, 80, 40, 40, rotNumTable[TRANS_MIRROR], this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
                }
            } else if (!(raidOn || olddir > 22 && olddir < 338 || (this.blockColChk_easy(this.PlayerPosX() + 12, this.PlayerPosY()) || this.blockColChk_easy(this.PlayerPosX() + 12, this.PlayerPosY() + 16)) && (this.blockColChk_easy(this.PlayerPosX() - 12, this.PlayerPosY()) || this.blockColChk_easy(this.PlayerPosX() - 12, this.PlayerPosY() + 16)))) {
                n = !this.blockColChk_easy(this.PlayerPosX() + 12, this.PlayerPosY()) && !this.blockColChk_easy(this.PlayerPosX() + 12, this.PlayerPosY() + 16) ? rotNumTable[TRANS_NONE] : rotNumTable[TRANS_MIRROR];
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 40 + this.playerStandCount / 8 % 2 * 40, 80, 40, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            } else if (this.playerStandCount < 75) {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 0, 0, 32, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            } else if (this.playerStandCount < 90) {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 32, 0, 32, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            } else if (this.playerStandCount < 105) {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 64, 0, 32, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            } else {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 96 + this.playerStandCount / 8 % 2 * 32, 0, 32, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
            }
        } else if (!PlayerJump && (PlayerParam[14] == 2 && PlayerParam[10] > 0 && PlayerParam[12] == 1 || PlayerParam[14] == 1 && PlayerParam[10] < 0 && PlayerParam[12] == 0)) {
            n = rotNumTable[TRANS_NONE];
            if (PlayerParam[12] == 0) {
                n = rotNumTable[TRANS_MIRROR];
            }
            this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 360 + PlayerParam[11] / plmaxspd / 4 % 2 * 40, 80, 40, 40, n, this.PlayerPosX() - mapView[0], this.PlayerPosY() - mapView[1], 1 | 0x20);
        } else if (Math.abs(PlayerParam[10]) >= plmaxspd || PlayerDush) {
            int n7 = 0;
            n3 = -20 + this.dSin(n2) * 20 / 100;
            n4 = -20 - this.dCos(n2) * 20 / 100;
            n5 = -24 + this.dSin(n2) * 24 / 100;
            n6 = -24 - this.dCos(n2) * 24 / 100;
            if (PlayerJump && olddir != 0) {
                n3 += this.dCos(olddir) * 20 / 100;
            }
            if (PlayerParam[12] == 1) {
                int n8;
                n = rotNumTable[TRANS_MIRROR];
                int[] nArray = new int[]{rotNumTable[TRANS_MIRROR_ROT90], rotNumTable[TRANS_MIRROR_ROT90], rotNumTable[TRANS_MIRROR], rotNumTable[TRANS_MIRROR], rotNumTable[TRANS_MIRROR_ROT270], rotNumTable[TRANS_MIRROR_ROT270], rotNumTable[TRANS_MIRROR_ROT180], rotNumTable[TRANS_MIRROR_ROT180]};
                for (n8 = 0; n8 < 7 && (n8 * 45 + 23 >= n2 || (n8 + 1) * 45 + 23 < n2); ++n8) {
                }
                n = nArray[n8];
                n7 = n8 % 2;
            } else {
                int n9;
                int[] nArray = new int[]{rotNumTable[TRANS_ROT180], rotNumTable[TRANS_ROT90], rotNumTable[TRANS_ROT90], rotNumTable[TRANS_NONE], rotNumTable[TRANS_NONE], rotNumTable[TRANS_ROT270], rotNumTable[TRANS_ROT270], rotNumTable[TRANS_ROT180]};
                for (n9 = 0; n9 < 7 && (n9 * 45 + 23 >= n2 || (n9 + 1) * 45 + 23 < n2); ++n9) {
                }
                n = nArray[n9];
                n7 = n9 % 2;
            }
            if (n7 == 1) {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], 240 + PlayerParam[11] / plmaxspd / 4 % 4 * 40, 40, 40, 40, n, this.PlayerPosX() - mapView[0] + n3, this.PlayerPosY() - mapView[1] + n4, 20);
            } else {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_S], 240 + PlayerParam[11] / plmaxspd / 4 % 4 * 40, 0, 40, 42, n, this.PlayerPosX() - mapView[0] + n3, this.PlayerPosY() - mapView[1] + n4, 20);
            }
        } else {
            int n10 = 0;
            n3 = -20 + this.dSin(n2) * 20 / 100;
            n4 = -20 - this.dCos(n2) * 20 / 100;
            n5 = -24 + this.dSin(n2) * 24 / 100;
            n6 = -24 - this.dCos(n2) * 24 / 100;
            if (PlayerJump && olddir != 0) {
                n3 += this.dCos(olddir) * 20 / 100;
            }
            if (PlayerParam[12] == 1) {
                int n11;
                n = rotNumTable[TRANS_MIRROR];
                int[] nArray = new int[]{rotNumTable[TRANS_MIRROR_ROT90], rotNumTable[TRANS_MIRROR_ROT90], rotNumTable[TRANS_MIRROR], rotNumTable[TRANS_MIRROR], rotNumTable[TRANS_MIRROR_ROT270], rotNumTable[TRANS_MIRROR_ROT270], rotNumTable[TRANS_MIRROR_ROT180], rotNumTable[TRANS_MIRROR_ROT180]};
                for (n11 = 0; n11 < 7 && (n11 * 45 + 23 >= n2 || (n11 + 1) * 45 + 23 < n2); ++n11) {
                }
                n = nArray[n11];
                n10 = n11 % 2;
            } else {
                int n12;
                int[] nArray = new int[]{rotNumTable[TRANS_ROT180], rotNumTable[TRANS_ROT90], rotNumTable[TRANS_ROT90], rotNumTable[TRANS_NONE], rotNumTable[TRANS_NONE], rotNumTable[TRANS_ROT270], rotNumTable[TRANS_ROT270], rotNumTable[TRANS_ROT180]};
                for (n12 = 0; n12 < 7 && (n12 * 45 + 23 >= n2 || (n12 + 1) * 45 + 23 < n2); ++n12) {
                }
                n = nArray[n12];
                n10 = n12 % 2;
            }
            if (n10 == 1) {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_N], PlayerParam[11] / plmaxspd / 4 % 6 * 40, 40, 40, 40, n, this.PlayerPosX() - mapView[0] + n3, this.PlayerPosY() - mapView[1] + n4, 20);
            } else {
                this.drawRegion(graphics, this.m_imgCmd[SONIC_S], PlayerParam[11] / plmaxspd / 4 % 6 * 40, 0, 40, 42, n, this.PlayerPosX() - mapView[0] + n3, this.PlayerPosY() - mapView[1] + n4, 20);
            }
        }
        PlayerDush = false;
        if (this.pushCount > 0) {
            --this.pushCount;
        }
        this.playerStandCount = PlayerParam[10] == 0 && !PlayerJump ? ++this.playerStandCount : 0;
        if (mutekicount > 0) {
            if (this.animeTimer % 2 == 0) {
                if (n3 != 0 || n4 != 0) {
                    this.setObjData(this.PlayerPosX() + n5 + 24, this.PlayerPosY() + n6 + 24, 0);
                } else {
                    this.setObjData(this.PlayerPosX(), this.PlayerPosY() - 18, 0);
                }
            }
        } else if (bariacount > 0) {
            if (n3 != 0 || n4 != 0) {
                if (this.animeTimer % 3 == 2) {
                    this.drawRegion(gg, this.m_imgObj[109], 48, 48, 48, 48, rotNumTable[TRANS_NONE + 4], this.PlayerPosX() - mapView[0] + n5, this.PlayerPosY() - mapView[1] + n6, 20);
                } else {
                    this.drawRegion(gg, this.m_imgObj[109], 48, 48 * (this.animeTimer % 3), 48, 48, rotNumTable[TRANS_NONE], this.PlayerPosX() - mapView[0] + n5, this.PlayerPosY() - mapView[1] + n6, 20);
                }
            } else if (this.animeTimer % 3 == 2) {
                this.drawRegion(gg, this.m_imgObj[109], 48, 48, 48, 48, rotNumTable[TRANS_NONE + 4], this.PlayerPosX() - mapView[0], this.PlayerPosY() - 18 - mapView[1], 1 | 2);
            } else {
                this.drawRegion(gg, this.m_imgObj[109], 48, 48 * (this.animeTimer % 3), 48, 48, rotNumTable[TRANS_NONE], this.PlayerPosX() - mapView[0], this.PlayerPosY() - 18 - mapView[1], 1 | 2);
            }
        }
    }

    private void setObjData(int n, int n2, int n3) {
        for (int i = 0; i < objData.length; ++i) {
            if (objData[i][0] != 0) continue;
            MainCanvas.objData[i][0] = 1;
            MainCanvas.objData[i][1] = n3;
            MainCanvas.objData[i][2] = n;
            MainCanvas.objData[i][3] = n2;
            MainCanvas.objData[i][5] = 0;
            break;
        }
    }

    private void moveObjData() {
        for (int i = 0; i < objData.length; ++i) {
            if (objData[i][0] != 1 || objData[i][1] != 0) continue;
            int[] nArray = objData[i];
            nArray[5] = nArray[5] + 1;
            if (objData[i][5] <= 60) continue;
            MainCanvas.objData[i][5] = 0;
            MainCanvas.objData[i][0] = 0;
        }
    }

    private void drawObjData() {
        for (int i = 0; i < objData.length; ++i) {
            if (objData[i][0] != 1 || objData[i][1] != 0) continue;
            this.drawRegion(gg, this.m_imgObj[109], 0, 48 * (objData[i][5] / 4 % 2), 48, 48, rotNumTable[TRANS_NONE], objData[i][2] - mapView[0], objData[i][3] - mapView[1], 1 | 2);
        }
    }

    public void objectInit(int n) {
        int n2 = 0;
        if (n > 3) {
            n = 3;
        }
        try {
            int n3;
            int n4 = 0;
            for (n3 = 0; n3 < zoneActTable[n].length / 7; ++n3) {
                if (0 == zoneActTable[n][n3 * 7 + 5] || 1 == zoneActTable[n][n3 * 7 + 5] || 63 == zoneActTable[n][n3 * 7 + 5] || 64 == zoneActTable[n][n3 * 7 + 5] || 65 == zoneActTable[n][n3 * 7 + 5] || 66 == zoneActTable[n][n3 * 7 + 5] || 67 == zoneActTable[n][n3 * 7 + 5] || 68 == zoneActTable[n][n3 * 7 + 5] || 69 == zoneActTable[n][n3 * 7 + 5]) {
                    ++n2;
                    n2 += zoneActTable[n][n3 * 7 + 6];
                    continue;
                }
                ++n2;
            }
            zoneActTable2 = new int[n2];
            ObjectAct = new boolean[n2 + 20];
            ObjectDead = new boolean[n2 + 20];
            n2 = 0;
            for (n3 = 0; n3 < zoneActTable[n].length / 7; ++n3) {
                MainCanvas.zoneActTable2[n3] = n2++;
                if (0 != zoneActTable[n][n3 * 7 + 5] && 1 != zoneActTable[n][n3 * 7 + 5] && 63 != zoneActTable[n][n3 * 7 + 5] && 64 != zoneActTable[n][n3 * 7 + 5] && 65 != zoneActTable[n][n3 * 7 + 5] && 66 != zoneActTable[n][n3 * 7 + 5] && 67 != zoneActTable[n][n3 * 7 + 5] && 68 != zoneActTable[n][n3 * 7 + 5] && 69 != zoneActTable[n][n3 * 7 + 5]) continue;
                for (n4 = 0; n4 < zoneActTable[n][n3 * 7 + 6] + 1; ++n4) {
                    ++n2;
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void addObjectChk() {
        block18: {
            if (this.endingModeOn) {
                return;
            }
            if (this.zoneNumber == 5 && this.stageNumber == 3) {
                return;
            }
            try {
                int n;
                block19: {
                    if (this.ChkVecR) {
                        int n2;
                        block17: {
                            if (this.objChkPoint < this.objChkNum) {
                                this.objChkNum = this.objChkPoint;
                            } else {
                                this.objChkPoint = this.objChkNum;
                            }
                            do {
                                if ((n2 = (zoneActTable[this.stageNumber][this.objChkNum * 7 + 0] & 0xFF) << 8 | zoneActTable[this.stageNumber][this.objChkNum * 7 + 1] & 0xFF) - mapOxy[0] > this.RSize) {
                                    this.ChkVecR = false;
                                    break block17;
                                }
                                if (!ObjectAct[zoneActTable2[this.objChkNum]]) {
                                    this.addObjectSet(this.objChkNum);
                                }
                                ++this.objChkNum;
                            } while (this.objChkNum < zoneActTable[this.stageNumber].length / 7);
                            this.objChkNum = zoneActTable[this.stageNumber].length / 7 - 1;
                            this.ChkVecR = false;
                        }
                        while ((n2 = (zoneActTable[this.stageNumber][this.objChkPoint * 7 + 0] & 0xFF) << 8 | zoneActTable[this.stageNumber][this.objChkPoint * 7 + 1] & 0xFF) - mapOxy[0] < this.LSize) {
                            ++this.objChkPoint;
                            if (this.objChkPoint < zoneActTable[this.stageNumber].length / 7) continue;
                            this.objChkPoint = zoneActTable[this.stageNumber].length / 7 - 1;
                            break block18;
                        }
                        break block18;
                    }
                    if (!this.ChkVecL) break block18;
                    if (this.objChkPoint > this.objChkNum) {
                        this.objChkNum = this.objChkPoint;
                    } else {
                        this.objChkPoint = this.objChkNum;
                    }
                    do {
                        if ((n = (zoneActTable[this.stageNumber][this.objChkNum * 7 + 0] & 0xFF) << 8 | zoneActTable[this.stageNumber][this.objChkNum * 7 + 1] & 0xFF) - mapOxy[0] < this.LSize) {
                            this.ChkVecL = false;
                            break block19;
                        }
                        if (!ObjectAct[zoneActTable2[this.objChkNum]]) {
                            this.addObjectSet(this.objChkNum);
                        }
                        --this.objChkNum;
                    } while (this.objChkNum >= 0);
                    this.objChkNum = 0;
                    this.ChkVecL = false;
                }
                while ((n = (zoneActTable[this.stageNumber][this.objChkPoint * 7 + 0] & 0xFF) << 8 | zoneActTable[this.stageNumber][this.objChkPoint * 7 + 1] & 0xFF) - mapOxy[0] > this.RSize) {
                    --this.objChkPoint;
                    if (this.objChkPoint >= 0) continue;
                    this.objChkPoint = 0;
                    break;
                }
            }
            catch (Throwable throwable) {
                this.ChkVecR = false;
            }
        }
    }

    public void addObjectSet(int n) {
        int n2;
        int n3 = 1;
        int n4 = n * 7;
        int n5 = zoneActTable[this.stageNumber][n * 7 + 5] & 0xFF;
        if (0 == n5 || 1 == n5 || 63 == n5 || 64 == n5 || 65 == n5 || 66 == n5 || 67 == n5 || 68 == n5 || 69 == n5) {
            n2 = (zoneActTable[this.stageNumber][n4 + 0] & 0xFF) << 8 | zoneActTable[this.stageNumber][n4 + 1] & 0xFF;
            int n6 = (zoneActTable[this.stageNumber][n4 + 2] & 0xFF) << 8 | zoneActTable[this.stageNumber][n4 + 3] & 0xFF;
            if ((n3 += zoneActTable[this.stageNumber][n4 + 6]) != 1) {
                switch (zoneActTable[this.stageNumber][n4 + 5]) {
                    case 0: {
                        n2 += (n3 - 1) * 24;
                        break;
                    }
                    case 1: {
                        n6 += (n3 - 1) * 24;
                        break;
                    }
                    case 63: {
                        n2 -= (n3 - 1) * 16;
                        n6 += (n3 - 1) * 16;
                        break;
                    }
                    case 64: {
                        n2 += (n3 - 1) * 16;
                        n6 += (n3 - 1) * 16;
                        break;
                    }
                    case 65: {
                        n2 += (n3 - 1) * 32;
                        n6 += (n3 - 1) * 32;
                        break;
                    }
                    case 66: {
                        n2 += (n3 - 1) * 16;
                        break;
                    }
                    case 67: {
                        n2 += (n3 - 1) * 32;
                        break;
                    }
                    case 68: {
                        n6 += (n3 - 1) * 16;
                        break;
                    }
                    case 69: {
                        n6 += (n3 - 1) * 32;
                    }
                }
                if (n2 - mapOxy[0] < this.LSize) {
                    return;
                }
                if (n2 - mapOxy[0] > this.RSize) {
                    return;
                }
            }
        } else if ((n5 == 41 || n5 == 86 || n5 == 87 || n5 == 81 || n5 == 57 || n5 == 78 || n5 == 40 || n5 == 70 || n5 == 39 || n5 == 74 || n5 == 49 || n5 == 50 || n5 == 71 || n5 == 51 || n5 == 10 || n5 == 35) && (n2 = (zoneActTable[this.stageNumber][n4 + 0] & 0xFF) << 8 | zoneActTable[this.stageNumber][n4 + 1] & 0xFF) - mapOxy[0] > -48 && n2 - mapOxy[0] < 288) {
            return;
        }
        for (n2 = 0; n2 < n3; ++n2) {
            int[] nArray = new int[25];
            if (ObjectDead[zoneActTable2[n] + n2] || ObjectAct[zoneActTable2[n] + n2]) continue;
            nArray[0] = 1;
            nArray[1] = zoneActTable[this.stageNumber][n4 + 5] & 0xFF;
            nArray[2] = (zoneActTable[this.stageNumber][n4 + 0] & 0xFF) << 8 | zoneActTable[this.stageNumber][n4 + 1] & 0xFF;
            nArray[3] = (zoneActTable[this.stageNumber][n4 + 2] & 0xFF) << 8 | zoneActTable[this.stageNumber][n4 + 3] & 0xFF;
            nArray[8] = (zoneActTable[this.stageNumber][n4 + 0] & 0xFF) << 8 | zoneActTable[this.stageNumber][n4 + 1] & 0xFF;
            nArray[9] = (zoneActTable[this.stageNumber][n4 + 2] & 0xFF) << 8 | zoneActTable[this.stageNumber][n4 + 3] & 0xFF;
            if (n3 != 1) {
                switch (zoneActTable[this.stageNumber][n4 + 5]) {
                    case 0: {
                        nArray[2] = nArray[2] + n2 * 24;
                        nArray[8] = nArray[8] + n2 * 24;
                        break;
                    }
                    case 1: {
                        nArray[3] = nArray[3] + n2 * 24;
                        nArray[9] = nArray[9] + n2 * 24;
                        break;
                    }
                    case 63: {
                        nArray[2] = nArray[2] - n2 * 16;
                        nArray[8] = nArray[8] - n2 * 16;
                        nArray[3] = nArray[3] + n2 * 16;
                        nArray[9] = nArray[9] + n2 * 16;
                        break;
                    }
                    case 64: {
                        nArray[2] = nArray[2] + n2 * 16;
                        nArray[8] = nArray[8] + n2 * 16;
                        nArray[3] = nArray[3] + n2 * 16;
                        nArray[9] = nArray[9] + n2 * 16;
                        break;
                    }
                    case 65: {
                        nArray[2] = nArray[2] + n2 * 32;
                        nArray[8] = nArray[8] + n2 * 32;
                        nArray[3] = nArray[3] + n2 * 32;
                        nArray[9] = nArray[9] + n2 * 32;
                        break;
                    }
                    case 66: {
                        nArray[2] = nArray[2] + n2 * 16;
                        nArray[8] = nArray[8] + n2 * 16;
                        break;
                    }
                    case 67: {
                        nArray[2] = nArray[2] + n2 * 32;
                        nArray[8] = nArray[8] + n2 * 32;
                        break;
                    }
                    case 68: {
                        nArray[3] = nArray[3] + n2 * 16;
                        nArray[9] = nArray[9] + n2 * 16;
                        break;
                    }
                    case 69: {
                        nArray[3] = nArray[3] + n2 * 32;
                        nArray[9] = nArray[9] + n2 * 32;
                    }
                }
            }
            nArray[4] = zoneActTable[this.stageNumber][n4 + 6] & 0xFF;
            nArray[19] = zoneActTable[this.stageNumber][n4 + 4] & 0xFF;
            nArray[20] = zoneActTable2[n] + n2;
            nArray[22] = zoneActTable2[n];
            if (m_nConfigValue[0] == 0 ? nArray[1] == 41 || nArray[1] == 86 || nArray[1] == 87 || nArray[1] == 81 || nArray[1] == 57 || nArray[1] == 78 || nArray[1] == 40 || nArray[1] == 70 || nArray[1] == 39 || nArray[1] == 74 || nArray[1] == 49 || nArray[1] == 50 || nArray[1] == 71 || nArray[1] == 51 : m_nConfigValue[0] == 1 && (nArray[1] == 40 || nArray[1] == 70 || nArray[1] == 39 || nArray[1] == 74 && nArray[4] == 0 || nArray[1] == 49 || nArray[1] == 50 || nArray[1] == 71)) {
                return;
            }
            MainCanvas.ObjectAct[MainCanvas.zoneActTable2[n] + n2] = true;
            if (nArray[1] == 0 && this.zoneNumber == 5 && this.stageNumber == 1 && 6144 > nArray[2] && nArray[3] < 256) {
                nArray[11] = 1;
                nArray[12] = nArray[3] + 2048;
            }
            this.addObject(nArray);
        }
    }

    public void addObject(int[] nArray) {
        block10: {
            try {
                int n;
                if (nArray[1] == 9 || nArray[1] == 15 || nArray[1] == 48 || nArray[1] == 11 || nArray[1] == 2 || nArray[1] == 79 || 0 == nArray[1] || 1 == nArray[1] || 63 == nArray[1] || 64 == nArray[1] || 65 == nArray[1] || 66 == nArray[1] || 67 == nArray[1] || 68 == nArray[1] || 69 == nArray[1]) {
                    for (int i = ObjectList.length - 1; i > 0; --i) {
                        if (ObjectList[i][24] != 0) continue;
                        MainCanvas.ObjectList[i] = nArray;
                        MainCanvas.ObjectList[i][24] = 1;
                        if (this.noDataPointer != i) {
                            ++ObjectListNum;
                            break block10;
                        }
                        ++ObjectListNum;
                        for (i = 0; i < ObjectList.length; ++i) {
                            if (ObjectList[i][24] != 0) continue;
                            this.noDataPointer = i;
                            break block10;
                        }
                        break block10;
                    }
                    break block10;
                }
                if (ObjectList[this.noDataPointer][24] == 0) {
                    MainCanvas.ObjectList[this.noDataPointer] = nArray;
                    MainCanvas.ObjectList[this.noDataPointer][24] = 1;
                    ++ObjectListNum;
                    for (int i = 0; i < ObjectList.length; ++i) {
                        if (ObjectList[i][24] != 0) continue;
                        this.noDataPointer = i;
                        break block10;
                    }
                    break block10;
                }
                for (n = 0; n < ObjectList.length; ++n) {
                    if (ObjectList[n][24] != 0) continue;
                    this.noDataPointer = n;
                    break;
                }
                MainCanvas.ObjectList[this.noDataPointer] = nArray;
                MainCanvas.ObjectList[this.noDataPointer][24] = 1;
                ++ObjectListNum;
                for (n = 0; n < ObjectList.length; ++n) {
                    if (ObjectList[n][24] != 0) continue;
                    this.noDataPointer = n;
                    break;
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    public boolean removeObjectChk(int[] nArray) {
        if (nArray[2] - mapOxy[0] < this.LSize) {
            return true;
        }
        return nArray[2] - mapOxy[0] > this.RSize;
    }

    public boolean removeObjectChkDead(int[] nArray) {
        return nArray[0] <= 0;
    }

    public void removeObject(int n) {
        this.noDataPointer = n;
        MainCanvas.ObjectList[n][24] = 0;
        --this.listSub;
    }

    public void InsertObject(int[] nArray, int n) {
        MainCanvas.ObjectList[n] = nArray;
    }

    public int[][] searchObject(int n, int n2) {
        this.objCount = 0;
        int n3 = 0;
        for (int i = 0; i < ObjectList.length && n3 < ObjectListNum; ++i) {
            if (ObjectList[i][24] != 1) continue;
            ++n3;
            if (ObjectList[i][1] != n || n2 >= 0 && n2 != ObjectList[i][4]) continue;
            this.objTempData[this.objCount] = ObjectList[i];
            this.objTempData[this.objCount][23] = i;
            ++this.objCount;
        }
        int[][] nArray = new int[this.objCount][25];
        System.arraycopy(this.objTempData, 0, nArray, 0, nArray.length);
        return nArray;
    }

    public void objectAction() {
        this.listSub = 0;
        int n = 0;
        for (int i = 0; i < ObjectList.length && n < ObjectListNum; ++i) {
            if (ObjectList[i][24] != 1) continue;
            ++n;
            objectData = ObjectList[i];
            this.CallObjectMove(0);
            MainCanvas.ObjectList[i] = objectData;
            if (objectData[1] == 17 && objectData[4] == 55) continue;
            if (objectData[0] <= 0 && objectData[21] == 0) {
                MainCanvas.ObjectDead[MainCanvas.objectData[20]] = true;
                MainCanvas.ObjectAct[MainCanvas.objectData[20]] = false;
                this.removeObject(i);
                continue;
            }
            if (!ObjectAct[objectData[20]] && objectData[1] < 120 && objectData[1] != 42 && objectData[1] != 43) {
                this.removeObject(i);
                continue;
            }
            if (!this.removeObjectChk(objectData) || objectData[21] != 0 || objectData[1] >= 120 || objectData[1] == 42 || objectData[1] == 43) continue;
            MainCanvas.ObjectAct[MainCanvas.objectData[20]] = false;
            MainCanvas.ObjectAct[MainCanvas.objectData[22]] = false;
            this.removeObject(i);
        }
        ObjectListNum += this.listSub;
    }

    public void CallObjectDraw() {
        try {
            int n = 0;
            for (int i = ObjectList.length - 1; i >= 0 && n < ObjectListNum; --i) {
                if (ObjectList[i][24] != 1) continue;
                ++n;
                if (ObjectList[i][1] == 45 || ObjectList[i][1] == 45 || ObjectList[i][1] == 26 || ObjectList[i][1] == 53 || ObjectList[i][1] == 10 || ObjectList[i][1] == 88 && ObjectList[i][4] == 127) continue;
                objectData = ObjectList[i];
                this.CallObjectDraw(0);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void CallObjectDrawFront() {
        try {
            int n = 0;
            for (int i = ObjectList.length - 1; i >= 0 && n < ObjectListNum; --i) {
                if (ObjectList[i][24] != 1) continue;
                ++n;
                if (ObjectList[i][1] != 45 && ObjectList[i][1] != 45 && ObjectList[i][1] != 26 && ObjectList[i][1] != 53 && ObjectList[i][1] != 10 && (ObjectList[i][1] != 88 || ObjectList[i][4] != 127)) continue;
                objectData = ObjectList[i];
                this.CallObjectDraw(0);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void loopchange() {
        if (noloopchecktimer-- > 0) {
            return;
        }
        boolean bl = false;
        if (ploldpos[0] >> 8 < this.PlayerPosX() >> 8) {
            if (this.zoneNumber == 0 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 54)) {
                MainCanvas.tempWorldMapData[(this.PlayerPosY() >> 8) % MainCanvas.MapH][this.PlayerPosX() >> 8] = 53;
            }
            if (this.zoneNumber == 3) {
                if (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 42 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 43) {
                    MainCanvas.tempWorldMapData[(this.PlayerPosY() >> 8) % MainCanvas.MapH][this.PlayerPosX() >> 8] = 42;
                }
                if (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 52 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53) {
                    MainCanvas.tempWorldMapData[(this.PlayerPosY() >> 8) % MainCanvas.MapH][this.PlayerPosX() >> 8] = 52;
                }
            }
        }
        if (ploldpos[0] >> 8 > this.PlayerPosX() >> 8) {
            if (this.zoneNumber == 0 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 54)) {
                MainCanvas.tempWorldMapData[(this.PlayerPosY() >> 8) % MainCanvas.MapH][this.PlayerPosX() >> 8] = 54;
            }
            if (this.zoneNumber == 3) {
                if (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 42 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 43) {
                    MainCanvas.tempWorldMapData[(this.PlayerPosY() >> 8) % MainCanvas.MapH][this.PlayerPosX() >> 8] = 43;
                }
                if (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 52 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53) {
                    MainCanvas.tempWorldMapData[(this.PlayerPosY() >> 8) % MainCanvas.MapH][this.PlayerPosX() >> 8] = 53;
                }
            }
        }
        if (this.zoneNumber == 3 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 52 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53) && PlayerJump) {
            MainCanvas.tempWorldMapData[(this.PlayerPosY() >> 8) % MainCanvas.MapH][this.PlayerPosX() >> 8] = 52;
        }
        int n = tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] & 1;
        if (this.zoneNumber == 0 && (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 54)) {
            bl = true;
        }
        if (this.zoneNumber == 3) {
            if (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 42 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 43) {
                bl = true;
                ++n;
            }
            if (tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 52 || tempWorldMapData[(this.PlayerPosY() >> 8) % MapH][this.PlayerPosX() >> 8] == 53) {
                bl = true;
                ++n;
            }
        }
        if (!bl) {
            return;
        }
        if (this.blockColChk(this.PlayerPosX(), this.PlayerPosY())) {
            if (n % 2 == 1 && this.PlayerPosX() / 16 % 16 < 9 && this.PlayerPosY() / 16 % 16 < 3) {
                byte[] byArray = tempWorldMapData[(this.PlayerPosY() >> 8) % MapH];
                int n2 = this.PlayerPosX() >> 8;
                byArray[n2] = (byte)(byArray[n2] + 1);
                noloopchecktimer = 60;
            } else if (n % 2 == 0 && this.PlayerPosX() / 16 % 16 >= 7 && this.PlayerPosY() / 16 % 16 < 3) {
                byte[] byArray = tempWorldMapData[(this.PlayerPosY() >> 8) % MapH];
                int n3 = this.PlayerPosX() >> 8;
                byArray[n3] = (byte)(byArray[n3] - 1);
                noloopchecktimer = 60;
            }
        }
    }

    public void waterMove() {
        if (this.waterH3 == 0) {
            this.waterH3 = this.waterH;
        }
        if (this.waterH3 < this.waterH) {
            ++this.waterH3;
            if (this.waterH3 > this.waterH) {
                this.waterH3 = this.waterH;
            }
        } else if (this.waterH3 > this.waterH) {
            --this.waterH3;
            if (this.waterH3 < this.waterH) {
                this.waterH3 = this.waterH;
            }
        }
        this.waterH2 = this.waterH3 + this.dSin(this.cpuTimer) * 8 / 100 + 8;
        if (this.zoneNumber != 1) {
            this.waterH = 0xFFFFFF;
            return;
        }
        switch (this.stageNumber) {
            case 0: {
                if (this.water_flag != 0) {
                    if (this.water_flag - 1 != 0 || 736 <= this.PlayerPosY()) break;
                    this.waterH = 936;
                    if (4864 > mapOxy[0]) break;
                    this.waterH = 264;
                    this.water_flag = (byte)2;
                    this.waterH = 264;
                    break;
                }
                this.waterH = 184;
                if (1536 > mapOxy[0]) break;
                this.waterH = 264;
                if (512 > this.PlayerPosY()) {
                    if (3200 > mapOxy[0]) break;
                    this.waterH = 232;
                    if (5376 > mapOxy[0]) break;
                    this.waterH = 264;
                    break;
                }
                if (3072 > mapOxy[0]) break;
                this.waterH = 792;
                if (4224 > mapOxy[0]) break;
                this.waterH = 1480;
                if (4992 > mapOxy[0]) break;
                this.waterH = 936;
                if (this.waterH != this.waterH3) break;
                this.water_flag = 1;
                break;
            }
            case 1: {
                this.waterH = 808;
                if (1280 > mapOxy[0]) break;
                this.waterH = 968;
                if (2816 > mapOxy[0]) break;
                this.waterH = 1064;
                break;
            }
            case 2: {
                int n = mapOxy[0];
                int n2 = this.water_flag;
                if (this.water_flag != 0) {
                    if (--n2 != 0) {
                        if (--n2 != 0) {
                            if (--n2 != 0) {
                                if (7680 > n) break;
                                this.waterH = 296;
                                break;
                            }
                            int n3 = 392;
                            if (6896 > n && mapOxy[1] < 2001 || 6260 > n) {
                                if (6868 <= n && mapOxy[1] > 1280) {
                                    n3 = 2304;
                                }
                                this.waterH = n3;
                                this.waterH3 = n3;
                                break;
                            }
                            n3 = 2304;
                            if (7147 > n) {
                                this.waterH = n3;
                                this.waterH3 = n3;
                                break;
                            }
                            this.water_flag = (byte)4;
                            this.waterH = 1544;
                            this.waterH3 = 1920;
                            break;
                        }
                        int n4 = 1288;
                        if (6240 > n) {
                            this.waterH = n4;
                            break;
                        }
                        n4 = 392;
                        if (6896 <= n) {
                            this.water_flag = (byte)3;
                            this.waterH = n4;
                            break;
                        }
                        if (this.waterH3 != n4) {
                            this.waterH = n4;
                            break;
                        }
                        this.water_flag = (byte)3;
                        this.waterH = n4;
                        break;
                    }
                    int n5 = 1224;
                    if (1936 > n) {
                        this.waterH = n5;
                        break;
                    }
                    n5 = 776;
                    if (5120 > n) {
                        this.waterH = n5;
                        break;
                    }
                    if (this.waterH == 1288) {
                        this.waterH3 = n5 = 1288;
                        if (6000 > n) {
                            this.waterH = n5;
                            break;
                        }
                        this.water_flag = (byte)2;
                        this.waterH = n5;
                        break;
                    }
                    if (1536 <= this.PlayerPosY()) {
                        this.waterH3 = n5 = 1288;
                        if (6000 > n) {
                            this.waterH = n5;
                            break;
                        }
                        this.water_flag = (byte)2;
                        this.waterH = n5;
                        break;
                    }
                    if (640 <= this.PlayerPosY()) {
                        this.waterH = n5;
                        break;
                    }
                    this.waterH3 = n5 = 1288;
                    if (6000 > n) {
                        this.waterH = n5;
                        break;
                    }
                    this.water_flag = (byte)2;
                    this.waterH = n5;
                    break;
                }
                int n6 = 2304;
                if (1696 > n) {
                    this.waterH = n6;
                    this.waterH3 = n6;
                    break;
                }
                if (992 > this.PlayerPosY()) {
                    this.waterH = n6;
                    this.waterH3 = n6;
                    break;
                }
                if (1536 <= this.PlayerPosY()) {
                    this.waterH = n6;
                    this.waterH3 = n6;
                    break;
                }
                n6 = 1224;
                this.water_flag = 1;
                this.waterH = n6;
                this.waterH3 = n6;
                break;
            }
            case 3: {
                int n = 552;
                this.waterH = 3840 > mapOxy[0] ? n : (n = 1224);
            }
        }
    }

    public void pata_draw(int n) {
        if (objectData[4] == 1 || objectData[4] == 2) {
            if (this.cpuTimer / 30 / 4 % 2 == 0) {
                this.drawImage(gg, this.m_imgObj[PATA], objectData[2] - mapView[0] - this.m_imgObj[PATA].getWidth(), objectData[3] - mapView[1] - this.m_imgObj[PATA].getHeight() / 2, 20);
                this.drawImage(gg, this.m_imgObj[PATA], objectData[2] - mapView[0], objectData[3] - mapView[1] - this.m_imgObj[PATA].getHeight() / 2, 20);
            } else {
                this.drawRegion(gg, this.m_imgObj[PATA], 0, 0, 64, 24, rotNumTable[TRANS_ROT90], objectData[2] - mapView[0] - this.m_imgObj[PATA].getWidth() - 12, objectData[3] - mapView[1], 20);
                this.drawRegion(gg, this.m_imgObj[PATA], 0, 0, 64, 24, rotNumTable[TRANS_ROT90], objectData[2] - mapView[0] + this.m_imgObj[PATA].getWidth() - 12, objectData[3] - mapView[1], 20);
            }
        }
    }

    public void drawRegion(Graphics graphics, Image image, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        try {
            graphics.drawRegion(image, n, n2, n3, n4, n5, n6, n7 += 36, n8);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void drawImage(Graphics graphics, Image image, int n, int n2, int n3) {
        try {
            graphics.drawImage(image, n, n2 += 36, n3);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public Image createImage(String string) {
        try {
            System.gc();
            if (drawRsm) {
                this.DG();
            }
            return Image.createImage((String)string);
        }
        catch (Exception exception) {
            return this.createImage(string);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public void getItem(int n) {
        if (n == 2) {
            ++playercount;
            this.PlayMusic(13);
        } else if (n == 3) {
            speedupcount = 1200;
            plmaxspd = 3072;
            pladdspd = 24;
        } else if (n == 4) {
            bariacount = 1;
        } else if (n == 5) {
            mutekicount = 1200;
            this.PlayMusic(12);
        } else if (n == 6) {
            ringcount += 10;
        }
    }

    public void CallObjectMove(int n) {
        try {
            switch (objectData[1]) {
                case 0: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 8, -1) && objectData[5] == 0) break;
                    this.ring_sflag_ring_18_00_move_ikeshita(n);
                    break;
                }
                case 1: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 8, -1) && objectData[5] == 0) break;
                    this.ring_sflag_ring_00_18_move_ikeshita(n);
                    break;
                }
                case 2: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 16, 16)) break;
                    this.sjump_nflag_move_sakaki(n);
                    break;
                }
                case 3: {
                    this.buranko_nflag_move_ikeshita(n);
                    break;
                }
                case 5: {
                    this.hashi_nflag_move_ikeshita(n);
                    break;
                }
                case 4: {
                    this.thashi_nflag_move_ikeshita(n);
                    break;
                }
                case 6: {
                    this.break_sflag_move_ikeshita(n);
                    break;
                }
                case 7: {
                    this.yuka_nflag_move_ikeshita(n);
                    break;
                }
                case 8: {
                    this.turi_nflag_move_ikeshita(n);
                    break;
                }
                case 9: {
                    this.toge_nflag_move_ikeshita(n);
                    break;
                }
                case 10: {
                    this.box_sflag_move_ikeshita(n);
                    break;
                }
                case 11: {
                    this.fblock_nflag_move_ikeshita(n);
                    break;
                }
                case 54: {
                    this.dainfla_move_ikeshita(n);
                    break;
                }
                case 13: {
                    this.yogan2_sflag_move_ikeshita(n);
                    break;
                }
                case 14: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 32, -1)) break;
                    this.myogan_nflag_move_ikeshita(n);
                    break;
                }
                case 15: {
                    this.switch2_nflag_move_ikeshita(n);
                    break;
                }
                case 16: {
                    this.shima_nflag_move_ikeshita(n);
                    break;
                }
                case 17: {
                    this.dai2_nflag_move_ikeshita(n);
                    break;
                }
                case 18: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 16, 32)) break;
                    this.brkabe_sflag_move_ikeshita(n);
                    break;
                }
                case 19: {
                    this.pedal_nflag_move_ikeshita(n);
                    break;
                }
                case 20: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 16, -1)) break;
                    this.break2_nflag_move_ikeshita(n);
                    break;
                }
                case 21: {
                    this.step_nflag_move_ikeshita(n);
                    break;
                }
                case 22: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 96, 64)) break;
                    this.fun_nflag_move_ikeshita(n);
                    break;
                }
                case 23: {
                    this.sisoo_nflag_move_arai(n);
                    break;
                }
                case 24: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 128, 16)) break;
                    this.belt_nflag_move_ikeshita(n);
                    break;
                }
                case 25: {
                    this.pata_nflag_move_ikeshita(n);
                    break;
                }
                case 26: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 32, 100)) break;
                    this.fire6_nflag_move_ikeshita(n);
                    break;
                }
                case 27: {
                    this.bryuka_nflag_move_ikeshita(n);
                    break;
                }
                case 28: {
                    this.mawaru_nflag_move_ikeshita(n);
                    break;
                }
                case 29: {
                    this.yukai_nflag_move_ikeshita(n);
                    break;
                }
                case 30: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 32, 64)) break;
                    this.door_nflag_move_ikeshita(n);
                    break;
                }
                case 31: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 32, 32)) break;
                    this.yukae_nflag_move_ikeshita(n);
                    break;
                }
                case 32: {
                    this.dai4_nflag_move_ikeshita(n);
                    break;
                }
                case 33: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 32, 16)) break;
                    this.ele_nflag_move_ikeshita(n);
                    break;
                }
                case 34: {
                    this.beltc_nflag_move_ikeshita(n);
                    break;
                }
                case 35: {
                    this.noko_nflag_move_ikeshita(n);
                    break;
                }
                case 36: {
                    this.save_sflag_move_ikeshita(n);
                    break;
                }
                case 37: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 8, 32)) break;
                    this.kageb_nflag_move_ikeshita(n);
                    break;
                }
                case 38: {
                    break;
                }
                case 39: {
                    this.kamere_sflag_move_arai(n);
                    break;
                }
                case 40: {
                    this.hachi_sflag_move_arai(n);
                    break;
                }
                case 41: {
                    this.musi_sflag_move_arai(n);
                    break;
                }
                case 42: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 16, 16)) break;
                    this.item_nflag_move_ikeshita(n);
                    break;
                }
                case 43: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 16, 16)) break;
                    this.item_sflag_move_ikeshita(n);
                    break;
                }
                case 44: {
                    this.gole_nflag_move_ikeshita(n);
                    break;
                }
                case 45: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 32, 32)) break;
                    this.bten_nflag_move_ikeshita(n);
                    break;
                }
                case 46: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 32, 32)) break;
                    this.bten_sflag_move_ikeshita(n);
                    break;
                }
                case 47: {
                    break;
                }
                case 48: {
                    this.scoli_nflag_move_ikeshita(n);
                    break;
                }
                case 49: {
                    this.imo_sflag_move_arai(n);
                    break;
                }
                case 50: {
                    this.brobo_sflag_move_arai(n);
                    break;
                }
                case 51: {
                    this.buta_sflag_move_arai(n);
                    break;
                }
                case 52: {
                    break;
                }
                case 53: {
                    this.shooter_nflag_move_ikeshita(n);
                    break;
                }
                case 12: {
                    break;
                }
                case 55: {
                    this.masin_nflag_move_ikeshita(n);
                    break;
                }
                case 56: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 32, 32)) break;
                    this.bobin_sflag_move_ikeshita(n);
                    break;
                }
                case 57: {
                    this.kani_sflag_move_arai(n);
                    break;
                }
                case 58: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 24, 24)) break;
                    this.jyama_nflag_move_ikeshita(n);
                    break;
                }
                case 59: {
                    this.fetama_nflag_move_ikeshita(n);
                    break;
                }
                case 60: {
                    this.tekyu_nflag_move_ikeshita(n);
                    break;
                }
                case 61: {
                    break;
                }
                case 62: {
                    this.dai2_sflag_move_ikeshita(n);
                    break;
                }
                case 63: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 8, -1) && objectData[5] == 0) break;
                    this.ring_sflag_ring_m10_10_move_ikeshita(n);
                    break;
                }
                case 64: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 8, -1) && objectData[5] == 0) break;
                    this.ring_sflag_ring_10_10_move_ikeshita(n);
                    break;
                }
                case 65: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 8, -1) && objectData[5] == 0) break;
                    this.ring_sflag_ring_20_20_move_ikeshita(n);
                    break;
                }
                case 66: {
                    this.ring_sflag_ring_10_00_move_ikeshita(n);
                    break;
                }
                case 67: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 8, -1) && objectData[5] == 0) break;
                    this.ring_sflag_ring_20_00_move_ikeshita(n);
                    break;
                }
                case 68: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 8, -1) && objectData[5] == 0) break;
                    this.ring_sflag_ring_00_10_move_ikeshita(n);
                    break;
                }
                case 69: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 8, -1) && objectData[5] == 0) break;
                    this.ring_sflag_ring_00_20_move_ikeshita(n);
                    break;
                }
                case 70: {
                    this.aruma_sflag_move_arai(n);
                    break;
                }
                case 71: {
                    this.yado_sflag_move_arai(n);
                    break;
                }
                case 72: {
                    this.elev_nflag_80_move_ikeshita(n);
                    break;
                }
                case 73: {
                    this.elev_nflag_move_ikeshita(n);
                    break;
                }
                case 74: {
                    this.uni_sflag_move_arai(n);
                    break;
                }
                case 75: {
                    this.mfire_nflag_move_ikeshita(n);
                    break;
                }
                case 76: {
                    break;
                }
                case 77: {
                    this.yoganc_nflag_move_ikeshita(n);
                    break;
                }
                case 78: {
                    this.bat_sflag_move_arai(n);
                    break;
                }
                case 79: {
                    this.ochi_nflag_move_ikeshita(n);
                    break;
                }
                case 80: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 24, 24)) break;
                    this.yari_sflag_move_ikeshita(n);
                    break;
                }
                case 81: {
                    this.mogura_sflag_move_arai(n);
                    break;
                }
                case 82: {
                    this.kazari_sflag_move_ikeshita(n);
                    break;
                }
                case 83: {
                    this.dai3_nflag_move_ikeshita(n);
                    break;
                }
                case 84: {
                    this.mizu_nflag_move_sakaki(n);
                    break;
                }
                case 85: {
                    this.awa_nflag_move_sakaki(n);
                    break;
                }
                case 86: {
                    this.fish_sflag_move_arai(n);
                    break;
                }
                case 87: {
                    this.fish2_sflag_move_arai(n);
                    break;
                }
                case 88: {
                    this.kassya_nflag_move_ikeshita(n);
                    break;
                }
                case 89: {
                    break;
                }
                case 90: {
                    this.shima2_nflag_move_ikeshita(n);
                    break;
                }
                case 91: {
                    if (!this.ObjectMoveChk(objectData[2], objectData[3], 32, 42)) break;
                    this.bou_nflag_move_ikeshita(n);
                    break;
                }
                case 92: {
                    this.ben_nflag_move_sakaki(n);
                    break;
                }
                case 93: {
                    this.ben_sflag_move_sakaki(n);
                    break;
                }
                case 120: {
                    this.boss1_move_arai(n);
                    break;
                }
                case 125: {
                    this.boss2_move_arai(n);
                    break;
                }
                case 130: {
                    this.boss3_move_arai(n);
                    break;
                }
                case 135: {
                    this.boss4_move_arai(n);
                    break;
                }
                case 140: {
                    this.boss5_move_arai(n);
                    break;
                }
                case 145: {
                    this.boss6_move_arai(n);
                    break;
                }
                case 150: {
                    this.MoveBoss5Block(n);
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void CallObjectDraw(int n) {
        try {
            switch (objectData[1]) {
                case 0: {
                    this.ring_sflag_ring_18_00_draw_ikeshita(n);
                    break;
                }
                case 1: {
                    this.ring_sflag_ring_00_18_draw_ikeshita(n);
                    break;
                }
                case 2: {
                    this.sjump_nflag_draw_sakaki(n);
                    break;
                }
                case 3: {
                    this.buranko_nflag_draw_ikeshita(n);
                    break;
                }
                case 5: {
                    this.hashi_nflag_draw_ikeshita(n);
                    break;
                }
                case 4: {
                    this.thashi_nflag_draw_ikeshita(n);
                    break;
                }
                case 6: {
                    this.break_sflag_draw_ikeshita(n);
                    break;
                }
                case 7: {
                    this.yuka_nflag_draw_ikeshita(n);
                    break;
                }
                case 8: {
                    this.turi_nflag_draw_ikeshita(n);
                    break;
                }
                case 9: {
                    this.toge_nflag_draw_ikeshita(n);
                    break;
                }
                case 10: {
                    this.box_sflag_draw_ikeshita(n);
                    break;
                }
                case 11: {
                    this.fblock_nflag_draw_ikeshita(n);
                    break;
                }
                case 54: {
                    this.dainfla_draw_ikeshita(n);
                    break;
                }
                case 13: {
                    this.yogan2_sflag_draw_ikeshita(n);
                    break;
                }
                case 14: {
                    this.myogan_nflag_draw_ikeshita(n);
                    break;
                }
                case 15: {
                    this.switch2_nflag_draw_ikeshita(n);
                    break;
                }
                case 16: {
                    this.shima_nflag_draw_ikeshita(n);
                    break;
                }
                case 17: {
                    this.dai2_nflag_draw_ikeshita(n);
                    break;
                }
                case 18: {
                    this.brkabe_sflag_draw_ikeshita(n);
                    break;
                }
                case 19: {
                    this.pedal_nflag_draw_ikeshita(n);
                    break;
                }
                case 20: {
                    this.break2_nflag_draw_ikeshita(n);
                    break;
                }
                case 21: {
                    this.step_nflag_draw_ikeshita(n);
                    break;
                }
                case 22: {
                    this.fun_nflag_draw_ikeshita(n);
                    break;
                }
                case 23: {
                    this.sisoo_nflag_draw_arai(n);
                    break;
                }
                case 24: {
                    break;
                }
                case 25: {
                    this.pata_nflag_draw_ikeshita(n);
                    break;
                }
                case 26: {
                    this.fire6_nflag_draw_ikeshita(n);
                    break;
                }
                case 27: {
                    this.bryuka_nflag_draw_ikeshita(n);
                    break;
                }
                case 28: {
                    this.mawaru_nflag_draw_ikeshita(n);
                    break;
                }
                case 29: {
                    this.yukai_nflag_draw_ikeshita(n);
                    break;
                }
                case 30: {
                    this.door_nflag_draw_ikeshita(n);
                    break;
                }
                case 31: {
                    this.yukae_nflag_draw_ikeshita(n);
                    break;
                }
                case 32: {
                    this.dai4_nflag_draw_ikeshita(n);
                    break;
                }
                case 33: {
                    this.ele_nflag_draw_ikeshita(n);
                    break;
                }
                case 34: {
                    this.beltc_nflag_draw_ikeshita(n);
                    break;
                }
                case 35: {
                    this.noko_nflag_draw_ikeshita(n);
                    break;
                }
                case 36: {
                    this.save_sflag_draw_ikeshita(n);
                    break;
                }
                case 37: {
                    this.kageb_nflag_draw_ikeshita(n);
                    break;
                }
                case 38: {
                    this.bgspr_nflag_draw_sakaki(n);
                    break;
                }
                case 39: {
                    this.kamere_sflag_draw_arai(n);
                    break;
                }
                case 40: {
                    this.hachi_sflag_draw_arai(n);
                    break;
                }
                case 41: {
                    this.musi_sflag_draw_arai(n);
                    break;
                }
                case 42: {
                    this.item_nflag_draw_ikeshita(n);
                    break;
                }
                case 43: {
                    this.item_sflag_draw_ikeshita(n);
                    break;
                }
                case 44: {
                    this.gole_nflag_draw_ikeshita(n);
                    break;
                }
                case 45: {
                    this.bten_nflag_draw_ikeshita(n);
                    break;
                }
                case 46: {
                    this.bten_sflag_draw_ikeshita(n);
                    break;
                }
                case 47: {
                    break;
                }
                case 48: {
                    break;
                }
                case 49: {
                    this.imo_sflag_draw_arai(n);
                    break;
                }
                case 50: {
                    this.brobo_sflag_draw_arai(n);
                    break;
                }
                case 51: {
                    this.buta_sflag_draw_arai(n);
                    break;
                }
                case 52: {
                    break;
                }
                case 53: {
                    break;
                }
                case 12: {
                    break;
                }
                case 55: {
                    this.masin_nflag_draw_ikeshita(n);
                    break;
                }
                case 56: {
                    this.bobin_sflag_draw_ikeshita(n);
                    break;
                }
                case 57: {
                    this.kani_sflag_draw_arai(n);
                    break;
                }
                case 58: {
                    this.jyama_nflag_draw_ikeshita(n);
                    break;
                }
                case 59: {
                    this.fetama_nflag_draw_ikeshita(n);
                    break;
                }
                case 60: {
                    this.tekyu_nflag_draw_ikeshita(n);
                    break;
                }
                case 61: {
                    this.signal_nflag_draw_sakaki(n);
                    break;
                }
                case 62: {
                    this.dai2_sflag_draw_ikeshita(n);
                    break;
                }
                case 63: {
                    this.ring_sflag_ring_m10_10_draw_ikeshita(n);
                    break;
                }
                case 64: {
                    this.ring_sflag_ring_10_10_draw_ikeshita(n);
                    break;
                }
                case 65: {
                    this.ring_sflag_ring_20_20_draw_ikeshita(n);
                    break;
                }
                case 66: {
                    this.ring_sflag_ring_10_00_draw_ikeshita(n);
                    break;
                }
                case 67: {
                    this.ring_sflag_ring_20_00_draw_ikeshita(n);
                    break;
                }
                case 68: {
                    this.ring_sflag_ring_00_10_draw_ikeshita(n);
                    break;
                }
                case 69: {
                    this.ring_sflag_ring_00_20_draw_ikeshita(n);
                    break;
                }
                case 70: {
                    this.aruma_sflag_draw_arai(n);
                    break;
                }
                case 71: {
                    this.yado_sflag_draw_arai(n);
                    break;
                }
                case 72: {
                    this.elev_nflag_80_draw_ikeshita(n);
                    break;
                }
                case 73: {
                    this.elev_nflag_draw_ikeshita(n);
                    break;
                }
                case 74: {
                    this.uni_sflag_draw_arai(n);
                    break;
                }
                case 75: {
                    this.mfire_nflag_draw_ikeshita(n);
                    break;
                }
                case 76: {
                    break;
                }
                case 77: {
                    this.yoganc_nflag_draw_ikeshita(n);
                    break;
                }
                case 78: {
                    this.bat_sflag_draw_arai(n);
                    break;
                }
                case 79: {
                    this.ochi_nflag_draw_ikeshita(n);
                    break;
                }
                case 80: {
                    this.yari_sflag_draw_ikeshita(n);
                    break;
                }
                case 81: {
                    this.mogura_sflag_draw_arai(n);
                    break;
                }
                case 82: {
                    this.kazari_sflag_draw_ikeshita(n);
                    break;
                }
                case 83: {
                    this.dai3_nflag_draw_ikeshita(n);
                    break;
                }
                case 84: {
                    this.mizu_nflag_draw_sakaki(n);
                    break;
                }
                case 85: {
                    this.awa_nflag_draw_sakaki(n);
                    break;
                }
                case 86: {
                    this.fish_sflag_draw_arai(n);
                    break;
                }
                case 87: {
                    this.fish2_sflag_draw_arai(n);
                    break;
                }
                case 88: {
                    this.kassya_nflag_draw_ikeshita(n);
                    break;
                }
                case 89: {
                    break;
                }
                case 90: {
                    this.shima2_nflag_draw_ikeshita(n);
                    break;
                }
                case 91: {
                    this.bou_nflag_draw_ikeshita(n);
                    break;
                }
                case 92: {
                    this.ben_nflag_draw_sakaki(n);
                    break;
                }
                case 93: {
                    this.ben_sflag_draw_sakaki(n);
                    break;
                }
                case 120: {
                    this.boss1_draw_arai(n);
                    break;
                }
                case 125: {
                    this.boss2_draw_arai(n);
                    break;
                }
                case 130: {
                    this.boss3_draw_arai(n);
                    break;
                }
                case 135: {
                    this.boss4_draw_arai(n);
                    break;
                }
                case 140: {
                    this.boss5_draw_arai(n);
                    break;
                }
                case 145: {
                    this.boss6_draw_arai(n);
                    break;
                }
                case 150: {
                    this.DrawBoss5Block(false);
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public int ObjectColChk(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        if (PlayerDie || PlayerNoCol || debugFlag) {
            return -1;
        }
        if (n4 + n6 <= n10 - n12 && n2 + n6 >= n8 - n12 && n + n5 >= n7 - n11 && n - n5 <= n7 + n11) {
            if (n + n5 > n7 - n11 && n - n5 < n7 + n11) {
                return 0;
            }
            return -1;
        }
        if (n3 + n5 <= n9 - n11 && n + n5 >= n7 - n11 && n2 + n6 >= n8 - n12 && n2 - n6 <= n8 + n12) {
            return 1;
        }
        if (n3 - n5 >= n9 + n11 && n - n5 <= n7 + n11 && n2 + n6 >= n8 - n12 && n2 - n6 <= n8 + n12) {
            return 2;
        }
        if (n4 - n6 >= n10 + n12 && n2 - n6 <= n8 + n12 && n + n5 >= n7 - n11 && n - n5 <= n7 + n11) {
            return 3;
        }
        if (n + n5 >= n7 - n11 && n - n5 <= n7 + n11 && n2 + n6 >= n8 - n12 && n2 - n6 <= n8 + n12) {
            return 4;
        }
        return -1;
    }

    private void setRaidOnSize(int n, int n2) {
        raidObjectW = n2;
        raidObjectX = n;
    }

    private void setHeadHit() {
        this.crushing[3] = true;
        if (PlayerParam[5] < 0) {
            MainCanvas.PlayerParam[5] = 0;
        }
    }

    public int getPlayerH() {
        int n = 18;
        if (PlayerBall) {
            n = 12;
        }
        return n;
    }

    public int ObjectColChk2(int n, int n2, int n3, int n4, int n5, int n6) {
        if (PlayerDie || PlayerNoCol || debugFlag) {
            return -1;
        }
        int n7 = (540 - olddir) % 360;
        if (0 > n7) {
            n7 = 0;
        }
        int n8 = 12;
        if (!PlayerBall && !PlayerCrouch) {
            n8 = 18;
        }
        int n9 = this.dSin(n7) * n8 / 100;
        int n10 = -this.dCos(n7) * n8 / 100;
        int n11 = this.PlayerPosX() + n9;
        int n12 = this.PlayerPosY() + n10;
        int n13 = ploldpos[0] + n9;
        int n14 = ploldpos[1] + n10;
        int n15 = 12;
        int n16 = n8;
        if (n14 + n16 <= n4 - n6 && n12 + n16 >= n2 - n6 && n11 + n15 >= n - n5 && n11 - n15 <= n + n5) {
            return 0;
        }
        if (n13 + n15 <= n3 - n5 && n11 + n15 >= n - n5 && n12 + n16 >= n2 - n6 && n12 - n16 <= n2 + n6) {
            return 1;
        }
        if (n13 - n15 >= n3 + n5 && n11 - n15 <= n + n5 && n12 + n16 >= n2 - n6 && n12 - n16 <= n2 + n6) {
            return 2;
        }
        if (n14 - n16 >= n4 + n6 && n12 - n16 <= n2 + n6 && n11 + n15 >= n - n5 && n11 - n15 <= n + n5) {
            return 3;
        }
        if (n11 + n15 >= n - n5 && n11 - n15 <= n + n5 && n12 + n16 >= n2 - n6 && n12 - n16 <= n2 + n6) {
            return 4;
        }
        return -1;
    }

    public int ObjectColChkPl(int n, int n2, int n3, int n4, int n5, int n6) {
        if (PlayerDie || PlayerNoCol || debugFlag) {
            return -1;
        }
        int n7 = 12;
        if (!PlayerBall) {
            n7 = 16;
        }
        int n8 = 0;
        int n9 = -n7;
        int n10 = this.PlayerPosX() + n8;
        int n11 = this.PlayerPosY() + n9;
        int n12 = ploldpos[0] + n8;
        int n13 = ploldpos[1] + n9;
        int n14 = 12;
        int n15 = n7;
        if (n13 + n15 <= n4 - n6 && n11 + n15 >= n2 - n6 && n10 + n14 >= n - n5 && n10 - n14 <= n + n5) {
            return 0;
        }
        if (n12 + n14 <= n3 - n5 && n10 + n14 >= n - n5 && n11 + n15 >= n2 - n6 && n11 - n15 <= n2 + n6) {
            return 1;
        }
        if (n12 - n14 >= n3 + n5 && n10 - n14 <= n + n5 && n11 + n15 >= n2 - n6 && n11 - n15 <= n2 + n6) {
            return 2;
        }
        if (n13 - n15 >= n4 + n6 && n11 - n15 <= n2 + n6 && n10 + n14 >= n - n5 && n10 - n14 <= n + n5) {
            return 3;
        }
        if (n10 + n14 >= n - n5 && n10 - n14 <= n + n5 && n11 + n15 >= n2 - n6 && n11 - n15 <= n2 + n6) {
            return 4;
        }
        return -1;
    }

    public void sjump_nflag_move_sakaki(int n) {
        int n2;
        int n3 = 16;
        int n4 = 8;
        if (objectData[4] == 16 || objectData[4] == 18) {
            n3 = 8;
            n4 = 16;
        }
        boolean bl = false;
        if (objectData[5] > 0) {
            objectData[5] = objectData[5] + 1;
            if (objectData[5] > 12) {
                MainCanvas.objectData[5] = 0;
            }
        }
        if ((n2 = this.ObjectColChkPl(objectData[2], objectData[3], objectData[2], objectData[3], n3, n4)) >= 0) {
            int n5 = 4096;
            int n6 = objectData[4] / 16;
            if (objectData[4] % 16 == 2) {
                n5 = 2560;
            }
            if (n6 == 1) {
                n3 = 7;
            } else {
                n4 = 7;
            }
            if (n2 == 0 || n2 == 4) {
                MainCanvas.PlayerParam[1] = objectData[3] - n4 << 8;
                if (n6 == 0) {
                    if (objectData[5] == 4) {
                        MainCanvas.PlayerParam[1] = objectData[3] - 8 << 8;
                        PlayerJump = true;
                        PlayerDamage = false;
                        PlayerSJump = true;
                        PlayerBall = false;
                        comboScore = 0;
                        int n7 = 0;
                        MainCanvas.PlayerParam[5] = this.dCos(n7) * n5 / 100;
                    }
                    objectData[5] = objectData[5] + 1;
                } else {
                    this.playerRaidOn(objectData[22]);
                }
            } else if (n2 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n3 - 12 - 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                if (n6 == 1 && objectData[19] == 1) {
                    this.noLeverTimer = 15;
                    MainCanvas.PlayerParam[10] = -n5;
                    MainCanvas.PlayerParam[12] = 1;
                    MainCanvas.PlayerParam[13] = 1;
                    MainCanvas.PlayerParam[14] = 1;
                    objectData[5] = objectData[5] + 1;
                }
            } else if (n2 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n3 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
                if (n6 == 1 && objectData[19] == 0) {
                    this.noLeverTimer = 15;
                    MainCanvas.PlayerParam[10] = n5;
                    MainCanvas.PlayerParam[12] = 0;
                    MainCanvas.PlayerParam[13] = 2;
                    MainCanvas.PlayerParam[14] = 2;
                    objectData[5] = objectData[5] + 1;
                }
            } else if (n2 == 3) {
                if (n6 == 2) {
                    if (objectData[19] == 2) {
                        MainCanvas.PlayerParam[5] = n5;
                        PlayerJump = true;
                        this.noLeverTimer = 30;
                    }
                    objectData[5] = objectData[5] + 1;
                }
                MainCanvas.PlayerParam[1] = objectData[3] + n4 + 12 + 12 + 1 << 8;
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n2 != 0) {
            raidOn = false;
        }
    }

    public void mizu_nflag_move_sakaki(int n) {
        int n2;
        int n3;
        int n4;
        if (objectData[4] == 8 && (n4 = this.ObjectColChkPl(objectData[2], objectData[3], objectData[2], objectData[3], n3 = 24, n2 = 8)) >= 0) {
            PlayerWater = true;
            MainCanvas.PlayerParam[12] = 0;
            MainCanvas.PlayerParam[10] = 4096;
            if (objectData[19] == 0) {
                MainCanvas.PlayerParam[12] = 1;
                MainCanvas.PlayerParam[10] = -4096;
            }
        }
        if (objectData[4] <= 6 && objectData[4] != 0 && (n4 = this.ObjectColChkPl(objectData[2], objectData[3], objectData[2], objectData[3], n3 = 8, n2 = 8)) >= 0) {
            PlayerWater = true;
        }
    }

    public void awa_nflag_move_sakaki(int n) {
        if (objectData[5] % 256 == 0) {
            MainCanvas.objectData[10] = this.rnd(4) + this.rnd(2) + this.rnd(2);
            MainCanvas.objectData[11] = 1;
            objectData[5] = objectData[5] + 1;
        }
        if (objectData[10] == 0) {
            objectData[5] = objectData[5] + 1;
        } else if (this.cpuTimer % 16 == 0 && this.rnd(3) != 0) {
            objectData[10] = objectData[10] - 1;
            if (objectData[10] > 0) {
                int n2 = 0;
                n2 = objectData[11] != 0 ? this.rnd(3) : this.rnd(2);
                this.objAwaData_set(n2, objectData[8], objectData[9]);
                if (n2 == 2) {
                    objectData[11] = objectData[11] - 1;
                }
            } else if (objectData[11] != 0) {
                objectData[11] = objectData[11] - 1;
                this.objAwaData_set(2, objectData[8], objectData[9]);
            } else {
                int n3 = 0;
                n3 = this.rnd(2);
                this.objAwaData_set(n3, objectData[8], objectData[9]);
            }
        }
    }

    public void objAwaData_set(int n, int n2, int n3) {
        for (int i = 0; i < objAwaData.length; ++i) {
            if (objAwaData[i][0] != 0) continue;
            for (int j = 0; j < objAwaData[i].length; ++j) {
                MainCanvas.objAwaData[i][j] = 0;
            }
            MainCanvas.objAwaData[i][0] = 1;
            MainCanvas.objAwaData[i][1] = n;
            int n4 = n2 + this.rnd(16) - 8;
            MainCanvas.objAwaData[i][8] = n4;
            MainCanvas.objAwaData[i][2] = n4;
            int n5 = n3;
            MainCanvas.objAwaData[i][9] = n5;
            MainCanvas.objAwaData[i][3] = n5;
            MainCanvas.objAwaData[i][6] = this.rnd(2) * 16 * 4;
            break;
        }
    }

    public void objAwaData_move() {
        for (int i = 0; i < objAwaData.length; ++i) {
            if (objAwaData[i][0] <= 0) continue;
            if (objAwaData[i][3] - mapView[1] > -48 && objAwaData[i][3] - mapView[1] < 288 && this.waterH3 < objAwaData[i][3]) {
                int n = this.awasintlb[objAwaData[i][6] % this.awasintlb.length];
                if (n > 128) {
                    n -= 255;
                }
                MainCanvas.objAwaData[i][10] = objAwaData[i][2];
                MainCanvas.objAwaData[i][11] = objAwaData[i][3];
                MainCanvas.objAwaData[i][2] = objAwaData[i][8] + n;
                MainCanvas.objAwaData[i][3] = objAwaData[i][9] - objAwaData[i][5] / 2;
                int[] nArray = objAwaData[i];
                nArray[5] = nArray[5] + 1;
                int[] nArray2 = objAwaData[i];
                nArray2[6] = nArray2[6] + 1;
                int[] nArray3 = objAwaData[i];
                nArray3[7] = nArray3[7] + 1;
                if (objAwaData[i][1] * 32 + 16 >= objAwaData[i][7]) continue;
                MainCanvas.objAwaData[i][7] = objAwaData[i][1] * 32 + 16;
                if (objAwaData[i][1] == 2) {
                    int n2 = 16;
                    int n3 = 16;
                    int n4 = -1;
                    if (Math.abs(this.PlayerPosX() - objAwaData[i][2]) < 12 + n2 && Math.abs(this.PlayerPosY() - 12 - objAwaData[i][3]) < 12 + n3) {
                        n4 = 0;
                    }
                    if (n4 < 0) continue;
                    MainCanvas.objAwaData[i][1] = 3;
                    kokyutimer = 8;
                    this.bressCount = 2100;
                    this.bressMusic = true;
                    PlayerBall = false;
                    this.PlayMusic(27);
                    if (!PlayerJump || -pljump_w >> 1 <= PlayerParam[5]) continue;
                    MainCanvas.PlayerParam[5] = -pljump_w >> 1;
                    continue;
                }
                if (objAwaData[i][1] != 3) continue;
                MainCanvas.objAwaData[i][0] = 0;
                continue;
            }
            MainCanvas.objAwaData[i][0] = 0;
        }
    }

    public void objAwaData_draw() {
        for (int i = 0; i < objAwaData.length; ++i) {
            if (objAwaData[i][0] <= 0) continue;
            int n = objAwaData[i][7] / 16;
            this.drawRegion(gg, this.m_imgObj[104], 0, this.awaPos[n], 32, this.awaSize[n], rotNumTable[TRANS_NONE], objAwaData[i][2] - mapView[0], objAwaData[i][3] - mapView[1], 1 | 2);
        }
    }

    public void ben_nflag_move_sakaki(int n) {
        if (this.animeTimer % 60 < 30) {
            if (raidOn && raidObjectNum == objectData[20]) {
                raidOn = false;
            }
            return;
        }
        int n2 = 8;
        int n3 = 32;
        int n4 = this.ObjectColChkPl(objectData[2], objectData[3], objectData[2], objectData[3], n2, n3);
        if (objectData[5] == 1) {
            n4 = -1;
        }
        if (n4 >= 0 && n4 == 1) {
            MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    public void ben_sflag_move_sakaki(int n) {
        this.ben_nflag_move_sakaki(n);
    }

    public void sjump_nflag_draw_sakaki(int n) {
        int n2 = SJUMP;
        int n3 = objectData[4] / 16;
        if (objectData[4] % 16 == 2) {
            n2 = 1;
        }
        int[] nArray = new int[]{0, 0, 32, 16, 0, 0, 32, 8, 0, 24, 32, 32};
        int n4 = 0;
        if (objectData[5] > 4) {
            n4 = 8;
        } else if (objectData[5] > 0) {
            n4 = 4;
        }
        if (n3 == 0) {
            if (n4 == 8) {
                this.drawRegion(gg, this.m_imgObj[n2], nArray[n4 + 0], nArray[n4 + 1], nArray[n4 + 2], nArray[n4 + 3], rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] - 8, 1 | 2);
            } else {
                this.drawRegion(gg, this.m_imgObj[n2], nArray[n4 + 0], nArray[n4 + 1], nArray[n4 + 2], nArray[n4 + 3], rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            }
        } else if (n3 == 1) {
            if (objectData[19] == 0) {
                if (n4 == 8) {
                    this.drawRegion(gg, this.m_imgObj[n2], nArray[n4 + 0], nArray[n4 + 1], nArray[n4 + 2], nArray[n4 + 3], rotNumTable[TRANS_ROT90], objectData[2] - mapView[0] + 8, objectData[3] - mapView[1], 1 | 2);
                } else {
                    this.drawRegion(gg, this.m_imgObj[n2], nArray[n4 + 0], nArray[n4 + 1], nArray[n4 + 2], nArray[n4 + 3], rotNumTable[TRANS_ROT90], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
                }
            } else if (n4 == 8) {
                this.drawRegion(gg, this.m_imgObj[n2], nArray[n4 + 0], nArray[n4 + 1], nArray[n4 + 2], nArray[n4 + 3], rotNumTable[TRANS_MIRROR_ROT270], objectData[2] - mapView[0] - 8, objectData[3] - mapView[1], 1 | 2);
            } else {
                this.drawRegion(gg, this.m_imgObj[n2], nArray[n4 + 0], nArray[n4 + 1], nArray[n4 + 2], nArray[n4 + 3], rotNumTable[TRANS_MIRROR_ROT270], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            }
        } else if (n4 == 8) {
            this.drawRegion(gg, this.m_imgObj[n2], nArray[n4 + 0], nArray[n4 + 1], nArray[n4 + 2], nArray[n4 + 3], rotNumTable[TRANS_MIRROR_ROT180], objectData[2] - mapView[0], objectData[3] - mapView[1] + 8, 1 | 2);
        } else {
            this.drawRegion(gg, this.m_imgObj[n2], nArray[n4 + 0], nArray[n4 + 1], nArray[n4 + 2], nArray[n4 + 3], rotNumTable[TRANS_MIRROR_ROT180], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        }
    }

    public void bgspr_nflag_draw_sakaki(int n) {
        if (this.zoneNumber != 0) {
            return;
        }
        int n2 = rotNumTable[TRANS_NONE];
        if (objectData[19] == 0) {
            n2 = rotNumTable[TRANS_MIRROR];
        }
        this.drawRegion(gg, this.m_imgObj[5], 0, 0, 32, 16, n2, objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    public void jyama_nflag_draw_sakaki(int n) {
        this.drawImage(gg, this.m_imgObj[58], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    public void signal_nflag_draw_sakaki(int n) {
        this.drawRegion(gg, this.m_imgObj[61], 0, 16 * ((this.animeTimer >> 1) % 6), 32, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    public void mizu_nflag_draw_sakaki(int n) {
        if (objectData[4] == 0) {
            this.DrawWaterMap(71, TRANS_NONE + objectData[19] * 4, objectData[2] - mapView[0] - 8, objectData[3] - mapView[1] - 16);
            this.DrawWaterMap(72, TRANS_NONE + objectData[19] * 4, objectData[2] - mapView[0] - 8, objectData[3] - mapView[1]);
        } else if (objectData[4] == 7) {
            this.DrawWaterMap(95, TRANS_NONE, objectData[2] - mapView[0] - 8, objectData[3] - mapView[1] - 16);
            this.DrawWaterMap(73, TRANS_NONE + 0, objectData[2] - mapView[0] - 8, objectData[3] - mapView[1]);
        } else if (objectData[4] == 8) {
            this.DrawWaterMap(74, TRANS_NONE + objectData[19] * 4, objectData[2] - mapView[0] + 8, objectData[3] - mapView[1] - 8);
            this.DrawWaterMap(75, TRANS_NONE + objectData[19] * 4, objectData[2] - mapView[0] - 8, objectData[3] - mapView[1] - 8);
            this.DrawWaterMap(76, TRANS_NONE + objectData[19] * 4, objectData[2] - mapView[0] - 24, objectData[3] - mapView[1] - 8);
        } else if (objectData[4] == 73) {
            this.drawRegion(gg, this.m_imgObj[110], 0, this.animeTimer % 5 * 32, 40, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], this.waterH2 - 20 - mapView[1], 1 | 2);
        } else if (objectData[4] == 9 || objectData[4] == 169) {
            this.drawRegion(gg, this.m_imgObj[110], 0, this.animeTimer % 5 * 32, 40, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else if (objectData[4] <= 6) {
            this.DrawWaterMap(187, TRANS_NONE + objectData[19] * 4, objectData[2] - mapView[0] - 8, objectData[3] - mapView[1] - 8);
        }
    }

    public void awa_nflag_draw_sakaki(int n) {
        if (this.waterH3 < objectData[3]) {
            this.drawRegion(gg, this.m_imgObj[85], 0, 16 * (this.cpuTimer / 16 % 3), 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        }
    }

    public void ben_nflag_draw_sakaki(int n) {
        if (this.animeTimer % 60 < 30) {
            this.drawRegion(gg, this.m_imgObj[92], 0, 0, 32, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + 8, objectData[3] - mapView[1] - 32, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[92], 0, 0, 32, 16, rotNumTable[TRANS_NONE + 6], objectData[2] - mapView[0] + 8, objectData[3] - mapView[1] + 32, 1 | 2);
        } else {
            this.drawRegion(gg, this.m_imgObj[92], 0, 0, 32, 16, rotNumTable[TRANS_NONE + 1], objectData[2] - mapView[0], objectData[3] - mapView[1] - 16, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[92], 0, 0, 32, 16, rotNumTable[TRANS_NONE + 5], objectData[2] - mapView[0], objectData[3] - mapView[1] + 16, 1 | 2);
        }
    }

    public void ben_sflag_draw_sakaki(int n) {
        this.ben_nflag_draw_sakaki(n);
    }

    public void resultContinue(boolean bl) {
        if (bl) {
            playercount = 3;
            scorecount = 0;
            diecount = 0;
            this.initStageStart();
            plsaveX = 0;
            plsaveY = 0;
            plsaveTime = 0;
            plsaveTime2 = 0;
            this.noTimeScore = false;
        } else {
            mode = MODE_TITLE;
            this.SetSoftFlag = true;
            this.SetSoftCount = 10;
            this.ObjImageClear();
            this.TK_TitleInit(true);
        }
    }

    public void setEnding() {
        int n;
        int n2;
        this.selectZoneNumber = 6;
        this.selectStageNumber = 1;
        MainCanvas.PlayerParam[0] = 978688;
        MainCanvas.PlayerParam[1] = 32768;
        this.zoneNumber = encZoneNumber[this.selectZoneNumber][this.selectStageNumber];
        this.stageNumber = encStageNumber[this.selectZoneNumber][this.selectStageNumber];
        try {
            indata = new DataInputStream(this.getClass().getResourceAsStream("/zone" + (this.zoneNumber + 1) + ".bmd"));
            MapW = worldMapData[this.zoneNumber][this.stageNumber][0].length;
            MapH = worldMapData[this.zoneNumber][this.stageNumber].length;
            tempWorldMapData = new byte[MapH][MapW];
            for (n2 = 0; n2 < MapH; ++n2) {
                for (n = 0; n < MapW; ++n) {
                    MainCanvas.tempWorldMapData[n2][n] = worldMapData[this.zoneNumber][this.stageNumber][n2][n];
                }
            }
            indata.read(mapData);
            indata.close();
            this.setMapData();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        for (n2 = 0; n2 < m_nHiScore.length; ++n2) {
            if (m_nHiScore[n2] >= scorecount) continue;
            for (n = m_nHiScore.length - 1; n > n2; --n) {
                MainCanvas.m_nHiScore[n] = m_nHiScore[n - 1];
                MainCanvas.m_nDifficulty[n] = m_nDifficulty[n - 1];
            }
            MainCanvas.m_nHiScore[n2] = scorecount;
            MainCanvas.m_nDifficulty[n2] = m_nConfigValue[0];
            this.save_hisc();
            break;
        }
        this.readStageObject();
        this.objectInit(this.stageNumber);
        ObjectListNum = 0;
        this.noDataPointer = 0;
        for (n2 = 0; n2 < ObjectList.length; ++n2) {
            MainCanvas.ObjectList[n2][24] = 0;
        }
        this.endingStep = 0;
        this.endingModeOn = true;
    }

    public String[] readStrings(String string) {
        try {
            InputStream inputStream = null;
            inputStream = this.getClass().getResourceAsStream("/" + string);
            int n = inputStream.read();
            n = inputStream.read();
            String[] stringArray = new String[n];
            for (int i = 0; i < n; ++i) {
                int n2 = inputStream.read() & 0xFF;
                byte[] byArray = new byte[n2];
                inputStream.read(byArray);
                stringArray[i] = new String(byArray);
            }
            inputStream.close();
            return stringArray;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private void TK_TitleFactor() {
        int n;
        for (n = 0; n < 10; ++n) {
            if (m_OnKeyFlag[n]) {
                if (KeyPress[n]) {
                    MainCanvas.KeyPress[n] = false;
                    continue;
                }
                MainCanvas.m_OnKeyFlag[n] = false;
                continue;
            }
            MainCanvas.m_OnKeyFlag[n] = KeyPress[n];
        }
        if (m_bDraw > 0) {
            m_bDraw = (byte)(m_bDraw - 1);
        }
        m_nRingPattern = (byte)((m_nRingPattern + 1) % 6);
        if (m_nTitleMode == TITLE_MODE_LICENSE_SEGA) {
            if (m_nTimer == 17) {
                this.PlayMusic(26);
            }
            if ((m_nTimer = (byte)(m_nTimer + 1)) > 75) {
                m_nTimer = 0;
                m_nTitleMode = TITLE_MODE_LICENSE_SONICTEAM;
            }
        } else if (m_nTitleMode == TITLE_MODE_LICENSE_SONICTEAM) {
            if ((m_nTimer = (byte)(m_nTimer + 1)) > 10) {
                m_nTimer = 0;
                this.TK_TitleInit(false);
            }
        } else if (m_nTitleMode == TITLE_MODE_FIRST_SETUP) {
            if (KeyPress[4]) {
                MainCanvas.m_nConfigValue[3] = (byte)((m_nConfigValue[3] + 1) % LANGUAGE_MAX);
                this.TK_LoadTextset();
            } else if (KeyPress[3]) {
                m_nConfigValue[3] = (byte)(m_nConfigValue[3] - 1);
                if (m_nConfigValue[3] < 0) {
                    MainCanvas.m_nConfigValue[3] = (byte)(LANGUAGE_MAX - 1);
                }
                this.TK_LoadTextset();
            } else if (KeyPress[0]) {
                this.save_conf();
                this.TK_TitleInit(false);
                this.SetSoftKey(0);
            }
        } else if (m_nTitleMode == TITLE_MODE_TITLE) {
            if (m_nPattern < 6) {
                if ((m_nTimer = (byte)(m_nTimer + 1)) > 5) {
                    m_nPattern = (byte)(m_nPattern + 1);
                }
            } else {
                m_nTimer = (byte)((m_nTimer + 1) % 5);
            }
            if (KeyPress[0]) {
                m_nTitleMode = TITLE_MODE_TITLE_MENU;
                m_nSel = 0;
                this.TK_SetMarquee(7 + m_nSel);
                this.SetSoftKey(2);
            }
            if (KeyPress[6]) {
                h.doExit();
            }
        } else if (m_nTitleMode == TITLE_MODE_TITLE_MENU) {
            m_nTimer = (byte)((m_nTimer + 1) % 5);
            if (KeyPress[4]) {
                m_nSel = (byte)((m_nSel + 1) % 5);
                this.TK_SetMarquee(7 + m_nSel);
            }
            if (KeyPress[3]) {
                if ((m_nSel = (byte)(m_nSel - 1)) < 0) {
                    m_nSel = (byte)4;
                }
                this.TK_SetMarquee(7 + m_nSel);
            }
            if (KeyPress[0]) {
                if (m_nSel == 0) {
                    m_nSel = 0;
                    this.load_resu();
                    if (this.resumeStage != 0) {
                        this.SetSoftKey(1);
                        m_nSel = 1;
                        this.TK_SetMarquee(45 + m_nSel);
                        m_nTitleMode = TITLE_MODE_TITLE_CONTINUE_MENU;
                    } else {
                        this.clearKey();
                        initDisplay = true;
                        for (n = 0; n < m_imgImage.length; ++n) {
                            MainCanvas.m_imgImage[n] = null;
                        }
                        playercount = 3;
                        scorecount = 0;
                        this.resumeStage = 0;
                        this.zoneNumber = 0;
                        this.selectZoneNumber = 0;
                        this.stageNumber = 0;
                        this.selectStageNumber = 0;
                        readStageObjectFlag = true;
                        this.initStageStart();
                    }
                    return;
                }
                if (m_nSel == 1) {
                    m_nSel = 1;
                    this.clearKey();
                    this.zoneNumber = 0;
                    this.selectZoneNumber = 0;
                    this.stageNumber = 0;
                    this.selectStageNumber = 0;
                    initDisplay = true;
                    mode = MODE_STAGESELECT;
                    this.SetSoftFlag = true;
                    this.SetSoftCount = 10;
                    for (n = 0; n < m_imgImage.length; ++n) {
                        MainCanvas.m_imgImage[n] = null;
                    }
                    return;
                }
                if (m_nSel == 2) {
                    m_nSel = 0;
                    m_nTitleMode = TITLE_MODE_TITLE_HOWTO;
                    m_bDraw = 1;
                    this.SetSoftKey(1);
                } else if (m_nSel == 3) {
                    m_nTitleMode = TITLE_MODE_TITLE_RANCKING;
                    this.SetSoftKey(1);
                } else {
                    m_nSel = 0;
                    m_nTitleMode = TITLE_MODE_TITLE_CONFIG_MENU;
                    this.TK_SetMarquee(47 + m_nSel);
                    this.SetSoftKey(1);
                    m_bDraw = 1;
                }
            }
            if (KeyPress[6]) {
                this.SetSoftKey(0);
                m_nTitleMode = TITLE_MODE_TITLE;
                return;
            }
            this.TK_MoveMarquee();
        } else if (m_nTitleMode == TITLE_MODE_TITLE_RANCKING) {
            if (KeyPress[6]) {
                m_nSel = (byte)3;
                m_nTitleMode = TITLE_MODE_TITLE_MENU;
                this.SetSoftKey(2);
                this.TK_SetMarquee(7 + m_nSel);
            } else if (KeyPress[9]) {
                m_nSel = 1;
                m_nTitleMode = TITLE_MODE_TITLE_RANCKING_MENU;
            }
        } else if (m_nTitleMode == TITLE_MODE_TITLE_RANCKING_MENU) {
            if (KeyPress[6]) {
                m_nTitleMode = TITLE_MODE_TITLE_RANCKING;
            } else if (KeyPress[2] || KeyPress[1]) {
                m_nSel = (byte)((m_nSel + 1) % 2);
            } else if (KeyPress[0]) {
                m_nTitleMode = TITLE_MODE_TITLE_RANCKING;
                if (m_nSel == 0) {
                    m_nHiScore = new int[5];
                    m_nDifficulty = new int[5];
                    this.save_hisc();
                    m_nTitleMode = TITLE_MODE_TITLE_RANCKING_DEL;
                }
            }
        } else if (m_nTitleMode == TITLE_MODE_TITLE_RANCKING_DEL) {
            if (KeyPress[6] || KeyPress[0]) {
                m_nTitleMode = TITLE_MODE_TITLE_RANCKING;
            }
        } else if (m_nTitleMode == TITLE_MODE_TITLE_CONFIG_MENU) {
            if (KeyPress[6] || KeyPress[0]) {
                m_nTitleMode = TITLE_MODE_TITLE_MENU;
                this.SetSoftKey(2);
                m_nSel = (byte)4;
                this.TK_SetMarquee(7 + m_nSel);
                this.save_conf();
            } else if (KeyPress[2]) {
                if ((m_nSel = (byte)(m_nSel - 1)) < 0) {
                    m_nSel = (byte)3;
                }
                this.TK_SetMarquee(47 + m_nSel);
                m_bDraw = 1;
            } else if (KeyPress[1]) {
                m_nSel = (byte)((m_nSel + 1) % 4);
                this.TK_SetMarquee(47 + m_nSel);
                m_bDraw = 1;
            } else if (KeyPress[4]) {
                if (m_nSel == 0) {
                    MainCanvas.m_nConfigValue[0] = (byte)((m_nConfigValue[0] + 1) % 3);
                } else if (m_nSel == 1) {
                    MainCanvas.m_nConfigValue[1] = (byte)((m_nConfigValue[1] + 1) % 4);
                } else if (m_nSel == 2) {
                    MainCanvas.m_nConfigValue[2] = (byte)((m_nConfigValue[2] + 1) % 2);
                } else {
                    MainCanvas.m_nConfigValue[3] = (byte)((m_nConfigValue[3] + 1) % LANGUAGE_MAX);
                    this.TK_LoadTextset();
                    this.TK_SetMarquee(47 + m_nSel);
                    this.SetSoftLabel(1, softKeys[4]);
                }
                m_bDraw = 1;
            } else if (KeyPress[3]) {
                byte by = m_nSel;
                m_nConfigValue[by] = (byte)(m_nConfigValue[by] - 1);
                if (m_nConfigValue[m_nSel] < 0) {
                    if (m_nSel == 0) {
                        MainCanvas.m_nConfigValue[0] = 2;
                    } else if (m_nSel == 1) {
                        MainCanvas.m_nConfigValue[1] = 3;
                    } else if (m_nSel == 2) {
                        MainCanvas.m_nConfigValue[2] = 1;
                    } else {
                        MainCanvas.m_nConfigValue[3] = (byte)(LANGUAGE_MAX - 1);
                    }
                }
                if (m_nSel == 3) {
                    this.TK_LoadTextset();
                    this.TK_SetMarquee(47 + m_nSel);
                    this.SetSoftLabel(1, softKeys[4]);
                }
                m_bDraw = 1;
            }
            this.TK_MoveMarquee();
        } else if (m_nTitleMode == TITLE_MODE_TITLE_CONTINUE_MENU) {
            if (KeyPress[6]) {
                m_nTitleMode = TITLE_MODE_TITLE_MENU;
                m_nSel = 0;
                this.TK_SetMarquee(7 + m_nSel);
                this.SetSoftKey(2);
            } else if (KeyPress[2] || KeyPress[1]) {
                m_nSel = (byte)((m_nSel + 1) % 2);
                this.TK_SetMarquee(45 + m_nSel);
            } else if (KeyPress[0]) {
                if (m_nSel == 0) {
                    this.clearKey();
                    initDisplay = true;
                    for (n = 0; n < m_imgImage.length; ++n) {
                        MainCanvas.m_imgImage[n] = null;
                    }
                    playercount = 3;
                    scorecount = 0;
                    this.resumeStage = 0;
                    this.zoneNumber = 0;
                    this.selectZoneNumber = 0;
                    this.stageNumber = 0;
                    this.selectStageNumber = 0;
                    readStageObjectFlag = true;
                    this.initStageStart();
                } else if (m_nSel == 1) {
                    this.clearKey();
                    initDisplay = true;
                    for (n = 0; n < m_imgImage.length; ++n) {
                        MainCanvas.m_imgImage[n] = null;
                    }
                    playercount = this.resumeZanki;
                    scorecount = this.resumeScore;
                    this.selectZoneNumber = this.zoneNumber = this.resumeStage / 3;
                    this.selectStageNumber = this.stageNumber = this.resumeStage % 3;
                    this.zoneNumber = encZoneNumber[this.selectZoneNumber][this.selectStageNumber];
                    this.stageNumber = encStageNumber[this.selectZoneNumber][this.selectStageNumber];
                    readStageObjectFlag = true;
                    this.initStageStart();
                }
            }
            this.TK_MoveMarquee();
        } else if (m_nTitleMode == TITLE_MODE_TITLE_HOWTO) {
            if (KeyPress[4] && m_nSel < 25) {
                m_nSel = (byte)(m_nSel + 1);
                m_bDraw = 1;
            }
            if (KeyPress[3] && m_nSel > 0) {
                m_nSel = (byte)(m_nSel - 1);
                m_bDraw = 1;
            }
            if (KeyPress[6]) {
                m_nSel = (byte)2;
                m_nTitleMode = TITLE_MODE_TITLE_MENU;
                this.SetSoftKey(2);
            }
        }
        MainCanvas.KeyPress[5] = false;
        MainCanvas.KeyPress[6] = false;
    }

    private void TK_TitleDraw() {
        gg.setFont(m_Font);
        gg.setClip(0, 0, 240, 240);
        if (m_nTitleMode == TITLE_MODE_LICENSE_SEGA) {
            int n;
            int n2;
            gg.setColor(0xFFFFFF);
            gg.fillRect(0, 0, 240, 240);
            gg.drawImage(m_imgImage[0], 120, 120, 3);
            if (m_nTimer < 15) {
                n2 = 240 * m_nTimer / 15;
                gg.fillRect(n2 - 240 - 10, 0, 240, 240);
                gg.fillRect(n2 + 10, 0, 240, 240);
                n = n2 - 11;
                gg.drawLine(n + 2, 0, n + 2, 240);
                gg.drawLine(n + 3, 0, n + 3, 240);
                gg.drawLine(n + 5, 0, n + 5, 240);
                gg.drawLine(n + 8, 0, n + 8, 240);
                n = n2 + 10;
                gg.drawLine(n - 2, 0, n - 2, 240);
                gg.drawLine(n - 3, 0, n - 3, 240);
                gg.drawLine(n - 5, 0, n - 5, 240);
                gg.drawLine(n - 8, 0, n - 8, 240);
            }
            if (m_nTimer >= 60) {
                gg.setColor(0);
                n = (m_nTimer - 60) * 120 / 15;
                for (n2 = 0; n2 < n; ++n2) {
                    gg.drawLine(2 * n2, 0, 2 * n2, 240);
                    gg.drawLine(239 - 2 * n2, 0, 239 - 2 * n2, 240);
                }
            }
        } else if (m_nTitleMode == TITLE_MODE_LICENSE_SONICTEAM) {
            gg.setColor(0);
            gg.fillRect(0, 0, 240, 240);
            gg.drawImage(m_imgImage[1], 120, 120, 3);
        } else if (m_nTitleMode == TITLE_MODE_FIRST_SETUP) {
            gg.setColor(0);
            gg.fillRect(0, 0, 240, 240);
            this.TK_DrawBelt(true, true);
            gg.setColor(0xFFFFFF);
            int n = 3;
            gg.drawString(m_strText[21 + n], 11, 48 + n * 30, 20);
            gg.drawString(m_strText[m_aConfigTextOffset[n][m_nConfigValue[n]]], 212, 48 + n * 30, 24);
            gg.drawImage(m_imgImage[1], 217, 48 + n * 30 + 8, 20);
            int n3 = m_Font.stringWidth(m_strText[m_aConfigTextOffset[n][m_nConfigValue[n]]]);
            gg.drawImage(m_imgImage[2], 212 - n3 - 10, 48 + n * 30 + 8, 20);
            this.TK_DrawStringC(m_strText[21 + n], 120, 8, 0xFFFFFF, 0);
        } else if (m_nTitleMode == TITLE_MODE_TITLE) {
            this.TK_DrawBg(false);
            gg.drawRegion(m_imgImage[0], 0, 0, 190, 109, 0, 25, 56, 20);
            if (m_nPattern == 0) {
                gg.drawRegion(m_imgImage[0], 0, 159, 49, 57, 0, 97, 56 + (5 - m_nTimer) * 3, 20);
            } else if (m_nPattern == 1) {
                gg.drawRegion(m_imgImage[0], 0, 109, 56, 50, 0, 93, 61, 20);
            } else if (m_nPattern == 2) {
                gg.drawRegion(m_imgImage[0], 0, 109, 56, 50, 0, 93, 61, 20);
                gg.drawRegion(m_imgImage[0], 107, 188, 53, 36, 0, 94, 75, 20);
            } else if (m_nPattern == 3) {
                gg.drawRegion(m_imgImage[0], 62, 109, 60, 55, 0, 97, 56, 20);
            } else if (m_nPattern == 4) {
                gg.drawRegion(m_imgImage[0], 50, 164, 55, 57, 0, 97, 55, 20);
            } else if (m_nPattern == 5) {
                gg.drawRegion(m_imgImage[0], 127, 110, 35, 57, 0, 94, 54, 20);
                gg.drawRegion(m_imgImage[0], 163, 109, 27, 58, 0, 129, 53, 20);
            } else {
                gg.drawRegion(m_imgImage[0], 127, 110, 35, 57, 0, 94, 54, 20);
                gg.drawRegion(m_imgImage[0], 135, 167, 26, 21, 0, 98, 67, 20);
                if (m_nTimer / 2 % 2 == 0) {
                    gg.drawRegion(m_imgImage[0], 163, 167, 27, 58, 0, 129, 53, 20);
                } else {
                    gg.drawRegion(m_imgImage[0], 163, 109, 27, 58, 0, 129, 53, 20);
                }
            }
            gg.drawRegion(m_imgImage[0], 0, 224, 190, 56, 0, 25, 109, 20);
            this.TK_DrawStringC(m_strText[0], 120, 178, 0xFFFFFF, 0);
            this.TK_DrawStringC(m_strText[1], 120, 204, 0xFFFFFF, 0);
        } else if (m_nTitleMode == TITLE_MODE_TITLE_MENU) {
            gg.setColor(0xFFFFFF);
            gg.fillRect(0, 0, 240, 240);
            this.TK_DrawBg(false);
            gg.drawRegion(m_imgImage[0], 0, 0, 190, 109, 0, 25, 56, 20);
            gg.drawRegion(m_imgImage[0], 127, 110, 35, 57, 0, 94, 54, 20);
            gg.drawRegion(m_imgImage[0], 135, 167, 26, 21, 0, 98, 67, 20);
            if (m_nTimer / 2 % 2 == 0) {
                gg.drawRegion(m_imgImage[0], 163, 167, 27, 58, 0, 129, 53, 20);
            } else {
                gg.drawRegion(m_imgImage[0], 163, 109, 27, 58, 0, 129, 53, 20);
            }
            gg.drawRegion(m_imgImage[0], 0, 224, 190, 56, 0, 25, 109, 20);
            this.TK_DrawBelt(true, true);
            gg.drawImage(m_imgImage[1], 233, 218, 20);
            gg.drawImage(m_imgImage[2], 2, 218, 20);
            this.TK_DrawStringC(m_strText[2 + m_nSel], 120, 212, 0xFFFFFF, 0xFA0A0A);
            this.TK_DrawMarqueeTop();
        } else if (m_nTitleMode == TITLE_MODE_TITLE_RANCKING) {
            this.TK_DrawBg(true);
            this.TK_DrawBelt(true, true);
            gg.setColor(0xFFFFFF);
            for (int i = 0; i < 5; ++i) {
                gg.drawString("" + (i + 1), 32, 48 + 30 * i, 24);
                gg.drawString("" + m_nHiScore[i], 130, 48 + 30 * i, 24);
                gg.drawString(m_strText[25 + m_nDifficulty[i]], 170, 48 + 30 * i, 17);
            }
            this.TK_DrawStringC(m_strText[5], 120, 8, 0xFFFFFF, 0);
            this.TK_DrawStringC(m_strText[12], 120, 212, 0xFFFFFF, 0);
        } else if (m_nTitleMode == TITLE_MODE_TITLE_RANCKING_MENU) {
            this.TK_DrawBg(true);
            this.TK_DrawBelt(true, true);
            gg.setColor(0xFFFFFF);
            gg.drawString(m_strText[13], 120, 43, 17);
            gg.drawString(m_strText[14], 120, 69, 17);
            gg.drawString(m_strText[15], 120, 95, 17);
            gg.drawString(m_strText[16], 120, 121, 17);
            gg.drawString(m_strText[17], 120, 147, 17);
            gg.drawString(m_strText[18], 120, 173, 17);
            int n = m_Font.stringWidth(m_strText[17 + m_nSel]);
            this.TK_DrawRing(120 - n / 2 - 18, 147 + m_nSel * 26);
            this.TK_DrawRing(120 + n / 2 + 2, 147 + m_nSel * 26);
        } else if (m_nTitleMode == TITLE_MODE_TITLE_RANCKING_DEL) {
            this.TK_DrawBg(true);
            this.TK_DrawBelt(true, true);
            gg.setColor(0xFFFFFF);
            gg.drawString(m_strText[19], 120, 95, 17);
            gg.drawString(m_strText[20], 120, 122, 17);
        } else if (m_nTitleMode == TITLE_MODE_TITLE_CONFIG_MENU) {
            if (m_bDraw != 0) {
                int n;
                this.TK_DrawBg(true);
                gg.setColor(0xFFFFFF);
                for (n = 0; n < 4; ++n) {
                    gg.drawString(m_strText[21 + n], 11, 48 + n * 30, 20);
                    gg.drawString(m_strText[m_aConfigTextOffset[n][m_nConfigValue[n]]], 212, 48 + n * 30, 24);
                }
                gg.drawImage(m_imgImage[1], 217, 48 + m_nSel * 30 + 8, 20);
                n = m_Font.stringWidth(m_strText[m_aConfigTextOffset[m_nSel][m_nConfigValue[m_nSel]]]);
                gg.drawImage(m_imgImage[2], 212 - n - 10, 48 + m_nSel * 30 + 8, 20);
                gg.drawImage(this.m_imgCmd[LOGOLINE], 0, 0, 20);
                gg.setColor(34, 115, 251);
                gg.fillRect(11, 5, 218, 26);
                gg.setColor(6, 66, 148);
                gg.drawLine(10, 30, 10, 4);
                gg.drawLine(10, 4, 229, 4);
                gg.setColor(129, 205, 242);
                gg.drawLine(10, 31, 229, 31);
                gg.drawLine(229, 31, 229, 5);
                this.TK_DrawStringC(m_strText[6], 120, 8, 0xFFFFFF, 0);
            }
            gg.drawImage(this.m_imgCmd[LOGOLINE], 0, 204, 20);
            gg.setColor(34, 115, 251);
            gg.fillRect(9, 207, 222, 30);
            gg.setColor(6, 66, 148);
            gg.drawLine(8, 236, 8, 206);
            gg.drawLine(8, 206, 231, 206);
            gg.setColor(129, 205, 242);
            gg.drawLine(8, 237, 231, 237);
            gg.drawLine(231, 237, 231, 207);
            this.TK_DrawMarqueeBottom();
        } else if (m_nTitleMode == TITLE_MODE_TITLE_CONTINUE_MENU) {
            this.TK_DrawBg(true);
            this.TK_DrawBelt(true, true);
            gg.setColor(0xFFFFFF);
            gg.drawString(m_strText[42], 120, 95, 17);
            gg.drawString(m_strText[43], 120, 121, 17);
            int n = m_Font.stringWidth(m_strText[42 + m_nSel]);
            this.TK_DrawRing(120 - n / 2 - 18, 95 + m_nSel * 26);
            this.TK_DrawRing(120 + n / 2 + 2, 95 + m_nSel * 26);
            this.TK_DrawMarqueeBottom();
        } else if (m_nTitleMode == TITLE_MODE_TITLE_HOWTO && m_bDraw != 0) {
            this.TK_DrawBg(true);
            this.TK_DrawBelt(true, false);
            if (m_HowToPicIndexTbl[m_nSel] >= 0) {
                gg.drawRegion(m_imgImage[6], (int)m_HowToPicTbl[m_HowToPicIndexTbl[m_nSel]][0], (int)m_HowToPicTbl[m_HowToPicIndexTbl[m_nSel]][1], (int)m_HowToPicTbl[m_HowToPicIndexTbl[m_nSel]][2], (int)m_HowToPicTbl[m_HowToPicIndexTbl[m_nSel]][3], 0, 233, 196, 40);
            }
            int n = m_nSel * 7;
            if (m_nSel > 0) {
                gg.setColor(0xFFFFFF);
                for (int i = 0; i < 6; ++i) {
                    gg.drawString(m_strHowToText[1 + n + i], 120, 43 + 26 * i, 17);
                }
                this.TK_DrawStringC(m_strHowToText[n], 120, 8, 0xFFFFFF, 0);
            } else {
                gg.drawRegion(m_imgImage[6], (int)m_HowToPicTbl[13][0], (int)m_HowToPicTbl[13][1], (int)m_HowToPicTbl[13][2], (int)m_HowToPicTbl[13][3], 0, 15, 43, 20);
                gg.drawRegion(m_imgImage[6], (int)m_HowToPicTbl[15][0], (int)m_HowToPicTbl[15][1], (int)m_HowToPicTbl[15][2], (int)m_HowToPicTbl[15][3], 0, 25, 69, 20);
                gg.drawRegion(m_imgImage[6], (int)m_HowToPicTbl[14][0], (int)m_HowToPicTbl[14][1], (int)m_HowToPicTbl[14][2], (int)m_HowToPicTbl[14][3], 0, 25, 95, 20);
                gg.setColor(0xFFFFFF);
                gg.drawString(m_strHowToText[1 + n + 0], 65, 43, 20);
                gg.drawString(m_strHowToText[1 + n + 1], 65, 69, 20);
                gg.drawString(m_strHowToText[1 + n + 2], 65, 95, 20);
                gg.drawString(m_strHowToText[1 + n + 3], 15, 121, 20);
                gg.drawString(m_strHowToText[1 + n + 4], 15, 147, 20);
                for (int i = 5; i < 6; ++i) {
                    gg.drawString(m_strHowToText[1 + n + i], 120, 43 + 26 * i, 17);
                }
            }
            this.TK_DrawStringC(m_strHowToText[n], 120, 8, 0xFFFFFF, 0);
            gg.setColor(34, 115, 251);
            gg.fillRect(15, 230, 210, 7);
            gg.setColor(6, 66, 148);
            gg.drawLine(14, 235, 14, 229);
            gg.drawLine(14, 229, 224, 229);
            gg.setColor(129, 205, 242);
            gg.drawLine(14, 236, 224, 236);
            gg.drawLine(224, 236, 224, 229);
            gg.fillRect(15 + m_nSel * 8, 230, 8, 5);
            gg.drawImage(m_imgImage[1], 227, 229, 20);
            gg.drawImage(m_imgImage[2], 7, 229, 20);
        }
    }

    private void TK_DrawStringC(String string, int n, int n2, int n3, int n4) {
        gg.setColor(n4);
        gg.drawString(string, n - 1, n2, 17);
        gg.drawString(string, n + 1, n2, 17);
        gg.drawString(string, n, n2 + 1, 17);
        gg.drawString(string, n, n2 - 1, 17);
        gg.setColor(n3);
        gg.drawString(string, n, n2, 17);
    }

    private void TK_DrawBelt(boolean bl, boolean bl2) {
        gg.drawImage(this.m_imgCmd[LOGOLINE], 0, 0, 20);
        gg.drawImage(this.m_imgCmd[LOGOLINE], 0, 204, 20);
        if (bl) {
            gg.setColor(34, 115, 251);
            gg.fillRect(11, 5, 218, 26);
            gg.setColor(6, 66, 148);
            gg.drawLine(10, 30, 10, 4);
            gg.drawLine(10, 4, 229, 4);
            gg.setColor(129, 205, 242);
            gg.drawLine(10, 31, 229, 31);
            gg.drawLine(229, 31, 229, 5);
        }
        if (bl2) {
            gg.setColor(34, 115, 251);
            gg.fillRect(9, 207, 222, 30);
            gg.setColor(6, 66, 148);
            gg.drawLine(8, 236, 8, 206);
            gg.drawLine(8, 206, 231, 206);
            gg.setColor(129, 205, 242);
            gg.drawLine(8, 237, 231, 237);
            gg.drawLine(231, 237, 231, 207);
        }
    }

    private void TK_DrawRing(int n, int n2) {
        gg.drawRegion(m_imgImage[4], 0, m_nRingPattern / 2 * 16, 16, 16, 0, n, n2, 20);
    }

    private void TK_SetMarquee(int n) {
        m_strMarquee = m_strText[n];
        m_nMarqueePos = 0;
    }

    private void TK_SetMarquee(String string) {
        m_strMarquee = string;
        m_nMarqueePos = 0;
    }

    private void TK_MoveMarquee() {
        int n = (m_Font.stringWidth(m_strMarquee) + 218) / 6;
        m_nMarqueePos = (m_nMarqueePos + 1) % n;
    }

    private void TK_DrawMarqueeTop() {
        gg.setClip(12, 6, 216, 24);
        gg.setColor(255, 200, 200);
        this.MarqOfs = m_nConfigValue[3] == 1 ? -2 : 0;
        gg.drawString(m_strMarquee, 216 - m_nMarqueePos * 6, 8 + this.MarqOfs, 20);
        gg.setClip(0, 0, 240, 240);
    }

    private void TK_DrawMarqueeBottom() {
        gg.setClip(10, 208, 220, 28);
        gg.setColor(255, 200, 200);
        this.MarqOfs = m_nConfigValue[3] == 1 ? -2 : 0;
        gg.drawString(m_strMarquee, 216 - m_nMarqueePos * 6, 210 + this.MarqOfs, 20);
        gg.setClip(0, 0, 240, 240);
    }

    private void TK_DrawBg(boolean bl) {
        gg.drawImage(m_imgImage[5], 0, 0, 20);
        if (bl) {
            gg.setColor(0);
            for (int i = 0; i < 120; ++i) {
                gg.drawLine(0, i * 2, 240, i * 2);
            }
        }
    }

    private void TK_TitleInit(boolean bl) {
        this.ObjImageClear();
        this.SetSoftKey(-1);
        this.TK_LoadTextset();
        if (bl) {
            MainCanvas.m_imgImage[0] = this.createImage("/t_license1.png");
            MainCanvas.m_imgImage[1] = this.createImage("/t_license2.png");
            m_nTitleMode = TITLE_MODE_LICENSE_SEGA;
        } else {
            MainCanvas.m_imgImage[0] = this.createImage("/t_title.png");
            MainCanvas.m_imgImage[1] = this.createImage("/t_cur1.png");
            MainCanvas.m_imgImage[2] = this.createImage("/t_cur2.png");
            MainCanvas.m_imgImage[4] = this.createImage("/ring.png");
            MainCanvas.m_imgImage[5] = this.createImage("/title_bg.png");
            MainCanvas.m_imgImage[6] = this.createImage("/t_matome.png");
            if (m_bFirstSetUp != 0) {
                m_bFirstSetUp = 0;
                MainCanvas.m_nConfigValue[3] = 1;
                this.TK_LoadTextset();
                m_nTitleMode = TITLE_MODE_FIRST_SETUP;
            } else {
                m_nTitleMode = TITLE_MODE_TITLE;
                this.SetSoftKey(0);
                this.PlayMusic(15);
            }
        }
        m_nTimer = 0;
        for (int i = 0; i < 10; ++i) {
            MainCanvas.m_OnKeyFlag[i] = false;
        }
        m_nRingPattern = 0;
    }

    private void TK_LoadTextset() {
        try {
            int n;
            m_Font = m_nConfigValue[3] == 0 ? Font.getFont((int)0, (int)0, (int)8) : Font.getFont((int)0, (int)0, (int)16);
            in = this.getClass().getResourceAsStream("/lang_" + m_nConfigValue[3] + ".txt");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(300);
            byte[] byArray = new byte[1];
            int n2 = 0;
            while ((n = in.read(byArray)) > 0) {
                if (byArray[0] == 13) {
                    in.read(byArray);
                    if (n2 < 51) {
                        MainCanvas.m_strText[n2] = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                    } else {
                        MainCanvas.softKeys[n2 - 51] = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                    }
                    byteArrayOutputStream.reset();
                    ++n2;
                    continue;
                }
                byteArrayOutputStream.write(byArray, 0, n);
            }
            in.close();
            byteArrayOutputStream.close();
            byteArrayOutputStream = new ByteArrayOutputStream(300);
            in = this.getClass().getResourceAsStream("/manual_" + m_nConfigValue[3] + ".txt");
            n2 = 0;
            while ((n = in.read(byArray)) > 0) {
                if (byArray[0] == 13) {
                    in.read(byArray);
                    MainCanvas.m_strHowToText[n2] = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                    byteArrayOutputStream.reset();
                    ++n2;
                    continue;
                }
                byteArrayOutputStream.write(byArray, 0, n);
            }
            in.close();
            byteArrayOutputStream.close();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void SetSoftKey(int n) {
        this.removeCommand(cmd[1]);
        this.removeCommand(cmd[0]);
        MainCanvas.cmd[1] = null;
        MainCanvas.cmd[0] = null;
        if (n == 0) {
            MainCanvas.cmd[0] = m_nConfigValue[1] == 0 ? new Command(m_strText[40], 1, 1) : new Command(m_strText[41], 1, 1);
            MainCanvas.cmd[1] = new Command(m_strText[39], 1, 1);
            this.addCommand(cmd[0]);
            this.addCommand(cmd[1]);
        }
        if (n == 1) {
            MainCanvas.cmd[0] = new Command("", 1, 1);
            MainCanvas.cmd[1] = new Command(m_strText[38], 1, 1);
            this.addCommand(cmd[0]);
            this.addCommand(cmd[1]);
        }
        if (n == 2) {
            MainCanvas.cmd[0] = m_nConfigValue[1] == 0 ? new Command(m_strText[40], 1, 1) : new Command(m_strText[41], 1, 1);
            MainCanvas.cmd[1] = new Command(m_strText[38], 1, 1);
            this.addCommand(cmd[0]);
            this.addCommand(cmd[1]);
        }
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == cmd[1]) {
            this.clearKey();
            MainCanvas.KeyPress[6] = true;
        }
        if (command == cmd[0]) {
            this.clearKey();
            MainCanvas.KeyPress[5] = true;
        }
    }

    private void Vibrate(int n) {
        if (n == 0) {
            n = 100;
        }
        if (m_nConfigValue[2] == 1) {
            h.vibrate(n);
        } else {
            h.vibrate(0);
        }
    }

    private void StopVibrate(int n) {
        h.vibrate(0);
    }

    private void InitViewControl() {
        this.mapViewType = 0;
        this.mapViewTypeTemp = -1;
        this.mapViewCount = 0;
        this.mapViewPri = 0;
        for (int i = 0; i < 2; ++i) {
            MainCanvas.mapViewTarget[i] = MainCanvas.mapView[i] = mapOxy[i];
            MainCanvas.mapOfs[i] = 0;
            MainCanvas.mapOfsTarget[i] = 0;
        }
    }

    private void ForceViewControl(int n) {
        this.mapViewCount = 20;
        this.mapViewTypeTemp = n;
    }

    private void view_yuka(int n, int n2, int n3) {
        if (n3 != 1 && n3 != 21) {
            return;
        }
        if (this.mapViewPri > 1) {
            return;
        }
        if (this.mapViewCount > 1) {
            return;
        }
        if (Math.abs(this.PlayerPosX() - n) < 300 && Math.abs(this.PlayerPosY() + 40 - n2) < 120) {
            this.mapViewCount = 20;
            this.mapViewTypeTemp = 10;
            this.mapViewPri = 1;
        }
    }

    private void view_turi(int n, int n2, int n3) {
        int n4;
        if (this.mapViewPri > 2) {
            return;
        }
        if (this.mapViewPri == 2 && this.mapViewCount > 1) {
            return;
        }
        int n5 = n4 = objectData[4] == 35 ? 48 : 136;
        if (Math.abs(this.PlayerPosX() - n) < n4 && this.PlayerPosY() + 40 > n2 && this.PlayerPosY() - 320 < n2) {
            this.mapViewCount = 20;
            this.mapViewTypeTemp = 8;
            this.mapViewPri = 2;
        }
    }

    private void view_fblock(int n, int n2, int n3) {
        if (n3 != 2 && n3 != 10) {
            return;
        }
        if (this.mapViewPri > 3) {
            return;
        }
        if (this.mapViewPri == 3 && this.mapViewCount > 1) {
            return;
        }
        if (this.mapViewCount < 2 && Math.abs(this.PlayerPosX() - n) < 128 && Math.abs(this.PlayerPosY() - n2) < 96) {
            this.mapViewCount = 20;
            this.mapViewTypeTemp = 7;
            this.mapViewPri = 3;
        }
    }

    private void view_dai_ride(int n, int n2, int n3) {
        if (n3 != 2) {
            return;
        }
        if (this.mapViewPri > 4) {
            return;
        }
        if (this.mapViewPri == 4 && this.mapViewCount > 1) {
            return;
        }
        if (Math.abs(this.PlayerPosX() - n) < 96 && Math.abs(this.PlayerPosY() - n2) < 96) {
            this.mapViewCount = 20;
            this.mapViewTypeTemp = 5;
            this.mapViewPri = 4;
        }
    }

    private void view_box_ride(int n, int n2, int n3) {
        if (n3 != 1 && n3 != 2) {
            return;
        }
        if (this.mapViewPri > 4) {
            return;
        }
        if (this.mapViewPri == 4 && this.mapViewCount > 1) {
            return;
        }
        if (Math.abs(this.PlayerPosX() - n) < 96 && Math.abs(this.PlayerPosY() - n2) < 96) {
            this.mapViewCount = 20;
            this.mapViewTypeTemp = 5;
            this.mapViewPri = 4;
        }
    }

    private void view_dai(int n, int n2, int n3) {
        if (n3 != 2) {
            return;
        }
        if (this.mapViewPri > 5) {
            return;
        }
        if (this.mapViewPri == 5 && this.mapViewCount > 1) {
            return;
        }
        if (Math.abs(this.PlayerPosX() - n) < 96 && Math.abs(this.PlayerPosY() - n2) < 96) {
            this.mapViewCount = 20;
            this.mapViewTypeTemp = 2;
            this.mapViewPri = 5;
        }
    }

    private void view_box(int n, int n2, int n3) {
        if (n3 != 1 && n3 != 2) {
            return;
        }
        if (this.mapViewPri > 5) {
            return;
        }
        if (this.mapViewPri == 5 && this.mapViewCount > 1) {
            return;
        }
        if (Math.abs(this.PlayerPosX() - n) < 96 && Math.abs(this.PlayerPosY() - n2) < 96) {
            this.mapViewCount = 20;
            this.mapViewTypeTemp = 2;
            this.mapViewPri = 5;
        }
    }

    private void ViewControl() {
        int n;
        int n2 = this.PlayerPosX();
        int n3 = this.PlayerPosY();
        if (this.mapViewCount > 0) {
            --this.mapViewCount;
            if (this.mapViewCount == 0) {
                this.mapViewTypeTemp = -1;
                this.mapViewPri = 0;
            }
        }
        if (this.mapViewTypeTemp >= 0) {
            this.mapViewType = this.mapViewTypeTemp;
        } else {
            this.mapViewPri = 0;
            if (bossModeOn || bossBreakOn) {
                this.mapViewType = this.zoneNumber == 5 && mapOxy[0] < 1024 ? 1 : 6;
            } else {
                switch (this.zoneNumber) {
                    case 0: {
                        this.mapViewType = 1;
                        break;
                    }
                    case 1: {
                        this.mapViewType = 0;
                        break;
                    }
                    case 2: {
                        this.mapViewType = 1;
                        switch (this.stageNumber) {
                            case 0: {
                                if (Math.abs(4272 - n2) < 120 && Math.abs(1024 - n3) < 320) {
                                    this.mapViewType = 8;
                                    break;
                                }
                                if (Math.abs(4672 - n2) >= 80 || Math.abs(688 - n3) >= 96) break;
                                this.mapViewType = 9;
                                break;
                            }
                            case 1: {
                                if (Math.abs(2944 - n2) >= 640 || Math.abs(384 - (n3 + 40)) >= 384) break;
                                this.mapViewType = 9;
                                break;
                            }
                            case 2: {
                                if (Math.abs(1552 - n2) < 160 && Math.abs(1120 - (n3 + 40)) < 96) {
                                    this.mapViewType = 3;
                                    break;
                                }
                                if (Math.abs(5632 - n2) >= 512 || Math.abs(688 - (n3 + 40)) >= 96) break;
                                this.mapViewType = 9;
                            }
                        }
                        break;
                    }
                    case 3: {
                        this.mapViewType = 1;
                        break;
                    }
                    case 4: {
                        this.mapViewType = 1;
                        if (this.stageNumber != 1) break;
                        if (Math.abs(n2 - 7296) < 240 && Math.abs(n3 - 640) < 80) {
                            this.mapViewType = 2;
                            break;
                        }
                        if (Math.abs(n2 - 8464) >= 240 || Math.abs(n3 - 640) >= 80) break;
                        this.mapViewType = 2;
                        break;
                    }
                    case 5: {
                        this.mapViewType = 0;
                    }
                }
            }
        }
        switch (this.mapViewType) {
            default: {
                MainCanvas.mapView[0] = mapOxy[0];
                MainCanvas.mapView[1] = mapOxy[1];
                return;
            }
            case 1: {
                MainCanvas.mapOfsTarget[0] = 0;
                MainCanvas.mapOfsTarget[1] = 0;
                break;
            }
            case 2: {
                MainCanvas.mapOfsTarget[0] = 0;
                MainCanvas.mapOfsTarget[1] = 32;
                break;
            }
            case 3: {
                MainCanvas.mapOfsTarget[0] = 0;
                MainCanvas.mapOfsTarget[1] = 40;
                break;
            }
            case 4: {
                if (PlayerParam[5] > 0) {
                    MainCanvas.mapOfsTarget[0] = 0;
                    MainCanvas.mapOfsTarget[1] = 48;
                    break;
                }
                MainCanvas.mapOfsTarget[0] = 0;
                MainCanvas.mapOfsTarget[1] = 0;
                break;
            }
            case 5: {
                MainCanvas.mapOfsTarget[0] = 0;
                MainCanvas.mapOfsTarget[1] = -16;
                break;
            }
            case 6: {
                MainCanvas.mapOfsTarget[0] = 0;
                MainCanvas.mapOfsTarget[1] = 0;
                break;
            }
            case 7: {
                MainCanvas.mapOfsTarget[0] = 0;
                MainCanvas.mapOfsTarget[1] = 16;
                break;
            }
            case 8: {
                MainCanvas.mapOfsTarget[0] = 0;
                MainCanvas.mapOfsTarget[1] = -32;
                break;
            }
            case 9: {
                MainCanvas.mapOfsTarget[0] = 36;
                MainCanvas.mapOfsTarget[1] = 16;
                break;
            }
            case 10: {
                MainCanvas.mapOfsTarget[0] = 32;
                MainCanvas.mapOfsTarget[1] = 40;
            }
        }
        int n4 = Math.abs(mapOxy[0] - mapViewTarget[0]);
        int n5 = Math.abs(mapOxy[1] - mapViewTarget[1]);
        if (this.mapViewType == 6) {
            MainCanvas.mapViewTarget[0] = n4 < 4 || n4 > 256 ? mapOxy[0] : mapViewTarget[0] + (mapOxy[0] > mapViewTarget[0] ? 4 : -4);
            MainCanvas.mapViewTarget[1] = n5 < 4 || n5 > 256 ? mapOxy[1] : mapViewTarget[1] + (mapOxy[1] > mapViewTarget[1] ? 4 : -4);
        } else {
            MainCanvas.mapViewTarget[0] = n4 < 32 || n4 > 256 ? mapOxy[0] : mapViewTarget[0] + (mapOxy[0] > mapViewTarget[0] ? 32 : -32);
            MainCanvas.mapViewTarget[1] = n5 < 16 || n5 > 256 ? mapOxy[1] : (n5 > 32 ? (mapOxy[1] > mapViewTarget[1] ? mapViewTarget[1] + 32 : mapViewTarget[1] - 32) : mapViewTarget[1] + (mapOxy[1] > mapViewTarget[1] ? 16 : -16));
        }
        if (mapOfs[0] != mapOfsTarget[0]) {
            mapOfs[0] = mapOfs[0] + (mapOfs[0] < mapOfsTarget[0] ? 1 : -1);
        }
        MainCanvas.mapView[0] = mapViewTarget[0] + mapOfs[0];
        if (mapOfs[1] != mapOfsTarget[1]) {
            mapOfs[1] = mapOfs[1] + (mapOfs[1] < mapOfsTarget[1] ? 1 : -1);
        }
        MainCanvas.mapView[1] = mapViewTarget[1] + mapOfs[1];
        int n6 = 112;
        if (this.LookUpCount > 0) {
            n6 += this.LookUpCount << 1;
        }
        if (this.CrouchCount > 0) {
            n6 -= this.CrouchCount << 1;
        }
        if (mapView[1] > (n = this.poslimit[3] - n6)) {
            MainCanvas.mapView[1] = n;
        }
    }

    private void DoGc() {
        try {
            System.gc();
            Thread.sleep(200L);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void moveSysString() {
        int n;
        if (this.goleFlag && this.golecount > 0) {
            --this.golecount;
            return;
        }
        if (this.scoreMoveFlag) {
            if (this.scoreGetcount < 0) {
                this.limitBreak = false;
                this.scoreMoveFlag = false;
                this.goleFlag = false;
                plsaveX = 0;
                plsaveY = 0;
                plsaveTime = 0;
                plsaveTime2 = 0;
                this.noTimeScore = false;
                this.selectStageNumber = (this.selectStageNumber + 1) % 3;
                if (this.selectStageNumber == 0) {
                    ++this.selectZoneNumber;
                }
                this.resumeStage = (byte)(this.selectStageNumber + this.selectZoneNumber * 3);
                this.resumeZanki = (byte)playercount;
                this.resumeScore = scorecount;
                if (this.clearStageData < this.resumeStage) {
                    this.clearStageData = this.resumeStage;
                }
                this.save_resu();
                this.zoneNumber = encZoneNumber[this.selectZoneNumber][this.selectStageNumber];
                this.stageNumber = encStageNumber[this.selectZoneNumber][this.selectStageNumber];
                this.readStageObject();
                readStageObjectFlag = false;
                this.countClear();
                this.objectInit(this.stageNumber);
                this.initStageStart();
            } else {
                --this.scoreGetcount;
                if (this.scoreGetcount == 10) {
                    this.PlayMusic(28);
                }
                if (this.scoreGetcountMax - this.scoreGetcount > 15) {
                    for (n = 0; n < 40; ++n) {
                        if (this.resultTime > 0) {
                            this.resultTime -= 10;
                            this.addScoreCount(10, 0);
                        }
                        if (this.resultRing <= 0) continue;
                        this.resultRing -= 10;
                        this.addScoreCount(10, 0);
                    }
                }
            }
        }
        if (this.goleFlag) {
            this.limitBreak = true;
            MainCanvas.PlayerParam[12] = 0;
            PlayerParam[10] = PlayerParam[10] + 128;
        }
        block1: for (n = 0; n < this.SysString.length; ++n) {
            if (this.SysString[n][0] != 1 || this.SysCount < this.SysString[n][9]) continue;
            for (int i = 0; i < 24; ++i) {
                if (this.SysCenter + this.SysString[n][8] > this.SysString[n][2]) {
                    int[] nArray = this.SysString[n];
                    nArray[2] = nArray[2] + 1;
                    continue;
                }
                if (this.SysCenter + this.SysString[n][8] < this.SysString[n][2]) {
                    int[] nArray = this.SysString[n];
                    nArray[2] = nArray[2] - 1;
                    continue;
                }
                ++this.SysCount;
                this.SysString[n][0] = 2;
                if (this.goleFlag) {
                    if (this.SysCount < 5) continue block1;
                    this.DG();
                    this.scoreMoveFlag = true;
                    mutekicount = -1;
                    this.resultRing = ringcount * 100;
                    this.resultTime = 0;
                    this.resultTime = timecount < 30 && timecount2 == 0 && !this.noTimeScore ? 50000 : (timecount < 45 && timecount2 == 0 ? 10000 : (timecount2 < 1 ? 5000 : (timecount < 30 && timecount2 == 1 ? 4000 : (timecount2 < 2 ? 3000 : (timecount < 30 && timecount2 == 2 ? 2000 : 1000)))));
                    if (this.resultTime > this.resultRing) {
                        this.scoreGetcountMax = this.scoreGetcount = this.resultTime / 240 + 30;
                        continue block1;
                    }
                    this.scoreGetcountMax = this.scoreGetcount = this.resultRing / 240 + 30;
                    continue block1;
                }
                if (this.SysCount < 5) continue block1;
                this.putNowLoading = true;
                this.DG();
                if (readStageObjectFlag) {
                    this.readStageObject();
                    readStageObjectFlag = false;
                    plsaveX = 0;
                    plsaveY = 0;
                    plsaveTime = 0;
                    plsaveTime2 = 0;
                    this.noTimeScore = false;
                    this.endStageStart();
                } else {
                    this.objectInit(this.stageNumber);
                    this.endStageStart();
                }
                this.putNowLoading = false;
                continue block1;
            }
        }
        if (mode == MODE_FIELD && !this.goleFlag) {
            ++this.SysCount;
            if (this.SysCount >= 20) {
                if (this.SysCount < 30) {
                    int[] nArray = this.SysString[0];
                    nArray[2] = nArray[2] + 48;
                    int[] nArray2 = this.SysString[1];
                    nArray2[2] = nArray2[2] + 48;
                    int[] nArray3 = this.SysString[2];
                    nArray3[2] = nArray3[2] + 48;
                    int[] nArray4 = this.SysString[3];
                    nArray4[2] = nArray4[2] - 48;
                    int[] nArray5 = this.SysString[4];
                    nArray5[2] = nArray5[2] - 48;
                } else {
                    this.SysString[0][0] = 0;
                    this.SysString[1][0] = 0;
                    this.SysString[2][0] = 0;
                    this.SysString[3][0] = 0;
                    this.SysString[4][0] = 0;
                }
            }
        }
    }

    private void drawSysString() {
        int n;
        for (n = 0; n < this.SysString.length; ++n) {
            if (this.SysString[n][0] < 1 || this.zoneNumber == 5 && this.stageNumber == 3 && (this.SysString[n][1] == this.ACT || this.SysString[n][1] == this.ACT1)) continue;
            gg.drawRegion(this.m_imgCmd[SYSTXT], this.SysString[n][4], this.SysString[n][5], this.SysString[n][6], this.SysString[n][7], rotNumTable[TRANS_NONE], this.SysString[n][2], this.SysString[n][3], 20);
        }
        if (this.scoreMoveFlag) {
            int[] nArray = new int[]{scorecount, this.resultTime, this.resultRing};
            for (n = 0; n < 3; ++n) {
                int n2 = 240 - (this.scoreGetcountMax - this.scoreGetcount) * 24 + n * 12;
                if (n2 < 44) {
                    n2 = 44;
                }
                gg.drawRegion(this.m_imgCmd[SYSTXT2], 0, n * 16, 84, 16, rotNumTable[TRANS_NONE], n2, 124 + 16 * n, 20);
                this.drawNumber2(n2 + 152, 124 + 16 * n - 36, nArray[n]);
            }
        }
    }

    public void run() {
        long l = System.currentTimeMillis();
        while (true) {
            try {
                while (true) {
                    if (bPauseMusic) {
                        if (this.player1 != null && this.player1.getState() == 400) {
                            try {
                                this.player1.stop();
                            }
                            catch (Throwable throwable) {}
                        }
                    } else if (musicRetry > 0) {
                        int n = musicRetry;
                        this.PlayMusic(musicRequest);
                        musicRetry = n;
                        --musicRetry;
                    } else if (this.bDoPlay) {
                        if (!this.scoreMoveFlag) {
                            switch (musicNum) {
                                default: {
                                    break;
                                }
                                case 1: {
                                    this.PlayMusic(2);
                                    break;
                                }
                                case 3: {
                                    this.PlayMusic(4);
                                    break;
                                }
                                case 5: {
                                    this.PlayMusic(6);
                                    break;
                                }
                                case 7: {
                                    this.PlayMusic(8);
                                    break;
                                }
                                case 9: {
                                    this.PlayMusic(10);
                                    break;
                                }
                                case 18: {
                                    this.PlayMusic(19);
                                    break;
                                }
                                case 12: 
                                case 13: 
                                case 24: 
                                case 25: 
                                case 27: {
                                    this.PlayZoneBGML();
                                }
                            }
                        }
                        this.bDoPlay = false;
                    }
                    l = System.currentTimeMillis();
                    Thread.sleep(50L);
                }
            }
            catch (InterruptedException interruptedException) {
                continue;
            }
            break;
        }
    }

    private void ResetSound() {
        musicNum = -1;
        musicCount = 0;
        musicRetry = 0;
        musicRequest = -1;
        this.scoreMoveFlag = false;
        bPauseMusic = false;
        bGoalMusic = false;
        if (this.player1 != null) {
            try {
                this.player1.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        this.player1 = null;
        if (this.is1 != null) {
            try {
                this.is1.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        this.is1 = null;
    }

    private void InitSound() {
        this.ResetSound();
        Thread thread = new Thread(this);
        thread.start();
        thread.setPriority(10);
    }

    public void playerUpdate(Player player, String string, Object object) {
        switch (player.getState()) {
            case 100: {
                break;
            }
            case 200: {
                break;
            }
            case 300: {
                break;
            }
            case 400: {
                break;
            }
            case 0: {
                musicNum = -1;
                break;
            }
        }
        if (string == "endOfMedia") {
            switch (musicNum) {
                default: {
                    break;
                }
                case 1: 
                case 3: 
                case 5: 
                case 7: 
                case 9: 
                case 18: {
                    this.bDoPlay = true;
                }
            }
        }
        if (string == "endOfMedia" && this.player1.getState() == 300) {
            this.bDoPlay = true;
        }
        if (string == "stopped" || string == "closed" || string == "endOfMedia") {
            // empty if block
        }
        if (string == "volumeChanged") {
            // empty if block
        }
    }

    private boolean _playMusic(String string, int n) {
        boolean bl = true;
        bPauseMusic = false;
        System.gc();
        try {
            if (this.is1 != null) {
                this.is1.close();
                this.is1 = null;
            }
            this.is1 = this.getClass().getResourceAsStream("/bgm/" + string + ".mmf");
            if (this.player1 != null) {
                this.player1.close();
                this.player1 = null;
            }
            this.player1 = Manager.createPlayer((InputStream)this.is1, (String)"application/x-smaf");
            this.player1.realize();
            this.player1.addPlayerListener((PlayerListener)this);
            this.player1.setLoopCount(n);
            this.VolumeMusic();
            this.player1.prefetch();
            this.player1.start();
            musicNum = musicRequest;
            musicRequest = -1;
            musicRetry = 0;
        }
        catch (MediaException mediaException) {
            if (this.player1 != null) {
                this.player1.close();
            }
            this.player1 = null;
            this.DoGc();
            bl = false;
        }
        catch (IOException iOException) {
            if (this.player1 != null) {
                this.player1.close();
            }
            this.player1 = null;
            this.DoGc();
            bl = false;
        }
        catch (Throwable throwable) {
            if (this.player1 != null) {
                this.player1.close();
            }
            this.player1 = null;
            this.DoGc();
            bl = false;
        }
        if (this.is1 != null) {
            try {
                this.is1.close();
                this.is1 = null;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        return bl;
    }

    private void PlayMusic(int n) {
        boolean bl = false;
        if (n == 20) {
            bGoalMusic = true;
        }
        if (bGoalMusic && n < 12) {
            return;
        }
        switch (n) {
            default: {
                this.StopMusic();
                return;
            }
            case 1: {
                bl = this._playMusic("81_1", 1);
                break;
            }
            case 2: {
                bl = this._playMusic("81_2", -1);
                break;
            }
            case 3: {
                bl = this._playMusic("82_1", 1);
                break;
            }
            case 4: {
                bl = this._playMusic("82_2", -1);
                break;
            }
            case 5: {
                bl = this._playMusic("83_1", 1);
                break;
            }
            case 6: {
                bl = this._playMusic("83_2", -1);
                break;
            }
            case 7: {
                bl = this._playMusic("84_1", 1);
                break;
            }
            case 8: {
                bl = this._playMusic("84_2", -1);
                break;
            }
            case 9: {
                bl = this._playMusic("85_1", 1);
                break;
            }
            case 10: {
                bl = this._playMusic("85_2", -1);
                break;
            }
            case 11: {
                bl = this._playMusic("86", -1);
                break;
            }
            case 12: {
                bl = this._playMusic("87", -1);
                break;
            }
            case 13: {
                bl = this._playMusic("88", 1);
                break;
            }
            case 14: {
                bl = this._playMusic("89", -1);
                break;
            }
            case 15: {
                bl = this._playMusic("8a", 1);
                break;
            }
            case 16: {
                bl = this._playMusic("8b", 1);
                break;
            }
            case 17: {
                bl = this._playMusic("8c", -1);
                break;
            }
            case 18: {
                bl = this._playMusic("8d_1", 1);
                break;
            }
            case 19: {
                bl = this._playMusic("8d_2", -1);
                break;
            }
            case 20: {
                bl = this._playMusic("8e", 1);
                break;
            }
            case 21: {
                bl = this._playMusic("8f", 1);
                break;
            }
            case 22: {
                bl = this._playMusic("90", 1);
                break;
            }
            case 23: {
                bl = this._playMusic("91", 1);
                break;
            }
            case 24: {
                bl = this._playMusic("92", -1);
                break;
            }
            case 25: {
                bl = this._playMusic("93", 1);
                break;
            }
            case 26: {
                bl = this._playMusic("SEGA", 1);
                break;
            }
            case 27: {
                bl = this._playMusic("ad", 1);
                break;
            }
            case 28: {
                bl = this._playMusic("c5", 1);
                break;
            }
            case 29: {
                bl = this._playMusic("b2", 1);
                break;
            }
            case 30: {
                bl = this._playMusic("88", 1);
            }
        }
        if (bl) {
            musicNum = n;
            musicRequest = -1;
            musicRetry = 0;
        } else {
            musicRequest = n;
            musicRetry = 30;
        }
    }

    private void PauseMusic() {
        try {
            this.player1.stop();
        }
        catch (MediaException mediaException) {
            mediaException.printStackTrace();
        }
        bPauseMusic = true;
    }

    private void RestartMusic() {
        bPauseMusic = false;
        if (this.player1 != null) {
            try {
                this.VolumeMusic();
                this.player1.start();
            }
            catch (MediaException mediaException) {
                mediaException.printStackTrace();
            }
        }
    }

    private void StopMusic() {
        if (this.player1 != null) {
            try {
                this.player1.close();
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        this.player1 = null;
        musicNum = -1;
        musicCount = 0;
        musicRetry = 0;
        musicRequest = -1;
        bPauseMusic = false;
        this.bDoPlay = false;
    }

    private void _setMusicVol(int n) {
        if (this.player1 != null && this.player1.getState() != 0) {
            try {
                VolumeControl volumeControl = (VolumeControl)this.player1.getControl("VolumeControl");
                if (volumeControl != null) {
                    volumeControl.setLevel(n);
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private void VolumeMusic() {
        switch (m_nConfigValue[1]) {
            case 0: {
                this._setMusicVol(0);
                break;
            }
            case 1: {
                this._setMusicVol(20);
                break;
            }
            case 2: {
                this._setMusicVol(36);
                break;
            }
            case 3: {
                this._setMusicVol(100);
            }
        }
    }

    private void MuteMusic(boolean bl) {
        if (this.player1 != null && this.player1.getState() != 0) {
            try {
                VolumeControl volumeControl = (VolumeControl)this.player1.getControl("VolumeControl");
                if (volumeControl != null) {
                    volumeControl.setMute(bl);
                }
                if (!bl) {
                    this.VolumeMusic();
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private int GetZoneBGMNum(boolean bl) {
        if (this.bressCount < 600) {
            return 24;
        }
        if (mutekicount > 0) {
            return 12;
        }
        if (bossModeOn) {
            if (this.zoneNumber == 5 && this.stageNumber == 3) {
                return 18;
            }
            return 17;
        }
        if (bl) {
            switch (this.zoneNumber) {
                default: {
                    return 2;
                }
                case 0: {
                    return 2;
                }
                case 1: {
                    if (this.stageNumber == 3) {
                        return 11;
                    }
                    return 4;
                }
                case 2: {
                    return 6;
                }
                case 3: {
                    return 8;
                }
                case 4: {
                    return 10;
                }
                case 5: {
                    if (this.stageNumber == 3) {
                        return 18;
                    }
                    return 11;
                }
                case 6: 
            }
            return 14;
        }
        switch (this.zoneNumber) {
            default: {
                return 2;
            }
            case 0: {
                return 1;
            }
            case 1: {
                if (this.stageNumber == 3) {
                    return 11;
                }
                return 3;
            }
            case 2: {
                return 5;
            }
            case 3: {
                return 7;
            }
            case 4: {
                return 9;
            }
            case 5: {
                if (this.stageNumber == 3) {
                    return 19;
                }
                return 11;
            }
            case 6: 
        }
        return 14;
    }

    private void PlayZoneBGM() {
        this.PlayMusic(this.GetZoneBGMNum(false));
    }

    private void PlayZoneBGML() {
        this.PlayMusic(this.GetZoneBGMNum(true));
    }

    private void AraiLoadStageImage(int n) {
        try {
            this.m_imgObj[100] = this.createImage("/animal.png");
            switch (n) {
                default: {
                    this.m_imgObj[41] = this.createImage("/musi.png");
                    this.m_imgObj[40] = this.createImage("/hachi.png");
                    this.m_imgObj[86] = this.createImage("/fish.png");
                    this.m_imgObj[39] = this.createImage("/kamere.png");
                    this.m_imgObj[57] = this.createImage("/kani.png");
                    break;
                }
                case 2: {
                    this.m_imgObj[101] = this.createImage("/fire.png");
                    this.m_imgObj[81] = this.createImage("/mogura.png");
                    this.m_imgObj[87] = this.createImage("/fish2.png");
                    this.m_imgObj[74] = this.createImage("/uni.png");
                    break;
                }
                case 3: {
                    this.m_imgObj[101] = this.createImage("/fire.png");
                    this.m_imgObj[40] = this.createImage("/hachi.png");
                    this.m_imgObj[49] = this.createImage("/imo.png");
                    this.m_imgObj[78] = this.createImage("/bat.png");
                    break;
                }
                case 4: {
                    this.m_imgObj[101] = this.createImage("/fire.png");
                    this.m_imgObj[50] = this.createImage("/brobo.png");
                    this.m_imgObj[74] = this.createImage("/uni.png");
                    break;
                }
                case 5: {
                    this.m_imgObj[101] = this.createImage("/fire.png");
                    this.m_imgObj[40] = this.createImage("/hachi.png");
                    this.m_imgObj[57] = this.createImage("/kani.png");
                    this.m_imgObj[71] = this.createImage("/yado.png");
                    this.m_imgObj[70] = this.createImage("/aruma.png");
                    this.m_imgObj[102] = this.createImage("/block.png");
                    break;
                }
                case 6: {
                    if (this.stageNumber == 3) break;
                    this.m_imgObj[101] = this.createImage("/fire.png");
                    this.m_imgObj[49] = this.createImage("/imo.png");
                    this.m_imgObj[50] = this.createImage("/brobo.png");
                    this.m_imgObj[51] = this.createImage("/buta.png");
                }
                case 7: 
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private boolean SaveRecordStore(byte[] byArray, String string) {
        RecordStore recordStore = null;
        try {
            this.deleteRecordStore(string);
            recordStore = RecordStore.openRecordStore((String)string, (boolean)true);
            recordStore.addRecord(byArray, 0, byArray.length);
            recordStore.closeRecordStore();
        }
        catch (Throwable throwable) {
            try {
                recordStore.closeRecordStore();
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
            return false;
        }
        return true;
    }

    private void deleteRecordStore(String string) {
        RecordStore recordStore = null;
        try {
            try {
                recordStore = RecordStore.openRecordStore((String)string, (boolean)false);
                recordStore.closeRecordStore();
                RecordStore.deleteRecordStore((String)string);
            }
            catch (Throwable throwable) {
                try {
                    recordStore.closeRecordStore();
                }
                catch (Throwable throwable2) {
                    // empty catch block
                }
            }
            recordStore.closeRecordStore();
        }
        catch (Throwable throwable) {
            try {
                recordStore.closeRecordStore();
            }
            catch (Throwable throwable3) {
                // empty catch block
            }
        }
    }

    private byte[] LoadRecordStore(String string) {
        RecordStore recordStore = null;
        byte[] byArray = null;
        try {
            recordStore = RecordStore.openRecordStore((String)string, (boolean)false);
            byArray = new byte[recordStore.getRecordSize(1)];
            recordStore.getRecord(1, byArray, 0);
            recordStore.closeRecordStore();
        }
        catch (Throwable throwable) {
            try {
                recordStore.closeRecordStore();
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
        }
        return byArray;
    }

    private int GetDrawRot(int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 1: {
                return 5;
            }
            case 2: {
                return 3;
            }
            case 3: 
        }
        return 6;
    }

    private boolean _CharaDefault(int[] nArray) {
        if (nArray[14] == 0) {
            nArray[5] = 0;
            nArray[6] = 0;
            nArray[7] = 0;
            nArray[10] = 0;
            nArray[11] = 0;
            nArray[12] = nArray[2] * 100;
            nArray[13] = nArray[3] * 100;
            nArray[15] = -1;
            nArray[16] = nArray[2];
            nArray[17] = nArray[3];
            nArray[14] = nArray[14] + 1;
        }
        if (nArray[5] > 0) {
            nArray[5] = nArray[5] - 1;
        }
        nArray[6] = nArray[6] + 1;
        if (nArray[7] > 0) {
            nArray[7] = nArray[7] - 1;
        }
        return false;
    }

    private void AraiMoveStand(int[] nArray) {
        this.AraiMoveStand(nArray, (objectSizeTbl[nArray[1]][1] >> 1) - 2);
    }

    private void AraiMoveStand(int[] nArray, int n) {
        int n2 = nArray[3];
        int n3 = n2 + n;
        if (n2 < 99999) {
            ++n2;
        }
        if (this.blockColChk_Enemy(nArray[2], n3)) {
            n3 = (n2 -= 2) + n;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        nArray[3] = n2;
    }

    private void AraiDirChangeX(int[] nArray) {
        nArray[19] = nArray[19] == 0 ? 1 : 0;
    }

    private int GetEnemyFloorY(int n, int n2, int n3) {
        int n4 = n2 + n3;
        if (this.blockColChk_Enemy(n, n4)) {
            for (int i = 0; i < 8 && this.blockColChk_Enemy(n, --n4); ++i) {
            }
        } else {
            for (int i = 0; i < 8 && !this.blockColChk_Enemy(n, n4 + 1); ++i) {
                ++n4;
            }
        }
        if ((n4 -= n3) < 0) {
            n4 = 0;
        }
        return n4;
    }

    private boolean CheckSlide(int n, int n2, int n3, int n4, int n5) {
        if (n5 == 0) {
            if (n - n3 - 1 < 0) {
                return true;
            }
            if (this.blockColChk_Enemy(n - n3 - 1, n2 - 12)) {
                return true;
            }
            if (!this.blockColChk_Enemy(n - n3 - 1, n2 + n4 + 10)) {
                return true;
            }
        } else {
            if (this.blockColChk_Enemy(n + n3 + 1, n2 - 12)) {
                return true;
            }
            if (!this.blockColChk_Enemy(n + n3 + 1, n2 + n4 + 10)) {
                return true;
            }
        }
        return false;
    }

    private boolean CheckSlideInverse(int n, int n2, int n3, int n4, int n5) {
        if (n5 == 0) {
            if (n - n3 - 1 < 0) {
                return true;
            }
            if (this.blockColChk_Enemy(n - n3 - 1, n2 - 8)) {
                return true;
            }
            if (!this.blockColChk_Enemy(n - n3 - 1, n2 - n4 - 12)) {
                return true;
            }
        } else {
            if (this.blockColChk_Enemy(n + n3 + 1, n2 - 8)) {
                return true;
            }
            if (!this.blockColChk_Enemy(n + n3 + 1, n2 - n4 - 12)) {
                return true;
            }
        }
        return false;
    }

    boolean AraiCheckSlide(int[] nArray) {
        int n = objectSizeTbl[nArray[1]][0] >> 1;
        int n2 = objectSizeTbl[nArray[1]][1] >> 1;
        return this.CheckSlide(nArray[2], nArray[3], n, n2, nArray[19] & 1);
    }

    boolean AraiCheckInside(int[] nArray, int n, int n2) {
        int n3 = this.PlayerPosX();
        int n4 = this.PlayerPosY() - (PlayerBall ? 16 : 20);
        if (nArray[3] - n2 > n4 || n4 > nArray[3] + n2) {
            return false;
        }
        switch (nArray[19]) {
            case 0: {
                if (nArray[2] - n >= n3 || n3 >= nArray[2]) break;
                return true;
            }
            case 1: {
                if (nArray[2] >= n3 || n3 >= nArray[2] + n) break;
                return true;
            }
        }
        return false;
    }

    private boolean IsFarDistance(int n, int n2) {
        return Math.abs(n - this.PlayerPosX()) > 240 || Math.abs(n2 - this.PlayerPosY()) > 240;
    }

    private boolean IsDistance(int n, int n2, int n3) {
        int n4 = n - this.PlayerPosX();
        int n5 = n2 - (this.PlayerPosY() - (PlayerBall ? 16 : 20));
        return n4 * n4 + n5 * n5 < n3 * n3;
    }

    private boolean DebugNearCheck(int n, int n2) {
        return Math.abs(n - this.PlayerPosX()) < 160 && Math.abs(n2 - this.PlayerPosY()) < 120;
    }

    private int IsHitSonic(int n, int n2, int n3, int n4, boolean bl) {
        if (PlayerJump && PlayerDamage) {
            return 0;
        }
        int n5 = 12;
        int n6 = PlayerBall || PlayerCrouch ? 12 : 16;
        int n7 = this.PlayerPosX();
        int n8 = this.PlayerPosY() - n6;
        int n9 = (n3 >> 1) + n5;
        int n10 = (n4 >> 1) + n6;
        if (PlayerBall) {
            if (n7 - n9 < n && n < n7 + n9 && n8 - n10 < n2 && n2 < n8 + n10) {
                if (mutekicount > 0) {
                    return 1;
                }
                if (bl) {
                    return 1;
                }
                return 2;
            }
        } else if (n7 - n9 < n && n < n7 + n9 && n8 - n10 < n2 && n2 < n8 + n10) {
            if (mutekicount > 0) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    private boolean AraiCharaHitCheck(int[] nArray) {
        if (debugFlag) {
            return false;
        }
        short s = objectSizeTbl[nArray[1]][0];
        short s2 = objectSizeTbl[nArray[1]][1];
        int n = this.IsHitSonic(nArray[2], nArray[3], s, s2, true);
        if (nArray[1] == 71 && n == 1) {
            if (nArray[3] - 4 > this.PlayerPosY() - 16) {
                n = 2;
            }
        } else if (nArray[1] == 50 && n == 1) {
            n = 2;
        }
        if (n == 1) {
            if (PlayerParam[5] > 0) {
                int n2 = MainCanvas.PlayerParam[5] = PlayerParam[5] > 2560 ? -2560 : -PlayerParam[5];
            }
            if (comboScore == 0) {
                comboScore = 100;
            } else if (comboScore == 100) {
                comboScore = 200;
            } else if (comboScore == 200) {
                comboScore = 500;
            } else if (comboScore == 500) {
                comboScore = 1000;
            }
            this.addScoreCount(comboScore);
            this.ShotScore(nArray[2], nArray[3], comboScore);
            this.SetObj2(2, nArray[2], nArray[3], 0, 0, 0, 0);
            this.SetObj2(friendTbl[this.zoneNumber][this.rnd(2)], nArray[2], nArray[3], 0, -300, 0, 0);
            nArray[0] = 0;
            return true;
        }
        if (n == 2) {
            this.playdamageset();
            return false;
        }
        return false;
    }

    private void AraiMoveTest(int[] nArray) {
        int n;
        int n2 = n = nArray[19] == 0 ? -1 : 1;
        if (this._CharaDefault(nArray)) {
            return;
        }
        nArray[15] = this.animeTimer;
        nArray[2] = nArray[2] + n;
        this.AraiMoveStand(nArray);
        if (this.AraiCheckSlide(nArray) || nArray[6] > 180) {
            this.AraiDirChangeX(nArray);
            nArray[6] = 0;
        }
    }

    private void sisoo_shot_tama(int n, int n2) {
        if (objectData[12] == 1) {
            if (n2 == 0) {
                MainCanvas.objectData[10] = (objectData[6] >> 8) - objectData[2] >= 0 ? -276 : 276;
                MainCanvas.objectData[11] = -2072;
            } else if (n2 == 1) {
                MainCanvas.objectData[10] = (objectData[6] >> 8) - objectData[2] >= 0 ? -204 : 204;
                MainCanvas.objectData[11] = -2800;
            } else if (n2 == 2) {
                MainCanvas.objectData[10] = (objectData[6] >> 8) - objectData[2] >= 0 ? -160 : 160;
                MainCanvas.objectData[11] = -3584;
            }
            MainCanvas.objectData[12] = 0;
            objectData[7] = objectData[7] - 9216;
            MainCanvas.objectData[18] = 1;
        }
    }

    private void sleep(int n) {
    }

    private void sisoo_nflag_move_arai(int n) {
        int n2;
        int n3 = 40;
        int n4 = 21;
        boolean bl = false;
        if (objectData[6] == 0 && objectData[7] == 0) {
            MainCanvas.objectData[6] = objectData[8] + 32 << 8;
            MainCanvas.objectData[7] = objectData[3] - n4 - 4 + 20 << 8;
            if (objectData[4] != 255) {
                MainCanvas.objectData[12] = 1;
            }
        }
        int[] nArray = new int[]{objectData[6] >> 8, objectData[7] >> 8};
        if (objectData[4] == 255 && objectData[13] == 1) {
            if (objectData[14] > 0) {
                objectData[14] = objectData[14] - 1;
            } else if (objectData[12] != 0) {
                if (objectData[18] == 0) {
                    this.ShotBomb(objectData[6] >> 8, objectData[7] >> 8);
                } else {
                    this.SetObj2(3, objectData[6] >> 8, objectData[7] >> 8, 0, 0, 0, 0);
                }
                MainCanvas.objectData[13] = 0;
                MainCanvas.objectData[12] = 0;
                MainCanvas.objectData[18] = 0;
            }
        }
        if ((n2 = 47 - (Math.abs(this.PlayerPosX() - objectData[2]) >> 1)) < 0) {
            n2 = 0;
        }
        int n5 = objectData[3] + sisootbl[n2] - 16;
        if (objectData[5] == 1) {
            int n6 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 0, 12, objectData[2], objectData[3], objectData[2], objectData[3], n3 + 12, n4);
            if (n6 >= 0) {
                if (Math.abs(this.PlayerPosX() - objectData[2]) < 8) {
                    MainCanvas.PlayerParam[1] = objectData[3] - n4 << 8;
                    this.sisoo_shot_tama(n, 0);
                    this.playerRaidOn(objectData[20]);
                } else if (this.PlayerPosX() > objectData[2]) {
                    MainCanvas.PlayerParam[1] = objectData[3] + sisootbl[n2] - 16 << 8;
                    MainCanvas.objectData[5] = 0;
                    this.sisoo_shot_tama(n, 0);
                    this.playerRaidOn(objectData[20]);
                } else {
                    MainCanvas.PlayerParam[1] = objectData[3] + sisootbl[n2] - 16 << 8;
                    MainCanvas.objectData[5] = 2;
                    this.sisoo_shot_tama(n, 0);
                    this.playerRaidOn(objectData[20]);
                }
            }
            if (raidOn && raidObjectNum == objectData[20] && n6 != 0) {
                raidOn = false;
            }
        } else if (raidOn && raidObjectNum == objectData[20]) {
            if (objectData[2] - n3 - 10 < this.PlayerPosX() && objectData[2] + n3 + 10 > this.PlayerPosX()) {
                if (Math.abs(this.PlayerPosX() - objectData[2]) < 8) {
                    MainCanvas.PlayerParam[1] = objectData[3] - n4 << 8;
                    if (objectData[5] != 1) {
                        this.sisoo_shot_tama(n, 0);
                    }
                    MainCanvas.objectData[5] = 1;
                    this.playerRaidOn(objectData[20]);
                } else if (objectData[2] < this.PlayerPosX()) {
                    MainCanvas.PlayerParam[1] = objectData[3] - 16 + sisootbl[n2] << 8;
                    if (objectData[5] != 0) {
                        if (PlayerParam[5] >= 2560) {
                            this.sisoo_shot_tama(n, 2);
                        } else {
                            this.sisoo_shot_tama(n, 1);
                        }
                    }
                    MainCanvas.objectData[5] = 0;
                    this.playerRaidOn(objectData[20]);
                } else {
                    MainCanvas.PlayerParam[1] = objectData[3] - 16 + sisootbl[n2] << 8;
                    if (objectData[5] != 2) {
                        if (PlayerParam[5] >= 2560) {
                            this.sisoo_shot_tama(n, 2);
                        } else {
                            this.sisoo_shot_tama(n, 1);
                        }
                    }
                    MainCanvas.objectData[5] = 2;
                    this.playerRaidOn(objectData[20]);
                }
            } else {
                raidOn = false;
            }
        } else if (objectData[2] - n3 - 10 < this.PlayerPosX() && objectData[2] + n3 + 10 > this.PlayerPosX()) {
            if (Math.abs(this.PlayerPosX() - objectData[2]) < 8) {
                n5 = objectData[3] - n4;
                if (n5 > ploldpos[1] && n5 <= this.PlayerPosY()) {
                    MainCanvas.PlayerParam[1] = (n5 << 8) - 1;
                    this.sisoo_shot_tama(n, 0);
                    MainCanvas.objectData[5] = 1;
                    this.playerRaidOn(objectData[20]);
                }
            } else if (objectData[2] < this.PlayerPosX()) {
                n5 = objectData[5] == 0 ? objectData[3] - 16 + sisootbl[n2] : (objectData[5] == 2 ? objectData[3] - 16 - sisootbl[n2] : objectData[3] - n4);
                if (n5 >= ploldpos[1] && n5 <= this.PlayerPosY()) {
                    MainCanvas.PlayerParam[1] = objectData[3] - 16 + sisootbl[n2] << 8;
                    if (objectData[5] != 0) {
                        if (PlayerParam[5] >= 2560) {
                            this.sisoo_shot_tama(n, 2);
                        } else {
                            this.sisoo_shot_tama(n, 1);
                        }
                    }
                    MainCanvas.objectData[5] = 0;
                    this.playerRaidOn(objectData[20]);
                }
            } else {
                n5 = objectData[5] == 0 ? objectData[3] - 16 - sisootbl[n2] : (objectData[5] == 2 ? objectData[3] - 16 + sisootbl[n2] : objectData[3] - n4);
                if (n5 > ploldpos[1] && n5 <= this.PlayerPosY()) {
                    MainCanvas.PlayerParam[1] = objectData[3] - 16 + sisootbl[n2] << 8;
                    if (objectData[5] != 2) {
                        if (PlayerParam[5] >= 2560) {
                            this.sisoo_shot_tama(n, 2);
                        } else {
                            this.sisoo_shot_tama(n, 1);
                        }
                        MainCanvas.objectData[5] = 2;
                    }
                    this.playerRaidOn(objectData[20]);
                }
            }
        }
        if (objectData[4] == 255 && objectData[13] == 0) {
            return;
        }
        int[] nArray2 = new int[2];
        if (objectData[12] == 0) {
            objectData[11] = objectData[11] + gravity;
            if (objectData[2] - n3 << 8 >= objectData[6]) {
                MainCanvas.objectData[6] = objectData[2] - n3 + 1 << 8;
                MainCanvas.objectData[10] = 0;
            } else if (objectData[2] + n3 << 8 <= objectData[6]) {
                MainCanvas.objectData[6] = objectData[2] + n3 - 1 << 8;
                MainCanvas.objectData[10] = 0;
            }
            objectData[6] = objectData[6] + objectData[10];
            objectData[7] = objectData[7] + objectData[11];
        }
        nArray2[0] = objectData[6] >> 8;
        nArray2[1] = objectData[7] >> 8;
        n2 = 47 - (Math.abs(nArray2[0] - objectData[2]) >> 1);
        if (n2 < 0) {
            n2 = 0;
        }
        n5 = objectData[3] - sisootbl[n2] - 16;
        if (objectData[12] == 0 && objectData[11] > 0) {
            if (objectData[5] == 1) {
                if (objectData[2] - n3 < nArray2[0] && objectData[2] + n3 > nArray2[0] && objectData[3] - 16 <= nArray2[1]) {
                    MainCanvas.objectData[5] = nArray2[0] >= objectData[2] ? 0 : 2;
                    MainCanvas.objectData[7] = objectData[3] - n4 - 4 + 20 << 8;
                    MainCanvas.objectData[12] = 1;
                    if (raidOn && raidObjectNum == objectData[20]) {
                        MainCanvas.PlayerParam[3] = 0;
                        MainCanvas.PlayerParam[5] = -objectData[11];
                        PlayerJump = true;
                        PlayerAir = true;
                        PlayerDamage = false;
                        if (objectData[4] == 255) {
                            PlayerBall = true;
                            PlayerSJump = false;
                        } else {
                            PlayerBall = false;
                            PlayerSJump = true;
                        }
                        raidOn = false;
                    }
                    MainCanvas.objectData[10] = 0;
                    MainCanvas.objectData[11] = 0;
                }
            } else if (objectData[2] - n3 < nArray2[0] && objectData[2] + n3 > nArray2[0]) {
                if (objectData[2] < nArray2[0]) {
                    n5 = objectData[5] == 2 ? objectData[3] - 16 - sisootbl[n2] : objectData[3] - 16 + sisootbl[n2];
                    if (n5 <= nArray2[1]) {
                        MainCanvas.objectData[7] = objectData[3] - n4 - 4 + 20 << 8;
                        MainCanvas.objectData[12] = 1;
                        if (objectData[5] != 0 && raidOn && raidObjectNum == objectData[20]) {
                            MainCanvas.PlayerParam[3] = 0;
                            MainCanvas.PlayerParam[5] = -objectData[11];
                            PlayerJump = true;
                            if (objectData[4] == 255) {
                                PlayerBall = true;
                                PlayerSJump = false;
                            } else {
                                PlayerBall = false;
                                PlayerSJump = true;
                            }
                            PlayerDamage = false;
                            PlayerAir = true;
                            raidOn = false;
                        }
                        MainCanvas.objectData[5] = 0;
                        MainCanvas.objectData[10] = 0;
                        MainCanvas.objectData[11] = 0;
                    }
                } else {
                    n5 = objectData[5] == 0 ? objectData[3] - 16 - sisootbl[n2] : objectData[3] - 16 + sisootbl[n2];
                    if (n5 <= nArray2[1]) {
                        MainCanvas.objectData[7] = objectData[3] - n4 - 4 + 20 << 8;
                        MainCanvas.objectData[12] = 1;
                        if (objectData[5] != 2 && raidOn && raidObjectNum == objectData[20]) {
                            MainCanvas.PlayerParam[5] = -objectData[11];
                            MainCanvas.PlayerParam[3] = 0;
                            PlayerJump = true;
                            if (objectData[4] == 255) {
                                PlayerBall = true;
                                PlayerSJump = false;
                            } else {
                                PlayerBall = false;
                                PlayerSJump = true;
                            }
                            PlayerDamage = false;
                            PlayerAir = true;
                            raidOn = false;
                        }
                        MainCanvas.objectData[5] = 2;
                        MainCanvas.objectData[10] = 0;
                        MainCanvas.objectData[11] = 0;
                    }
                }
            } else {
                MainCanvas.objectData[12] = 0;
            }
        }
        if (this.IsHitSonic(objectData[6] >> 8, objectData[7] >> 8, 12, 12, false) != 0) {
            if (raidOn && raidObjectNum == objectData[20]) {
                raidOn = false;
            }
            this.playdamageset();
        }
    }

    private void kamere_sflag_move_arai(int n) {
        int n2;
        int[] nArray = objectData;
        int n3 = nArray[19];
        int n4 = n2 = n3 == 0 ? -2 : 2;
        if (this._CharaDefault(nArray)) {
            return;
        }
        int n5 = nArray[2];
        int n6 = nArray[3];
        switch (nArray[14]) {
            default: {
                nArray[15] = -1;
                nArray[14] = 1;
                break;
            }
            case 1: {
                if (Math.abs(this.PlayerPosX() - nArray[2]) >= 50) break;
                nArray[5] = 30;
                nArray[15] = 0;
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 2: {
                nArray[19] = this.PlayerPosX() > nArray[2] ? 1 : 0;
                if (nArray[5] > 0) break;
                nArray[5] = 48;
                nArray[15] = 1;
                if (nArray[4] == 1) {
                    nArray[14] = 6;
                    break;
                }
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 3: {
                this.AraiMoveStand(nArray);
                if (nArray[5] > 0) break;
                nArray[5] = 8;
                nArray[15] = 2;
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 4: {
                this.AraiMoveStand(nArray);
                if (nArray[5] > 0) break;
                nArray[5] = 8;
                nArray[15] = 3;
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 5: {
                nArray[2] = nArray[2] + n2;
                this.AraiMoveStand(nArray);
                nArray[15] = 4 + (this.animeTimer & 1);
                break;
            }
            case 6: {
                if (nArray[5] > 0) break;
                this.ShotObj2(7, nArray[2], nArray[3], n3 == 0 ? 270 : 90, 150, 0);
                nArray[5] = 60;
                nArray[14] = nArray[14] + 1;
            }
            case 7: {
                if (nArray[5] > 0) break;
                nArray[15] = 0;
                nArray[5] = 10;
                nArray[14] = nArray[14] + 1;
            }
            case 8: {
                if (nArray[5] > 0) break;
                nArray[14] = nArray[14] + 1;
            }
            case 9: {
                nArray[15] = -1;
            }
        }
        if (nArray[14] >= 3 && nArray[14] <= 7) {
            this.AraiCharaHitCheck(nArray);
        }
    }

    private void hachi_sflag_move_arai(int n) {
        int n2;
        int[] nArray = objectData;
        int n3 = nArray[19];
        int n4 = n2 = n3 == 0 ? -2 : 2;
        if (this._CharaDefault(nArray)) {
            return;
        }
        int n5 = nArray[2];
        int n6 = nArray[3];
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
                break;
            }
            case 1: {
                nArray[18] = 0;
                nArray[14] = nArray[14] + 1;
            }
            case 2: {
                nArray[18] = 0;
                if (nArray[6] > 440) {
                    nArray[19] = nArray[19] == 0 ? 1 : 0;
                    nArray[6] = 0;
                }
                if (this.AraiCheckInside(nArray, 160, 100)) {
                    nArray[5] = 20;
                    nArray[14] = 3;
                }
                nArray[2] = nArray[2] + n2;
                nArray[15] = this.animeTimer & 1;
                break;
            }
            case 3: {
                nArray[6] = nArray[6] - 1;
                nArray[15] = 2 + (this.animeTimer & 1);
                if (nArray[5] > 0) break;
                nArray[5] = 90;
                nArray[14] = nArray[14] + 1;
            }
            case 4: {
                nArray[6] = nArray[6] - 1;
                nArray[15] = 4 + (this.animeTimer & 1);
                if (nArray[5] == 16) {
                    nArray[18] = 1;
                } else if (nArray[5] == 8) {
                    nArray[18] = 2;
                }
                if (nArray[5] > 0) break;
                nArray[18] = 0;
                this.ShotObj2(7, nArray[2] + (n3 == 0 ? -18 : 18), nArray[3] + 24, n3 == 0 ? 210 : 150, 150, 0);
                nArray[5] = 30;
                nArray[14] = nArray[14] + 1;
            }
            case 5: {
                nArray[6] = nArray[6] - 1;
                if (nArray[5] > 0) break;
                nArray[14] = nArray[14] + 1;
            }
            case 6: {
                nArray[2] = nArray[2] + n2;
                nArray[15] = this.animeTimer & 1;
                if (nArray[6] <= 480) break;
                nArray[14] = 2;
            }
        }
        this.AraiCharaHitCheck(nArray);
    }

    private void musi_sflag_move_arai(int n) {
        int[] nArray = objectData;
        int n2 = nArray[19];
        int n3 = n2 == 0 ? -1 : 1;
        boolean bl = false;
        if (Math.abs(nArray[2] - this.PlayerPosX()) > 240 && Math.abs(nArray[3] - this.PlayerPosY()) > 168) {
            return;
        }
        if (this._CharaDefault(nArray)) {
            return;
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[14] = nArray[14] + 1;
            }
            case 2: {
                nArray[15] = (this.animeTimer >> 1) % 3;
                nArray[2] = nArray[2] + n3;
                this.AraiMoveStand(nArray);
                if (this.AraiCheckSlide(nArray)) {
                    nArray[5] = 60;
                    nArray[14] = nArray[14] + 1;
                }
                if ((this.animeTimer & 7) != 0) break;
                this.SetObj2(15, nArray[2] - n3 * 20, nArray[3] - 2, 0, 0, 0, 0);
                break;
            }
            case 3: {
                if (nArray[5] > 0) break;
                this.AraiDirChangeX(nArray);
                nArray[6] = 0;
                nArray[14] = nArray[14] - 1;
            }
        }
        this.AraiCharaHitCheck(nArray);
    }

    private void imo_sflag_move_arai(int n) {
        int n2;
        int[] nArray = objectData;
        int n3 = n2 = nArray[19] == 0 ? -1 : 1;
        if (Math.abs(nArray[2] - this.PlayerPosX()) > 240 && Math.abs(nArray[3] - this.PlayerPosY()) > 168) {
            return;
        }
        nArray[5] = nArray[5] + 1;
        if (this.IsFarDistance(nArray[2], nArray[3])) {
            nArray[18] = 0;
            return;
        }
        if (nArray[18] == 3 || nArray[18] == 4) {
            if (this.CheckSlide(nArray[6] >> 8, nArray[7] >> 8, 8, 8, nArray[8] == -1 ? 0 : 1)) {
                nArray[8] = nArray[8] == 1 ? -1 : 1;
            }
            if (this.CheckSlide(nArray[9] >> 8, nArray[10] >> 8, 8, 8, nArray[11] == -1 ? 0 : 1)) {
                nArray[11] = nArray[11] == 1 ? -1 : 1;
            }
            if (this.CheckSlide(nArray[12] >> 8, nArray[13] >> 8, 8, 8, nArray[14] == -1 ? 0 : 1)) {
                nArray[14] = nArray[14] == 1 ? -1 : 1;
            }
            if (this.CheckSlide(nArray[15] >> 8, nArray[16] >> 8, 8, 8, nArray[17] == -1 ? 0 : 1)) {
                nArray[17] = nArray[17] == 1 ? -1 : 1;
            }
        }
        switch (nArray[18]) {
            default: {
                nArray[18] = 1;
            }
            case 1: {
                nArray[5] = 0;
                nArray[6] = nArray[2] << 8;
                nArray[7] = nArray[3] << 8;
                nArray[8] = n2;
                nArray[9] = nArray[6] + (-n2 * 12 << 8);
                nArray[10] = nArray[7];
                nArray[11] = n2;
                nArray[12] = nArray[9] + (-n2 * 12 << 8);
                nArray[13] = nArray[10];
                nArray[14] = n2;
                nArray[15] = nArray[12] + (-n2 * 12 << 8);
                nArray[16] = nArray[13];
                nArray[17] = n2;
                nArray[18] = nArray[18] + 1;
            }
            case 2: {
                nArray[7] = this.GetEnemyFloorY(nArray[6] >> 8, nArray[7] >> 8, 8) << 8;
                nArray[10] = this.GetEnemyFloorY(nArray[9] >> 8, nArray[10] >> 8, 8) << 8;
                nArray[13] = this.GetEnemyFloorY(nArray[12] >> 8, nArray[13] >> 8, 8) << 8;
                nArray[16] = this.GetEnemyFloorY(nArray[15] >> 8, nArray[16] >> 8, 8) << 8;
                if (nArray[5] < 8) break;
                nArray[5] = 0;
                nArray[18] = nArray[18] + 1;
                break;
            }
            case 3: {
                nArray[6] = nArray[6] + 0 * nArray[8];
                nArray[9] = nArray[9] + 32 * nArray[11];
                nArray[12] = nArray[12] + 64 * nArray[14];
                nArray[15] = nArray[15] + 96 * nArray[17];
                if (nArray[5] < 32) break;
                nArray[18] = nArray[18] + 1;
                break;
            }
            case 4: {
                nArray[6] = nArray[6] + 96 * nArray[8];
                nArray[9] = nArray[9] + 64 * nArray[11];
                nArray[12] = nArray[12] + 32 * nArray[14];
                nArray[15] = nArray[15] + 0 * nArray[17];
                if (nArray[5] < 64) break;
                nArray[18] = nArray[18] + 1;
                break;
            }
            case 5: {
                if (nArray[8] == nArray[11] && nArray[11] == nArray[14] && nArray[14] == nArray[17]) {
                    nArray[9] = nArray[6] + (-nArray[8] * 12 << 8);
                    nArray[12] = nArray[9] + (-nArray[8] * 12 << 8);
                    nArray[15] = nArray[12] + (-nArray[8] * 12 << 8);
                }
                nArray[5] = 0;
                nArray[18] = 3;
            }
        }
        nArray[7] = this.GetEnemyFloorY(nArray[6] >> 8, nArray[7] >> 8, 8) << 8;
        nArray[10] = this.GetEnemyFloorY(nArray[9] >> 8, nArray[10] >> 8, 8) << 8;
        nArray[13] = this.GetEnemyFloorY(nArray[12] >> 8, nArray[13] >> 8, 8) << 8;
        nArray[16] = this.GetEnemyFloorY(nArray[15] >> 8, nArray[16] >> 8, 8) << 8;
        if (nArray[7] + 4096 < nArray[10]) {
            nArray[10] = nArray[7];
        }
        if (Math.abs(nArray[8] - nArray[11]) > 3072) {
            nArray[11] = nArray[11] + (nArray[8] << 8);
        }
        if (nArray[7] + 4096 < nArray[13]) {
            nArray[13] = nArray[7];
        }
        if (Math.abs(nArray[8] - nArray[14]) > 3072) {
            nArray[14] = nArray[14] + (nArray[8] << 8);
        }
        if (nArray[7] + 4096 < nArray[16]) {
            nArray[16] = nArray[7];
        }
        if (Math.abs(nArray[8] - nArray[17]) > 3072) {
            nArray[17] = nArray[17] + (nArray[8] << 8);
        }
        nArray[2] = nArray[6] >> 8;
        nArray[3] = nArray[7] >> 8;
        if (!this.AraiCharaHitCheck(nArray)) {
            boolean bl = false;
            boolean bl2 = bl = bl || this.IsHitSonic(nArray[12] >> 8, nArray[13] >> 8, 22, 10, false) != 0;
            if (bl) {
                this.ShotObj2(14, nArray[2], nArray[3], 30 * n2 + 360, 300, 0);
                this.ShotObj2(14, nArray[9] >> 8, nArray[10] >> 8, 15 * n2 + 360, 300, 1);
                this.ShotObj2(14, nArray[12] >> 8, nArray[13] >> 8, -15 * n2 + 360, 300, 1);
                this.ShotObj2(14, nArray[15] >> 8, nArray[16] >> 8, -30 * n2 + 360, 300, 1);
                nArray[0] = 0;
                this.playdamageset();
            }
        }
    }

    private void brobo_sflag_move_arai(int n) {
        int n2;
        int[] nArray = objectData;
        int n3 = n2 = nArray[19] == 0 ? -1 : 1;
        if (Math.abs(nArray[2] - this.PlayerPosX()) > 360 && Math.abs(nArray[3] - this.PlayerPosY()) > 360) {
            return;
        }
        if (this._CharaDefault(nArray)) {
            return;
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[5] = 121;
                nArray[6] = 0;
                nArray[18] = nArray[19] == 2 ? 1 : 0;
                nArray[14] = nArray[14] + 1;
            }
            case 2: {
                nArray[5] = 121;
                nArray[15] = this.animeTimer >> 3;
                if (nArray[18] == 0) {
                    this.AraiMoveStand(nArray, 18);
                    if ((this.cpuTimer & 0xF) == 0) {
                        nArray[2] = nArray[2] + n2;
                    }
                    if (this.AraiCheckSlide(nArray) || nArray[6] > 600) {
                        this.AraiDirChangeX(nArray);
                        nArray[6] = 0;
                    }
                } else {
                    if (this.blockColChk_Enemy(nArray[2], nArray[3] - 18)) {
                        nArray[3] = nArray[3] + 1;
                    }
                    if (this.CheckSlideInverse(nArray[2], nArray[3], 12, 18, nArray[19]) || nArray[6] > 600) {
                        nArray[19] = nArray[19] == 0 ? 1 : 0;
                        nArray[6] = 0;
                    }
                    if ((this.cpuTimer & 0xF) == 0) {
                        nArray[2] = nArray[2] + n2;
                    }
                }
                if (Math.abs(nArray[2] - this.PlayerPosX()) >= 100 || Math.abs(nArray[3] - (this.PlayerPosY() - 12)) >= 100) break;
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 3: {
                if (nArray[5] > 0) break;
                this.ShotObj2(13, nArray[2], nArray[3], 30, 300, 0);
                this.ShotObj2(13, nArray[2], nArray[3], 30, 200, 0);
                this.ShotObj2(13, nArray[2], nArray[3], 330, 300, 0);
                this.ShotObj2(13, nArray[2], nArray[3], 330, 200, 0);
                this.SetObj2(1, nArray[2], nArray[3], 0, 0, 0, 0);
                nArray[0] = 0;
            }
        }
        this.AraiCharaHitCheck(nArray);
    }

    private void buta_sflag_move_arai(int n) {
        int n2;
        int[] nArray = objectData;
        int n3 = n2 = nArray[19] == 0 ? -1 : 1;
        if (Math.abs(nArray[2] - this.PlayerPosX()) > 240 && Math.abs(nArray[3] - this.PlayerPosY()) > 168) {
            return;
        }
        if (this._CharaDefault(nArray)) {
            return;
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[8] = 0;
                nArray[5] = 30;
                nArray[14] = nArray[14] + 1;
            }
            case 2: {
                nArray[15] = 0;
                if (nArray[5] > 0) break;
                nArray[5] = 30;
                nArray[14] = nArray[14] + 1;
            }
            case 3: {
                nArray[15] = 1;
                nArray[3] = nArray[17] - 8;
                if (nArray[5] > 0) break;
                nArray[5] = 30;
                nArray[14] = nArray[14] + 1;
            }
            case 4: {
                nArray[15] = 0;
                nArray[3] = nArray[17];
                if (nArray[5] > 0) break;
                nArray[5] = 30;
                nArray[14] = nArray[14] + 1;
            }
            case 5: {
                nArray[15] = 2;
                if (nArray[5] > 0) break;
                nArray[5] = 30;
                nArray[8] = nArray[8] + 1;
                if (nArray[8] > 3) {
                    nArray[14] = nArray[14] + 1;
                    break;
                }
                nArray[14] = 2;
                break;
            }
            case 6: {
                nArray[15] = 3;
                if (nArray[5] == 10) {
                    if (nArray[19] == 0) {
                        this.ShotObj2(10, nArray[2], nArray[3], 345, 300, 0);
                    } else {
                        this.ShotObj2(10, nArray[2], nArray[3], 15, 300, 0);
                    }
                }
                if (nArray[5] > 0) break;
                nArray[8] = 0;
                nArray[14] = 1;
            }
        }
        this.AraiCharaHitCheck(nArray);
    }

    private void kani_sflag_move_arai(int n) {
        int n2;
        int[] nArray = objectData;
        int n3 = n2 = nArray[19] == 0 ? -1 : 1;
        if (Math.abs(nArray[2] - this.PlayerPosX()) > 240 && Math.abs(nArray[3] - this.PlayerPosY()) > 168) {
            return;
        }
        if (this._CharaDefault(nArray)) {
            return;
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[10] = 0;
                nArray[11] = 0;
                nArray[5] = 360;
                nArray[14] = nArray[14] + 1;
            }
            case 2: {
                nArray[15] = (this.animeTimer >> 2) % 3;
                nArray[10] = n2 * 20;
                nArray[12] = nArray[12] + nArray[10];
                nArray[13] = nArray[13] + nArray[11];
                this.AraiStand100x(nArray, 16);
                nArray[2] = nArray[12] / 100;
                nArray[3] = nArray[13] / 100;
                if (this.AraiCheckSlide(nArray) || nArray[6] > 180) {
                    this.AraiDirChangeX(nArray);
                    nArray[6] = 0;
                }
                if (nArray[5] > 0) break;
                nArray[15] = 1;
                nArray[5] = 60;
                nArray[14] = nArray[14] + 1;
            }
            case 3: {
                this.AraiStand100x(nArray, 16);
                if (nArray[5] < 12) {
                    nArray[15] = 3;
                }
                if (nArray[5] > 0) break;
                this.ShotObj2(9, nArray[2] + 16, nArray[3] - 16, 15, 240, 0);
                this.ShotObj2(9, nArray[2] - 16, nArray[3] - 16, 345, 240, 0);
                nArray[5] = 50;
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 4: {
                this.AraiStand100x(nArray, 16);
                if (nArray[5] > 0) break;
                nArray[14] = 1;
            }
        }
        this.AraiCharaHitCheck(nArray);
    }

    private void aruma_sflag_move_arai(int n) {
        int[] nArray = objectData;
        if (this._CharaDefault(nArray)) {
            return;
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[15] = -1;
                nArray[8] = 0;
                nArray[9] = 0;
                nArray[10] = 0;
                nArray[11] = 400;
                nArray[14] = nArray[14] + 1;
            }
            case 2: {
                if (this.PlayerPosX() - 160 < nArray[2]) break;
                nArray[14] = nArray[14] + 1;
            }
            case 3: {
                nArray[10] = 500;
                nArray[11] = 400;
                nArray[15] = 0;
                nArray[5] = 94;
                nArray[14] = nArray[14] + 1;
            }
            case 4: {
                nArray[15] = this.animeTimer & 1;
                nArray[10] = 400;
                if (nArray[9] == 0 && this.CheckSlide(nArray[2], nArray[3], 20, 20, 1)) {
                    nArray[9] = 1;
                    nArray[11] = -800;
                    nArray[5] = 94;
                }
                if (nArray[5] > 0) break;
                nArray[5] = 94;
                nArray[14] = nArray[14] + 1;
            }
            case 5: {
                nArray[10] = 0;
                nArray[11] = 0;
                nArray[15] = 1;
                nArray[5] = 20;
                nArray[14] = nArray[14] + 1;
            }
            case 6: {
                if (nArray[5] > 0) break;
                nArray[15] = 2;
                nArray[5] = 20;
                nArray[14] = nArray[14] + 1;
            }
            case 7: {
                if (nArray[5] > 0) break;
                nArray[15] = 3;
                nArray[5] = 60;
                nArray[14] = nArray[14] + 1;
            }
            case 8: {
                if (nArray[5] > 0) break;
                nArray[15] = 2;
                nArray[5] = 20;
                nArray[14] = nArray[14] + 1;
            }
            case 9: {
                if (nArray[5] > 0) break;
                nArray[15] = 1;
                nArray[5] = 20;
                nArray[14] = nArray[14] + 1;
            }
            case 10: {
                if (nArray[5] > 0) break;
                nArray[5] = 94;
                nArray[14] = 3;
            }
        }
        nArray[11] = nArray[11] + 20;
        if (nArray[11] > 400) {
            nArray[11] = 400;
        }
        nArray[12] = nArray[12] + nArray[10];
        nArray[13] = nArray[13] + nArray[11];
        if (nArray[11] > 0 && this.blockColChk_Enemy(nArray[12] / 100, nArray[13] / 100 + 12)) {
            nArray[9] = 0;
            for (int i = 0; i < 4; ++i) {
                if (this.blockColChk_Enemy(nArray[12] / 100, nArray[13] / 100 + 12)) {
                    // empty if block
                }
                nArray[13] = nArray[13] - 100;
            }
            if (nArray[13] < 0) {
                nArray[13] = 0;
            }
        }
        nArray[2] = nArray[12] / 100;
        nArray[3] = nArray[13] / 100;
        if (nArray[15] >= 0) {
            this.AraiCharaHitCheck(nArray);
        }
    }

    private void yado_sflag_move_arai(int n) {
        int n2;
        int[] nArray = objectData;
        int n3 = n2 = nArray[19] == 0 ? -1 : 1;
        if (Math.abs(nArray[2] - this.PlayerPosX()) > 240 && Math.abs(nArray[3] - this.PlayerPosY()) > 168) {
            return;
        }
        if (this._CharaDefault(nArray)) {
            return;
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[10] = 0;
                nArray[11] = 0;
                nArray[5] = 120;
                nArray[14] = nArray[14] + 1;
            }
            case 2: 
        }
        nArray[15] = (this.animeTimer >> 2) % 3;
        nArray[10] = n2 * 25;
        nArray[12] = nArray[12] + nArray[10];
        nArray[13] = nArray[13] + nArray[11];
        nArray[2] = nArray[12] / 100;
        nArray[3] = nArray[13] / 100;
        this.AraiMoveStand(nArray, 24);
        if (this.AraiCheckSlide(nArray) || nArray[6] > 240) {
            this.AraiDirChangeX(nArray);
            nArray[6] = 0;
        }
        if (nArray[5] <= 0) {
            nArray[15] = 1;
            nArray[5] = 40;
        }
        this.AraiCharaHitCheck(nArray);
    }

    private void uni_sflag_move_arai(int n) {
        int n2;
        int n3;
        int n4;
        boolean bl;
        int[] nArray = objectData;
        int n5 = nArray[19] == 0 ? -1 : 1;
        boolean bl2 = bl = nArray[4] != 2;
        if (Math.abs(nArray[2] - this.PlayerPosX()) > 240 && Math.abs(nArray[3] - this.PlayerPosY()) > 240) {
            return;
        }
        if (this._CharaDefault(nArray)) {
            return;
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[5] = 1800;
                nArray[9] = 0;
                nArray[10] = !bl ? n5 * 20 : 0;
                nArray[18] = 359;
                nArray[11] = 0;
                nArray[15] = !bl ? 0 : 1;
                nArray[14] = nArray[14] + 1;
            }
            case 2: 
        }
        if (bl) {
            nArray[10] = (nArray[9] & 0xF) == 15 ? n5 * 25 : 0;
        }
        if (nArray[5] <= 0) {
            nArray[5] = 1800;
        }
        nArray[12] = nArray[12] + nArray[10];
        nArray[13] = nArray[13] + nArray[11];
        nArray[2] = nArray[12] / 100;
        nArray[3] = nArray[13] / 100;
        if (nArray[19] == 0) {
            nArray[18] = nArray[18] + 1;
            if (nArray[18] > 359) {
                nArray[18] = nArray[18] - 360;
            }
        } else {
            nArray[18] = nArray[18] - 1;
            if (nArray[18] < 0) {
                nArray[18] = nArray[18] + 360;
            }
        }
        if (this.AraiCheckInside(nArray, 100, 50) && bl) {
            nArray[15] = 3;
        }
        if ((nArray[9] & 1) == 0) {
            n4 = nArray[18] % 360;
            n3 = nArray[2] + this.dSin(n4) * 16 / 100;
            if (this.IsHitSonic(n3, n2 = nArray[3] + this.dCos(n4) * 16 / 100, 16, 16, false) != 0) {
                this.playdamageset();
            }
            if (bl && Math.abs(180 - n4) < 4 && this.AraiCheckInside(nArray, 100, 50)) {
                nArray[9] = nArray[9] | 1;
                this.ShotObj2(12, n3, n2, nArray[19] == 0 ? 270 : 90, 80, 0);
            }
        }
        if ((nArray[9] & 2) == 0) {
            n4 = (nArray[18] + 90) % 360;
            n3 = nArray[2] + this.dSin(n4) * 16 / 100;
            if (this.IsHitSonic(n3, n2 = nArray[3] + this.dCos(n4) * 16 / 100, 16, 16, false) != 0) {
                this.playdamageset();
            }
            if (bl && Math.abs(180 - n4) < 4 && this.AraiCheckInside(nArray, 100, 50)) {
                nArray[9] = nArray[9] | 2;
                this.ShotObj2(12, n3, n2, nArray[19] == 0 ? 270 : 90, 80, 0);
            }
        }
        if ((nArray[9] & 4) == 0) {
            n4 = (nArray[18] + 180) % 360;
            n3 = nArray[2] + this.dSin(n4) * 16 / 100;
            if (this.IsHitSonic(n3, n2 = nArray[3] + this.dCos(n4) * 16 / 100, 16, 16, false) != 0) {
                this.playdamageset();
            }
            if (bl && Math.abs(180 - n4) < 4 && this.AraiCheckInside(nArray, 100, 50)) {
                nArray[9] = nArray[9] | 4;
                this.ShotObj2(12, n3, n2, nArray[19] == 0 ? 270 : 90, 80, 0);
            }
        }
        if ((nArray[9] & 8) == 0) {
            n4 = (nArray[18] + 270) % 360;
            n3 = nArray[2] + this.dSin(n4) * 16 / 100;
            if (this.IsHitSonic(n3, n2 = nArray[3] + this.dCos(n4) * 16 / 100, 16, 16, false) != 0) {
                this.playdamageset();
            }
            if (bl && Math.abs(180 - n4) < 4 && this.AraiCheckInside(nArray, 100, 50)) {
                nArray[9] = nArray[9] | 8;
                this.ShotObj2(12, n3, n2, nArray[19] == 0 ? 270 : 90, 80, 0);
            }
        }
        this.AraiCharaHitCheck(nArray);
    }

    private void bat_sflag_move_arai(int n) {
        int n2;
        int[] nArray = objectData;
        int n3 = n2 = nArray[19] == 0 ? -1 : 1;
        if (this._CharaDefault(nArray)) {
            return;
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[15] = 0;
                nArray[19] = this.PlayerPosX() > nArray[2] ? 1 : 0;
                if (nArray[3] + 40 > this.PlayerPosY() || nArray[3] + 100 < this.PlayerPosY() || Math.abs(nArray[2] - this.PlayerPosX()) >= 100) break;
                nArray[9] = this.PlayerPosY() - 16;
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 2: {
                nArray[15] = 1;
                nArray[3] = nArray[3] + 2;
                if (nArray[3] < nArray[9]) break;
                nArray[3] = nArray[9];
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 3: {
                nArray[15] = batAnimTbl[this.animeTimer & 3];
                nArray[2] = nArray[2] + n2;
                if (Math.abs(nArray[2] - this.PlayerPosX()) <= 80) break;
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 4: {
                nArray[15] = batAnimTbl[this.animeTimer & 3];
                nArray[2] = nArray[2] + n2;
                nArray[3] = nArray[3] - 2;
                if (!this.blockColChk_Enemy(nArray[2], nArray[3] - 16)) break;
                nArray[14] = 1;
            }
        }
        this.AraiCharaHitCheck(nArray);
    }

    private boolean AraiStand100x(int[] nArray, int n) {
        int n2 = nArray[13];
        int n3 = n2 / 100;
        int n4 = n3 + n;
        int n5 = (nArray[17] - 240) * 100;
        int n6 = (nArray[17] + 240) * 100;
        boolean bl = false;
        if (n2 < 9999900) {
            n2 += 100;
        }
        if (this.blockColChk_Enemy(nArray[12] / 100, n4)) {
            n2 -= 200;
            nArray[11] = 50;
            bl = true;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        nArray[13] = n2;
        return bl;
    }

    private void mogura_sflag_move_arai(int n) {
        int n2;
        int[] nArray = objectData;
        int n3 = n2 = nArray[19] == 0 ? -8 : 8;
        if (Math.abs(nArray[2] - this.PlayerPosX()) > 240 && Math.abs(nArray[3] - this.PlayerPosY()) > 240) {
            return;
        }
        if (this._CharaDefault(nArray)) {
            return;
        }
        switch (nArray[14]) {
            default: {
                nArray[10] = 0;
                nArray[11] = 0;
                nArray[15] = 0;
                nArray[14] = 1;
                break;
            }
            case 1: {
                nArray[19] = this.PlayerPosX() > nArray[2] ? 1 : 0;
                nArray[15] = 0;
                if (Math.abs(this.PlayerPosX() - nArray[2]) >= 100) break;
                nArray[10] = nArray[19] == 0 ? -50 : 50;
                nArray[11] = -300;
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 2: {
                nArray[11] = nArray[11] + 5;
                if (nArray[11] <= 0) break;
                nArray[5] = 10;
                nArray[14] = nArray[14] + 1;
                break;
            }
            case 3: {
                nArray[15] = nArray[5] > 16 ? 1 : (nArray[5] > 8 || this.blockColChk_Enemy(nArray[2] + n2, nArray[3]) ? 2 : 3 + (this.animeTimer >> 1 & 1));
                if (nArray[6] > 360) {
                    nArray[19] = this.PlayerPosX() > nArray[2] ? 1 : 0;
                }
                this.AraiStand100x(nArray, 16);
                nArray[11] = nArray[11] + 5;
            }
        }
        nArray[12] = nArray[12] + nArray[10];
        nArray[13] = nArray[13] + nArray[11];
        nArray[2] = nArray[12] / 100;
        nArray[3] = nArray[13] / 100;
        this.AraiCharaHitCheck(nArray);
    }

    private void fish_sflag_move_arai(int n) {
        int[] nArray = objectData;
        if (this._CharaDefault(nArray)) {
            return;
        }
        nArray[15] = this.animeTimer & 1;
        nArray[3] = nArray[17] - Math.abs(this.dCos(nArray[6] % 180)) * 268 / 100;
        this.AraiCharaHitCheck(nArray);
    }

    private void fish2_sflag_move_arai(int n) {
        int n2;
        int[] nArray = objectData;
        int n3 = n2 = nArray[19] == 0 ? -1 : 1;
        if (this._CharaDefault(nArray)) {
            return;
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[5] = 480;
                nArray[10] = n2 * 26;
                nArray[11] = 0;
                nArray[14] = nArray[14] + 1;
            }
            case 2: 
        }
        nArray[10] = n2 * 26;
        nArray[15] = this.animeTimer >> 1 & 3;
        if (nArray[5] <= 0) {
            nArray[19] = nArray[19] == 0 ? 1 : 0;
            nArray[5] = 480;
        }
        nArray[12] = nArray[12] + nArray[10];
        nArray[13] = nArray[13] + nArray[11];
        nArray[2] = nArray[12] / 100;
        nArray[3] = nArray[13] / 100;
        this.AraiCharaHitCheck(nArray);
    }

    private void AraiDrawChara(int n, short[][] sArray, int n2) {
        int n3;
        if (n2 < 0) {
            return;
        }
        short s = sArray[n2][0];
        short s2 = sArray[n2][1];
        short s3 = sArray[n2][2];
        short s4 = sArray[n2][3];
        short s5 = sArray[n2][4];
        switch (objectData[19]) {
            default: {
                n3 = 0;
                break;
            }
            case 1: {
                n3 = 2;
                break;
            }
            case 2: {
                n3 = 1;
                break;
            }
            case 3: {
                n3 = 3;
            }
        }
        this.drawRegion(gg, this.m_imgObj[objectData[1]], s, s2, s3, s4, n3, objectData[2] - mapView[0], objectData[3] - mapView[1] + s5, 1 | 2);
    }

    private void AraiDrawChara100x(int n, short[][] sArray, int n2) {
        int n3;
        if (n2 < 0) {
            return;
        }
        short s = sArray[n2][0];
        short s2 = sArray[n2][1];
        short s3 = sArray[n2][2];
        short s4 = sArray[n2][3];
        short s5 = sArray[n2][4];
        switch (objectData[19]) {
            default: {
                n3 = 0;
                break;
            }
            case 1: {
                n3 = 2;
                break;
            }
            case 2: {
                n3 = 1;
                break;
            }
            case 3: {
                n3 = 3;
            }
        }
        this.drawRegion(gg, this.m_imgObj[objectData[1]], s, s2, s3, s4, n3, objectData[2] / 100 - mapView[0], objectData[3] / 100 - mapView[1] + s5, 1 | 2);
    }

    private void sisoo_nflag_draw_arai(int n) {
        int n2 = 0;
        if (objectData[4] == 255) {
            if (objectData[14] < 60) {
                if ((this.animeTimer & 1) == 0) {
                    n2 = 24;
                }
            } else if (objectData[14] < 200 && (this.animeTimer >> 1 & 1) == 0) {
                n2 = 24;
            }
        }
        if (objectData[4] != 255 || objectData[13] == 1) {
            this.drawRegion(gg, this.m_imgObj[23], n2, 80, 24, 24, 0, (objectData[6] >> 8) - mapView[0], (objectData[7] >> 8) - mapView[1], 1 | 2);
        }
        if (objectData[5] == 1) {
            this.drawRegion(gg, this.m_imgObj[23], 0, 56, 96, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] - 16, 1 | 2);
        } else {
            this.drawRegion(gg, this.m_imgObj[23], 0, 0, 96, 56, rotNumTable[TRANS_NONE + (objectData[5] >> 1) * 4], objectData[2] - mapView[0], objectData[3] - mapView[1] - 16, 1 | 2);
        }
        this.drawStringCenter(gg, f, "height:" + ((objectData[7] >> 8) - objectData[3]), objectData[2] - mapView[0] + 40, objectData[3] - mapView[1] + FontPos - 40, false);
    }

    private void kamere_sflag_draw_arai(int n) {
        int n2 = objectData[15] % 6;
        this.AraiDrawChara(n, RectTblKamere, n2);
    }

    private void hachi_sflag_draw_arai(int n) {
        int[] nArray = objectData;
        int n2 = nArray[19] == 0 ? -1 : 1;
        int n3 = nArray[15] % 6;
        this.AraiDrawChara(n, RectTblHachi, n3);
        if (nArray[18] == 1) {
            this.drawRegion(gg, this.m_imgObj[40], 0, 184, 16, 16, nArray[19] == 0 ? 0 : 2, nArray[2] - mapView[0] + n2 * 18, nArray[3] - mapView[1] + 28, 1 | 2);
        } else if (nArray[18] == 2) {
            this.drawRegion(gg, this.m_imgObj[40], 16, 184, 16, 16, nArray[19] == 0 ? 0 : 2, nArray[2] - mapView[0] + n2 * 18, nArray[3] - mapView[1] + 28, 1 | 2);
        }
    }

    private void musi_sflag_draw_arai(int n) {
        int n2 = 0;
        n2 = objectData[15] % 3;
        this.AraiDrawChara(n, RectTblMusi, n2);
    }

    private void imo_sflag_draw_arai(int n) {
        int[] nArray = objectData;
        if (nArray[18] < 1) {
            return;
        }
        int n2 = 2;
        short s = RectTblImo[n2][0];
        short s2 = RectTblImo[n2][1];
        short s3 = RectTblImo[n2][2];
        short s4 = RectTblImo[n2][3];
        int n3 = nArray[18] == 3 ? nArray[5] >> 2 : 8 - (nArray[5] - 30 >> 2);
        this.drawRegion(gg, this.m_imgObj[49], s, s2, s3, s4, nArray[17] == 1 ? 2 : 0, (nArray[15] >> 8) - mapView[0], (nArray[16] >> 8) - mapView[1], 1 | 2);
        this.drawRegion(gg, this.m_imgObj[49], s, s2, s3, s4, nArray[14] == 1 ? 2 : 0, (nArray[12] >> 8) - mapView[0], (nArray[13] >> 8) - mapView[1] - n3, 1 | 2);
        this.drawRegion(gg, this.m_imgObj[49], s, s2, s3, s4, nArray[11] == 1 ? 2 : 0, (nArray[9] >> 8) - mapView[0], (nArray[10] >> 8) - mapView[1], 1 | 2);
        n2 = nArray[18] > 3 ? 1 : 0;
        s = RectTblImo[n2][0];
        s2 = RectTblImo[n2][1];
        s3 = RectTblImo[n2][2];
        s4 = RectTblImo[n2][3];
        short s5 = RectTblImo[n2][4];
        this.drawRegion(gg, this.m_imgObj[49], s, s2, s3, s4, nArray[8] == 1 ? 2 : 0, (nArray[6] >> 8) - mapView[0], (nArray[7] >> 8) - mapView[1] + s5 - n3, 1 | 2);
    }

    private void brobo_sflag_draw_arai(int n) {
        int[] nArray = objectData;
        int n2 = nArray[15] % 5;
        short s = RectTblBrobo[n2][0];
        short s2 = RectTblBrobo[n2][1];
        short s3 = RectTblBrobo[n2][2];
        short s4 = RectTblBrobo[n2][3];
        int n3 = nArray[18] == 0 ? (nArray[19] == 0 ? 0 : 2) : (nArray[19] == 0 ? 1 : 3);
        this.drawRegion(gg, this.m_imgObj[nArray[1]], s, s2, s3, s4, n3, nArray[2] - mapView[0], nArray[3] - mapView[1], 1 | 2);
        if (nArray[5] < 119) {
            n2 = this.animeTimer & 1;
            s = RectTblTama[10 + n2][0];
            s2 = RectTblTama[10 + n2][1];
            s3 = RectTblTama[10 + n2][2];
            s4 = RectTblTama[10 + n2][3];
            int n4 = nArray[18] == 0 ? -6 - nArray[5] / 10 : 6 + nArray[5] / 10;
            this.drawRegion(gg, this.m_imgObj[96], s, s2, s3, s4, nArray[18] == 0 ? 0 : 3, nArray[2] - mapView[0], nArray[3] - mapView[1] + n4, 1 | 2);
        }
    }

    private void buta_sflag_draw_arai(int n) {
        int n2 = objectData[15] % 4;
        this.AraiDrawChara(n, RectTblButa, n2);
    }

    private void kani_sflag_draw_arai(int n) {
        int n2 = objectData[15] % 4;
        this.AraiDrawChara(n, RectTblKani, n2);
    }

    private void aruma_sflag_draw_arai(int n) {
        int n2 = objectData[15] % 4;
        this.AraiDrawChara(n, RectTblAruma, n2);
    }

    private void yado_sflag_draw_arai(int n) {
        int n2 = objectData[15] % 3;
        this.AraiDrawChara(n, RectTblYado, n2);
    }

    private void drawUniToge(int n, int n2, int n3) {
        int n4 = n3 == 0 ? 6 : 7;
        short s = RectTblTama[n4][0];
        short s2 = RectTblTama[n4][1];
        short s3 = RectTblTama[n4][2];
        short s4 = RectTblTama[n4][3];
        this.drawRegion(gg, this.m_imgObj[96], s, s2, s3, s4, 0, n - mapView[0], n2 - mapView[1], 1 | 2);
    }

    private void uni_sflag_draw_arai(int n) {
        int n2;
        int n3;
        int[] nArray = objectData;
        int n4 = n3 = nArray[4] == 2 ? 0 : 1;
        if ((nArray[9] & 1) == 0) {
            n2 = nArray[18] % 360;
            this.drawUniToge(nArray[2] + this.dSin(n2) * 16 / 100, nArray[3] + this.dCos(n2) * 16 / 100, n3);
        }
        if ((nArray[9] & 2) == 0) {
            n2 = nArray[18] + 90;
            this.drawUniToge(nArray[2] + this.dSin(n2) * 16 / 100, nArray[3] + this.dCos(n2) * 16 / 100, n3);
        }
        if ((nArray[9] & 4) == 0) {
            n2 = nArray[18] + 180;
            this.drawUniToge(nArray[2] + this.dSin(n2) * 16 / 100, nArray[3] + this.dCos(n2) * 16 / 100, n3);
        }
        if ((nArray[9] & 8) == 0) {
            n2 = nArray[18] + 270;
            this.drawUniToge(nArray[2] + this.dSin(n2) * 16 / 100, nArray[3] + this.dCos(n2) * 16 / 100, n3);
        }
        int n5 = nArray[15] % 4;
        this.AraiDrawChara(n, RectTblUni, n5);
    }

    private void bat_sflag_draw_arai(int n) {
        int n2 = objectData[15] % 4;
        this.AraiDrawChara(n, RectTblBat, n2);
    }

    private void ochi_nflag_draw_arai(int n) {
    }

    private void yari_sflag_draw_arai(int n) {
    }

    private void mogura_sflag_draw_arai(int n) {
        int n2 = objectData[15] % 5;
        this.AraiDrawChara(n, RectTblMogura, n2);
    }

    private void fish_sflag_draw_arai(int n) {
        int[] nArray = objectData;
        int n2 = nArray[15] % 2;
        this.AraiDrawChara(n, RectTblFish, n2);
    }

    private void fish2_sflag_draw_arai(int n) {
        int n2 = objectData[15] % 4;
        this.AraiDrawChara(n, RectTblFish2, n2);
    }

    private void AddObjectData(int n, int n2, int n3, int n4, int n5) {
        int[] nArray = new int[25];
        if (n < 1) {
            return;
        }
        nArray[0] = 1;
        nArray[1] = n;
        nArray[2] = n2;
        nArray[3] = n3;
        nArray[4] = n4;
        nArray[19] = n5;
        nArray[21] = 1;
        this.addObject(nArray);
    }

    private void InitObj2() {
        obj2Data = new int[50][20];
        for (int i = 0; i < 50; ++i) {
            MainCanvas.obj2Data[i][0] = 0;
        }
    }

    private void ClearObj2() {
        for (int i = 0; i < 50; ++i) {
            MainCanvas.obj2Data[i][0] = 0;
        }
    }

    private void SetObj2(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (n < 1) {
            return;
        }
        for (int i = 0; i < 50; ++i) {
            int[] nArray = obj2Data[i];
            if (nArray[0] > 0) continue;
            for (int j = 4; j < 20; ++j) {
                nArray[j] = 0;
            }
            nArray[0] = 1;
            nArray[1] = n;
            nArray[2] = n2 * 100;
            nArray[3] = n3 * 100;
            nArray[8] = n7;
            nArray[10] = n4;
            nArray[11] = n5;
            nArray[19] = n6;
            return;
        }
    }

    private void SetObj2Ex(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        if (n < 1) {
            return;
        }
        for (int i = 0; i < 50; ++i) {
            int[] nArray = obj2Data[i];
            if (nArray[0] > 0) continue;
            for (int j = 4; j < 20; ++j) {
                nArray[j] = 0;
            }
            nArray[0] = 1;
            nArray[1] = n;
            nArray[2] = n2 * 100;
            nArray[3] = n3 * 100;
            nArray[5] = n9;
            nArray[8] = n7;
            nArray[9] = n8;
            nArray[10] = n4;
            nArray[11] = n5;
            nArray[19] = n6;
            return;
        }
    }

    private void ShotObj2(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n < 1) {
            return;
        }
        for (int i = 0; i < 50; ++i) {
            int[] nArray = obj2Data[i];
            if (nArray[0] > 0) continue;
            for (int j = 4; j < 20; ++j) {
                nArray[j] = 0;
            }
            nArray[0] = 1;
            nArray[1] = n;
            nArray[2] = n2 * 100;
            nArray[3] = n3 * 100;
            nArray[8] = n6;
            nArray[10] = this.dSin(n4) * n5 / 100;
            nArray[11] = this.dCos(n4) * n5 / 100;
            return;
        }
    }

    private void ShotRing(int n, int n2, int n3) {
        int n4;
        int n5;
        if (n3 <= 0) {
            return;
        }
        if (n3 > 32) {
            n3 = 32;
        }
        for (n5 = 0; n5 < (n3 > 16 ? 16 : n3); ++n5) {
            n4 = (n5 >> 1) * 2250 + 1125;
            if ((n5 & 1) == 1) {
                n4 = -n4 + 36000;
            }
            this.ShotObj2(4, n, n2, n4 / 100, 256, 0);
        }
        if (n3 > 16) {
            n3 -= 16;
            for (n5 = 0; n5 < (n3 > 16 ? 16 : n3); ++n5) {
                n4 = (n5 >> 1) * 2250 + 1125;
                if ((n5 & 1) == 1) {
                    n4 = -n4 + 36000;
                }
                this.ShotObj2(4, n, n2, n4 / 100, 128, 0);
            }
        }
    }

    private void ShotAnimal(int n, int n2, int n3) {
        int n4;
        int[] nArray = new int[24];
        if (n3 < 0 || n3 > 5) {
            n3 = 0;
        }
        int n5 = 60;
        for (n4 = 0; n4 < 24; ++n4) {
            nArray[n4] = n5 += 2 + this.rnd(18);
        }
        for (n4 = 0; n4 < 24; ++n4) {
            this.SetObj2(friendTbl[n3][this.rnd(2)], n + (n4 % 8 * 8 - 32), n2, 0, -350 + this.rnd(60), this.rnd(2), n5 - nArray[n4]);
        }
    }

    private void ShotScore(int n, int n2, int n3) {
        if (n3 < 10) {
            this.SetObj2(6, n, n2, 0, 0, 0, 0);
        } else if (n3 < 50) {
            this.SetObj2(6, n, n2, 0, 0, 0, 1);
        } else if (n3 < 100) {
            this.SetObj2(6, n, n2, 0, 0, 0, 2);
        } else if (n3 < 200) {
            this.SetObj2(6, n, n2, 0, 0, 0, 3);
        } else if (n3 < 500) {
            this.SetObj2(6, n, n2, 0, 0, 0, 4);
        } else if (n3 < 1000) {
            this.SetObj2(6, n, n2, 0, 0, 0, 5);
        } else {
            this.SetObj2(6, n, n2, 0, 0, 0, 6);
        }
    }

    private void ShotBomb(int n, int n2) {
        this.ShotObj2(13, n, n2, 30, 200, 0);
        this.ShotObj2(13, n, n2, 30, 300, 0);
        this.ShotObj2(13, n, n2, 330, 200, 0);
        this.ShotObj2(13, n, n2, 330, 300, 0);
        this.SetObj2(1, n, n2, 0, 0, 0, 0);
    }

    private void DebugRect(int n, int n2, int n3, int n4, int n5) {
    }

    private void DriveObj2() {
        for (int i = 0; i < 50; ++i) {
            int[] nArray = obj2Data[i];
            if (nArray[0] <= 0) continue;
            if (Math.abs(nArray[2] / 100 - this.PlayerPosX()) > 320 || Math.abs(nArray[3] / 100 - this.PlayerPosY()) > 260 || nArray[6] > 600) {
                nArray[0] = 0;
                continue;
            }
            this.CallObj2(nArray);
            if (nArray[5] > 0) {
                nArray[5] = nArray[5] - 1;
            }
            nArray[6] = nArray[6] + 1;
        }
    }

    private void CallObj2(int[] nArray) {
        switch (nArray[1]) {
            case 1: {
                this.MoveBakuhatu(nArray);
                break;
            }
            case 2: {
                this.MoveBakuhatu(nArray);
                break;
            }
            case 3: {
                this.MoveBakudan(nArray);
                break;
            }
            case 4: {
                this.MoveRing(nArray);
                break;
            }
            case 5: {
                this.MoveKira(nArray);
                break;
            }
            case 6: {
                this.MoveScore(nArray);
                break;
            }
            case 7: {
                this.MoveNormalTama(nArray);
                break;
            }
            case 8: {
                this.MoveHachiTama(nArray);
                break;
            }
            case 9: {
                this.MoveKaniTama(nArray);
                break;
            }
            case 10: {
                this.MoveButaTama(nArray);
                break;
            }
            case 13: {
                this.MoveBroboTama(nArray);
                break;
            }
            case 11: {
                this.MoveUniTama(nArray);
                break;
            }
            case 12: {
                this.MoveUni2Tama(nArray);
                break;
            }
            case 14: {
                this.MoveImoTama(nArray);
                break;
            }
            case 15: {
                this.MoveMusiKemuri(nArray);
                break;
            }
            case 16: {
                this.MoveFireball(nArray);
                break;
            }
            case 17: {
                this.MoveFireball2(nArray);
                break;
            }
            case 18: {
                this.MoveFireball3(nArray);
                break;
            }
            case 19: {
                this.MoveFireball4(nArray);
                break;
            }
            case 20: {
                this.MoveFireball5(nArray);
                break;
            }
            case 21: {
                this.MoveKazarifire(nArray);
                break;
            }
            case 22: {
                this.MoveDBlock(nArray);
                break;
            }
            case 23: {
                this.MoveDBlock(nArray);
                break;
            }
            case 24: {
                this.MoveDBlock(nArray);
                break;
            }
            case 25: {
                this.MoveDBlock(nArray);
                break;
            }
            case 26: {
                this.MoveDBlock(nArray);
                break;
            }
            case 27: {
                this.MoveBoss6Tama(nArray);
                break;
            }
            case 28: {
                this.MoveAnimal(nArray);
                break;
            }
            case 29: {
                this.MoveAnimal(nArray);
                break;
            }
            case 30: {
                this.MoveAnimal(nArray);
                break;
            }
            case 31: {
                this.MoveAnimal(nArray);
                break;
            }
            case 32: {
                this.MoveAnimal(nArray);
                break;
            }
            case 33: {
                this.MoveAnimal(nArray);
                break;
            }
            case 34: {
                this.MoveAnimal(nArray);
                break;
            }
            case 35: {
                this.MoveObj2Debug(nArray);
            }
        }
    }

    private void DrawObj2() {
        int n = 0;
        block37: for (int i = 0; i < 50; ++i) {
            int[] nArray = obj2Data[i];
            if (nArray[0] <= 0) continue;
            ++n;
            switch (nArray[1]) {
                case 1: {
                    this.DrawBakuhatu(nArray);
                    continue block37;
                }
                case 2: {
                    this.DrawBakuhatu(nArray);
                    continue block37;
                }
                case 3: {
                    this.DrawBakuhatu(nArray);
                    continue block37;
                }
                case 4: {
                    this.DrawRing(nArray);
                    continue block37;
                }
                case 5: {
                    this.DrawKira(nArray);
                    continue block37;
                }
                case 6: {
                    this.DrawScore(nArray);
                    continue block37;
                }
                case 7: {
                    this.DrawTama(nArray);
                    continue block37;
                }
                case 8: {
                    this.DrawTama(nArray);
                    continue block37;
                }
                case 9: {
                    this.DrawTama(nArray);
                    continue block37;
                }
                case 10: {
                    this.DrawTama(nArray);
                    continue block37;
                }
                case 13: {
                    this.DrawTama(nArray);
                    continue block37;
                }
                case 11: {
                    this.DrawTama(nArray);
                    continue block37;
                }
                case 12: {
                    this.DrawTama(nArray);
                    continue block37;
                }
                case 14: {
                    this.DrawImoTama(nArray);
                    continue block37;
                }
                case 15: {
                    this.DrawMusiKemuri(nArray);
                    continue block37;
                }
                case 16: {
                    this.DrawFireball(nArray);
                    continue block37;
                }
                case 17: {
                    this.DrawFireball(nArray);
                    continue block37;
                }
                case 18: {
                    this.DrawFireball(nArray);
                    continue block37;
                }
                case 19: {
                    this.DrawFireball(nArray);
                    continue block37;
                }
                case 20: {
                    this.DrawFireball(nArray);
                    continue block37;
                }
                case 21: {
                    this.DrawKazarifire(nArray);
                    continue block37;
                }
                case 22: {
                    this.DrawDBlock(nArray);
                    continue block37;
                }
                case 23: {
                    this.DrawDBlock(nArray);
                    continue block37;
                }
                case 24: {
                    this.DrawDBlock(nArray);
                    continue block37;
                }
                case 25: {
                    this.DrawDBlock(nArray);
                    continue block37;
                }
                case 26: {
                    this.DrawBrkabe(nArray);
                    continue block37;
                }
                case 27: {
                    this.DrawBoss6Tama(nArray);
                    continue block37;
                }
                case 28: {
                    this.DrawAnimal(nArray);
                    continue block37;
                }
                case 29: {
                    this.DrawAnimal(nArray);
                    continue block37;
                }
                case 30: {
                    this.DrawAnimal(nArray);
                    continue block37;
                }
                case 31: {
                    this.DrawAnimal(nArray);
                    continue block37;
                }
                case 32: {
                    this.DrawAnimal(nArray);
                    continue block37;
                }
                case 33: {
                    this.DrawAnimal(nArray);
                    continue block37;
                }
                case 34: {
                    this.DrawAnimal(nArray);
                    continue block37;
                }
                case 35: {
                    this.DrawObj2Debug(nArray);
                }
            }
        }
        if (n > 42) {
            // empty if block
        }
    }

    private void MoveBakudan(int[] nArray) {
        if (nArray[6] > 4 && nArray[6] < 20 && this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 12, 12, false) != 0) {
            this.playdamageset();
        }
        if (nArray[6] > 24) {
            nArray[0] = 0;
        }
    }

    private void MoveBakuhatu(int[] nArray) {
        if (nArray[6] > 24) {
            nArray[0] = 0;
        }
    }

    private void MoveRing(int[] nArray) {
        nArray[2] = nArray[2] + nArray[10];
        nArray[3] = nArray[3] + nArray[11];
        nArray[15] = this.animeTimer >> 1;
        int n = nArray[2];
        int n2 = nArray[3];
        int n3 = nArray[11];
        int n4 = nArray[2] / 100;
        int n5 = nArray[3] / 100;
        if (this.IsHitSonic(n4, n5, 12, 12, false) != 0) {
            this.SetObj2(5, n4, n5, 0, 0, 0, 0);
            ++ringcount;
            nArray[0] = 0;
            return;
        }
        if (n3 > 0) {
            if (this.blockColChk_Enemy(n4, n5 + 4)) {
                int n6 = (blockLinkTable[this.enemyBlock] & 0xFF) << 4;
                n5 = (n5 & 0xFFFFFFF0) + (16 - Math.abs(scdtblwk[n6 + (n4 & 0xF)]));
                n3 = -(n3 >> 1);
            } else if ((n3 += 6) > 500) {
                n3 = 500;
            }
        } else if (this.blockColChk_Enemy(n4, n5 - 4)) {
            for (int i = 0; i < 3 && this.blockColChk_Enemy(n4, ++n5 - 4); ++i) {
            }
            n3 = -(n3 >> 1);
        } else if ((n3 += 6) > 500) {
            n3 = 500;
        }
        if (n5 < 0) {
            n5 = 0;
        } else if (n5 > 99999) {
            nArray[0] = 0;
        }
        nArray[3] = n5 * 100;
        nArray[11] = n3;
        if (nArray[6] > 300) {
            nArray[0] = 0;
        }
    }

    private void MoveKira(int[] nArray) {
        nArray[15] = nArray[6] / 8;
        if (nArray[15] > 3) {
            nArray[0] = 0;
        }
    }

    private void MoveScore(int[] nArray) {
        nArray[3] = nArray[3] - 100;
        if (nArray[6] > 50) {
            nArray[0] = 0;
        }
    }

    private void MoveNormalTama(int[] nArray) {
        if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 8, 8, false) != 0) {
            this.playdamageset();
        }
        nArray[2] = nArray[2] + nArray[10];
        nArray[3] = nArray[3] + nArray[11];
        nArray[15] = 2 + (this.animeTimer & 1);
    }

    private void MoveHachiTama(int[] nArray) {
        if (nArray[6] > 10) {
            if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 10, 10, false) != 0) {
                this.playdamageset();
            }
            nArray[2] = nArray[2] + nArray[10];
            nArray[3] = nArray[3] + nArray[11];
        }
        nArray[15] = 2 + (this.animeTimer & 1);
    }

    private void MoveKaniTama(int[] nArray) {
        if (nArray[6] > 5) {
            if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 10, 10, false) != 0) {
                this.playdamageset();
            }
            nArray[2] = nArray[2] + nArray[10];
            nArray[3] = nArray[3] + nArray[11];
            nArray[11] = nArray[11] + 10;
            if (nArray[11] > 600) {
                nArray[11] = 600;
            }
        }
        nArray[15] = 4 + (this.animeTimer & 1);
    }

    private void MoveButaTama(int[] nArray) {
        if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 12, 12, false) != 0) {
            this.playdamageset();
        }
        int n = nArray[2];
        int n2 = nArray[3];
        int n3 = nArray[10];
        int n4 = nArray[11];
        if ((n4 += 10) > 300) {
            n4 = 300;
        }
        if (n4 > 0 && this.blockColChk_Enemy((n += n3) / 100, (n2 += n4) / 100 + 5)) {
            int n5;
            do {
                n5 = this.getPlayerArg(n / 100, n2 / 100 + 5);
            } while (this.blockColChk_Enemy(n / 100, (n2 -= 100) / 100 + 5));
            if (n5 > 270) {
                n3 = -Math.abs(n3);
            } else if (n5 > 15) {
                n3 = Math.abs(n3);
            }
            n4 = -n4;
        }
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 > 999900) {
            nArray[0] = 0;
        }
        nArray[15] = 8 + (this.animeTimer & 1);
        nArray[2] = n;
        nArray[3] = n2;
        nArray[10] = n3;
        nArray[11] = n4;
        if (nArray[6] > 300) {
            this.SetObj2(1, nArray[2] / 100, nArray[3] / 100, 0, 0, 0, 0);
            nArray[0] = 0;
        }
    }

    private void MoveBroboTama(int[] nArray) {
        if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 8, 8, false) != 0) {
            this.playdamageset();
        }
        nArray[2] = nArray[2] + nArray[10];
        nArray[3] = nArray[3] + nArray[11];
        nArray[11] = nArray[11] + 10;
        if (nArray[11] > 800) {
            nArray[11] = 800;
        }
        nArray[15] = 12 + (this.animeTimer & 1);
    }

    private void MoveUniTama(int[] nArray) {
        if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 12, 12, false) != 0) {
            this.playdamageset();
        }
        nArray[15] = 6;
    }

    private void MoveUni2Tama(int[] nArray) {
        if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 12, 12, false) != 0) {
            this.playdamageset();
        }
        nArray[2] = nArray[2] + nArray[10];
        nArray[3] = nArray[3] + nArray[11];
        nArray[15] = 7;
    }

    private void MoveImoTama(int[] nArray) {
        if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 12, 12, false) != 0) {
            this.playdamageset();
        }
        nArray[15] = 11;
        int n = nArray[2];
        int n2 = nArray[3];
        int n3 = nArray[10];
        int n4 = nArray[11];
        if ((n4 += 10) > 400) {
            n4 = 400;
        }
        if (n4 > 0 && this.blockColChk_Enemy((n += n3) / 100, (n2 += n4) / 100 + 4)) {
            while (this.blockColChk_Enemy(n / 100, (n2 -= 100) / 100 + 4)) {
            }
            n4 = -n4;
        }
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 > 999900) {
            nArray[0] = 0;
        }
        nArray[2] = n;
        nArray[3] = n2;
        nArray[10] = n3;
        nArray[11] = n4;
        if (nArray[6] > 180) {
            nArray[0] = 0;
        }
    }

    private void MoveMusiKemuri(int[] nArray) {
        if (nArray[6] > 30) {
            nArray[0] = 0;
        }
    }

    private void MoveFireball(int[] nArray) {
        switch (nArray[14]) {
            case 2: {
                nArray[15] = 4;
                nArray[5] = 8;
                nArray[14] = nArray[14] + 1;
            }
            case 3: {
                if (nArray[5] > 0) {
                    return;
                }
                nArray[0] = 0;
                return;
            }
        }
        if (nArray[6] > 4) {
            int n = nArray[2] / 100;
            int n2 = nArray[3] / 100;
            if (nArray[10] > 0) {
                n += 5;
            } else if (nArray[10] < 0) {
                n -= 5;
            }
            if (nArray[11] > 0) {
                n2 += 5;
            } else if (nArray[11] < 0) {
                n2 -= 5;
            }
            if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 12, 12, false) != 0) {
                this.playdamageset();
            }
            nArray[2] = nArray[2] + nArray[10];
            nArray[3] = nArray[3] + nArray[11];
            if (nArray[8] == 1) {
                nArray[11] = nArray[11] + 6;
                if (nArray[11] > 1000) {
                    nArray[11] = 1000;
                }
            }
        }
        if (nArray[10] > 0) {
            nArray[18] = 3;
            if (this.blockColChk_Enemy(nArray[2] / 100 + 15, nArray[3] / 100)) {
                nArray[14] = 2;
            }
        } else if (nArray[10] < 0) {
            nArray[18] = 1;
            if (this.blockColChk_Enemy(nArray[2] / 100 - 15, nArray[3] / 100)) {
                nArray[14] = 2;
            }
        } else if (nArray[11] < 0) {
            nArray[18] = 2;
        } else if (nArray[11] > 0) {
            nArray[18] = 0;
            if (this.blockColChk_Enemy(nArray[2] / 100, nArray[3] / 100 + 16)) {
                nArray[14] = 2;
            }
        }
    }

    private void MoveFireball2(int[] nArray) {
        int n = nArray[2] / 100;
        int n2 = nArray[3] / 100 + 6;
        if (this.IsHitSonic(n, n2, 10, 10, false) != 0) {
            this.playdamageset();
        }
        nArray[2] = nArray[2] + nArray[10];
        nArray[3] = nArray[3] + nArray[11];
        switch (nArray[14]) {
            default: {
                nArray[10] = 0;
                nArray[11] = 20;
                nArray[18] = 0;
                nArray[19] = 0;
                nArray[14] = 1;
            }
            case 1: {
                nArray[11] = nArray[11] + 4;
                if (nArray[11] > 300) {
                    nArray[11] = 300;
                }
                if (!this.blockColChk_Enemy(nArray[2] / 100, nArray[3] / 100 + 14)) break;
                this.SetObj2(18, nArray[2] / 100, nArray[3] / 100, 0, 0, 0, 0);
                this.SetObj2(18, nArray[2] / 100, nArray[3] / 100, 0, 0, 1, 0);
                nArray[11] = 0;
                nArray[5] = 13;
                nArray[14] = nArray[14] + 1;
            }
            case 2: {
                nArray[15] = 4;
                if (nArray[5] > 0) break;
                nArray[0] = 0;
            }
        }
    }

    private void MoveFireball3(int[] nArray) {
        int n = nArray[2] / 100;
        int n2 = nArray[3] / 100 + 6;
        if (this.IsHitSonic(n, n2, 12, 12, false) != 0) {
            this.playdamageset();
        }
        nArray[2] = nArray[2] + nArray[10];
        nArray[3] = nArray[3] + nArray[11];
        switch (nArray[14]) {
            default: {
                nArray[10] = nArray[19] == 1 ? 64 : -64;
                nArray[11] = 100;
                nArray[5] = 100;
                switch (nArray[8]) {
                    default: {
                        nArray[5] = 100;
                        nArray[9] = 5;
                        break;
                    }
                    case 1: {
                        nArray[5] = 140;
                        nArray[9] = 8;
                    }
                }
                nArray[18] = 0;
                nArray[15] = 0;
                nArray[14] = 1;
            }
            case 1: {
                if (this.blockColChk_Enemy(nArray[2] / 100, nArray[3] / 100 + 14)) {
                    nArray[3] = nArray[3] - 200;
                }
                if (nArray[6] % 24 == 0 && nArray[9] > 0) {
                    nArray[9] = nArray[9] - 1;
                    if (nArray[8] == 0) {
                        this.SetObj2(19, nArray[2] / 100, nArray[3] / 100, 0, 0, 0, 0);
                    } else if (nArray[8] == 1) {
                        this.SetObj2(19, nArray[2] / 100, nArray[3] / 100, 0, 0, 0, 999);
                    }
                }
                if (nArray[5] > 0) break;
                nArray[5] = 12;
                nArray[14] = nArray[14] + 1;
            }
            case 2: {
                nArray[15] = 4;
                if (nArray[5] > 0) break;
                nArray[0] = 0;
            }
        }
    }

    private void MoveFireball4(int[] nArray) {
        int n = nArray[2] / 100;
        int n2 = nArray[3] / 100 + 6;
        if (this.IsHitSonic(n, n2, 12, 12, false) != 0) {
            this.playdamageset();
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                if (nArray[8] == 0) {
                    nArray[8] = 100;
                }
                nArray[5] = 0;
                nArray[18] = 0;
                nArray[15] = 0;
                nArray[14] = 1;
            }
            case 2: {
                if (nArray[8] > 998 || nArray[6] < nArray[8]) break;
                nArray[15] = 4;
                nArray[5] = 8;
                nArray[14] = nArray[14] + 1;
            }
            case 3: {
                if (nArray[5] > 0) break;
                nArray[0] = 0;
            }
        }
    }

    private void MoveFireball5(int[] nArray) {
        int n = nArray[2] / 100;
        int n2 = nArray[3] / 100 + (nArray[18] == 0 ? 6 : -6);
        if (this.IsHitSonic(n, n2, 10, 12, false) != 0) {
            this.playdamageset();
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                if (nArray[8] == 0) {
                    nArray[8] = 64;
                }
                nArray[5] = 0;
                nArray[9] = 0;
                nArray[18] = 0;
                nArray[15] = 0;
                nArray[17] = nArray[3];
                nArray[14] = nArray[14] + 1;
            }
            case 2: 
        }
        nArray[9] = nArray[9] + 140;
        nArray[15] = this.animeTimer & 1;
        int n3 = nArray[9] / 100 % 180;
        nArray[3] = nArray[17] - Math.abs(this.dSin(n3)) * nArray[8];
        nArray[18] = n3 < 90 ? 2 : 0;
        if (nArray[9] >= 18000) {
            nArray[0] = 0;
        }
    }

    private void MoveKazarifire(int[] nArray) {
        if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100 + 2, 10, 10, false) != 0) {
            this.playdamageset();
        }
        nArray[2] = nArray[2] + nArray[10];
        nArray[3] = nArray[3] + nArray[11];
        if (this.blockColChk_Enemy(nArray[2] / 100, nArray[3] / 100)) {
            nArray[0] = 0;
        }
    }

    private void MoveDBlock(int[] nArray) {
        nArray[15] = nArray[8];
        nArray[2] = nArray[2] + nArray[10];
        nArray[3] = nArray[3] + nArray[11];
        nArray[11] = nArray[11] + 20;
        if (nArray[11] > 800) {
            nArray[11] = 800;
        }
    }

    private void MoveBoss6Tama(int[] nArray) {
        if (this.IsHitSonic(nArray[2] / 100, nArray[3] / 100, 12, 12, false) != 0 && nArray[14] == 4) {
            this.playdamageset();
        }
        nArray[15] = nArray[14] <= 2 ? Boss6TamaAnmTbl[this.animeTimer & 3] : (nArray[14] <= 3 ? Boss6TamaAnmTbl2[this.animeTimer % 20] : Boss6TamaAnmTbl3[this.animeTimer & 3]);
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[10] = (nArray[8] - nArray[2]) / 20;
                nArray[11] = 0;
                nArray[15] = 1;
                nArray[5] = 30;
                nArray[14] = nArray[14] + 1;
            }
            case 2: {
                if (nArray[2] > nArray[8]) {
                    nArray[2] = nArray[2] + nArray[10];
                    nArray[3] = nArray[3] + nArray[11];
                }
                if (nArray[5] > 0) break;
                nArray[2] = nArray[8];
                nArray[5] = 90;
                nArray[14] = nArray[14] + 1;
            }
            case 3: {
                if (nArray[5] > 0) break;
                int n = this.PlayerPosX() * 100;
                int n2 = 39200;
                nArray[10] = (n - nArray[2]) / 256;
                nArray[11] = (n2 - nArray[3]) / 256;
                nArray[5] = 150;
                nArray[14] = nArray[14] + 1;
            }
            case 4: {
                nArray[2] = nArray[2] + nArray[10];
                nArray[3] = nArray[3] + nArray[11];
                if (nArray[5] > 0) break;
                nArray[0] = 0;
            }
        }
    }

    private void DrawBakuhatu(int[] nArray) {
        short s;
        short s2;
        short s3;
        short s4;
        int n = nArray[6] / 4 % 5;
        if (nArray[1] == 2) {
            s4 = RectTblKemuri[n][0];
            s3 = RectTblKemuri[n][1];
            s2 = RectTblKemuri[n][2];
            s = RectTblKemuri[n][3];
        } else {
            s4 = RectTblBakuhatu[n][0];
            s3 = RectTblBakuhatu[n][1];
            s2 = RectTblBakuhatu[n][2];
            s = RectTblBakuhatu[n][3];
        }
        this.drawRegion(gg, this.m_imgObj[97], s4, s3, s2, s, 0, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void DrawRing(int[] nArray) {
        int[] nArray2 = new int[]{0, 0, 0, 2};
        int[] nArray3 = new int[]{0, 16, 32, 16};
        this.drawRegion(gg, this.m_imgObj[0], 0, nArray3[this.animeTimer & 3], 16, 16, nArray2[this.animeTimer & 3], nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void DrawKira(int[] nArray) {
        if (nArray[15] < 0 || nArray[15] > 3) {
            return;
        }
        this.drawRegion(gg, this.m_imgObj[0], 16, nArray[15] * 16, 16, 16, 0, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void DrawScore(int[] nArray) {
        int n;
        int n2;
        int n3;
        int n4 = nArray[8];
        if (n4 < 0) {
            return;
        }
        if (n4 > 6) {
            n4 = 6;
        }
        switch (n4) {
            default: {
                n3 = 8;
                n2 = 0;
                n = 5;
                break;
            }
            case 1: {
                n3 = 3;
                n2 = 0;
                n = 10;
                break;
            }
            case 2: {
                n3 = 3;
                n2 = 16;
                n = 10;
                break;
            }
            case 3: {
                n3 = 3;
                n2 = 0;
                n = 15;
                break;
            }
            case 4: {
                n3 = 3;
                n2 = 8;
                n = 15;
                break;
            }
            case 5: {
                n3 = 3;
                n2 = 16;
                n = 15;
                break;
            }
            case 6: {
                n3 = 3;
                n2 = 0;
                n = 20;
            }
        }
        int n5 = 8;
        this.drawRegion(gg, this.m_imgCmd[SYSSCORE], n3, n2, n, n5, 0, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void DrawTama(int[] nArray) {
        int n = nArray[15] % 14;
        short s = RectTblTama[n][0];
        short s2 = RectTblTama[n][1];
        short s3 = RectTblTama[n][2];
        short s4 = RectTblTama[n][3];
        this.drawRegion(gg, this.m_imgObj[96], s, s2, s3, s4, 0, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void DrawImoTama(int[] nArray) {
        int n = nArray[8] == 0 ? 0 : 2;
        short s = RectTblImo[n][0];
        short s2 = RectTblImo[n][1];
        short s3 = RectTblImo[n][2];
        short s4 = RectTblImo[n][3];
        this.drawRegion(gg, this.m_imgObj[49], s, s2, s3, s4, nArray[19] == 0 ? 0 : 2, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void DrawMusiKemuri(int[] nArray) {
        int n;
        if (nArray[6] < 5) {
            n = 0;
        } else if (nArray[6] < 10) {
            n = 8;
        } else if (nArray[6] < 15) {
            n = 16;
        } else {
            return;
        }
        if ((this.animeTimer & 1) == 0) {
            this.drawRegion(gg, this.m_imgObj[41], n, 96, 8, 8, 0, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
        }
    }

    private void DrawFireball(int[] nArray) {
        int n = nArray[15] % 5;
        if (n == 0) {
            n += this.animeTimer & 3;
        }
        int n2 = nArray[18];
        int n3 = 0;
        int n4 = n * 32;
        int n5 = 24;
        int n6 = 32;
        this.drawRegion(gg, this.m_imgObj[101], n3, n4, n5, n6, this.GetDrawRot(n2), nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void DrawKazarifire(int[] nArray) {
        int n = nArray[15] % 1;
        if (n == 0) {
            n += this.animeTimer >> 1 & 1;
        }
        int n2 = nArray[10] < 0 ? 0 : 2;
        int n3 = 0;
        int n4 = n == 0 ? 160 : 168;
        int n5 = 16;
        int n6 = 8;
        this.drawRegion(gg, this.m_imgObj[101], n3, n4, n5, n6, n2, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void DrawDBlock(int[] nArray) {
        int n = nArray[15] & 3;
        int n2 = nArray[1] == 23 ? 102 : (nArray[1] == 24 ? BRKABE : 27);
        short s = RectTblDBlock[n][0];
        short s2 = RectTblDBlock[n][1];
        int n3 = 16;
        int n4 = 16;
        this.drawRegion(gg, this.m_imgObj[n2], s, s2, n3, n4, 0, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void DrawBrkabe(int[] nArray) {
        int n;
        switch (nArray[8]) {
            default: {
                n = 0;
                break;
            }
            case 1: {
                n = 16;
                break;
            }
            case 2: {
                n = 32;
            }
        }
        int n2 = 0;
        int n3 = 16;
        int n4 = 16;
        this.drawRegion(gg, this.m_imgObj[18], n, n2, n3, n4, 0, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void DrawBoss6Tama(int[] nArray) {
        int n;
        if (nArray[15] < 0) {
            return;
        }
        int n2 = nArray[15] % 5;
        short s = RectTblBoss6Tama[n2][0];
        short s2 = RectTblBoss6Tama[n2][1];
        short s3 = RectTblBoss6Tama[n2][2];
        short s4 = RectTblBoss6Tama[n2][3];
        switch (this.cpuTimer & 3) {
            default: {
                n = 0;
                break;
            }
            case 1: {
                n = 2;
                break;
            }
            case 2: {
                n = 1;
                break;
            }
            case 3: {
                n = 3;
            }
        }
        this.drawRegion(gg, this.m_imgObj[145], s, s2, s3, s4, n, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1], 1 | 2);
    }

    private void MoveAnimal(int[] nArray) {
        int n = (nArray[1] - 28) % 7;
        if (nArray[14] > 2) {
            nArray[2] = nArray[2] + nArray[10];
            nArray[3] = nArray[3] + nArray[11];
            nArray[11] = nArray[11] + 10;
            if (nArray[11] > 800) {
                nArray[11] = 800;
            }
        }
        switch (nArray[14]) {
            default: {
                nArray[14] = 1;
            }
            case 1: {
                nArray[10] = 0;
                nArray[15] = 0;
                nArray[5] = nArray[8];
                nArray[14] = nArray[14] + 1;
            }
            case 2: {
                if (nArray[5] > 0) break;
                nArray[14] = nArray[14] + 1;
            }
            case 3: {
                nArray[15] = 0;
                if (!this.blockColChk_Enemy(nArray[2] / 100, nArray[3] / 100 + 8)) break;
                nArray[10] = this.MoveAnimalTbl[n][0];
                nArray[11] = this.MoveAnimalTbl[n][1];
                if (nArray[19] == 1) {
                    nArray[10] = -nArray[10];
                }
                nArray[6] = 0;
                nArray[14] = nArray[14] + 1;
            }
            case 4: {
                nArray[15] = 1;
                if (!this.blockColChk_Enemy(nArray[2] / 100, nArray[3] / 100 + 8)) break;
                for (int i = 0; i < 3; ++i) {
                    nArray[3] = nArray[3] - 200;
                    if (!this.blockColChk_Enemy(nArray[2] / 100, nArray[3] / 100 + 8)) break;
                }
                nArray[11] = this.MoveAnimalTbl[n][1];
            }
        }
        if (nArray[3] < 0) {
            nArray[3] = 0;
        } else if (nArray[3] > 999900) {
            nArray[0] = 0;
        }
    }

    private void DrawAnimal(int[] nArray) {
        int n;
        int n2;
        int n3 = nArray[15] % 3;
        if (n3 < 0) {
            return;
        }
        if (n3 == 1 && nArray[11] > 0) {
            ++n3;
        }
        if ((n2 = (nArray[1] - 28) % 7) < 0) {
            n2 = 0;
        }
        short s = this.RectAnimalTbl[n3 += n2 * 3][0];
        short s2 = this.RectAnimalTbl[n3][1];
        short s3 = this.RectAnimalTbl[n3][2];
        short s4 = this.RectAnimalTbl[n3][3];
        short s5 = this.RectAnimalTbl[n3][4];
        switch (nArray[19]) {
            default: {
                n = 0;
                break;
            }
            case 1: {
                n = 2;
                break;
            }
            case 2: {
                n = 1;
                break;
            }
            case 3: {
                n = 3;
            }
        }
        this.drawRegion(gg, this.m_imgObj[100], s, s2, s3, s4, n, nArray[2] / 100 - mapView[0], nArray[3] / 100 - mapView[1] + s5, 1 | 2);
    }

    private void MoveObj2Debug(int[] nArray) {
        if (nArray[6] > 0) {
            nArray[0] = 0;
        }
    }

    private void DrawObj2Debug(int[] nArray) {
    }

    private void InitBoss() {
        this.bossType = this.zoneNumber;
        this.bossStep = 0;
        this.bossAnim = 0;
        this.bossDir = 0;
        this.bossAngle = 0;
        this.bossAngle2 = 0;
        this.bossParam1 = 0;
        this.bossParam2 = 0;
        this.bossPosY = 0;
        this.bossPosX = 0;
        this.bossOfsY = 0;
        this.bossOfsX = 0;
        this.bossCount = 0;
        this.bossFrame = 0;
        this.bossFlash = 0;
        this.bossStopCount = 0;
        this.bossFace = 0;
        this.bossFaceCount = 0;
        if (this.zoneNumber == 3 || this.zoneNumber == 4) {
            switch (m_nConfigValue[0]) {
                case 2: {
                    this.bossHP = 6;
                    break;
                }
                case 1: {
                    this.bossHP = 5;
                    break;
                }
                default: {
                    this.bossHP = 4;
                    break;
                }
            }
        } else {
            switch (m_nConfigValue[0]) {
                case 2: {
                    this.bossHP = 8;
                    break;
                }
                case 1: {
                    this.bossHP = 6;
                    break;
                }
                default: {
                    this.bossHP = 4;
                }
            }
        }
        if (this.zoneNumber < 5) {
            this.PlayMusic(17);
        }
    }

    private void initBossData(int n) {
        try {
            int n2;
            int[] nArray = new int[25];
            for (n2 = 0; n2 < nArray.length; ++n2) {
                nArray[n2] = 0;
            }
            this.InitBoss();
            if (n == 0) {
                this.m_imgObj[120] = this.createImage("boss.png");
                this.m_imgObj[121] = this.createImage("bossball.png");
                nArray[1] = 120;
                this.bossOriginX = 10752;
                this.bossOriginY = 808;
            } else if (n == 1) {
                this.m_imgObj[120] = this.createImage("boss.png");
                nArray[1] = 125;
                this.bossOriginX = 0;
                this.bossOriginY = 0;
                this.bossPosX = 769600;
                this.bossPosY = 147200;
            } else if (n == 2) {
                this.m_imgObj[120] = this.createImage("boss.png");
                this.m_imgObj[131] = this.createImage("fire.png");
                nArray[1] = 130;
                this.bossOriginX = 6304;
                this.bossOriginY = 608;
                this.bossPosX = (6640 - this.bossOriginX) * 100;
                this.bossPosY = (544 - this.bossOriginY) * 100;
            } else if (n == 3) {
                this.m_imgObj[120] = this.createImage("boss.png");
                nArray[1] = 135;
                this.bossOriginX = 8352;
                this.bossOriginY = 576;
                this.bossPosX = 0;
                this.bossPosY = 0;
                for (n2 = 0; n2 < 3; ++n2) {
                    MainCanvas.boss4Sisoo[n2][0] = 0;
                }
                boolean bl = false;
                int[][] nArray2 = this.searchObject(23, 255);
                for (n2 = 0; n2 < nArray2.length; ++n2) {
                    MainCanvas.ObjectAct[nArray2[n2][20]] = true;
                    MainCanvas.ObjectDead[nArray2[n2][20]] = false;
                    int n3 = nArray2[n2][2] == 8352 ? 1 : (nArray2[n2][2] == 8452 ? 2 : 0);
                    MainCanvas.boss4Sisoo[n3][0] = (short)nArray2[n2][23];
                    MainCanvas.boss4Sisoo[n3][1] = (short)(nArray2[n2][2] - this.bossOriginX);
                    MainCanvas.boss4Sisoo[n3][2] = (short)(n3 == 2 ? 20 : -20);
                    MainCanvas.boss4Sisoo[n3][3] = 0;
                }
            } else if (n == 4) {
                this.PreInitBoss5();
                this.m_imgObj[120] = this.createImage("boss.png");
                nArray[1] = 140;
                this.bossPosX = 0;
                this.bossPosY = 0;
            } else if (n == 5) {
                for (n2 = 0; n2 < 150; ++n2) {
                    this.m_imgObj[n2] = null;
                }
                this.DoGc();
                this.m_imgObj[0] = this.createImage("/ring.png");
                this.m_imgObj[97] = this.createImage("/bakuhatu.png");
                this.m_imgObj[84] = this.createImage("/beltcon.png");
                this.m_imgObj[120] = this.createImage("boss.png");
                this.m_imgObj[145] = this.createImage("boss6.png");
                this.m_imgObj[146] = this.createImage("eggman.png");
                this.m_imgObj[147] = this.createImage("boss2.png");
                nArray[1] = 145;
                this.bossOriginX = 1272;
                this.bossOriginY = 120;
                this.bossPosX = 0;
                this.bossPosY = 0;
            }
            nArray[0] = 1;
            nArray[2] = nArray[16] = mapView[0] + 256 + 46;
            nArray[3] = nArray[17] = mapView[1] + 46;
            nArray[4] = 0;
            nArray[14] = 0;
            nArray[20] = ObjectAct.length - 1;
            MainCanvas.ObjectAct[nArray[20]] = true;
            MainCanvas.ObjectDead[nArray[20]] = false;
            this.addObject(nArray);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void startBossMode() {
        bossModeOn = true;
        this.initBossData(this.zoneNumber);
    }

    private void endBossMode() {
        bossBreakOn = true;
        bossModeOn = false;
        MapEndCounter = 1;
        if (this.zoneNumber != 5) {
            this.PlayZoneBGM();
        }
    }

    private boolean _BossDefault(int[] nArray) {
        nArray[2] = (this.bossPosX + this.bossOfsX) / 100 + this.bossOriginX;
        nArray[3] = (this.bossPosY + this.bossOfsY) / 100 + this.bossOriginY;
        if (this.bossFlash > 0) {
            --this.bossFlash;
        }
        if (this.bossFaceCount > 0 && --this.bossFaceCount == 0) {
            this.bossFace = 0;
        }
        if (this.bossStopCount > 0) {
            --this.bossStopCount;
            return true;
        }
        if (this.bossCount > 0) {
            --this.bossCount;
        }
        ++this.bossFrame;
        return false;
    }

    private boolean _BossDead() {
        int n = this.bossOriginY + (this.bossPosY + this.bossOfsY) / 100;
        switch (this.bossStep) {
            case 100: {
                this.bossAnim = 3;
                this.bossCount = 120;
                ++this.bossStep;
            }
            case 101: {
                if (this.bossParam1 > 0) {
                    --this.bossParam1;
                }
                if (this.bossCount > 0) break;
                this.bossAnim = 4;
                this.bossCount = 80;
                ++this.bossStep;
            }
            case 102: {
                this.bossAnim = 4;
                this.bossPosY += 200;
                if (n < BossDeadLimitY[this.zoneNumber]) break;
                this.bossCount = 40;
                ++this.bossStep;
            }
            case 103: {
                if (this.bossCount > 0) break;
                this.endBossMode();
                this.bossCount = 24;
                ++this.bossStep;
            }
            case 104: {
                this.bossPosY -= 80;
                if (this.bossCount > 0) break;
                this.bossCount = 40;
                ++this.bossStep;
            }
            case 105: {
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 106: {
                this.bossAnim = 5;
                this.bossDir = 1;
                this.bossPosX += 100;
                this.bossPosY -= 50;
                if (this.bossCount > 0) break;
                this.bossCount = 120;
                ++this.bossStep;
            }
            case 107: {
                this.bossAnim = 6;
                this.bossDir = 1;
                this.bossPosX += 500;
                this.bossPosY -= 50;
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 108: {
                this.bossAnim = -1;
                return true;
            }
        }
        return false;
    }

    private void UpdateBossPos(int[] nArray) {
        nArray[2] = this.bossOriginX + (this.bossPosX + this.bossOfsX) / 100;
        nArray[3] = this.bossOriginY + (this.bossPosY + this.bossOfsY) / 100;
    }

    private void ColliRect(int n, int n2, int n3, int n4) {
        int n5 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, n, n2, n, n2, n3, n4);
        if (n5 >= 0) {
            if (n5 == 0) {
                MainCanvas.PlayerParam[1] = n2 - n4 << 8;
                this.playerRaidOn(-1);
            } else if (n5 == 1) {
                MainCanvas.PlayerParam[0] = n - n3 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
            } else if (n5 == 2) {
                MainCanvas.PlayerParam[0] = n + n3 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
            } else if (n5 == 3) {
                MainCanvas.PlayerParam[1] = n2 + n4 + 12 + 12 + 1 << 8;
            }
        }
        if (raidOn && n5 != 0) {
            raidOn = false;
        }
    }

    private boolean isHitBoss() {
        int n;
        if (this.bossStep >= 50) {
            return false;
        }
        if (PlayerJump && PlayerDamage) {
            return false;
        }
        if (comboScore > 0) {
            return false;
        }
        int n2 = (this.bossPosX + this.bossOfsX) / 100 + this.bossOriginX;
        int n3 = (this.bossPosY + this.bossOfsY) / 100 + this.bossOriginY - 16;
        int n4 = n2 - this.PlayerPosX();
        int n5 = n4 * n4 + (n = n3 - (this.PlayerPosY() - 16)) * n;
        if (n5 < 1024) {
            if (PlayerBall) {
                comboScore = 1;
                this.Vibrate(100);
                return true;
            }
            if (mutekicount == 0) {
                this.playdamageset();
            }
            comboScore = 1;
            return false;
        }
        return false;
    }

    private boolean isHitBoss6() {
        int n = 6;
        int n2 = -8;
        if (!PlayerBall || this.bossFlash > 0 || this.bossStep >= 100) {
            return false;
        }
        int n3 = this.PlayerPosX();
        int n4 = this.PlayerPosY() - 16;
        int n5 = this.bossPosX / 100 + this.bossOriginX;
        int n6 = this.bossPosY / 100 + this.bossOriginY;
        if (n5 - 32 - 8 - n <= n3 && n3 <= n5 + 32 + 8 + n && n6 - 32 - n2 <= n4 && n4 <= n6 + 32 + n2) {
            this.Vibrate(100);
            return true;
        }
        return false;
    }

    private void boundBossHit(int n, int n2, int n3) {
        int n4 = this.PlayerPosX();
        int n5 = this.PlayerPosY() - 16;
        int n6 = n2 >= n5 ? (n <= n4 ? 45 : 315) : (n <= n4 ? 135 : 225);
        MainCanvas.PlayerParam[3] = this.dSin(n6) * 8;
        MainCanvas.PlayerParam[5] = this.dCos(n6) * 8;
    }

    private void boss1_move_arai(int n) {
        int[] nArray = objectData;
        this.bossOfsX = 0;
        this.bossOfsY = this.dSin(this.bossAngle2 / 100) * 8;
        this._BossDefault(nArray);
        if (this.isHitBoss()) {
            this.boundBossHit(nArray[2], nArray[3], 12);
            if (this.bossFlash == 0 && this.bossStep < 100) {
                if (--this.bossHP <= 0) {
                    this.bossStep = 100;
                    return;
                }
                this.bossFace = 3;
                this.bossFaceCount = 60;
                this.bossFlash = 60;
            }
        }
        if (this.bossStep < 100) {
            int n2;
            int n3;
            for (n3 = this.bossAngle / 100; n3 < 0; n3 += 360) {
            }
            int n4 = 180 + this.dSin(n3) * 90 / 100;
            int n5 = (this.bossPosX + this.bossOfsX) / 100 + this.dSin(n4) * this.bossParam1 / 100 + this.RectBossTbl[15][4];
            if (this.IsDistance(this.bossOriginX + n5, this.bossOriginY + (n2 = (this.bossPosY + this.bossOfsY) / 100 + this.dCos(n4) * this.bossParam1 / 100 + this.RectBossTbl[15][5]), 28)) {
                this.playdamageset();
                this.bossFace = 1;
                this.bossFaceCount = 60;
            }
        }
        switch (this.bossStep) {
            default: {
                this.bossStep = 1;
            }
            case 1: {
                this.bossPosX = 10000;
                this.bossPosY = -12000;
                this.bossParam1 = -32;
                this.bossParam2 = -100;
                this.bossAngle = 0;
                this.bossAngle2 = 0;
                this.bossCount = 80;
                ++this.bossStep;
            }
            case 2: {
                this.bossAnim = 0;
                this.bossPosY += 80;
                if (this.bossPosY < 0) break;
                this.bossPosY = 0;
                this.bossCount = 100;
                ++this.bossStep;
            }
            case 3: {
                this.bossAnim = 2;
                this.bossPosX -= 100;
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 4: {
                this.bossAnim = 1;
                if (++this.bossParam1 < 96) break;
                this.bossCount = 32;
                ++this.bossStep;
            }
            case 5: {
                this.bossAnim = 2;
                this.bossPosX -= 50;
                this.bossAngle += this.bossParam2;
                this.bossAngle2 += 100;
                if (this.bossPosX > -3200) break;
                this.bossPosX = -3200;
                this.bossStep = 6;
                break;
            }
            case 6: {
                this.bossAnim = 2;
                this.bossPosX -= 100;
                this.bossAngle += this.bossParam2;
                this.bossAngle2 += 100;
                if (this.bossPosX > -3200) break;
                this.bossPosX = -3200;
                ++this.bossStep;
            }
            case 7: {
                this.bossAnim = 0;
                this.bossDir = 1;
                this.bossAngle2 += 100;
                if (this.bossParam2 < 0) {
                    this.bossAngle += this.bossParam2;
                    if (this.bossAngle >= -9000) break;
                    this.bossParam2 = -this.bossParam2;
                    this.bossAngle = -9000;
                    break;
                }
                this.bossAngle += this.bossParam2;
                if (this.bossAngle < 9000) break;
                this.bossAngle = 9000;
                this.bossParam2 = -this.bossParam2;
                this.bossCount = 64;
                ++this.bossStep;
            }
            case 8: {
                this.bossAnim = 2;
                this.bossPosX += 100;
                this.bossAngle += this.bossParam2;
                this.bossAngle2 += 100;
                if (this.bossPosX < 3200 || this.bossCount > 0) break;
                this.bossPosX = 3200;
                ++this.bossStep;
            }
            case 9: {
                this.bossAnim = 0;
                this.bossDir = 0;
                this.bossAngle2 += 100;
                if (this.bossParam2 > 0) {
                    this.bossAngle += this.bossParam2;
                    if (this.bossAngle <= 9000) break;
                    this.bossParam2 = -this.bossParam2;
                    this.bossAngle = 9000;
                    break;
                }
                this.bossAngle += this.bossParam2;
                if (this.bossAngle > -9000) break;
                this.bossAngle = -9000;
                this.bossParam2 = -this.bossParam2;
                this.bossCount = 64;
                this.bossStep = 6;
                break;
            }
            case 100: {
                this.bossAnim = 3;
                this.bossCount = 40;
                ++this.bossStep;
            }
            case 101: {
                if (this.bossCount > 0) break;
                this.bossCount = 180;
                ++this.bossStep;
            }
            case 102: {
                if (this.bossParam1 > 0) {
                    --this.bossParam1;
                }
                if (this.bossCount > 0) break;
                this.bossAnim = 4;
                this.bossCount = 80;
                ++this.bossStep;
            }
            case 103: {
                this.bossAnim = 4;
                this.bossPosY += 200;
                this.UpdateBossPos(nArray);
                if (nArray[3] < BossDeadLimitY[this.zoneNumber]) break;
                this.bossCount = 40;
                ++this.bossStep;
            }
            case 104: {
                if (this.bossCount > 0) break;
                this.endBossMode();
                this.bossCount = 16;
                ++this.bossStep;
            }
            case 105: {
                this.bossAnim = 5;
                this.bossDir = 1;
                this.bossPosX += 200;
                this.bossPosY -= 50;
                if (this.bossCount > 0) break;
                this.bossCount = 120;
                ++this.bossStep;
            }
            case 106: {
                this.bossAnim = 6;
                this.bossDir = 1;
                this.bossPosX += 600;
                this.bossPosY -= 50;
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 107: {
                this.bossAnim = -1;
                MainCanvas.objectData[0] = 0;
            }
        }
    }

    private boolean moveBoss2Point(int n, int n2, int n3, int n4) {
        this.bossPosX = Math.abs(n - this.bossPosX) > n3 ? (n > this.bossPosX ? (this.bossPosX += n3) : (this.bossPosX -= n3)) : n;
        this.bossPosY = Math.abs(n2 - this.bossPosY) > n4 ? (n2 > this.bossPosY ? (this.bossPosY += n4) : (this.bossPosY -= n4)) : n2;
        return Math.abs(this.bossPosX - n) < 200 && Math.abs(this.bossPosY - n2) < 200;
    }

    private void boss2_move_arai(int n) {
        int[] nArray = objectData;
        this._BossDefault(nArray);
        this.bossAngle2 += 200;
        this.bossOfsX = 0;
        this.bossOfsY = this.dSin(this.bossAngle2 / 100) * 8;
        this.UpdateBossPos(nArray);
        int n2 = nArray[2] - this.PlayerPosX();
        int n3 = nArray[3] - (this.PlayerPosY() - 16);
        int n4 = n2 * n2 + n3 * n3;
        if (this.isHitBoss()) {
            this.boundBossHit(nArray[2], nArray[3], 8);
            if (this.bossFlash == 0 && this.bossStep < 100) {
                this.bossFace = 3;
                this.bossFaceCount = 60;
                this.bossFlash = 60;
            }
        }
        switch (this.bossStep) {
            default: {
                this.bossStep = 1;
            }
            case 1: {
                this.bossFace = 0;
                this.bossAnim = 2;
                this.bossPosX = boss2MoveTbl[0][0];
                this.bossPosY = boss2MoveTbl[0][1];
                this.bossAngle = 0;
                this.bossAngle2 = 0;
                ++this.bossStep;
                if (n4 > 4096) break;
                ++this.bossStep;
            }
            case 3: {
                if (!this.moveBoss2Point(boss2MoveTbl[1][0], boss2MoveTbl[1][1], 50, 100)) break;
                ++this.bossStep;
                break;
            }
            case 4: {
                if (n4 > 4096 && nArray[3] < this.PlayerPosY() - 16) break;
                ++this.bossStep;
            }
            case 5: {
                if (!this.moveBoss2Point(boss2MoveTbl[2][0], boss2MoveTbl[2][1], 50, 80)) break;
                ++this.bossStep;
                break;
            }
            case 6: {
                if (n4 > 6400 && nArray[3] < this.PlayerPosY() - 16) break;
                ++this.bossStep;
            }
            case 7: {
                if (!this.moveBoss2Point(boss2MoveTbl[3][0], boss2MoveTbl[3][1], 50, 80)) break;
                ++this.bossStep;
                break;
            }
            case 8: {
                if (n4 > 6400 && nArray[3] < this.PlayerPosY() - 16) break;
                ++this.bossStep;
            }
            case 9: {
                if (!this.moveBoss2Point(boss2MoveTbl[4][0], boss2MoveTbl[4][1], 80, 80)) break;
                ++this.bossStep;
                break;
            }
            case 10: {
                if (n4 > 6400) break;
                this.bossCount = 40;
                ++this.bossStep;
            }
            case 11: {
                if (this.bossCount > 0) break;
                this.bossStep = 100;
                break;
            }
            case 100: {
                if (this.bossCount > 0) break;
                this.endBossMode();
                this.bossCount = 16;
                ++this.bossStep;
            }
            case 101: {
                this.bossAnim = 5;
                this.bossDir = 1;
                this.bossPosX += 100;
                this.bossPosY -= 30;
                if (this.bossCount > 0) break;
                this.bossCount = 180;
                ++this.bossStep;
            }
            case 102: {
                this.bossAnim = 6;
                this.bossDir = 1;
                this.bossPosX += 300;
                this.bossPosY -= 50;
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 103: {
                this.bossAnim = -1;
                MainCanvas.objectData[0] = 0;
            }
        }
    }

    private void boss3_move_arai(int n) {
        int[] nArray = objectData;
        if (this._BossDefault(objectData)) {
            return;
        }
        this.bossAngle2 += 100;
        this.bossOfsX = 0;
        this.bossOfsY = this.dSin(this.bossAngle2 / 100) * 10;
        if (this.bossStep > 99) {
            if (this._BossDead()) {
                nArray[0] = 0;
            }
            return;
        }
        if (this.isHitBoss() && this.bossStep > 3) {
            this.boundBossHit(nArray[2], nArray[3], 12);
            if (this.bossFlash == 0 && this.bossStep < 100) {
                if (--this.bossHP <= 0) {
                    boss3FireCount = 0;
                    this.bossStep = 100;
                    return;
                }
                this.bossFace = 3;
                this.bossFaceCount = 60;
                this.bossFlash = 60;
                this.bossStopCount = 20;
            }
        }
        if (boss3FireCount > 0 && --boss3FireCount == 0) {
            boss3FireCount = 150 + this.rnd(150);
            this.SetObj2(16, this.bossOriginX + this.rnd(40) - 20, this.bossOriginY + 130, 0, -300, 0, 1);
        }
        switch (this.bossStep) {
            default: {
                this.bossStep = 1;
            }
            case 1: {
                this.bossFace = 0;
                this.bossAnim = 2;
                this.bossPosX = 31200;
                this.bossPosY = 4800;
                this.bossAngle = 0;
                this.bossAngle2 = 0;
                boss3FireCount = 0;
                this.bossCount = 30;
                ++this.bossStep;
            }
            case 2: {
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 3: {
                this.bossAnim = 2;
                this.bossPosX -= 150;
                this.bossPosY -= 20;
                if (this.bossPosX > 10400 || this.bossCount > 0) break;
                this.bossPosX = 10400;
                this.bossAnim = 0;
                this.bossFace = 1;
                this.bossFaceCount = 60;
                this.bossCount = 60;
                boss3FireCount = 120;
                ++this.bossStep;
                break;
            }
            case 4: {
                this.bossAnim = 2;
                this.bossDir = 0;
                ++this.bossStep;
            }
            case 5: {
                this.bossAnim = 2;
                this.bossDir = 0;
                this.bossPosX -= 150;
                this.bossPosY -= 12;
                if (this.bossPosX > -10400) break;
                this.bossPosX = -10400;
                ++this.bossStep;
            }
            case 6: {
                this.bossPosY += 50;
                if (this.bossPosY <= 1200) break;
                this.bossPosY = 1200;
                ++this.bossStep;
            }
            case 7: {
                this.bossFace = 1;
                this.bossFaceCount = 60;
                this.bossCount = 48;
                ++this.bossStep;
            }
            case 8: {
                if (this.bossCount == 8) {
                    this.SetObj2(17, nArray[2], nArray[3] + 16, 0, 0, 0, 0);
                }
                if (this.bossCount > 0) break;
                this.UpdateBossPos(nArray);
                ++this.bossStep;
                break;
            }
            case 9: {
                this.bossAnim = 2;
                this.bossDir = 1;
                ++this.bossStep;
            }
            case 10: {
                this.bossAnim = 2;
                this.bossDir = 1;
                this.bossPosX += 150;
                this.bossPosY -= 12;
                if (this.bossPosX < 10400) break;
                this.bossPosX = 10400;
                ++this.bossStep;
            }
            case 11: {
                this.bossPosY += 50;
                if (this.bossPosY <= 1200) break;
                this.bossPosY = 1200;
                ++this.bossStep;
            }
            case 12: {
                this.bossFace = 1;
                this.bossFaceCount = 60;
                this.bossCount = 48;
                ++this.bossStep;
            }
            case 13: {
                if (this.bossCount == 8) {
                    this.SetObj2(17, nArray[2], nArray[3] + 16, 0, 0, 0, 0);
                }
                if (this.bossCount > 0) break;
                this.UpdateBossPos(nArray);
                ++this.bossStep;
            }
            case 14: {
                this.bossPosY -= 100;
                if (this.bossPosY > 0) break;
                this.bossPosY = 0;
                this.bossStep = 4;
            }
        }
    }

    private void Boss4ShotTekkyu(int n) {
        short s = boss4Sisoo[n % 3][0];
        int[] nArray = new int[25];
        for (int i = 0; i < 25; ++i) {
            nArray[i] = ObjectList[s][i];
        }
        if (nArray[13] == 0) {
            int n2 = (this.bossPosX + this.bossOfsX) / 100 + this.bossOriginX;
            int n3 = (this.bossPosY + this.bossOfsY) / 100 + this.bossOriginY - 16;
            nArray[6] = n2 << 8;
            nArray[7] = n3 + 32 << 8;
            nArray[10] = 0;
            nArray[11] = 70;
            nArray[12] = 0;
            nArray[13] = 1;
            nArray[14] = 240;
            this.InsertObject(nArray, s);
        }
    }

    private boolean Boss4HitTekkyu(int n) {
        if (this.bossFlash > 0 || this.bossStep >= 100) {
            return false;
        }
        short s = boss4Sisoo[n % 3][0];
        int[] nArray = new int[25];
        for (int i = 0; i < 25; ++i) {
            nArray[i] = ObjectList[s][i];
        }
        if (nArray[13] == 1 && nArray[14] < 210) {
            int n2 = nArray[6] >> 8;
            int n3 = nArray[7] >> 8;
            int n4 = (this.bossPosX + this.bossOfsX) / 100 + this.bossOriginX;
            int n5 = (this.bossPosY + this.bossOfsY) / 100 + this.bossOriginY - 16;
            if (n4 - 24 <= n2 && n2 <= n4 + 24 && n5 - 24 <= n3 && n3 <= n5 + 24) {
                nArray[13] = 0;
                nArray[14] = 0;
                this.InsertObject(nArray, s);
                this.SetObj2(1, n2, n3, 0, 0, 0, 0);
                return true;
            }
        }
        return false;
    }

    private void boss4_move_arai(int n) {
        boolean bl;
        int[] nArray = objectData;
        this._BossDefault(nArray);
        if (this.bossStep > 99) {
            if (this._BossDead()) {
                nArray[0] = 0;
            }
            return;
        }
        this.bossAngle2 += 400;
        this.bossOfsX = 0;
        this.bossOfsY = this.dSin(this.bossAngle2 / 100) * 8;
        int n2 = boss4Sisoo[0][1] * 100;
        int n3 = boss4Sisoo[1][1] * 100;
        int n4 = boss4Sisoo[2][1] * 100;
        this.UpdateBossPos(nArray);
        if (this.bossStep > 3 && this.bossPosY > -400) {
            this.bossPosY -= 240;
        }
        bl = (bl = false) || this.Boss4HitTekkyu(1);
        boolean bl2 = bl = bl || this.Boss4HitTekkyu(2);
        if ((this.isHitBoss() || bl) && this.bossStep > 3) {
            this.boundBossHit(nArray[2], nArray[3], 12);
            if (this.bossFlash == 0 && this.bossStep < 100) {
                if (--this.bossHP <= 0) {
                    this.bossStep = 100;
                    return;
                }
                this.bossFace = 3;
                this.bossFaceCount = 60;
                this.bossFlash = 60;
            }
        }
        switch (this.bossStep) {
            default: {
                this.bossStep = 1;
            }
            case 1: {
                this.bossFace = 1;
                this.bossAnim = 2;
                this.bossPosX = 21600;
                this.bossPosY = 9000;
                this.bossAngle = 0;
                this.bossAngle2 = 0;
                this.bossCount = 60;
                ++this.bossStep;
            }
            case 2: {
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 3: {
                this.bossPosX -= 80;
                if (this.bossPosX > n4 - 3500 + 10) break;
                ++this.bossStep;
            }
            case 4: {
                this.bossDir = 0;
                this.bossAnim = 2;
                this.bossPosX -= 80;
                if (this.bossPosX > n4 - 3500) break;
                this.bossPosX = n4 - 3500;
                this.bossAnim = 0;
                this.bossFace = 1;
                this.bossFaceCount = 50;
                this.bossCount = 50;
                ++this.bossStep;
            }
            case 5: {
                if (this.bossCount == 10) {
                    this.Boss4ShotTekkyu(2);
                }
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 6: {
                this.bossAnim = 2;
                this.bossDir = 0;
                this.bossPosX -= 80;
                if (this.bossPosX > n3 - 3500) break;
                this.bossPosX = n3 - 3500;
                this.bossAnim = 0;
                this.bossFace = 1;
                this.bossFaceCount = 50;
                this.bossCount = 50;
                ++this.bossStep;
                break;
            }
            case 7: {
                if (this.bossCount == 10) {
                    this.Boss4ShotTekkyu(1);
                }
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 8: {
                this.bossDir = 1;
                this.bossAnim = 2;
                ++this.bossStep;
            }
            case 9: {
                this.bossDir = 1;
                this.bossAnim = 2;
                this.bossPosX += 80;
                if (this.bossPosX < n3 + 3500) break;
                this.bossPosX = n3 + 3500;
                this.bossAnim = 0;
                this.bossFace = 1;
                this.bossFaceCount = 50;
                this.bossCount = 50;
                ++this.bossStep;
            }
            case 10: {
                if (this.bossCount == 10) {
                    this.Boss4ShotTekkyu(1);
                }
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 11: {
                this.bossDir = 1;
                this.bossAnim = 2;
                this.bossPosX += 80;
                if (this.bossPosX < n4 + 3500) break;
                this.bossPosX = n4 + 3500;
                this.bossAnim = 0;
                this.bossFace = 1;
                this.bossFaceCount = 50;
                this.bossCount = 50;
                ++this.bossStep;
            }
            case 12: {
                if (this.bossCount == 10) {
                    this.Boss4ShotTekkyu(2);
                }
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 13: {
                this.bossDir = 1;
                this.bossAnim = 2;
                this.bossPosX += 80;
                if (this.bossPosX < 16000) break;
                this.bossPosX = 16000;
                this.bossAnim = 0;
                this.bossFace = 1;
                this.bossFaceCount = 50;
                this.bossCount = 50;
                ++this.bossStep;
            }
            case 14: {
                this.bossDir = 0;
                this.bossStep = 4;
            }
        }
    }

    private void PreInitBoss5() {
        this.bossOriginX = 11424;
        this.bossOriginY = 1232;
        for (int i = 0; i < 10; ++i) {
            MainCanvas.boss5Block[i][0] = (short)(-160 + 32 * i + 16);
            MainCanvas.boss5Block[i][1] = 176;
            MainCanvas.boss5Block[i][2] = 0;
            MainCanvas.boss5Block[i][3] = 0;
        }
    }

    private void DestroyBoss5Block() {
        for (int i = 0; i < 10; ++i) {
            if (boss5Block[i][3] == 0) continue;
            this.ShotObj2(23, boss5Block[i][0], boss5Block[i][1], 330, 300, 0);
            this.ShotObj2(23, boss5Block[i][0], boss5Block[i][1], 30, 300, 1);
            this.ShotObj2(23, boss5Block[i][0], boss5Block[i][1], 300, 300, 2);
            this.ShotObj2(23, boss5Block[i][0], boss5Block[i][1], 60, 300, 3);
            MainCanvas.boss5Block[i][2] = 1;
        }
    }

    private void MoveBoss5Block(int n) {
        if (objectData[14] == 0) {
            this.PreInitBoss5();
            objectData[14] = objectData[14] + 1;
        }
        int n2 = this.PlayerPosX();
        int n3 = this.PlayerPosY();
        for (int i = 0; i < 10; ++i) {
            int n4;
            int n5;
            if (boss5Block[i][2] != 0) continue;
            if (boss5Block[i][3] == 0) {
                n5 = this.bossOriginX + boss5Block[i][0];
                n4 = this.bossOriginY + boss5Block[i][1];
            } else {
                n5 = this.bossOriginX + (this.bossPosX + this.bossOfsX) / 100;
                n4 = this.bossOriginY + (this.bossPosY + this.bossOfsY) / 100 + 24;
            }
            this.ColliRect(n5, n4, 16, 16);
        }
    }

    private void DrawBoss5Block(boolean bl) {
        for (int i = 0; i < 10; ++i) {
            int n;
            short s;
            int n2;
            int n3;
            if (boss5Block[i][2] != 0) continue;
            if (boss5Block[i][3] == 0) {
                n3 = boss5Block[i][0];
                n2 = boss5Block[i][1];
            } else {
                n3 = (this.bossPosX + this.bossOfsX) / 100;
                n2 = (this.bossPosY + this.bossOfsY) / 100 + 24;
            }
            if (bl && Math.abs((s = boss5Block[i][0]) - (n = (this.bossPosX + this.bossOfsX) / 100)) > 32) continue;
            this.drawRegion(gg, this.m_imgObj[102], 0, 0, 32, 32, 0, n3 + this.bossOriginX - mapView[0], n2 + this.bossOriginY - mapView[1], 1 | 2);
        }
    }

    private void boss5_move_arai(int n) {
        int[] nArray = objectData;
        int n2 = 0;
        boolean bl = false;
        this._BossDefault(nArray);
        if (this.bossStep > 99) {
            if (this._BossDead()) {
                nArray[0] = 0;
            }
            return;
        }
        this.bossAngle2 += 200;
        this.bossOfsX = 0;
        this.bossOfsY = this.dSin(this.bossAngle2 / 100) * 12;
        int n3 = (this.PlayerPosX() - (this.bossOriginX - 160)) / 32;
        int n4 = (this.bossPosX + 16000) / 3200;
        n2 = this.bossOriginX - 160 + n4 * 32 + 16;
        int n5 = Math.abs(this.bossPosX / 100 + 160 - (n4 * 32 + 16));
        if (n3 == n4 && n5 < 3 && boss5AttackCount == 0) {
            bl = true;
        }
        if (boss5AttackCount > 0) {
            --boss5AttackCount;
        }
        if (this.bossParam1 > 16 && this.IsHitSonic(nArray[2], nArray[3] + 8 - 32 + this.bossParam1, 14, 32, false) != 0) {
            this.playdamageset();
        }
        if (this.isHitBoss() && this.bossStep > 3 && this.bossFlash == 0) {
            this.boundBossHit(nArray[2], nArray[3], 10);
            if (this.bossFlash == 0 && this.bossStep < 100) {
                if (--this.bossHP <= 0) {
                    this.DestroyBoss5Block();
                    this.bossStep = 100;
                    return;
                }
                this.bossFace = 3;
                this.bossFaceCount = 60;
                this.bossFlash = 60;
            }
        }
        switch (this.bossStep) {
            default: {
                this.bossStep = 1;
            }
            case 1: {
                this.bossFace = 0;
                this.bossAnim = 2;
                this.bossPosX = 19200;
                this.bossPosY = 10000;
                this.bossAngle = 0;
                this.bossAngle2 = 0;
                this.bossCount = 50;
                boss5AttackCount = 90;
                bl = false;
                ++this.bossStep;
            }
            case 2: {
                if (this.bossCount > 0) break;
                ++this.bossStep;
            }
            case 3: {
                this.bossAnim = 2;
                this.bossPosY -= 20;
                this.bossPosX -= 100;
                if (this.bossPosX > 6400) break;
                this.bossPosX = 6400;
                this.bossAnim = 0;
                this.bossFace = 1;
                this.bossFaceCount = 60;
                this.bossCount = 60;
                ++this.bossStep;
            }
            case 4: {
                if (bl) {
                    this.bossStep = 10;
                    break;
                }
                this.bossAnim = 2;
                this.bossDir = 0;
                this.bossPosX -= 70;
                if (this.bossPosX > -12000) break;
                this.bossPosX = -12000;
                ++this.bossStep;
            }
            case 5: {
                if (bl) {
                    this.bossStep = 10;
                    break;
                }
                this.bossAnim = 2;
                this.bossDir = 1;
                this.bossPosX += 70;
                if (this.bossPosX < 12000) break;
                this.bossPosX = 12000;
                ++this.bossStep;
            }
            case 6: {
                this.bossStep = 4;
                break;
            }
            case 10: {
                this.bossAnim = 0;
                this.bossFace = 1;
                ++this.bossStep;
            }
            case 11: {
                this.bossPosY += 120;
                if (this.bossParam1 < 32) {
                    ++this.bossParam1;
                }
                if (this.bossPosY < 15400) break;
                this.bossPosY = 15400;
                this.bossCount = 48;
                MainCanvas.boss5Block[n4][3] = 1;
                ++this.bossStep;
            }
            case 12: {
                this.bossOfsX = 0;
                this.bossOfsY = this.rnd(400) - 200;
                if (this.bossCount > 0) break;
                this.bossOfsX = 0;
                this.bossOfsY = 0;
                ++this.bossStep;
            }
            case 13: {
                this.bossPosY -= 300;
                if (this.bossPosY > 2400) break;
                this.bossPosY = 2400;
                this.bossCount = 50;
                ++this.bossStep;
            }
            case 14: {
                this.bossOfsX = 0;
                this.bossOfsY = this.rnd(400) - 200;
                if (this.bossParam1 > 0) {
                    --this.bossParam1;
                }
                if (this.bossCount > 0) break;
                if (boss5Block[n4][2] == 0) {
                    this.bossOfsX = 0;
                    this.bossOfsY = 0;
                    this.ShotObj2(23, nArray[2], nArray[3] + 24, 330, 300, 0);
                    this.ShotObj2(23, nArray[2], nArray[3] + 24, 30, 300, 1);
                    this.ShotObj2(23, nArray[2], nArray[3] + 24, 300, 300, 2);
                    this.ShotObj2(23, nArray[2], nArray[3] + 24, 60, 300, 3);
                    MainCanvas.boss5Block[n4][2] = 1;
                }
                this.bossCount = 30;
                ++this.bossStep;
            }
            case 15: {
                if (this.bossCount > 0) break;
                boss5AttackCount = 120;
                this.bossStep = this.bossDir == 0 ? 4 : 5;
            }
        }
        this.UpdateBossPos(nArray);
        if (this.bossStep == 4 || this.bossStep == 5) {
            if (Math.abs(nArray[2] - this.PlayerPosX()) < 64) {
                if (this.bossPosY > 1000) {
                    this.bossPosY -= 160;
                }
            } else if (this.bossPosY < 8000) {
                this.bossPosY += 140;
            }
        }
    }

    private void ColliRect2(int n, int[] nArray, int n2, int n3) {
        int n4 = nArray[0];
        int n5 = nArray[1];
        int n6 = nArray[2] > -99999 ? nArray[2] : nArray[0];
        int n7 = nArray[3] > -99999 ? nArray[3] : nArray[1];
        int n8 = n2 >> 1;
        int n9 = n3 >> 1;
        int n10 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, n4, n5, n6, n7, n8, n9);
        if (n10 >= 0) {
            if (n10 == 0) {
                MainCanvas.PlayerParam[1] = n5 - n9 << 8;
                this.setRaidOnSize(n4, n8);
                this.playerRaidOn(n);
            } else if (n10 == 1) {
                MainCanvas.PlayerParam[0] = n4 - n8 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n10 == 2) {
                MainCanvas.PlayerParam[0] = n4 + n8 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n10 == 3) {
                MainCanvas.PlayerParam[1] = n5 + n9 + 12 + 12 + 1 << 8;
                this.setHeadHit();
            }
        }
        if (raidOn && raidObjectNum == n && n10 != 0) {
            raidOn = false;
        }
        nArray[2] = nArray[0];
        nArray[3] = nArray[1];
    }

    private void boss6_move_arai(int n) {
        int n2;
        int n3;
        int n4;
        int[] nArray = objectData;
        if (this.bossStep > 200) {
            return;
        }
        if (PlayerParam[1] >> 8 > 192) {
            MainCanvas.PlayerParam[1] = 49152;
        }
        if (PlayerParam[0] >> 8 >= 1952) {
            if (this.bossAnim != 11) {
                PlayerLookUp = true;
            }
            MainCanvas.PlayerParam[0] = 499968;
        }
        this._BossDefault(nArray);
        switch (this.bossStep) {
            default: {
                this.bossStep = 1;
            }
            case 1: {
                this.bossFace = 0;
                this.bossAnim = 0;
                this.bossPosX = 0;
                this.bossPosY = 0;
                this.bossOfsX = 0;
                this.bossOfsY = 0;
                for (int i = 0; i < 4; ++i) {
                    MainCanvas.boss6Piston[i] = 0;
                    MainCanvas.boss6PistonXY[i][2] = -99999;
                    MainCanvas.boss6PistonXY[i][3] = -99999;
                    MainCanvas.boss6TamaY[i] = 0;
                }
                boss6PistonNum = 2;
                boss6RideNum = 3;
                boss6Lamp = 1;
                boss6Destroy = 0;
                this.setWipe(0, true, 0);
                ++this.bossStep;
            }
            case 2: {
                if (this.PlayerPosX() < 1328) break;
                ++this.bossStep;
                break;
            }
            case 3: {
                int n5 = boss6RideNum;
                boss6Piston[n5] = boss6Piston[n5] + 50;
                int n6 = boss6PistonNum;
                boss6Piston[n6] = boss6Piston[n6] + 50;
                if (boss6Piston[boss6RideNum] < 2000) break;
                ++this.bossStep;
                break;
            }
            case 4: {
                int n7 = boss6RideNum;
                boss6Piston[n7] = boss6Piston[n7] + 180;
                int n8 = boss6PistonNum;
                boss6Piston[n8] = boss6Piston[n8] + 180;
                if (boss6Piston[boss6RideNum] < 16000) break;
                MainCanvas.boss6Piston[MainCanvas.boss6RideNum] = 16000;
                MainCanvas.boss6Piston[MainCanvas.boss6PistonNum] = 16000;
                ++this.bossStep;
                break;
            }
            case 5: {
                int n9 = boss6RideNum;
                boss6Piston[n9] = boss6Piston[n9] - 180;
                int n10 = boss6PistonNum;
                boss6Piston[n10] = boss6Piston[n10] - 180;
                if (boss6Piston[boss6RideNum] > 0) break;
                MainCanvas.boss6Piston[MainCanvas.boss6RideNum] = 0;
                MainCanvas.boss6Piston[MainCanvas.boss6PistonNum] = 0;
                this.bossFaceCount = 0;
                this.bossFace = 0;
                this.bossFlash = 0;
                ++this.bossStep;
            }
            case 6: {
                boss6Lamp = 2;
                this.SetObj2(27, 1415, 60, 0, 0, 0, (this.bossOriginX + 64 + 32 - this.rnd(8) + 42) * 100);
                this.SetObj2(27, 1415, 60, 0, 0, 0, (this.bossOriginX + 32 + this.rnd(46) - 23 + 42) * 100);
                this.SetObj2(27, 1415, 60, 0, 0, 0, (this.bossOriginX - 32 + this.rnd(46) - 23 + 42) * 100);
                this.SetObj2(27, 1415, 60, 0, 0, 0, (this.bossOriginX - 64 - 32 + this.rnd(24) + 42) * 100);
                this.bossCount = 300;
                ++this.bossStep;
            }
            case 7: {
                if (this.bossCount > 0) break;
                boss6RideNum = 1 + this.rnd(3);
                boss6PistonNum = (boss6RideNum + 1 + this.rnd(3)) % 4;
                boss6Lamp = 1;
                this.bossStep = 3;
                this.bossAnim = -1;
                break;
            }
            case 50: {
                boss6Lamp = 2;
                boss6Destroy = 1;
                this.bossFace = 2;
                this.bossFaceCount = 999;
                this.bossFlash = 999;
                TimerStop = true;
                ++this.bossStep;
            }
            case 51: {
                int n11 = boss6RideNum;
                boss6Piston[n11] = boss6Piston[n11] - 50;
                int n12 = boss6PistonNum;
                boss6Piston[n12] = boss6Piston[n12] - 50;
                if (boss6Piston[boss6RideNum] > 0) break;
                MainCanvas.boss6Piston[MainCanvas.boss6RideNum] = 0;
                MainCanvas.boss6Piston[MainCanvas.boss6PistonNum] = 0;
                this.bossFaceCount = 0;
                this.bossFace = 0;
                this.bossFlash = 0;
                this.bossCount = 60;
                boss6Destroy = 2;
                boss6Lamp = 3;
                ++this.bossStep;
            }
            case 52: {
                if (this.bossCount > 0) break;
                this.bossStep = 100;
                break;
            }
            case 100: {
                boss6Lamp = 0;
                boss6Destroy = 0;
                this.bossOfsX = 0;
                this.bossOfsY = 0;
                this.bossPosX = (1472 - this.bossOriginX) * 100;
                this.bossPosY = (168 - this.bossOriginY) * 100;
                this.UpdateBossPos(nArray);
                this.bossAnim = 7;
                TimerStop = true;
                this.endBossMode();
                ++this.bossStep;
            }
            case 101: {
                if (nArray[2] - this.PlayerPosX() < 150) {
                    this.bossPosX += 50;
                }
                if (nArray[2] - this.PlayerPosX() < 110) {
                    this.bossPosX += 400;
                }
                if (nArray[2] - this.PlayerPosX() < 70) {
                    this.bossPosX += 500;
                }
                if (nArray[2] < 1696) break;
                nArray[2] = 1696;
                nArray[10] = 200;
                nArray[11] = -300;
                ++this.bossStep;
            }
            case 102: {
                this.bossPosX += nArray[10];
                this.bossPosY += nArray[11];
                nArray[11] = nArray[11] + 12;
                if (nArray[11] > 600) {
                    nArray[11] = 600;
                }
                if (nArray[2] < 1760) break;
                this.bossPosX = (1760 - this.bossOriginX) * 100;
                this.bossPosY = (168 - this.bossOriginY) * 100;
                nArray[10] = 0;
                nArray[11] = -50;
                this.bossAnim = 8;
                this.bossCount = 60;
                ++this.bossStep;
            }
            case 103: {
                this.bossPosX += nArray[10];
                this.bossPosY += nArray[11];
                if (this.bossCount > 0) break;
                nArray[10] = 25;
                nArray[11] = -100;
                this.bossAnim = 9;
                this.bossCount = 30;
                ++this.bossStep;
            }
            case 104: {
                this.bossPosX += nArray[10];
                this.bossPosY += nArray[11];
                if (this.bossCount > 0) break;
                nArray[10] = 200;
                nArray[11] = 0;
                this.bossAnim = 10;
                ++this.bossStep;
            }
            case 105: {
                this.bossPosX += nArray[10];
                this.bossPosY += nArray[11];
                this.UpdateBossPos(nArray);
                if (nArray[2] > 2168) {
                    this.bossCount = 120;
                    this.bossStep = 107;
                    break;
                }
                n4 = (this.bossPosX + this.bossOfsX) / 100 + this.bossOriginX - this.PlayerPosX();
                n2 = n4 * n4 + (n3 = (this.bossPosY + this.bossOfsY) / 100 + this.bossOriginY - (this.PlayerPosY() - 16)) * n3;
                if (n2 >= 1444 || !PlayerBall) break;
                this.boundBossHit(nArray[2], nArray[3], 6);
                nArray[10] = 100;
                nArray[11] = 40;
                this.bossAnim = 11;
                ++this.bossStep;
                break;
            }
            case 106: {
                this.bossPosX += nArray[10];
                this.bossPosY += nArray[11];
                this.UpdateBossPos(nArray);
                if (nArray[2] < 2168) break;
                this.bossCount = 120;
                ++this.bossStep;
                break;
            }
            case 107: {
                this.playerStandCount = 120;
                if (this.doWipe(true)) {
                    // empty if block
                }
                if (this.bossCount == 10) {
                    this.putNowLoading = true;
                }
                if (this.bossCount > 0) break;
                this.setWipe(0, true, 8);
                this.bossStep = 200;
                break;
            }
            case 200: {
                this.playerStandCount = 0;
                this.setEnding();
                this.setWipe(0, true, 8);
                this.putNowLoading = true;
                nArray[0] = 0;
                ++this.bossStep;
                return;
            }
            case 201: {
                this.putNowLoading = true;
                this.setWipe(0, true, 8);
            }
        }
        this.AddObjectData(48, 1216, 16, 0, 0);
        this.AddObjectData(48, 1248, 16, 0, 0);
        this.AddObjectData(48, 1344, 16, 0, 0);
        this.AddObjectData(48, 1376, 16, 0, 0);
        if (this.bossStep < 100) {
            switch (boss6RideNum) {
                default: {
                    this.bossPosY = 0;
                    this.bossPosX = 0;
                    break;
                }
                case 0: {
                    this.bossPosX = boss6PistonPos[0][0] * 100;
                    this.bossPosY = boss6PistonPos[0][1] * 100 + boss6Piston[0] + -800;
                    break;
                }
                case 1: {
                    this.bossPosX = boss6PistonPos[1][0] * 100;
                    this.bossPosY = boss6PistonPos[1][1] * 100 + boss6Piston[1] + -800;
                    break;
                }
                case 2: {
                    this.bossPosX = boss6PistonPos[2][0] * 100;
                    this.bossPosY = boss6PistonPos[2][1] * 100 - boss6Piston[2] + 1600;
                    break;
                }
                case 3: {
                    this.bossPosX = boss6PistonPos[3][0] * 100;
                    this.bossPosY = boss6PistonPos[3][1] * 100 - boss6Piston[3] + 1600;
                }
            }
        }
        MainCanvas.boss6PistonXY[0][0] = boss6PistonPos[0][0] + this.bossOriginX;
        MainCanvas.boss6PistonXY[0][1] = boss6PistonPos[0][1] + this.bossOriginY - 8 + boss6Piston[0] / 100;
        this.ColliRect2(46592, boss6PistonXY[0], 64, 160);
        MainCanvas.boss6PistonXY[1][0] = boss6PistonPos[1][0] + this.bossOriginX;
        MainCanvas.boss6PistonXY[1][1] = boss6PistonPos[1][1] + this.bossOriginY - 8 + boss6Piston[1] / 100;
        this.ColliRect2(46593, boss6PistonXY[1], 64, 160);
        MainCanvas.boss6PistonXY[2][0] = boss6PistonPos[2][0] + this.bossOriginX;
        MainCanvas.boss6PistonXY[2][1] = boss6PistonPos[2][1] + this.bossOriginY + 8 - boss6Piston[2] / 100;
        this.ColliRect2(46594, boss6PistonXY[2], 64, 160);
        MainCanvas.boss6PistonXY[3][0] = boss6PistonPos[3][0] + this.bossOriginX;
        MainCanvas.boss6PistonXY[3][1] = boss6PistonPos[3][1] + this.bossOriginY + 8 - boss6Piston[3] / 100;
        this.ColliRect2(46595, boss6PistonXY[3], 64, 160);
        if (boss6Destroy == 1) {
            if ((this.animeTimer & 3) == 0) {
                n4 = boss6PistonPos[boss6RideNum][0] + this.bossOriginX;
                n3 = boss6PistonPos[boss6RideNum][1] + this.bossOriginY;
                n2 = boss6Piston[boss6RideNum] / 100;
                if ((boss6RideNum & 2) != 0) {
                    n2 = -n2;
                }
                this.SetObj2(1, n4 + this.rnd(64) - 32, n3 + this.rnd(128) - 64 + n2, 0, 0, 0, 0);
            } else if ((this.animeTimer & 3) == 2 && boss6PistonNum != 0) {
                n4 = boss6PistonPos[boss6PistonNum][0] + this.bossOriginX;
                n3 = boss6PistonPos[boss6PistonNum][1] + this.bossOriginY;
                n2 = boss6Piston[boss6PistonNum] / 100;
                if ((boss6PistonNum & 2) != 0) {
                    n2 = -n2;
                }
                this.SetObj2(1, n4 + this.rnd(64) - 32, n3 + this.rnd(128) - 64 + n2, 0, 0, 0, 0);
            }
        } else if (boss6Destroy == 2 && (this.animeTimer & 7) == 0) {
            this.SetObj2(1, 1415 + this.rnd(16) - 8, 60 + this.rnd(16) - 8, 0, 0, 0, 0);
        }
        if (this.isHitBoss6() && this.bossStep < 50) {
            MainCanvas.PlayerParam[3] = nArray[2] < this.PlayerPosX() ? 768 : -768;
            MainCanvas.PlayerParam[5] = -1536;
            if (--this.bossHP <= 0) {
                this.bossStep = 50;
                return;
            }
            this.bossFace = 1;
            this.bossFaceCount = 120;
            this.bossFlash = 120;
            this.bossStopCount = 0;
        }
    }

    private boolean moveNaka() {
        if (nakaCount > 0) {
            --nakaCount;
        }
        switch (nakaStep) {
            default: {
                nakaStep = 1;
            }
            case 1: {
                nakaLevel = 0;
                ++nakaStep;
                break;
            }
            case 2: {
                if ((nakaLevel += 4) < 255) break;
                nakaLevel = 255;
                nakaCount = 180;
                ++nakaStep;
                break;
            }
            case 3: {
                if (nakaCount > 0) break;
                ++nakaStep;
                break;
            }
            case 4: {
                if ((nakaLevel -= 4) > 0) break;
                nakaLevel = 0;
                ++nakaStep;
                break;
            }
            case 5: {
                return true;
            }
        }
        return false;
    }

    private void drawNaka() {
        int n = nakaLevel;
        Font font = Font.getFont((int)0, (int)0, (int)8);
        gg.setColor(0);
        gg.fillRect(0, 0, 240, 240);
        gg.setFont(font);
        int n2 = (n &= 0xFF) << 16 | n << 8 | n;
        int n3 = n;
        int n4 = 116;
        int n5 = 22;
        this.drawRegion(gg, this.m_imgObj[124], 0, 0, 54, 15, 0, 206, 152, 1 | 2);
        this.TK_DrawStringC(softKeys[25], 120, 96, n2, n3);
        this.TK_DrawStringC(softKeys[26], 120, 121, n2, n3);
    }

    private void drawEndingEggmanB() {
        int n = endingEggAnim % 3;
        gg.setColor(0);
        gg.fillRect(0, 0, 240, 240);
        short s = RectTblEndingB[n][0];
        short s2 = RectTblEndingB[n][1];
        short s3 = RectTblEndingB[n][2];
        short s4 = RectTblEndingB[n][3];
        this.drawRegion(gg, this.m_imgObj[123], s, s2, s3, s4, 0, 120, 90, 1 | 2);
    }

    private boolean moveEndingEggmanB() {
        if (endingEggCount > 0) {
            --endingEggCount;
        }
        endingEggAnim = (this.animeTimer >> 1) % 3;
        switch (endingEggStep) {
            default: {
                endingEggStep = 1;
            }
            case 1: {
                this.setWipe(0, true, 0);
                endingEggCount = 300;
                ++endingEggStep;
            }
            case 2: {
                if (endingEggCount > 0) break;
                ++endingEggStep;
                break;
            }
            case 3: {
                return true;
            }
        }
        return false;
    }

    void setWipe(int n, boolean bl, int n2) {
        wipeCol = n;
        wipeDir = bl;
        wipeLevel = n2;
    }

    boolean doWipe(boolean bl) {
        if (bl) {
            if ((this.animeTimer & 3) == 0 && wipeLevel < 8) {
                ++wipeLevel;
            }
            return wipeLevel >= 8;
        }
        if ((this.animeTimer & 3) == 0 && wipeLevel > 0) {
            --wipeLevel;
        }
        return wipeLevel == 0;
    }

    void drawWipe() {
        block4: {
            if (wipeLevel <= 0) break block4;
            gg.setColor(0);
            if (wipeDir) {
                for (int i = 0; i < 240; i += 8) {
                    gg.fillRect(0, i, 240, wipeLevel);
                }
            } else {
                for (int i = 0; i < 240; i += 8) {
                    gg.fillRect(0, i + 7 - wipeLevel, 240, wipeLevel);
                }
            }
        }
    }

    private void moveEnding() {
        ringcount = 0;
        timecount = 0;
        timecount2 = 0;
        if (this.endingCount > 0) {
            --this.endingCount;
        }
        if (this.endingStep >= 4 && this.rnd(15) == 0) {
            if (this.rnd(2) == 0) {
                this.SetObj2(28 + this.rnd(7), -20, this.PlayerPosY() - (30 + this.rnd(120)), 0, 300, 1, 0);
            } else {
                this.SetObj2(28 + this.rnd(7), 260, this.PlayerPosY() - (30 + this.rnd(120)), 0, 300, 0, 0);
            }
        }
        switch (this.endingStep) {
            default: {
                this.endingStep = 1;
            }
            case 1: {
                try {
                    for (int i = 0; i < 150; ++i) {
                        this.m_imgObj[i] = null;
                    }
                    this.DoGc();
                    this.m_imgObj[100] = this.createImage("/animal.png");
                    this.m_imgObj[121] = this.createImage("/ED_00.png");
                    this.m_imgObj[122] = this.createImage("/ED3.png");
                    this.m_imgObj[123] = this.createImage("/endegg_b.png");
                    this.m_imgObj[124] = this.createImage("/t_license3.png");
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                this.countClear();
                this.endingCount = 180;
                this.endingLogoPosX = -102;
                this.endingAnim = -1;
                this.endingType = 0;
                this.endingStringFadeLevel = 0;
                this.setWipe(0, true, 8);
                TimerClear = true;
                TimerStop = true;
                this.putNowLoading = false;
                bossModeOn = false;
                bossBreakOn = false;
                this.PlayMusic(16);
                ++this.endingStep;
                break;
            }
            case 2: {
                this.doWipe(false);
                MainCanvas.PlayerParam[10] = -2048;
                MainCanvas.PlayerParam[12] = 1;
                this.playerRaidOn(-1);
                if (this.rnd(12) == 0) {
                    switch (this.rnd(3)) {
                        default: {
                            this.SetObj2(28, this.PlayerPosX() - 300, this.PlayerPosY() - (30 + this.rnd(120)), 0, 300, 0, 0);
                            break;
                        }
                        case 1: {
                            this.SetObj2(31, this.PlayerPosX() - 300, this.PlayerPosY() - (30 + this.rnd(120)), 0, 300, 0, 0);
                            break;
                        }
                        case 2: {
                            this.SetObj2(33, this.PlayerPosX() - 300, this.PlayerPosY() - (30 + this.rnd(120)), 0, 300, 0, 0);
                        }
                    }
                }
                if (this.PlayerPosX() > 64) break;
                ++this.endingStep;
                break;
            }
            case 3: {
                PlayerParam[10] = PlayerParam[10] < 768 ? PlayerParam[10] + 80 : 768;
                MainCanvas.PlayerParam[12] = 0;
                if (this.PlayerPosX() < 160) break;
                MainCanvas.PlayerParam[0] = 40960;
                MainCanvas.PlayerParam[10] = 0;
                this.endingCount = 265;
                ++this.endingStep;
                break;
            }
            case 4: {
                this.playerStandCount = 120;
                if (this.endingCount > 0) break;
                ++this.endingStep;
            }
            case 5: {
                this.endingAnim = 0;
                this.endingLogoPosX += 8;
                if (this.endingLogoPosX < 46) break;
                this.endingCount = 48;
                ++this.endingStep;
                break;
            }
            case 6: {
                muteki2count = 1;
                this.endingAnim = 1;
                if (this.endingCount > 0) break;
                this.endingCount = 10;
                ++this.endingStep;
            }
            case 7: {
                muteki2count = 1;
                this.endingAnim = 2;
                if (this.endingCount > 0) break;
                this.endingCount = 10;
                ++this.endingStep;
            }
            case 8: {
                muteki2count = 1;
                this.endingAnim = 3;
                if (this.endingCount > 0) break;
                this.endingCount = 300;
                ++this.endingStep;
            }
            case 9: {
                muteki2count = 1;
                if (this.endingCount > 0) break;
                this.endingCount = 34;
                ++this.endingStep;
            }
            case 10: {
                muteki2count = 1;
                this.doWipe(true);
                if (this.endingCount > 0) break;
                this.endingType = 1;
                endingEggStep = 0;
                ++this.endingStep;
                break;
            }
            case 11: {
                muteki2count = 1;
                if (!this.moveEndingEggmanB()) break;
                this.endingType = 2;
                nakaStep = 0;
                ++this.endingStep;
            }
            case 12: {
                muteki2count = 1;
                if (!this.moveNaka()) break;
                this.endingStep = 100;
                break;
            }
            case 100: {
                muteki2count = 1;
                this.endingModeOn = false;
                mode = MODE_TITLE;
                this.ObjImageClear();
                this.TK_TitleInit(false);
            }
        }
    }

    private void drawEnding() {
        this._drawEnding();
        this.drawWipe();
    }

    private void _drawEnding() {
        if (this.endingStep < 2) {
            return;
        }
        if (this.endingType == 1) {
            this.drawEndingEggmanB();
            return;
        }
        if (this.endingType == 2) {
            this.drawNaka();
            return;
        }
        if (this.endingAnim < 0) {
            return;
        }
        this.drawRegion(gg, this.m_imgObj[121], 0, 0, 96, 32, 0, this.endingLogoPosX, 110, 1 | 2);
        switch (this.endingAnim) {
            default: {
                break;
            }
            case 1: {
                this.drawRegion(gg, this.m_imgObj[122], 0, 0, 32, 40, 0, 120, 96, 1 | 2);
                break;
            }
            case 2: {
                this.drawRegion(gg, this.m_imgObj[122], 0, 40, 48, 72, 0, 120, 96, 1 | 2);
                break;
            }
            case 3: {
                this.drawRegion(gg, this.m_imgObj[122], 48, 0, 176, 136, 0, 162, 96, 1 | 2);
            }
        }
    }

    private void boss1_draw_arai(int n) {
        this.AraiDrawBoss(objectData);
    }

    private void boss2_draw_arai(int n) {
        this.AraiDrawBoss(objectData);
    }

    private void boss3_draw_arai(int n) {
        this.AraiDrawBoss(objectData);
    }

    private void boss4_draw_arai(int n) {
        this.AraiDrawBoss(objectData);
    }

    private void boss5_draw_arai(int n) {
        this.AraiDrawBoss(objectData);
        this.DrawBoss5Block(true);
    }

    private void drawBoss6Piston(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10 = this.bossOriginX + n - mapView[0];
        int n11 = this.bossOriginY + n2 - mapView[1];
        if (n3 == 0) {
            n9 = n4;
            n8 = -84;
            n7 = -24;
            n6 = 24;
            n5 = 3;
        } else {
            n9 = -n4;
            n8 = 84;
            n7 = 24;
            n6 = -24;
            n5 = 0;
        }
        this.drawRegion(gg, this.m_imgObj[145], 0, 0, 64, 144, n5, n10, n11 + n9, 1 | 2);
        switch ((this.animeTimer >> 1) % 3) {
            default: {
                break;
            }
            case 1: {
                this.drawRegion(gg, this.m_imgObj[145], 64, 0, 16, 16, n5, n10, n11 + n9 + n6, 1 | 2);
                break;
            }
            case 2: {
                this.drawRegion(gg, this.m_imgObj[145], 64, 16, 16, 16, n5, n10, n11 + n9 + n6, 1 | 2);
            }
        }
        if (n4 > 0) {
            this.drawRegion(gg, this.m_imgObj[145], 16, 120, 32, 24, n5, n10, n11 + n9 + n8, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[145], 16, 120, 32, 24, n5, n10, n11 + n9 + n8 + n7, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[145], 16, 120, 32, 24, n5, n10, n11 + n9 + n8 + n7 + n7, 1 | 2);
        }
    }

    private void drawBoss6Lamp(int n) {
        int n2 = 1415 - mapView[0];
        int n3 = 60 - mapView[1];
        switch (n) {
            case 0: {
                return;
            }
            case 1: {
                break;
            }
            case 2: {
                this.drawRegion(gg, this.m_imgObj[145], 80, 0, 16, 16, 0, n2, n3, 1 | 2);
                break;
            }
            case 3: {
                this.drawRegion(gg, this.m_imgObj[145], 80, 16, 16, 16, 0, n2, n3, 1 | 2);
                break;
            }
            case 4: {
                this.drawRegion(gg, this.m_imgObj[145], 80, 32, 16, 16, 0, n2, n3, 1 | 2);
            }
        }
    }

    private void drawEggman(int n, int n2, int n3, int n4) {
        int n5;
        int n6 = 0;
        switch (n) {
            default: {
                n6 = 0 + (this.animeTimer >> 1 & 1);
                break;
            }
            case 1: {
                n6 = 2 + (this.animeTimer & 1);
                break;
            }
            case 2: {
                n6 = 4;
                break;
            }
            case 3: {
                n6 = 5 + (this.animeTimer >> 1) % 3;
            }
        }
        short s = this.RectEggmanTbl[n6][0];
        short s2 = this.RectEggmanTbl[n6][1];
        short s3 = this.RectEggmanTbl[n6][2];
        short s4 = this.RectEggmanTbl[n6][3];
        switch (n4) {
            default: {
                n5 = 0;
                break;
            }
            case 1: {
                n5 = 2;
                break;
            }
            case 2: {
                n5 = 1;
                break;
            }
            case 3: {
                n5 = 3;
            }
        }
        this.drawRegion(gg, this.m_imgObj[146], s, s2, s3, s4, n5, n2 - mapView[0], n3 - mapView[1], 1 | 2);
    }

    private void boss6_draw_arai(int n) {
        int[] nArray = objectData;
        if (this.bossStep > 200) {
            return;
        }
        this.UpdateBossPos(nArray);
        if (this.bossStep < 100) {
            this.drawEggman(this.bossFace, nArray[2], nArray[3], 0);
        } else {
            this.AraiDrawBoss(nArray);
        }
        this.drawBoss6Piston(boss6PistonPos[0][0], boss6PistonPos[0][1], 0, boss6Piston[0] / 100);
        this.drawBoss6Piston(boss6PistonPos[1][0], boss6PistonPos[1][1], 0, boss6Piston[1] / 100);
        this.drawBoss6Piston(boss6PistonPos[2][0], boss6PistonPos[2][1], 1, boss6Piston[2] / 100);
        this.drawBoss6Piston(boss6PistonPos[3][0], boss6PistonPos[3][1], 1, boss6Piston[3] / 100);
        switch (boss6Lamp) {
            default: {
                this.drawBoss6Lamp(2);
                break;
            }
            case 0: {
                this.drawBoss6Lamp(1);
                break;
            }
            case 2: 
            case 3: {
                this.drawBoss6Lamp(3 + (this.animeTimer & 1));
            }
        }
        this.drawWipe();
    }

    private void AraiOfsDraw(Image image, int n, int n2, int n3, short[] sArray) {
        int n4;
        short s = sArray[0];
        short s2 = sArray[1];
        short s3 = sArray[2];
        short s4 = sArray[3];
        short s5 = sArray[4];
        short s6 = sArray[5];
        switch (n3) {
            default: {
                n4 = 0;
                break;
            }
            case 1: {
                n4 = 2;
                s5 = -s5;
                break;
            }
            case 2: {
                n4 = 1;
                s6 = -s6;
                break;
            }
            case 3: {
                n4 = 3;
                s5 = -s5;
                s6 = -s6;
            }
        }
        this.drawRegion(gg, image, s, s2, s3, s4, n4, n - mapView[0] + s5, n2 - mapView[1] + s6, 1 | 2);
    }

    private void DrawBossFace(int n, int n2, int n3, int n4, int n5) {
        switch (n) {
            case 0: {
                if (n5 == 0) {
                    this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[1]);
                    break;
                }
                this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[2]);
                break;
            }
            case 1: {
                if (n5 == 0) {
                    this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[3]);
                    break;
                }
                this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[4]);
                break;
            }
            case 2: {
                if (n5 == 0) {
                    this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[1]);
                    break;
                }
                this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[6]);
                break;
            }
            case 3: {
                this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[6]);
                break;
            }
            case 4: {
                this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[7]);
                break;
            }
            case 5: {
                if (n5 == 0) {
                    this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[21]);
                    break;
                }
                this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[22]);
                break;
            }
            case 6: {
                this.AraiOfsDraw(this.m_imgObj[120], n2, n3, n4, this.RectBossTbl[0]);
            }
        }
    }

    private void DrawBossPartsStage1(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        short s = this.RectBossTbl[15][4];
        short s2 = this.RectBossTbl[15][5];
        int n8 = this.bossParam1;
        int n9 = this.bossAngle / 100;
        if (n3 == 1) {
            s = -s;
        }
        while (n9 < 0) {
            n9 += 360;
        }
        int n10 = 180 + this.dSin(n9) * 90 / 100;
        if (n8 > 16) {
            this.AraiOfsDraw(this.m_imgObj[120], n, n2, n3, this.RectBossTbl[15 + (this.animeTimer >> 2 & 1)]);
        }
        for (n7 = 0; n7 < 4; ++n7) {
            int n11 = (n7 + 1) * 16;
            n6 = n + this.dSin(n10) * n11 / 100 + s;
            n5 = n2 + this.dCos(n10) * n11 / 100 + s2;
            if (n8 > 16 + n11) {
                this.AraiOfsDraw(this.m_imgObj[120], n6, n5, 0, this.RectBossTbl[17]);
            }
            if (n4 != 2 || Math.abs(n8 - (16 + n11)) >= 4) continue;
            this.SetObj2(1, n6, n5, 0, 0, 0, 0);
        }
        n6 = n + s + this.dSin(n10) * n8 / 100;
        n5 = n2 + s2 + this.dCos(n10) * n8 / 100;
        if (n4 == 2) {
            n7 = n + s + this.dSin(n10) * 96 / 100;
            int n12 = n2 + s2 + this.dCos(n10) * 96 / 100;
            this.AraiOfsDraw(this.m_imgObj[121], n7, n12, 0, this.RectBossBallTbl);
            if ((this.animeTimer & 7) == 4) {
                this.SetObj2(1, n7 + this.rnd(48) - 24, n12 + this.rnd(48) - 24, 0, 0, 0, 0);
            }
        } else {
            this.AraiOfsDraw(this.m_imgObj[121], n6, n5, 0, this.RectBossBallTbl);
        }
    }

    private void DrawBossPartsStage2(int n, int n2, int n3, int n4) {
    }

    private void DrawBossPartsStage3(int n, int n2, int n3, int n4) {
        this.AraiOfsDraw(this.m_imgObj[120], n, n2, n3, this.RectBossTbl[19]);
    }

    private void DrawBossPartsStage4(int n, int n2, int n3, int n4) {
        this.AraiOfsDraw(this.m_imgObj[120], n, n2, n3, this.RectBossTbl[19]);
    }

    private void DrawBossPartsStage5(int n, int n2, int n3, int n4) {
        this.AraiOfsDraw(this.m_imgObj[120], n, n2 + 8 - 32 + this.bossParam1, n3, this.RectBossTbl[20]);
    }

    private void DrawBossPartsStage6(int n, int n2, int n3, int n4) {
    }

    private void DrawBossParts(int n, int n2, int n3) {
        switch (this.bossType) {
            case 0: {
                this.DrawBossPartsStage1(n, n2, n3, 0);
                break;
            }
            case 1: {
                this.DrawBossPartsStage2(n, n2, n3, 0);
                break;
            }
            case 2: {
                this.DrawBossPartsStage3(n, n2, n3, 0);
                break;
            }
            case 3: {
                this.DrawBossPartsStage4(n, n2, n3, 0);
                break;
            }
            case 4: {
                this.DrawBossPartsStage5(n, n2, n3, 0);
                break;
            }
            case 5: {
                this.DrawBossPartsStage6(n, n2, n3, 0);
            }
        }
    }

    private void DrawBossEnd(int n, int n2, int n3) {
        switch (this.bossType) {
            case 0: {
                this.DrawBossPartsStage1(n, n2, n3, 2);
                break;
            }
            case 1: {
                this.DrawBossPartsStage2(n, n2, n3, 2);
                break;
            }
            case 2: {
                this.DrawBossPartsStage3(n, n2, n3, 2);
                break;
            }
            case 3: {
                this.DrawBossPartsStage4(n, n2, n3, 2);
                break;
            }
            case 4: {
                this.DrawBossPartsStage5(n, n2, n3, 2);
                break;
            }
            case 5: {
                this.DrawBossPartsStage6(n, n2, n3, 2);
            }
        }
    }

    private void AraiDrawBoss(int[] nArray) {
        int n = this.animeTimer >> 3 & 1;
        int n2 = this.animeTimer >> 2 & 1;
        int n3 = this.animeTimer >> 1 & 1;
        int n4 = this.animeTimer & 1;
        if (this.bossStep < 2) {
            return;
        }
        int n5 = nArray[1];
        this.UpdateBossPos(nArray);
        int n6 = nArray[2];
        int n7 = nArray[3];
        int n8 = this.bossAnim;
        int n9 = this.bossDir;
        int n10 = (this.animeTimer & 1) == 0 && this.bossFlash > 0 ? 1 : 0;
        switch (n8) {
            case 0: {
                this.DrawBossParts(n6, n7, n9);
                this.DrawBossFace(this.bossFace, n6, n7, n9, n2);
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[8 + n10]);
                break;
            }
            case 1: {
                this.DrawBossParts(n6, n7, n9);
                this.DrawBossFace(1, n6, n7, n9, n2);
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[8]);
                break;
            }
            case 2: {
                this.DrawBossParts(n6, n7, n9);
                this.DrawBossFace(this.bossFace, n6, n7, n9, n2);
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[11 + n4]);
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[8 + n10]);
                break;
            }
            case 3: {
                this.DrawBossEnd(n6, n7, n9);
                this.DrawBossFace(2, n6, n7, n9, n);
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[8]);
                if (n2 == 0) break;
                this.SetObj2(1, n6 + this.rnd(32) - 16, n7 + this.rnd(32) - 16 - 8, 0, 0, 0, 0);
                break;
            }
            case 4: {
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[7]);
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[8]);
                break;
            }
            case 5: {
                this.DrawBossFace(0, n6, n7, n9, n2);
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[8]);
                if (n3 == 1) {
                    this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[18]);
                }
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[13 + n2]);
                break;
            }
            case 6: {
                this.DrawBossFace(0, n6, n7, n9, n2);
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[8]);
                if (n3 != 0) {
                    this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[18]);
                }
                this.AraiOfsDraw(this.m_imgObj[120], n6, n7, n9, this.RectBossTbl[11 + n4]);
                break;
            }
            case 7: {
                this.DrawBossFace(6, 1760, 168, 1, 0);
                this.AraiOfsDraw(this.m_imgObj[147], 1760, 168, n9, this.RectBoss2Tbl[0]);
                this.drawEggman(3, n6, n7, 1);
                break;
            }
            case 8: {
                this.DrawBossFace(0, n6, n7, 1, n2);
                this.AraiOfsDraw(this.m_imgObj[147], n6, n7, 1, this.RectBoss2Tbl[0]);
                break;
            }
            case 9: {
                this.DrawBossFace(0, n6, n7, 1, n2);
                this.AraiOfsDraw(this.m_imgObj[147], n6, n7, 1, this.RectBoss2Tbl[1]);
                break;
            }
            case 10: {
                this.DrawBossFace(0, n6, n7, 1, n2);
                this.AraiOfsDraw(this.m_imgObj[147], n6, n7, 1, this.RectBoss2Tbl[2]);
                break;
            }
            case 11: {
                this.DrawBossFace(5, n6, n7, 1, n2);
                this.AraiOfsDraw(this.m_imgObj[147], n6, n7, 1, this.RectBoss2Tbl[3]);
                if (n2 == 0) break;
                this.SetObj2(1, n6 + this.rnd(32) - 16, n7 + this.rnd(32) - 16 - 8, 0, 0, 0, 0);
            }
        }
    }

    private void startContinue() {
        continueStep = 0;
        mode = MODE_CONTINUE;
    }

    private void moveContinue() {
        if (continueCount > 0 && continueStep < 4) {
            --continueCount;
        }
        switch (continueStep) {
            default: {
                continueStep = 1;
            }
            case 1: {
                continueSonicPosX = 120;
                continueSonicPosY = -20;
                continueCount = 164;
                continueResult = 0;
                continueSonicAnim = -1;
                continueSonicAnim2 = -1;
                try {
                    for (int i = 120; i < 150; ++i) {
                        this.m_imgObj[i] = null;
                    }
                    this.DoGc();
                    this.m_imgObj[121] = this.createImage("/continue.png");
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                this.PlayMusic(22);
                ++continueStep;
            }
            case 2: {
                continueSonicAnim = 0;
                if ((continueSonicPosY += 15) < 167) break;
                continueSonicPosY = 167;
                continueSonicAnim = 1;
                ++continueStep;
            }
            case 3: {
                if (continueCount == 0) {
                    this.resultContinue(false);
                    continueStep = 999;
                    break;
                }
                if (!KeyPress[0]) break;
                continueSonicAnim = 2;
                continueSonicAnim2 = 0;
                this.clearKey();
                ++continueStep;
                break;
            }
            case 4: {
                if (++continueSonicAnim2 > 8) {
                    ++continueSonicPosX;
                }
                if (continueSonicAnim2 > 12) {
                    continueSonicPosX += 20;
                }
                if (continueSonicAnim2 < 45) break;
                ++continueStep;
                break;
            }
            case 5: {
                this.StopMusic();
                this.resultContinue(true);
                continueStep = 999;
            }
            case 999: 
        }
    }

    private void drawContinue() {
        int n = continueSonicPosX;
        int n2 = continueSonicPosY;
        int n3 = 120;
        gg.setColor(0);
        gg.fillRect(0, 0, 240, 240);
        if (continueStep < 2) {
            return;
        }
        if (continueSonicAnim == 0) {
            gg.drawRegion(this.m_imgObj[121], 0, 0, 48, 32, 0, n3, 167, 1 | 2);
            int n4 = this.animeTimer % 5;
            short s = ContinueSonicTbl[n4][0];
            short s2 = ContinueSonicTbl[n4][1];
            int n5 = 48;
            int n6 = 24;
            int n7 = ContinueSonicTbl[n4][2] == 0 ? 0 : 2;
            gg.drawRegion(this.m_imgCmd[SONIC_N], (int)s, (int)s2, n5, n6, n7, n, n2, 1 | 2);
        } else if (continueSonicAnim == 1) {
            int n8 = this.animeTimer >> 2 & 3;
            short s = ContinueSonicTbl2[n8][0];
            short s3 = ContinueSonicTbl2[n8][1];
            int n9 = 48;
            int n10 = 32;
            gg.drawRegion(this.m_imgObj[121], (int)s, (int)s3, n9, n10, 0, n3, 167, 1 | 2);
        } else if (continueSonicAnim == 2) {
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16 = continueSonicAnim2;
            if (continueSonicAnim2 < 0) {
                n16 = 0;
            }
            if (continueSonicAnim2 < 1) {
                n15 = 48;
                n14 = 120;
                n13 = 48;
                n12 = 24;
                n11 = -16;
            } else {
                n16 = continueSonicAnim2 < 12 ? (continueSonicAnim2 >> 1) % 6 : 6 + (continueSonicAnim2 - 12) % 4;
                n15 = n16 * 40;
                n14 = 40;
                n13 = 40;
                n12 = 40;
                n11 = -4;
            }
            gg.drawRegion(this.m_imgObj[121], 0, 0, 48, 32, 0, n3, 167, 1 | 2);
            gg.drawRegion(this.m_imgCmd[SONIC_N], n15, n14, n13, n12, 0, n, n2 + n11, 1 | 2);
        }
        gg.drawRegion(this.m_imgObj[121], 96, 0, 16, 16, 0, n3 - 16, 128, 1 | 2);
        gg.drawRegion(this.m_imgObj[121], 96, 0, 16, 16, 0, n3 + 16, 128, 1 | 2);
        int n17 = continueCount / 15 % 10;
        int n18 = continueCount / 15 / 10 % 10;
        gg.drawRegion(this.m_imgCmd[WINDOU_SUUJI], n18 * 7, 0, 7, 13, 0, n3 - 4, 128, 1 | 2);
        gg.drawRegion(this.m_imgCmd[WINDOU_SUUJI], n17 * 7, 0, 7, 13, 0, n3 + 4, 128, 1 | 2);
        gg.drawRegion(this.m_imgObj[121], 0, 64, 120, 16, 0, n3, 80, 1 | 2);
    }

    private void IkeshitaLoadStageImage(int n) {
        try {
            if (this.zoneNumber == 5) {
                this.m_imgObj[MainCanvas.BURANKO] = this.createImage("/buranko_.png");
                this.m_imgObj[35] = this.createImage("/noko.png");
                this.m_imgObj[MainCanvas.DOOR] = this.createImage("/door.png");
                this.m_imgObj[MainCanvas.BELTC] = this.createImage("/beltc.png");
                this.m_imgObj[31] = this.createImage("/yukae.png");
                this.m_imgObj[29] = this.createImage("/yukai.png");
                this.m_imgObj[84] = this.createImage("/beltcon.png");
                this.m_imgObj[27] = this.createImage("/bryuka_sc.png");
            }
            if (this.zoneNumber == 0) {
                this.m_imgObj[4] = this.createImage("/thashi.png");
                this.m_imgObj[18] = this.createImage("/brkabe_g.png");
            }
            if (this.zoneNumber == 2) {
                this.m_imgObj[MainCanvas.BURANKO] = this.createImage("/buranko_m.png");
            }
            if (this.zoneNumber == 3) {
                this.m_imgObj[75] = this.createImage("/mfire.png");
                this.m_imgObj[MainCanvas.BURANKO] = this.createImage("/buranko_s.png");
            }
            if (this.zoneNumber == 1 && this.stageNumber != 3) {
                this.m_imgObj[12] = this.createImage("/dai_la.png");
            }
            if (this.zoneNumber != 2) {
                this.m_imgObj[15] = this.createImage("/switch2.png");
            }
            if (this.zoneNumber == 1 && this.stageNumber == 3) {
                this.m_imgObj[32] = this.createImage("/z_dai4_l.png");
                this.m_imgObj[12] = this.createImage("/z_dai_la.png");
            }
            if (this.zoneNumber == 4) {
                this.m_imgObj[107] = this.createImage("/dai2_3.png");
            }
            this.m_imgObj[44] = this.createImage("/gole.png");
            this.m_imgObj[60] = this.createImage("/tekyu.png");
            this.m_imgObj[45] = this.createImage("/bten.png");
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private boolean ObjectMoveChk(int n, int n2, int n3, int n4) {
        return (n3 == -1 || 0 <= n - mapOxy[0] + n3 && 240 >= n - mapOxy[0] - n3) && (n4 == -1 || 0 <= n2 - mapOxy[1] + n4 && 240 >= n2 - mapOxy[1] - n4);
    }

    private void ring_sflag_ring_18_00_move_ikeshita(int n) {
        int n2 = 8;
        int n3 = 8;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        int n4 = this.ObjectColChk2(objectData[2], objectData[3], objectData[6], objectData[7], n2, n3);
        if (n4 >= 0) {
            if (objectData[5] == 0 && objectData[0] != -1) {
                MainCanvas.objectData[5] = 1;
                MainCanvas.objectData[10] = this.cpuTimer;
                ++ringcount;
            }
        } else if (objectData[12] != 0 && (n4 = this.ObjectColChk2(objectData[2], objectData[12], objectData[6], objectData[12], n2, n3)) >= 0 && objectData[5] == 0 && objectData[0] != -1) {
            MainCanvas.objectData[5] = 1;
            MainCanvas.objectData[10] = this.cpuTimer;
            ++ringcount;
        }
        if (objectData[5] == 1 && this.cpuTimer - objectData[10] >= 20) {
            MainCanvas.objectData[0] = -1;
            MainCanvas.objectData[5] = 0;
        }
    }

    private void ring_sflag_ring_00_18_move_ikeshita(int n) {
        this.ring_sflag_ring_18_00_move_ikeshita(n);
    }

    private void buranko_nflag_move_ikeshita(int n) {
        int n2 = this.dSin(this.animeTimer * 3) * 87;
        int n3 = this.dSin(objectData[6] * 3) * 87;
        MainCanvas.objectData[6] = this.animeTimer;
        int n4 = objectData[4] + 1;
        if (objectData[4] == 5) {
            n2 = -n2;
            n3 = -n3;
        } else if (objectData[19] == 1) {
            n2 = -n2;
            n3 = -n3;
        }
        int n5 = n4;
        int n6 = 24;
        int n7 = 8;
        if (this.zoneNumber == 3) {
            n6 = 44;
            n7 = 24;
            n5 <<= 4;
            n5 += 8;
        } else if (this.zoneNumber == 5) {
            n6 = 24;
            n7 = 24;
            n5 <<= 4;
            n5 -= 24;
        } else {
            n5 <<= 4;
            n5 -= 8;
        }
        int n8 = 12;
        if (!PlayerBall && !PlayerCrouch) {
            n8 = 20;
        }
        int n9 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] + this.dSin(180 + n2 / 100) * n5 / 100, objectData[3] + this.dCos(180 + n2 / 100) * n5 / 100, objectData[2] + this.dSin(180 + n3 / 100) * n5 / 100, objectData[3] + this.dCos(180 + n3 / 100) * n5 / 100, n6, n7);
        if (this.zoneNumber == 3) {
            if (n9 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] + this.dCos(180 + n2 / 100) * n5 / 100 - n7 << 8;
                PlayerParam[0] = PlayerParam[0] + (this.dSin(180 + n2 / 100) * n5 - this.dSin(180 + n3 / 100) * n5 << 8) / 100;
                this.setRaidOnSize(objectData[2] + this.dSin(180 + n2 / 100) * n5 / 100, n6);
                this.playerRaidOn(objectData[22]);
            } else {
                n9 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] + this.dSin(180 + n2 / 100) * n5 / 100, objectData[3] + this.dCos(180 + n2 / 100) * n5 / 100 - 4, objectData[2] + this.dSin(180 + n3 / 100) * n5 / 100, objectData[3] + this.dCos(180 + n3 / 100) * n5 / 100 - 4, 32, 20);
                if (n9 >= 0) {
                    if (n9 == 0) {
                        MainCanvas.PlayerParam[1] = objectData[3] + this.dCos(180 + n2 / 100) * n5 / 100 - n7 << 8;
                        PlayerParam[0] = PlayerParam[0] + (this.dSin(180 + n2 / 100) * n5 - this.dSin(180 + n3 / 100) * n5 << 8) / 100;
                        this.setRaidOnSize(objectData[2] + this.dSin(180 + n2 / 100) * n5 / 100, n6);
                        this.playerRaidOn(objectData[22]);
                    } else if (Math.abs(objectData[2] + this.dSin(180 + n2 / 100) * n5 / 100 - this.PlayerPosX()) < 44 && Math.abs(objectData[3] + this.dCos(180 + n2 / 100) * n5 / 100 - 4 - (this.PlayerPosY() - n8) + 1) < n8 + 24) {
                        this.playdamageset();
                    }
                }
            }
        } else if (this.zoneNumber != 5) {
            if (n9 != 0) {
                n9 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] + this.dSin(180 + n2 / 100) * n5 / 100, objectData[3] + this.dCos(180 + n2 / 100) * n5 / 100 + 5, objectData[2] + this.dSin(180 + n3 / 100) * n5 / 100, objectData[3] + this.dCos(180 + n3 / 100) * n5 / 100 + 5, n6, n7);
            }
            if (n9 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] + this.dCos(180 + n2 / 100) * n5 / 100 - n7 << 8;
                PlayerParam[0] = PlayerParam[0] + (this.dSin(180 + n2 / 100) * n5 - this.dSin(180 + n3 / 100) * n5 << 8) / 100;
                this.setRaidOnSize(objectData[2] + this.dSin(180 + n2 / 100) * n5 / 100, n6);
                this.playerRaidOn(objectData[22]);
            }
        } else if (n9 >= 0) {
            this.playdamageset();
        } else if (Math.abs(objectData[2] + this.dSin(180 + n2 / 100) * n5 / 100 - this.PlayerPosX()) < 12 + n6 && Math.abs(objectData[3] + this.dCos(180 + n2 / 100) * n5 / 100 - (this.PlayerPosY() - n8)) < n8 + n7) {
            this.playdamageset();
        }
        if (raidOn && raidObjectNum == objectData[20] && n9 != 0) {
            raidOn = false;
        }
    }

    private void hashi_nflag_move_ikeshita(int n) {
        int n2 = 0;
        int n3 = 240;
        int n4 = 8;
        int n5 = 8;
        int n6 = 0;
        boolean bl = false;
        int n7 = 6;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        n6 = this.cpuTimer - objectData[14];
        MainCanvas.objectData[14] = this.cpuTimer;
        int n8 = 99;
        n3 = 999;
        for (int i = 0; i < 12; ++i) {
            n2 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 4, 12, objectData[2] - 96 + (i << 4), objectData[3] + objectData[10], objectData[6] - 96 + (i << 4), objectData[7] + objectData[10], n4, n5);
            if (n2 < 0 || n2 == 3) continue;
            bl = true;
            MainCanvas.PlayerParam[1] = objectData[3] - n5 << 8;
            if (Math.abs(this.PlayerPosX() - (objectData[2] - 8)) >= n3) continue;
            n8 = i;
            n3 = Math.abs(this.PlayerPosX() - objectData[2]);
        }
        if (n8 != 99) {
            MainCanvas.PlayerParam[1] = objectData[3] - n5 + objectData[10] << 8;
            this.setRaidOnSize(objectData[2], 96);
            this.playerRaidOn(objectData[22]);
            MainCanvas.objectData[5] = n8;
            n7 = n8 <= 6 ? n8 : 6 - n8 % 6;
            objectData[10] = objectData[10] + n6;
            if (objectData[10] >= n7 * 2) {
                MainCanvas.objectData[10] = n7 * 2;
            }
            if (n8 == 0 || n8 == 11) {
                MainCanvas.objectData[10] = 0;
            }
        } else {
            objectData[10] = objectData[10] - n6;
            if (objectData[10] <= 0) {
                MainCanvas.objectData[10] = 0;
            }
        }
        if (bl) {
            n2 = 0;
        }
        if (raidOn && raidObjectNum == objectData[20] && n2 != 0) {
            raidOn = false;
        }
    }

    private void thashi_nflag_move_ikeshita(int n) {
        int n2 = 8;
        int n3 = 12;
        int n4 = -1;
        int[] nArray = new int[]{-4, 4};
        for (int i = 0; i < 12; ++i) {
            if ((this.animeTimer / 10 + (12 - i)) % 7 != 2 || (n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] - 96 + (i << 4), objectData[3], objectData[2] - 96 + (i << 4), objectData[3], n2, n3)) < 0) continue;
            this.playdamageset();
        }
    }

    private void break_sflag_move_ikeshita(int n) {
        int n2;
        int n3 = 48;
        int n4 = 48;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = -1;
        int n9 = -99;
        int n10 = 0;
        int n11 = 999;
        int n12 = 0;
        int n13 = 0;
        if (objectData[4] != 0) {
            n13 = -1;
        }
        n7 = objectData[2];
        if (objectData[5] == 0) {
            n12 = n13 == 0 ? this.break_sflag_ike_yuka.length : -this.break_sflag_ike_yuka.length;
            n8 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 2, 12, objectData[2] - n12, objectData[3] - this.break_sflag_ike_yuka[0] + 8, objectData[2] - n12, objectData[3] - this.break_sflag_ike_yuka[0] + 8, 8, 8);
            if (n8 >= 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - this.break_sflag_ike_yuka[0] + 8 - 8 << 8;
            }
        }
        if (objectData[5] != 0) {
            for (n2 = 0; n2 < 36; ++n2) {
                n5 = this.cpuTimer / 2 - objectData[10] - ((n2 << 1) + n2);
                if (n5 < 0) {
                    n6 = n2 / 6 << 3;
                    break;
                }
                if (n2 != 29) continue;
                MainCanvas.objectData[5] = 2;
            }
            if (n6 >= 48) {
                MainCanvas.objectData[5] = 2;
            }
            n7 = objectData[4] != 0 ? objectData[2] - n6 : objectData[2] + n6;
        }
        if (objectData[5] != 2) {
            n12 = 0;
            for (n2 = 0; n2 < this.break_sflag_ike_yuka.length; ++n2) {
                n12 = n13 == 0 ? n2 : this.break_sflag_ike_yuka.length - n2 - 1;
                if ((n13 != 0 || n6 > n2) && (n13 == 0 || this.break_sflag_ike_yuka.length - n6 < n2)) continue;
                n8 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 2, 12, objectData[2] - this.break_sflag_ike_yuka.length + (n2 << 1), objectData[3] - this.break_sflag_ike_yuka[n12], objectData[2] - this.break_sflag_ike_yuka.length + (n2 << 1), objectData[3] - this.break_sflag_ike_yuka[n12], 1, 1);
                if (n8 >= 0 && n8 == 0 && n11 > Math.abs(this.PlayerPosX() - (objectData[2] - this.break_sflag_ike_yuka.length + (n2 << 1)))) {
                    n11 = Math.abs(this.PlayerPosX() - (objectData[2] - this.break_sflag_ike_yuka.length + (n2 << 1)));
                    n9 = n12;
                    n10 = n2;
                }
                if (n9 == -99 || 8 <= Math.abs(this.PlayerPosX() - (objectData[2] - this.break_sflag_ike_yuka.length + (n2 << 1))) || this.PlayerPosY() - (objectData[3] - this.break_sflag_ike_yuka[n12]) <= 0 || this.PlayerPosY() - (objectData[3] - this.break_sflag_ike_yuka[n12]) > 64 || n11 <= Math.abs(this.PlayerPosX() - (objectData[2] - this.break_sflag_ike_yuka.length + (n2 << 1)))) continue;
                n11 = Math.abs(this.PlayerPosX() - (objectData[2] - this.break_sflag_ike_yuka.length + (n2 << 1)));
                n9 = n12;
                n10 = n2;
            }
            n8 = -1;
            if (n11 != 999) {
                MainCanvas.objectData[17] = n9;
                MainCanvas.PlayerParam[1] = objectData[3] - this.break_sflag_ike_yuka[n9] - 1 << 8;
                if (objectData[5] == 0) {
                    MainCanvas.objectData[10] = this.cpuTimer / 2;
                }
                MainCanvas.objectData[5] = 1;
                n3 = n13 == 0 ? n6 : this.break_sflag_ike_yuka.length - n6;
                this.setRaidOnSize(n7, n3);
                this.playerRaidOn(objectData[22]);
                n8 = 0;
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n8 != 0) {
            raidOn = false;
        }
    }

    private void yuka_nflag_move_ikeshita(int n) {
        int n2;
        int n3 = 0;
        int n4 = -1;
        int n5 = -1;
        this.view_yuka(objectData[2], objectData[3], objectData[4]);
        n3 = objectData[4] == 21 ? 2 : (objectData[4] == 1 ? 0 : 1);
        boolean bl = false;
        int n6 = 0;
        boolean bl2 = false;
        int n7 = 0;
        MainCanvas.objectData[17] = objectData[2];
        MainCanvas.objectData[18] = objectData[3];
        if (n3 != 2 && objectData[4] != 32) {
            objectData[5] = objectData[5] + 1;
            n7 = 32;
            if (objectData[4] == 35) {
                n7 = 32;
            } else if (objectData[4] == 1) {
                n7 = 16;
            } else if (objectData[4] == 41) {
                n7 = 16;
            } else if (objectData[4] == 34) {
                n7 = 24;
            } else if (objectData[4] == 43) {
                n7 = 32;
            } else if (objectData[4] == 33) {
                n7 = 16;
            } else if (objectData[4] == 42) {
                n7 = 24;
            }
            if (objectData[4] == 3) {
                n6 = objectData[18] >> 8;
                MainCanvas.objectData[3] = objectData[9] + n6;
            } else if (objectData[4] == 7) {
                n6 = 0;
            } else if (objectData[4] == 1) {
                n6 = this.dSin(objectData[5]) * n7 / 100 - n7;
                MainCanvas.objectData[3] = objectData[9] + 8 + n6;
            } else {
                n6 = this.dSin(objectData[5]) * n7 / 100 - n7;
                MainCanvas.objectData[3] = objectData[9] + n6;
            }
        }
        if (n3 == 2) {
            MainCanvas.objectData[3] = objectData[9];
        }
        if (n3 == 2 && objectData[13] != 0) {
            MainCanvas.objectData[3] = objectData[9] + 15;
            if (objectData[16] == 0) {
                MainCanvas.objectData[16] = 1;
            }
        }
        MainCanvas.objectData[13] = 0;
        int n8 = 999;
        n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[17], objectData[18], this.yuka_nflag_yuka_w[n3], this.yuka_nflag_ike_yuka[n3][0]);
        if (n4 >= 0) {
            if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - this.yuka_nflag_yuka_w[n3] - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                n5 = -99;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + this.yuka_nflag_yuka_w[n3] + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                n5 = -99;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            }
        }
        for (n2 = 0; n2 < this.yuka_nflag_ike_yuka[n3].length; ++n2) {
            n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 2, 13, objectData[2] - this.yuka_nflag_ike_yuka[n3].length + (n2 << 1), objectData[3] - this.yuka_nflag_ike_yuka[n3][n2], objectData[17] - this.yuka_nflag_ike_yuka[n3].length + (n2 << 1), objectData[18] - this.yuka_nflag_ike_yuka[n3][n2], 1, 1);
            if (n4 >= 0 && n4 == 0 && n8 > Math.abs(this.PlayerPosX() - (objectData[2] - this.yuka_nflag_ike_yuka[n3].length + (n2 << 1)))) {
                n8 = Math.abs(this.PlayerPosX() - (objectData[2] - this.yuka_nflag_ike_yuka[n3].length + (n2 << 1)));
                n5 = n2;
            }
            if (n5 == -99 || 8 < Math.abs(this.PlayerPosX() - (objectData[2] - this.yuka_nflag_ike_yuka[n3].length + (n2 << 1))) || this.PlayerPosY() - (objectData[3] - this.yuka_nflag_ike_yuka[n3][n2]) < -1 || this.PlayerPosY() - (objectData[3] - this.yuka_nflag_ike_yuka[n3][n2]) > 64 || n8 <= Math.abs(this.PlayerPosX() - (objectData[2] - this.yuka_nflag_ike_yuka[n3].length + (n2 << 1)))) continue;
            n8 = Math.abs(this.PlayerPosX() - (objectData[2] - this.yuka_nflag_ike_yuka[n3].length + (n2 << 1)));
            n5 = n2;
        }
        n4 = -1;
        if (n8 != 999) {
            MainCanvas.PlayerParam[1] = objectData[3] - this.yuka_nflag_ike_yuka[n3][n5] + 4 << 8;
            this.setRaidOnSize(objectData[2], this.yuka_nflag_ike_yuka[n3].length);
            this.playerRaidOn(objectData[22]);
            n4 = 0;
            if (n3 == 2) {
                MainCanvas.objectData[13] = 1;
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
        n4 = -1;
        if (objectData[16] != 0) {
            objectData[16] = objectData[16] + 1;
            if (objectData[16] == 60) {
                MainCanvas.objectData[15] = this.animeTimer - 1;
            }
            if (objectData[16] >= 60) {
                int n9 = 0;
                int n10 = 0;
                for (n2 = 0; n2 < 8; ++n2) {
                    n9 = this.animeTimer - objectData[15];
                    n10 = n9 - 1;
                    if (n10 < 0) {
                        n10 = 0;
                    }
                    if (n2 << 3 < n9) {
                        n10 = n9 = n2 << 3;
                    }
                    if ((n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] + (n9 << 1) - 56, objectData[3] - this.yuka_nflag_ike_yuka[n3][n9], objectData[17] + (n10 << 1) - 56, objectData[18] - this.yuka_nflag_ike_yuka[n3][n10], 6, 6)) < 0) continue;
                    this.playdamageset();
                    break;
                }
            }
        }
    }

    private void turi_nflag_move_ikeshita(int n) {
        int n2 = 56;
        int n3 = 12;
        int n4 = -1;
        this.view_turi(objectData[8], objectData[9], 0);
        MainCanvas.objectData[7] = objectData[3];
        if (objectData[4] == 128) {
            if (objectData[18] == 0) {
                MainCanvas.objectData[3] = objectData[9] + 112;
            }
            MainCanvas.objectData[18] = 1;
            if (!switchflag[128] && !switchflag[129]) {
                if (objectData[3] < objectData[9] + 112) {
                    objectData[3] = objectData[3] + 2;
                    if (objectData[3] > objectData[9] + 112) {
                        MainCanvas.objectData[3] = objectData[9] + 112;
                    }
                }
            } else if (objectData[3] > objectData[9]) {
                objectData[3] = objectData[3] - 1;
            }
            int[][] nArray = this.searchObject(10, 0);
            for (int i = 0; i < nArray.length; ++i) {
                if (objectData[2] - 56 - (nArray[i][2] - 16) > 32 || objectData[2] - 56 - (nArray[i][2] - 16) < -112 || !switchflag[128] || objectData[3] >= objectData[9] + 16) continue;
                MainCanvas.objectData[3] = objectData[9] + 16;
            }
        } else {
            int n5 = 160;
            if (objectData[4] == 17) {
                n2 = 48;
            } else if (objectData[4] == 2) {
                n2 = 56;
                n5 = 80;
            } else if (objectData[4] == 35) {
                n2 = 16;
                n5 = 120;
            } else if (objectData[4] == 18) {
                n2 = 48;
                n5 = 80;
            }
            if (objectData[5] == 0) {
                if (objectData[3] < objectData[9] + n5) {
                    objectData[3] = objectData[3] + 4;
                    if (objectData[3] >= objectData[9] + n5) {
                        MainCanvas.objectData[3] = objectData[9] + n5;
                        MainCanvas.objectData[5] = 1;
                    }
                }
            } else if (objectData[5] < 60) {
                objectData[5] = objectData[5] + 1;
            } else if (objectData[3] > objectData[9]) {
                objectData[3] = objectData[3] - 1;
                if (objectData[3] == objectData[9]) {
                    MainCanvas.objectData[5] = 0;
                }
            }
        }
        if ((n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[2], objectData[7], n2, n3)) >= 0) {
            if (n4 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
                if (objectData[3] - 24 < objectData[9]) {
                    this.setHeadHit();
                }
            } else if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n4 == 3) {
                this.setHeadHit();
                MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
        if (objectData[4] != 35) {
            n3 = 14;
            n2 = 40;
            n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3] + 32, objectData[2], objectData[7] + 32, n2, n3);
            if (n4 >= 0) {
                this.playdamageset();
            }
        }
    }

    private void toge_nflag_move_ikeshita(int n) {
        if (this.zoneNumber == 1 && this.stageNumber == 0 && objectData[4] == 64 && objectData[19] != 0) {
            return;
        }
        int n2 = 20;
        int n3 = 14;
        boolean bl = false;
        MainCanvas.objectData[7] = objectData[3];
        MainCanvas.objectData[15] = objectData[2];
        if (objectData[4] == 64) {
            n2 = 64;
        } else if (objectData[4] == 16) {
            n2 = 16;
            n3 = 19;
        }
        if (objectData[4] == 48) {
            n2 = 30;
        } else if (objectData[4] == 18) {
            n2 = 14;
            n3 = 20;
            objectData[6] = objectData[6] + 1;
            MainCanvas.objectData[5] = objectData[6];
            if (objectData[6] < 60) {
                MainCanvas.objectData[5] = 0;
            } else if (objectData[6] < 68) {
                MainCanvas.objectData[5] = objectData[6] - 60;
            } else if (objectData[6] < 128) {
                MainCanvas.objectData[5] = 8;
            } else if (objectData[6] < 136) {
                MainCanvas.objectData[5] = 136 - objectData[6];
            } else {
                MainCanvas.objectData[5] = 0;
                MainCanvas.objectData[6] = 0;
            }
            MainCanvas.objectData[2] = objectData[8] - (objectData[5] << 2) + 32;
        } else if (objectData[4] == 32) {
            n2 = 8;
            n3 = 18;
        } else if (objectData[4] == 82) {
            n2 = 20;
            n3 = 6;
            objectData[6] = objectData[6] + 1;
            MainCanvas.objectData[5] = objectData[6];
            if (objectData[6] < 60) {
                MainCanvas.objectData[5] = 0;
            } else if (objectData[6] < 68) {
                MainCanvas.objectData[5] = objectData[6] - 60;
            } else if (objectData[6] < 128) {
                MainCanvas.objectData[5] = 8;
            } else if (objectData[6] < 136) {
                MainCanvas.objectData[5] = 136 - objectData[6];
            } else {
                MainCanvas.objectData[5] = 0;
                MainCanvas.objectData[6] = 0;
            }
            MainCanvas.objectData[2] = objectData[8] - (objectData[5] << 2) + 32;
        } else if (objectData[4] == 1) {
            n2 = 20;
            objectData[6] = objectData[6] + 1;
            MainCanvas.objectData[5] = objectData[6];
            if (objectData[6] < 60) {
                MainCanvas.objectData[5] = 0;
            } else if (objectData[6] < 68) {
                MainCanvas.objectData[5] = objectData[6] - 60;
            } else if (objectData[6] < 128) {
                MainCanvas.objectData[5] = 8;
            } else if (objectData[6] < 136) {
                MainCanvas.objectData[5] = 136 - objectData[6];
            } else {
                MainCanvas.objectData[5] = 0;
                MainCanvas.objectData[6] = 0;
            }
            MainCanvas.objectData[3] = objectData[9] - (objectData[5] << 2) + 32;
        }
        boolean bl2 = false;
        int n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[15], objectData[7], n2, n3);
        if (n4 >= 0) {
            if (objectData[4] == 82) {
                if (n4 == 1 || n4 == 2) {
                    this.playdamageset();
                    bl2 = true;
                }
            } else if (objectData[4] == 18 || objectData[4] == 16) {
                if (n4 == 1 || n4 == 2) {
                    this.playdamageset();
                    bl2 = true;
                }
            } else {
                if (n4 == 0 && objectData[19] == 0) {
                    this.playdamageset2();
                    bl2 = true;
                } else if (n4 == 3 && objectData[19] != 0) {
                    this.playdamageset();
                    bl2 = true;
                }
                if (objectData[19] != 0 && this.zoneNumber == 1) {
                    if (n4 == 1) {
                        MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                        MainCanvas.PlayerParam[10] = 0;
                        if (PlayerParam[3] > 0) {
                            MainCanvas.PlayerParam[3] = 0;
                        }
                    } else if (n4 == 2) {
                        MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                        MainCanvas.PlayerParam[10] = 0;
                        if (PlayerParam[3] < 0) {
                            MainCanvas.PlayerParam[3] = 0;
                        }
                    }
                }
            }
            if (n4 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
                if (this.blockColChk2(this.PlayerPosX(), this.PlayerPosY() - 32)) {
                    MainCanvas.PlayerParam[0] = PlayerParam[12] == 0 ? objectData[2] - n2 - 12 << 8 : objectData[2] + n2 + 12 + 1 << 8;
                }
            } else if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (!bl2 && KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (!bl2 && KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n4 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
                if (PlayerParam[5] < 0) {
                    MainCanvas.PlayerParam[5] = 0;
                }
                if (this.zoneNumber == 0) {
                    PlayerParam[1] = PlayerParam[1] + 4096;
                }
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    private void box_sflag_move_ikeshita(int n) {
        int n2;
        int n3 = 16;
        int n4 = 16;
        boolean bl = false;
        int n5 = 0;
        int n6 = -1;
        int n7 = -1;
        boolean bl2 = false;
        MainCanvas.objectData[15] = objectData[2];
        MainCanvas.objectData[16] = objectData[3];
        if (objectData[4] == 129) {
            n3 = 64;
            n4 = 16;
        }
        n5 = objectData[2];
        if (objectData[5] != 0 && objectData[10] == 0) {
            objectData[3] = objectData[3] + 2;
            if (this.blockColChk_Enemy(objectData[2] - n3 + 1, objectData[3] + n4) || this.blockColChk_Enemy(objectData[2] + n3 - 1, objectData[3] + n4)) {
                MainCanvas.objectData[5] = 0;
                if (objectData[4] == 0) {
                    MainCanvas.objectData[6] = 1;
                }
            }
        }
        for (n2 = 0; n2 < 4; ++n2) {
            if (objectData[8] != this.box_sflag_ike_def_X[n2] || objectData[9] != this.box_sflag_ike_def_Y[n2]) continue;
            n7 = n2;
            break;
        }
        if (objectData[5] == 0 && n7 != -1 && objectData[10] == 0 && Math.abs(objectData[2] - this.box_sflag_ike_col_X[n7]) <= 16 && Math.abs(objectData[3] - this.box_sflag_ike_col_Y[n7]) <= 16) {
            MainCanvas.objectData[10] = 1;
        }
        if (objectData[17] == 0 && objectData[10] > 0 && objectData[3] < this.box_sflag_ike_col_Y[n7]) {
            objectData[3] = objectData[3] + 2;
            if (objectData[3] > this.box_sflag_ike_col_Y[n7]) {
                MainCanvas.objectData[3] = this.box_sflag_ike_col_Y[n7];
            }
        }
        if (objectData[17] == 0) {
            if (objectData[10] >= 1 && objectData[10] < 15) {
                objectData[10] = objectData[10] + 1;
            } else if (objectData[10] == 15) {
                objectData[2] = objectData[2] + this.box_sflag_ike_box_V[n7];
            } else if (objectData[10] >= 16) {
                objectData[10] = objectData[10] + 1;
                if (objectData[10] >= 46 && objectData[10] - 48 <= 96 && objectData[10] % 2 == 0) {
                    objectData[3] = objectData[3] + 1;
                }
            }
        } else if (this.box_sflag_ike_box_V[n7] < 0) {
            if (objectData[18] < objectData[2]) {
                objectData[2] = objectData[2] + this.box_sflag_ike_box_V[n7];
            }
        } else if (objectData[18] > objectData[2]) {
            objectData[2] = objectData[2] + this.box_sflag_ike_box_V[n7];
        }
        MainCanvas.objectData[17] = 0;
        if (objectData[4] != 129 && this.zoneNumber == 2) {
            int[][] nArray;
            if (this.zoneNumber == 2 && this.stageNumber == 0 && objectData[4] == 0) {
                nArray = this.searchObject(8, 128);
                for (n2 = 0; n2 < nArray.length; ++n2) {
                    if (nArray[n2][2] - 56 - (objectData[2] - 16) > 32 || nArray[n2][2] - 56 - (objectData[2] - 16) < -112) continue;
                    MainCanvas.objectData[3] = nArray[n2][3] - 28;
                }
                int[][] nArray2 = this.searchObject(15, 128);
                MainCanvas.switchflag[129] = false;
                for (n2 = 0; n2 < nArray2.length; ++n2) {
                    if (nArray2[n2][2] - 8 - (objectData[2] - 16) > 32 || nArray2[n2][2] - 8 - (objectData[2] - 16) < -32 || nArray2[n2][3] - 8 - (objectData[3] - 16) > 32 || nArray2[n2][3] - 8 - (objectData[3] - 16) < -32) continue;
                    MainCanvas.switchflag[129] = true;
                    MainCanvas.switchflag2[129] = true;
                }
            }
            if (objectData[4] != 0) {
                nArray = this.searchObject(9, 16);
                for (n2 = 0; n2 < nArray.length; ++n2) {
                    if (nArray[n2][2] - 20 - (objectData[2] - 16) > 32 || nArray[n2][2] - 20 - (objectData[2] - 16) < -40 || nArray[n2][3] - 20 - (objectData[3] - 16) > 32 || nArray[n2][3] - 20 - (objectData[3] - 16) < -40 || objectData[10] != 15) continue;
                    MainCanvas.objectData[10] = 16;
                }
            }
            if (objectData[4] == 2) {
                nArray = this.searchObject(77, 16);
                for (n2 = 0; n2 < nArray.length; ++n2) {
                    if (nArray[n2][2] - 20 - 64 - (objectData[2] - 16) > 32 || nArray[n2][2] - 20 - 64 - (objectData[2] - 16) < -112 || nArray[n2][3] - 48 + 16 - 16 - (objectData[3] - 16) > 32 || nArray[n2][3] - 48 + 16 - 16 - (objectData[3] - 16) < -32 || nArray[n2][5] <= 1 || nArray[n2][5] / 4 >= 26) continue;
                    MainCanvas.objectData[3] = nArray[n2][3] - 48 + 16 - 16;
                    MainCanvas.objectData[18] = nArray[n2][2] - 10 + 16;
                    MainCanvas.objectData[17] = 1;
                    break;
                }
            }
        }
        n5 -= objectData[2];
        n6 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[15], objectData[16], n3, n4);
        if (n6 >= 0) {
            if (n6 == 0) {
                int n8 = -1;
                n8 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3] - n4, objectData[15], objectData[16] - n4, n3, 2);
                if (n8 == 1) {
                    if ((KeyPress[4] && objectData[5] == 0 || objectData[4] == 129 || objectData[4] == 0) && objectData[10] == 0) {
                        objectData[2] = objectData[2] + 1;
                        if (this.blockColChk_Enemy(objectData[2] + n3, objectData[3] - n4)) {
                            objectData[2] = objectData[2] - 1;
                        }
                    }
                } else if (n8 == 2 && (KeyPress[3] && objectData[5] == 0 || objectData[4] == 129 || objectData[4] == 0) && objectData[10] == 0) {
                    objectData[2] = objectData[2] - 1;
                    if (this.blockColChk_Enemy(objectData[2] - n3, objectData[3] - n4)) {
                        objectData[2] = objectData[2] + 1;
                    }
                }
                MainCanvas.PlayerParam[1] = objectData[3] - n4 << 8;
                this.setRaidOnSize(objectData[2], n3);
                this.playerRaidOn(objectData[22]);
                bl2 = true;
                PlayerParam[0] = PlayerParam[0] - (n5 << 8);
            }
            if (n6 == 1) {
                if (KeyPress[4] && (objectData[5] == 0 || objectData[4] == 129 || objectData[4] == 0)) {
                    if (objectData[10] == 0) {
                        objectData[2] = objectData[2] + 1;
                        MainCanvas.objectData[7] = 1;
                        if (this.blockColChk_Enemy(objectData[2] + n3, objectData[3] + n4 - 1)) {
                            objectData[2] = objectData[2] - 1;
                        }
                        if (objectData[4] == 129 && objectData[2] > objectData[8] + 64) {
                            MainCanvas.objectData[2] = objectData[8] + 64;
                        }
                    }
                    this.playerPushSet();
                }
                MainCanvas.PlayerParam[0] = objectData[2] - n3 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
            }
            if (n6 == 2) {
                if (KeyPress[3] && (objectData[5] == 0 || objectData[4] == 129 || objectData[4] == 0)) {
                    if (objectData[10] == 0) {
                        objectData[2] = objectData[2] - 1;
                        MainCanvas.objectData[7] = -1;
                        if (this.blockColChk_Enemy(objectData[2] - n3, objectData[3] + n4 - 1)) {
                            objectData[2] = objectData[2] + 1;
                        }
                    }
                    this.playerPushSet();
                }
                MainCanvas.PlayerParam[0] = objectData[2] + n3 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
            }
            if (n6 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n4 + 12 + 12 + 1 << 8;
                this.setHeadHit();
            }
        }
        if (!this.blockColChk_Enemy(objectData[2] - n3 + 1, objectData[3] + n4) && !this.blockColChk_Enemy(objectData[2] + n3 - 1, objectData[3] + n4)) {
            objectData[5] = objectData[5] + 1;
        }
        if (raidOn && raidObjectNum == objectData[20] && n6 != 0) {
            raidOn = false;
        }
        if (bl2) {
            this.view_box_ride(objectData[2], objectData[3], objectData[4]);
        } else {
            this.view_box(objectData[2], objectData[3], objectData[4]);
        }
    }

    private void fblock_nflag_move_ikeshita(int n) {
        int n2 = 16;
        int n3 = 16;
        boolean bl = false;
        this.view_fblock(objectData[2], objectData[3], objectData[4]);
        if (objectData[4] == 2 || objectData[4] == 10) {
            if (objectData[5] == 2) {
                MainCanvas.objectData[3] = objectData[11] + this.dSin(this.cpuTimer) * 6 / 100 + 6;
            } else if (objectData[5] == 1) {
                objectData[10] = objectData[10] + 1;
                objectData[3] = objectData[3] + objectData[10];
                if (this.blockColChk_Enemy(objectData[2] - n2 + 1, objectData[3] + n3) || this.blockColChk_Enemy(objectData[2] + n2 - 1, objectData[3] + n3)) {
                    MainCanvas.objectData[5] = objectData[8] == 4016 && objectData[9] == 1296 || objectData[8] == 3920 && objectData[9] == 1328 ? 0 : 2;
                    objectData[3] = objectData[3] - (objectData[3] + n3) % 16;
                    MainCanvas.objectData[11] = objectData[3];
                }
            } else if (objectData[3] < this.PlayerPosY() && objectData[2] - 100 < this.PlayerPosX()) {
                MainCanvas.objectData[10] = 1;
                MainCanvas.objectData[5] = 1;
            }
        } else if (objectData[4] == 1) {
            MainCanvas.objectData[3] = objectData[9] + (this.dSin(objectData[5]) << 3) / 100 - 8;
            objectData[5] = objectData[5] + 6;
        }
        int n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[2], objectData[3], n2, n3);
        if (n4 >= 0) {
            if (n4 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
            } else if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n4 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
                this.setHeadHit();
            } else if (n4 == 4 && raidObjectNum != objectData[20]) {
                if (this.PlayerPosX() < objectData[2]) {
                    MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[4]) {
                        this.playerPushSet();
                    }
                } else {
                    MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[3]) {
                        this.playerPushSet();
                    }
                }
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    private void dainfla_move_ikeshita(int n) {
        int n2 = 48;
        int n3 = 16;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        boolean bl = false;
        int n7 = 0;
        boolean bl2 = false;
        if (objectData[4] == 57) {
            n2 = 63;
            n3 = 8;
        } else if (objectData[4] == 40) {
            n2 = 32;
            n3 = 8;
        }
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        if (objectData[4] == 7 || objectData[4] == 4) {
            n2 = 16;
            n3 = 8;
            if (this.zoneNumber == 1 && this.stageNumber == 0 && switchflag[2]) {
                MainCanvas.objectData[5] = 1;
            }
            if (this.zoneNumber == 1 && this.stageNumber == 3) {
                MainCanvas.objectData[5] = 1;
            }
            if (objectData[10] == 1) {
                n7 = objectData[2];
                objectData[2] = objectData[2] + 1;
                if (objectData[4] == 7) {
                    if (this.blockColChk_Enemy(objectData[2] + n2, objectData[3] + n3 - 1 - 16)) {
                        objectData[2] = objectData[2] - 1;
                        MainCanvas.objectData[10] = 2;
                    }
                } else if (Math.abs(objectData[2] - objectData[8]) >= 96) {
                    MainCanvas.objectData[2] = objectData[8] + 96;
                    MainCanvas.objectData[10] = 2;
                }
                n7 -= objectData[2];
            } else if (objectData[10] == 2) {
                objectData[3] = objectData[3] + 5;
                if (this.blockColChk_Enemy(objectData[2] - n2 + 1, objectData[3] + n3) || this.blockColChk_Enemy(objectData[2] + n2 - 1, objectData[3] + n3)) {
                    MainCanvas.objectData[5] = 0;
                    objectData[3] = objectData[3] - (objectData[3] + n3) % 16;
                    MainCanvas.objectData[10] = 3;
                }
            }
        }
        if (objectData[4] == 1) {
            n2 = 16;
            n3 = 16;
            n7 = objectData[2];
            if (this.cpuTimer % 384 <= 144) {
                MainCanvas.objectData[2] = objectData[8] - this.cpuTimer % 384 / 3;
            } else if (this.cpuTimer % 384 > 240) {
                MainCanvas.objectData[2] = objectData[8] - (48 - (this.cpuTimer % 384 / 3 - 80));
            }
            n7 -= objectData[2];
        } else if (objectData[4] == 2) {
            n2 = 16;
            n3 = 16;
            MainCanvas.objectData[3] = objectData[9] + 9;
            if (objectData[10] != 0) {
                n7 = objectData[2];
                objectData[2] = objectData[2] + 1;
                if (this.blockColChk_Enemy(objectData[2] + n2, objectData[3] + n3 - 1 - 16)) {
                    objectData[2] = objectData[2] - 1;
                }
                n7 -= objectData[2];
            }
        } else if (objectData[4] == 65) {
            n7 = objectData[2];
            n6 = 48;
            MainCanvas.objectData[2] = objectData[8] + this.dSin(this.cpuTimer) * n6 / 100 - 32 - 48;
            MainCanvas.objectData[3] = objectData[9] + 8;
            n4 = 32;
            n5 = 0;
            n2 = 47;
            n7 -= objectData[2];
        } else if (objectData[4] == 57) {
            if (objectData[10] != 0) {
                objectData[10] = objectData[10] + 1;
            }
            if (objectData[10] > 5) {
                n7 = objectData[2];
                if (objectData[19] == 0) {
                    if (this.cpuTimer - objectData[11] <= 32) {
                        MainCanvas.objectData[2] = objectData[8] + (this.cpuTimer - objectData[11] << 2);
                    } else if (this.cpuTimer - objectData[11] >= 500 && this.cpuTimer - objectData[11] < 532) {
                        MainCanvas.objectData[2] = objectData[8] + (128 - (this.cpuTimer - objectData[11] - 500 << 2));
                    }
                } else if (this.cpuTimer - objectData[11] <= 32) {
                    MainCanvas.objectData[2] = objectData[8] - (this.cpuTimer - objectData[11] << 2);
                } else if (this.cpuTimer - objectData[11] >= 500 && this.cpuTimer - objectData[11] < 532) {
                    MainCanvas.objectData[2] = objectData[8] - (128 - (this.cpuTimer - objectData[11] - 500 << 2));
                }
                if (this.cpuTimer - objectData[11] >= 532) {
                    MainCanvas.objectData[10] = 0;
                    MainCanvas.objectData[11] = 0;
                    MainCanvas.objectData[2] = objectData[8];
                }
                n7 -= objectData[2];
            } else {
                MainCanvas.objectData[2] = objectData[8];
            }
        } else if (objectData[4] == 40) {
            MainCanvas.objectData[3] = (this.cpuTimer >> 1) % 256 < 128 ? objectData[9] - (this.cpuTimer >> 1) % 256 : objectData[9] - (128 - ((this.cpuTimer >>> 1) % 256 - 128));
        }
        int n8 = -1;
        if ((objectData[4] != 7 && objectData[4] != 4 || objectData[5] != 0) && (n8 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] + n4, objectData[3] + n5, objectData[6] + n4, objectData[7] + n5, n2, n3)) >= 0 && n8 == 0) {
            MainCanvas.PlayerParam[1] = objectData[3] - n3 + n5 << 8;
            if (objectData[4] == 2 || objectData[4] == 1 || objectData[4] == 65) {
                if (objectData[10] == 0) {
                    MainCanvas.objectData[10] = 1;
                    MainCanvas.objectData[11] = this.cpuTimer;
                }
                PlayerParam[0] = PlayerParam[0] - (n7 << 8);
            }
            if (objectData[4] == 57) {
                if (objectData[2] + n4 - n2 <= this.PlayerPosX() && this.PlayerPosX() <= objectData[2] + n4 + n2 && objectData[10] == 0) {
                    MainCanvas.objectData[10] = 1;
                    MainCanvas.objectData[11] = this.cpuTimer;
                }
                PlayerParam[0] = PlayerParam[0] - (n7 << 8);
            }
            if (objectData[4] == 7 || objectData[4] == 4) {
                if (objectData[5] == 1 && objectData[10] == 0) {
                    MainCanvas.objectData[10] = 1;
                }
                PlayerParam[0] = PlayerParam[0] - (n7 << 8);
            }
            this.setRaidOnSize(objectData[2] + n4, n2);
            this.playerRaidOn(objectData[22]);
            bl2 = true;
        }
        if (raidOn && raidObjectNum == objectData[20] && n8 != 0) {
            raidOn = false;
        }
        if (bl2) {
            this.view_dai_ride(objectData[2], objectData[3], objectData[4]);
        } else {
            this.view_dai(objectData[2], objectData[3], objectData[4]);
        }
    }

    private void yogan2_sflag_move_ikeshita(int n) {
        int n2 = objectData[2];
        int n3 = objectData[5];
        if (objectData[5] == 0) {
            if (objectData[2] + 160 < this.PlayerPosX() && Math.abs(objectData[3] - this.PlayerPosY() + 12) < 43) {
                objectData[5] = objectData[5] + 1;
            }
        } else {
            objectData[5] = objectData[5] + 2;
            if (objectData[5] > 1152) {
                MainCanvas.objectData[5] = 1152;
            }
            MainCanvas.objectData[2] = objectData[5] + objectData[8];
        }
        if (objectData[2] + 96 > this.PlayerPosX() && Math.abs(objectData[3] - this.PlayerPosY() + 12) < 43) {
            this.playdamageset();
            if (objectData[5] > 0 && this.PlayerPosX() + 300 < objectData[2]) {
                MainCanvas.objectData[2] = this.PlayerPosX() + 300;
            }
        }
        int n4 = 120;
        int n5 = 32;
        int n6 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] - 96, objectData[3], n2 - 96, objectData[3], n4, n5);
        if (n6 >= 0 && n6 != 0 && n6 != 1) {
            if (n6 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n4 - 96 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
            } else if (n6 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n5 + 12 + 12 + 1 << 8;
                MainCanvas.PlayerParam[5] = 0;
                this.setHeadHit();
            }
        }
    }

    private void myogan_nflag_move_ikeshita(int n) {
        int n2 = 32;
        int n3 = 32;
        MainCanvas.objectData[5] = this.cpuTimer / 2 % 180;
        if (objectData[5] == 0) {
            MainCanvas.objectData[10] = 0;
        }
        MainCanvas.objectData[2] = objectData[8];
        MainCanvas.objectData[3] = objectData[9] - 356 + (objectData[5] << 3);
        if (Math.abs(this.PlayerPosX() - objectData[2]) < 44) {
            if (objectData[3] < objectData[9]) {
                if (objectData[3] - 240 < this.PlayerPosY() && objectData[3] > this.PlayerPosY() - 12) {
                    this.playdamageset();
                }
            } else if (objectData[3] - 240 < this.PlayerPosY() && objectData[9] > this.PlayerPosY() - 12) {
                this.playdamageset();
            }
        }
        if (objectData[10] == 0) {
            if (objectData[3] > objectData[9]) {
                MainCanvas.objectData[10] = 1;
            }
        } else {
            objectData[10] = objectData[10] + 1;
        }
    }

    private void switch2_nflag_move_ikeshita(int n) {
        int n2 = 14;
        int n3 = 7;
        if (switchflag[objectData[4]]) {
            n3 = 0;
        }
        MainCanvas.switchflag[MainCanvas.objectData[4]] = false;
        int n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[2], objectData[3], n2, n3);
        if (n4 >= 0) {
            if (n4 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                MainCanvas.switchflag[MainCanvas.objectData[4]] = true;
                MainCanvas.switchflag2[MainCanvas.objectData[4]] = true;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
                if (this.zoneNumber == 1 && this.stageNumber == 2) {
                    MainCanvas.tempWorldMapData[2][6] = objectData[4] == 15 ? 7 : 75;
                }
            } else if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    private void shima_nflag_move_ikeshita(int n) {
        int n2 = 32;
        int n3 = 8;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = objectData[2];
        MainCanvas.objectData[11] = objectData[2];
        MainCanvas.objectData[7] = objectData[3] + objectData[14];
        if (this.zoneNumber == 4) {
            n3 = 16;
        }
        if (objectData[4] == 5) {
            MainCanvas.objectData[5] = this.cpuTimer * 15 / 10 % 360;
            n6 = objectData[5];
            n7 = 64;
        } else if (objectData[4] == 1) {
            MainCanvas.objectData[5] = this.cpuTimer * 15 / 10 % 360;
            n6 = objectData[5];
            n7 = -64;
        }
        if (objectData[4] == 12) {
            MainCanvas.objectData[5] = this.cpuTimer * 15 / 10 % 360;
            n6 = objectData[5];
            n8 = 48;
        } else if (objectData[4] == 11) {
            MainCanvas.objectData[5] = this.cpuTimer * 15 / 10 % 360;
            n6 = objectData[5];
            n8 = -48;
        } else if (objectData[4] == 6) {
            MainCanvas.objectData[5] = this.cpuTimer * 15 / 10 % 360;
            n6 = objectData[5];
            n8 = 64;
        } else if (objectData[4] == 2) {
            MainCanvas.objectData[5] = this.cpuTimer * 15 / 10 % 360;
            n6 = objectData[5];
            n8 = -64;
        } else if (objectData[4] == 16) {
            MainCanvas.objectData[5] = this.cpuTimer * 15 / 10 % 360;
            n6 = objectData[5];
            n8 = -32;
        }
        if (objectData[4] == 7) {
            if (switchflag[128] && objectData[5] <= 0) {
                objectData[5] = objectData[5] + 1;
            }
            if (objectData[5] > 0) {
                objectData[5] = objectData[5] + 1;
                if (objectData[5] > 90) {
                    objectData[3] = objectData[3] - 2;
                    if (objectData[3] < 368) {
                        MainCanvas.objectData[3] = 368;
                    }
                }
            }
            n6 = objectData[5];
        } else if (objectData[4] == 3 && objectData[5] != 0) {
            objectData[5] = objectData[5] + 1;
            if (objectData[5] > 40) {
                objectData[6] = objectData[6] + 80;
                objectData[18] = objectData[18] + objectData[6];
            }
            n6 = objectData[5];
        }
        n4 = this.dSin(n6) * n8 / 100;
        if (objectData[4] == 3) {
            n5 = objectData[18] >> 8;
            MainCanvas.objectData[3] = objectData[9] + n5;
        } else if (objectData[4] == 7) {
            n5 = 0;
        } else {
            n5 = this.dSin(n6) * n8 / 100;
            MainCanvas.objectData[3] = objectData[9] + n5;
            n4 = this.dSin(n6) * n7 / 100;
            MainCanvas.objectData[2] = objectData[8] + n4;
        }
        MainCanvas.objectData[14] = 0;
        if (objectData[13] != 0) {
            MainCanvas.objectData[14] = 4;
        }
        MainCanvas.objectData[13] = 0;
        int n10 = -1;
        boolean bl = false;
        n9 -= objectData[2];
        n10 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3] + objectData[14] + 32, objectData[11], objectData[7] + 32, n2, 8);
        if (n10 >= 0 && n10 == 0) {
            MainCanvas.PlayerParam[0] = this.PlayerPosX() - n9 << 8;
            MainCanvas.PlayerParam[1] = objectData[3] - n3 + objectData[14] << 8;
            if (objectData[4] == 3 && n6 == 0) {
                MainCanvas.objectData[5] = 1;
            }
            this.setRaidOnSize(objectData[2], n2);
            this.playerRaidOn(objectData[22]);
            bl = true;
            MainCanvas.objectData[13] = 1;
        }
        if (raidOn && raidObjectNum == objectData[20] && n10 != 0) {
            raidOn = false;
        }
        if ((n10 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3] + objectData[14] - 4, objectData[11], objectData[7] - 4, n2, 4)) >= 0 && n10 != 3) {
            MainCanvas.PlayerParam[0] = this.PlayerPosX() - n9 << 8;
            MainCanvas.PlayerParam[1] = objectData[3] - n3 + objectData[14] << 8;
            if (objectData[4] == 3 && n6 == 0) {
                MainCanvas.objectData[5] = 1;
            }
            this.setRaidOnSize(objectData[2], n2);
            this.playerRaidOn(objectData[22]);
            MainCanvas.objectData[13] = 1;
            bl = true;
        }
        if (raidOn && raidObjectNum == objectData[20] && n10 != 0) {
            raidOn = false;
        }
    }

    private void dai2_nflag_move_ikeshita(int n) {
        this.dai2_sflag_move_ikeshita(n);
    }

    private void brkabe_sflag_move_ikeshita(int n) {
        int n2 = 8;
        int n3 = 32;
        int n4 = -1;
        boolean bl = false;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        for (int i = 0; i < 2; ++i) {
            if (objectData[10 + i] == 1) continue;
            n4 = -1;
            n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] - 8 + (i << 4), objectData[3], objectData[6] - 8 + (i << 4), objectData[7], n2, n3);
            if (n4 < 0) continue;
            if (n4 == 1) {
                if (!PlayerJump && PlayerBall) {
                    if (PlayerParam[10] >= 300) {
                        PlayerParam[10] = PlayerParam[10] - 10;
                        MainCanvas.objectData[10 + i] = 1;
                        if (this.zoneNumber == 0) {
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16, 330, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 16, 300, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 32, 320, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 48, 310, 400, objectData[4]);
                        } else {
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16, 330, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 16, 300, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 32, 320, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 48, 310, 400, 0);
                        }
                    } else if (PlayerParam[10] <= -300) {
                        PlayerParam[10] = PlayerParam[10] + 10;
                        MainCanvas.objectData[10 + i] = 1;
                        if (this.zoneNumber == 0) {
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16, 390, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 16, 420, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 32, 400, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 48, 410, 400, objectData[4]);
                        } else {
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16, 390, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 16, 420, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 32, 400, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 48, 410, 400, 0);
                        }
                    } else {
                        MainCanvas.PlayerParam[10] = 0;
                    }
                } else {
                    MainCanvas.PlayerParam[10] = 0;
                }
                if (PlayerParam[10] != 0) continue;
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 - 8 + (i << 4) << 8;
                if (!KeyPress[4]) continue;
                this.playerPushSet();
                continue;
            }
            if (n4 == 2) {
                if (!PlayerJump && PlayerBall) {
                    if (PlayerParam[10] >= 300) {
                        PlayerParam[10] = PlayerParam[10] - 10;
                        MainCanvas.objectData[10 + i] = 1;
                        if (this.zoneNumber == 0) {
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16, 330, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 16, 300, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 32, 320, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 48, 310, 400, objectData[4]);
                        } else {
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16, 330, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 16, 300, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 32, 320, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 48, 310, 400, 0);
                        }
                    } else if (PlayerParam[10] <= -300) {
                        PlayerParam[10] = PlayerParam[10] + 10;
                        MainCanvas.objectData[10 + i] = 1;
                        if (this.zoneNumber == 0) {
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16, 390, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 16, 420, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 32, 400, 400, objectData[4]);
                            this.ShotObj2(26, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 48, 410, 400, objectData[4]);
                        } else {
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16, 390, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 16, 420, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 32, 400, 400, 0);
                            this.ShotObj2(24, objectData[2] - 8 + (i << 4), objectData[3] - 16 - 16 + 48, 410, 400, 0);
                        }
                    } else {
                        MainCanvas.PlayerParam[10] = 0;
                    }
                } else {
                    MainCanvas.PlayerParam[10] = 0;
                }
                if (PlayerParam[10] != 0) continue;
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 - 8 + (i << 4) << 8;
                if (!KeyPress[3]) continue;
                this.playerPushSet();
                continue;
            }
            if (n4 != 3) continue;
            MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
            this.setHeadHit();
        }
        if (objectData[10] == 1 && objectData[11] == 1) {
            MainCanvas.objectData[0] = 0;
        }
        if (bl) {
            n4 = 0;
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    private void pedal_nflag_move_ikeshita(int n) {
        int n2 = 24;
        int n3 = 8;
        int n4 = this.dSin(this.animeTimer % 360 * 3 + objectData[4] * 90) * 80 / 100;
        int n5 = this.dCos(this.animeTimer % 360 * 3 + objectData[4] * 90) * 80 / 100;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        if (objectData[4] <= 3) {
            MainCanvas.objectData[2] = objectData[8] + n4;
            MainCanvas.objectData[3] = objectData[9] - n5;
        } else {
            MainCanvas.objectData[2] = objectData[8] + n4;
            MainCanvas.objectData[3] = objectData[9] + n5;
        }
        int n6 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n2, n3);
        if (n6 >= 0 && n6 == 0) {
            MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
            PlayerParam[0] = PlayerParam[0] + (objectData[2] - objectData[6] << 8);
            this.setRaidOnSize(objectData[2], n2);
            this.playerRaidOn(objectData[22]);
        }
        if (raidOn && raidObjectNum == objectData[20] && n6 != 0) {
            raidOn = false;
        }
    }

    private void break2_nflag_move_ikeshita(int n) {
        int n2 = 8;
        int n3 = 8;
        int n4 = 0;
        int n5 = 0;
        boolean bl = false;
        MainCanvas.objectData[10] = this.cpuTimer;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        if (this.zoneNumber == 3) {
            n3 = 7;
        }
        for (int i = 0; i < 8; ++i) {
            if (objectData[15] != 0 && (n4 = this.cpuTimer - objectData[16] - this.break2_nflag_ike_brockTimeTable[i]) < 0) {
                n4 = 0;
            }
            n5 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] + ((this.break2_nflag_ike_brockTable[i] % 4 << 4) - 16 - 8), objectData[3] + ((this.break2_nflag_ike_brockTable[i] >> 2 << 4) + n4 * (n4 / 5)), objectData[6] + ((this.break2_nflag_ike_brockTable[i] % 4 << 4) - 16 - 8), objectData[7] + ((this.break2_nflag_ike_brockTable[i] >> 2 << 4) + n4 * (n4 / 5)), n2, n3);
            if (n4 != 0) {
                n5 = -1;
            }
            if (n5 < 0) continue;
            if (this.zoneNumber == 3 && (n5 == 1 || n5 == 2) && this.PlayerPosY() < objectData[3] + (n3 >> 1)) {
                n5 = 0;
            }
            if (n5 == 0) {
                bl = true;
                MainCanvas.PlayerParam[1] = objectData[3] + ((this.break2_nflag_ike_brockTable[i] >> 2 << 4) + n4 * 5) - n3 << 8;
                this.setRaidOnSize(objectData[2] + ((this.break2_nflag_ike_brockTable[i] % 4 << 4) - 16 - 8), n2);
                this.playerRaidOn(objectData[22]);
                if (objectData[15] == 0) {
                    MainCanvas.objectData[16] = this.cpuTimer;
                }
                MainCanvas.objectData[15] = 1;
                continue;
            }
            if (n5 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] + ((this.break2_nflag_ike_brockTable[i] % 4 << 4) - 16 - 8) - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (!KeyPress[4]) continue;
                this.playerPushSet();
                continue;
            }
            if (n5 != 2) continue;
            MainCanvas.PlayerParam[0] = objectData[2] + ((this.break2_nflag_ike_brockTable[i] % 4 << 4) - 16 - 8) + n2 + 12 + 1 << 8;
            MainCanvas.PlayerParam[10] = 0;
            if (!KeyPress[3]) continue;
            this.playerPushSet();
        }
        if (bl) {
            n5 = 0;
        }
        if (raidOn && raidObjectNum == objectData[20] && n5 != 0) {
            raidOn = false;
        }
    }

    private void step_nflag_move_ikeshita(int n) {
        int n2 = 16;
        int n3 = 16;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        boolean bl = false;
        int n7 = objectData[5];
        int n8 = 0;
        boolean bl2 = false;
        int n9 = 30;
        int n10 = -1;
        if (Math.abs(this.PlayerPosX() - objectData[2]) > 320) {
            MainCanvas.objectData[5] = 0;
            MainCanvas.objectData[18] = 0;
        }
        if (objectData[18] > 0) {
            objectData[18] = objectData[18] + 1;
        }
        for (n8 = 0; n8 < 4; ++n8) {
            if (objectData[10 + n8] == 0) {
                MainCanvas.objectData[10 + n8] = objectData[3];
            }
            if (objectData[19] == 1) {
                if (objectData[5] > 0 && n8 == 0 && (objectData[18] > n9 || objectData[18] < 0)) {
                    MainCanvas.objectData[18] = -1;
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > 188) {
                        MainCanvas.objectData[5] = 188;
                    }
                }
                if (objectData[5] > 60) {
                    n5 = n8 << 5;
                    n4 = (objectData[5] - 60 >> 2) * (n8 + 1);
                    n6 = objectData[10 + n8];
                } else {
                    n5 = n8 << 5;
                    n4 = 0;
                    n6 = objectData[10 + n8];
                }
            } else if (objectData[19] == 0) {
                if (objectData[5] > 0 && n8 == 0 && (objectData[18] > n9 || objectData[18] < 0)) {
                    MainCanvas.objectData[18] = -1;
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > 188) {
                        MainCanvas.objectData[5] = 188;
                    }
                }
                if (objectData[5] > 60) {
                    n5 = n8 << 5;
                    n4 = (objectData[5] - 60 >> 2) * (4 - n8);
                    n6 = objectData[10 + n8];
                } else {
                    n5 = n8 << 5;
                    n4 = 0;
                    n6 = objectData[10 + n8];
                }
            }
            MainCanvas.objectData[10 + n8] = objectData[3] + n4;
            n10 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] + n5, objectData[3] + n4, objectData[2] + n5, n6, n2, n3);
            if (n10 < 0) continue;
            if (n10 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 + n4 << 8;
                if (objectData[4] == 0 && objectData[5] == 0) {
                    objectData[5] = objectData[5] + 1;
                    MainCanvas.objectData[18] = -1;
                }
                this.setRaidOnSize(objectData[2] + n5, n2);
                this.playerRaidOn(objectData[22]);
                raidObjectNumSub = n8;
                bl2 = true;
                continue;
            }
            if (n10 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 + n5 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (!KeyPress[4]) continue;
                this.playerPushSet();
                continue;
            }
            if (n10 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + n5 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (!KeyPress[3]) continue;
                this.playerPushSet();
                continue;
            }
            if (n10 != 3) continue;
            MainCanvas.PlayerParam[1] = objectData[3] + n3 + n4 + 12 + 12 + 1 << 8;
            this.setHeadHit();
            if (objectData[4] != 2 || objectData[5] != 0) continue;
            MainCanvas.objectData[5] = 60;
            if (objectData[18] != 0) continue;
            MainCanvas.objectData[18] = 1;
        }
        n10 = bl2 ? 0 : -1;
        if (raidOn && raidObjectNum == objectData[20] && n10 != 0) {
            raidOn = false;
        }
    }

    private void fun_nflag_move_ikeshita(int n) {
        int n2 = 32;
        int n3 = 8;
        int n4 = 0;
        int n5 = 0;
        boolean bl = false;
        int n6 = 0;
        int n7 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        n4 = objectData[2] - this.PlayerPosX();
        n5 = Math.abs(objectData[3] - 64 + 16 - (this.PlayerPosY() - 24));
        bl = objectData[2] <= this.PlayerPosX();
        if (objectData[4] != 2) {
            if (this.animeTimer / 30 % 2 == 0) {
                MainCanvas.objectData[5] = this.animeTimer;
            }
        } else {
            MainCanvas.objectData[5] = this.animeTimer;
        }
        if (objectData[4] == 0) {
            if (this.animeTimer / 30 % 2 == 0) {
                if (objectData[19] != 0) {
                    if (n5 <= 64) {
                        if (n4 >= -64 && n4 <= 64) {
                            while (n6 < 16 && n4 >= -64 && n4 <= 64) {
                                PlayerParam[0] = PlayerParam[0] + 256;
                                n4 = objectData[2] - this.PlayerPosX();
                                ++n6;
                            }
                        }
                        if (n4 <= -64 && n4 >= -128) {
                            n7 = 4;
                            if (PlayerParam[10] / 2 > 1024) {
                                n7 = PlayerParam[10] / 2 >> 8;
                            }
                            while (n6 < n7 && n4 <= -64 && n4 >= -128) {
                                PlayerParam[0] = PlayerParam[0] + 256;
                                n4 = objectData[2] - this.PlayerPosX();
                                ++n6;
                            }
                        }
                    }
                } else if (n5 <= 64) {
                    if (n4 <= 64 && n4 >= -64) {
                        while (n6 < 16 && n4 <= 64 && n4 >= -64) {
                            PlayerParam[0] = PlayerParam[0] - 256;
                            n4 = objectData[2] - this.PlayerPosX();
                            ++n6;
                        }
                    }
                    if (n4 >= 64 && n4 <= 128) {
                        n7 = 4;
                        if (PlayerParam[10] / 2 > 1024) {
                            n7 = PlayerParam[10] / 2 >> 8;
                        }
                        while (n6 < n7 && n4 >= 64 && n4 <= 128) {
                            PlayerParam[0] = PlayerParam[0] - 256;
                            n4 = objectData[2] - this.PlayerPosX();
                            ++n6;
                        }
                    }
                }
            }
        } else if (objectData[4] == 1) {
            if (this.animeTimer / 30 % 2 == 0) {
                if (objectData[19] == 0) {
                    if (n5 <= 64) {
                        if (n4 >= -64 && n4 <= 64) {
                            while (n6 < 16 && n4 >= -64 && n4 <= 64) {
                                PlayerParam[0] = PlayerParam[0] + 256;
                                n4 = objectData[2] - this.PlayerPosX();
                                ++n6;
                            }
                        }
                        if (n4 <= -64 && n4 >= -128) {
                            n7 = 4;
                            if (PlayerParam[10] / 2 > 1024) {
                                n7 = PlayerParam[10] / 2 >> 8;
                            }
                            while (n6 < n7 && n4 <= -64 && n4 >= -128) {
                                PlayerParam[0] = PlayerParam[0] + 256;
                                n4 = objectData[2] - this.PlayerPosX();
                                ++n6;
                            }
                        }
                    }
                } else if (n5 <= 64) {
                    if (n4 <= 64 && n4 >= -64) {
                        while (n6 < 16 && n4 <= 64 && n4 >= -64) {
                            PlayerParam[0] = PlayerParam[0] - 256;
                            n4 = objectData[2] - this.PlayerPosX();
                            ++n6;
                        }
                    }
                    if (n4 >= 64 && n4 <= 128) {
                        n7 = 4;
                        if (PlayerParam[10] / 2 > 1024) {
                            n7 = PlayerParam[10] / 2 >> 8;
                        }
                        while (n6 < n7 && n4 >= 64 && n4 <= 128) {
                            PlayerParam[0] = PlayerParam[0] - 256;
                            n4 = objectData[2] - this.PlayerPosX();
                            ++n6;
                        }
                    }
                }
            }
        } else if (objectData[4] == 2) {
            if (objectData[19] != 0) {
                if (n5 <= 64) {
                    if (n4 >= -64 && n4 <= 64) {
                        while (n6 < 16 && n4 >= -64 && n4 <= 64) {
                            PlayerParam[0] = PlayerParam[0] + 256;
                            n4 = objectData[2] - this.PlayerPosX();
                            ++n6;
                        }
                    }
                    if (n4 <= -64 && n4 >= -128) {
                        n7 = 4;
                        if (PlayerParam[10] / 2 > 1024) {
                            n7 = PlayerParam[10] / 2 >> 8;
                        }
                        while (n6 < n7 && n4 <= -64 && n4 >= -128) {
                            PlayerParam[0] = PlayerParam[0] + 256;
                            n4 = objectData[2] - this.PlayerPosX();
                            ++n6;
                        }
                    }
                }
            } else if (objectData[19] == 0 && n5 <= 64) {
                if (n4 <= 64 && n4 >= -64) {
                    while (n6 < 16 && n4 <= 64 && n4 >= -64) {
                        PlayerParam[0] = PlayerParam[0] - 256;
                        n4 = objectData[2] - this.PlayerPosX();
                        ++n6;
                    }
                }
                if (n4 >= 64 && n4 <= 128) {
                    n7 = 4;
                    if (PlayerParam[10] / 2 > 1024) {
                        n7 = PlayerParam[10] / 2 >> 8;
                    }
                    while (n6 < n7 && n4 >= 64 && n4 <= 128) {
                        PlayerParam[0] = PlayerParam[0] - 256;
                        n4 = objectData[2] - this.PlayerPosX();
                        ++n6;
                    }
                }
            }
        }
        this.rcol3();
        this.rcol2();
        this.lcol3();
        this.lcol2();
    }

    private void belt_nflag_move_ikeshita(int n) {
        int n2;
        int n3 = 56;
        int n4 = 16;
        int n5 = 0;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        n3 = objectData[4] == 33 || objectData[4] == 225 ? 56 : 128;
        n5 = objectData[4] == 32 || objectData[4] == 33 ? 2 : (objectData[4] == 224 || objectData[4] == 225 ? -2 : 3);
        int n6 = 0;
        if (PlayerJump && olddir != 0) {
            n6 += this.dSin(olddir) * 20 / 100;
        }
        if ((n2 = this.ObjectColChk(this.PlayerPosX() + n6, this.PlayerPosY() - 12, ploldpos[0] + n6, ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n3, n4)) >= 0) {
            if (n2 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n4 << 8;
                this.setRaidOnSize(objectData[2], n3);
                this.playerRaidOn(objectData[22]);
                if (Math.abs(objectData[2] - this.PlayerPosX()) < n3 - 12) {
                    PlayerParam[0] = PlayerParam[0] + (n5 << 8);
                }
            } else if (n2 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n3 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n2 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n3 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n2 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n4 + 12 + 12 + 1 << 8;
                this.setHeadHit();
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n2 != 0) {
            raidOn = false;
        }
    }

    private void pata_nflag_move_ikeshita(int n) {
        if (objectData[4] != 1 && objectData[4] != 2) {
            int n2 = 16;
            int n3 = 7;
            int n4 = -1;
            MainCanvas.objectData[6] = objectData[2];
            MainCanvas.objectData[7] = objectData[3];
            int n5 = 4;
            if (objectData[4] >= 144) {
                MainCanvas.objectData[14] = objectData[4] == 152 ? objectData[4] : (objectData[4] > 152 ? 152 - (objectData[4] - 152) : 152 - (objectData[4] + 16 - 152));
                MainCanvas.objectData[13] = this.cpuTimer / n5 + objectData[14];
                MainCanvas.objectData[13] = objectData[13] % 32;
            } else {
                if (objectData[4] == 128) {
                    MainCanvas.objectData[14] = objectData[4];
                } else if (objectData[4] > 128) {
                    MainCanvas.objectData[14] = 128 - (objectData[4] - 128);
                }
                MainCanvas.objectData[13] = this.cpuTimer / n5 + objectData[14];
                MainCanvas.objectData[13] = objectData[13] % 20;
            }
            if ((objectData[13] == 0 || objectData[13] > 7) && (n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n2, n3)) >= 0) {
                if (n4 == 0) {
                    MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                    this.setRaidOnSize(objectData[2], n2);
                    this.playerRaidOn(objectData[22]);
                } else if (n4 == 1) {
                    MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[4]) {
                        this.playerPushSet();
                    }
                } else if (n4 == 2) {
                    MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[3]) {
                        this.playerPushSet();
                    }
                } else if (n4 == 3) {
                    MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
                    this.setHeadHit();
                }
            }
            if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
                raidOn = false;
            }
        } else {
            int n6 = 64;
            int n7 = 12;
            boolean bl = false;
            if (objectData[4] == 1 || objectData[4] == 2) {
                if (this.cpuTimer / 30 / 4 % 2 == 0) {
                    int n8 = this.ObjectColChkPl(objectData[2], objectData[3], objectData[2], objectData[3], n6, n7);
                    if (0 == n8) {
                        MainCanvas.PlayerParam[1] = objectData[3] - n7 << 8;
                        this.playerRaidOn(objectData[22]);
                    } else if (3 == n8) {
                        MainCanvas.PlayerParam[1] = objectData[3] + n7 + 12 + 12 + 1 << 8;
                        this.setHeadHit();
                    }
                    if (raidOn && raidObjectNum == objectData[20] && 0 != n8) {
                        raidOn = false;
                    }
                } else if (raidOn && raidObjectNum == objectData[20]) {
                    raidOn = false;
                }
            }
        }
    }

    private void fire6_nflag_move_ikeshita(int n) {
        int n2 = -1;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 5;
        int n7 = 12;
        if (!PlayerBall) {
            n7 = 24;
        }
        objectData[5] = objectData[5] + 1;
        n6 = objectData[5] / 4;
        n6 = n6 % 30 < 6 ? (n6 %= 30) : (n6 % 30 > 20 && n6 % 30 <= 25 ? 5 - (n6 - 20) % 30 : (n6 % 30 >= 25 ? 0 : 5));
        if (objectData[19] != 2) {
            n3 = 0;
            n4 = 49;
        } else {
            n3 = 0;
            n4 = -42;
        }
        for (int i = 0; i < n6; ++i) {
            n2 = objectData[19] != 2 ? this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] + n3, objectData[3] + n4 - n5, objectData[2] + n3, objectData[3] + n4 - n5, this.fire6_nflag_ike_sizeTable[4 - i] / 2 - 4, this.fire6_nflag_ike_sizeTable[4 - i] / 2 - 4) : this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] + n3, objectData[3] + n4 + (n5 += this.fire6_nflag_ike_sizeTable2[4 - i] - this.fire6_nflag_ike_posTable[4 - i]), objectData[2] + n3, objectData[3] + n4 + n5, this.fire6_nflag_ike_sizeTable[4 - i] / 2 - 4, this.fire6_nflag_ike_sizeTable[4 - i] / 2 - 4);
            if (n2 < 0) continue;
            this.playdamageset();
        }
    }

    private void bryuka_nflag_move_ikeshita(int n) {
        int n2 = 14;
        int n3 = 14;
        boolean bl = false;
        int n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[2], objectData[3], n2, n3);
        if (n4 >= 0) {
            if (n4 == 0) {
                if (PlayerBall) {
                    MainCanvas.objectData[0] = 0;
                    PlayerJump = true;
                    PlayerDamage = false;
                    PlayerBall = true;
                    MainCanvas.PlayerParam[5] = -1280;
                    if (comboScore == 0) {
                        comboScore = 100;
                    } else if (comboScore == 100) {
                        comboScore = 200;
                    } else if (comboScore == 200) {
                        comboScore = 500;
                    } else if (comboScore == 500) {
                        comboScore = 1000;
                    }
                    this.addScoreCount(comboScore);
                    this.ShotScore(objectData[2], objectData[3], comboScore);
                    this.ShotObj2(22, objectData[2] - 8, objectData[3] - 16, 330, 400, 0);
                    this.ShotObj2(22, objectData[2] - 8, objectData[3] - 16, 300, 400, 1);
                    this.ShotObj2(22, objectData[2] - 8, objectData[3] - 16, 390, 400, 2);
                    this.ShotObj2(22, objectData[2] - 8, objectData[3] - 16, 420, 400, 3);
                    MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                } else {
                    MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                    if (olddir != 0) {
                        MainCanvas.PlayerParam[0] = this.PlayerPosX() + this.dSin(olddir + 90) * 24 / 100 << 8;
                        olddir = 0;
                    }
                    this.setRaidOnSize(objectData[2], n2);
                    this.playerRaidOn(objectData[22]);
                }
            } else if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n4 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
                this.setHeadHit();
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    private void mawaru_nflag_move_ikeshita(int n) {
        int n2 = 45;
        int n3 = 45;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        int n4 = 0;
        n4 = objectData[5] - this.cpuTimer;
        n4 = Math.abs(n4);
        if (switchflag[objectData[4]]) {
            if (objectData[16] != 1) {
                MainCanvas.objectData[16] = 1;
                MainCanvas.objectData[17] = objectData[17] == 1 ? 0 : 1;
            }
        } else {
            MainCanvas.objectData[16] = 0;
        }
        objectData[13] = n4 != 1 ? (objectData[17] == 1 ? objectData[13] - n4 : objectData[13] + n4) : (objectData[17] == 1 ? objectData[13] - 1 : objectData[13] + 1);
        if (objectData[13] < 0) {
            MainCanvas.objectData[13] = 80 + objectData[13] % 80;
        }
        if (objectData[13] > 79) {
            MainCanvas.objectData[13] = objectData[13] % 80;
        }
        MainCanvas.objectData[15] = objectData[13] / 10;
        MainCanvas.objectData[5] = this.cpuTimer;
        MainCanvas.objectData[10] = this.mawaru_nflag_ike_posx[objectData[15]];
        MainCanvas.objectData[11] = this.mawaru_nflag_ike_posy[objectData[15]];
        int n5 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] - 1, objectData[3] - 1, objectData[6] - 1, objectData[7] - 1, n2, n3);
        if (n5 >= 0) {
            if (objectData[14] == 0) {
                if (n5 == 0) {
                    MainCanvas.PlayerParam[1] = objectData[3] - n3 - 1 << 8;
                    this.setRaidOnSize(objectData[2] - 1, n2);
                    this.playerRaidOn(objectData[22]);
                } else if (n5 == 1) {
                    MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 - 1 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[4]) {
                        this.playerPushSet();
                    }
                    if (objectData[14] == 0 && objectData[15] == 1) {
                        MainCanvas.objectData[14] = 1;
                        MainCanvas.objectData[18] = 1;
                    }
                } else if (n5 == 2) {
                    MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 - 1 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[3]) {
                        this.playerPushSet();
                    }
                    if (objectData[14] == 0 && objectData[15] == 5) {
                        MainCanvas.objectData[14] = 1;
                        MainCanvas.objectData[18] = 5;
                    }
                } else if (n5 == 3) {
                    MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 - 1 << 8;
                }
            }
        } else if (objectData[14] == 2) {
            MainCanvas.objectData[14] = 0;
        }
        if (raidOn && raidObjectNum == objectData[20] && n5 != 0) {
            raidOn = false;
        }
        if (objectData[14] == 1) {
            int[] nArray = new int[]{0, -80, -100, -80};
            int[] nArray2 = new int[]{-100, -80, 0, 80};
            PlayerJump = true;
            PlayerDamage = false;
            PlayerBall = true;
            int n6 = nArray[objectData[15] % 4] * 30 / 100;
            int n7 = nArray2[objectData[15] % 4] * 30 / 100;
            if (objectData[15] >= 4) {
                n6 *= -1;
                n7 *= -1;
            }
            MainCanvas.PlayerParam[0] = objectData[2] + n6 << 8;
            MainCanvas.PlayerParam[1] = objectData[3] + n7 + 12 << 8;
            if (objectData[15] == 4 && objectData[18] != 4) {
                MainCanvas.objectData[14] = 2;
                MainCanvas.PlayerParam[5] = 4096;
            }
            if (objectData[15] == 5 && objectData[18] != 5) {
                MainCanvas.objectData[14] = 2;
                MainCanvas.PlayerParam[10] = 2048;
                PlayerJump = false;
                PlayerBall = false;
            }
        }
    }

    private void yukai_nflag_move_ikeshita(int n) {
        int n2 = 96;
        int n3 = 24;
        boolean bl = false;
        int n4 = 0;
        int n5 = 48;
        int n6 = 24;
        int n7 = 96;
        int n8 = this.cpuTimer % (n7 + n5 + n7 + n5);
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        n4 = objectData[2];
        if (n8 < n7) {
            MainCanvas.objectData[2] = objectData[8] + n8;
        } else if (n8 < n7 + n5) {
            MainCanvas.objectData[2] = objectData[8] + n7;
            MainCanvas.objectData[3] = objectData[9] + (n8 - n7);
        } else if (n8 < n7 + n5 + n7) {
            MainCanvas.objectData[2] = objectData[8] + n7 - (n8 - n7 - n5);
            MainCanvas.objectData[3] = objectData[9] + n5 - 24 * (n8 - n7 - n5) / n7;
        } else if (n8 < n7 + n5 + n7 + n6) {
            MainCanvas.objectData[2] = objectData[8];
            MainCanvas.objectData[3] = objectData[9] + n5 - 24 - (n8 - n7 - n5 - n7);
        }
        n4 -= objectData[2];
        int n9 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n2, n3);
        if (n9 >= 0) {
            if (n9 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                MainCanvas.PlayerParam[0] = this.PlayerPosX() - n4 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
            } else if (n9 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n9 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n9 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
                this.setHeadHit();
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n9 != 0) {
            raidOn = false;
        }
    }

    private void door_nflag_move_ikeshita(int n) {
        int n2 = 4;
        int n3 = 32;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        int n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n2, n3);
        MainCanvas.objectData[15] = this.animeTimer / 5;
        MainCanvas.objectData[5] = this.animeTimer / 10;
        if (n4 >= 0 && objectData[10] == 0) {
            if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            }
        }
        if (objectData[19] == 0) {
            if (this.PlayerPosX() - 12 > objectData[2]) {
                objectData[10] = objectData[10] - 1;
                if (objectData[10] < 0) {
                    MainCanvas.objectData[10] = 0;
                }
            } else if (this.PlayerPosX() > objectData[2] - 24 && this.PlayerPosY() - 12 < objectData[3] + 32 && this.PlayerPosY() - 12 > objectData[3] - 32) {
                objectData[10] = objectData[10] + 1;
                if (objectData[10] > 4) {
                    MainCanvas.objectData[10] = 4;
                }
            } else {
                objectData[10] = objectData[10] - 1;
                if (objectData[10] < 0) {
                    MainCanvas.objectData[10] = 0;
                }
            }
        } else if (this.PlayerPosX() + 12 < objectData[2]) {
            objectData[10] = objectData[10] - 1;
            if (objectData[10] < 0) {
                MainCanvas.objectData[10] = 0;
            }
        } else if (this.PlayerPosX() < objectData[2] + 24 && this.PlayerPosY() - 12 <= objectData[3] + 32 && this.PlayerPosY() - 12 >= objectData[3] - 32) {
            objectData[10] = objectData[10] + 1;
            if (objectData[10] > 4) {
                MainCanvas.objectData[10] = 4;
            }
        } else {
            objectData[10] = objectData[10] - 1;
            if (objectData[10] < 0) {
                MainCanvas.objectData[10] = 0;
            }
        }
    }

    private void yukae_nflag_move_ikeshita(int n) {
        int n2 = 16;
        int n3 = 16;
        boolean bl = false;
        int n4 = 16;
        int n5 = -1;
        MainCanvas.objectData[5] = this.cpuTimer / 2 % 128;
        int n6 = (objectData[5] - objectData[4] / 2 + 256) % 128;
        if (n6 < 128) {
            if (n6 < 16) {
                n4 = n6;
            } else if (n6 > 64 && n6 < 80) {
                n4 = 80 - n6;
            } else if (n6 >= 80) {
                n4 = -1;
            }
        }
        if (n4 > 0) {
            n2 = 16;
            if (n4 <= 8 && n4 > 4) {
                n2 = 8;
            } else if (n4 <= 4) {
                n2 = 0;
            }
            if (n2 > 0) {
                n5 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3] + 8, objectData[2], objectData[3] + 8, n2, n3);
                if (n5 >= 0) {
                    if (n5 == 0) {
                        MainCanvas.PlayerParam[1] = objectData[3] + 8 - n3 << 8;
                        this.setRaidOnSize(objectData[2], n2);
                        this.playerRaidOn(objectData[22]);
                    } else if (n5 == 1) {
                        MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                        MainCanvas.PlayerParam[10] = 0;
                        if (KeyPress[4]) {
                            this.playerPushSet();
                        }
                    } else if (n5 == 2) {
                        MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                        MainCanvas.PlayerParam[10] = 0;
                        if (KeyPress[3]) {
                            this.playerPushSet();
                        }
                    }
                }
            } else {
                n5 = -1;
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n5 != 0) {
            raidOn = false;
        }
    }

    private void dai4_nflag_move_ikeshita(int n) {
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        int n2 = 0;
        int n3 = 0;
        int n4 = 62;
        int n5 = 11;
        int n6 = 0;
        if (objectData[4] < 128) {
            n4 = 28;
            n5 = 32;
        }
        if (objectData[4] == 203) {
            n4 = 128;
            n5 = 64;
            n6 = objectData[2];
            if (switchflag2[11] && objectData[18] == 0) {
                MainCanvas.objectData[18] = 1;
                MainCanvas.objectData[5] = 256;
                MainCanvas.objectData[2] = 2432;
                MainCanvas.objectData[3] = 320;
            }
            MainCanvas.objectData[18] = 1;
            if (objectData[5] == 0) {
                if (switchflag2[11]) {
                    MainCanvas.objectData[5] = 1;
                } else {
                    MainCanvas.objectData[2] = objectData[8];
                    MainCanvas.objectData[3] = objectData[9];
                }
            } else {
                if (this.cpuTimer % 2 == 0) {
                    objectData[5] = objectData[5] + 1;
                }
                if (objectData[5] > 256) {
                    MainCanvas.objectData[5] = 256;
                }
                MainCanvas.objectData[2] = objectData[8] - objectData[5];
                MainCanvas.objectData[3] = objectData[9] + objectData[5] / 2;
            }
            n6 -= objectData[2];
        } else if (objectData[4] == 52) {
            n3 = 6;
            n2 = this.animeTimer % (30 + n3 * 2);
            if (n2 < 15) {
                MainCanvas.objectData[3] = objectData[9];
            } else if (n2 < 15 + n3) {
                MainCanvas.objectData[3] = objectData[9] + (n2 - 15) * 16;
            } else if (n2 < 15 + n3 + 15) {
                MainCanvas.objectData[3] = objectData[9] + n3 * 16;
            } else if (n2 < 15 + n3 + 15 + n3) {
                MainCanvas.objectData[3] = objectData[9] + n3 * 16 - (n2 - (15 + n3 + 15)) * 16;
            }
        } else if (objectData[4] == 36) {
            n3 = 4;
            n2 = this.animeTimer % (30 + n3 * 2);
            if (n2 < 15) {
                MainCanvas.objectData[3] = objectData[9];
            } else if (n2 < 15 + n3) {
                MainCanvas.objectData[3] = objectData[9] + (n2 - 15) * 16;
            } else if (n2 < 15 + n3 + 15) {
                MainCanvas.objectData[3] = objectData[9] + n3 * 16;
            } else if (n2 < 15 + n3 + 15 + n3) {
                MainCanvas.objectData[3] = objectData[9] + n3 * 16 - (n2 - (15 + n3 + 15)) * 16;
            }
        } else if (objectData[4] == 19) {
            n3 = 4;
            n2 = this.animeTimer % (30 + n3 * 2);
            if (n2 < 15) {
                MainCanvas.objectData[3] = objectData[9] + 8;
                objectData[3] = objectData[3] - 16;
            } else if (n2 < 15 + n3) {
                MainCanvas.objectData[3] = objectData[9] + (n2 - 15) * 16 + 8;
                objectData[3] = objectData[3] - 16;
            } else if (n2 < 15 + n3 + 15) {
                MainCanvas.objectData[3] = objectData[9] + n3 * 16 + 8;
                objectData[3] = objectData[3] - 16;
            } else if (n2 < 15 + n3 + 15 + n3) {
                MainCanvas.objectData[3] = objectData[9] + n3 * 16 - (n2 - (15 + n3 + 15)) * 16 + 8;
                objectData[3] = objectData[3] - 16;
            }
        } else if (objectData[4] >= 128) {
            n6 = objectData[2];
            if (switchflag[objectData[4] - 128]) {
                if (objectData[5] == 0) {
                    MainCanvas.objectData[10] = 0;
                    MainCanvas.objectData[11] = this.cpuTimer;
                }
                MainCanvas.objectData[5] = 1;
            }
            if (objectData[5] != 0) {
                MainCanvas.objectData[10] = this.cpuTimer - objectData[11];
                if (objectData[19] == 0) {
                    if (objectData[10] < 128) {
                        MainCanvas.objectData[2] = objectData[8] - objectData[10];
                    } else if (objectData[10] > 178) {
                        MainCanvas.objectData[2] = objectData[8] - (128 - (objectData[10] - 128 - 50));
                    }
                } else if (objectData[10] < 128) {
                    MainCanvas.objectData[2] = objectData[8] + objectData[10] - 128;
                } else if (objectData[10] > 178) {
                    MainCanvas.objectData[2] = objectData[8] + (128 - (objectData[10] - 128 - 50)) - 128;
                }
                if (objectData[10] > 306) {
                    MainCanvas.objectData[5] = 0;
                }
            }
            if (objectData[5] == 0) {
                MainCanvas.objectData[2] = objectData[19] == 0 ? objectData[8] : objectData[8] - 128;
            }
            n6 -= objectData[2];
        }
        boolean bl = false;
        int n7 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n4, n5);
        if ((this.stageNumber != 3 || objectData[4] != 64) && n7 >= 0) {
            if (n7 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n5 << 8;
                this.setRaidOnSize(objectData[2], n4);
                this.playerRaidOn(objectData[22]);
                PlayerParam[0] = PlayerParam[0] - (n6 << 8);
            } else if (n7 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n4 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n7 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n4 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n7 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n5 + 12 + 12 + 1 << 8;
                this.setHeadHit();
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n7 != 0) {
            raidOn = false;
        }
    }

    private void ele_nflag_move_ikeshita(int n) {
        int n2 = 0;
        int n3 = 1;
        int n4 = -1;
        int n5 = 12;
        if (!PlayerBall) {
            n5 = 24;
        }
        MainCanvas.objectData[5] = this.animeTimer % ((n2 = objectData[4] * 2) + 5) < n2 ? 0 : (this.animeTimer % (n2 + 5) - n2) / 1 + 1;
        if (objectData[19] == 2) {
            n3 = -1;
        }
        if (objectData[5] >= 2) {
            for (int i = 0; i <= 1; ++i) {
                if (this.ele_nflag_ike_anime[objectData[5] - 2][i] == 0) continue;
                n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] + 24 + i * 32 - 4, objectData[3] - 4 * n3, objectData[2] + 24 + i * 32 - 4, objectData[3] - 4 * n3, 16, 8);
                if (n4 >= 0) {
                    this.playdamageset();
                } else if (24 >= Math.abs(this.PlayerPosX() - (objectData[2] + 24 + i * 32)) && 8 + n5 >= Math.abs(this.PlayerPosY() - n5 - (objectData[3] - 4 * n3))) {
                    this.playdamageset();
                }
                n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2] - 24 - i * 32 + 4, objectData[3] - 4 * n3, objectData[2] - 24 - i * 32 + 4, objectData[3] - 4 * n3, 16, 8);
                if (n4 >= 0) {
                    this.playdamageset();
                    continue;
                }
                if (24 < Math.abs(this.PlayerPosX() - (objectData[2] - 24 - i * 32)) || 8 + n5 < Math.abs(this.PlayerPosY() - n5 - (objectData[3] - 4 * n3))) continue;
                this.playdamageset();
            }
        }
    }

    private void beltc_nflag_move_ikeshita(int n) {
        int n2;
        int n3;
        int n4 = 0;
        boolean bl = false;
        int n5 = -1;
        int n6 = 0;
        int[] nArray = new int[this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2 + 1];
        nArray[0] = 0;
        for (n3 = 0; n3 < this.beltc_nflag_ike_defx.length; ++n3) {
            if (objectData[9] != this.beltc_nflag_ike_defy[n3] || objectData[8] != this.beltc_nflag_ike_defx[n3]) continue;
            n4 = n3;
        }
        for (n3 = 0; n3 < this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2; ++n3) {
            for (n2 = 0; n2 < 2; ++n2) {
                this.beltc_nflag_ike_startPos[n2] = 0;
                this.beltc_nflag_ike_endPos[n2] = 0;
            }
            this.beltc_nflag_ike_startPos[0] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][n3 * 2 + 0];
            this.beltc_nflag_ike_startPos[1] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][n3 * 2 + 1];
            this.beltc_nflag_ike_endPos[0] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][(n3 + 1) % (this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 0];
            this.beltc_nflag_ike_endPos[1] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][(n3 + 1) % (this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 1];
            n6 = Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]) < Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1]) ? (n6 += Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1])) : (n6 += Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]));
            nArray[n3 + 1] = n6;
        }
        int n7 = n6 / 69;
        int n8 = 0;
        int n9 = 0;
        if (objectData[18] == 0) {
            for (n3 = 0; n3 < kassya_x[n4].length; ++n3) {
                MainCanvas.kassya_x[n4][n3] = 0;
                MainCanvas.kassya_y[n4][n3] = 0;
            }
        }
        MainCanvas.objectData[18] = 1;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        for (n3 = 0; n3 < n7; ++n3) {
            int n15;
            n10 = 0;
            n11 = 0;
            n12 = 0;
            n13 = 0;
            n8 = (n3 * 69 + this.cpuTimer) % n6;
            for (n15 = 0; n15 < this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2; ++n15) {
                if (n8 >= nArray[n15 + 1]) continue;
                n14 = n8 - nArray[n15 + 1];
                for (n2 = 0; n2 < 2; ++n2) {
                    this.beltc_nflag_ike_startPos[n2] = 0;
                    this.beltc_nflag_ike_endPos[n2] = 0;
                }
                this.beltc_nflag_ike_startPos[0] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][n15 * 2 + 0];
                this.beltc_nflag_ike_startPos[1] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][n15 * 2 + 1];
                this.beltc_nflag_ike_endPos[0] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][(n15 + 1) % (this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 0];
                this.beltc_nflag_ike_endPos[1] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][(n15 + 1) % (this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 1];
                if (Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]) < Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1])) {
                    n10 = this.beltc_nflag_ike_endPos[0] + (this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]) * n14 / Math.abs(this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]);
                    n11 = this.beltc_nflag_ike_endPos[1] + n14 * ((this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]) / Math.abs(this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]));
                    break;
                }
                n10 = this.beltc_nflag_ike_endPos[0] + n14 * ((this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]) / Math.abs(this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]));
                n11 = this.beltc_nflag_ike_endPos[1] + (this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]) * n14 / Math.abs(this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]);
                break;
            }
            if (kassya_x[n4][n3] == 0 && kassya_y[n4][n3] == 0) {
                MainCanvas.kassya_x[n4][n3] = n10;
                MainCanvas.kassya_y[n4][n3] = n11;
            }
            n12 = kassya_x[n4][n3];
            n13 = kassya_y[n4][n3];
            MainCanvas.kassya_x[n4][n3] = n10;
            MainCanvas.kassya_y[n4][n3] = n11;
            for (n15 = 0; n15 < this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2; ++n15) {
                if (n8 >= nArray[n15 + 1]) continue;
                n9 = n15;
                break;
            }
            int n16 = 16;
            int n17 = 7;
            if (bl || (n5 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, n10, n11, n12, n13, n16, n17)) < 0 || n9 == 1 || n9 == 2 || n5 != 0) continue;
            MainCanvas.PlayerParam[1] = n11 - n17 << 8;
            PlayerParam[0] = PlayerParam[0] - (n12 - n10 << 8);
            raidObjectNumSub = n3;
            this.setRaidOnSize(n10, n16 + 4);
            this.playerRaidOn(objectData[22]);
            bl = true;
        }
        if (bl) {
            n5 = 0;
        }
        if (raidOn && raidObjectNum == objectData[20] && n5 != 0) {
            raidOn = false;
        }
    }

    private void noko_nflag_move_ikeshita(int n) {
        int n2 = 0;
        int n3 = 30;
        int n4 = 30;
        int n5 = -1;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        MainCanvas.objectData[15] = this.animeTimer & 1;
        if (objectData[4] == 1) {
            MainCanvas.objectData[10] = 1;
            MainCanvas.objectData[2] = this.cpuTimer / 2 % 192 < 96 ? objectData[8] - this.cpuTimer / 2 % 192 : objectData[8] - (96 - (this.cpuTimer / 2 % 192 - 96));
        } else if (objectData[4] == 2) {
            MainCanvas.objectData[10] = 1;
            MainCanvas.objectData[3] = this.cpuTimer / 2 % 112 < 56 ? objectData[9] - this.cpuTimer / 2 % 112 : objectData[9] - (56 - (this.cpuTimer / 2 % 112 - 56));
        } else if (objectData[4] == 3) {
            if (objectData[10] == 0) {
                if (objectData[2] > this.PlayerPosX() - 180 && objectData[2] < this.PlayerPosX() - 150) {
                    MainCanvas.objectData[5] = this.cpuTimer;
                    MainCanvas.objectData[10] = 1;
                }
            } else if (objectData[10] == 1) {
                MainCanvas.objectData[2] = objectData[8] + (this.cpuTimer - objectData[5]) * 3;
                n2 = objectData[2] - this.PlayerPosX();
                if (n2 > 200) {
                    MainCanvas.objectData[5] = 0;
                    MainCanvas.objectData[10] = 0;
                    MainCanvas.objectData[2] = objectData[8];
                }
            }
        }
        int n6 = 12;
        if (!PlayerBall && !PlayerCrouch) {
            n6 = 20;
        }
        if (objectData[10] != 0) {
            n5 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n3, n4);
            if (n5 >= 0) {
                this.playdamageset();
            } else if (Math.abs(objectData[2] - this.PlayerPosX()) < 12 + n3 && Math.abs(objectData[3] - (this.PlayerPosY() - n6)) < n6 + n4) {
                this.playdamageset();
            }
        }
    }

    private void save_sflag_move_ikeshita(int n) {
        int n2;
        int n3 = 8;
        int n4 = 32;
        boolean bl = false;
        if (objectData[5] == 0 && plsaveX == objectData[2] && plsaveY == objectData[3]) {
            MainCanvas.objectData[5] = 32;
        }
        if (objectData[5] > 0) {
            objectData[5] = objectData[5] + 1;
            if (objectData[5] > 32) {
                MainCanvas.objectData[5] = 32;
            }
        }
        if ((n2 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3] - 12, objectData[2], objectData[3] - 12, n3, n4)) >= 0 && objectData[5] == 0) {
            MainCanvas.objectData[5] = 1;
            plsaveX = objectData[2];
            plsaveY = objectData[3];
            plsaveTime = timecount;
            plsaveTime2 = timecount2;
        }
    }

    private void kageb_nflag_move_ikeshita(int n) {
        int n2 = 8;
        int n3 = 32;
        boolean bl = false;
        if (objectData[4] < 16) {
            int n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[2], objectData[3], n2, n3);
            if (n4 >= 0) {
                if (n4 == 1) {
                    MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[4]) {
                        this.playerPushSet();
                    }
                } else if (n4 == 2) {
                    MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[3]) {
                        this.playerPushSet();
                    }
                } else if (n4 == 3) {
                    MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
                    this.setHeadHit();
                }
            }
            if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
                raidOn = false;
            }
        }
    }

    private void item_nflag_move_ikeshita(int n) {
        int n2;
        int n3 = 16;
        int n4 = 16;
        boolean bl = false;
        if (objectData[4] >= 10) {
            return;
        }
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        if (objectData[12] == 1) {
            n2 = 0;
            n2 = (this.animeTimer - objectData[14]) * 4;
            MainCanvas.objectData[14] = this.animeTimer;
            if (n2 > 0) {
                for (int i = n2; i >= 0; --i) {
                    if (objectData[3] < objectData[7] + 1000) {
                        objectData[3] = objectData[3] + 2;
                    }
                    if (this.blockColChk_Enemy(objectData[2], objectData[3] + n3) && objectData[3] > objectData[7] - 1000) {
                        objectData[3] = objectData[3] - 2;
                        MainCanvas.objectData[12] = 0;
                        break;
                    }
                    if (objectData[3] >= 0) continue;
                    MainCanvas.objectData[3] = 0;
                }
            }
        }
        n2 = this.ObjectColChk2(objectData[2], objectData[3], objectData[6], objectData[7], n3, n4);
        if (objectData[4] == 0) {
            n2 = -1;
        }
        if (objectData[5] != 0) {
            MainCanvas.objectData[7] = (this.animeTimer - objectData[13]) * 2;
            if (objectData[7] > 60) {
                MainCanvas.objectData[7] = 60;
            }
        }
        if (n2 >= 0) {
            if (PlayerBall && n2 != 3 || !PlayerJump && PlayerBall && n2 == 3) {
                MainCanvas.PlayerParam[5] = -768;
                this.SetObj2(1, objectData[2], objectData[3], 0, 0, 0, 0);
                MainCanvas.objectData[5] = objectData[4];
                MainCanvas.objectData[13] = this.animeTimer;
                this.getItem(objectData[4]);
                MainCanvas.objectData[4] = 0;
            } else if (n2 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n4 << 8;
                this.setRaidOnSize(objectData[2], n3);
                this.playerRaidOn(objectData[22]);
            } else if (n2 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n3 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n2 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n3 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n2 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n4 + 12 + 12 + 1 << 8;
                if (PlayerParam[5] < 0) {
                    PlayerParam[5] = PlayerParam[5] * -1;
                }
                if (objectData[12] == 0) {
                    objectData[3] = objectData[3] - 5;
                    MainCanvas.objectData[14] = this.animeTimer;
                }
                MainCanvas.objectData[12] = 1;
                if (!PlayerJump) {
                    MainCanvas.PlayerParam[0] = this.PlayerPosX() < objectData[2] ? this.PlayerPosX() - 5 << 8 : this.PlayerPosX() + 5 << 8;
                }
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n2 != 0) {
            raidOn = false;
        }
    }

    private void item_sflag_move_ikeshita(int n) {
        this.item_nflag_move_ikeshita(n);
    }

    private void gole_nflag_move_ikeshita(int n) {
        int n2 = 3;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        if (objectData[5] == 1) {
            objectData[10] = objectData[10] + 1;
            if (objectData[10] > 129) {
                MainCanvas.objectData[10] = 129;
                MainCanvas.objectData[5] = 2;
                this.initGoleStart();
            }
        } else if (objectData[5] == 0 && this.PlayerPosX() > objectData[2] - n2 && objectData[3] + 48 > this.PlayerPosY()) {
            MainCanvas.objectData[5] = 1;
            MainCanvas.objectData[10] = 0;
            this.gole_on = true;
        }
    }

    private void bten_nflag_move_ikeshita(int n) {
        int n2 = 12;
        int n3 = 12;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        if (objectData[5] == 0) {
            int n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n2, n3);
            if (n4 >= 0) {
                MainCanvas.objectData[5] = 1;
                MainCanvas.objectData[11] = 0;
                this.addScoreCount(this.bten_nflag_ike_score[objectData[4]]);
            }
        } else if (objectData[5] == 1) {
            objectData[11] = objectData[11] + 1;
            if (objectData[11] > 120) {
                MainCanvas.objectData[5] = 2;
            }
        }
    }

    private void bten_sflag_move_ikeshita(int n) {
        this.bten_nflag_move_ikeshita(n);
    }

    private void bigring_nflag_move_ikeshita(int n) {
        int n2 = 32;
        int n3 = 32;
        if (ringcount >= 50) {
            MainCanvas.objectData[6] = objectData[2];
            MainCanvas.objectData[7] = objectData[3];
            if (objectData[5] == 0) {
                int n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n2, n3);
                if (n4 >= 0) {
                    MainCanvas.objectData[5] = 1;
                    MainCanvas.objectData[0] = -1;
                    MainCanvas.objectData[11] = this.animeTimer;
                }
            } else {
                MainCanvas.objectData[10] = (this.animeTimer - objectData[11]) / 1;
                if (objectData[10] > 5) {
                    MainCanvas.objectData[10] = 5;
                }
            }
        }
    }

    private void scoli_nflag_move_ikeshita(int n) {
        int n2 = 16;
        int n3 = 16;
        int n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[2], objectData[3], n2, n3);
        if (n4 >= 0 && n4 != 0) {
            if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    // empty if block
                }
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    // empty if block
                }
            } else if (n4 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
                this.setHeadHit();
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    private void shooter_nflag_move_ikeshita(int n) {
        int n2 = 27;
        int n3 = 44;
        int n4 = -1;
        n2 = 5;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        if (objectData[5] == 0 && (n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n2, n3)) >= 0) {
            if (n4 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
            } else if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (objectData[19] == 0) {
                    MainCanvas.objectData[5] = 1;
                    MainCanvas.objectData[10] = 0;
                } else if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (objectData[19] != 0) {
                    MainCanvas.objectData[5] = 1;
                    MainCanvas.objectData[10] = 0;
                } else if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n4 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
                this.setHeadHit();
            }
        }
        if (objectData[5] == 1) {
            PlayerJump = true;
            PlayerDamage = false;
            PlayerBall = true;
            PlayerNoCol = true;
            PlayerNoCtrl = true;
            PlayerParam[11] = PlayerParam[11] + plmaxspd;
            objectData[10] = objectData[10] + 1;
            MainCanvas.PlayerParam[0] = objectData[2] << 8;
            MainCanvas.PlayerParam[1] = objectData[3] + 12 - this.shooter_nflag_ike_pos[objectData[10] / 5 % 12] << 8;
            if (objectData[10] / 5 % 12 == 11) {
                MainCanvas.objectData[5] = 2;
                if (objectData[4] == 0 || objectData[4] == 6) {
                    MainCanvas.objectData[5] = 4;
                }
                MainCanvas.objectData[10] = 0;
                MainCanvas.objectData[11] = 0;
                MainCanvas.objectData[12] = 0;
                MainCanvas.PlayerParam[3] = 0;
                MainCanvas.PlayerParam[5] = 0;
                MainCanvas.PlayerParam[10] = 0;
            }
        }
        if (objectData[5] == 4) {
            if (objectData[4] == 0) {
                MainCanvas.PlayerParam[1] = this.PlayerPosY() + 10 << 8;
                if (objectData[3] > this.PlayerPosY()) {
                    MainCanvas.objectData[5] = 2;
                }
            } else {
                MainCanvas.PlayerParam[1] = this.PlayerPosY() - 10 << 8;
                if (158 < this.PlayerPosY()) {
                    MainCanvas.objectData[5] = 2;
                }
            }
        }
        if (objectData[5] == 2) {
            PlayerJump = true;
            PlayerDamage = false;
            PlayerBall = true;
            PlayerNoCol = true;
            PlayerNoCtrl = true;
            PlayerParam[11] = PlayerParam[11] + plmaxspd;
            MainCanvas.objectData[11] = 0;
            MainCanvas.objectData[12] = 0;
            if (objectData[10] * 2 + 1 < this.shooter_nflag_ike_objectPos[objectData[4]].length) {
                if (this.PlayerPosX() > this.shooter_nflag_ike_objectPos[objectData[4]][objectData[10] * 2]) {
                    MainCanvas.objectData[11] = -1;
                } else if (this.PlayerPosX() < this.shooter_nflag_ike_objectPos[objectData[4]][objectData[10] * 2]) {
                    MainCanvas.objectData[11] = 1;
                }
                if (this.PlayerPosY() > this.shooter_nflag_ike_objectPos[objectData[4]][objectData[10] * 2 + 1]) {
                    MainCanvas.objectData[12] = -1;
                } else if (this.PlayerPosY() < this.shooter_nflag_ike_objectPos[objectData[4]][objectData[10] * 2 + 1]) {
                    MainCanvas.objectData[12] = 1;
                }
                objectData[10] = objectData[10] + 1;
                MainCanvas.objectData[5] = 3;
            } else {
                MainCanvas.objectData[5] = 0;
                PlayerNoCol = false;
                PlayerNoCtrl = false;
            }
        }
        if (objectData[5] == 3) {
            PlayerParam[11] = PlayerParam[11] + plmaxspd;
            PlayerJump = true;
            PlayerDamage = false;
            PlayerBall = true;
            PlayerNoCol = true;
            PlayerNoCtrl = true;
            if (objectData[11] != 0) {
                MainCanvas.PlayerParam[0] = this.PlayerPosX() + objectData[11] * 10 << 8;
                if (objectData[11] == -1 && this.PlayerPosX() < this.shooter_nflag_ike_objectPos[objectData[4]][(objectData[10] - 1) * 2]) {
                    MainCanvas.PlayerParam[0] = this.shooter_nflag_ike_objectPos[objectData[4]][(objectData[10] - 1) * 2] << 8;
                    MainCanvas.objectData[11] = 0;
                }
                if (objectData[11] == 1 && this.PlayerPosX() > this.shooter_nflag_ike_objectPos[objectData[4]][(objectData[10] - 1) * 2]) {
                    MainCanvas.PlayerParam[0] = this.shooter_nflag_ike_objectPos[objectData[4]][(objectData[10] - 1) * 2] << 8;
                    MainCanvas.objectData[11] = 0;
                }
            }
            if (objectData[12] != 0) {
                MainCanvas.PlayerParam[1] = this.PlayerPosY() + objectData[12] * 10 << 8;
                if (objectData[12] == -1 && this.PlayerPosY() < this.shooter_nflag_ike_objectPos[objectData[4]][(objectData[10] - 1) * 2 + 1]) {
                    MainCanvas.PlayerParam[1] = this.shooter_nflag_ike_objectPos[objectData[4]][(objectData[10] - 1) * 2 + 1] << 8;
                    MainCanvas.objectData[12] = 0;
                }
                if (objectData[12] == 1 && this.PlayerPosY() > this.shooter_nflag_ike_objectPos[objectData[4]][(objectData[10] - 1) * 2 + 1]) {
                    MainCanvas.PlayerParam[1] = this.shooter_nflag_ike_objectPos[objectData[4]][(objectData[10] - 1) * 2 + 1] << 8;
                    MainCanvas.objectData[12] = 0;
                }
            }
            if (objectData[11] == 0 && objectData[12] == 0) {
                MainCanvas.PlayerParam[0] = this.shooter_nflag_ike_objectPos[objectData[4]][(objectData[10] - 1) * 2] << 8;
                MainCanvas.PlayerParam[1] = this.shooter_nflag_ike_objectPos[objectData[4]][(objectData[10] - 1) * 2 + 1] << 8;
                MainCanvas.objectData[5] = 2;
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    private void masin_nflag_move_ikeshita(int n) {
        int n2 = 32;
        int n3 = 28;
        int n4 = 4;
        if (objectData[4] == 1) {
            n2 = 12;
            n3 = 8;
            n4 = 0;
        }
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        int n5 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3] + n4, objectData[6], objectData[7] + n4, n2, n3);
        if (n5 >= 0) {
            if (n5 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 + n4 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
                if (objectData[4] == 1 && objectData[5] == 0) {
                    this.gole_on = true;
                    MainCanvas.objectData[5] = 1;
                    objectData[3] = objectData[3] + 8;
                    MainCanvas.objectData[10] = this.cpuTimer;
                    this.m_bScrollLock = (byte)2;
                }
            } else if (!this.limitBreak) {
                if (n5 == 1) {
                    MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[4]) {
                        this.playerPushSet();
                    }
                } else if (n5 == 2) {
                    MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[3]) {
                        this.playerPushSet();
                    }
                } else if (n5 == 3) {
                    MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 + n4 << 8;
                }
            }
        }
        if (objectData[5] == 1) {
            if ((this.cpuTimer - objectData[10]) % 20 == 0 && this.masin_nflag_ike_x.length > (this.cpuTimer - objectData[10]) / 20) {
                this.SetObj2(1, objectData[8] + this.masin_nflag_ike_x[(this.cpuTimer - objectData[10]) / 20], objectData[9] + this.masin_nflag_ike_y[(this.cpuTimer - objectData[10]) / 20], 0, 0, 0, 0);
            }
            if (this.cpuTimer - objectData[10] > 100) {
                MainCanvas.objectData[5] = 2;
                MainCanvas.objectData[10] = this.cpuTimer;
                this.ShotAnimal(objectData[8] + 4, objectData[9] + 27 + 16, this.zoneNumber);
            }
        } else if (objectData[5] == 2 && this.cpuTimer - objectData[10] > 180) {
            this.initGoleStart();
            objectData[5] = objectData[5] + 1;
        }
        if (raidOn && raidObjectNum == objectData[20] && n5 != 0) {
            raidOn = false;
        }
    }

    private void bobin_sflag_move_ikeshita(int n) {
        int n2 = 8;
        int n3 = 8;
        boolean bl = false;
        int n4 = this.ObjectColChkPl(objectData[2], objectData[3], objectData[2], objectData[3], n2, n3);
        if (n4 >= 0) {
            int n5 = Math.abs(this.PlayerPosX() - objectData[2]);
            int n6 = Math.abs(this.PlayerPosY() - 12 - objectData[3]);
            if (objectData[10] < 10) {
                this.ShotScore(objectData[2], objectData[3], 10);
                this.addScoreCount(10);
                objectData[10] = objectData[10] + 1;
            }
            MainCanvas.PlayerParam[3] = this.PlayerPosX() - objectData[2] > 0 ? 1792 * n5 / (n5 + n6) : -1792 * n5 / (n5 + n6);
            MainCanvas.PlayerParam[5] = this.PlayerPosY() - 12 - objectData[3] > 0 ? 2048 * n6 / (n5 + n6) : -2048 * n6 / (n5 + n6);
            if (!PlayerJump) {
                MainCanvas.PlayerParam[3] = PlayerParam[3] * 80 / 100;
                PlayerParam[5] = PlayerParam[5] - 1024;
            }
            MainCanvas.PlayerParam[10] = 0;
            MainCanvas.PlayerParam[13] = 0;
            MainCanvas.PlayerParam[14] = 0;
            PlayerJump = true;
            PlayerDamage = false;
            PlayerAir = true;
            raidOn = false;
        }
    }

    private void jyama_nflag_move_ikeshita(int n) {
        boolean bl = false;
        boolean bl2 = false;
        int n2 = 16;
        int n3 = 16;
        int n4 = this.ObjectColChkPl(objectData[2], objectData[3], objectData[2], objectData[3], n2, n3);
        if (n4 >= 0) {
            if (n4 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
            } else if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
                MainCanvas.PlayerParam[10] = 0;
                MainCanvas.PlayerParam[13] = 0;
                MainCanvas.PlayerParam[14] = 0;
            } else if (n4 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    private void fetama_nflag_move_ikeshita(int n) {
        int n2;
        int n3 = this.animeTimer;
        int n4 = 0;
        int n5 = 16;
        int n6 = 16;
        int n7 = 4;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        if (objectData[19] == 1) {
            n3 += 45;
        } else if (objectData[19] == 2) {
            n3 += 135;
        } else if (objectData[19] == 3) {
            n3 += 180;
        }
        if (objectData[4] == 195 || objectData[4] == 179) {
            n7 = 8;
        }
        if (objectData[4] == 243 || objectData[4] == 195 || objectData[4] == 227 || objectData[4] == 179) {
            MainCanvas.vect((360 / n7 - n3 % (360 / n7)) * n7, 16, 17);
            MainCanvas.objectData[2] = objectData[8] + objectData[16] * 80 / 10000;
            MainCanvas.objectData[3] = objectData[9] + objectData[17] * 80 / 10000;
        } else {
            n7 = 1;
            n2 = this.animeTimer;
            if (objectData[19] == 1) {
                n3 += 24;
            } else if (objectData[19] == 2) {
                n3 += 48;
            } else if (objectData[19] == 3) {
                n3 += 72;
            }
            if (objectData[4] == 2) {
                MainCanvas.objectData[3] = objectData[19] != 0 ? (n2 % 96 * 2 < 96 ? objectData[9] - (96 - (n2 % 96 * 2 - 96)) + 64 : objectData[9] - n2 % 96 * 2 + 64) : (n2 % 96 * 2 < 96 ? objectData[9] - n2 % 96 * 2 : objectData[9] - (96 - (n2 % 96 * 2 - 96)));
            } else if (objectData[4] == 1) {
                MainCanvas.objectData[2] = n2 % 96 * 2 < 96 ? objectData[8] - n2 % 96 * 2 : objectData[8] - (96 - (n2 % 96 * 2 - 96));
            }
        }
        n2 = 12;
        if (!PlayerBall && !PlayerCrouch) {
            n2 = 20;
        }
        if ((n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[6], objectData[7], n5, n6)) >= 0) {
            this.playdamageset();
        } else if (Math.abs(objectData[2] - this.PlayerPosX()) < 12 + n5 && Math.abs(objectData[3] - (this.PlayerPosY() - n2)) < n2 + n6) {
            this.playdamageset();
        }
    }

    private void tekyu_nflag_move_ikeshita(int n) {
        int n2;
        int n3 = 0;
        int n4 = 0;
        boolean bl = false;
        int n5 = 0;
        int n6 = 0;
        int n7 = 12;
        if (!PlayerBall && !PlayerCrouch) {
            n7 = 20;
        }
        if (objectData[18] == 0) {
            MainCanvas.objectData[5] = this.animeTimer;
            MainCanvas.objectData[18] = 1;
        }
        n3 = this.animeTimer - objectData[5];
        n4 = n3 - 1;
        if (objectData[4] == 213 || objectData[4] == 181 || objectData[4] == 197 || objectData[4] == 101 || objectData[4] == 69 || objectData[4] == 53) {
            n5 = 5;
        } else if (objectData[4] == 212 || objectData[4] == 196 || objectData[4] == 84 || objectData[4] == 68 || objectData[4] == 52) {
            n5 = 4;
        } else if (objectData[4] == 38) {
            n5 = 6;
        } else if (objectData[4] == 195) {
            n5 = 3;
        }
        if (objectData[4] == 181 || objectData[4] == 101) {
            n6 = 12;
        } else if (objectData[4] == 196 || objectData[4] == 197 || objectData[4] == 84 || objectData[4] == 195) {
            n6 = 10;
        } else if (objectData[4] == 213 || objectData[4] == 212 || objectData[4] == 69 || objectData[4] == 68) {
            n6 = 8;
        } else if (objectData[4] == 52 || objectData[4] == 53) {
            n6 = 6;
        } else if (objectData[4] == 38) {
            n6 = 4;
        }
        if (objectData[4] != 69 && objectData[4] != 84 && objectData[4] != 101 && objectData[4] != 38 && objectData[4] != 68 && objectData[4] != 52 && objectData[4] != 53) {
            MainCanvas.vect((360 / n6 - n3 % (360 / n6)) * n6, 16, 17);
            MainCanvas.vect((360 / n6 - n4 % (360 / n6)) * n6, 14, 15);
        } else {
            MainCanvas.vect(360 - (360 / n6 - n3 % (360 / n6)) * n6 % 360, 16, 17);
            MainCanvas.vect(360 - (360 / n6 - n4 % (360 / n6)) * n6 % 360, 14, 15);
        }
        if (objectData[4] == 84) {
            MainCanvas.vect(n3 % (360 / n6) * n6, 16, 17);
            MainCanvas.vect(n4 % (360 / n6) * n6, 14, 15);
        } else if (objectData[19] == 1) {
            MainCanvas.vect(n3 % (360 / n6) * n6, 16, 17);
            MainCanvas.vect(n4 % (360 / n6) * n6, 14, 15);
        }
        int n8 = 0;
        int n9 = 16;
        int n10 = 16;
        if (this.zoneNumber == 4) {
            n9 = 8;
            n10 = 8;
        }
        for (n2 = 1; n2 < n5; ++n2) {
            if (this.zoneNumber != 4) continue;
            n9 = 8;
            n10 = 8;
            n8 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - n7, ploldpos[0], ploldpos[1] - n7, 12, n7, objectData[2] + n2 * (objectData[16] * (n9 * 2)) / 10000, objectData[3] + n2 * (objectData[17] * (n9 * 2)) / 10000, objectData[2] + n2 * (objectData[14] * (n9 * 2)) / 10000, objectData[3] + n2 * (objectData[15] * (n9 * 2)) / 10000, n9 - 2, n10 - 2);
            if (n8 < 0) continue;
            this.playdamageset();
        }
        n8 = this.zoneNumber == 4 ? this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - n7, ploldpos[0], ploldpos[1] - n7, 12, n7, objectData[2] + n2 * (objectData[16] * (n9 * 2)) / 10000, objectData[3] + n2 * (objectData[17] * (n9 * 2)) / 10000, objectData[2] + n2 * (objectData[14] * (n9 * 2)) / 10000, objectData[3] + n2 * (objectData[15] * (n9 * 2)) / 10000, n9 - 2, n10 - 2) : this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - n7, ploldpos[0], ploldpos[1] - n7, 12, n7, objectData[2] + n2 * (objectData[16] * n9) / 10000, objectData[3] + n2 * (objectData[17] * n9) / 10000, objectData[2] + n2 * (objectData[14] * n9) / 10000, objectData[3] + n2 * (objectData[15] * n9) / 10000, 6, 6);
        if (n8 >= 0) {
            this.playdamageset();
        }
    }

    private void dai2_sflag_move_ikeshita(int n) {
        int n2 = 16;
        int n3 = 16;
        boolean bl = false;
        boolean bl2 = false;
        int n4 = 0;
        boolean bl3 = false;
        int n5 = 0;
        boolean bl4 = false;
        boolean bl5 = false;
        MainCanvas.objectData[6] = objectData[2];
        MainCanvas.objectData[7] = objectData[3];
        if (objectData[4] == 248 && this.stageNumber == 2) {
            n2 = 64;
            n3 = 16;
            if (Math.abs(this.PlayerPosX() - objectData[8]) <= n2 && Math.abs(this.PlayerPosY() + 12 - (objectData[9] - n3 * 2 + 8)) <= n3 * 2) {
                MainCanvas.switchflag2[MainCanvas.objectData[4] - 240] = true;
            }
            if (Math.abs(this.PlayerPosX() - objectData[8]) <= n2 && Math.abs(this.PlayerPosY() + 12 - (objectData[9] + n3 * 3)) <= n3 * 2) {
                MainCanvas.switchflag2[MainCanvas.objectData[4] - 240] = false;
            }
            if (switchflag2[objectData[4] - 240] && objectData[3] > this.waterH2) {
                MainCanvas.objectData[18] = 1;
                MainCanvas.objectData[5] = n2 * 2;
                MainCanvas.objectData[2] = objectData[8] + n2 * 2 - objectData[5];
            } else {
                MainCanvas.objectData[18] = 1;
                MainCanvas.objectData[5] = 0;
                MainCanvas.objectData[2] = objectData[8] + n2 * 2 - objectData[5];
            }
            --n2;
        } else if (objectData[4] == 241 && switchflag2[128] && this.zoneNumber == 1 && this.stageNumber == 3) {
            n2 = 64;
            n3 = 16;
            if (objectData[19] == 0) {
                if (switchflag2[128] && objectData[18] == 0) {
                    MainCanvas.objectData[18] = 1;
                    MainCanvas.objectData[5] = n2 * 2;
                    MainCanvas.objectData[2] = objectData[8] + n2 * 2 - objectData[5];
                }
                MainCanvas.objectData[18] = 1;
                if (objectData[5] == 0) {
                    if (switchflag2[128]) {
                        MainCanvas.objectData[5] = 1;
                    } else {
                        MainCanvas.objectData[2] = objectData[8] + n2 * 2;
                    }
                } else {
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > n2 * 2) {
                        MainCanvas.objectData[5] = n2 * 2;
                    }
                    MainCanvas.objectData[2] = objectData[8] + n2 * 2 - objectData[5];
                }
            } else {
                if (switchflag2[128] && objectData[18] == 0) {
                    MainCanvas.objectData[18] = 1;
                    MainCanvas.objectData[5] = n2 * 2;
                    MainCanvas.objectData[2] = objectData[8] + objectData[5];
                }
                MainCanvas.objectData[18] = 1;
                if (objectData[5] == 0) {
                    if (switchflag2[128]) {
                        MainCanvas.objectData[5] = 1;
                    } else {
                        MainCanvas.objectData[2] = objectData[8];
                    }
                } else {
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > n2 * 2) {
                        MainCanvas.objectData[5] = n2 * 2;
                    }
                    MainCanvas.objectData[2] = objectData[8] + objectData[5];
                }
            }
            --n2;
        } else if (objectData[4] >= 240) {
            n2 = 64;
            n3 = 16;
            if (objectData[19] == 0) {
                if (switchflag2[objectData[4] - 240] && objectData[18] == 0) {
                    MainCanvas.objectData[18] = 1;
                    MainCanvas.objectData[5] = n2 * 2;
                    MainCanvas.objectData[2] = objectData[8] + n2 * 2 - objectData[5];
                }
                MainCanvas.objectData[18] = 1;
                if (objectData[5] == 0) {
                    if (switchflag2[objectData[4] - 240]) {
                        MainCanvas.objectData[5] = 1;
                    } else {
                        MainCanvas.objectData[2] = objectData[8] + n2 * 2;
                    }
                } else {
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > n2 * 2) {
                        MainCanvas.objectData[5] = n2 * 2;
                    }
                    MainCanvas.objectData[2] = objectData[8] + n2 * 2 - objectData[5];
                }
            } else {
                if (switchflag2[objectData[4] - 240] && objectData[18] == 0) {
                    MainCanvas.objectData[18] = 1;
                    MainCanvas.objectData[5] = n2 * 2;
                    MainCanvas.objectData[2] = objectData[8] + objectData[5];
                }
                MainCanvas.objectData[18] = 1;
                if (objectData[5] == 0) {
                    if (switchflag2[objectData[4] - 240]) {
                        MainCanvas.objectData[5] = 1;
                    } else {
                        MainCanvas.objectData[2] = objectData[8];
                    }
                } else {
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > n2 * 2) {
                        MainCanvas.objectData[5] = n2 * 2;
                    }
                    MainCanvas.objectData[2] = objectData[8] + objectData[5];
                }
            }
            --n2;
        } else if (objectData[4] == 229 && this.zoneNumber == 1 && this.stageNumber == 0) {
            n2 = 8;
            n3 = 32;
            if (objectData[5] == 0) {
                if (switchflag[objectData[4] - 96]) {
                    MainCanvas.objectData[5] = 1;
                    MainCanvas.objectData[18] = 1;
                } else {
                    MainCanvas.objectData[3] = objectData[9] + n3 * 2;
                }
            } else {
                if (objectData[18] != 0 && objectData[2] < this.PlayerPosX() - 12) {
                    MainCanvas.objectData[18] = 0;
                }
                if (objectData[18] == 0) {
                    objectData[5] = objectData[5] - 1;
                    if (objectData[5] < 0) {
                        MainCanvas.objectData[5] = 0;
                    }
                    MainCanvas.objectData[3] = objectData[9] + n3 * 2 - objectData[5];
                } else {
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > n3 * 2) {
                        MainCanvas.objectData[5] = n3 * 2;
                    }
                    MainCanvas.objectData[3] = objectData[9] + n3 * 2 - objectData[5];
                }
            }
            --n2;
        } else if (objectData[4] >= 224) {
            n2 = 8;
            n3 = 32;
            if (switchflag2[objectData[4] - 224] && objectData[18] == 0) {
                MainCanvas.objectData[18] = 1;
                MainCanvas.objectData[5] = n3 * 2;
                MainCanvas.objectData[3] = objectData[9] + n3 * 2 - objectData[5];
            }
            MainCanvas.objectData[18] = 1;
            if (objectData[5] == 0) {
                if (switchflag2[objectData[4] - 224]) {
                    MainCanvas.objectData[5] = 1;
                } else {
                    MainCanvas.objectData[3] = objectData[9] + n3 * 2;
                }
            } else {
                objectData[5] = objectData[5] + 1;
                if (objectData[5] > n3 * 2) {
                    MainCanvas.objectData[5] = n3 * 2;
                }
                MainCanvas.objectData[3] = objectData[9] + n3 * 2 - objectData[5];
            }
            --n2;
        } else if (objectData[4] == 19) {
            n2 = 32;
            n3 = 32;
            objectData[5] = objectData[5] + 1;
            n5 = this.cpuTimer % 360 > 90 && this.cpuTimer % 360 < 270 ? 33 : 32;
            MainCanvas.objectData[3] = objectData[19] == 0 ? objectData[9] + this.dSin(this.cpuTimer) * n5 / 100 - n5 : objectData[9] - this.dSin(this.cpuTimer) * n5 / 100 - n5;
            bl5 = true;
        } else if (objectData[4] >= 0 && objectData[4] <= 2) {
            n2 = 16;
            n3 = 16;
            n4 = objectData[2];
            if (objectData[4] != 0) {
                objectData[5] = objectData[5] + 1;
                n5 = 32 * objectData[4];
                MainCanvas.objectData[2] = objectData[19] == 0 ? objectData[8] + this.dSin(this.cpuTimer) * n5 / 100 - n5 : objectData[8] - this.dSin(this.cpuTimer) * n5 / 100 - n5;
            }
            n4 -= objectData[2];
            bl4 = true;
        } else if (objectData[4] <= 91 && objectData[4] >= 88) {
            n2 = 16;
            n3 = 16;
            n4 = objectData[2];
            n5 = 32 * (objectData[4] - 88 + 1) - 16;
            if (this.cpuTimer % 720 < 180) {
                if (objectData[19] == 0) {
                    MainCanvas.objectData[3] = objectData[9] - this.dSin(90 + this.cpuTimer % 720) * n5 / 100;
                    MainCanvas.objectData[2] = objectData[8] - 16 + 32 * (objectData[4] - 88 + 1);
                } else {
                    MainCanvas.objectData[3] = objectData[9] + this.dSin(90 + this.cpuTimer % 720) * n5 / 100;
                    MainCanvas.objectData[2] = objectData[8] + 16 - 32 * (objectData[4] - 88 + 1);
                }
            } else if (this.cpuTimer % 720 < 360) {
                if (objectData[19] == 0) {
                    MainCanvas.objectData[2] = objectData[8] - this.dSin(270 - (this.cpuTimer % 720 - 180)) * n5 / 100;
                    MainCanvas.objectData[3] = objectData[9] - 16 + 32 * (objectData[4] - 88 + 1);
                } else {
                    MainCanvas.objectData[2] = objectData[8] + this.dSin(270 - (this.cpuTimer % 720 - 180)) * n5 / 100;
                    MainCanvas.objectData[3] = objectData[9] + 16 - 32 * (objectData[4] - 88 + 1);
                }
                bl4 = true;
            } else if (this.cpuTimer % 720 < 540) {
                if (objectData[19] == 0) {
                    MainCanvas.objectData[3] = objectData[9] + this.dSin(90 + (this.cpuTimer % 720 - 360)) * n5 / 100;
                    MainCanvas.objectData[2] = objectData[8] + 16 - 32 * (objectData[4] - 88 + 1);
                } else {
                    MainCanvas.objectData[3] = objectData[9] - this.dSin(90 + (this.cpuTimer % 720 - 360)) * n5 / 100;
                    MainCanvas.objectData[2] = objectData[8] - 16 + 32 * (objectData[4] - 88 + 1);
                }
            } else if (this.cpuTimer % 720 < 720) {
                if (objectData[19] == 0) {
                    MainCanvas.objectData[2] = objectData[8] + this.dSin(270 - (this.cpuTimer % 720 - 540)) * n5 / 100;
                    MainCanvas.objectData[3] = objectData[9] + 16 - 32 * (objectData[4] - 88 + 1);
                } else {
                    MainCanvas.objectData[2] = objectData[8] - this.dSin(270 - (this.cpuTimer % 720 - 540)) * n5 / 100;
                    MainCanvas.objectData[3] = objectData[9] - 16 + 32 * (objectData[4] - 88 + 1);
                }
                bl4 = true;
            }
            n4 -= objectData[2];
        } else if (objectData[4] == 160) {
            n2 = 16;
            n3 = 32;
            if (switchflag2[0] && objectData[18] == 0) {
                MainCanvas.objectData[18] = 1;
                MainCanvas.objectData[3] = objectData[9];
            }
            MainCanvas.objectData[18] = 1;
            if (switchflag2[0]) {
                objectData[3] = objectData[3] - 1;
                if (objectData[3] < objectData[9]) {
                    MainCanvas.objectData[3] = objectData[9];
                }
            } else {
                MainCanvas.objectData[3] = this.stageNumber == 0 ? 688 : objectData[9] + 64;
            }
        } else if (objectData[4] == 55) {
            n2 = 32;
            n3 = 25;
            if (switchflag2[objectData[4] - 40] && objectData[18] == 0) {
                MainCanvas.objectData[18] = 1;
                MainCanvas.objectData[2] = 7992;
            }
            MainCanvas.objectData[18] = 1;
            if ((objectData[8] != 7992 || objectData[9] != 1353) && switchflag2[objectData[4] - 40]) {
                objectData[2] = objectData[2] + 1;
                if (objectData[2] > 7992) {
                    MainCanvas.objectData[2] = 7992;
                }
            }
        }
        int n6 = 12;
        if (!PlayerBall && !PlayerCrouch) {
            n6 = 16;
        }
        int n7 = -1;
        if ((objectData[4] != 55 || objectData[8] != 7992 || objectData[9] != 1353) && (n7 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - n6, ploldpos[0], ploldpos[1] - n6, 12, n6, objectData[2], objectData[3], objectData[6], objectData[7], n2, n3)) >= 0) {
            if (n7 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
                PlayerParam[0] = PlayerParam[0] - (n4 << 8);
            } else if (n7 == 1) {
                if (!PlayerSWater || objectData[4] != 227) {
                    MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                    MainCanvas.PlayerParam[10] = 0;
                    if (KeyPress[4]) {
                        this.playerPushSet();
                    }
                }
            } else if (n7 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n7 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n3 + n6 + n6 + 1 << 8;
                this.setHeadHit();
            } else if (n7 == 4) {
                if (bl4) {
                    if (objectData[2] > this.PlayerPosX()) {
                        if (!PlayerSWater || objectData[4] != 227) {
                            MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                            MainCanvas.PlayerParam[10] = 0;
                            if (KeyPress[4]) {
                                this.playerPushSet();
                            }
                        }
                    } else {
                        MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                        MainCanvas.PlayerParam[10] = 0;
                        if (KeyPress[3]) {
                            this.playerPushSet();
                        }
                    }
                }
                if (bl5) {
                    if (objectData[3] > this.PlayerPosY() - n6) {
                        MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                        this.setRaidOnSize(objectData[2], n2);
                        this.playerRaidOn(objectData[22]);
                        PlayerParam[0] = PlayerParam[0] - (n4 << 8);
                        n7 = 0;
                    } else {
                        MainCanvas.PlayerParam[1] = objectData[3] + n3 + n6 + n6 + 1 + 8 << 8;
                        this.setHeadHit();
                    }
                }
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n7 != 0) {
            raidOn = false;
        }
    }

    private void ring_sflag_ring_m10_10_move_ikeshita(int n) {
        this.ring_sflag_ring_18_00_move_ikeshita(n);
    }

    private void ring_sflag_ring_10_10_move_ikeshita(int n) {
        this.ring_sflag_ring_18_00_move_ikeshita(n);
    }

    private void ring_sflag_ring_20_20_move_ikeshita(int n) {
        this.ring_sflag_ring_18_00_move_ikeshita(n);
    }

    private void ring_sflag_ring_10_00_move_ikeshita(int n) {
        this.ring_sflag_ring_18_00_move_ikeshita(n);
    }

    private void ring_sflag_ring_20_00_move_ikeshita(int n) {
        this.ring_sflag_ring_18_00_move_ikeshita(n);
    }

    private void ring_sflag_ring_00_10_move_ikeshita(int n) {
        this.ring_sflag_ring_18_00_move_ikeshita(n);
    }

    private void ring_sflag_ring_00_20_move_ikeshita(int n) {
        this.ring_sflag_ring_18_00_move_ikeshita(n);
    }

    private void elev_nflag_80_move_ikeshita(int n) {
        this.elev_nflag_move_ikeshita(n);
    }

    private void elev_nflag_move_ikeshita(int n) {
        int n2 = 40;
        int n3 = 8;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = -1;
        MainCanvas.objectData[7] = objectData[3];
        MainCanvas.objectData[11] = objectData[2];
        if (objectData[4] == 1 || objectData[4] == 0) {
            if (Math.abs(this.PlayerPosX() - objectData[2]) > 320) {
                MainCanvas.objectData[2] = objectData[8];
                MainCanvas.objectData[3] = objectData[9];
                MainCanvas.objectData[5] = 0;
            }
        } else if (objectData[4] == 12 && Math.abs(this.PlayerPosX() - objectData[2]) > 320) {
            MainCanvas.objectData[2] = objectData[8];
            MainCanvas.objectData[3] = objectData[9];
            MainCanvas.objectData[5] = 0;
        }
        if (objectData[4] != 16) {
            if (objectData[5] != 0) {
                if (objectData[4] == 1) {
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > 128) {
                        MainCanvas.objectData[5] = 128;
                    }
                    MainCanvas.objectData[3] = objectData[9] - objectData[5] * 2;
                } else if (objectData[4] == 0) {
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > 64) {
                        MainCanvas.objectData[5] = 64;
                    }
                    MainCanvas.objectData[3] = objectData[9] - objectData[5] * 2;
                } else if (objectData[4] == 3) {
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > 64) {
                        MainCanvas.objectData[5] = 64;
                    }
                    MainCanvas.objectData[3] = objectData[9] + objectData[5] * 2;
                } else if (objectData[4] == 12) {
                    objectData[5] = objectData[5] + 1;
                    if (objectData[5] > 128) {
                        MainCanvas.objectData[5] = 128;
                    }
                    n6 = objectData[2];
                    MainCanvas.objectData[2] = objectData[8] + objectData[5] * 2;
                    MainCanvas.objectData[3] = objectData[9] - objectData[5];
                    n6 -= objectData[2];
                }
            } else {
                n5 = this.dSin(objectData[5]) * n8 / 100;
                MainCanvas.objectData[3] = objectData[9] + n5;
                n4 = this.dSin(objectData[5]) * n7 / 100;
                MainCanvas.objectData[2] = objectData[8] + n4;
            }
            n9 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[11], objectData[7], n2, n3);
            if (n9 >= 0 && n9 == 0) {
                if (n7 != 0) {
                    PlayerParam[0] = PlayerParam[0] - (this.dSin(objectData[5] - 1) * n7 - this.dSin(objectData[5]) * n7 << 8) / 100;
                }
                MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                PlayerParam[0] = PlayerParam[0] - (n6 << 8);
                if (objectData[5] == 0 && Math.abs(this.PlayerPosX() - objectData[2]) <= 48) {
                    MainCanvas.objectData[5] = 1;
                }
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
            }
        } else {
            int n10 = 0;
            int n11 = 0;
            objectData[5] = objectData[5] + 1;
            for (int i = 0; i < 3; ++i) {
                n10 = objectData[3] - (objectData[5] + 1 + i * 128) % 384;
                n11 = objectData[3] - (objectData[5] + i * 128) % 384;
                n9 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], n10, objectData[11], n11, n2, n3);
                if (n9 < 0 || n9 != 0) continue;
                MainCanvas.PlayerParam[1] = n10 - n3 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n9 != 0) {
            raidOn = false;
        }
    }

    private void mfire_nflag_move_ikeshita(int n) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        n2 = objectData[4] / 16;
        if (objectData[18] == 0) {
            MainCanvas.objectData[10] = this.cpuTimer;
            MainCanvas.objectData[18] = 1;
        }
        if ((n4 = this.cpuTimer - objectData[10]) % (n2 * 50) == 0 && objectData[2] - mapOxy[0] >= -16 && objectData[2] - mapOxy[0] <= 256 && objectData[3] - mapOxy[1] >= -16 && objectData[3] - mapOxy[1] <= 184) {
            if (objectData[4] == 48 || objectData[4] == 66 || objectData[4] == 65 || objectData[4] == 49 || objectData[4] == 80 || objectData[4] == 64 || objectData[4] == 81) {
                if (objectData[4] == 48) {
                    n3 = 96;
                }
                if (objectData[4] == 49) {
                    n3 = 128;
                }
                if (objectData[4] == 64) {
                    n3 = 96;
                }
                if (objectData[4] == 65) {
                    n3 = 128;
                }
                if (objectData[4] == 66) {
                    n3 = 196;
                }
                if (objectData[4] == 80) {
                    n3 = 72;
                }
                if (objectData[4] == 81) {
                    n3 = 136;
                }
                this.SetObj2(20, objectData[2], objectData[3], 0, 0, 0, n3);
            } else if (objectData[4] == 53 || objectData[4] == 37 || objectData[4] == 69) {
                this.SetObj2(16, objectData[2], objectData[3], 0, 200, 0, 0);
            } else if (objectData[4] == 55 || objectData[4] == 71 || objectData[4] == 23) {
                this.SetObj2(16, objectData[2], objectData[3], 200, 0, 0, 0);
            } else if (objectData[4] == 54) {
                this.SetObj2(16, objectData[2], objectData[3], -200, 0, 0, 0);
            }
        }
    }

    private void yoganc_nflag_move_ikeshita(int n) {
        int n2 = 0;
        if (this.stageNumber == 2) {
            n2 = 1;
        }
        if (objectData[4] == 16) {
            int n3;
            int[][] nArray = this.searchObject(10, 2);
            for (n3 = 0; n3 < nArray.length; ++n3) {
                if (Math.abs(objectData[2] + 32 - 64 * n2 - nArray[n3][2]) >= 2) continue;
                if (objectData[5] == 0) {
                    MainCanvas.objectData[5] = 1;
                    MainCanvas.objectData[10] = this.cpuTimer;
                }
                MainCanvas.objectData[7] = nArray[n3][20];
                break;
            }
            if (objectData[7] > 0) {
                for (n3 = 0; n3 < nArray.length; ++n3) {
                    if (nArray[n3][20] != objectData[7]) continue;
                    MainCanvas.objectData[6] = n3;
                    break;
                }
            }
            if (objectData[10] != 0) {
                MainCanvas.objectData[5] = this.cpuTimer - objectData[10];
            }
            if (objectData[5] > 0 && objectData[7] > 0) {
                if (objectData[5] / 4 > 44) {
                    MainCanvas.objectData[5] = 0;
                    MainCanvas.objectData[6] = 0;
                    MainCanvas.objectData[7] = 0;
                    MainCanvas.objectData[10] = 0;
                } else if (objectData[5] / 4 > 26) {
                    MainCanvas.objectData[3] = objectData[9] - (160 - (objectData[5] - 104) * 2);
                } else if (objectData[5] / 4 > 6) {
                    MainCanvas.objectData[3] = objectData[9] - (objectData[5] - 24) * 2;
                }
                objectData[5] = objectData[5] + 1;
            }
            if (objectData[4] == 16 && objectData[5] / 4 > 0 && objectData[2] - 20 - 32 <= this.PlayerPosX() && objectData[2] - 20 - 32 + 112 >= this.PlayerPosX() && objectData[3] <= this.PlayerPosY() && objectData[9] >= this.PlayerPosY()) {
                this.playdamageset();
            }
        }
    }

    private void ochi_nflag_move_ikeshita(int n) {
        int n2 = 32;
        int n3 = 72;
        boolean bl = false;
        int n4 = 0;
        boolean bl2 = false;
        int n5 = 0;
        if (objectData[6] == 0 && objectData[7] == 0) {
            MainCanvas.objectData[6] = objectData[2];
            MainCanvas.objectData[7] = objectData[3];
        }
        if (objectData[4] == 1) {
            MainCanvas.objectData[5] = this.cpuTimer;
            n5 = 16;
            n4 = this.dSin(objectData[5]) * n5 / 100 - n5;
            n4 *= 2;
            n4 += 2;
        } else if (objectData[4] == 2) {
            MainCanvas.objectData[5] = this.cpuTimer;
            n5 = -16;
            n4 = this.dSin(objectData[5]) * n5 / 100 + n5;
            n4 *= 2;
            n4 += 2;
        } else if (objectData[4] == 20) {
            n3 = 56;
            if (objectData[5] == 0) {
                if (switchflag[1]) {
                    MainCanvas.objectData[5] = 1;
                    MainCanvas.objectData[10] = this.cpuTimer;
                } else {
                    MainCanvas.objectData[3] = objectData[9] - 160;
                }
            } else {
                MainCanvas.objectData[5] = this.cpuTimer - (objectData[10] - 1);
                if (objectData[5] > 72) {
                    MainCanvas.objectData[5] = 72;
                }
                MainCanvas.objectData[3] = objectData[9] - 160 + objectData[5] * 2;
            }
            n4 = 16;
        } else if (objectData[4] == 4) {
            n3 = 56;
            if (switchflag[0] || objectData[5] != 0) {
                if (switchflag[0] && objectData[5] == 0) {
                    MainCanvas.objectData[10] = this.cpuTimer;
                }
                MainCanvas.objectData[5] = this.cpuTimer - (objectData[10] - 1);
                if (objectData[5] > 72) {
                    MainCanvas.objectData[5] = 72;
                }
                MainCanvas.objectData[3] = objectData[9] - 160 + objectData[5] * 2;
            } else {
                MainCanvas.objectData[3] = objectData[9] - 160;
            }
            n4 = 16;
        }
        int n6 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3] + n4, objectData[6], objectData[7], n2, n3);
        if (n6 >= 0) {
            if (n6 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] + n4 - n3 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
            } else if (n6 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n6 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n6 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n4 + n3 + 12 + 12 + 1 << 8;
                if (objectData[4] == 1 && (objectData[5] % 360 < 90 || objectData[5] % 360 > 270)) {
                    this.setHeadHit();
                } else if (objectData[4] == 2 && objectData[5] % 360 < 270 && objectData[5] % 360 > 90) {
                    this.setHeadHit();
                } else if (objectData[4] != 1 && objectData[4] != 2) {
                    this.setHeadHit();
                }
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n6 != 0) {
            raidOn = false;
        }
        MainCanvas.objectData[7] = objectData[3] + n4;
        MainCanvas.objectData[6] = objectData[2];
    }

    private void yari_sflag_move_ikeshita(int n) {
        int n2;
        int n3 = this.cpuTimer % 132;
        int n4 = 4;
        int n5 = 24;
        int n6 = 0;
        if (objectData[13] == 0 && objectData[12] == 0) {
            MainCanvas.objectData[13] = objectData[3];
            MainCanvas.objectData[12] = objectData[2];
        }
        MainCanvas.objectData[6] = objectData[12];
        MainCanvas.objectData[7] = objectData[13];
        if (n3 < 60) {
            MainCanvas.objectData[5] = 0;
            n5 = 20;
        } else if (n3 < 64) {
            MainCanvas.objectData[5] = 1;
            n5 = 12;
        } else if (n3 < 124) {
            MainCanvas.objectData[5] = 2;
            n5 = 4;
        } else {
            MainCanvas.objectData[5] = 3;
            n5 = 12;
        }
        if (objectData[4] == 0) {
            MainCanvas.objectData[12] = objectData[19] == 0 ? objectData[2] + (this.yari_sflag_ike_PosTable[objectData[5]] >> 1) - 8 : objectData[2] - (this.yari_sflag_ike_PosTable[objectData[5]] >> 1) + 8;
        } else {
            MainCanvas.objectData[13] = objectData[19] == 0 ? objectData[3] - (this.yari_sflag_ike_PosTable[objectData[5]] >> 1) + 8 : objectData[3] + (this.yari_sflag_ike_PosTable[objectData[5]] >> 1) - 8;
        }
        if (objectData[4] == 0) {
            n6 = n5;
            n5 = n4;
            n4 = n6;
        }
        int n7 = 12;
        if (!PlayerBall && !PlayerCrouch) {
            n7 = 20;
        }
        if ((n2 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[12], objectData[13], objectData[6], objectData[7], n4, n5)) >= 0) {
            this.playdamageset();
        } else if (Math.abs(objectData[12] - this.PlayerPosX()) < 12 + n4 && Math.abs(objectData[13] - (this.PlayerPosY() - n7)) < n7 + n5) {
            this.playdamageset();
        }
    }

    private void kazari_sflag_move_ikeshita(int n) {
        if (this.cpuTimer % 120 == 0) {
            if (objectData[19] == 1) {
                this.SetObj2(21, objectData[2] + 16, objectData[3] + 10, 260, 0, 0, 0);
            } else if (objectData[19] == 0) {
                this.SetObj2(21, objectData[2] - 16, objectData[3] + 10, -260, 0, 0, 0);
            }
        }
    }

    private void dai3_nflag_move_ikeshita(int n) {
        int[][] nArray;
        int n2 = 16;
        int n3 = 16;
        MainCanvas.objectData[7] = objectData[3];
        if (objectData[4] == 39) {
            if (objectData[3] < this.waterH2) {
                objectData[3] = objectData[3] + 8;
                if (this.blockColChk_Enemy(objectData[2], objectData[3] + n3)) {
                    objectData[3] = objectData[3] - (objectData[3] + n3) % 16;
                } else if (objectData[3] > this.waterH2) {
                    MainCanvas.objectData[3] = this.waterH2;
                }
            } else if (objectData[3] > this.waterH2) {
                objectData[3] = objectData[3] - 8;
                if (this.blockColChk_Enemy(objectData[2], objectData[3] - n3)) {
                    objectData[3] = objectData[3] + (objectData[3] - n3) % 16;
                } else if (objectData[3] < this.waterH2) {
                    MainCanvas.objectData[3] = this.waterH2;
                }
            }
        } else if (objectData[4] == 19) {
            n2 = 32;
            n3 = 12;
            MainCanvas.objectData[6] = this.cpuTimer;
            if (objectData[10] == 1) {
                if (objectData[11] % 4 == 0 && objectData[11] <= 16) {
                    objectData[3] = objectData[3] + 1;
                }
                objectData[11] = objectData[11] + 1;
                if (objectData[11] > 76) {
                    MainCanvas.objectData[11] = 0;
                    MainCanvas.objectData[10] = 2;
                }
            } else if (objectData[10] == 2) {
                objectData[3] = objectData[3] - 2;
                nArray = this.searchObject(9, -1);
                for (int i = 0; i < nArray.length; ++i) {
                    if (nArray[i][2] - 20 - (objectData[2] - 16) > 32 || nArray[i][2] - 20 - (objectData[2] - 16) < -40 || nArray[i][3] - 60 - (objectData[3] - 16) > 16 || nArray[i][3] - 60 - (objectData[3] - 16) < -40) continue;
                    MainCanvas.objectData[10] = 3;
                    break;
                }
            }
        } else if (objectData[4] == 1) {
            n2 = 16;
            n3 = 16;
            if (objectData[10] != 0) {
                objectData[10] = objectData[10] + 1;
                if (objectData[10] > 20) {
                    if (objectData[5] == 0) {
                        objectData[3] = objectData[3] + 2;
                        if (this.blockColChk_Enemy(objectData[2] - n2 + 1, objectData[3] + n3) || this.blockColChk_Enemy(objectData[2] + n2 - 1, objectData[3] + n3)) {
                            MainCanvas.objectData[5] = 1;
                        }
                    }
                } else {
                    MainCanvas.objectData[3] = objectData[9] + 2;
                }
            }
            if (this.zoneNumber == 1 && this.stageNumber == 3) {
                nArray = this.searchObject(15, 1);
                MainCanvas.switchflag[128] = false;
                for (int i = 0; i < nArray.length; ++i) {
                    if (nArray[i][2] - 8 - (objectData[2] - 16) > 32 || nArray[i][2] - 8 - (objectData[2] - 16) < -32 || nArray[i][3] - 8 - (objectData[3] - 16) > 32 || nArray[i][3] - 8 - (objectData[3] - 16) < -32) continue;
                    MainCanvas.switchflag[128] = true;
                    MainCanvas.switchflag2[128] = true;
                }
            }
        }
        int n4 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[2], objectData[7], n2, n3);
        if (n4 >= 0) {
            if (n4 == 0) {
                MainCanvas.PlayerParam[1] = objectData[3] - n3 << 8;
                this.setRaidOnSize(objectData[2], n2);
                this.playerRaidOn(objectData[22]);
                if ((objectData[4] == 19 || objectData[4] == 1) && objectData[10] == 0) {
                    MainCanvas.objectData[10] = 1;
                }
            } else if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[4]) {
                    this.playerPushSet();
                }
            } else if (n4 == 2) {
                MainCanvas.PlayerParam[0] = objectData[2] + n2 + 12 + 1 << 8;
                MainCanvas.PlayerParam[10] = 0;
                if (KeyPress[3]) {
                    this.playerPushSet();
                }
            } else if (n4 == 3) {
                MainCanvas.PlayerParam[1] = objectData[3] + n3 + 12 + 12 + 1 << 8;
                this.setHeadHit();
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    private void kassya_nflag_move_ikeshita(int n) {
        int n2 = -1;
        boolean bl = false;
        if (objectData[4] != 127) {
            int n3;
            int n4;
            int n5 = 0;
            int n6 = 0;
            int n7 = this.kassya_nflag_ike_objectPos[objectData[4] - 128].length >> 1;
            int[] nArray = new int[n7 + 1];
            nArray[0] = 0;
            if (this.stageNumber == 3) {
                return;
            }
            for (n4 = 0; n4 < this.kassya_nflag_ike_defY[this.stageNumber].length; ++n4) {
                if (this.kassya_nflag_ike_defY[this.stageNumber][n4] != objectData[9] || this.kassya_nflag_ike_defX[this.stageNumber][n4] != objectData[8]) continue;
                n6 = n4;
            }
            for (n4 = 0; n4 < n7; ++n4) {
                for (n3 = 0; n3 < 2; ++n3) {
                    this.beltc_nflag_ike_startPos[n3] = 0;
                    this.beltc_nflag_ike_endPos[n3] = 0;
                }
                this.beltc_nflag_ike_startPos[0] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][n4 << 1];
                this.beltc_nflag_ike_startPos[1] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][(n4 << 1) + 1];
                this.beltc_nflag_ike_endPos[0] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][(n4 + 1) % n7 << 1];
                this.beltc_nflag_ike_endPos[1] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][((n4 + 1) % n7 << 1) + 1];
                n5 = Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]) < Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1]) ? (n5 += Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1])) : (n5 += Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]));
                nArray[n4 + 1] = n5;
            }
            int n8 = n5 / 132;
            int n9 = 0;
            int n10 = 0;
            int n11 = 0;
            int n12 = 0;
            int n13 = 0;
            int n14 = 0;
            if (objectData[18] == 0) {
                for (n4 = 0; n4 < kassya_x[n6].length; ++n4) {
                    MainCanvas.kassya_x[n6][n4] = 0;
                    MainCanvas.kassya_y[n6][n4] = 0;
                }
            }
            MainCanvas.objectData[18] = 1;
            for (n4 = 0; n4 < n8; ++n4) {
                n9 = (n4 * 132 + this.cpuTimer) % n5;
                if (switchflag2[14] && this.zoneNumber == 1 && this.stageNumber == 2 && (n9 = n5 - n9) == n5) {
                    n9 = 0;
                }
                n10 = 0;
                n11 = 0;
                n12 = 0;
                n13 = 0;
                for (int i = 0; i < n7; ++i) {
                    if (n9 >= nArray[i + 1]) continue;
                    n14 = n9 - nArray[i + 1];
                    for (n3 = 0; n3 < 2; ++n3) {
                        this.beltc_nflag_ike_startPos[n3] = 0;
                        this.beltc_nflag_ike_endPos[n3] = 0;
                    }
                    this.beltc_nflag_ike_startPos[0] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][i << 1];
                    this.beltc_nflag_ike_startPos[1] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][(i << 1) + 1];
                    this.beltc_nflag_ike_endPos[0] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][(i + 1) % n7 << 1];
                    this.beltc_nflag_ike_endPos[1] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][((i + 1) % n7 << 1) + 1];
                    if (Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]) < Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1])) {
                        n10 = this.beltc_nflag_ike_endPos[0] + (this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]) * n14 / Math.abs(this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]);
                        n11 = this.beltc_nflag_ike_endPos[1] + n14 * ((this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]) / Math.abs(this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]));
                        break;
                    }
                    n10 = this.beltc_nflag_ike_endPos[0] + n14 * ((this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]) / Math.abs(this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]));
                    n11 = this.beltc_nflag_ike_endPos[1] + (this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]) * n14 / Math.abs(this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]);
                    break;
                }
                if (kassya_x[n6][n4] == 0 && kassya_y[n6][n4] == 0) {
                    MainCanvas.kassya_x[n6][n4] = n10;
                    MainCanvas.kassya_y[n6][n4] = n11;
                }
                n12 = kassya_x[n6][n4];
                n13 = kassya_y[n6][n4];
                MainCanvas.kassya_x[n6][n4] = n10;
                MainCanvas.kassya_y[n6][n4] = n11;
                int n15 = 16;
                int n16 = 8;
                if (bl || (n2 = this.ObjectColChk(this.PlayerPosX(), this.PlayerPosY() - 12, ploldpos[0], ploldpos[1] - 12, 12, 12, n10, n11, n12, n13, n15, n16)) < 0 || n2 != 0) continue;
                MainCanvas.PlayerParam[1] = n11 - n16 << 8;
                PlayerParam[0] = PlayerParam[0] - (n12 - n10 << 8);
                this.setRaidOnSize(n10, n15);
                this.playerRaidOn(objectData[22]);
                raidObjectNumSub = n4;
                bl = true;
            }
        }
        if (bl) {
            n2 = 0;
        }
        if (raidOn && raidObjectNum == objectData[20] && n2 != 0) {
            raidOn = false;
        }
    }

    private void shima2_nflag_move_ikeshita(int n) {
        this.shima_nflag_move_ikeshita(n);
    }

    private void bou_nflag_move_ikeshita(int n) {
        int n2 = 4;
        int n3 = 32;
        int n4 = this.ObjectColChk(this.PlayerPosX() - 35, this.PlayerPosY() - 12, ploldpos[0] - 35, ploldpos[1] - 12, 12, 12, objectData[2], objectData[3], objectData[2], objectData[3], n2, n3);
        if (objectData[10] >= 300) {
            n4 = -1;
        }
        if (n4 >= 0) {
            if (n4 == 1) {
                MainCanvas.PlayerParam[0] = objectData[2] - n2 - 12 + 35 << 8;
                PlayerBou = true;
                objectData[10] = objectData[10] + 1;
            }
            if (objectData[3] - this.PlayerPosY() > 4) {
                MainCanvas.PlayerParam[1] = objectData[3] - 4 << 8;
            } else if (objectData[3] - this.PlayerPosY() < -32) {
                MainCanvas.PlayerParam[1] = objectData[3] + 32 << 8;
            }
            if (KeyPress[0]) {
                PlayerParam[0] = PlayerParam[0] + 256;
                MainCanvas.ploldpos[0] = this.PlayerPosX();
            }
        }
        if (raidOn && raidObjectNum == objectData[20] && n4 != 0) {
            raidOn = false;
        }
    }

    private void ring_sflag_ring_18_00_draw_ikeshita(int n) {
        int n2 = TRANS_NONE;
        int n3 = this.animeTimer % 4 * 16;
        if (this.animeTimer % 4 == 3) {
            n2 = TRANS_MIRROR;
            n3 = 16;
        }
        if (objectData[5] == 0) {
            this.drawRegion(gg, this.m_imgObj[0], 0, n3, 16, 16, rotNumTable[n2], objectData[2] - mapView[0] - 8, objectData[3] - mapView[1] - 8, 20);
        } else {
            this.drawRegion(gg, this.m_imgObj[0], 16, (this.cpuTimer - objectData[10]) / 5 % 4 * 16, 16, 16, rotNumTable[0], objectData[2] - mapView[0] - 8, objectData[3] - mapView[1] - 8, 20);
        }
        if (objectData[11] == 1) {
            if (objectData[5] == 0) {
                this.drawRegion(gg, this.m_imgObj[0], 0, n3, 16, 16, rotNumTable[n2], objectData[2] - mapView[0] - 8, objectData[12] - mapView[1] - 8, 20);
            } else {
                this.drawRegion(gg, this.m_imgObj[0], 16, (this.cpuTimer - objectData[10]) / 5 % 4 * 16, 16, 16, rotNumTable[0], objectData[2] - mapView[0] - 8, objectData[12] - mapView[1] - 8, 20);
            }
        }
    }

    private void ring_sflag_ring_00_18_draw_ikeshita(int n) {
        this.ring_sflag_ring_18_00_draw_ikeshita(n);
    }

    private void buranko_nflag_draw_ikeshita(int n) {
        int n2 = 0;
        int n3 = this.dSin(this.animeTimer * 3) * 87;
        int n4 = objectData[4] + 1;
        if (objectData[4] == 5) {
            n3 = -n3;
        } else if (objectData[19] == 1) {
            n3 = -n3;
        }
        for (n2 = 1; n2 < n4; ++n2) {
            if (this.zoneNumber == 3) {
                this.drawRegion(gg, this.m_imgObj[3], 36, 48, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + n2 * (this.dSin(180 + n3 / 100) * 16) / 100, objectData[3] - mapView[1] + n2 * (this.dCos(180 + n3 / 100) * 16) / 100, 1 | 2);
                continue;
            }
            if (this.zoneNumber != 5) {
                this.drawRegion(gg, this.m_imgObj[3], 16, 32, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + n2 * (this.dSin(180 + n3 / 100) * 16) / 100, objectData[3] - mapView[1] + n2 * (this.dCos(180 + n3 / 100) * 16) / 100, 1 | 2);
                continue;
            }
            this.drawRegion(gg, this.m_imgObj[3], 0, 96, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + n2 * (this.dSin(180 + n3 / 100) * 16) / 100, objectData[3] - mapView[1] + n2 * (this.dCos(180 + n3 / 100) * 16) / 100, 1 | 2);
        }
        if (this.zoneNumber == 3) {
            this.drawRegion(gg, this.m_imgObj[3], 36, 64, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else if (this.zoneNumber != 5) {
            this.drawRegion(gg, this.m_imgObj[3], 16, 16, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else {
            this.drawRegion(gg, this.m_imgObj[3], 0, this.cpuTimer / 3 % 3 * 32, 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        }
        if (this.zoneNumber == 3) {
            n2 *= 16;
            this.drawRegion(gg, this.m_imgObj[3], 0, 0, 88, 48, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + this.dSin(180 + n3 / 100) * (n2 += 8) / 100, objectData[3] - mapView[1] + this.dCos(180 + n3 / 100) * n2 / 100, 1 | 2);
        } else if (this.zoneNumber != 5) {
            n2 *= 16;
            this.drawRegion(gg, this.m_imgObj[3], 0, 0, 48, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + this.dSin(180 + n3 / 100) * (n2 -= 8) / 100, objectData[3] - mapView[1] + this.dCos(180 + n3 / 100) * n2 / 100, 1 | 2);
        } else {
            n2 *= 16;
            this.drawRegion(gg, this.m_imgObj[60], 0, 0, 48, 48, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + this.dSin(180 + n3 / 100) * (n2 -= 24) / 100, objectData[3] - mapView[1] + this.dCos(180 + n3 / 100) * n2 / 100, 1 | 2);
        }
    }

    private void hashi_nflag_draw_ikeshita(int n) {
        int n2 = 0;
        for (int i = 0; i < 12; ++i) {
            n2 = objectData[10] - Math.abs(objectData[5] - i);
            if (n2 < 0) {
                n2 = 0;
            }
            if (i == 0 || i == 11) {
                n2 = 0;
            }
            this.drawRegion(gg, this.m_imgObj[5], 32, 0, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 96 + i * 16, objectData[3] - mapView[1] + n2, 1 | 2);
        }
    }

    private void thashi_nflag_draw_ikeshita(int n) {
        int n2 = 0;
        int n3 = 0;
        int[] nArray = new int[]{-4, 4};
        for (n2 = 0; n2 < 12; ++n2) {
            n3 = (this.animeTimer / 10 + (12 - n2)) % 7;
            this.drawRegion(gg, this.m_imgObj[4], 0, n3 * 24, 16, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 96 + n2 * 16, objectData[3] - mapView[1] + nArray[n3 / 4], 1 | 2);
        }
    }

    private void break_sflag_draw_ikeshita(int n) {
        int n2 = rotNumTable[TRANS_NONE];
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        if (objectData[4] != 0) {
            n2 = rotNumTable[TRANS_MIRROR];
            n6 = -1;
        }
        if (objectData[5] != 0) {
            n3 = this.cpuTimer / 2 - objectData[10];
        }
        for (int i = 0; i < 36; ++i) {
            n4 = n3 - i * 3;
            n4 = n4 < 0 ? 0 : (n4 *= n3 / 6);
            n5 = objectData[4] != 0 ? 96 - i / 6 * 16 - 16 : i / 6 * 16;
            this.drawRegion(gg, this.m_imgObj[6], i / 6 * 16, 96 - (i % 6 + 1) * 16, 16, 16, n2, objectData[2] - mapView[0] + n5 - 40, objectData[3] - mapView[1] + 96 - (i % 6 + 1) * 16 - 48 + n4, 1 | 2);
        }
    }

    private void yuka_nflag_draw_ikeshita(int n) {
        block6: {
            block5: {
                int n2 = 0;
                n2 = objectData[4] == 21 ? 2 : (objectData[4] == 1 ? 0 : 1);
                if (objectData[4] != 21) break block5;
                this.drawRegion(gg, this.m_imgObj[7], 16, 0, 128, 96, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] - 16, 1 | 2);
                if (objectData[16] < 60) break block6;
                int n3 = 0;
                for (int i = 0; i < 8; ++i) {
                    n3 = this.animeTimer - objectData[15];
                    if (i << 3 < n3) {
                        n3 = i << 3;
                    }
                    this.drawRegion(gg, this.m_imgObj[101], 0, (this.animeTimer + (i << 1)) % 4 << 5, 24, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + (n3 << 1) - 56, objectData[3] - mapView[1] - this.yuka_nflag_ike_yuka[n2][n3], 1 | 2);
                }
                break block6;
            }
            if (objectData[4] == 1) {
                this.drawRegion(gg, this.m_imgObj[7], 0, 96, 128, 80, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] - 16, 1 | 2);
            } else {
                for (int i = 0; i < 4; ++i) {
                    this.drawRegion(gg, this.m_imgObj[7], 0, 0, 16, 96, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 32 + (i << 4), objectData[3] - mapView[1] - 48, 20);
                }
            }
        }
    }

    private void turi_nflag_draw_ikeshita(int n) {
        for (int i = 0; i <= (objectData[3] - objectData[9]) / 16; ++i) {
            this.drawRegion(gg, this.m_imgObj[94], 0, 8, 32, 16, rotNumTable[TRANS_NONE], objectData[8] - mapView[0], objectData[9] - mapView[1] - 24 + i * 16 + (objectData[3] - objectData[9]) % 16, 1 | 2);
        }
        this.drawRegion(gg, this.m_imgObj[94], 0, 0, 32, 8, rotNumTable[TRANS_NONE], objectData[8] - mapView[0], objectData[9] - mapView[1] - 24, 1 | 2);
        if (objectData[4] == 128 || objectData[4] == 2) {
            this.drawRegion(gg, this.m_imgObj[8], 0, 24, 112, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] + 28, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[8], 0, 0, 112, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else if (objectData[4] == 35) {
            this.drawRegion(gg, this.m_imgObj[95], 0, 0, 32, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else if (objectData[4] == 17 || objectData[4] == 18) {
            this.drawRegion(gg, this.m_imgObj[8], 0, 24, 112, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] + 28, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[8], 0, 0, 48, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 48, objectData[3] - mapView[1] - 12, 20);
            this.drawRegion(gg, this.m_imgObj[8], 64, 0, 48, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] - 12, 20);
        }
        this.drawRegion(gg, this.m_imgObj[94], 0, 24, 32, 8, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] - 16, 1 | 2);
    }

    private void toge_nflag_draw_ikeshita(int n) {
        int n2 = TRANS_NONE;
        if (objectData[19] == 2) {
            n2 = TRANS_ROT180;
        }
        if (objectData[4] == 48) {
            for (int i = 0; i < 3; ++i) {
                this.drawRegion(gg, this.m_imgObj[9], 0, 0, 8, 32, rotNumTable[n2], objectData[2] - mapView[0] - 24 + i * 24, objectData[3] - mapView[1], 1 | 2);
            }
        } else if (objectData[4] == 64) {
            if (this.zoneNumber != 1 || this.stageNumber != 0 || objectData[4] != 64 || objectData[19] == 0) {
                for (int i = 0; i < 6; ++i) {
                    this.drawRegion(gg, this.m_imgObj[9], 16, 0, 8, 32, rotNumTable[n2], objectData[2] - mapView[0] - 60 + i * 24, objectData[3] - mapView[1], 1 | 2);
                }
            }
        } else if (objectData[4] == 18 || objectData[4] == 16) {
            n2 = objectData[19] == 0 ? TRANS_ROT270 : TRANS_ROT90;
            this.drawRegion(gg, this.m_imgObj[9], 0, 0, 40, 32, rotNumTable[n2], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else if (objectData[4] == 82) {
            if (objectData[19] == 0) {
                this.drawRegion(gg, this.m_imgObj[9], 16, 0, 8, 32, rotNumTable[TRANS_MIRROR_ROT270], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            } else {
                this.drawRegion(gg, this.m_imgObj[9], 16, 0, 8, 32, rotNumTable[TRANS_ROT90], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            }
        } else if (objectData[4] == 32) {
            this.drawRegion(gg, this.m_imgObj[9], 16, 0, 8, 32, rotNumTable[n2], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else {
            this.drawRegion(gg, this.m_imgObj[9], 0, 0, 40, 32, rotNumTable[n2], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        }
    }

    private void box_sflag_draw_ikeshita(int n) {
        if (objectData[4] == 129) {
            for (int i = 0; i < 4; ++i) {
                this.drawImage(gg, this.m_imgObj[54], objectData[2] - mapView[0] - 62 + 31 * i, objectData[3] - mapView[1] - 16, 20);
            }
        } else {
            this.drawImage(gg, this.m_imgObj[54], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            this.DrawMapRegion((objectData[2] - mapView[0] >> 4) - 1, (objectData[3] - mapView[1] >> 4) - 1, 4, 4);
        }
    }

    private void fblock_nflag_draw_ikeshita(int n) {
        this.drawImage(gg, this.m_imgObj[11], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        if (objectData[4] == 2 || objectData[4] == 10) {
            this.DrawMapRegion((objectData[2] - mapView[0] >> 4) - 1, (objectData[3] - mapView[1] >> 4) - 1, 4, 4);
        }
    }

    private void dainfla_draw_ikeshita(int n) {
        if (objectData[4] == 2 || objectData[4] == 1) {
            this.drawRegion(gg, this.m_imgObj[54], 0, 0, 31, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            if (objectData[4] == 2) {
                this.DrawMapRegion((objectData[2] - mapView[0] >> 4) - 1, (objectData[3] - mapView[1] >> 4) - 1, 4, 4);
            }
        } else if (objectData[4] == 65) {
            for (int i = 0; i < 3; ++i) {
                this.drawImage(gg, this.m_imgObj[54], objectData[2] - mapView[0] + (i << 5), objectData[3] - mapView[1], 1 | 2);
            }
        } else if (objectData[4] == 57) {
            for (int i = 1; i < 15; ++i) {
                this.drawRegion(gg, this.m_imgObj[12], 0, 24, 8, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 64 + (i << 3), objectData[3] - mapView[1] - 8, 20);
            }
            this.drawRegion(gg, this.m_imgObj[12], 0, 0, 8, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 64, objectData[3] - mapView[1] - 8, 20);
            this.drawRegion(gg, this.m_imgObj[12], 0, 0, 8, 24, rotNumTable[TRANS_MIRROR], objectData[2] - mapView[0] + 56, objectData[3] - mapView[1] - 8, 20);
        } else if (objectData[4] == 40) {
            for (int i = 0; i < 8; ++i) {
                this.drawRegion(gg, this.m_imgObj[12], 8, i % 2 * 24, 8, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 32 + (i << 3), objectData[3] - mapView[1] - 8, 20);
            }
        } else if ((objectData[4] == 7 || objectData[4] == 4) && objectData[5] != 0) {
            this.drawRegion(gg, this.m_imgObj[12], 0, 0, 32, 16, rotNumTable[TRANS_MIRROR], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        }
    }

    private void yogan2_sflag_draw_ikeshita(int n) {
        int n2;
        for (n2 = 0; n2 < 2; ++n2) {
            this.drawRegion(gg, this.m_imgObj[13], 0, (this.animeTimer + n2) % 3 << 5, 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + (n2 << 5) + 48, objectData[3] - mapView[1] + (n2 << 5) - 16, 1 | 2);
        }
        int n3 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            n3 = objectData[2] - mapView[0] + (n2 >> 1 << 5) + 16;
            for (int i = 0; i < n3 / 32 + 2; ++i) {
                this.drawRegion(gg, this.m_imgObj[99], 0, (this.animeTimer + n2) % 3 * 16, 32, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + (n2 >> 1 << 5) + 16 - (i << 5), objectData[3] - mapView[1] + (n2 << 4) - 24, 1 | 2);
            }
        }
    }

    private void myogan_nflag_draw_ikeshita(int n) {
        int n2;
        int n3;
        if (objectData[5] / 4 != 0 && objectData[3] - 32 < objectData[9]) {
            this.drawRegion(gg, this.m_imgObj[98], 0, 32 * (this.animeTimer % 2), 64, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 32, objectData[3] - mapView[1] - 32, 20);
        }
        if ((n3 = objectData[5] / 4) > 6) {
            n3 = 6;
        }
        for (n2 = 1; n2 < n3; ++n2) {
            if (objectData[3] - n2 * 32 - 32 + 32 < objectData[9]) {
                this.drawRegion(gg, this.m_imgObj[14], 0, 32 * (n2 % 2), 64, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 32, objectData[3] - mapView[1] - n2 * 32 - 32, 20);
                continue;
            }
            if (objectData[3] - n2 * 32 - 32 >= objectData[9]) continue;
            this.drawRegion(gg, this.m_imgObj[14], 0, 32 * (n2 % 2), 64, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 32, objectData[3] - mapView[1] - n2 * 32 - 32, 20);
        }
        if (objectData[5] / 4 != 0 && objectData[3] - n2 * 32 - 32 < objectData[9]) {
            this.drawRegion(gg, this.m_imgObj[98], 0, 64 + 32 * (this.animeTimer % 2), 64, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 32, objectData[3] - mapView[1] - n2 * 32 - 32, 20);
        }
        if (objectData[10] > 0 && this.myogan_nflag_ike_ani.length > objectData[10] / 3) {
            this.drawRegion(gg, this.m_imgObj[77], 0, 32 * this.myogan_nflag_ike_ani[objectData[10] / 3], 112, 32, rotNumTable[TRANS_NONE], objectData[8] - mapView[0], objectData[9] - mapView[1], 1 | 2);
        }
    }

    private void switch2_nflag_draw_ikeshita(int n) {
        if (switchflag[objectData[4]]) {
            this.drawRegion(gg, this.m_imgObj[15], 0, 16, 32, 8, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else {
            this.drawRegion(gg, this.m_imgObj[15], 0, 0, 32, 11, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] - 3, 1 | 2);
        }
        this.drawRegion(gg, this.m_imgObj[15], 0, 11, 32, 5, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] + 5, 1 | 2);
    }

    private void shima_nflag_draw_ikeshita(int n) {
        if (this.zoneNumber != 3) {
            if (objectData[4] != 16) {
                this.drawRegion(gg, this.m_imgObj[16], 0, 0, 64, 32, 0, objectData[2] - mapView[0], objectData[3] - mapView[1] + objectData[14], 1 | 2);
            } else {
                this.drawRegion(gg, this.m_imgObj[16], 0, 32, 64, 48, 0, objectData[2] - mapView[0], objectData[3] - mapView[1] + 8 + objectData[14], 1 | 2);
                for (int i = 5; i >= 0; --i) {
                    this.drawRegion(gg, this.m_imgObj[16], 0, 64, 64, 16, 0, objectData[2] - mapView[0], objectData[3] - mapView[1] + 8 + 48 - 16 + 16 * i + objectData[14], 1 | 2);
                }
            }
        } else {
            int n2 = this.animeTimer / 4 % 6;
            if (n2 > 3) {
                n2 = 6 - n2;
            }
            for (int i = 0; i < 4; ++i) {
                int n3;
                for (n3 = 0; n3 < 3; ++n3) {
                    this.drawRegion(gg, this.m_imgObj[73], 0, n3 * 8, 16, 8, rotNumTable[TRANS_NONE + 4 * (i % 2)], objectData[2] - mapView[0] - 40 + i * 16 + 8, objectData[3] - mapView[1] - 8 + n3 * 8 + objectData[14], 20);
                }
                this.drawRegion(gg, this.m_imgObj[73], 0, n3 * 8 + n2 * 8, 16, 8, rotNumTable[TRANS_NONE + 4 * (i % 2)], objectData[2] - mapView[0] - 40 + i * 16 + 8, objectData[3] - mapView[1] - 8 + n3 * 8 + objectData[14], 20);
            }
        }
    }

    private void dai2_nflag_draw_ikeshita(int n) {
        this.dai2_sflag_draw_ikeshita(n);
    }

    private void brkabe_sflag_draw_ikeshita(int n) {
        int n2;
        int n3 = 1;
        n3 = objectData[4] == 0 ? 0 : 1;
        if (objectData[10] != 1) {
            for (n2 = 0; n2 < 4; ++n2) {
                this.drawRegion(gg, this.m_imgObj[18], n3 * 16, 0, 16, 16, 0, objectData[2] - mapView[0] - 8 - 8, objectData[3] - mapView[1] - 16 - 16 + n2 * 16, 20);
            }
        }
        n3 = objectData[4] == 2 ? 2 : 1;
        if (objectData[11] != 1) {
            for (n2 = 0; n2 < 4; ++n2) {
                this.drawRegion(gg, this.m_imgObj[18], n3 * 16, 0, 16, 16, 0, objectData[2] - mapView[0] - 8 - 8 + 16, objectData[3] - mapView[1] - 16 - 16 + n2 * 16, 20);
            }
        }
    }

    private void pedal_nflag_draw_ikeshita(int n) {
        this.drawImage(gg, this.m_imgObj[PEDAL], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    private void break2_nflag_draw_ikeshita(int n) {
        int n2 = 27;
        int n3 = 0;
        if (objectData[5] < 129) {
            if (this.zoneNumber == 3) {
                n2 = STEP;
            }
            for (int i = 0; i < 8; ++i) {
                int n4 = this.break2_nflag_ike_brockTable[i];
                if (this.break2_nflag_ike_brockTable[i] % 4 >= 2) {
                    n4 -= 2;
                }
                if (objectData[15] != 0 && (n3 = this.cpuTimer - objectData[16] - this.break2_nflag_ike_brockTimeTable[i]) < 0) {
                    n3 = 0;
                }
                this.drawRegion(gg, this.m_imgObj[n2], n4 % 4 * 16, n4 / 4 * 16, 16, 16, 0, objectData[2] - mapView[0] + this.break2_nflag_ike_brockTable[i] % 4 * 16 - 16 - 8, objectData[3] - mapView[1] + this.break2_nflag_ike_brockTable[i] / 4 * 16 + n3 * (n3 / 5), 1 | 2);
            }
        }
    }

    private void step_nflag_draw_ikeshita(int n) {
        int n2;
        int n3 = 0;
        if (objectData[18] > 0) {
            n3 = 1;
        }
        if ((n2 = this.animeTimer / 4 % 6) > 3) {
            n2 = 6 - n2;
        }
        for (int i = 0; i < 8; ++i) {
            int n4;
            int n5 = objectData[5];
            n5 = n5 > 60 ? (n5 -= 60) : 0;
            int n6 = n5 / 4 * ((i + 2) / 2);
            if (objectData[19] == 0) {
                n6 = n5 / 4 * (4 - i / 2);
            }
            for (n4 = 0; n4 < 3; ++n4) {
                this.drawRegion(gg, this.m_imgObj[73], 0, n4 * 8, 16, 8, rotNumTable[TRANS_NONE + 4 * (i % 2)], objectData[2] - mapView[0] - 16 + i * 16, objectData[3] - mapView[1] - 16 + n4 * 8 + n6 + n3 * this.step_nflag_ike_gura[this.animeTimer % 2][i / 2 % 2], 20);
            }
            this.drawRegion(gg, this.m_imgObj[73], 0, n4 * 8 + n2 * 8, 16, 8, rotNumTable[TRANS_NONE + 4 * (i % 2)], objectData[2] - mapView[0] - 16 + i * 16, objectData[3] - mapView[1] - 16 + n4 * 8 + n6 + n3 * this.step_nflag_ike_gura[this.animeTimer % 2][i / 2 % 2], 20);
        }
    }

    private void fun_nflag_draw_ikeshita(int n) {
        int n2 = TRANS_NONE;
        int n3 = 0;
        if (objectData[19] != 0) {
            n2 = TRANS_MIRROR;
        }
        n3 = objectData[2] - this.PlayerPosX();
        this.drawRegion(gg, this.m_imgObj[22], 0, objectData[5] % 3 * 32, 32, 32, rotNumTable[n2], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    private void pata_nflag_draw_ikeshita(int n) {
        if (objectData[4] != 1 & objectData[4] != 2) {
            int n2 = 0;
            if (objectData[13] < 8) {
                switch (objectData[13] / 2) {
                    default: {
                        n2 = 0;
                        break;
                    }
                    case 1: {
                        n2 = 5;
                        break;
                    }
                    case 2: {
                        n2 = 3;
                        break;
                    }
                    case 3: {
                        n2 = 6;
                    }
                }
                if (objectData[13] % 2 == 0) {
                    this.drawRegion(gg, this.m_imgObj[BELTC], 0, 1, 32, 14, n2, objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
                } else {
                    this.drawRegion(gg, this.m_imgObj[BELTC], 0, 17, 32, 30, n2, objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
                }
            } else {
                this.drawRegion(gg, this.m_imgObj[BELTC], 0, 1, 32, 14, n2, objectData[2] - mapView[0] - 16, objectData[3] - mapView[1] - 7, 20);
            }
        } else {
            this.pata_draw(n);
        }
    }

    private void fire6_nflag_draw_ikeshita(int n) {
        int n2 = TRANS_NONE;
        int n3 = 0;
        if (objectData[19] == 1) {
            n2 = TRANS_MIRROR;
        } else if (objectData[19] == 2) {
            n2 = TRANS_ROT180;
        }
        if (objectData[19] == 0) {
            this.drawRegion(gg, this.m_imgObj[26], 24, 0, 8, 16, rotNumTable[n2], objectData[2] - mapView[0] + 1 - 3 + 3 - 2, objectData[3] - mapView[1] - 8 + 52 + 8 + 4 - 8, 1 | 2);
        } else if (objectData[19] == 1) {
            this.drawRegion(gg, this.m_imgObj[26], 24, 0, 8, 16, rotNumTable[n2], objectData[2] - mapView[0] + 1 - 3 + 3 - 2 + 2, objectData[3] - mapView[1] - 8 + 52 + 8 + 4 - 8, 1 | 2);
        }
        int n4 = 5;
        n4 = objectData[5] / 4;
        n4 = n4 % 30 < 6 ? (n4 %= 30) : (n4 % 30 > 20 && n4 % 30 <= 25 ? 5 - (n4 - 20) % 30 : (n4 % 30 >= 25 ? 0 : 5));
        for (int i = 0; i < n4; ++i) {
            n3 += this.fire6_nflag_ike_sizeTable2[4 - i] - this.fire6_nflag_ike_posTable[4 - i];
            if (objectData[19] != 2) {
                this.drawRegion(gg, this.m_imgObj[26], 0, this.fire6_nflag_ike_animeTable[4 - i], 24, this.fire6_nflag_ike_sizeTable[4 - i], rotNumTable[this.fire6_nflag_ike_rotTable[objectData[19]][this.animeTimer / 2 % 2]], objectData[2] - mapView[0] - 10 + 3 + 7, objectData[3] - mapView[1] - 8 + 52 - n3 + 5, 1 | 2);
                continue;
            }
            this.drawRegion(gg, this.m_imgObj[26], 0, this.fire6_nflag_ike_animeTable[4 - i], 24, this.fire6_nflag_ike_sizeTable[4 - i], rotNumTable[this.fire6_nflag_ike_rotTable[objectData[19]][this.animeTimer / 2 % 2]], objectData[2] - mapView[0] - 10 - 2 + 3 + 12, objectData[3] - mapView[1] - 8 - 52 + n3 + 18, 1 | 2);
        }
        if (objectData[19] == 2) {
            this.drawRegion(gg, this.m_imgObj[26], 24, 32, 8, 16, rotNumTable[n2], objectData[2] - mapView[0] + 4 + 3, objectData[3] - mapView[1] - 54 + 8 - 8 + 5, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[26], 24, 48, 8, 16, rotNumTable[n2], objectData[2] - mapView[0] - 8 + 4 + 3, objectData[3] - mapView[1] - 54 + 8 - 8 + 5, 1 | 2);
        }
    }

    private void bryuka_nflag_draw_ikeshita(int n) {
        this.drawRegion(gg, this.m_imgObj[27], 0, 0, 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    private void mawaru_nflag_draw_ikeshita(int n) {
        int n2 = 0;
        this.drawRegion(gg, this.m_imgObj[28], 0, 0, 94, 94, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 1, objectData[3] - mapView[1] - 1, 1 | 2);
        switch (objectData[15] / 2) {
            default: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 6;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            case 3: {
                n2 = 5;
            }
        }
        if (objectData[15] % 2 == 0) {
            this.drawRegion(gg, this.m_imgObj[28], 25, 95, 48, 40, n2, objectData[2] - mapView[0] + objectData[10] - 1, objectData[3] - mapView[1] + objectData[11] - 1, 20);
        } else {
            this.drawRegion(gg, this.m_imgObj[28], 24, 135, 47, 47, n2, objectData[2] - mapView[0] + objectData[10] - 1, objectData[3] - mapView[1] + objectData[11] - 1, 20);
        }
    }

    private void yukai_nflag_draw_ikeshita(int n) {
        for (int i = 1; i < 11; ++i) {
            this.drawRegion(gg, this.m_imgObj[29], 0, 48, 16, 48, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 96 + 16 * i, objectData[3] - mapView[1] - 24, 20);
        }
        this.drawRegion(gg, this.m_imgObj[29], 0, 0, 16, 48, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 96, objectData[3] - mapView[1] - 24, 20);
        this.drawRegion(gg, this.m_imgObj[29], 0, 0, 16, 48, rotNumTable[TRANS_MIRROR], objectData[2] - mapView[0] - 96 + 176, objectData[3] - mapView[1] - 24, 20);
    }

    private void door_nflag_draw_ikeshita(int n) {
        int n2 = TRANS_NONE;
        int n3 = 0;
        if (objectData[19] != 0) {
            n2 = TRANS_MIRROR;
            n3 = 8;
        }
        this.drawRegion(gg, this.m_imgObj[30], 0, objectData[15] % 4 * 64, 8, 32, rotNumTable[n2], objectData[2] - mapView[0] - 8 + n3, objectData[3] - mapView[1] - 32 - objectData[10] * 8, 20);
        this.drawRegion(gg, this.m_imgObj[30], 0, 32 + objectData[15] % 4 * 64, 8, 32, rotNumTable[n2], objectData[2] - mapView[0] - 8 + n3, objectData[3] - mapView[1] + objectData[10] * 8, 20);
        this.drawRegion(gg, this.m_imgObj[30], 8, objectData[5] % 4 * 64, 8, 32, rotNumTable[n2], objectData[2] - mapView[0] - n3, objectData[3] - mapView[1] - 32 - objectData[10] * 8, 20);
        this.drawRegion(gg, this.m_imgObj[30], 8, 32 + objectData[5] % 4 * 64, 8, 32, rotNumTable[n2], objectData[2] - mapView[0] - n3, objectData[3] - mapView[1] + objectData[10] * 8, 20);
    }

    private void yukae_nflag_draw_ikeshita(int n) {
        int n2 = 16;
        int n3 = 0;
        int n4 = 0;
        n4 = (objectData[5] - objectData[4] / 2 + 256) % 128;
        if (n4 < 128) {
            if (n4 < 16) {
                n2 = n4;
            } else if (n4 > 64 && n4 < 80) {
                n2 = 80 - n4;
            } else if (n4 >= 80) {
                n2 = -1;
            }
            if (n2 > 0) {
                n3 = 0;
                if (n2 <= 8 && n2 > 4) {
                    n3 = 1;
                } else if (n2 <= 4) {
                    n3 = 2;
                }
                this.drawRegion(gg, this.m_imgObj[31], 0, n3 * 32, 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 16, objectData[3] + 8 - mapView[1] - 16, 20);
            }
        }
    }

    private void dai4_nflag_draw_ikeshita(int n) {
        if (objectData[4] == 203) {
            this.drawRegion(gg, this.m_imgObj[32], 0, 0, 256, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] - 64 + 16, 1 | 2);
            for (int i = 0; i < 3; ++i) {
                for (int j = 2 - i; j >= 0; --j) {
                    if (j != 2 - i) {
                        this.drawRegion(gg, this.m_imgObj[32], 256, 0, 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + 64 * i - 128 + 16, objectData[3] - mapView[1] - 64 + 16 + 32 + j * 32, 1 | 2);
                        continue;
                    }
                    this.drawRegion(gg, this.m_imgObj[32], 288, 0, 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + 64 * i - 128 + 16, objectData[3] - mapView[1] - 64 + 16 + 32 + j * 32, 1 | 2);
                }
            }
        } else if (objectData[4] != 64) {
            if (objectData[4] >= 128) {
                this.drawRegion(gg, this.m_imgObj[32], 0, 64, 64, 24, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 64, objectData[3] - mapView[1] - 12, 20);
                this.drawRegion(gg, this.m_imgObj[32], 0, 64, 64, 24, rotNumTable[TRANS_MIRROR], objectData[2] - mapView[0], objectData[3] - mapView[1] - 12, 20);
            } else {
                this.drawRegion(gg, this.m_imgObj[32], 0, 0, 56, 64, rotNumTable[TRANS_NONE + 6], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            }
        }
    }

    private void ele_nflag_draw_ikeshita(int n) {
        int n2 = TRANS_NONE;
        int n3 = 1;
        if (objectData[19] == 2) {
            n2 = TRANS_ROT180;
            n3 = -1;
        }
        this.drawRegion(gg, this.m_imgObj[33], 0, 88 + this.animeTimer % 3 * 8, 16, 8, rotNumTable[n2], objectData[2] - mapView[0], objectData[3] - mapView[1] + 20 * n3, 1 | 2);
        this.drawRegion(gg, this.m_imgObj[33], 0, 0, 16, 16, rotNumTable[n2], objectData[2] - mapView[0], objectData[3] - mapView[1] + 8 * n3, 1 | 2);
        if (objectData[5] == 1 || objectData[5] == 2) {
            this.drawRegion(gg, this.m_imgObj[33], 0, 40, 16, 16, rotNumTable[n2], objectData[2] - mapView[0], objectData[3] - mapView[1] - 4 * n3 + 4 * n3, 1 | 2);
        } else {
            this.drawRegion(gg, this.m_imgObj[33], 0, 16 + this.animeTimer % 3 * 8, 16, 8, rotNumTable[n2], objectData[2] - mapView[0], objectData[3] - mapView[1] - 4 * n3, 1 | 2);
        }
        if (objectData[5] >= 2) {
            for (int i = 0; i <= 1; ++i) {
                if (this.ele_nflag_ike_anime[objectData[5] - 2][i] == 0) continue;
                this.drawRegion(gg, this.m_imgObj[33], 0, 72, 16, 16, rotNumTable[this.ele_nflag_ike_rotTable[objectData[5] - 2][0]], objectData[2] - mapView[0] + 16 + i * 32, objectData[3] - mapView[1] - 4 * n3, 1 | 2);
                this.drawRegion(gg, this.m_imgObj[33], 0, 56, 16, 16, rotNumTable[this.ele_nflag_ike_rotTable[objectData[5] - 2][0]], objectData[2] - mapView[0] + 32 + i * 32, objectData[3] - mapView[1] - 4 * n3, 1 | 2);
                this.drawRegion(gg, this.m_imgObj[33], 0, 72, 16, 16, rotNumTable[this.ele_nflag_ike_rotTable[objectData[5] - 2][1]], objectData[2] - mapView[0] - 16 - i * 32, objectData[3] - mapView[1] - 4 * n3, 1 | 2);
                this.drawRegion(gg, this.m_imgObj[33], 0, 56, 16, 16, rotNumTable[this.ele_nflag_ike_rotTable[objectData[5] - 2][1]], objectData[2] - mapView[0] - 32 - i * 32, objectData[3] - mapView[1] - 4 * n3, 1 | 2);
            }
        }
    }

    private void beltc_nflag_draw_ikeshita(int n) {
        int n2;
        int n3;
        int n4 = 0;
        boolean bl = false;
        int n5 = 0;
        int n6 = 0;
        int[] nArray = new int[this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2 + 1];
        nArray[0] = 0;
        for (n3 = 0; n3 < this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2; ++n3) {
            for (n2 = 0; n2 < 2; ++n2) {
                this.beltc_nflag_ike_startPos[n2] = 0;
                this.beltc_nflag_ike_endPos[n2] = 0;
            }
            this.beltc_nflag_ike_startPos[0] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][n3 * 2 + 0];
            this.beltc_nflag_ike_startPos[1] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][n3 * 2 + 1];
            this.beltc_nflag_ike_endPos[0] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][(n3 + 1) % (this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 0];
            this.beltc_nflag_ike_endPos[1] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][(n3 + 1) % (this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 1];
            n4 = Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]) < Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1]) ? (n4 += Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1])) : (n4 += Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]));
            nArray[n3 + 1] = n4;
        }
        int n7 = n4 / 69;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        block7: for (n3 = 0; n3 < n7; ++n3) {
            n8 = (n3 * 69 + this.cpuTimer) % n4;
            for (int i = 0; i < this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2; ++i) {
                if (n8 >= nArray[i + 1]) continue;
                n9 = 0;
                n10 = 0;
                n11 = n8 - nArray[i + 1];
                for (n2 = 0; n2 < 2; ++n2) {
                    this.beltc_nflag_ike_startPos[n2] = 0;
                    this.beltc_nflag_ike_endPos[n2] = 0;
                }
                this.beltc_nflag_ike_startPos[0] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][i * 2 + 0];
                this.beltc_nflag_ike_startPos[1] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][i * 2 + 1];
                this.beltc_nflag_ike_endPos[0] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][(i + 1) % (this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 0];
                this.beltc_nflag_ike_endPos[1] = this.beltc_nflag_ike_objectPos[objectData[4] - 128][(i + 1) % (this.beltc_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 1];
                if (Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]) < Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1])) {
                    n9 = this.beltc_nflag_ike_endPos[0] + (this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]) * n11 / Math.abs(this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]);
                    n10 = this.beltc_nflag_ike_endPos[1] + n11 * ((this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]) / Math.abs(this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]));
                } else {
                    n9 = this.beltc_nflag_ike_endPos[0] + n11 * ((this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]) / Math.abs(this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]));
                    n10 = this.beltc_nflag_ike_endPos[1] + (this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]) * n11 / Math.abs(this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]);
                }
                if (i == 0 || i == 3) {
                    this.drawRegion(gg, this.m_imgObj[BELTC], 0, 1, 32, 14, 0, n9 - mapView[0], n10 - mapView[1], 1 | 2);
                    continue block7;
                }
                n5 = 0;
                n5 = i == 1 ? Math.abs(this.beltc_nflag_ike_objectPos[objectData[4] - 128][3] - n10) : Math.abs(this.beltc_nflag_ike_objectPos[objectData[4] - 128][3] - this.beltc_nflag_ike_objectPos[objectData[4] - 128][5]) + Math.abs(this.beltc_nflag_ike_objectPos[objectData[4] - 128][2] - n9);
                n5 = (n5 / 4 + 1) % 8;
                switch (n5 / 2) {
                    default: {
                        n6 = 0;
                        break;
                    }
                    case 1: {
                        n6 = 5;
                        break;
                    }
                    case 2: {
                        n6 = 3;
                        break;
                    }
                    case 3: {
                        n6 = 6;
                    }
                }
                if (n5 % 2 == 0) {
                    this.drawRegion(gg, this.m_imgObj[BELTC], 0, 1, 32, 14, n6, n9 - mapView[0], n10 - mapView[1], 1 | 2);
                    continue block7;
                }
                this.drawRegion(gg, this.m_imgObj[BELTC], 0, 17, 32, 30, n6, n9 - mapView[0], n10 - mapView[1], 1 | 2);
                continue block7;
            }
        }
    }

    private void noko_nflag_draw_ikeshita(int n) {
        if (objectData[10] != 0) {
            this.drawRegion(gg, this.m_imgObj[35], 0, objectData[15] * 32, 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 32, objectData[3] - mapView[1] - 32, 20);
            this.drawRegion(gg, this.m_imgObj[35], 0, objectData[15] * 32, 32, 32, rotNumTable[TRANS_ROT90], objectData[2] - mapView[0], objectData[3] - mapView[1] - 32, 20);
            this.drawRegion(gg, this.m_imgObj[35], 0, objectData[15] * 32, 32, 32, rotNumTable[TRANS_ROT270], objectData[2] - mapView[0] - 32, objectData[3] - mapView[1], 20);
            this.drawRegion(gg, this.m_imgObj[35], 0, objectData[15] * 32, 32, 32, rotNumTable[TRANS_ROT180], objectData[2] - mapView[0], objectData[3] - mapView[1], 20);
            if (objectData[4] != 3) {
                this.drawRegion(gg, this.m_imgObj[35], 32, 0, 8, 64, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 4, objectData[3] - mapView[1] - 62, 20);
            }
        }
    }

    private void save_sflag_draw_ikeshita(int n) {
        if (objectData[5] == 0) {
            this.drawRegion(gg, this.m_imgObj[36], 0, 16, 16, 16, rotNumTable[TRANS_NONE + 4], objectData[2] - mapView[0], objectData[3] - mapView[1] - 32 - 4, 1 | 2);
        } else {
            this.drawRegion(gg, this.m_imgObj[36], 0, 0, 16, 16, rotNumTable[TRANS_NONE + 4], objectData[2] - mapView[0] - this.dSin(90 * objectData[5] / 4) * 8 / 100, objectData[3] - mapView[1] - 24 + this.dCos(90 * objectData[5] / 4) * 8 / 100 - 4, 1 | 2);
        }
        this.drawRegion(gg, this.m_imgObj[36], 0, 32, 16, 48, rotNumTable[TRANS_NONE + 4], objectData[2] - mapView[0], objectData[3] - mapView[1] - 4, 1 | 2);
    }

    private void kageb_nflag_draw_ikeshita(int n) {
        int n2 = 0;
        int n3 = 64;
        if (objectData[4] == 1) {
            n2 = 1;
        } else if (objectData[4] == 2) {
            n2 = 2;
        } else if (objectData[4] == 16) {
            n2 = 3;
        } else if (objectData[4] == 17) {
            n2 = 4;
        } else if (objectData[4] == 18) {
            n2 = 5;
        }
        this.drawRegion(gg, this.m_imgObj[37], n2 * 16, 0, 16, n3, 0, objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    private void item_nflag_draw_ikeshita(int n) {
        int n2;
        int n3 = 32;
        int n4 = 0;
        if (objectData[4] >= 7) {
            return;
        }
        if (this.item_nflag_ike_itemTable[objectData[4]] == 8) {
            n3 = 16;
            n4 = 8;
        }
        if (objectData[5] != 0 && objectData[7] < 60) {
            if (objectData[5] >= 7) {
                return;
            }
            n2 = objectData[7];
            if (n2 >= 48) {
                n2 = 48;
            }
            this.drawRegion(gg, this.m_imgObj[42], 8, this.item_nflag_ike_itemTable[objectData[5]] * 32 + 6, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] - n2, 1 | 2);
        }
        n2 = this.item_nflag_ike_itemTable[objectData[4]] != 8 ? (this.animeTimer % 2 == 0 ? this.item_nflag_ike_itemTable[objectData[4]] * 32 : (5 + this.animeTimer % 6 / 2) * 32) : this.item_nflag_ike_itemTable[objectData[4]] * 32;
        this.drawRegion(gg, this.m_imgObj[42], 0, n2, 32, n3, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1] + n4, 1 | 2);
    }

    private void item_sflag_draw_ikeshita(int n) {
        this.item_nflag_draw_ikeshita(n);
    }

    private void gole_nflag_draw_ikeshita(int n) {
        int n2 = 0;
        if (objectData[10] / 3 > 22) {
            n2 = 48;
        }
        if (objectData[5] != 2) {
            this.drawRegion(gg, this.m_imgObj[44], 0, n2 + objectData[10] / 3 % 4 * 48, 48, 48, 0, objectData[2] - mapView[0], objectData[3] - mapView[1] + 10, 1 | 2);
        } else {
            this.drawRegion(gg, this.m_imgObj[44], 0, 192, 48, 48, 0, objectData[2] - mapView[0], objectData[3] - mapView[1] + 10, 1 | 2);
        }
        if (objectData[5] == 1) {
            this.drawRegion(gg, this.m_imgObj[0], 16, objectData[10] / 4 % 4 * 16, 16, 16, this.gole_nflag_ike_rotTable[objectData[10] / 2 % 4], objectData[2] - mapView[0] + this.gole_nflag_ike_kiraTableX[objectData[10] / 4 % 10] - 24 - 8, objectData[3] - mapView[1] + 10 + this.gole_nflag_ike_kiraTableY[objectData[10] / 4 % 10] - 24 - 8, 20);
        }
    }

    private void bten_nflag_draw_ikeshita(int n) {
        int n2 = 0;
        n2 = objectData[4] == 0 || objectData[4] == 3 ? 0 : (objectData[4] == 1 ? 48 : 24);
        if (objectData[5] == 1) {
            this.drawRegion(gg, this.m_imgObj[45], 0, n2, 32, 24, 0, objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        }
    }

    private void bten_sflag_draw_ikeshita(int n) {
        this.bten_nflag_draw_ikeshita(n);
    }

    private void bigring_nflag_draw_ikeshita(int n) {
    }

    private void masin_nflag_draw_ikeshita(int n) {
        if (objectData[4] == 1) {
            if (objectData[5] < 2) {
                this.drawRegion(gg, this.m_imgObj[55], this.animeTimer % 2 * 24, 96, 24, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
                this.drawRegion(gg, this.m_imgObj[55], 0, 0, 64, 64, rotNumTable[TRANS_NONE], objectData[8] - mapView[0], objectData[9] - mapView[1] + 37, 1 | 2);
            } else {
                this.drawRegion(gg, this.m_imgObj[55], 0, 64, 64, 32, rotNumTable[TRANS_NONE], objectData[8] - mapView[0], objectData[9] - mapView[1] + 16 + 37, 1 | 2);
            }
        }
    }

    private void bobin_sflag_draw_ikeshita(int n) {
        this.drawRegion(gg, this.m_imgObj[56], 0, 32, 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    private void jyama_nflag_draw_ikeshita(int n) {
        this.drawImage(gg, this.m_imgObj[58], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    private void fetama_nflag_draw_ikeshita(int n) {
        this.drawRegion(gg, this.m_imgObj[60], 0, 0, 48, 48, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    private static void vect(int n, int n2, int n3) {
        if (n < 0) {
            n += 360;
        }
        if (360 >= n) {
            n -= n / 360 * 360;
        }
        if (n <= 90) {
            MainCanvas.objectData[n2] = sinData[90 - n];
            MainCanvas.objectData[n3] = sinData[n];
        }
        if (n > 90 && n <= 180) {
            MainCanvas.objectData[n2] = -sinData[90 - (180 - n)];
            MainCanvas.objectData[n3] = sinData[180 - n];
        }
        if (n > 180 && n <= 270) {
            MainCanvas.objectData[n2] = -sinData[90 - (n - 180)];
            MainCanvas.objectData[n3] = -sinData[n - 180];
        }
        if (n > 270 && n < 360) {
            MainCanvas.objectData[n2] = sinData[90 - (360 - n)];
            MainCanvas.objectData[n3] = -sinData[360 - n];
        }
    }

    private void tekyu_nflag_draw_ikeshita(int n) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        n2 = this.animeTimer - objectData[5];
        if (objectData[4] == 213 || objectData[4] == 181 || objectData[4] == 197 || objectData[4] == 101 || objectData[4] == 69 || objectData[4] == 53) {
            n3 = 5;
        } else if (objectData[4] == 212 || objectData[4] == 196 || objectData[4] == 84 || objectData[4] == 68 || objectData[4] == 52) {
            n3 = 4;
        } else if (objectData[4] == 38) {
            n3 = 6;
        } else if (objectData[4] == 195) {
            n3 = 3;
        }
        if (objectData[4] == 181 || objectData[4] == 101) {
            n4 = 12;
        } else if (objectData[4] == 196 || objectData[4] == 197 || objectData[4] == 84 || objectData[4] == 195) {
            n4 = 10;
        } else if (objectData[4] == 213 || objectData[4] == 212 || objectData[4] == 69 || objectData[4] == 68) {
            n4 = 8;
        } else if (objectData[4] == 52 || objectData[4] == 53) {
            n4 = 6;
        } else if (objectData[4] == 38) {
            n4 = 4;
        }
        if (objectData[4] != 69 && objectData[4] != 84 && objectData[4] != 101 && objectData[4] != 38 && objectData[4] != 68 && objectData[4] != 52 && objectData[4] != 53) {
            MainCanvas.vect((360 / n4 - n2 % (360 / n4)) * n4, 16, 17);
        } else {
            MainCanvas.vect(360 - (360 / n4 - n2 % (360 / n4)) * n4 % 360, 16, 17);
        }
        if (objectData[4] == 84) {
            MainCanvas.vect(n2 % (360 / n4) * n4, 16, 17);
        } else if (objectData[19] == 1) {
            MainCanvas.vect(n2 % (360 / n4) * n4, 16, 17);
        }
        if (this.zoneNumber != 4) {
            int n5;
            for (n5 = 1; n5 < n3; ++n5) {
                this.drawRegion(gg, this.m_imgObj[60], 0, 64, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + n5 * (objectData[16] * 16) / 10000, objectData[3] - mapView[1] + n5 * (objectData[17] * 16) / 10000, 1 | 2);
            }
            this.drawRegion(gg, this.m_imgObj[60], 0, 80, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            this.drawRegion(gg, this.m_imgObj[60], 16, 48, 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + n5 * (objectData[16] * 16) / 10000, objectData[3] - mapView[1] + n5 * (objectData[17] * 16) / 10000, 1 | 2);
        } else {
            int n6;
            for (n6 = 1; n6 < n3; ++n6) {
                this.drawRegion(gg, this.m_imgObj[60], 0, 48, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + n6 * (objectData[16] * 16) / 10000, objectData[3] - mapView[1] + n6 * (objectData[17] * 16) / 10000, 1 | 2);
            }
            this.drawRegion(gg, this.m_imgObj[60], 0, 48, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            this.drawRegion(gg, this.m_imgObj[60], 0, 48, 16, 16, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] + n6 * (objectData[16] * 16) / 10000, objectData[3] - mapView[1] + n6 * (objectData[17] * 16) / 10000, 1 | 2);
        }
    }

    private void dai2_sflag_draw_ikeshita(int n) {
        if (objectData[4] >= 240) {
            for (int i = 0; i < 4; ++i) {
                this.drawImage(gg, this.m_imgObj[108], objectData[2] - mapView[0] - 48 + i * 32, objectData[3] - mapView[1], 1 | 2);
            }
        } else if (objectData[4] >= 224) {
            this.drawImage(gg, this.m_imgObj[107], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else if (objectData[4] <= 2) {
            this.drawImage(gg, this.m_imgObj[DAI2], objectData[2] - mapView[0] - 16, objectData[3] - mapView[1] - 16, 20);
        } else if (objectData[4] == 19) {
            this.drawImage(gg, this.m_imgObj[DAI2], objectData[2] - mapView[0] - 32, objectData[3] - mapView[1] - 32, 20);
            this.drawImage(gg, this.m_imgObj[DAI2], objectData[2] - mapView[0] - 0, objectData[3] - mapView[1] - 32, 20);
            this.drawImage(gg, this.m_imgObj[DAI2], objectData[2] - mapView[0] - 32, objectData[3] - mapView[1] - 0, 20);
            this.drawImage(gg, this.m_imgObj[DAI2], objectData[2] - mapView[0] - 0, objectData[3] - mapView[1] - 0, 20);
        } else if (objectData[4] <= 91 && objectData[4] >= 88) {
            this.drawImage(gg, this.m_imgObj[STEP], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else if (objectData[4] == 160) {
            this.drawImage(gg, this.m_imgObj[DAI2], objectData[2] - mapView[0], objectData[3] - mapView[1] - 16, 1 | 2);
            this.drawImage(gg, this.m_imgObj[DAI2], objectData[2] - mapView[0], objectData[3] - mapView[1] + 16, 1 | 2);
        } else if (objectData[4] == 55 && (objectData[8] != 7992 || objectData[9] != 1353)) {
            this.drawImage(gg, this.m_imgObj[107], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        }
    }

    private void ring_sflag_ring_m10_10_draw_ikeshita(int n) {
        this.ring_sflag_ring_18_00_draw_ikeshita(n);
    }

    private void ring_sflag_ring_10_10_draw_ikeshita(int n) {
        this.ring_sflag_ring_18_00_draw_ikeshita(n);
    }

    private void ring_sflag_ring_20_20_draw_ikeshita(int n) {
        this.ring_sflag_ring_18_00_draw_ikeshita(n);
    }

    private void ring_sflag_ring_10_00_draw_ikeshita(int n) {
        this.ring_sflag_ring_18_00_draw_ikeshita(n);
    }

    private void ring_sflag_ring_20_00_draw_ikeshita(int n) {
        this.ring_sflag_ring_18_00_draw_ikeshita(n);
    }

    private void ring_sflag_ring_00_10_draw_ikeshita(int n) {
        this.ring_sflag_ring_18_00_draw_ikeshita(n);
    }

    private void ring_sflag_ring_00_20_draw_ikeshita(int n) {
        this.ring_sflag_ring_18_00_draw_ikeshita(n);
    }

    private void elev_nflag_80_draw_ikeshita(int n) {
        this.elev_nflag_draw_ikeshita(n);
    }

    private void elev_nflag_draw_ikeshita(int n) {
        int n2 = 40;
        int n3 = 16;
        int n4 = this.animeTimer / 4 % 6;
        if (n4 > 3) {
            n4 = 6 - n4;
        }
        if (objectData[4] != 16) {
            for (int i = 0; i < 5; ++i) {
                int n5;
                for (n5 = 0; n5 < 3; ++n5) {
                    this.drawRegion(gg, this.m_imgObj[73], 16, n5 * 8, 16, 8, rotNumTable[TRANS_NONE + 4 * (i % 2)], objectData[2] - mapView[0] - 40 + i * 16, objectData[3] - mapView[1] - 8 + n5 * 8, 20);
                }
                this.drawRegion(gg, this.m_imgObj[73], 16, n5 * 8 + n4 * 8, 16, 8, rotNumTable[TRANS_NONE + 4 * (i % 2)], objectData[2] - mapView[0] - 40 + i * 16, objectData[3] - mapView[1] - 8 + n5 * 8, 20);
            }
        } else {
            int n6 = 0;
            for (int i = 0; i < 3; ++i) {
                n6 = objectData[3] - (objectData[5] + 1 + i * 128) % 384;
                for (int j = 0; j < 5; ++j) {
                    int n7;
                    for (n7 = 0; n7 < 3; ++n7) {
                        this.drawRegion(gg, this.m_imgObj[73], 16, n7 * 8, 16, 8, rotNumTable[TRANS_NONE + 4 * (j % 2)], objectData[2] - mapView[0] - 40 + j * 16, n6 - mapView[1] - 8 + n7 * 8, 20);
                    }
                    this.drawRegion(gg, this.m_imgObj[73], 16, n7 * 8 + n4 * 8, 16, 8, rotNumTable[TRANS_NONE + 4 * (j % 2)], objectData[2] - mapView[0] - 40 + j * 16, n6 - mapView[1] - 8 + n7 * 8, 20);
                }
            }
        }
    }

    private void mfire_nflag_draw_ikeshita(int n) {
        int n2 = TRANS_NONE;
        int n3 = -25;
        if (this.zoneNumber == 3) {
            if (objectData[4] == 54) {
                n2 = TRANS_MIRROR;
                n3 = 25;
            }
            this.drawRegion(gg, this.m_imgObj[75], 0, 0, 16, 32, rotNumTable[n2], objectData[2] - mapView[0] + n3, objectData[3] - mapView[1], 1 | 2);
        }
    }

    private void yoganc_nflag_draw_ikeshita(int n) {
        int n2 = objectData[5] / 4;
        if (objectData[4] == 16 && n2 > 0) {
            int n3;
            n2 = n2 < 6 ? (n2 %= 2) : n2 % 2 + 2;
            for (n3 = 0; n3 < (objectData[9] - objectData[3]) / 32; ++n3) {
                this.drawRegion(gg, this.m_imgObj[14], 0, 32 * (n3 % 2), 64, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 20 + 24 - 32, objectData[3] - mapView[1] - 48 + n3 * 32 + 16, 20);
            }
            int n4 = (objectData[9] - objectData[3]) % 32;
            if (n4 > 0) {
                this.drawRegion(gg, this.m_imgObj[14], 0, 32 * (n3 % 2), 64, n4, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 20 + 24 - 32, objectData[3] - mapView[1] - 48 + n3 * 32 + 16, 20);
            }
            this.drawRegion(gg, this.m_imgObj[77], 0, this.yoganc_nflag_ike_posY[n2], 112, this.yoganc_nflag_ike_posY[n2 + 1] - this.yoganc_nflag_ike_posY[n2], rotNumTable[TRANS_NONE], objectData[8] - mapView[0] - 20 - 32, objectData[9] - mapView[1] - 48, 20);
            this.drawRegion(gg, this.m_imgObj[77], 0, this.yoganc_nflag_ike_posY[n2 + 2], 112, this.yoganc_nflag_ike_posY[n2 + 1 + 2] - this.yoganc_nflag_ike_posY[n2 + 2], rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 20 - 32, objectData[3] - mapView[1] - 48, 20);
        }
    }

    private void ochi_nflag_draw_ikeshita(int n) {
        int n2 = 32;
        int n3 = 72;
        boolean bl = false;
        int n4 = 0;
        int n5 = 0;
        boolean bl2 = false;
        int n6 = 0;
        if (objectData[4] == 1) {
            n6 = 16;
            n4 = this.dSin(objectData[5]) * n6 / 100 - n6;
            n6 = -9;
            n5 = this.dSin(objectData[5]) * n6 / 100 + n6;
            n4 *= 2;
            n5 *= 2;
            n4 += 2;
            n5 += 2;
        } else if (objectData[4] == 2) {
            n6 = -16;
            n4 = this.dSin(objectData[5]) * n6 / 100 + n6;
            n6 = 9;
            n5 = this.dSin(objectData[5]) * n6 / 100 - n6;
            n4 *= 2;
            n5 *= 2;
            n4 += 2;
            n5 += 2;
        }
        if (objectData[4] == 20 || objectData[4] == 4) {
            n6 = 28;
            n5 = this.dSin(this.cpuTimer) * n6 / 100 - 28;
            this.drawRegion(gg, this.m_imgObj[79], 0, 0, 32, 56, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 16, objectData[3] - mapView[1] - 28 + 16, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[79], 0, 0, 32, 56, rotNumTable[TRANS_MIRROR], objectData[2] - mapView[0] + 16, objectData[3] - mapView[1] - 28 + 16, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[79], 0, 0, 32, 56, rotNumTable[TRANS_MIRROR_ROT180], objectData[2] - mapView[0] - 16, objectData[3] - mapView[1] + 28 + 16, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[79], 0, 0, 32, 56, rotNumTable[TRANS_ROT180], objectData[2] - mapView[0] + 16, objectData[3] - mapView[1] + 28 + 16, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[79], 0, 72, 32, 32, rotNumTable[TRANS_ROT180], objectData[2] - mapView[0], objectData[3] - mapView[1] + n5 + 28 + 16, 1 | 2);
        } else {
            this.drawRegion(gg, this.m_imgObj[79], 0, 0, 32, 72, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 16, objectData[3] - mapView[1] + n4 - 36, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[79], 0, 0, 32, 72, rotNumTable[TRANS_MIRROR], objectData[2] - mapView[0] + 16, objectData[3] - mapView[1] + n4 - 36, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[79], 0, 0, 32, 72, rotNumTable[TRANS_MIRROR_ROT180], objectData[2] - mapView[0] - 16, objectData[3] - mapView[1] + n4 + 36, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[79], 0, 0, 32, 72, rotNumTable[TRANS_ROT180], objectData[2] - mapView[0] + 16, objectData[3] - mapView[1] + n4 + 36, 1 | 2);
            this.drawRegion(gg, this.m_imgObj[79], 0, 72, 32, 32, rotNumTable[TRANS_ROT180], objectData[2] - mapView[0], objectData[3] - mapView[1] + n5 - 8 - 6, 1 | 2);
        }
    }

    private void yari_sflag_draw_ikeshita(int n) {
        if (objectData[4] == 2) {
            if (objectData[19] == 0) {
                this.drawRegion(gg, this.m_imgObj[80], 0, this.yari_sflag_ike_drawPosTable[objectData[5] * 2 + 0] * 8, 8, this.yari_sflag_ike_drawPosTable[objectData[5] * 2 + 1] * 8, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - 4, objectData[3] - mapView[1] - this.yari_sflag_ike_drawPosTable[objectData[5] * 2 + 1] * 8 + 8, 20);
            } else {
                this.drawRegion(gg, this.m_imgObj[80], 0, this.yari_sflag_ike_drawPosTable[objectData[5] * 2 + 0] * 8, 8, this.yari_sflag_ike_drawPosTable[objectData[5] * 2 + 1] * 8, rotNumTable[TRANS_NONE + 6], objectData[2] - mapView[0] - 4, objectData[3] - mapView[1] - 8, 20);
            }
        } else if (objectData[4] == 0) {
            if (objectData[19] == 0) {
                this.drawRegion(gg, this.m_imgObj[80], 0, this.yari_sflag_ike_drawPosTable[objectData[5] * 2 + 0] * 8, 8, this.yari_sflag_ike_drawPosTable[objectData[5] * 2 + 1] * 8, rotNumTable[TRANS_NONE + 1], objectData[2] - mapView[0] - 8, objectData[3] - mapView[1] - 4, 20);
            } else {
                this.drawRegion(gg, this.m_imgObj[80], 0, this.yari_sflag_ike_drawPosTable[objectData[5] * 2 + 0] * 8, 8, this.yari_sflag_ike_drawPosTable[objectData[5] * 2 + 1] * 8, rotNumTable[TRANS_NONE + 3], objectData[2] - mapView[0] + 8 - this.yari_sflag_ike_drawPosTable[objectData[5] * 2 + 1] * 8, objectData[3] - mapView[1] - 4, 20);
            }
        }
    }

    private void kazari_sflag_draw_ikeshita(int n) {
        this.drawRegion(gg, this.m_imgObj[82], 0, 0, 32, 32, rotNumTable[TRANS_NONE + 4 - objectData[19] * 4], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
    }

    private void dai3_nflag_draw_ikeshita(int n) {
        if (objectData[4] == 1) {
            this.drawImage(gg, this.m_imgObj[108], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else if (objectData[4] == 39) {
            this.drawImage(gg, this.m_imgObj[105], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else if (objectData[4] == 19) {
            this.drawImage(gg, this.m_imgObj[106], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        } else {
            this.drawImage(gg, this.m_imgObj[83], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
        }
    }

    private void kassya_nflag_draw_ikeshita(int n) {
        if (objectData[4] != 127) {
            int n2;
            int n3;
            int n4 = 0;
            int[] nArray = new int[this.kassya_nflag_ike_objectPos[objectData[4] - 128].length / 2 + 1];
            nArray[0] = 0;
            for (n3 = 0; n3 < this.kassya_nflag_ike_objectPos[objectData[4] - 128].length / 2; ++n3) {
                for (n2 = 0; n2 < 2; ++n2) {
                    this.beltc_nflag_ike_startPos[n2] = 0;
                    this.beltc_nflag_ike_endPos[n2] = 0;
                }
                this.beltc_nflag_ike_startPos[0] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][n3 * 2 + 0];
                this.beltc_nflag_ike_startPos[1] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][n3 * 2 + 1];
                this.beltc_nflag_ike_endPos[0] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][(n3 + 1) % (this.kassya_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 0];
                this.beltc_nflag_ike_endPos[1] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][(n3 + 1) % (this.kassya_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 1];
                n4 = Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]) < Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1]) ? (n4 += Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1])) : (n4 += Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]));
                nArray[n3 + 1] = n4;
            }
            int n5 = n4 / 132;
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            int n9 = 0;
            block2: for (n3 = 0; n3 < n5; ++n3) {
                n6 = (n3 * 132 + this.cpuTimer) % n4;
                if (switchflag2[14] && this.zoneNumber == 1 && this.stageNumber == 2 && (n6 = n4 - n6) == n4) {
                    n6 = 0;
                }
                for (int i = 0; i < this.kassya_nflag_ike_objectPos[objectData[4] - 128].length / 2; ++i) {
                    if (n6 >= nArray[i + 1]) continue;
                    n7 = 0;
                    n8 = 0;
                    n9 = n6 - nArray[i + 1];
                    for (n2 = 0; n2 < 2; ++n2) {
                        this.beltc_nflag_ike_startPos[n2] = 0;
                        this.beltc_nflag_ike_endPos[n2] = 0;
                    }
                    this.beltc_nflag_ike_startPos[0] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][i * 2 + 0];
                    this.beltc_nflag_ike_startPos[1] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][i * 2 + 1];
                    this.beltc_nflag_ike_endPos[0] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][(i + 1) % (this.kassya_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 0];
                    this.beltc_nflag_ike_endPos[1] = this.kassya_nflag_ike_objectPos[objectData[4] - 128][(i + 1) % (this.kassya_nflag_ike_objectPos[objectData[4] - 128].length / 2) * 2 + 1];
                    if (Math.abs(this.beltc_nflag_ike_startPos[0] - this.beltc_nflag_ike_endPos[0]) < Math.abs(this.beltc_nflag_ike_startPos[1] - this.beltc_nflag_ike_endPos[1])) {
                        n7 = this.beltc_nflag_ike_endPos[0] + (this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]) * n9 / Math.abs(this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]);
                        n8 = this.beltc_nflag_ike_endPos[1] + n9 * ((this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]) / Math.abs(this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]));
                    } else {
                        n7 = this.beltc_nflag_ike_endPos[0] + n9 * ((this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]) / Math.abs(this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]));
                        n8 = this.beltc_nflag_ike_endPos[1] + (this.beltc_nflag_ike_endPos[1] - this.beltc_nflag_ike_startPos[1]) * n9 / Math.abs(this.beltc_nflag_ike_endPos[0] - this.beltc_nflag_ike_startPos[0]);
                    }
                    this.drawRegion(gg, this.m_imgObj[88], 0, 128, 32, 16, rotNumTable[TRANS_NONE], n7 - 16 - mapView[0], n8 - 8 - mapView[1], 20);
                    continue block2;
                }
            }
        }
        if (objectData[4] == 127) {
            if (switchflag2[14] && this.zoneNumber == 1 && this.stageNumber == 2) {
                this.drawRegion(gg, this.m_imgObj[88], 0, 96 - 32 * (this.animeTimer % 4), 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            } else {
                this.drawRegion(gg, this.m_imgObj[88], 0, 32 * (this.animeTimer % 4), 32, 32, rotNumTable[TRANS_NONE], objectData[2] - mapView[0], objectData[3] - mapView[1], 1 | 2);
            }
        }
    }

    private void shima2_nflag_draw_ikeshita(int n) {
        this.shima_nflag_draw_ikeshita(n);
    }

    private void bou_nflag_draw_ikeshita(int n) {
        int n2 = 0;
        if (objectData[10] >= 300) {
            n2 = 1;
        }
        this.drawRegion(gg, this.m_imgObj[91], 0, n2 * 64, 8 + n2 * 8, 64, rotNumTable[TRANS_NONE], objectData[2] - mapView[0] - n2 * 4, objectData[3] - mapView[1], 1 | 2);
    }

    /*
     * Opcode count of 23829 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     */
    static {
        record = null;
        f = Font.getDefaultFont();
        ObjectList = new int[256][25];
        KeyEvent = new boolean[5];
        KeyPress = new boolean[10];
        debugFlag = false;
        TIME_WAIT = 66;
        XNUM = 100;
        MODE_SELECT_DATAFOLDER = -6;
        MODE_DEBUGPRINT2 = -5;
        MODE_CONNINIT = -4;
        MODE_DEBUGPRINT = -3;
        MODE_CONNECT_FAILED = -2;
        MODE_INIT = -1;
        MODE_TITLE = 1;
        MODE_FIELD = 2;
        MODE_STAGESELECT = 3;
        MODE_STARTSTAGE = 4;
        MODE_CLEARSTAGE = 5;
        MODE_CONTINUE = 6;
        MODE_OPTION = 10;
        plmaxspd = 1536;
        pladdspd = 12;
        plretspd = 128;
        plstaspd = 128;
        gravity = 56;
        pljump = 1664;
        pljump_w = 896;
        plspeed = new int[2];
        ploldpos = new int[2];
        objectData = new int[25];
        OBJA_MAX = 30;
        objAwaData = new int[OBJA_MAX][20];
        objData = new int[OBJA_MAX][10];
        initDisplay = false;
        readStageObjectFlag = false;
        switchflag = new boolean[256];
        PlayerH = 32;
        SONIC_N = 1;
        SONIC_S = 2;
        LOGO = 3;
        LOGOLINE = 4;
        SYSTXT = 5;
        WINDOW_RING = 6;
        WINDOW_TIME = 7;
        WINDOW_ZANKI = 8;
        WINDOU_SUUJI = 9;
        SYSSCORE = 10;
        SYSTXT2 = 11;
        T_CUR1 = 12;
        T_CUR2 = 13;
        GAMEOVER = 14;
        TIMEOVER = 15;
        RING = 0;
        RING1 = 1;
        SJUMP = 2;
        BURANKO = 3;
        HASHI = 4;
        TOGE_HASHI = 5;
        BREAK = 6;
        YUKA = 7;
        TURI = 8;
        TOGE = 9;
        BOX = 10;
        FBLOCK = 11;
        DAI = 12;
        YOGAN = 14;
        SWITCH2 = 15;
        SHIMA = 16;
        DAI2 = 17;
        BRKABE = 18;
        PEDAL = 19;
        BREAK2 = 20;
        STEP = 21;
        FUN = 22;
        SISOO = 23;
        BELT = 24;
        PATA = 25;
        FIRE6 = 26;
        SWITCH2_ = 27;
        MAWARU = 28;
        YUKAI = 29;
        DOOR = 30;
        YUKAE = 31;
        DAI4 = 32;
        ELE = 33;
        BELTC = 34;
        NOKO = 35;
        objectDrawList = new int[200];
        objectDrawCount = 0;
        BossFirst = -1;
        Window = 1;
        mapOxy = new int[2];
        oldMapOxy = new int[2];
        mapView = new int[2];
        mapViewTarget = new int[2];
        mapOfs = new int[2];
        mapOfsTarget = new int[2];
        mapData = new byte[42496];
        mapFrontData = new byte[600];
        blockLinkTable = new byte[600];
        blockColTable = new byte[8192];
        zoneActTable = new byte[4][];
        worldMapData = new byte[][][][]{new byte[][][]{new byte[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 56, 1, 1, 1, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 56, 36, 0, 0, 33, 38, 17, 17, 31, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 45, 49, 36, 20, 56, 4, 35, 37, 45, 53, 38, 17, 31, 30, 32, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {45, 45, 3, 49, 36, 16, 2, 7, 4, 5, 43, 14, 30, 17, 37, 26, 38, 17, 8, 9, 10, 23, 30, 30, 32, 17, 31, 15, 0, 16, 5, 43, 22, 2, 3, 55, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30, 30, 32, 37, 7, 34, 12, 13, 21, 25, 17, 37, 45, 45, 45}}, new byte[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {14, 43, 22, 28, 5, 43, 22, 2, 55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 3, 0, 0, 0, 0, 33, 49, 36, 0, 0, 0}, {12, 13, 6, 12, 30, 13, 21, 17, 37, 50, 43, 11, 45, 53, 45, 7, 36, 18, 56, 36, 45, 38, 8, 5, 43, 11, 33, 38, 31, 15, 0, 0, 0}, {30, 30, 30, 30, 10, 23, 30, 30, 12, 12, 13, 25, 17, 8, 23, 30, 30, 30, 30, 30, 30, 30, 30, 24, 13, 8, 35, 17, 32, 37, 45, 45, 45}, {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0, 0, 0, 0, 0, 30, 30, 10, 23, 30, 17, 8, 29, 9, 30, 30, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0}}, new byte[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 45, 55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 56, 24, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 19, 56, 36, 20, 0, 19, 56, 39, 2, 26, 38, 31, 15, 0, 0, 20, 33, 45, 0, 0, 0, 19, 51, 51, 16, 36, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {45, 55, 22, 27, 35, 37, 26, 3, 6, 38, 31, 30, 30, 30, 32, 37, 53, 49, 27, 35, 17, 51, 51, 2, 26, 52, 52, 25, 37, 6, 49, 39, 0, 22, 2, 7, 2, 55, 45, 45, 45, 60, 60, 45, 45}, {30, 15, 21, 30, 30, 30, 30, 30, 30, 30, 32, 31, 30, 30, 30, 30, 30, 30, 12, 17, 9, 52, 52, 17, 30, 30, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30, 32, 17, 8, 9, 10, 29, 9, 30, 30, 30, 30, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}, new byte[][]{{40, 41, 42, 45, 49, 39, 2, 49, 34, 37, 3, 49, 2, 49, 39}}}, new byte[][][]{new byte[][]{{25, 42, 39, 41, 26, 23, 14, 33, 23, 0, 0, 0, 39, 29, 36, 13, 14, 14, 14, 14, 14, 14, 33, 23, 23, 23, 23, 0, 0, 0, 0, 0}, {14, 14, 14, 14, 14, 37, 12, 34, 14, 20, 0, 0, 14, 14, 14, 2, 10, 9, 10, 9, 21, 12, 34, 31, 1, 14, 14, 14, 0, 0, 0, 0}, {0, 0, 0, 0, 14, 14, 14, 14, 14, 12, 45, 14, 14, 14, 14, 11, 58, 14, 60, 25, 29, 29, 29, 30, 14, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 14, 14, 24, 9, 45, 14, 17, 15, 59, 14, 61, 17, 27, 14, 14, 14, 14, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 14, 14, 46, 12, 15, 17, 15, 14, 62, 15, 16, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 14, 14, 14, 25, 26, 12, 11, 11, 15, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 14, 14, 14, 14, 14, 14, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14}}, new byte[][]{{23, 11, 23, 13, 14, 14, 14, 14, 14, 14, 14, 14, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 2, 3, 11, 14, 17, 0, 11, 23, 14, 0, 0, 0, 0, 0, 0, 0}, {14, 14, 14, 11, 76, 5, 20, 46, 45, 14, 19, 14, 14, 0, 0, 0, 0, 0, 0}, {33, 23, 12, 46, 14, 14, 14, 45, 46, 14, 15, 14, 14, 63, 28, 0, 0, 0, 0}, {47, 21, 12, 23, 34, 9, 10, 46, 15, 14, 19, 14, 14, 64, 14, 1, 14, 14, 14}, {14, 14, 14, 14, 14, 14, 14, 14, 17, 11, 15, 11, 12, 65, 14, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 14, 21, 12, 11, 15, 14, 14, 14, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 14, 14, 14, 14, 14, 14, 0, 0, 0, 0, 0, 0}}, new byte[][]{{0, 0, 0, 0, 0, 14, 14, 33, 77, 14, 14, 14, 14, 14, 0, 0, 0, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 16, 14, 14, 0, 0, 0, 0, 0}, {14, 14, 14, 14, 14, 14, 32, 75, 14, 17, 11, 11, 11, 14, 14, 14, 0, 14, 17, 33, 0, 13, 14, 14, 14, 14, 23, 15, 14, 14, 49, 1, 14, 14, 14}, {11, 11, 13, 14, 12, 17, 75, 14, 17, 0, 46, 39, 66, 68, 39, 14, 0, 14, 70, 71, 14, 2, 3, 18, 14, 14, 16, 14, 14, 14, 49, 14, 0, 0, 0}, {14, 14, 2, 3, 18, 8, 20, 35, 36, 11, 23, 40, 67, 69, 34, 14, 14, 14, 20, 45, 23, 12, 23, 4, 18, 33, 15, 14, 0, 14, 49, 14, 0, 0, 0}, {0, 14, 14, 14, 4, 74, 12, 37, 14, 17, 22, 14, 36, 12, 34, 9, 10, 36, 12, 45, 45, 11, 22, 14, 72, 0, 14, 14, 14, 14, 49, 14, 0, 0, 0}, {0, 0, 0, 14, 14, 4, 18, 36, 23, 15, 14, 14, 14, 14, 14, 14, 14, 14, 14, 43, 43, 44, 14, 14, 16, 14, 14, 14, 23, 23, 15, 14, 0, 0, 0}, {0, 0, 0, 0, 14, 14, 4, 18, 43, 34, 38, 10, 9, 10, 9, 41, 29, 41, 42, 29, 41, 42, 0, 11, 37, 14, 35, 14, 16, 14, 14, 14, 0, 0, 0}, {0, 0, 0, 0, 0, 14, 14, 4, 18, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 46, 15, 14, 14, 15, 33, 15, 14, 14, 14, 0, 0, 0}}, new byte[][]{{14, 14, 14, 14, 14, 17, 39, 41, 26, 17, 6, 73, 14, 14, 48, 14, 14, 14, 14, 14, 14, 14, 14}, {14, 33, 11, 18, 14, 22, 14, 11, 6, 5, 11, 17, 23, 18, 16, 14, 14, 14, 14, 14, 14, 14, 14}, {14, 31, 14, 47, 27, 35, 14, 20, 11, 12, 15, 1, 35, 43, 15, 14, 14, 14, 14, 14, 14, 14, 14}, {14, 43, 11, 14, 46, 15, 14, 14, 1, 43, 18, 14, 37, 14, 19, 14, 11, 11, 14, 14, 14, 14, 14}, {14, 45, 0, 17, 44, 19, 14, 12, 35, 17, 43, 14, 43, 34, 25, 18, 37, 24, 38, 41, 42, 23, 14}, {33, 45, 0, 46, 12, 46, 14, 12, 38, 31, 23, 12, 11, 14, 14, 47, 30, 14, 14, 14, 14, 16, 14}, {14, 45, 12, 34, 14, 43, 11, 11, 11, 23, 44, 14, 47, 10, 9, 10, 9, 10, 9, 27, 12, 15, 14}, {14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14}}}, new byte[][][]{new byte[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 6, 11, 8, 9, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 52, 2, 2, 3, 5, 18, 18, 10, 8, 11, 7, 7, 7, 9, 12, 32, 12, 11, 8, 3, 8, 11, 16, 16, 16}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 15, 15, 14, 14, 73, 13, 24, 22, 32, 32, 18, 18, 18, 18, 18, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 39, 40, 32, 32, 31, 49, 25, 32, 18, 18, 18, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 17, 33, 20, 20, 20, 69, 22, 32, 0, 0, 0, 0, 0, 0, 0, 0}}, new byte[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 32, 32, 0, 0, 0, 0, 6, 8, 53, 16, 9, 0, 0, 32, 32, 32, 32, 32, 32, 0, 0, 0}, {52, 8, 53, 7, 9, 32, 32, 16, 9, 11, 2, 5, 18, 18, 32, 10, 8, 9, 32, 32, 32, 32, 32, 12, 53, 53, 53}, {18, 51, 32, 43, 73, 17, 21, 18, 46, 30, 29, 42, 42, 42, 42, 32, 18, 46, 40, 32, 32, 42, 25, 22, 32, 32, 0}, {0, 18, 26, 44, 20, 23, 22, 42, 42, 31, 49, 48, 47, 47, 45, 32, 68, 30, 22, 32, 25, 22, 32, 32, 32, 0, 0}, {0, 18, 41, 27, 27, 27, 30, 17, 38, 36, 36, 36, 23, 17, 22, 32, 44, 20, 20, 23, 22, 32, 32, 0, 0, 0, 0}}, new byte[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 8, 53, 16, 53, 9, 0, 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {32, 32, 32, 32, 70, 73, 8, 12, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 12, 11, 3, 71, 11, 72, 74, 53, 53}, {26, 33, 25, 17, 22, 32, 26, 22, 32, 32, 32, 32, 32, 32, 26, 69, 25, 25, 0, 22, 32, 32, 18, 32, 0, 0, 0, 0}, {21, 14, 15, 30, 36, 36, 22, 18, 32, 32, 32, 32, 32, 32, 39, 42, 0, 0, 0, 0, 42, 32, 32, 32, 0, 0, 0, 0}, {28, 34, 69, 22, 32, 37, 29, 14, 30, 37, 49, 31, 49, 49, 49, 22, 47, 47, 47, 22, 39, 42, 32, 0, 0, 0, 0, 0}, {32, 35, 30, 20, 20, 36, 13, 32, 26, 22, 32, 32, 32, 42, 42, 14, 14, 40, 43, 40, 29, 25, 32, 0, 0, 0, 0, 0}, {32, 32, 32, 32, 32, 32, 32, 32, 39, 30, 38, 20, 20, 23, 22, 32, 32, 33, 44, 44, 17, 22, 32, 0, 0, 0, 0, 0}}}, new byte[][][]{new byte[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 8, 10, 0, 0, 0, 0, 1, 24, 5, 1, 8, 0, 0, 0, 0, 51, 0, 0, 0, 0}, {0, 0, 0, 1, 10, 51, 51, 51, 51, 0, 0, 0, 15, 51, 6, 7, 24, 0, 0, 0, 0, 0, 0, 0, 6, 7, 42, 15, 24, 51, 0, 0, 0, 0}, {1, 1, 38, 51, 12, 5, 8, 63, 47, 5, 24, 3, 12, 4, 1, 51, 51, 1, 1, 14, 24, 4, 18, 5, 8, 51, 47, 3, 12, 18, 4, 18, 18, 18}, {51, 51, 29, 51, 0, 0, 6, 7, 46, 51, 51, 4, 3, 1, 1, 51, 51, 51, 35, 20, 51, 35, 20, 32, 6, 7, 46, 51, 32, 24, 0, 0, 0, 0}, {0, 51, 51, 51, 0, 0, 51, 51, 11, 51, 51, 0, 51, 51, 0, 1, 40, 3, 12, 19, 1, 24, 19, 31, 3, 12, 18, 24, 31, 18, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 51, 41, 8, 51, 0, 3, 12, 3, 12, 5, 40, 5, 0, 51, 0, 4, 0, 0, 0, 51, 51, 0, 4, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 51, 51, 6, 7, 1, 42, 40, 0, 3, 0, 12, 5, 24, 3, 0, 0, 0, 4, 3, 4, 5, 24, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}, new byte[][]{{0, 0, 20, 1, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 40, 5, 40, 5, 40, 5, 40, 4, 51, 51, 0, 51, 0, 1, 51, 0, 0, 0, 0}, {21, 21, 19, 51, 6, 7, 52, 0, 0, 0, 20, 1, 38, 3, 51, 20, 21, 5, 42, 42, 1, 24, 5, 15, 51, 0, 3, 0, 51, 51, 0, 0, 0, 0}, {0, 0, 0, 51, 51, 51, 41, 42, 40, 36, 37, 8, 21, 3, 12, 19, 0, 1, 40, 3, 0, 1, 4, 3, 12, 0, 51, 0, 5, 32, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 51, 51, 51, 0, 0, 0, 6, 7, 52, 51, 0, 0, 51, 0, 51, 0, 51, 0, 51, 0, 0, 15, 0, 15, 39, 24, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 51, 11, 0, 18, 40, 21, 5, 52, 51, 51, 20, 51, 0, 4, 29, 15, 29, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 51, 41, 24, 51, 51, 51, 51, 41, 8, 24, 19, 0, 4, 0, 15, 29, 29, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 51, 51, 51, 0, 0, 0, 51, 6, 7, 42, 24, 21, 0, 29, 29, 29, 0, 0, 0, 0, 0}}, new byte[][]{{0, 0, 0, 0, 0, 1, 24, 5, 9, 5, 1, 24, 5, 20, 52, 51, 51, 0, 0, 14, 8, 0, 51, 29, 14, 24, 5, 8, 0, 51, 0, 0, 0, 0, 0}, {21, 21, 25, 23, 0, 18, 0, 0, 6, 7, 52, 51, 47, 19, 41, 52, 51, 35, 18, 10, 6, 7, 52, 29, 14, 10, 51, 6, 7, 52, 0, 0, 0, 0, 0}, {0, 0, 51, 26, 22, 0, 4, 14, 32, 51, 41, 1, 46, 51, 51, 41, 42, 40, 21, 10, 51, 51, 41, 24, 10, 4, 5, 10, 51, 41, 20, 1, 1, 1, 1}, {0, 0, 51, 2, 27, 0, 0, 0, 31, 5, 20, 51, 41, 40, 13, 22, 0, 0, 3, 12, 5, 14, 24, 5, 20, 38, 3, 12, 35, 18, 19, 51, 0, 0, 0}, {0, 0, 0, 51, 28, 0, 20, 14, 24, 18, 19, 0, 0, 0, 2, 27, 0, 0, 51, 0, 14, 0, 3, 12, 19, 3, 12, 18, 24, 3, 12, 51, 0, 0, 0}, {0, 0, 0, 51, 30, 21, 19, 10, 51, 51, 14, 0, 0, 15, 63, 28, 20, 33, 51, 1, 10, 21, 51, 1, 0, 0, 0, 1, 20, 51, 0, 0, 0, 0, 0}, {0, 0, 0, 51, 0, 0, 4, 3, 12, 3, 10, 0, 0, 29, 10, 30, 19, 10, 0, 20, 14, 0, 5, 24, 3, 12, 4, 4, 19, 51, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 10, 0, 0, 29, 21, 4, 3, 12, 4, 19, 10, 0, 0, 51, 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}}, new byte[][][]{new byte[][]{{36, 47, 36, 66, 12, 36, 56, 71, 1, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 2, 36, 2, 71, 1, 36, 0}, {36, 36, 36, 66, 10, 73, 1, 71, 1, 1, 43, 36, 36, 4, 14, 19, 30, 55, 25, 28, 6, 36, 2, 4, 36, 36, 28, 73, 36, 36, 1, 36, 1, 71, 1, 36, 0}, {36, 36, 36, 8, 9, 45, 1, 14, 15, 17, 1, 36, 36, 1, 1, 20, 22, 23, 23, 29, 1, 36, 1, 1, 71, 74, 29, 43, 43, 2, 1, 2, 11, 2, 2, 2, 2}, {6, 2, 7, 1, 1, 1, 1, 1, 16, 18, 5, 33, 2, 15, 17, 1, 1, 1, 1, 1, 1, 2, 34, 37, 70, 57, 67, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 16, 18, 21, 27, 21, 24, 21, 27, 21, 35, 38, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}}, new byte[][]{{36, 36, 38, 36, 36, 40, 47, 47, 36, 36, 56, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 2, 44, 36, 36, 36, 36, 36, 36, 36, 1, 71, 1, 36, 49, 3, 50, 48, 36, 36, 36, 36, 36, 2, 6, 36, 36, 1, 36, 36, 36, 36, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 36, 36, 36, 28, 73, 36, 56, 1, 71, 1, 56, 40, 1, 52, 51, 50, 48, 36, 36, 28, 15, 17, 4, 13, 4, 36, 36, 25, 36, 36, 36, 36, 38, 36, 36, 1, 36, 0, 0, 0}, {1, 1, 1, 36, 2, 26, 29, 43, 43, 1, 1, 71, 1, 1, 1, 1, 1, 1, 52, 31, 36, 4, 29, 16, 18, 21, 41, 5, 33, 26, 23, 14, 6, 73, 32, 44, 36, 36, 1, 36, 36, 36, 0}, {1, 1, 1, 36, 46, 17, 1, 1, 1, 1, 1, 71, 1, 1, 1, 1, 1, 1, 1, 1, 56, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 40, 45, 1, 1, 36, 36, 58, 32, 33, 2, 2}, {1, 1, 1, 45, 16, 18, 21, 27, 21, 24, 5, 70, 57, 67, 57, 68, 68, 68, 68, 68, 69, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 53, 2, 54, 32, 33, 2, 2}}, new byte[][]{{56, 36, 36, 36, 36, 36, 36, 0, 0, 0, 0, 1, 36, 36, 25, 36, 2, 36, 36, 36, 36, 6, 6, 44, 36, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 49, 3, 50, 48, 36, 36, 36, 36, 36, 36, 1, 36, 36, 23, 4, 1, 36, 36, 36, 4, 71, 68, 1, 36, 1, 1, 1, 1, 36, 36, 36, 36, 36, 36, 71, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 52, 51, 50, 48, 36, 36, 2, 6, 1, 36, 6, 42, 21, 5, 33, 73, 36, 54, 71, 1, 1, 36, 1, 1, 1, 1, 36, 36, 56, 36, 36, 36, 71, 1, 1, 36, 36, 47, 47, 40, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 52, 31, 36, 2, 15, 17, 1, 4, 71, 1, 1, 1, 1, 43, 43, 1, 70, 40, 1, 36, 40, 1, 1, 1, 36, 36, 1, 43, 43, 43, 71, 1, 12, 36, 36, 36, 36, 11, 36, 36, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 36, 1, 16, 18, 27, 5, 71, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 36, 46, 17, 1, 1, 4, 13, 1, 1, 1, 1, 71, 1, 10, 36, 56, 36, 36, 36, 36, 36, 36, 36, 36, 0}, {0, 0, 0, 0, 0, 0, 1, 4, 1, 1, 1, 1, 1, 4, 57, 67, 11, 1, 1, 1, 1, 1, 1, 1, 36, 16, 18, 24, 39, 39, 41, 24, 21, 27, 5, 72, 8, 9, 36, 1, 36, 36, 36, 4, 36, 64, 4, 4, 4}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 45, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 36, 36, 36, 1, 36, 66, 1, 1, 0}}}, new byte[][][]{new byte[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 22, 1, 14, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 34, 2, 34, 0, 17, 16, 12, 3, 16, 16, 16, 0, 0, 16, 16, 16, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 34, 0, 0, 0, 0, 46, 45, 16, 0, 16, 44, 16, 13, 3, 16, 16, 5, 16, 16, 16, 30, 15, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 6, 0, 18, 19, 17, 16, 0, 0, 9, 45, 29, 0, 15, 0, 16, 12, 7, 8, 5, 16, 16, 4, 75, 47, 26, 42, 43, 24, 20, 18, 18}, {1, 9, 22, 22, 34, 2, 1, 7, 3, 16, 16, 0, 0, 15, 0, 0, 0, 22, 22, 1, 14, 16, 16, 4, 75, 31, 47, 33, 33, 26, 42, 43, 16, 16, 16, 0}, {16, 16, 17, 17, 16, 12, 3, 16, 5, 16, 16, 27, 24, 20, 18, 45, 0, 17, 17, 16, 12, 7, 9, 33, 33, 28, 16, 0, 46, 0, 32, 43, 16, 16, 16, 0}, {16, 16, 17, 17, 16, 16, 5, 16, 4, 75, 47, 28, 16, 16, 16, 17, 16, 16, 30, 33, 1, 21, 21, 9, 34, 18, 18, 45, 29, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 16, 4, 75, 7, 21, 21, 21, 9, 75, 47, 75, 47, 34, 25, 17, 16, 16, 16, 16, 16, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0}}, new byte[][]{{16, 16, 16, 16, 30, 30, 30, 44, 11, 1, 47, 33, 33, 33, 33, 33, 75, 50, 36, 50, 9, 10, 16, 30, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {11, 1, 36, 47, 34, 0, 0, 10, 11, 75, 31, 47, 34, 49, 48, 48, 15, 30, 16, 0, 33, 26, 42, 43, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {44, 16, 16, 16, 16, 16, 16, 13, 8, 16, 28, 30, 16, 9, 1, 23, 24, 20, 18, 19, 17, 26, 42, 43, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {11, 1, 36, 36, 47, 33, 33, 10, 16, 30, 15, 41, 75, 36, 50, 36, 47, 10, 16, 16, 16, 26, 42, 43, 16, 16, 16, 16, 16, 16, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0}, {16, 16, 16, 15, 15, 33, 33, 34, 18, 19, 40, 40, 16, 16, 16, 13, 7, 8, 11, 1, 47, 26, 42, 43, 15, 15, 15, 15, 30, 30, 30, 16, 16, 0, 0, 0, 0, 0, 0, 0}, {16, 15, 0, 41, 41, 17, 17, 16, 11, 75, 47, 75, 36, 36, 9, 10, 16, 16, 44, 16, 11, 34, 32, 43, 24, 20, 37, 38, 1, 9, 1, 68, 69, 70, 68, 68, 71, 72, 73, 74}, {16, 0, 0, 40, 22, 1, 9, 10, 11, 1, 9, 0, 0, 1, 36, 50, 36, 47, 10, 16, 44, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0}, {18, 19, 39, 40, 17, 16, 16, 44, 16, 16, 16, 0, 0, 16, 16, 15, 15, 15, 16, 16, 12, 14, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 0, 0, 0, 0, 0, 0, 0}}, new byte[][]{new byte[0]}, new byte[][]{{69, 70, 68, 68, 71, 72, 73, 74}}}};
        scddirtbl = new byte[512];
        pauseGame = false;
        PlayerParam = new int[26];
        PlayerSJump = false;
        PlayerDamage = false;
        PlayerWater = false;
        PlayerSWater = false;
        PlayerBou = false;
        PlayerJump = false;
        PlayerAir = false;
        PlayerBall = false;
        PlayerDie = false;
        PlayerCrouch = false;
        PlayerLookUp = false;
        PlayerNoCol = false;
        PlayerNoCtrl = false;
        TimerClear = false;
        TimerStop = false;
        sinData = new int[]{0, 175, 349, 523, 698, 872, 1045, 1219, 1392, 1564, 1736, 1908, 2079, 2249, 2419, 2588, 2756, 2924, 3090, 3256, 3420, 3584, 3746, 3907, 4067, 4226, 4384, 4540, 4695, 4848, 5000, 5150, 5299, 5446, 5592, 5736, 5878, 6018, 6156, 6293, 6428, 6560, 6691, 6820, 6946, 7071, 7193, 7313, 7431, 7547, 7660, 7771, 7880, 7986, 8090, 8191, 8290, 8387, 8480, 8572, 8660, 8746, 8829, 8910, 8988, 9063, 9135, 9205, 9272, 9336, 9397, 9455, 9510, 9563, 9613, 9659, 9703, 9744, 9781, 9816, 9848, 9877, 9903, 9925, 9945, 9962, 9976, 9986, 9994, 9998, 10000};
        scdtblwk = new byte[8192];
        MapEndCounter = 0;
        bossModeOn = false;
        bossBreakOn = false;
        objectSizeTbl = new short[][]{{48, 48}, {48, 48}, {48, 48}, {160, 160}, {192, 48}, {192, 48}, {480, 480}, {128, 96}, {48, 48}, {48, 48}, {32, 32}, {32, 32}, {240, 24}, {240, 48}, {64, 240}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {240, 48}, {64, 24}, {48, 48}, {48, 48}, {94, 94}, {192, 48}, {16, 32}, {48, 48}, {480, 480}, {48, 48}, {480, 480}, {240, 48}, {48, 48}, {48, 48}, {48, 48}, {40, 32}, {32, 32}, {32, 24}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {64, 64}, {48, 48}, {16, 16}, {24, 24}, {24, 40}, {48, 48}, {-1, -1}, {48, 48}, {48, 48}, {48, 48}, {40, 24}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {-1, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {32, 32}, {28, 20}, {48, 48}, {48, 48}, {16, 16}, {48, 48}, {48, 48}, {240, 240}, {32, 24}, {48, 48}, {48, 48}, {24, 40}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {24, 32}, {40, 32}, {48, 480}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {48, 48}, {128, 128}, {128, 128}, {32, 32}, {32, 32}, {128, 128}, {128, 128}, {40, 40}, {32, 40}};
        TRANS_NONE = 0;
        TRANS_ROT90 = 1;
        TRANS_ROT180 = 2;
        TRANS_ROT270 = 3;
        TRANS_MIRROR = 4;
        TRANS_MIRROR_ROT90 = 5;
        TRANS_MIRROR_ROT180 = 6;
        TRANS_MIRROR_ROT270 = 7;
        rotNumTable = new int[]{0, 5, 3, 6, 2, 7, 1, 4};
        encZoneNumber = new int[][]{{0, 0, 0}, {2, 2, 2}, {4, 4, 4}, {1, 1, 1}, {3, 3, 3}, {5, 5, 1}, {5, 0}};
        encStageNumber = new int[][]{{0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 3}, {3, 3}};
        cutDrawVLine = 0;
        softKeys = new String[33];
        raidObjectW = 0;
        raidObjectX = 0;
        m_aAddObjectData = new int[25];
        LANGUAGE_MAX = (byte)2;
        TITLE_MODE_LICENSE_SEGA = 0;
        TITLE_MODE_LICENSE_SONICTEAM = 1;
        TITLE_MODE_FIRST_SETUP = (byte)2;
        TITLE_MODE_TITLE = (byte)3;
        TITLE_MODE_TITLE_MENU = (byte)4;
        TITLE_MODE_TITLE_RANCKING = (byte)5;
        TITLE_MODE_TITLE_RANCKING_MENU = (byte)6;
        TITLE_MODE_TITLE_RANCKING_DEL = (byte)7;
        TITLE_MODE_TITLE_CONFIG_MENU = (byte)8;
        TITLE_MODE_TITLE_CONTINUE_MENU = (byte)9;
        TITLE_MODE_TITLE_HOWTO = (byte)10;
        m_bFirstSetUp = 0;
        m_nConfigValue = new byte[4];
        m_HowToPicIndexTbl = new byte[]{-1, 0, -1, -1, -1, -1, -1, 1, 1, 2, 3, 4, 5, 6, 7, -1, 8, 9, -1, -1, -1, 10, 11, 12, -1, -1};
        m_aConfigTextOffset = new byte[][]{{25, 26, 27}, {29, 30, 31, 32}, {29, 28}, {33, 34, 35, 36, 37}};
        cmd = new Command[2];
        m_nHiScore = new int[]{10000, 8000, 6000, 4000, 2000};
        m_nDifficulty = new int[]{0, 1, 2, 1, 0};
        m_OnKeyFlag = new boolean[10];
        m_imgImage = new Image[10];
        m_Font = Font.getFont((int)0, (int)0, (int)8);
        m_HowToPicTbl = new short[][]{{0, 0, 32, 32}, {32, 0, 32, 40}, {64, 0, 32, 32}, {96, 0, 32, 32}, {128, 0, 32, 32}, {160, 0, 32, 32}, {192, 0, 32, 32}, {224, 0, 32, 32}, {0, 40, 40, 32}, {40, 40, 40, 48}, {80, 40, 40, 48}, {120, 32, 32, 48}, {160, 32, 16, 64}, {176, 32, 40, 20}, {176, 52, 20, 20}, {196, 52, 20, 20}};
        m_strText = new String[51];
        m_strHowToText = new String[182];
        m_strMusicComposed = new String[]{"MUSIC COMPOSED", "BY MASATO", "NAKAMURA"};
        comboScore = 0;
        bPauseMusic = false;
        bGoalMusic = false;
        musicCount = 0;
        musicRetry = 0;
        musicRequest = -1;
        musicNum = -1;
        friendTbl = new byte[][]{{28, 31}, {32, 29}, {33, 29}, {28, 34}, {34, 30}, {31, 30}, {33, 33}, {31, 31}};
        sisootbl = new byte[]{36, 36, 38, 40, 42, 44, 42, 40, 38, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 2, 2, 2, 2};
        batAnimTbl = new byte[]{1, 2, 3, 2};
        RectTblKamere = new short[][]{{0, 0, 56, 40, 0}, {0, 40, 56, 40, 0}, {0, 80, 56, 40, 0}, {0, 120, 56, 24, 0}, {0, 144, 56, 16, 0}, {0, 160, 56, 16, 0}};
        RectTblHachi = new short[][]{{0, 0, 48, 32, 0}, {0, 32, 48, 24, 3}, {0, 56, 48, 32, 0}, {0, 88, 48, 24, 3}, {0, 112, 48, 40, 4}, {0, 152, 48, 32, 7}};
        RectTblMusi = new short[][]{{0, 0, 40, 32, 0}, {0, 32, 40, 32, 0}, {0, 64, 40, 32, 0}};
        RectTblImo = new short[][]{{0, 0, 16, 24, -4}, {0, 24, 16, 24, -4}, {0, 48, 16, 16, 0}};
        RectTblBrobo = new short[][]{{0, 0, 24, 40, 0}, {0, 40, 24, 40, 0}, {0, 80, 24, 40, 0}, {0, 120, 24, 40, 0}, {0, 160, 24, 40, 0}};
        RectTblButa = new short[][]{{0, 0, 24, 40, 0}, {0, 40, 24, 40, 0}, {0, 80, 24, 40, 0}, {0, 120, 24, 40, 0}};
        RectTblKani = new short[][]{{0, 0, 48, 32, 0}, {0, 32, 48, 32, 0}, {0, 64, 48, 32, 0}, {0, 96, 48, 32, 0}};
        RectTblAruma = new short[][]{{0, 0, 32, 32, 0}, {0, 32, 32, 32, 0}, {0, 64, 32, 40, -5}, {0, 104, 32, 48, -8}};
        RectTblYado = new short[][]{{0, 0, 40, 40, 0}, {0, 40, 40, 40, 0}, {0, 80, 40, 40, 0}};
        RectTblUni = new short[][]{{0, 0, 24, 24, 0}, {0, 24, 24, 24, 0}, {0, 48, 24, 24, 0}, {0, 72, 24, 24, 0}};
        RectTblBat = new short[][]{{0, 0, 40, 24, 0}, {0, 24, 40, 32, 0}, {0, 56, 40, 32, 0}, {0, 88, 40, 32, 0}};
        RectTblMogura = new short[][]{{0, 0, 32, 48, 0}, {0, 48, 32, 48, 0}, {0, 96, 32, 48, 0}, {0, 144, 32, 40, 0}, {0, 184, 32, 40, 0}};
        RectTblFish = new short[][]{{0, 0, 32, 32, 0}, {0, 32, 32, 32, 0}};
        RectTblFish2 = new short[][]{{0, 0, 48, 24, 0}, {0, 24, 48, 24, 0}, {0, 48, 48, 24, 0}, {0, 72, 48, 24, 0}};
        Boss6TamaAnmTbl = new byte[]{1, -1, -1};
        Boss6TamaAnmTbl2 = new byte[]{1, -1, 0, -1, 2, -1, 3, -1, 4, -1, 1, -1, 0, -1, 2, -1, 3, -1, 4, -1};
        Boss6TamaAnmTbl3 = new byte[]{0, 4, 1, 4};
        RectTblBakuhatu = new short[][]{{8, 0, 24, 16}, {0, 16, 40, 32}, {0, 48, 40, 32}, {0, 80, 40, 40}, {0, 120, 40, 40}};
        RectTblKemuri = new short[][]{{8, 0, 24, 16}, {0, 160, 40, 32}, {0, 192, 40, 32}, {0, 80, 40, 40}, {0, 120, 40, 40}};
        RectTblTama = new short[][]{{0, 0, 16, 16}, {0, 16, 16, 16}, {0, 32, 16, 16}, {0, 48, 16, 16}, {0, 64, 16, 16}, {0, 80, 16, 16}, {0, 96, 16, 16}, {0, 112, 16, 16}, {0, 128, 16, 16}, {0, 144, 16, 16}, {8, 160, 8, 8}, {8, 168, 8, 8}, {0, 160, 8, 8}, {0, 168, 8, 8}};
        RectTblDBlock = new short[][]{{0, 0}, {16, 0}, {0, 16}, {16, 16}};
        RectTblBoss6Tama = new short[][]{{88, 56, 16, 16}, {64, 56, 24, 24}, {88, 72, 16, 16}, {88, 88, 16, 16}, {64, 80, 24, 24}};
        BossDeadLimitY = new int[]{912, 224, 656, 672, 1360, -16};
        boss2MoveTbl = new int[][]{{769600, 147200}, {775200, 128000}, {779200, 121600}, {779200, 25600}, {801200, 19200}};
        boss4Sisoo = new short[3][4];
        boss5Block = new short[10][4];
        boss5AttackCount = 0;
        boss6Piston = new int[4];
        boss6PistonXY = new int[4][4];
        boss6TamaY = new int[4];
        boss6PistonPos = new short[][]{{-104, -159}, {24, -159}, {-40, 144}, {88, 144}};
        endingEggStep = 0;
        endingEggAnim = 0;
        endingEggCount = 0;
        RectTblEndingB = new short[][]{{0, 0, 64, 96}, {64, 0, 64, 96}, {128, 0, 64, 96}};
        wipeCol = 0;
        wipeLevel = 0;
        wipeDir = false;
        continueStep = 0;
        continueResult = 0;
        ContinueSonicTbl = new short[][]{{0, 120, 0}, {48, 120, 0}, {96, 120, 0}, {96, 120, 1}, {48, 120, 1}};
        ContinueSonicTbl2 = new short[][]{{48, 0}, {0, 32}, {48, 32}, {0, 32}};
        switchflag2 = new boolean[256];
        kassya_x = new int[6][20];
        kassya_y = new int[6][20];
    }
}
