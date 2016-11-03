package com.gold.palm.palmkitchen_new.bean;

import java.util.List;

/**
 * Created by Wang on 2016/11/3.
 */

public class HotSearchBean {

    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1478162350000
     * data : {"data":[{"id":"169","text":"萝卜"},{"id":"273","text":"牛"},{"id":"207","text":"排骨"},{"id":"182","text":"鸡翅"},{"id":"192","text":"饼"}]}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    private DataOne data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public DataOne getData() {
        return data;
    }

    public void setData(DataOne data) {
        this.data = data;
    }

    public static class DataOne {
        /**
         * id : 169
         * text : 萝卜
         */

        private List<DataTwo> data;

        public List<DataTwo> getData() {
            return data;
        }

        public void setData(List<DataTwo> data) {
            this.data = data;
        }

        public static class DataTwo {
            private String id;
            private String text;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}
