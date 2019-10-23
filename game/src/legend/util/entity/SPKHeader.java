package legend.util.entity;

import static java.util.regex.Pattern.compile;
import static legend.util.StringUtil.gsph;
import static legend.util.StringUtil.hexToBytes;
import static legend.util.ValueUtil.nonEmpty;
import static legend.util.param.FileParam.convertParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import legend.intf.IValue;
import legend.util.entity.intf.IFileSPK;
import legend.util.param.SingleValue;

@XmlRootElement(name = "SPKHeader")
@XmlType(propOrder = {"headerSize","headerFlag","fileStartPosExpr","fileSizeExpr"})
public class SPKHeader extends BaseEntity<SPKHeader> implements IFileSPK{
    @XmlElement
    private String headerSize = S_EMPTY;
    @XmlElement
    private String headerFlag = S_EMPTY;
    @XmlElement
    private String fileStartPosExpr = S_EMPTY;
    @XmlElement
    private String fileSizeExpr = S_EMPTY;
    @XmlTransient
    protected MetaData headerSizeData = new MetaData();
    @XmlTransient
    protected MetaData headerFlagData = new MetaData();
    @XmlTransient
    protected MetaData fileStartPosData = new MetaData();
    @XmlTransient
    protected MetaData fileSizeData = new MetaData();
    @XmlTransient
    protected static final Pattern sizePattern;
    @XmlTransient
    protected static final Pattern sizeExprPattern;
    @XmlTransient
    protected static final Pattern flagHexPattern;
    static{
        sizePattern = compile(REG_SPK_SIZE);
        sizeExprPattern = compile(REG_SPK_SIZE_EXPR);
        flagHexPattern = compile(REG_SPK_FLAG_HEX);
    }

    public static final class MetaData{
        protected int offset;
        protected int size;
        protected int position;
        protected int deviation;
        protected byte[] bytes;

        public int getOffset(){
            return offset;
        }

        public void setOffset(int offset){
            this.offset = offset;
        }

        public int getSize(){
            return size;
        }

        public void setSize(int size){
            this.size = size;
        }

        public int getPosition(){
            return position;
        }

        public void setPosition(int position){
            this.position = position;
        }

        public int getDeviation(){
            return deviation;
        }

        public void setDeviation(int deviation){
            this.deviation = deviation;
        }

        public byte[] getBytes(){
            return bytes;
        }

        public void setBytes(byte[] bytes){
            this.bytes = bytes;
        }
    }

    @Override
    public SPKHeader trim(){
        headerFlag = headerFlag.trim();
        headerSize = headerSize.trim();
        fileStartPosExpr = fileStartPosExpr.trim();
        fileSizeExpr = fileSizeExpr.trim();
        return this;
    }

    @Override
    public boolean validate(){
        IValue<Boolean> value = new SingleValue<>(true);
        if(nonEmpty(headerSize)){
            Matcher matcher = sizePattern.matcher(headerSize);
            if(!matcher.matches()){
                errorInfo = gsph(ERR_SPKH_EXPR_DESC,"headerSize");
                value.setValue(false);
            }else headerSizeData.size = Integer.parseInt(headerSize);
        }
        if(nonEmpty(headerFlag) && value.getValue()){
            Matcher matcher = flagHexPattern.matcher(headerFlag);
            if(matcher.matches()) headerFlagData.bytes = hexToBytes(matcher.group(1));
            else headerFlagData.bytes = convertParam(headerFlag,false).getBytes();
        }
        if(nonEmpty(fileSizeExpr) && value.getValue()) validateSizeExpr(value,fileSizeData,fileSizeExpr,"fileSizeExpr");
        if(nonEmpty(fileStartPosExpr) && value.getValue()) validateSizeExpr(value,fileStartPosData,fileStartPosExpr,"fileStartPosExpr");
        return value.getValue();
    }

    private void validateSizeExpr(IValue<Boolean> value, MetaData metaData, String expr, String field){
        Matcher matcher = sizeExprPattern.matcher(expr);
        if(matcher.matches()){
            metaData.offset = Integer.parseInt(matcher.group(1));
            String size = matcher.group(3);
            metaData.size = nonEmpty(size) ? Integer.parseInt(size) : 1;
        }else{
            errorInfo = gsph(ERR_SPKH_EXPR_DESC,field);
            value.setValue(false);
        }
    }

    public MetaData getSizeData(){
        return headerSizeData;
    }

    public MetaData getFlagData(){
        return headerFlagData;
    }

    public MetaData getFileStartPosData(){
        return fileStartPosData;
    }

    public MetaData getFileSizeData(){
        return fileSizeData;
    }

    protected String getHeaderSize(){
        return headerSize;
    }

    protected String getHeaderFlag(){
        return headerFlag;
    }

    protected String getFileStartPosExpr(){
        return fileStartPosExpr;
    }

    protected String getFileSizeExpr(){
        return fileSizeExpr;
    }
}