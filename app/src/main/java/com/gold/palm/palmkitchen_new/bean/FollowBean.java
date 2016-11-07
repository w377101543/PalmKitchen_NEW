package com.gold.palm.palmkitchen_new.bean;

import java.util.List;

/**
 * Created by Wang on 2016/11/6.
 */

public class FollowBean {
    private String code;
    private String msg;
    private long timestamp;
    private String version;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timetemp) {
        this.timestamp = timetemp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public DataFirst getData() {
        return data;
    }

    public void setData(DataFirst data) {
        this.data = data;
    }

    public class DataFirst{
        private int page;
        private int size;
        private int total;
        private int count;
        private List<DataSecond> data;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

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

        public class DataSecond{
            private String user_id;
            private String nick;
            private String head_img;
            private int istalent;
            private String id;
            private String image;
            private String video;
            private String description;
            private String content;
            private String agree_count;
            private String comment_count;
            private String create_time;
            private int belike;
            private long create_time_org;
            private String marrow_time;
            private String delete_time;
            private String share_url;
            private List<Topics> topics;
            private List<Comment> comment;
            private List<Like> like;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getHead_img() {
                return head_img;
            }

            public void setHead_img(String head_img) {
                this.head_img = head_img;
            }

            public int getIstalent() {
                return istalent;
            }

            public void setIstalent(int istalent) {
                this.istalent = istalent;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String img) {
                this.image = img;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAgree_count() {
                return agree_count;
            }

            public void setAgree_count(String agree_count) {
                this.agree_count = agree_count;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getBelike() {
                return belike;
            }

            public void setBelike(int belike) {
                this.belike = belike;
            }

            public long getCreate_time_org() {
                return create_time_org;
            }

            public void setCreate_time_org(long create_time_org) {
                this.create_time_org = create_time_org;
            }

            public String getMarrow_time() {
                return marrow_time;
            }

            public void setMarrow_time(String marrow_time) {
                this.marrow_time = marrow_time;
            }

            public String getDelete_time() {
                return delete_time;
            }

            public void setDelete_time(String delete_time) {
                this.delete_time = delete_time;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public List<Topics> getTopics() {
                return topics;
            }

            public void setTopics(List<Topics> topics) {
                this.topics = topics;
            }

            public List<Comment> getComment() {
                return comment;
            }

            public void setComment(List<Comment> comment) {
                this.comment = comment;
            }

            public List<Like> getLike() {
                return like;
            }

            public void setLike(List<Like> like) {
                this.like = like;
            }

            public class Topics{
                private String id;
                private String post_id;
                private String topic_id;
                private String topic_name;
                private int locx;
                private int locy;
                private int width;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPost_id() {
                    return post_id;
                }

                public void setPost_id(String post_id) {
                    this.post_id = post_id;
                }

                public String getTopic_id() {
                    return topic_id;
                }

                public void setTopic_id(String topic_id) {
                    this.topic_id = topic_id;
                }

                public String getTopic_name() {
                    return topic_name;
                }

                public void setTopic_name(String topic_name) {
                    this.topic_name = topic_name;
                }

                public int getLocx() {
                    return locx;
                }

                public void setLocx(int locx) {
                    this.locx = locx;
                }

                public int getLocy() {
                    return locy;
                }

                public void setLocy(int locy) {
                    this.locy = locy;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
            public class Comment{
                private String user_id;
                private String nick;
                private String head_img;
                private int istalent;
                private String id;
                private String content;
                private String parent_id;
                private List<Parent> parents;

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getHead_img() {
                    return head_img;
                }

                public void setHead_img(String head_img) {
                    this.head_img = head_img;
                }

                public int getIstalent() {
                    return istalent;
                }

                public void setIstalent(int istalent) {
                    this.istalent = istalent;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getParent_id() {
                    return parent_id;
                }

                public void setParent_id(String parent_id) {
                    this.parent_id = parent_id;
                }

                public List<Parent> getParents() {
                    return parents;
                }

                public void setParents(List<Parent> parents) {
                    this.parents = parents;
                }

                public class Parent{
                    private String user_id;
                    private String nick;
                    private String head_img;
                    private int istalent;
                    private String id;
                    private String content;
                    private int parent_id;

                    public int getParent_id() {
                        return parent_id;
                    }

                    public void setParent_id(int parent_id) {
                        this.parent_id = parent_id;
                    }

                    public String getUser_id() {
                        return user_id;
                    }

                    public void setUser_id(String user_id) {
                        this.user_id = user_id;
                    }

                    public String getNick() {
                        return nick;
                    }

                    public void setNick(String nick) {
                        this.nick = nick;
                    }

                    public String getHead_img() {
                        return head_img;
                    }

                    public void setHead_img(String head_img) {
                        this.head_img = head_img;
                    }

                    public int getIstalent() {
                        return istalent;
                    }

                    public void setIstalent(int istalent) {
                        this.istalent = istalent;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getContent() {
                        return content;
                    }

                    public void setContent(String content) {
                        this.content = content;
                    }
                }
            }
            public class Like{
                private String user_id;
                private String nick;
                private String head_img;
                private int istalent;
                private String id;

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getHead_img() {
                    return head_img;
                }

                public void setHead_img(String head_img) {
                    this.head_img = head_img;
                }

                public int getIstalent() {
                    return istalent;
                }

                public void setIstalent(int istalent) {
                    this.istalent = istalent;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }
    }
}
