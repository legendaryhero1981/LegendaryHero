package legend.game.kcd.entity.mod;

import static legend.util.ValueUtil.nonEmpty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import legend.game.kcd.intf.IMain;
import legend.intf.IValue;

@XmlRootElement(name = "Mod")
@XmlType(propOrder = {"mod","desc","order"})
public class Mod implements IMain,IValue<Mod>{
    @XmlElement
    @XmlID
    private String mod = S_EMPTY;
    @XmlElement
    private String desc = MOD_INGNORE_DESC;
    @XmlElement
    private String order = MOD_ORDER_INGNORE;

    @Override
    public boolean validate(){
        if(nonEmpty(mod)){
            if(!order.matches(REG_ORDER)) order = MOD_ORDER_INGNORE;
            if(MOD_MERGE.equalsIgnoreCase(mod)) order = MOD_ORDER_MERGE;
            else if(MOD_ORDER_MERGE.equals(order)) order = MOD_ORDER_CONFLICT;
            return true;
        }
        return false;
    }

    @Override
    public Mod trim(){
        mod = mod.trim();
        desc = desc.trim();
        order = order.trim();
        return this;
    }

    public String getMod(){
        return mod;
    }

    public void setMod(String mod){
        this.mod = mod;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public String getOrder(){
        return order;
    }

    public void setOrder(String order){
        this.order = order;
    }
}
