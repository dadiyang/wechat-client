package com.github.dadiyang.openwx.api.media;

import lombok.Data;

/**
 * 媒体信息
 *
 * @author huangxuyang
 * @date 2019/1/1
 */
@Data
public class MediaInfo {
    private String mediaExt;
    private String mediaId;
    private String mediaMime;
    private String mediaMtime;
    private String mediaName;
    private String mediaPath;
    private int mediaSize;
}
