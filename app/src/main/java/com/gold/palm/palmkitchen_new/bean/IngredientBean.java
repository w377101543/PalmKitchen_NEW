package com.gold.palm.palmkitchen_new.bean;

import java.util.List;

/**
 * Created by Wang on 2016/11/1.
 */

public class IngredientBean {
    private String code;
    private String msg;
    private String version;
    private long timestamp;
    private DataFirst data;
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
    public DataFirst getData() {
        return data;
    }
    public void setData(DataFirst data) {
        this.data = data;
    }
    public static class DataFirst {
        private int id;
        private String text;
        private String name;
        private List<DataSecond> data;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public List<DataSecond> getData() {
            return data;
        }
        public void setData(List<DataSecond> data) {
            this.data = data;
        }
        public static class DataSecond {
            private String id;
            private String text;
            private String image;
            private List<DataThird> data;
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
            public String getImage() {
                return image;
            }
            public void setImage(String image) {
                this.image = image;
            }
            public List<DataThird> getData() {
                return data;
            }
            public void setData(List<DataThird> data) {
                this.data = data;
            }
            public static class DataThird {
                private String id;
                private String text;
                private String image;
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
                public String getImage() {
                    return image;
                }
                public void setImage(String image) {
                    this.image = image;
                }
            }
        }
    }
}
