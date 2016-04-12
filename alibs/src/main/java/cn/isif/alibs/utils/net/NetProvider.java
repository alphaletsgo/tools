package cn.isif.alibs.utils.net;

/**
 * Created by dell on 2016/4/12.
 */
public enum NetProvider {
    UNKNOWN("未知网络"), UNICOM("联通"), MOBILE("移动"), TELECOM("电信");
    private String type;

    private NetProvider(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
