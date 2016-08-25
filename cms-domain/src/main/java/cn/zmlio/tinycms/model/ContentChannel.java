package cn.zmlio.tinycms.model;

import javax.persistence.*;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "cms_channel")
public class ContentChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer channelId;

    /**
     * 文章频道名称
     */
    @Column(name = "channel_name", length = 32, unique = true)
    private String channelName;

    /**
     * 文章频道代码
     */
    @Column(name = "channel_code", length = 32, unique = true)
    private String channelCode;


    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    @Override
    public String toString() {
        return "ContentChannel{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                ", channelCode='" + channelCode + '\'' +
                '}';
    }
}
