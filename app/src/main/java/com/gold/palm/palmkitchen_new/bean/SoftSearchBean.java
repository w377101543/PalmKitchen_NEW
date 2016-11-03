package com.gold.palm.palmkitchen_new.bean;

import java.util.List;

/**
 * Created by Wang on 2016/11/2.
 */

public class SoftSearchBean {

    /**
     * code : 0
     * msg : success
     * version : 4.01
     * timestamp : 1478073693000
     * data : {"top":{"count":4,"data":[{"id":"480","title":"小龙虾","image":"http://img.szzhangchu.com/1439713719675_3776918513.jpg","video":"http://video.szzhangchu.com/xiaolongxia.mp4"},{"id":"479","title":"虾仁","image":"http://img.szzhangchu.com/1439643619835_2842941638.jpg","video":"http://video.szzhangchu.com/xiaren.mp4"},{"id":"483","title":"河虾","image":"http://img.szzhangchu.com/1439715262634_1797907547.jpg","video":"http://video.szzhangchu.com/hexia.mp4"},{"id":"493","title":"基围虾","image":"http://img.szzhangchu.com/1439712380070_9942188343.jpg","video":"http://video.szzhangchu.com/jiweixia.mp4"}]},"data":[{"id":"3905","text":"马蹄虾球"},{"id":"15508","text":"出水芙蓉虾"},{"id":"2319","text":"尖椒虾皮"},{"id":"993","text":"琵琶虾仁"},{"id":"9363","text":"虾酱芋头"},{"id":"12067","text":"辣味虾皮"},{"id":"12088","text":"椒盐烤虾"},{"id":"330","text":"金丝虾球"},{"id":"13080","text":"红烧大虾"},{"id":"1647","text":"虾仁炒蛋"},{"id":"1533","text":"吉利虾"},{"id":"570","text":"香酥虾"},{"id":"8560","text":"元帅虾"},{"id":"10134","text":"孜然串烧虾"},{"id":"4092","text":"玉子虾仁"},{"id":"4495","text":"西施虾仁"},{"id":"400","text":"碧螺虾仁"},{"id":"1687","text":"虾米丝瓜"},{"id":"5029","text":"芙蓉虾球"},{"id":"12886","text":"虾仁豆腐羹"},{"id":"9180","text":"蒜香虾球"},{"id":"401","text":"草菇虾仁"},{"id":"5292","text":"虾米白菜"},{"id":"4167","text":"虾仁四季豆"},{"id":"13109","text":"绿茶虾仁"},{"id":"2406","text":"口味虾"},{"id":"701","text":"虾仁莴笋"},{"id":"14775","text":"炸海虾"},{"id":"7925","text":"虾仁炒豆芽"},{"id":"12795","text":"洋葱酱虾米"}]}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    /**
     * top : {"count":4,"data":[{"id":"480","title":"小龙虾","image":"http://img.szzhangchu.com/1439713719675_3776918513.jpg","video":"http://video.szzhangchu.com/xiaolongxia.mp4"},{"id":"479","title":"虾仁","image":"http://img.szzhangchu.com/1439643619835_2842941638.jpg","video":"http://video.szzhangchu.com/xiaren.mp4"},{"id":"483","title":"河虾","image":"http://img.szzhangchu.com/1439715262634_1797907547.jpg","video":"http://video.szzhangchu.com/hexia.mp4"},{"id":"493","title":"基围虾","image":"http://img.szzhangchu.com/1439712380070_9942188343.jpg","video":"http://video.szzhangchu.com/jiweixia.mp4"}]}
     * data : [{"id":"3905","text":"马蹄虾球"},{"id":"15508","text":"出水芙蓉虾"},{"id":"2319","text":"尖椒虾皮"},{"id":"993","text":"琵琶虾仁"},{"id":"9363","text":"虾酱芋头"},{"id":"12067","text":"辣味虾皮"},{"id":"12088","text":"椒盐烤虾"},{"id":"330","text":"金丝虾球"},{"id":"13080","text":"红烧大虾"},{"id":"1647","text":"虾仁炒蛋"},{"id":"1533","text":"吉利虾"},{"id":"570","text":"香酥虾"},{"id":"8560","text":"元帅虾"},{"id":"10134","text":"孜然串烧虾"},{"id":"4092","text":"玉子虾仁"},{"id":"4495","text":"西施虾仁"},{"id":"400","text":"碧螺虾仁"},{"id":"1687","text":"虾米丝瓜"},{"id":"5029","text":"芙蓉虾球"},{"id":"12886","text":"虾仁豆腐羹"},{"id":"9180","text":"蒜香虾球"},{"id":"401","text":"草菇虾仁"},{"id":"5292","text":"虾米白菜"},{"id":"4167","text":"虾仁四季豆"},{"id":"13109","text":"绿茶虾仁"},{"id":"2406","text":"口味虾"},{"id":"701","text":"虾仁莴笋"},{"id":"14775","text":"炸海虾"},{"id":"7925","text":"虾仁炒豆芽"},{"id":"12795","text":"洋葱酱虾米"}]
     */

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
        /**
         * count : 4
         * data : [{"id":"480","title":"小龙虾","image":"http://img.szzhangchu.com/1439713719675_3776918513.jpg","video":"http://video.szzhangchu.com/xiaolongxia.mp4"},{"id":"479","title":"虾仁","image":"http://img.szzhangchu.com/1439643619835_2842941638.jpg","video":"http://video.szzhangchu.com/xiaren.mp4"},{"id":"483","title":"河虾","image":"http://img.szzhangchu.com/1439715262634_1797907547.jpg","video":"http://video.szzhangchu.com/hexia.mp4"},{"id":"493","title":"基围虾","image":"http://img.szzhangchu.com/1439712380070_9942188343.jpg","video":"http://video.szzhangchu.com/jiweixia.mp4"}]
         */

        private TopBean top;
        /**
         * id : 3905
         * text : 马蹄虾球
         */

        private List<DataThird> data;

        public TopBean getTop() {
            return top;
        }

        public void setTop(TopBean top) {
            this.top = top;
        }

        public List<DataThird> getData() {
            return data;
        }

        public void setData(List<DataThird> data) {
            this.data = data;
        }

        public static class TopBean {
            private int count;
            /**
             * id : 480
             * title : 小龙虾
             * image : http://img.szzhangchu.com/1439713719675_3776918513.jpg
             * video : http://video.szzhangchu.com/xiaolongxia.mp4
             */

            private List<DataSecond> data;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<DataSecond> getData() {
                return data;
            }

            public void setData(List<DataSecond> data) {
                this.data = data;
            }

            public static class DataSecond {
                private String id;
                private String title;
                private String image;
                private String video;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getVideo() {
                    return video;
                }

                public void setVideo(String video) {
                    this.video = video;
                }
            }
        }

        public static class DataThird {
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
