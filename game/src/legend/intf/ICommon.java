package legend.intf;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;
import static legend.util.StringUtil.gl;
import static legend.util.StringUtil.gs;

import java.io.File;
import java.util.Map;

public interface ICommon extends Cloneable{
    int BLOCK_SIZE_FILE = 1 << 20;
    byte[] BOM_UTF16LE = new byte[]{(byte)0xff,(byte)0xfe};
    byte[] BOM_UTF16BE = new byte[]{(byte)0xfe,(byte)0xff};
    byte[] BOM_UTF8 = new byte[]{(byte)0xef,(byte)0xbb,(byte)0xbf};
    char[] CHAR_HEX = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    String SPRT_LINE = System.lineSeparator();
    String SPRT_FILE = File.separator;
    String SPRT_FILE_ZIP = "/";
    String SPRT_PKG = "\\.";
    String AUTHOR = "作者：李允";
    String VERSION = "版本：V5.5";
    String APP_INFO = AUTHOR + gl(1) + VERSION + gl(3);
    String CHARSET_GBK = "GBK";
    String CHARSET_BIG5 = "BIG5";
    String CHARSET_UTF8 = "UTF8";
    String CHARSET_UTF8_BOM = "UTF-8";
    String CHARSET_UTF16LE = "UTF-16LE";
    String CHARSET_UTF16BE = "UTF-16BE";
    String EXT_BAT = ".bat";
    String EXT_VBS = ".vbs";
    String EXT_EXE = ".exe";
    String EXT_LNK = ".lnk";
    String EXT_IL = ".il";
    String EXT_PAK = ".pak";
    String EXT_SPK = ".spk";
    String EXT_STC = ".stc";
    String EXT_XML = ".xml";
    String EXT_ZIP = ".zip";
    String EXT_CLASS = ".class";
    String S_EMPTY = "";
    String S_SPACE = " ";
    String S_SQM = "'";
    String S_DQM = "\"";
    String S_BQ = "`";
    String S_COMMA = "，";
    String S_SEMICOLON = "；";
    String S_PERIOD = "。";
    String S_BANG = "！";
    String S_ELLIPSIS = "…";
    String S_COLON = "：";
    String S_BRACKET_L = "（";
    String S_BRACKET_R = "）";
    String S_DQM_L = "“";
    String S_DQM_R = "”";
    String N_ARG = "参数";
    String N_LOG = "日志";
    String N_ERR_INFO = "错误信息：";
    String N_FILE = "文件";
    String N_FILE_NUL = "空文件";
    String N_FILE_MERGE = "文件整合";
    String N_PATH_NAME = "路径名";
    String N_DIR = "目录";
    String N_DIR_NUL = "空目录";
    String N_DIR_SUB = "子目录";
    String N_SPEC_ID = "给定ID";
    String N_SIZE = "大小";
    String N_TIME = "耗时";
    String N_CMD = "命令";
    String N_EXTN = "外部";
    String N_PRG = "程序";
    String N_PROC = "进程";
    String N_NUM = "个数";
    String N_OTW = "否则";
    String N_STM = "流";
    String N_A = "的";
    String N_AN = "个";
    String N_AND = "和";
    String N_OR = "或";
    String N_IN = "中";
    String N_FMT = "格式";
    String N_DEAL = "处理了";
    String V_DEAL = "处理";
    String V_INPUT = "输入";
    String V_OUTPUT = "输出";
    String V_IMPORT = "导入";
    String V_EXPORT = "导出";
    String V_NON_EXISTS = "不存在！";
    String V_ARD_EXISTS = "已存在！";
    String V_BY_NUL = "为空！";
    String V_FAIL = "失败！";
    String V_ERR = "错误！";
    String V_SAME = "相同";
    String V_EXISTS = "存在";
    String V_CAN_NOT = "不能";
    String V_READ = "读取";
    String V_WRITE = "写入";
    String V_SMLT = "模拟";
    String V_EXEC = "执行";
    String V_START = "开始";
    String V_DONE = "完毕";
    String V_FIND = "找到";
    String V_ANLS = "解析";
    String V_GNRT = "生成";
    String V_VST = "访问";
    String V_DEL = "删除";
    String V_CPY = "复制";
    String V_MOV = "移动";
    String V_BAK = "备份";
    String V_UPD = "更新";
    String V_REPL = "替换";
    String V_ADD = "新增";
    String V_REN = "重命名";
    String V_EXTR = "提取";
    String V_CRT = "创建";
    String V_CPRS = "压缩";
    String V_DCPRS = "解压缩";
    String V_TSC = "转码";
    String V_ENC = "编码";
    String V_DEC = "解码";
    String V_CLS = "关闭";
    String V_IS = "是";
    String V_TO = " 到 ";
    String V_BY = " 为 ";
    String OPT_INSIDE = "~";
    String OPT_DETAIL = "+";
    String OPT_SIMULATE = "*";
    String OPT_EXCLUDE_ROOT = "!";
    String OPT_CACHE = "@";
    String OPT_ASK = "?";
    String PLACE_HOLDER = "#";
    String PH_ARG0 = PLACE_HOLDER + "0" + PLACE_HOLDER;
    String PH_ARG1 = PLACE_HOLDER + "1" + PLACE_HOLDER;
    String PH_ARG2 = PLACE_HOLDER + "2" + PLACE_HOLDER;
    String PH_ARG3 = PLACE_HOLDER + "3" + PLACE_HOLDER;
    String PH_ARG4 = PLACE_HOLDER + "4" + PLACE_HOLDER;
    String PH_ARG5 = PLACE_HOLDER + "5" + PLACE_HOLDER;
    String PH_ARG6 = PLACE_HOLDER + "6" + PLACE_HOLDER;
    String PH_ARG7 = PLACE_HOLDER + "7" + PLACE_HOLDER;
    String PH_ARG8 = PLACE_HOLDER + "8" + PLACE_HOLDER;
    String PH_ARG9 = PLACE_HOLDER + "9" + PLACE_HOLDER;
    String MODE_NATIVE = "0";
    String MODE_REPL = "1";
    String MODE_ADD = "2";
    String MODE_ZIP = "0";
    String MODE_UNZIP = "1";
    String MODE_UNZIP_MD5 = "0";
    String MODE_UNZIP_DIR = "1";
    String MODE_UNZIP_MEG = "2";
    String FLAG_DEBUG = "#";
    String FLAG_MOD = "*";
    String FLAG_ADD = "+";
    String SPRT_CMD = "::";
    String SPRT_FIELD = "##";
    String SPRT_RULE = ";;";
    String SPRT_ATOM = "=>";
    String SPRT_ARG = ",,";
    String SPC_NUL = new String(new byte[]{0});
    String SPC_SQM = "SQM";
    String SPC_DQM = "DQM";
    String SPC_BQ = "BQ";
    String EXEC_KDIFF_F2 = "\"" + PH_ARG0 + "\" \"" + PH_ARG1 + "\" \"" + PH_ARG2 + "\" -o \"" + PH_ARG3 + "\"";
    String EXEC_KDIFF_F3 = "\"" + PH_ARG0 + "\" \"" + PH_ARG1 + "\" \"" + PH_ARG2 + "\" \"" + PH_ARG3 + "\" -o \"" + PH_ARG4 + "\"";
    String XML_NOTE_START = "<!--";
    String XML_NOTE_END = "-->";
    String XML_NOTE = XML_NOTE_START + PH_ARG0 + XML_NOTE_END;
    String XML_CDATA_START = "<![CDATA[";
    String XML_CDATA_END = "]]>";
    String XML_CDATA = XML_CDATA_START + PH_ARG0 + XML_CDATA_END;
    String REP_ADD = FLAG_DEBUG + "$1" + FLAG_DEBUG;
    String REG_WHOLE_MATCH = "\\A" + PH_ARG0 + "$";
    String REG_WHOLE_MATCH_IC = "(?i)" + REG_WHOLE_MATCH;
    String REG_UC_MC_GBK = "(?:[\\u3000\\ue766-\\ue76b\\ue76d-\\ue76f\\ue770-\\ue78c\\ue797-\\ue79f\\ue7a0-\\ue7bb\\ue7c9-\\ue7e1\\ue7fe-\\ue7ff\\ue800-\\ue814])";
    String REG_UC_MC_BIG5 = "(?:[\\u3000\\u007f\\ufffd])";
    String REG_UC_NON_CHS = "(?:[^\\u2e80-\\uffef])";
    String REG_SPC_SQM = "(?i)" + PLACE_HOLDER + SPC_SQM + "=?([1-9]?)" + PLACE_HOLDER;
    String REG_SPC_DQM = "(?i)" + PLACE_HOLDER + SPC_DQM + "=?([1-9]?)" + PLACE_HOLDER;
    String REG_SPC_BQ = "(?i)" + PLACE_HOLDER + SPC_BQ + "=?([1-9]?)" + PLACE_HOLDER;
    String REG_QUOTE_BQ = S_BQ + "(.*?)" + S_BQ;
    String REG_SPRT_CMD = SPRT_CMD + "+";
    String REG_SPRT_FIELD = SPRT_FIELD + "+";
    String REG_SPRT_RULE = SPRT_RULE + "+";
    String REG_SPRT_ARG = SPRT_ARG + "+";
    String REG_SPRT_COL = "[ \\t]+";
    String REG_SPRT_PATH = "[/" + gs(SPRT_FILE,2) + "]";
    String REG_PATH_NAME = "(.*" + REG_SPRT_PATH + ")(.*)";
    String REG_FILE_SUFFIX = "\\..*$";
    String REG_RPT_ARG = "\\A[" + OPT_SIMULATE + "]+(.*)";
    String REG_NON_PROG = ".*?[" + OPT_DETAIL + OPT_SIMULATE + OPT_INSIDE + "].*?";
    String REG_OPT = "(.*?)([" + OPT_INSIDE + OPT_DETAIL + OPT_SIMULATE + OPT_EXCLUDE_ROOT + OPT_CACHE + OPT_ASK + "]+)$";
    String REG_OPT_ASK = "\\A[" + OPT_ASK + "]+$";
    String REG_ASK_NO = "\\A[nN]$";
    String REG_SPRT_CODE = "(?m)\n+";
    String REG_NUM = "\\d+";
    String REG_NUM_NATURAL = "[1-9]\\d*";
    String REG_ANY = ".";
    String REG_XML_NOTE = XML_NOTE_START + "(.*)" + XML_NOTE_END;
    String REG_XML_CDATA = XML_CDATA_START + "(.*)" + XML_CDATA_END;
    String REG_RELEASE = FLAG_DEBUG + ".*?" + FLAG_DEBUG;
    String REG_DEBUG = FLAG_DEBUG + REG_NUM + FLAG_DEBUG;
    String REG_MOD = FLAG_DEBUG + "\\" + FLAG_MOD + REG_NUM + FLAG_DEBUG;
    String REG_ADD = FLAG_DEBUG + "\\" + FLAG_ADD + "(" + REG_NUM + ")" + FLAG_DEBUG + ".*";
    String ST_ARG_START = V_START + V_ANLS + N_CMD + N_ARG + S_DQM_L + PH_ARG0 + S_DQM_R + S_ELLIPSIS;
    String ST_ARG_DONE = N_CMD + N_ARG + S_DQM_L + PH_ARG0 + S_DQM_R + V_ANLS + V_DONE + S_PERIOD;
    String ST_CMD_START = V_START + V_EXEC + N_CMD + S_DQM_L + PH_ARG0 + S_DQM_R + S_ELLIPSIS;
    String ST_CMD_DONE = N_CMD + S_DQM_L + PH_ARG0 + S_DQM_R + V_EXEC + V_DONE + S_PERIOD;
    String ST_PRG_START = V_START + V_EXEC + N_PRG + S_ELLIPSIS;
    String ST_PRG_DONE = N_PRG + V_EXEC + V_DONE + S_PERIOD;
    String ST_PRG_EXTN_START = V_START + V_EXEC + N_EXTN + N_PRG + S_DQM_L + PH_ARG0 + S_DQM_R + S_ELLIPSIS;
    String ST_PRG_EXTN_DONE = N_EXTN + N_PRG + S_DQM_L + PH_ARG0 + S_DQM_R + V_EXEC + V_DONE + S_PERIOD;
    String ERR_INFO = N_ERR_INFO + PH_ARG0;
    String ERR_EXEC_CMD = V_EXEC + N_CMD + V_FAIL + ERR_INFO;
    String ERR_EXEC_CMD_SPEC = V_EXEC + N_CMD + S_DQM_L + PH_ARG0 + S_DQM_R + V_FAIL + N_ERR_INFO + PH_ARG1;
    String ERR_EXEC_FILE_MERGE = V_EXEC + N_FILE_MERGE + N_CMD + V_FAIL + ERR_INFO;
    String ERR_KDIFF3_EXEC_NON = "文件整合工具KDiff3的可执行文件路径名无效或不存在！";
    String ERR_7ZIP_EXEC_NON = "文件压缩解压工具7-Zip的可执行文件路径名无效或不存在！";
    String ERR_RES_CLS = V_CLS + N_STM + V_FAIL + ERR_INFO;
    String ERR_ARG_ANLS = V_ANLS + N_ARG + V_FAIL + ERR_INFO;
    String ERR_ARG_FMT = N_ARG + N_NUM + N_OR + N_ARG + N_FMT + V_ERR;
    String ERR_LOG_FLE_CRT = V_CRT + N_LOG + N_FILE + S_SPACE + PH_ARG0 + S_SPACE + V_FAIL + N_ERR_INFO + PH_ARG1;
    Map<String,String> SPH_MAP = ofEntries(entry(REG_SPC_SQM,S_SQM),entry(REG_SPC_DQM,S_DQM),entry(REG_SPC_BQ,S_BQ));
}
