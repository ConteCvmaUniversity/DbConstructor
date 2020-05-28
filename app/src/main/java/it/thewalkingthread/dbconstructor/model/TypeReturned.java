package it.thewalkingthread.dbconstructor.model;




import org.json.JSONObject;

public class TypeReturned {
    int slot;
    JSONObject type;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public JSONObject getType() {
        return type;
    }

    public void setType(JSONObject type) {
        this.type = type;
    }
}
