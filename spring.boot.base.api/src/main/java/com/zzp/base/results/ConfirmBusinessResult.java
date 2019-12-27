package com.zzp.base.results;

import java.io.Serializable;

/**
 * @Description 业务确认result
 * @Author Garyzeng
 * @since 2019.12.27
 **/
public class ConfirmBusinessResult extends BaseResult implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 消息id
     */
    private String msgId;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 业务是否成功
     */
    private Boolean businessSuccess;

}
